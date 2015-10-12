/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.dbmetadata.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import blanco.commons.util.BlancoStringUtil;
import blanco.dbmetadata.BlancoDbMetaDataTable;
import blanco.dbmetadata.BlancoDbMetaDataUtil;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataTableStructure;

/**
 * データベースからメタ情報を取得してCSVに出力します。
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataMeta2Csv {
    /**
     * データベースのメタ情報を取得します。
     * 
     * @param argJdbcDriverName
     *            JDBCドライバ名。
     * @param argJdbcUrl
     *            JDBC接続先URL。
     * @param argJdbcUser
     *            JDBC接続ユーザ名。
     * @param argJdbcPassword
     *            JDBC接続パスワード。
     * @param argSchema
     *            スキーマ名。特に値が無い場合にはnullを指定。
     * @param argTable
     *            テーブル名。特に値が無い場合にはnullを指定。
     * @throws SQLException
     *             各種例外が発生した場合。
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void process(final String argJdbcDriverName,
            final String argJdbcUrl, final String argJdbcUser,
            final String argJdbcPassword, final String argSchema,
            final String argTable, final File targetDir) throws SQLException,
            IOException, ClassNotFoundException {
        System.out.println("データベース接続: 開始: [" + argJdbcDriverName + "], ["
                + argJdbcUrl + "], [" + argJdbcUser + "]");
        final Connection conn = BlancoDbMetaDataUtil.connect(argJdbcDriverName,
                argJdbcUrl, argJdbcUser, argJdbcPassword);

        List<BlancoDbMetaDataTableStructure> listTables = null;

        try {
            // 自動コミットをOFFに設定します。
            conn.setAutoCommit(false);

            listTables = BlancoDbMetaDataTable.getTablesWithColumns(conn,
                    argSchema, argTable, new String[] { "TABLE" });
        } finally {
            // 後処理を実行します。
            conn.rollback();
            conn.close();
            System.out.println("データベース接続: 終了");
        }

        WriteCsvForMetaInfo.process(listTables, targetDir);

        WriteCsvForDataInput.process(listTables, targetDir);

        WriteCsvForMetaInfoAll.process(listTables, targetDir);
    }

    /**
     * 表に関する一般的な情報を出力します。
     * 
     * @param tableStructure
     * @param writer
     * @throws IOException
     */
    public static void writeTableInfo(
            final BlancoDbMetaDataTableStructure tableStructure,
            final BufferedWriter writer) throws IOException {
        writer.write("表名,タイプ,カタログ,スキーマ,備考");
        writer.newLine();
        writer.write(tableStructure.getName());
        writer.write(",");
        writer.write(BlancoStringUtil.null2Blank(tableStructure.getType()));
        writer.write(",");
        writer.write(BlancoStringUtil.null2Blank(tableStructure.getCatalog()));
        writer.write(",");
        writer.write(BlancoStringUtil.null2Blank(tableStructure.getSchema()));
        writer.write(",");
        writer.write(BlancoStringUtil.null2Blank(tableStructure.getRemarks()));
        writer.newLine();
    }

    /**
     * 項目の型名を出力します。
     * 
     * @param columnStructure
     * @param writer
     * @throws IOException
     */
    public static void writeColumnTypeName(
            final BlancoDbMetaDataColumnStructure columnStructure,
            final BufferedWriter writer) throws IOException {
        writer.write(columnStructure.getTypeName());

        // 型によって サイズ表現を切り替えます。
        if (columnStructure.getColumnSize() < 0) {
            // サイズが0より小さい場合には、サイズは表示しません。
            // PostgreSQLの場合に、-1が戻る仕様でした。
        } else {
            switch (columnStructure.getDataType()) {
            case Types.NUMERIC:
            case Types.DECIMAL:
                // 小数サイズを含めて表示します。
                writer.write(" (" + columnStructure.getColumnSize() + "."
                        + columnStructure.getDecimalDigits() + ")");
                break;
            case Types.BIT:
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
            case Types.FLOAT:
            case Types.REAL:
            case Types.DOUBLE:
            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
            case Types.NULL:
            case Types.BOOLEAN:
                // サイズに関する表示については、何も出力しません。
                break;
            default:
                writer.write(" (" + columnStructure.getColumnSize() + ")");
                break;
            }
        }
    }
}
