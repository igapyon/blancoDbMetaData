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

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure;

/**
 * データベースからメタ情報を取得するユーティリティ。
 * 
 * 基本的なメソッドが含まれます。
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataUtil {
    /**
     * 指定された情報をもとにデータベースに接続します。
     * 
     * DriverManager は利用せずに、独自方式でデータベース接続を実現します。
     * これはクラスローダーのインスタンスが異なる場合でも適切に動作させるための対処です。
     * 
     * @param argJdbcDriverClassName
     *            JDBCドライバ・クラス名。
     * @param argJdbcUrl
     *            JDBC接続先URL。
     * @param argJdbcUser
     *            JDBC接続ユーザ名。
     * @param argJdbcPassword
     *            JDBC接続パスワード。
     * @return データベース接続。
     * @throws ClassNotFoundException
     *             クラスが見つからなかった場合。
     * @throws IllegalArgumentException
     *             接続時に例外が発生した場合。
     */
    public static Connection connect(final String argJdbcDriverClassName,
            final String argJdbcUrl, final String argJdbcUser,
            final String argJdbcPassword) throws ClassNotFoundException {
        return connect(argJdbcDriverClassName, argJdbcUrl, argJdbcUser,
                argJdbcPassword, BlancoDbMetaDataUtil.class.getClassLoader());
    }

    /**
     * 指定された情報をもとにデータベースに接続します。
     * 
     * DriverManager は利用せずに、独自方式でデータベース接続を実現します。
     * これはクラスローダーのインスタンスが異なる場合でも適切に動作させるための対処です。
     * 
     * @param argJdbcDriverClassName
     *            JDBCドライバ・クラス名。
     * @param argJdbcUrl
     *            JDBC接続先URL。
     * @param argJdbcUser
     *            JDBC接続ユーザ名。
     * @param argJdbcPassword
     *            JDBC接続パスワード。
     * @param loader
     *            クラスローダー。
     * @return データベース接続。
     * @throws ClassNotFoundException
     *             クラスが見つからなかった場合。
     * @throws IllegalArgumentException
     *             接続時に例外が発生した場合。
     */
    @SuppressWarnings( { "unchecked" })
    public static Connection connect(final String argJdbcDriverClassName,
            final String argJdbcUrl, final String argJdbcUser,
            final String argJdbcPassword, final ClassLoader loader)
            throws ClassNotFoundException {
        Connection conn = null;
        Driver driver = null;
        Class driverClass = null;
        try {
            driverClass = loader.loadClass(argJdbcDriverClassName);
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("データベース接続: JDBCドライバクラス["
                    + argJdbcDriverClassName + "]ロードに失敗しました: " + ex.toString(),
                    ex);
        }

        try {
            driver = (Driver) driverClass.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("データベース接続: JDBCドライバクラス["
                    + argJdbcDriverClassName + "]のインスタンス化に失敗しました: "
                    + e.toString());
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("データベース接続: JDBCドライバクラス["
                    + argJdbcDriverClassName + "]のインスタンス化の際にアクセス違反が発生しました: "
                    + e.toString());
        }

        try {
            // DriverManagerを使用せず、Driverのconnect()メソッドを直接呼び出します。
            // これにより、クラスローダーが別でも動作します。
            final Properties info = new Properties();
            info.put("user", argJdbcUser);
            info.put("password", argJdbcPassword);
            conn = driver.connect(argJdbcUrl, info);
        } catch (SQLException ex) {
            throw new IllegalArgumentException("データベース接続: JDBC接続に失敗しました: "
                    + ex.toString());
        }

        return conn;
    }

    /**
     * 指定された URI 一覧から JDBC ドライバー・クラスをロードしたクラスローダーを作成します。
     * 
     * コード例: urlArray[0] = jarFile.toURL();
     * 
     * @param urlArray
     *            読み込みもと URI 一覧。
     * @param argJdbcDriverClassName
     *            ドライバクラス名。
     * @return クラスローダーのインスタンス。
     * @throws ClassNotFoundException
     *             クラスが見つからなかった場合。
     */
    public static final ClassLoader loadDriverClass(final URL[] urlArray,
            final String argJdbcDriverClassName) throws ClassNotFoundException {
        try {
            final ClassLoader loader = new URLClassLoader(urlArray,
                    BlancoDbMetaDataUtil.class.getClassLoader());
            loader.loadClass(argJdbcDriverClassName);

            return loader;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("データベース接続: JDBCドライバクラス["
                    + argJdbcDriverClassName + "]のクラスロードに失敗しました: "
                    + e.toString());
        }
    }

    /**
     * JDBCデータタイプをJavaの文字列に読み替えます。
     * 
     * [java.sql.Types.]を前方に付与するとJava JDBCの定数になります。
     * 
     * @param argJdbcDataType
     *            JDBC上のデータ型。
     * @return Java上の文字列。
     */
    public final static String convertJdbcDataTypeToString(
            final int argJdbcDataType) {
        switch (argJdbcDataType) {
        case Types.BIT:
            return "BIT";
        case Types.TINYINT:
            return "TINYINT";
        case Types.SMALLINT:
            return "SMALLINT";
        case Types.INTEGER:
            return "INTEGER";
        case Types.BIGINT:
            return "BIGINT";
        case Types.FLOAT:
            return "FLOAT";
        case Types.REAL:
            return "REAL";
        case Types.DOUBLE:
            return "DOUBLE";
        case Types.NUMERIC:
            return "NUMERIC";
        case Types.DECIMAL:
            return "DECIMAL";
        case Types.CHAR:
            return "CHAR";
        case Types.VARCHAR:
            return "VARCHAR";
        case Types.LONGVARCHAR:
            return "LONGVARCHAR";
        case Types.NCHAR:
            return "NCHAR";
        case Types.NVARCHAR:
            return "NVARCHAR";
        case Types.LONGNVARCHAR:
            return "LONGNVARCHAR";
        case Types.DATE:
            return "DATE";
        case Types.TIME:
            return "TIME";
        case Types.TIMESTAMP:
            return "TIMESTAMP";
        case Types.BINARY:
            return "BINARY";
        case Types.VARBINARY:
            return "VARBINARY";
        case Types.LONGVARBINARY:
            return "LONGVARBINARY";
        case Types.NULL:
            return "NULL";
        case Types.OTHER:
            return "OTHER";
        case Types.JAVA_OBJECT:
            return "JAVA_OBJECT";
        case Types.DISTINCT:
            return "DISTINCT";
        case Types.STRUCT:
            return "STRUCT";
        case Types.ARRAY:
            return "ARRAY";
        case Types.BLOB:
            return "BLOB";
        case Types.CLOB:
            return "CLOB";
        case Types.REF:
            return "REF";
        case Types.DATALINK:
            return "DATALINK";
        case Types.BOOLEAN:
            return "BOOLEAN";
        case Types.ROWID:
            return "ROWID";
        default:
            // 合致しなかった場合には 空白を戻します。
            return "";
        }
    }

    /**
     * JDBCデータタイプ文字列をJavaのTypesに読み替えます。
     * 
     * @param argJdbcDataType
     *            [java.sql.Types.]を前方に付与するとJava JDBCの定数になる値。
     * @return java.sql.Typesの値。ヒットしなかった場合には Integer.MIN_VALUE。
     */
    public final static int convertJdbcDataType2Int(final String argJdbcDataType) {
        if (argJdbcDataType.equals("BIT")) {
            return Types.BIT;
        }
        if (argJdbcDataType.equals("TINYINT")) {
            return Types.TINYINT;
        }
        if (argJdbcDataType.equals("SMALLINT")) {
            return Types.SMALLINT;
        }
        if (argJdbcDataType.equals("INTEGER")) {
            return Types.INTEGER;
        }
        if (argJdbcDataType.equals("BIGINT")) {
            return Types.BIGINT;
        }
        if (argJdbcDataType.equals("FLOAT")) {
            return Types.FLOAT;
        }
        if (argJdbcDataType.equals("REAL")) {
            return Types.REAL;
        }
        if (argJdbcDataType.equals("DOUBLE")) {
            return Types.DOUBLE;
        }
        if (argJdbcDataType.equals("NUMERIC")) {
            return Types.NUMERIC;
        }
        if (argJdbcDataType.equals("DECIMAL")) {
            return Types.DECIMAL;
        }
        if (argJdbcDataType.equals("CHAR")) {
            return Types.CHAR;
        }
        if (argJdbcDataType.equals("VARCHAR")) {
            return Types.VARCHAR;
        }
        if (argJdbcDataType.equals("LONGVARCHAR")) {
            return Types.LONGVARCHAR;
        }
        if (argJdbcDataType.equals("NCHAR")) {
            return Types.NCHAR;
        }
        if (argJdbcDataType.equals("NVARCHAR")) {
            return Types.NVARCHAR;
        }
        if (argJdbcDataType.equals("LONGNVARCHAR")) {
            return Types.LONGNVARCHAR;
        }
        if (argJdbcDataType.equals("DATE")) {
            return Types.DATE;
        }
        if (argJdbcDataType.equals("TIME")) {
            return Types.TIME;
        }
        if (argJdbcDataType.equals("TIMESTAMP")) {
            return Types.TIMESTAMP;
        }
        if (argJdbcDataType.equals("BINARY")) {
            return Types.BINARY;
        }
        if (argJdbcDataType.equals("VARBINARY")) {
            return Types.VARBINARY;
        }
        if (argJdbcDataType.equals("LONGVARBINARY")) {
            return Types.LONGVARBINARY;
        }
        if (argJdbcDataType.equals("NULL")) {
            return Types.NULL;
        }
        if (argJdbcDataType.equals("OTHER")) {
            return Types.OTHER;
        }
        if (argJdbcDataType.equals("JAVA_OBJECT")) {
            return Types.JAVA_OBJECT;
        }
        if (argJdbcDataType.equals("DISTINCT")) {
            return Types.DISTINCT;
        }
        if (argJdbcDataType.equals("STRUCT")) {
            return Types.STRUCT;
        }
        if (argJdbcDataType.equals("ARRAY")) {
            return Types.ARRAY;
        }
        if (argJdbcDataType.equals("BLOB")) {
            return Types.BLOB;
        }
        if (argJdbcDataType.equals("CLOB")) {
            return Types.CLOB;
        }
        if (argJdbcDataType.equals("REF")) {
            return Types.REF;
        }
        if (argJdbcDataType.equals("DATALINK")) {
            return Types.DATALINK;
        }
        if (argJdbcDataType.equals("ROWID")) {
            return Types.ROWID;
        }
        if (argJdbcDataType.equals("BOOLEAN")) {
            return Types.BOOLEAN;
        }

        // 確定しなかった場合。
        return Integer.MIN_VALUE;
    }

    /**
     * JDBC の nullableをJavaの文字列に読み替えます。
     * 
     * [java.sql.ResultSetMetaData.]を前方に付与するとJava JDBCの定数になります。
     * 
     * @param argJdbcDataType
     *            JDBC上のデータ型。
     * @return Java文字列名称。
     */
    public final static String convertJdbcNullableToString(
            final int argJdbcDataType) {
        switch (argJdbcDataType) {
        case ResultSetMetaData.columnNoNulls:
            return "columnNoNulls";
        case ResultSetMetaData.columnNullable:
            return "columnNullable";
        case ResultSetMetaData.columnNullableUnknown:
            return "columnNullableUnknown";
        default:
            // 合致しなかった場合には 空白を戻します。
            return "";
        }
    }

    /**
     * データベース上のタイプ名からデータタイプを引き当てます。
     * 
     * ORACLEにおいて
     * TIMESTAMP型に対してサイズ指定をおこなった場合にOTHERになってしまいます。その際に名称からタイプ名を引き当てる処理をおこないます。
     * 
     * OTHER や 不定 の場合にのみ、この処理を実施するようにしてください。
     * 
     * @param columnStructure
     *            列構造。
     * @return trueなら引き当ての結果更新された。 falseなら何も実施されていない。
     */
    public static final boolean mapTypeName2DataType(
            final BlancoDbMetaDataColumnStructure columnStructure) {

        // データベース上の型名を取得します。
        String wrkTypeName = columnStructure.getTypeName().toUpperCase();

        // ()によるサイズ指定を切り取ります。
        int indexOfTrim = wrkTypeName.indexOf('(');
        if (indexOfTrim > 0) {
            wrkTypeName = wrkTypeName.substring(0, indexOfTrim);
        }

        // JDBCタイプ名の文字列を使って、型名引き当てを実施します。
        final int jdbcDataType = convertJdbcDataType2Int(wrkTypeName);
        if (jdbcDataType != Integer.MIN_VALUE) {
            // 導出されたデータタイプを正として扱います。
            columnStructure.setDataType(jdbcDataType);
            return true;
        }

        return false;
    }
}
