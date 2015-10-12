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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSetMetaData;
import java.util.List;

import blanco.commons.util.BlancoFileUtil;
import blanco.commons.util.BlancoStringUtil;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataTableStructure;

class WriteCsvForMetaInfoAll {
    /**
     * 全ての表に関する情報をひとつのCSVファイルにまとめて作成します。
     * 
     * @throws IOException
     * 
     */
    public static void process(
            final List<BlancoDbMetaDataTableStructure> listTables,
            final File targetDir) throws IOException {
        final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(outStream));

        for (int indexTable = 0; indexTable < listTables.size(); indexTable++) {
            final BlancoDbMetaDataTableStructure tableStructure = listTables
                    .get(indexTable);

            if (indexTable != 0) {
                writer.newLine();
            }

            BlancoDbMetaDataMeta2Csv.writeTableInfo(tableStructure, writer);
            writer.newLine();

            writer.write("列名,型(桁),非NULL,主キー,被参照,参照,デフォルト,備考");
            writer.newLine();

            for (int indexColumn = 0; indexColumn < tableStructure.getColumns()
                    .size(); indexColumn++) {
                final BlancoDbMetaDataColumnStructure columnStructure = tableStructure
                        .getColumns().get(indexColumn);

                writer.write(columnStructure.getName());
                writer.write(",");

                BlancoDbMetaDataMeta2Csv.writeColumnTypeName(columnStructure,
                        writer);
                writer.write(",");

                if (columnStructure.getNullable() == ResultSetMetaData.columnNoNulls) {
                    writer.write("○");
                } else if (columnStructure.getNullable() == ResultSetMetaData.columnNullableUnknown) {
                    writer.write("？");
                }

                writer.write(",");

                {
                    boolean isPrimaryKey = false;
                    for (int indexPrimaryKey = 0; indexPrimaryKey < tableStructure
                            .getPrimaryKeys().size(); indexPrimaryKey++) {
                        final BlancoDbMetaDataKeyStructure primaryKeyStructure = tableStructure
                                .getPrimaryKeys().get(indexPrimaryKey);
                        if (primaryKeyStructure.getPkcolumnName().equals(
                                columnStructure.getName())) {
                            isPrimaryKey = true;
                        }
                    }
                    if (isPrimaryKey) {
                        writer.write("○");
                    }
                }

                writer.write(",\"");

                {
                    boolean isExportedKey = false;
                    for (int indexExportedKey = 0; indexExportedKey < tableStructure
                            .getExportedKeys().size(); indexExportedKey++) {
                        final BlancoDbMetaDataKeyStructure exportedKeyStructure = tableStructure
                                .getExportedKeys().get(indexExportedKey);
                        if (exportedKeyStructure.getPkcolumnName().equals(
                                columnStructure.getName())) {
                            isExportedKey = true;
                        }
                    }
                    if (isExportedKey) {
                        // このキーを参照しているキーのリストについては、crossReferenceKeysから取得します。
                        final List<BlancoDbMetaDataKeyStructure> listForeignKey = tableStructure
                                .getCrossReferenceKeys();
                        for (int indexKey = 0; indexKey < listForeignKey.size(); indexKey++) {
                            final BlancoDbMetaDataKeyStructure importedKeyStructure = listForeignKey
                                    .get(indexKey);
                            if (indexKey != 0) {
                                writer.write("\n");
                            }
                            writer.write("["
                                    + importedKeyStructure.getFktableName()
                                    + "."
                                    + importedKeyStructure.getFkcolumnName()
                                    + "(" + importedKeyStructure.getFkName()
                                    + ")]");
                        }
                    }
                }

                writer.write("\",");

                {
                    BlancoDbMetaDataKeyStructure foundKeyStructure = null;
                    boolean isImportedKey = false;
                    for (int indexImportedKey = 0; indexImportedKey < tableStructure
                            .getImportedKeys().size(); indexImportedKey++) {
                        final BlancoDbMetaDataKeyStructure importedKeyStructure = tableStructure
                                .getImportedKeys().get(indexImportedKey);
                        if (importedKeyStructure.getFkcolumnName().equals(
                                columnStructure.getName())) {
                            isImportedKey = true;
                            foundKeyStructure = importedKeyStructure;
                        }
                    }
                    if (isImportedKey) {
                        writer.write("[" + foundKeyStructure.getPktableName()
                                + "." + foundKeyStructure.getPkcolumnName()
                                + "(" + foundKeyStructure.getFkName() + ")]");
                    }
                }

                writer.write(",");

                writer.write(BlancoStringUtil.null2Blank(columnStructure
                        .getColumnDef()));

                writer.write(",");

                writer.write(BlancoStringUtil.null2Blank(columnStructure
                        .getRemarks()));

                writer.newLine();
            }
        }

        writer.flush();
        outStream.flush();

        final File fileTarget = new File(targetDir.getAbsolutePath()
                + "/MetaInfoAll.csv");
        switch (BlancoFileUtil.bytes2FileIfNecessary(outStream.toByteArray(),
                fileTarget)) {
        case 0:
            break;
        case 1:
            System.out.println("dbmeta: " + "create: "
                    + fileTarget.getAbsolutePath());
            break;
        case 2:
            System.out.println("dbmeta: " + "update: "
                    + fileTarget.getAbsolutePath());
            break;
        }

    }
}
