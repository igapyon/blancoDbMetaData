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
 * �f�[�^�x�[�X���烁�^�����擾����CSV�ɏo�͂��܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataMeta2Csv {
    /**
     * �f�[�^�x�[�X�̃��^�����擾���܂��B
     * 
     * @param argJdbcDriverName
     *            JDBC�h���C�o���B
     * @param argJdbcUrl
     *            JDBC�ڑ���URL�B
     * @param argJdbcUser
     *            JDBC�ڑ����[�U���B
     * @param argJdbcPassword
     *            JDBC�ڑ��p�X���[�h�B
     * @param argSchema
     *            �X�L�[�}���B���ɒl�������ꍇ�ɂ�null���w��B
     * @param argTable
     *            �e�[�u�����B���ɒl�������ꍇ�ɂ�null���w��B
     * @throws SQLException
     *             �e���O�����������ꍇ�B
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void process(final String argJdbcDriverName,
            final String argJdbcUrl, final String argJdbcUser,
            final String argJdbcPassword, final String argSchema,
            final String argTable, final File targetDir) throws SQLException,
            IOException, ClassNotFoundException {
        System.out.println("�f�[�^�x�[�X�ڑ�: �J�n: [" + argJdbcDriverName + "], ["
                + argJdbcUrl + "], [" + argJdbcUser + "]");
        final Connection conn = BlancoDbMetaDataUtil.connect(argJdbcDriverName,
                argJdbcUrl, argJdbcUser, argJdbcPassword);

        List<BlancoDbMetaDataTableStructure> listTables = null;

        try {
            // �����R�~�b�g��OFF�ɐݒ肵�܂��B
            conn.setAutoCommit(false);

            listTables = BlancoDbMetaDataTable.getTablesWithColumns(conn,
                    argSchema, argTable, new String[] { "TABLE" });
        } finally {
            // �㏈�������s���܂��B
            conn.rollback();
            conn.close();
            System.out.println("�f�[�^�x�[�X�ڑ�: �I��");
        }

        WriteCsvForMetaInfo.process(listTables, targetDir);

        WriteCsvForDataInput.process(listTables, targetDir);

        WriteCsvForMetaInfoAll.process(listTables, targetDir);
    }

    /**
     * �\�Ɋւ����ʓI�ȏ����o�͂��܂��B
     * 
     * @param tableStructure
     * @param writer
     * @throws IOException
     */
    public static void writeTableInfo(
            final BlancoDbMetaDataTableStructure tableStructure,
            final BufferedWriter writer) throws IOException {
        writer.write("�\��,�^�C�v,�J�^���O,�X�L�[�},���l");
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
     * ���ڂ̌^�����o�͂��܂��B
     * 
     * @param columnStructure
     * @param writer
     * @throws IOException
     */
    public static void writeColumnTypeName(
            final BlancoDbMetaDataColumnStructure columnStructure,
            final BufferedWriter writer) throws IOException {
        writer.write(columnStructure.getTypeName());

        // �^�ɂ���� �T�C�Y�\����؂�ւ��܂��B
        if (columnStructure.getColumnSize() < 0) {
            // �T�C�Y��0��菬�����ꍇ�ɂ́A�T�C�Y�͕\�����܂���B
            // PostgreSQL�̏ꍇ�ɁA-1���߂�d�l�ł����B
        } else {
            switch (columnStructure.getDataType()) {
            case Types.NUMERIC:
            case Types.DECIMAL:
                // �����T�C�Y���܂߂ĕ\�����܂��B
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
                // �T�C�Y�Ɋւ���\���ɂ��ẮA�����o�͂��܂���B
                break;
            default:
                writer.write(" (" + columnStructure.getColumnSize() + ")");
                break;
            }
        }
    }
}
