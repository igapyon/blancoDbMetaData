/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.task.valueobject;

/**
 * 処理クラス [BlancoDbMetaDataMeta2CsvProcess]の入力バリューオブジェクトクラスです。
 */
public class BlancoDbMetaDataMeta2CsvProcessInput {
    /**
     * verboseモードで動作させるかどうか。
     *
     * フィールド: [verbose]。
     * デフォルト: [false]。
     */
    private boolean fVerbose = false;

    /**
     * JDBCドライバ名を指定します。
     *
     * フィールド: [jdbcdriver]。
     */
    private String fJdbcdriver;

    /**
     * JDBC接続先URLを指定します。
     *
     * フィールド: [jdbcurl]。
     */
    private String fJdbcurl;

    /**
     * フィールド: [jdbcuser]。
     */
    private String fJdbcuser;

    /**
     * フィールド: [jdbcpassword]。
     */
    private String fJdbcpassword;

    /**
     * スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。
     *
     * フィールド: [schema]。
     */
    private String fSchema;

    /**
     * 指定された場合には、その表のみを処理します。
     *
     * フィールド: [table]。
     */
    private String fTable;

    /**
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。
     *
     * フィールド: [targetdir]。
     * デフォルト: [blanco.db]。
     */
    private String fTargetdir = "blanco.db";

    /**
     * テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。
     *
     * フィールド: [tmpdir]。
     * デフォルト: [tmp]。
     */
    private String fTmpdir = "tmp";

    /**
     * フィールド [verbose] の値を設定します。
     *
     * フィールドの説明: [verboseモードで動作させるかどうか。]。
     *
     * @param argVerbose フィールド[verbose]に設定する値。
     */
    public void setVerbose(final boolean argVerbose) {
        fVerbose = argVerbose;
    }

    /**
     * フィールド [verbose] の値を取得します。
     *
     * フィールドの説明: [verboseモードで動作させるかどうか。]。
     * デフォルト: [false]。
     *
     * @return フィールド[verbose]から取得した値。
     */
    public boolean getVerbose() {
        return fVerbose;
    }

    /**
     * フィールド [jdbcdriver] の値を設定します。
     *
     * フィールドの説明: [JDBCドライバ名を指定します。]。
     *
     * @param argJdbcdriver フィールド[jdbcdriver]に設定する値。
     */
    public void setJdbcdriver(final String argJdbcdriver) {
        fJdbcdriver = argJdbcdriver;
    }

    /**
     * フィールド [jdbcdriver] の値を取得します。
     *
     * フィールドの説明: [JDBCドライバ名を指定します。]。
     *
     * @return フィールド[jdbcdriver]から取得した値。
     */
    public String getJdbcdriver() {
        return fJdbcdriver;
    }

    /**
     * フィールド [jdbcurl] の値を設定します。
     *
     * フィールドの説明: [JDBC接続先URLを指定します。]。
     *
     * @param argJdbcurl フィールド[jdbcurl]に設定する値。
     */
    public void setJdbcurl(final String argJdbcurl) {
        fJdbcurl = argJdbcurl;
    }

    /**
     * フィールド [jdbcurl] の値を取得します。
     *
     * フィールドの説明: [JDBC接続先URLを指定します。]。
     *
     * @return フィールド[jdbcurl]から取得した値。
     */
    public String getJdbcurl() {
        return fJdbcurl;
    }

    /**
     * フィールド [jdbcuser] の値を設定します。
     *
     * フィールドの説明: []。
     *
     * @param argJdbcuser フィールド[jdbcuser]に設定する値。
     */
    public void setJdbcuser(final String argJdbcuser) {
        fJdbcuser = argJdbcuser;
    }

    /**
     * フィールド [jdbcuser] の値を取得します。
     *
     * フィールドの説明: []。
     *
     * @return フィールド[jdbcuser]から取得した値。
     */
    public String getJdbcuser() {
        return fJdbcuser;
    }

    /**
     * フィールド [jdbcpassword] の値を設定します。
     *
     * フィールドの説明: []。
     *
     * @param argJdbcpassword フィールド[jdbcpassword]に設定する値。
     */
    public void setJdbcpassword(final String argJdbcpassword) {
        fJdbcpassword = argJdbcpassword;
    }

    /**
     * フィールド [jdbcpassword] の値を取得します。
     *
     * フィールドの説明: []。
     *
     * @return フィールド[jdbcpassword]から取得した値。
     */
    public String getJdbcpassword() {
        return fJdbcpassword;
    }

    /**
     * フィールド [schema] の値を設定します。
     *
     * フィールドの説明: [スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。]。
     *
     * @param argSchema フィールド[schema]に設定する値。
     */
    public void setSchema(final String argSchema) {
        fSchema = argSchema;
    }

    /**
     * フィールド [schema] の値を取得します。
     *
     * フィールドの説明: [スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。]。
     *
     * @return フィールド[schema]から取得した値。
     */
    public String getSchema() {
        return fSchema;
    }

    /**
     * フィールド [table] の値を設定します。
     *
     * フィールドの説明: [指定された場合には、その表のみを処理します。]。
     *
     * @param argTable フィールド[table]に設定する値。
     */
    public void setTable(final String argTable) {
        fTable = argTable;
    }

    /**
     * フィールド [table] の値を取得します。
     *
     * フィールドの説明: [指定された場合には、その表のみを処理します。]。
     *
     * @return フィールド[table]から取得した値。
     */
    public String getTable() {
        return fTable;
    }

    /**
     * フィールド [targetdir] の値を設定します。
     *
     * フィールドの説明: [出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。]。
     *
     * @param argTargetdir フィールド[targetdir]に設定する値。
     */
    public void setTargetdir(final String argTargetdir) {
        fTargetdir = argTargetdir;
    }

    /**
     * フィールド [targetdir] の値を取得します。
     *
     * フィールドの説明: [出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。]。
     * デフォルト: [blanco.db]。
     *
     * @return フィールド[targetdir]から取得した値。
     */
    public String getTargetdir() {
        return fTargetdir;
    }

    /**
     * フィールド [tmpdir] の値を設定します。
     *
     * フィールドの説明: [テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。]。
     *
     * @param argTmpdir フィールド[tmpdir]に設定する値。
     */
    public void setTmpdir(final String argTmpdir) {
        fTmpdir = argTmpdir;
    }

    /**
     * フィールド [tmpdir] の値を取得します。
     *
     * フィールドの説明: [テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。]。
     * デフォルト: [tmp]。
     *
     * @return フィールド[tmpdir]から取得した値。
     */
    public String getTmpdir() {
        return fTmpdir;
    }

    /**
     * このバリューオブジェクトの文字列表現を取得します。
     *
     * <P>使用上の注意</P>
     * <UL>
     * <LI>オブジェクトのシャロー範囲のみ文字列化の処理対象となります。
     * <LI>オブジェクトが循環参照している場合には、このメソッドは使わないでください。
     * </UL>
     *
     * @return バリューオブジェクトの文字列表現。
     */
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput[");
        buf.append("verbose=" + fVerbose);
        buf.append(",jdbcdriver=" + fJdbcdriver);
        buf.append(",jdbcurl=" + fJdbcurl);
        buf.append(",jdbcuser=" + fJdbcuser);
        buf.append(",jdbcpassword=" + fJdbcpassword);
        buf.append(",schema=" + fSchema);
        buf.append(",table=" + fTable);
        buf.append(",targetdir=" + fTargetdir);
        buf.append(",tmpdir=" + fTmpdir);
        buf.append("]");
        return buf.toString();
    }
}
