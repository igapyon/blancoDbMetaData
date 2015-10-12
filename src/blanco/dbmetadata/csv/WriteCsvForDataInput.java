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
import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure;
import blanco.dbmetadata.valueobject.BlancoDbMetaDataTableStructure;

class WriteCsvForDataInput {
    /**
     * データ入力用のCSVファイルを作成します。
     * 
     * @throws IOException
     * 
     */
    public static void process(
            final List<BlancoDbMetaDataTableStructure> listTables,
            final File targetDir) throws IOException {
        for (int indexTable = 0; indexTable < listTables.size(); indexTable++) {
            final BlancoDbMetaDataTableStructure tableStructure = listTables
                    .get(indexTable);

            final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            final BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(outStream));

            try {
                BlancoDbMetaDataMeta2Csv.writeTableInfo(tableStructure, writer);
                writer.newLine();

                for (int indexColumn = 0; indexColumn < tableStructure
                        .getColumns().size(); indexColumn++) {
                    final BlancoDbMetaDataColumnStructure columnStructure = tableStructure
                            .getColumns().get(indexColumn);

                    if (indexColumn != 0) {
                        writer.write(",");
                    }

                    writer.write(columnStructure.getName());
                }
                writer.newLine();

                for (int indexColumn = 0; indexColumn < tableStructure
                        .getColumns().size(); indexColumn++) {
                    final BlancoDbMetaDataColumnStructure columnStructure = tableStructure
                            .getColumns().get(indexColumn);

                    if (indexColumn != 0) {
                        writer.write(",");
                    }

                    BlancoDbMetaDataMeta2Csv.writeColumnTypeName(
                            columnStructure, writer);
                }
                writer.newLine();

                // 主キーかどうかを表示。
                for (int indexColumn = 0; indexColumn < tableStructure
                        .getColumns().size(); indexColumn++) {
                    final BlancoDbMetaDataColumnStructure columnStructure = tableStructure
                            .getColumns().get(indexColumn);

                    if (indexColumn != 0) {
                        writer.write(",");
                    }

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
                        writer.write("主キー");
                    }
                }
                writer.newLine();

                // 非NULLかどうかを表示。
                for (int indexColumn = 0; indexColumn < tableStructure
                        .getColumns().size(); indexColumn++) {
                    final BlancoDbMetaDataColumnStructure columnStructure = tableStructure
                            .getColumns().get(indexColumn);

                    if (indexColumn != 0) {
                        writer.write(",");
                    }

                    if (columnStructure.getNullable() == ResultSetMetaData.columnNoNulls) {
                        writer.write("非NULL");
                    }
                }

                writer.newLine();

                writer.flush();
                outStream.flush();

                final File fileTarget = new File(targetDir.getAbsolutePath()
                        + "/" + tableStructure.getName() + ".data.csv");
                switch (BlancoFileUtil.bytes2FileIfNecessary(outStream
                        .toByteArray(), fileTarget)) {
                case 0:
                    break;
                case 1:
                    System.out.println("dbmeta: data: " + "create: "
                            + fileTarget.getAbsolutePath());
                    break;
                case 2:
                    System.out.println("dbmeta: data: " + "update: "
                            + fileTarget.getAbsolutePath());
                    break;
                }
            } finally {
                writer.close();
            }
        }
    }
}
