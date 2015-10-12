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
 * データベースからメタ情報を取得するユーティリティ。
 * 
 * 表に関する処理が含まれます。
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataTable {
    private static final boolean IS_REPORT_COLUMN_NOT_FOUND = false;

    /**
     * データベース上の全ての表について、項目・プライマリキーなどの情報付で取得します。
     * 
     * @param conn
     *            データベースコネクション。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTable
     *            表名。指定しない場合にはnullを与える。
     * @param argTypes
     *            取得する種類の一覧。nullなら全て。new String[] { "TABLE" }のように指定。
     * @return 表情報の一覧。
     * @throws SQLException
     */
    public static List<BlancoDbMetaDataTableStructure> getTablesWithColumns(
            final Connection conn, final String argSchema,
            final String argTable, final String[] argTypes) throws SQLException {
        final DatabaseMetaData metadata = conn.getMetaData();

        // 表情報を取得します。
        final List<BlancoDbMetaDataTableStructure> listTables = BlancoDbMetaDataTable
                .getTables(metadata, argSchema, argTable, argTypes);

        boolean isImportedKeysAvailable = true;
        boolean isExportedKeysAvailable = true;
        boolean isCrossReferenceKeysAvailable = true;

        // 表にまつわる全てのメタ情報を取得します。
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
                    System.out.println("インポートキー取得時に例外が発生:" + ex.toString());
                }
            }

            try {
                tableStructure.setExportedKeys(BlancoDbMetaDataTable
                        .getExportedKeys(metadata, tableStructure.getCatalog(),
                                argSchema, tableStructure.getName()));
            } catch (SQLException ex) {
                if (isExportedKeysAvailable) {
                    isExportedKeysAvailable = false;
                    System.out.println("エクスポートキー取得時に例外が発生:" + ex.toString());
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
                    System.out.println("クロス参照取得時に例外が発生:" + ex.toString());
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
                System.out.println("ResultSetから文字列を取得する際に例外が発生。:"
                        + ex.toString());
            }
            return null;
        }
    }

    /**
     * データベースメタ情報から表の一覧情報を取得します。
     * 
     * 表名に $ が含まれるものは処理をスキップします。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTable
     *            表名。指定しない場合にはnullを与える。
     * @param argTypes
     *            取得する種類の一覧。nullなら全て。new String[] { "TABLE" }のように指定。
     * @return 表情報の一覧。
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

                // System.out.println("表[" + tableStructure.getName() + "]を処理");

                tableStructure.setType(resultSet.getString("TABLE_TYPE"));

                tableStructure.setCatalog(getStringSafety(resultSet,
                        "TABLE_CAT"));
                tableStructure.setSchema(getStringSafety(resultSet,
                        "TABLE_SCHEM"));
                tableStructure
                        .setRemarks(getStringSafety(resultSet, "REMARKS"));

                if (BlancoStringUtil.null2Blank(tableStructure.getName())
                        .length() == 0) {
                    // 表名が無いものは処理をスキップします。
                    continue;
                }
                if (BlancoStringUtil.null2Blank(tableStructure.getType())
                        .length() == 0) {
                    // 表タイプが無いものは処理をスキップします。
                    continue;
                }
                if (tableStructure.getName().indexOf('$') >= 0) {
                    // 表名に $ が含まれているものは処理をスキップします。
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
     * データベースメタ情報から表のカラム一覧情報を取得します。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTableName
     *            表名。指定しない場合にはnullを与える。
     * @return 項目の一覧が戻る。
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
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
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
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setNumPrecRadix(resultSet
                            .getInt("NUM_PREC_RADIX"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
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
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
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
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setSqlDatetimeSub(resultSet
                            .getInt("SQL_DATETIME_SUB"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setCharOctetLength(resultSet
                            .getInt("CHAR_OCTET_LENGTH"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
                                + ex.toString());
                    }
                }
                try {
                    columnStructure.setOrdinalPosition(resultSet
                            .getInt("ORDINAL_POSITION"));
                } catch (SQLException ex) {
                    if (IS_REPORT_COLUMN_NOT_FOUND) {
                        System.out.println("ResultSetからintを取得する際に例外が発生。:"
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
                        System.out.println("ResultSetからshortを取得する際に例外が発生。:"
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
     * データベースメタ情報から表のプライマリキー情報を取得します。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTableName
     *            表名。指定しない場合にはnullを与える。
     * @return プライマリキーの一覧が戻る。
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
     * データベースメタ情報から表の外部キー列を参照する主キー列に関する情報を取得します。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTableName
     *            表名。指定しない場合にはnullを与える。
     * @return 主キー列の一覧が戻る。
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
     * データベースメタ情報から表の外部キー列を参照する主キー列に関する情報を取得します。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argTableName
     *            表名。指定しない場合にはnullを与える。
     * @return 主キー列の一覧が戻る。
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
     * データベースメタ情報から表の外部キー列に関する情報を取得します。
     * 
     * @param metadata
     *            データベースメタデータ。
     * @param argPrimaryCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argPrimarySchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argPrimaryTableName
     *            表名。指定しない場合にはnullを与える。
     * @param argForeignCat
     *            カタログ名。指定しない場合にはnullを与える。
     * @param argForeignSchema
     *            スキーマ名。指定しない場合にはnullを与える。
     * @param argForeignTableName
     *            表名。指定しない場合にはnullを与える。
     * @return 主キー列の一覧が戻る。
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
     * ResultSetからキー構造を取得します。
     * 
     * getImportedKeys, getExportedKeysなどのResultSetが同一であることから、これを共通化しています。
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
                System.out.println("ResultSetからshortを取得する際に例外が発生。:"
                        + ex.toString());
            }
        }
        try {
            keyStructure.setDeleteRule(resultSet.getShort("DELETE_RULE"));
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSetからshortを取得する際に例外が発生。:"
                        + ex.toString());
            }
        }
        keyStructure.setFkName(getStringSafety(resultSet, "FK_NAME"));
        keyStructure.setPkName(getStringSafety(resultSet, "PK_NAME"));
        try {
            keyStructure.setDeferrability(resultSet.getShort("DEFERRABILITY"));
        } catch (SQLException ex) {
            if (IS_REPORT_COLUMN_NOT_FOUND) {
                System.out.println("ResultSetからshortを取得する際に例外が発生。:"
                        + ex.toString());
            }
        }

        return keyStructure;
    }
}
