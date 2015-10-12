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
 * �f�[�^�x�[�X���烁�^�����擾���郆�[�e�B���e�B�B
 * 
 * ��{�I�ȃ��\�b�h���܂܂�܂��B
 * 
 * @author IGA Tosiki
 */
public class BlancoDbMetaDataUtil {
    /**
     * �w�肳�ꂽ�������ƂɃf�[�^�x�[�X�ɐڑ����܂��B
     * 
     * DriverManager �͗��p�����ɁA�Ǝ������Ńf�[�^�x�[�X�ڑ����������܂��B
     * ����̓N���X���[�_�[�̃C���X�^���X���قȂ�ꍇ�ł��K�؂ɓ��삳���邽�߂̑Ώ��ł��B
     * 
     * @param argJdbcDriverClassName
     *            JDBC�h���C�o�E�N���X���B
     * @param argJdbcUrl
     *            JDBC�ڑ���URL�B
     * @param argJdbcUser
     *            JDBC�ڑ����[�U���B
     * @param argJdbcPassword
     *            JDBC�ڑ��p�X���[�h�B
     * @return �f�[�^�x�[�X�ڑ��B
     * @throws ClassNotFoundException
     *             �N���X��������Ȃ������ꍇ�B
     * @throws IllegalArgumentException
     *             �ڑ����ɗ�O�����������ꍇ�B
     */
    public static Connection connect(final String argJdbcDriverClassName,
            final String argJdbcUrl, final String argJdbcUser,
            final String argJdbcPassword) throws ClassNotFoundException {
        return connect(argJdbcDriverClassName, argJdbcUrl, argJdbcUser,
                argJdbcPassword, BlancoDbMetaDataUtil.class.getClassLoader());
    }

    /**
     * �w�肳�ꂽ�������ƂɃf�[�^�x�[�X�ɐڑ����܂��B
     * 
     * DriverManager �͗��p�����ɁA�Ǝ������Ńf�[�^�x�[�X�ڑ����������܂��B
     * ����̓N���X���[�_�[�̃C���X�^���X���قȂ�ꍇ�ł��K�؂ɓ��삳���邽�߂̑Ώ��ł��B
     * 
     * @param argJdbcDriverClassName
     *            JDBC�h���C�o�E�N���X���B
     * @param argJdbcUrl
     *            JDBC�ڑ���URL�B
     * @param argJdbcUser
     *            JDBC�ڑ����[�U���B
     * @param argJdbcPassword
     *            JDBC�ڑ��p�X���[�h�B
     * @param loader
     *            �N���X���[�_�[�B
     * @return �f�[�^�x�[�X�ڑ��B
     * @throws ClassNotFoundException
     *             �N���X��������Ȃ������ꍇ�B
     * @throws IllegalArgumentException
     *             �ڑ����ɗ�O�����������ꍇ�B
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
            throw new ClassNotFoundException("�f�[�^�x�[�X�ڑ�: JDBC�h���C�o�N���X["
                    + argJdbcDriverClassName + "]���[�h�Ɏ��s���܂���: " + ex.toString(),
                    ex);
        }

        try {
            driver = (Driver) driverClass.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("�f�[�^�x�[�X�ڑ�: JDBC�h���C�o�N���X["
                    + argJdbcDriverClassName + "]�̃C���X�^���X���Ɏ��s���܂���: "
                    + e.toString());
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("�f�[�^�x�[�X�ڑ�: JDBC�h���C�o�N���X["
                    + argJdbcDriverClassName + "]�̃C���X�^���X���̍ۂɃA�N�Z�X�ᔽ���������܂���: "
                    + e.toString());
        }

        try {
            // DriverManager���g�p�����ADriver��connect()���\�b�h�𒼐ڌĂяo���܂��B
            // ����ɂ��A�N���X���[�_�[���ʂł����삵�܂��B
            final Properties info = new Properties();
            info.put("user", argJdbcUser);
            info.put("password", argJdbcPassword);
            conn = driver.connect(argJdbcUrl, info);
        } catch (SQLException ex) {
            throw new IllegalArgumentException("�f�[�^�x�[�X�ڑ�: JDBC�ڑ��Ɏ��s���܂���: "
                    + ex.toString());
        }

        return conn;
    }

    /**
     * �w�肳�ꂽ URI �ꗗ���� JDBC �h���C�o�[�E�N���X�����[�h�����N���X���[�_�[���쐬���܂��B
     * 
     * �R�[�h��: urlArray[0] = jarFile.toURL();
     * 
     * @param urlArray
     *            �ǂݍ��݂��� URI �ꗗ�B
     * @param argJdbcDriverClassName
     *            �h���C�o�N���X���B
     * @return �N���X���[�_�[�̃C���X�^���X�B
     * @throws ClassNotFoundException
     *             �N���X��������Ȃ������ꍇ�B
     */
    public static final ClassLoader loadDriverClass(final URL[] urlArray,
            final String argJdbcDriverClassName) throws ClassNotFoundException {
        try {
            final ClassLoader loader = new URLClassLoader(urlArray,
                    BlancoDbMetaDataUtil.class.getClassLoader());
            loader.loadClass(argJdbcDriverClassName);

            return loader;
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("�f�[�^�x�[�X�ڑ�: JDBC�h���C�o�N���X["
                    + argJdbcDriverClassName + "]�̃N���X���[�h�Ɏ��s���܂���: "
                    + e.toString());
        }
    }

    /**
     * JDBC�f�[�^�^�C�v��Java�̕�����ɓǂݑւ��܂��B
     * 
     * [java.sql.Types.]��O���ɕt�^�����Java JDBC�̒萔�ɂȂ�܂��B
     * 
     * @param argJdbcDataType
     *            JDBC��̃f�[�^�^�B
     * @return Java��̕�����B
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
            // ���v���Ȃ������ꍇ�ɂ� �󔒂�߂��܂��B
            return "";
        }
    }

    /**
     * JDBC�f�[�^�^�C�v�������Java��Types�ɓǂݑւ��܂��B
     * 
     * @param argJdbcDataType
     *            [java.sql.Types.]��O���ɕt�^�����Java JDBC�̒萔�ɂȂ�l�B
     * @return java.sql.Types�̒l�B�q�b�g���Ȃ������ꍇ�ɂ� Integer.MIN_VALUE�B
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

        // �m�肵�Ȃ������ꍇ�B
        return Integer.MIN_VALUE;
    }

    /**
     * JDBC �� nullable��Java�̕�����ɓǂݑւ��܂��B
     * 
     * [java.sql.ResultSetMetaData.]��O���ɕt�^�����Java JDBC�̒萔�ɂȂ�܂��B
     * 
     * @param argJdbcDataType
     *            JDBC��̃f�[�^�^�B
     * @return Java�����񖼏́B
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
            // ���v���Ȃ������ꍇ�ɂ� �󔒂�߂��܂��B
            return "";
        }
    }

    /**
     * �f�[�^�x�[�X��̃^�C�v������f�[�^�^�C�v���������Ă܂��B
     * 
     * ORACLE�ɂ�����
     * TIMESTAMP�^�ɑ΂��ăT�C�Y�w��������Ȃ����ꍇ��OTHER�ɂȂ��Ă��܂��܂��B���̍ۂɖ��̂���^�C�v�����������Ă鏈���������Ȃ��܂��B
     * 
     * OTHER �� �s�� �̏ꍇ�ɂ̂݁A���̏��������{����悤�ɂ��Ă��������B
     * 
     * @param columnStructure
     *            ��\���B
     * @return true�Ȃ�������Ă̌��ʍX�V���ꂽ�B false�Ȃ牽�����{����Ă��Ȃ��B
     */
    public static final boolean mapTypeName2DataType(
            final BlancoDbMetaDataColumnStructure columnStructure) {

        // �f�[�^�x�[�X��̌^�����擾���܂��B
        String wrkTypeName = columnStructure.getTypeName().toUpperCase();

        // ()�ɂ��T�C�Y�w���؂���܂��B
        int indexOfTrim = wrkTypeName.indexOf('(');
        if (indexOfTrim > 0) {
            wrkTypeName = wrkTypeName.substring(0, indexOfTrim);
        }

        // JDBC�^�C�v���̕�������g���āA�^���������Ă����{���܂��B
        final int jdbcDataType = convertJdbcDataType2Int(wrkTypeName);
        if (jdbcDataType != Integer.MIN_VALUE) {
            // ���o���ꂽ�f�[�^�^�C�v�𐳂Ƃ��Ĉ����܂��B
            columnStructure.setDataType(jdbcDataType);
            return true;
        }

        return false;
    }
}
