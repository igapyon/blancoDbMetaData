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
 * �f�[�^�x�[�X��SQL�𔭍s���A���^�����擾���郆�[�e�B���e�B�B
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataSql {
    /**
     * �f�[�^�x�[�X��SQL�𔭍s���A���^�����擾���܂��B
     * 
     * ���i��SQL���`�F�b�N�͎��s����܂���B�����܂ł����^���擾�݂̂����{����܂��B
     * 
     * @throws SQLException
     *             SQL���ɕs�����������ꍇ�Ȃǂɔ������܂��B
     */
    public static List<BlancoDbMetaDataColumnStructure> getResultSetMetaData(
            final Connection conn, final String argSql) throws SQLException {
        // SQL Server 2005 �ł́Astmt.executeQuery()
        // �����s���Ȃ��ꍇ�ɂ́ASQL���̓p�����[�^�̃Z�b�g������s�v�ł����B
        // �����āAstmt.executeQuery() �����s���Ȃ��Ƃ����^���͎擾�ł��܂����B

        return getResultSetMetaData(conn, argSql, null);
    }

    /**
     * �f�[�^�x�[�X��SQL�𔭍s���A���^�����擾���܂��B
     * 
     * SQL���𔭍s���Č��ʃZ�b�g���擾���܂��BargSqlInParameter�ɒl���Z�b�g����Ă���ꍇ�ɂ́ASQL���̎����ł����s���܂��B
     * 
     * @param conn
     *            �f�[�^�x�[�X�ڑ��B
     * @param argSql
     *            SQL���B
     * @param argSqlInParameter
     *            SQL���̓p�����[�^�Bnull��^����ƁA���i��SQL�`�F�b�N�̓X�L�b�v���ꂽ���s����܂���B
     * @throws SQLException
     *             SQL���ɕs�����������ꍇ�Ȃǂɔ������܂��B
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
                // System.out.println("SQL����SQL���̓p�����[�^���Z�b�g���������Ŏ��ۂɎ��s���Ă݂܂�:["
                // + argSql + "]");

                bindSqlInParameter(stmt, argSqlInParameter);

                resultSet = stmt.executeQuery();
                // SQL���s����O�́A���̂܂܃X���[���܂��B
            }

            ResultSetMetaData resultSetMetaData = null;
            if (resultSet != null) {
                // ���ʃZ�b�g������̂ł���΁A����𗘗p�B
                // �Ȃ��Ȃ�JDBC�h���C�o�ɂ���ẮA���ʃZ�b�g���擾���Ȃ���stmt����擾����p�X�����p�ł��Ȃ�����ł��B
                resultSetMetaData = resultSet.getMetaData();
            } else {
                resultSetMetaData = stmt.getMetaData();
            }

            if (resultSetMetaData == null) {
                throw new IllegalArgumentException(
                        "���^���擾: ���ʃZ�b�g���^���̎擾�Ɏ��s���܂����BSQL���s�I�v�V������iterator�ɕύX���Ă��������B");
            }

            final int columnCount = resultSetMetaData.getColumnCount();
            for (int indexColumn = 1; indexColumn <= columnCount; indexColumn++) {
                final BlancoDbMetaDataColumnStructure columnStructure = parseResultSetMetaData(
                        resultSetMetaData, indexColumn);
                result.add(columnStructure);
            }
        } finally {
            if (resultSet != null) {
                // ���ʃZ�b�g���^�f�[�^���擾���Ă���N���[�Y����悤�ɂ��܂��B
                // �������Ȃ��� PostgreSQL 8.1�ł̓��^�f�[�^�擾���o���܂���ł����B
                resultSet.close();
                resultSet = null;
            }
            stmt.close();
        }

        return result;
    }

    /**
     * ResultSetMetaData�����\���̂ɓW�J���܂��B
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
        // 2012.01.06 �ȑO�� getColumnName �ł��������AMySQL 5.1 �Ή��̂��߂ɂ����ύX�B
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

        // SQL���s���ɂ̂ݎ擾�\�ȍ��ځB
        columnStructure.setWritable(resultSetMetaData.isWritable(indexColumn));

        return columnStructure;
    }

    /**
     * SQL���̓p�����[�^���o�C���h���܂��B
     * 
     * @param stmt
     * @param argSqlInParameter
     * @throws SQLException
     * @throws IllegalArgumentException
     *             SQL���̓p�����[�^���s���ȏꍇ�Ȃǂɔ������܂��B
     */
    private static void bindSqlInParameter(final PreparedStatement stmt,
            final List<BlancoDbMetaDataColumnStructure> argSqlInParameter)
            throws SQLException {
        if (argSqlInParameter == null) {
            // �p�����[�^��null�̏ꍇ�ɂ́A�o�C���h����ׂ�SQL���̓p�����[�^���������̂Ɣ��f���܂��B
            return;
        }

        // SQL���̓p�����[�^���Z�b�g���܂��B
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
                // "0"�Ƃ��ė^���Ă��܂��BJDK1.5�΍�ł��B
                stmt.setBigDecimal(indexInParameter + 1, new BigDecimal("0"));
                break;
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
            case Types.NCHAR:
            case Types.NVARCHAR:
            case Types.LONGNVARCHAR:
                // SQL Server 2005��uniqueidentifier�ł́Anull��^����̂��œK�ł��B
                stmt.setString(indexInParameter + 1, null);
                break;
            case Types.DATE:
                // ���� TIMESTAMP�Ɠ��������������Ă��܂��B
            case Types.TIME:
                // ���� TIMESTAMP�Ɠ��������������Ă��܂��B
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
            case Types.ROWID:// ����������T�|�[�g�͈͊O�Ƀ}�b�v���܂��B
            default:
                throw new IllegalArgumentException(
                        "BlancoDbMetaDataSql: SQL���̓p�����[�^["
                                + columnStructure.getName()
                                + "]("
                                + BlancoDbMetaDataUtil
                                        .convertJdbcDataTypeToString(columnStructure
                                                .getDataType())
                                + ")�̃o�C���h: �����ł��Ȃ�SQL���̓p�����[�^�̌^("
                                + columnStructure.getDataType()
                                + "/"
                                + BlancoDbMetaDataUtil
                                        .convertJdbcDataTypeToString(columnStructure
                                                .getDataType()) + ")���w�肳��܂����B");
            }
        }
    }
}
