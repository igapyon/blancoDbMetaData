/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.task;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput;

/**
 * Apache Antタスク [BlancoDbMetaDataMeta2Csv]のクラス。
 *
 * データベースメタ情報からCSVを自動生成するためのAntTaskです。<br>
 * このクラスでは、Apache Antタスクで一般的に必要なチェックなどのコーディングを肩代わりします。
 * 実際の処理は パッケージ[blanco.dbmetadata.task]にBlancoDbMetaDataMeta2CsvBatchProcessクラスを作成して記述してください。<br>
 * <br>
 * Antタスクへの組み込み例<br>
 * <pre>
 * &lt;taskdef name=&quot;blancodbmetadatameta2csv&quot; classname=&quot;blanco.dbmetadata.task.BlancoDbMetaDataMeta2CsvTask">
 *     &lt;classpath&gt;
 *         &lt;fileset dir=&quot;lib&quot; includes=&quot;*.jar&quot; /&gt;
 *         &lt;fileset dir=&quot;lib.ant&quot; includes=&quot;*.jar&quot; /&gt;
 *     &lt;/classpath&gt;
 * &lt;/taskdef&gt;
 * </pre>
 */
public class BlancoDbMetaDataMeta2CsvTask extends Task {
    /**
     * データベースメタ情報からCSVを自動生成するためのAntTaskです。
     */
    protected BlancoDbMetaDataMeta2CsvProcessInput fInput = new BlancoDbMetaDataMeta2CsvProcessInput();

    /**
     * フィールド [jdbcdriver] に値がセットされたかどうか。
     */
    protected boolean fIsFieldJdbcdriverProcessed = false;

    /**
     * フィールド [jdbcurl] に値がセットされたかどうか。
     */
    protected boolean fIsFieldJdbcurlProcessed = false;

    /**
     * フィールド [jdbcuser] に値がセットされたかどうか。
     */
    protected boolean fIsFieldJdbcuserProcessed = false;

    /**
     * フィールド [jdbcpassword] に値がセットされたかどうか。
     */
    protected boolean fIsFieldJdbcpasswordProcessed = false;

    /**
     * フィールド [schema] に値がセットされたかどうか。
     */
    protected boolean fIsFieldSchemaProcessed = false;

    /**
     * フィールド [table] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTableProcessed = false;

    /**
     * フィールド [targetdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTargetdirProcessed = false;

    /**
     * フィールド [tmpdir] に値がセットされたかどうか。
     */
    protected boolean fIsFieldTmpdirProcessed = false;

    /**
     * verboseモードで動作させるかどうか。
     *
     * @param arg verboseモードで動作させるかどうか。
     */
    public void setVerbose(final boolean arg) {
        fInput.setVerbose(arg);
    }

    /**
     * verboseモードで動作させるかどうか。
     *
     * @return verboseモードで動作させるかどうか。
     */
    public boolean getVerbose() {
        return fInput.getVerbose();
    }

    /**
     * Antタスクの[jdbcdriver]アトリビュートのセッターメソッド。
     *
     * 項目番号: 1<br>
     * JDBCドライバ名を指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setJdbcdriver(final String arg) {
        fInput.setJdbcdriver(arg);
        fIsFieldJdbcdriverProcessed = true;
    }

    /**
     * Antタスクの[jdbcdriver]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 1<br>
     * JDBCドライバ名を指定します。<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getJdbcdriver() {
        return fInput.getJdbcdriver();
    }

    /**
     * Antタスクの[jdbcurl]アトリビュートのセッターメソッド。
     *
     * 項目番号: 2<br>
     * JDBC接続先URLを指定します。<br>
     *
     * @param arg セットしたい値
     */
    public void setJdbcurl(final String arg) {
        fInput.setJdbcurl(arg);
        fIsFieldJdbcurlProcessed = true;
    }

    /**
     * Antタスクの[jdbcurl]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 2<br>
     * JDBC接続先URLを指定します。<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getJdbcurl() {
        return fInput.getJdbcurl();
    }

    /**
     * Antタスクの[jdbcuser]アトリビュートのセッターメソッド。
     *
     * 項目番号: 3<br>
     *
     * @param arg セットしたい値
     */
    public void setJdbcuser(final String arg) {
        fInput.setJdbcuser(arg);
        fIsFieldJdbcuserProcessed = true;
    }

    /**
     * Antタスクの[jdbcuser]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 3<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getJdbcuser() {
        return fInput.getJdbcuser();
    }

    /**
     * Antタスクの[jdbcpassword]アトリビュートのセッターメソッド。
     *
     * 項目番号: 4<br>
     *
     * @param arg セットしたい値
     */
    public void setJdbcpassword(final String arg) {
        fInput.setJdbcpassword(arg);
        fIsFieldJdbcpasswordProcessed = true;
    }

    /**
     * Antタスクの[jdbcpassword]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 4<br>
     * 必須アトリビュートです。Apache Antタスク上で必ず値が指定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getJdbcpassword() {
        return fInput.getJdbcpassword();
    }

    /**
     * Antタスクの[schema]アトリビュートのセッターメソッド。
     *
     * 項目番号: 5<br>
     * スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。<br>
     *
     * @param arg セットしたい値
     */
    public void setSchema(final String arg) {
        fInput.setSchema(arg);
        fIsFieldSchemaProcessed = true;
    }

