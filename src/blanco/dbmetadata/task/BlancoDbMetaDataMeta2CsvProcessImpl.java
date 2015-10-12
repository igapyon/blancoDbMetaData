/*
 * blanco Framework
 * Copyright (C) 2004-2006 IGA Tosiki
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */
package blanco.dbmetadata.task;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import blanco.dbmetadata.BlancoDbMetaDataConstants;
import blanco.dbmetadata.csv.BlancoDbMetaDataMeta2Csv;
import blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput;

public class BlancoDbMetaDataMeta2CsvProcessImpl implements
        BlancoDbMetaDataMeta2CsvProcess {

    public int execute(final BlancoDbMetaDataMeta2CsvProcessInput input)
            throws IOException, IllegalArgumentException {
        System.out.println("- " + BlancoDbMetaDataConstants.PRODUCT_NAME + " ("
                + BlancoDbMetaDataConstants.VERSION + ")");

        try {
            // テンポラリディレクトリを作成。
            final File fileTempDirectory = new File(input.getTmpdir()
                    + BlancoDbMetaDataConstants.TARGET_SUBDIRECTORY);
            fileTempDirectory.mkdirs();

            final File fileTargetDirectory = new File(input.getTargetdir());
            fileTargetDirectory.mkdirs();

            // 指定されたメタディレクトリを処理します。
            new BlancoDbMetaDataMeta2Csv().process(input.getJdbcdriver(), input
                    .getJdbcurl(), input.getJdbcuser(),
                    input.getJdbcpassword(), input.getSchema(), input
                            .getTable(), fileTargetDirectory);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            throw ex;
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.toString());
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException(ex.toString());
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean progress(final String argProgressMessage) {
        System.out.println(argProgressMessage);
        return false;
    }
}
