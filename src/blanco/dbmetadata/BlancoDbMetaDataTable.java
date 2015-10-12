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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import blanco.commons.util.BlancoStringUtil;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataTableStructure;

/**
 * �f�[�^�x�[�X���烁�^�����擾���郆�[�e�B���e�B�B
 * 
 * �\�Ɋւ��鏈�����܂܂�܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataTable {
    private static final boolean IS_REPORT_COLUMN_NOT_FOUND = false;

    /**
     * �f�[�^�x�[�X��̑S�Ă̕\�ɂ��āA���ځE�v���C�}���L�[�Ȃǂ̏��t�Ŏ擾���܂��B
     * 
     * @param conn
     *            �f�[�^�x�[�X�R�l�N�V�����B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTable
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTypes
     *            �擾�����ނ̈ꗗ�Bnull�Ȃ�S�āBnew String[] { "TABLE" }�̂悤�Ɏw��B
     * @return �\���̈ꗗ�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataTableStructure> getTablesWithColumns(
            final Connection conn, final String argSchema,
            final String argTable, final String[] argTypes) throws SQLException {
        final DatabaseMetaData metadata = conn.getMetaData();

        // �\�����擾���܂��B
        final List<BlancoDbMetaDataTableStructure> listTables = BlancoDbMetaDataTable
                .getTables(metadata, argSchema, argTable, argTypes);

        boolean isImportedKeysAvailable = true;
        boolean isExportedKeysAvailable = true;
        boolean isCrossReferenceKeysAvailable = true;

        // �\�ɂ܂��S�Ẵ��^�����擾���܂��B
        for (int indexTable = 0; indexTable < listTables.size(); indexTable++) {
            final BlancoDbMetaDataTableStructure tableStructure = listTables
                    .get(indexTable);

            tableStructure.setColumns(BlancoDbMetaDataTable.getColumns(
                    metadata, tableStructure.getCatalog(), argSchema,
                    tableStructure.getName()));

            tableStructure.setPrimaryKeys(BlancoDbMetaDataTable.getPrimaryKeys(
                    metadata, tableStructure.getCatalog(), argSchema,
                    tableStructure.getName()));

            try {
                tableStructure.setImportedKeys(BlancoDbMetaDataTable
                        .getImportedKeys(metadata, tableStructure.getCatalog(),
                                argSchema, tableStructure.getName()));
            } catch (SQLException ex) {
                if (isImportedKeysAvailable) {
                    isImportedKeysAvailable = false;
                    System.out.println("�C���|�[�g�L�[�擾���ɗ�O������:" + ex.toString());
                }
            }

            try {
                tableStructure.setExportedKeys(BlancoDbMetaDataTable
                        .getExportedKeys(metadata, tableStructure.getCatalog(),
                                argSchema, tableStructure.getName()));
            } catch (SQLException ex) {
                if (isExportedKeysAvailable) {
                    isExportedKeysAvailable = false;
                    System.out.println("�G�N�X�|�[�g�L�[�擾���ɗ�O������:" + ex.toString());
                }
            }

            try {
                tableStructure.setCrossReferenceKeys(BlancoDbMetaDataTable
                        .getCrossReference(metadata, tableStructure
                                .getCatalog(), argSchema, tableStructure
                                .getName(), null, null, null));
            } catch (SQLException ex) {
                if (isCrossReferenceKeysAvailable) {
                    isCrossReferenceKeysAvailable = false;
                    System.out.println("�N���X�Q�Ǝ擾���ɗ�O������:" + ex.toString());
                }
            }
        }

        return listTables;
    }

    private static String getStringSafety(final ResultSet resultSet,
            final String fieldName) {
        try {
            return resultSet.getString(fieldName);
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSet���當������擾����ۂɗ�O�������B:"
                        + ex.toString());
            }
            return null;
        }
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̈ꗗ�����擾���܂��B
     * 
     * �\���� $ ���܂܂����̂͏������X�L�b�v���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTable
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTypes
     *            �擾�����ނ̈ꗗ�Bnull�Ȃ�S�āBnew String[] { "TABLE" }�̂悤�Ɏw��B
     * @return �\���̈ꗗ�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataTableStructure> getTables(
            final DatabaseMetaData metadata, final String argSchema,
            final String argTable, final String[] argTypes) throws SQLException {
        final List<BlancoDbMetaDataTableStructure> result = new ArrayList<BlancoDbMetaDataTableStructure>();

        final ResultSet resultSet = metadata.getTables(null, argSchema,
                argTable, argTypes);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataTableStructure tableStructure = new BlancoDbMetaDataTableStructure();

                tableStructure.setName(resultSet.getString("TABLE_NAME"));

                // if (tableStructure.getName().toLowerCase().startsWith("sys"))
                // {
                // continue;
                // }

                // System.out.println("�\[" + tableStructure.getName() + "]������");

                tableStructure.setType(resultSet.getString("TABLE_TYPE"));

                tableStructure.setCatalog(getStringSafety(resultSet,
                        "TABLE_CAT"));
                tableStructure.setSchema(getStringSafety(resultSet,
                        "TABLE_SCHEM"));
                tableStructure
                        .setRemarks(getStringSafety(resultSet, "REMARKS"));

                if (BlancoStringUtil.null2Blank(tableStructure.getName())
                        .length() == 0) {
                    // �\�����������̂͏������X�L�b�v���܂��B
                    continue;
                }
                if (BlancoStringUtil.null2Blank(tableStructure.getType())
                        .length() == 0) {
                    // �\�^�C�v���������̂͏������X�L�b�v���܂��B
                    continue;
                }
                if (tableStructure.getName().indexOf('$') >= 0) {
                    // �\���� $ ���܂܂�Ă�����̂͏������X�L�b�v���܂��B
                    continue;
                }

                result.add(tableStructure);
            }
        } finally {
            resultSet.close();
        }

        return result;
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̃J�����ꗗ�����擾���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @return ���ڂ̈ꗗ���߂�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataColumnStructure> getColumns(
            final DatabaseMetaData metadata, final String argCat,
            final String argSchema, final String argTableName)
            throws SQLException {
        final List<BlancoDbMetaDataColumnStructure> result = new ArrayList<BlancoDbMetaDataColumnStructure>();

        final ResultSet resultSet = metadata.getColumns(argCat, argSchema,
                argTableName, null);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataColumnStructure columnStructure = new BlancoDbMetaDataColumnStructure();
                columnStructure.setName(resultSet.getString("COLUMN_NAME"));
                columnStructure.setDataType(resultSet.getShort("DATA_TYPE"));
                columnStructure.setTypeName(getStringSafety(resultSet,
                        "TYPE_NAME"));
                if (columnStructure.getDataType() == Types.OTHER) {
                    BlancoDbMetaDataUtil.mapTypeName2DataType(columnStructure);
                }

                columnStructure.setDataTypeDisplayName(BlancoDbMetaDataUtil
                        .convertJdbcDataTypeToString(columnStructure
                                .getDataType()));
                try {
                    columnStructure.setColumnSize(resultSet
                            .getInt("COLUMN_SIZE"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                columnStructure.setBufferLength(getStringSafety(resultSet,
                        "BUFFER_LENGTH"));
                try {
                    columnStructure.setDecimalDigits(resultSet
                            .getInt("DECIMAL_DIGITS"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setNumPrecRadix(resultSet
                            .getInt("NUM_PREC_RADIX"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setNullable(resultSet.getInt("NULLABLE"));
                    columnStructure.setNullableDisplayName(BlancoDbMetaDataUtil
                            .convertJdbcNullableToString(columnStructure
                                    .getNullable()));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }

                columnStructure
                        .setRemarks(getStringSafety(resultSet, "REMARKS"));
                columnStructure.setColumnDef(getStringSafety(resultSet,
                        "COLUMN_DEF"));

                try {
                    columnStructure.setSqlDataType(resultSet
                            .getInt("SQL_DATA_TYPE"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setSqlDatetimeSub(resultSet
                            .getInt("SQL_DATETIME_SUB"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setCharOctetLength(resultSet
                            .getInt("CHAR_OCTET_LENGTH"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setOrdinalPosition(resultSet
                            .getInt("ORDINAL_POSITION"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����int���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }
                columnStructure.setIsNullable(getStringSafety(resultSet,
                        "IS_NULLABLE"));
                columnStructure.setScopeCatlog(getStringSafety(resultSet,
                        "SCOPE_CATLOG"));
                columnStructure.setScopeSchema(getStringSafety(resultSet,
                        "SCOPE_SCHEMA"));
                columnStructure.setScopeTable(getStringSafety(resultSet,
                        "SCOPE_TABLE"));
                try {
                    columnStructure.setSourceDataType(resultSet
                            .getShort("SOURCE_DATA_TYPE"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSet����short���擾����ۂɗ�O�������B:"
                                + ex.toString());
                    }
                }

                result.add(columnStructure);
            }
        } finally {
            resultSet.close();
        }
        return result;
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̃v���C�}���L�[�����擾���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @return �v���C�}���L�[�̈ꗗ���߂�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataKeyStructure> getPrimaryKeys(
            final DatabaseMetaData metadata, final String argCat,
            final String argSchema, final String argTableName)
            throws SQLException {
        final List<BlancoDbMetaDataKeyStructure> result = new ArrayList<BlancoDbMetaDataKeyStructure>();

        final ResultSet resultSet = metadata.getPrimaryKeys(argCat, argSchema,
                argTableName);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataKeyStructure primaryKeyStructure = new BlancoDbMetaDataKeyStructure();

                primaryKeyStructure.setPkcolumnName(resultSet
                        .getString("COLUMN_NAME"));
                primaryKeyStructure.setKeySeq(resultSet.getShort("KEY_SEQ"));
                primaryKeyStructure.setPkName(getStringSafety(resultSet,
                        "PK_NAME"));

                result.add(primaryKeyStructure);
            }
        } finally {
            resultSet.close();
        }
        return result;
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̊O���L�[����Q�Ƃ����L�[��Ɋւ�������擾���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @return ��L�[��̈ꗗ���߂�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataKeyStructure> getImportedKeys(
            final DatabaseMetaData metadata, final String argCat,
            final String argSchema, final String argTableName)
            throws SQLException {
        final List<BlancoDbMetaDataKeyStructure> result = new ArrayList<BlancoDbMetaDataKeyStructure>();

        final ResultSet resultSet = metadata.getImportedKeys(argCat, argSchema,
                argTableName);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataKeyStructure importedKeyStructure = getKeyStructureFromResultSet(resultSet);
                result.add(importedKeyStructure);
            }
        } finally {
            resultSet.close();
        }
        return result;
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̊O���L�[����Q�Ƃ����L�[��Ɋւ�������擾���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @return ��L�[��̈ꗗ���߂�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataKeyStructure> getExportedKeys(
            final DatabaseMetaData metadata, final String argCat,
            final String argSchema, final String argTableName)
            throws SQLException {
        final List<BlancoDbMetaDataKeyStructure> result = new ArrayList<BlancoDbMetaDataKeyStructure>();

        final ResultSet resultSet = metadata.getExportedKeys(argCat, argSchema,
                argTableName);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataKeyStructure exportedKeyStructure = getKeyStructureFromResultSet(resultSet);
                result.add(exportedKeyStructure);
            }
        } finally {
            resultSet.close();
        }
        return result;
    }

    /**
     * �f�[�^�x�[�X���^��񂩂�\�̊O���L�[��Ɋւ�������擾���܂��B
     * 
     * @param metadata
     *            �f�[�^�x�[�X���^�f�[�^�B
     * @param argPrimaryCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argPrimarySchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argPrimaryTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argForeignCat
     *            �J�^���O���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argForeignSchema
     *            �X�L�[�}���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @param argForeignTableName
     *            �\���B�w�肵�Ȃ��ꍇ�ɂ�null��^����B
     * @return ��L�[��̈ꗗ���߂�B
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataKeyStructure> getCrossReference(
            final DatabaseMetaData metadata, final String argPrimaryCat,
            final String argPrimarySchema, final String argPrimaryTableName,
            final String argForeignCat, final String argForeignSchema,
            final String argForeignTableName) throws SQLException {
        final List<BlancoDbMetaDataKeyStructure> result = new ArrayList<BlancoDbMetaDataKeyStructure>();

        final ResultSet resultSet = metadata.getCrossReference(argPrimaryCat,
                argPrimarySchema, argPrimaryTableName, argForeignCat,
                argForeignSchema, argForeignTableName);
        try {
            for (; resultSet.next();) {
                final BlancoDbMetaDataKeyStructure exportedKeyStructure = getKeyStructureFromResultSet(resultSet);
                result.add(exportedKeyStructure);
            }
        } finally {
            resultSet.close();
        }
        return result;
    }

    /**
     * ResultSet����L�[�\�����擾���܂��B
     * 
     * getImportedKeys, getExportedKeys�Ȃǂ�ResultSet������ł��邱�Ƃ���A��������ʉ����Ă��܂��B
     * 
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private static BlancoDbMetaDataKeyStructure getKeyStructureFromResultSet(
            final ResultSet resultSet) throws SQLException {
        final BlancoDbMetaDataKeyStructure keyStructure = new BlancoDbMetaDataKeyStructure();

        keyStructure.setPktableCat(resultSet.getString("PKTABLE_CAT"));
        keyStructure.setPktableSchem(resultSet.getString("PKTABLE_SCHEM"));
        keyStructure.setPktableName(resultSet.getString("PKTABLE_NAME"));
        keyStructure.setPkcolumnName(resultSet.getString("PKCOLUMN_NAME"));
        keyStructure.setFktableCat(resultSet.getString("FKTABLE_CAT"));
        keyStructure.setFktableSchem(resultSet.getString("FKTABLE_SCHEM"));
        keyStructure.setFktableName(resultSet.getString("FKTABLE_NAME"));
        keyStructure.setFkcolumnName(resultSet.getString("FKCOLUMN_NAME"));
        keyStructure.setKeySeq(resultSet.getShort("KEY_SEQ"));

        try {
            keyStructure.setUpdateRule(resultSet.getShort("UPDATE_RULE"));
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSet����short���擾����ۂɗ�O�������B:"
                        + ex.toString());
            }
        }
        try {
            keyStructure.setDeleteRule(resultSet.getShort("DELETE_RULE"));
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSet����short���擾����ۂɗ�O�������B:"
                        + ex.toString());
            }
        }
        keyStructure.setFkName(getStringSafety(resultSet, "FK_NAME"));
        keyStructure.setPkName(getStringSafety(resultSet, "PK_NAME"));
        try {
            keyStructure.setDeferrability(resultSet.getShort("DEFERRABILITY"));
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSet����short���擾����ۂɗ�O�������B:"
                        + ex.toString());
            }
        }

        return keyStructure;
    }
}