    /**
     * Antタスクの[schema]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 5<br>
     * スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。<br>
     *
     * @return このフィールドの値
     */
    public String getSchema() {
        return fInput.getSchema();
    }

    /**
     * Antタスクの[table]アトリビュートのセッターメソッド。
     *
     * 項目番号: 6<br>
     * 指定された場合には、その表のみを処理します。<br>
     *
     * @param arg セットしたい値
     */
    public void setTable(final String arg) {
        fInput.setTable(arg);
        fIsFieldTableProcessed = true;
    }

    /**
     * Antタスクの[table]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 6<br>
     * 指定された場合には、その表のみを処理します。<br>
     *
     * @return このフィールドの値
     */
    public String getTable() {
        return fInput.getTable();
    }

    /**
     * Antタスクの[targetdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 7<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTargetdir(final String arg) {
        fInput.setTargetdir(arg);
        fIsFieldTargetdirProcessed = true;
    }

    /**
     * Antタスクの[targetdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 7<br>
     * 出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。<br>
     * デフォルト値[blanco.db]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTargetdir() {
        return fInput.getTargetdir();
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのセッターメソッド。
     *
     * 項目番号: 8<br>
     * テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。<br>
     *
     * @param arg セットしたい値
     */
    public void setTmpdir(final String arg) {
        fInput.setTmpdir(arg);
        fIsFieldTmpdirProcessed = true;
    }

    /**
     * Antタスクの[tmpdir]アトリビュートのゲッターメソッド。
     *
     * 項目番号: 8<br>
     * テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。<br>
     * デフォルト値[tmp]が設定されています。Apache Antタスク上でアトリビュートの指定が無い場合には、デフォルト値が設定されます。<br>
     *
     * @return このフィールドの値
     */
    public String getTmpdir() {
        return fInput.getTmpdir();
    }

    /**
     * Antタスクのメイン処理。Apache Antから このメソッドが呼び出されます。
     *
     * @throws BuildException タスクとしての例外が発生した場合。
     */
    @Override
    public final void execute() throws BuildException {
        System.out.println("BlancoDbMetaDataMeta2CsvTask begin.");

        // 項目番号[1]、アトリビュート[jdbcdriver]は必須入力です。入力チェックを行います。
        if (fIsFieldJdbcdriverProcessed == false) {
            throw new BuildException("必須アトリビュート[jdbcdriver]が設定されていません。処理を中断します。");
        }
        // 項目番号[2]、アトリビュート[jdbcurl]は必須入力です。入力チェックを行います。
        if (fIsFieldJdbcurlProcessed == false) {
            throw new BuildException("必須アトリビュート[jdbcurl]が設定されていません。処理を中断します。");
        }
        // 項目番号[3]、アトリビュート[jdbcuser]は必須入力です。入力チェックを行います。
        if (fIsFieldJdbcuserProcessed == false) {
            throw new BuildException("必須アトリビュート[jdbcuser]が設定されていません。処理を中断します。");
        }
        // 項目番号[4]、アトリビュート[jdbcpassword]は必須入力です。入力チェックを行います。
        if (fIsFieldJdbcpasswordProcessed == false) {
            throw new BuildException("必須アトリビュート[jdbcpassword]が設定されていません。処理を中断します。");
        }

        if (getVerbose()) {
            System.out.println("- verbose:[true]");
            System.out.println("- jdbcdriver:[" + getJdbcdriver() + "]");
            System.out.println("- jdbcurl:[" + getJdbcurl() + "]");
            System.out.println("- jdbcuser:[" + getJdbcuser() + "]");
            System.out.println("- jdbcpassword:[" + getJdbcpassword() + "]");
            System.out.println("- schema:[" + getSchema() + "]");
            System.out.println("- table:[" + getTable() + "]");
            System.out.println("- targetdir:[" + getTargetdir() + "]");
            System.out.println("- tmpdir:[" + getTmpdir() + "]");
        }

        try {
            // 実際のAntタスクの主処理を実行します。
            // この箇所でコンパイルエラーが発生する場合、BlancoDbMetaDataMeta2CsvProcessインタフェースを実装して blanco.dbmetadata.taskパッケージに BlancoDbMetaDataMeta2CsvProcessImplクラスを作成することにより解決できる場合があります。
            final BlancoDbMetaDataMeta2CsvProcess proc = new BlancoDbMetaDataMeta2CsvProcessImpl();
            if (proc.execute(fInput) != BlancoDbMetaDataMeta2CsvBatchProcess.END_SUCCESS) {
                throw new BuildException("タスクは異常終了しました。");
            }
        } catch (IllegalArgumentException e) {
            if (getVerbose()) {
                e.printStackTrace();
            }
            throw new BuildException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中に例外が発生しました。処理を中断します。" + e.toString());
        } catch (Error e) {
            e.printStackTrace();
            throw new BuildException("タスクを処理中にエラーが発生しました。処理を中断します。" + e.toString());
        }
    }
}
