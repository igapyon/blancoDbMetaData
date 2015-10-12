/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.dbmetadata;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;

/**
 * データベースにSQLを発行し、メタ情報を取得するユーティリティ。
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataSql {
    /**
     * データベースにSQLを発行し、メタ情報を取得します。
     * 
     * 厳格なSQL文チェックは実行されません。あくまでもメタ情報取得のみが実施されます。
     * 
     * @throws SQLException
     *             SQL文に不備があった場合などに発生します。
     */
    public static List<BlancoDbMetaDataColumnStructure> getResultSetMetaData(
            final Connection conn, final String argSql) throws SQLException {
        // SQL Server 2005 では、stmt.executeQuery()
        // を実行しない場合には、SQL入力パラメータのセットすらも不要でした。
        // そして、stmt.executeQuery() を実行しなくともメタ情報は取得できました。

        return getResultSetMetaData(conn, argSql, null);
    }

    /**
     * データベースにSQLを発行し、メタ情報を取得します。
     * 
     * SQL文を発行して結果セットを取得します。argSqlInParameterに値がセットされている場合には、SQL文の試し打ちも行います。
     * 
     * @param conn
     *            データベース接続。
     * @param argSql
     *            SQL文。
     * @param argSqlInParameter
     *            SQL入力パラメータ。nullを与えると、厳格なSQLチェックはスキップされた実行されません。
     * @throws SQLException
     *             SQL文に不備があった場合などに発生します。
     */
    public static List<BlancoDbMetaDataColumnStructure> getResultSetMetaData(
            final Connection conn, final String argSql,
            final List<BlancoDbMetaDataColumnStructure> argSqlInParameter)
            throws SQLException {
        final List<BlancoDbMetaDataColumnStructure> result = new ArrayList<BlancoDbMetaDataColumnStructure>();

        final PreparedStatement stmt = conn.prepareStatement(argSql);

        ResultSet resultSet = null;
        try {
            if (argSqlInParameter != null) {
                // System.out.println("SQL文にSQL入力パラメータをセットしたうえで実際に実行してみます:["
                // + argSql + "]");

                bindSqlInParameter(stmt, argSqlInParameter);

                resultSet = stmt.executeQuery();
                // SQL実行時例外は、そのままスローします。
            }

            ResultSetMetaData resultSetMetaData = null;
            if (resultSet != null) {
                // 結果セットがあるのであれば、それを利用。
                // なぜならJDBCドライバによっては、結果セットを取得しないでstmtから取得するパスが利用できないからです。
                resultSetMetaData = resultSet.getMetaData();
            } else {
                resultSetMetaData = stmt.getMetaData();
            }

            if (resultSetMetaData == null) {
                throw new IllegalArgumentException(
                        "メタ情報取得: 結果セットメタ情報の取得に失敗しました。SQL実行オプションをiteratorに変更してください。");
            }

            final int columnCount = resultSetMetaData.getColumnCount();
            for (int indexColumn = 1; indexColumn <= columnCount; indexColumn++) {
                final BlancoDbMetaDataColumnStructure columnStructure = parseResultSetMetaData(
                        resultSetMetaData, indexColumn);
                result.add(columnStructure);
            }
        } finally {
            if (resultSet != null) {
                // 結果セットメタデータを取得してからクローズするようにします。
                // そうしないと PostgreSQL 8.1ではメタデータ取得が出来ませんでした。
                resultSet.close();
                resultSet = null;
            }
            stmt.close();
        }

        return result;
    }

    /**
     * ResultSetMetaData情報を構造体に展開します。
     * 
     * @param resultSetMetaData
     * @param indexColumn
     * @return
     * @throws SQLException
     */
    private static BlancoDbMetaDataColumnStructure parseResultSetMetaData(
            final ResultSetMetaData resultSetMetaData, final int indexColumn)
            throws SQLException {
        final BlancoDbMetaDataColumnStructure columnStructure = new BlancoDbMetaDataColumnStructure();
        // 2012.01.06 以前は getColumnName であったが、MySQL 5.1 対応のためにこれを変更。
        columnStructure.setName(resultSetMetaData.getColumnLabel(indexColumn));
        columnStructure.setDataType(resultSetMetaData
                .getColumnType(indexColumn));
        columnStructure.setTypeName(resultSetMetaData
                .getColumnTypeName(indexColumn));
        if (columnStructure.getDataType() == Types.OTHER) {
            BlancoDbMetaDataUtil.mapTypeName2DataType(columnStructure);
        }

        columnStructure.setDataTypeDisplayName(BlancoDbMetaDataUtil
                .convertJdbcDataTypeToString(columnStructure.getDataType()));
        columnStructure.setColumnSize(resultSetMetaData
                .getPrecision(indexColumn));
        columnStructure.setDecimalDigits(resultSetMetaData
                .getScale(indexColumn));
        columnStructure.setNullable(resultSetMetaData.isNullable(indexColumn));
        columnStructure.setNullableDisplayName(BlancoDbMetaDataUtil
                .convertJdbcNullableToString(columnStructure.getNullable()));

        // SQL実行時にのみ取得可能な項目。
        columnStructure.setWritable(resultSetMetaData.isWritable(indexColumn));

        return columnStructure;
    }

    /**
     * SQL入力パラメータをバインドします。
     * 
     * @param stmt
     * @param argSqlInParameter
     * @throws SQLException
     * @throws IllegalArgumentException
     *             SQL入力パラメータが不正な場合などに発生します。
     */
    private static void bindSqlInParameter(final PreparedStatement stmt,
            final List<BlancoDbMetaDataColumnStructure> argSqlInParameter)
            throws SQLException {
        if (argSqlInParameter == null) {
            // パラメータがnullの場合には、バインドするべきSQL入力パラメータが無いものと判断します。
            return;
        }

        // SQL入力パラメータをセットします。
        for (int indexInParameter = 0; indexInParameter < argSqlInParameter
                .size(); indexInParameter++) {
            final BlancoDbMetaDataColumnStructure columnStructure = argSqlInParameter
                    .get(indexInParameter);

            switch (columnStructure.getDataType()) {
            case Types.BIT:
            case Types.BOOLEAN:
                stmt.setBoolean(indexInParameter + 1, false);
                break;
            case Types.TINYINT:
                stmt.setByte(indexInParameter + 1, (byte) 0x00);
                break;
            case Types.SMALLINT:
                stmt.setShort(indexInParameter + 1, (short) 0);
                break;
            case Types.INTEGER:
                stmt.setInt(indexInParameter + 1, 0);
                break;
            case Types.BIGINT:
                stmt.setLong(indexInParameter + 1, 0);
                break;
            case Types.REAL:
                stmt.setFloat(indexInParameter + 1, 0);
                break;
            case Types.FLOAT:
            case Types.DOUBLE:
                stmt.setDouble(indexInParameter + 1, 0);
                break;
            case Types.NUMERIC:
            case Types.DECIMAL:
                // "0"として与えています。JDK1.5対策です。
                stmt.setBigDecimal(indexInParameter + 1, new BigDecimal("0"));
                break;
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
            case Types.NCHAR:
            case Types.NVARCHAR:
            case Types.LONGNVARCHAR:
                // SQL Server 2005のuniqueidentifierでは、nullを与えるのが最適です。
                stmt.setString(indexInParameter + 1, null);
                break;
            case Types.DATE:
                // 仮で TIMESTAMPと同じ動きをさせています。
            case Types.TIME:
                // 仮で TIMESTAMPと同じ動きをさせています。
            case Types.TIMESTAMP:
                stmt.setTimestamp(indexInParameter + 1, new Timestamp(0));
                break;
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
            case Types.BLOB: {
                byte[] dummy = "0".getBytes();
                stmt.setBinaryStream(indexInParameter + 1,
                        new ByteArrayInputStream(dummy), dummy.length);
            }
                break;
            case Types.JAVA_OBJECT:
                stmt.setObject(indexInParameter + 1, new Object());
                break;
            case Types.CLOB: {
                char[] dummy = new char[1];
                dummy[0] = '0';
                stmt.setCharacterStream(indexInParameter + 1,
                        new CharArrayReader(dummy), dummy.length);
            }
                break;
            case Types.DISTINCT:
            case Types.STRUCT:
            case Types.ARRAY:
            case Types.NULL:
            case Types.OTHER:
            case Types.REF:
            case Types.DATALINK:
            case Types.ROWID:// さしあたりサポート範囲外にマップします。
            default:
                throw new IllegalArgumentException(
                        "BlancoDbMetaDataSql: SQL入力パラメータ["
                                + columnStructure.getName()
                                + "]("
                                + BlancoDbMetaDataUtil
                                        .convertJdbcDataTypeToString(columnStructure
                                                .getDataType())
                                + ")のバインド: 処理できないSQL入力パラメータの型("
                                + columnStructure.getDataType()
                                + "/"
                                + BlancoDbMetaDataUtil
                                        .convertJdbcDataTypeToString(columnStructure
                                                .getDataType()) + ")が指定されました。");
            }
        }
    }
}
