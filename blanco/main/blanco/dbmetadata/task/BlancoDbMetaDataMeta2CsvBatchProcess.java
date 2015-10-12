/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.task;

import java.io.IOException;

import blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput;

/**
 * バッチ処理クラス [BlancoDbMetaDataMeta2CsvBatchProcess]。
 *
 * <P>バッチ処理の呼び出し例。</P>
 * <code>
 * java -classpath (クラスパス) blanco.dbmetadata.task.BlancoDbMetaDataMeta2CsvBatchProcess -help
 * </code>
 */
public class BlancoDbMetaDataMeta2CsvBatchProcess {
    /**
     * 正常終了。
     */
    public static final int END_SUCCESS = 0;

    /**
     * 入力異常終了。内部的にjava.lang.IllegalArgumentExceptionが発生した場合。
     */
    public static final int END_ILLEGAL_ARGUMENT_EXCEPTION = 7;

    /**
     * 入出力例外終了。内部的にjava.io.IOExceptionが発生した場合。
     */
    public static final int END_IO_EXCEPTION = 8;

    /**
     * 異常終了。バッチの処理開始に失敗した場合、および内部的にjava.lang.Errorまたはjava.lang.RuntimeExceptionが発生した場合。
     */
    public static final int END_ERROR = 9;

    /**
     * コマンドラインから実行された際のエントリポイントです。
     *
     * @param args コンソールから引き継がれた引数。
     */
    public static final void main(final String[] args) {
        final BlancoDbMetaDataMeta2CsvBatchProcess batchProcess = new BlancoDbMetaDataMeta2CsvBatchProcess();

        // バッチ処理の引数。
        final BlancoDbMetaDataMeta2CsvProcessInput input = new BlancoDbMetaDataMeta2CsvProcessInput();

        boolean isNeedUsage = false;
        boolean isFieldJdbcdriverProcessed = false;
        boolean isFieldJdbcurlProcessed = false;
        boolean isFieldJdbcuserProcessed = false;
        boolean isFieldJdbcpasswordProcessed = false;

        // コマンドライン引数の解析をおこないます。
        for (int index = 0; index < args.length; index++) {
            String arg = args[index];
            if (arg.startsWith("-verbose=")) {
                input.setVerbose(Boolean.valueOf(arg.substring(9)).booleanValue());
            } else if (arg.startsWith("-jdbcdriver=")) {
                input.setJdbcdriver(arg.substring(12));
                isFieldJdbcdriverProcessed = true;
            } else if (arg.startsWith("-jdbcurl=")) {
                input.setJdbcurl(arg.substring(9));
                isFieldJdbcurlProcessed = true;
            } else if (arg.startsWith("-jdbcuser=")) {
                input.setJdbcuser(arg.substring(10));
                isFieldJdbcuserProcessed = true;
            } else if (arg.startsWith("-jdbcpassword=")) {
                input.setJdbcpassword(arg.substring(14));
                isFieldJdbcpasswordProcessed = true;
            } else if (arg.startsWith("-schema=")) {
                input.setSchema(arg.substring(8));
            } else if (arg.startsWith("-table=")) {
                input.setTable(arg.substring(7));
            } else if (arg.startsWith("-targetdir=")) {
                input.setTargetdir(arg.substring(11));
            } else if (arg.startsWith("-tmpdir=")) {
                input.setTmpdir(arg.substring(8));
            } else if (arg.equals("-?") || arg.equals("-help")) {
                usage();
                System.exit(END_SUCCESS);
            } else {
                System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 入力パラメータ[" + arg + "]は無視されました。");
                isNeedUsage = true;
            }
        }

        if (isNeedUsage) {
            usage();
        }

        if( isFieldJdbcdriverProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcdriver]に値が設定されていません。");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcurlProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcurl]に値が設定されていません。");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcuserProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcuser]に値が設定されていません。");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcpasswordProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcpassword]に値が設定されていません。");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }

        int retCode = batchProcess.execute(input);

        // 終了コードを戻します。
        // ※注意：System.exit()を呼び出している点に注意してください。
        System.exit(retCode);
    }

    /**
     * 具体的なバッチ処理内容を記述するためのメソッドです。
     *
     * このメソッドに実際の処理内容を記述します。
     *
     * @param input バッチ処理の入力パラメータ。
     * @return バッチ処理の終了コード。END_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR のいずれかの値を戻します。
     * @throws IOException 入出力例外が発生した場合。
     * @throws IllegalArgumentException 入力値に不正が見つかった場合。
     */
    public int process(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IOException, IllegalArgumentException {
        // 入力パラメータをチェックします。
        validateInput(input);

        // この箇所でコンパイルエラーが発生する場合、BlancoDbMetaDataMeta2CsvProcessインタフェースを実装して blanco.dbmetadata.taskパッケージに BlancoDbMetaDataMeta2CsvProcessImplクラスを作成することにより解決できる場合があります。
        final BlancoDbMetaDataMeta2CsvProcess process = new BlancoDbMetaDataMeta2CsvProcessImpl();

        // 処理の本体を実行します。
        final int retCode = process.execute(input);

        return retCode;
    }

    /**
     * クラスをインスタンス化してバッチを実行する際のエントリポイントです。
     *
     * このメソッドは下記の仕様を提供します。
     * <ul>
     * <li>メソッドの入力パラメータの内容チェック。
     * <li>IllegalArgumentException, RuntimeException, Errorなどの例外をcatchして戻り値へと変換。
     * </ul>
     *
     * @param input バッチ処理の入力パラメータ。
     * @return バッチ処理の終了コード。END_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR のいずれかの値を戻します。
     * @throws IllegalArgumentException 入力値に不正が見つかった場合。
     */
    public final int execute(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IllegalArgumentException {
        try {
            // バッチ処理の本体を実行します。
            int retCode = process(input);

            return retCode;
        } catch (IllegalArgumentException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 入力例外が発生しました。バッチ処理を中断します。:" + ex.toString());
            // 入力異常終了。
            return END_ILLEGAL_ARGUMENT_EXCEPTION;
        } catch (IOException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: 入出力例外が発生しました。バッチ処理を中断します。:" + ex.toString());
            // 入力異常終了。
            return END_IO_EXCEPTION;
        } catch (RuntimeException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: ランタイム例外が発生しました。バッチ処理を中断します。:" + ex.toString());
            ex.printStackTrace();
            // 異常終了。
            return END_ERROR;
        } catch (Error er) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: ランタイムエラーが発生しました。バッチ処理を中断します。:" + er.toString());
            er.printStackTrace();
            // 異常終了。
            return END_ERROR;
        }
    }

    /**
     * このバッチ処理クラスの使い方の説明を標準出力に示すためのメソッドです。
     */
    public static final void usage() {
        System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: Usage:");
        System.out.println("  java blanco.dbmetadata.task.BlancoDbMetaDataMeta2CsvBatchProcess -verbose=値1 -jdbcdriver=値2 -jdbcurl=値3 -jdbcuser=値4 -jdbcpassword=値5 -schema=値6 -table=値7 -targetdir=値8 -tmpdir=値9");
        System.out.println("    -verbose");
        System.out.println("      説明[verboseモードで動作させるかどうか。]");
        System.out.println("      型[真偽]");
        System.out.println("      デフォルト値[false]");
        System.out.println("    -jdbcdriver");
        System.out.println("      説明[JDBCドライバ名を指定します。]");
        System.out.println("      型[文字列]");
        System.out.println("      必須パラメータ");
        System.out.println("    -jdbcurl");
        System.out.println("      説明[JDBC接続先URLを指定します。]");
        System.out.println("      型[文字列]");
        System.out.println("      必須パラメータ");
        System.out.println("    -jdbcuser");
        System.out.println("      型[文字列]");
        System.out.println("      必須パラメータ");
        System.out.println("    -jdbcpassword");
        System.out.println("      型[文字列]");
        System.out.println("      必須パラメータ");
        System.out.println("    -schema");
        System.out.println("      説明[スキーマ情報。Oracleの場合にはユーザ名を与える必要があります。]");
        System.out.println("      型[文字列]");
        System.out.println("    -table");
        System.out.println("      説明[指定された場合には、その表のみを処理します。]");
        System.out.println("      型[文字列]");
        System.out.println("    -targetdir");
        System.out.println("      説明[出力先フォルダを指定します。無指定の場合にはカレント直下のblancoを用います。]");
        System.out.println("      型[文字列]");
        System.out.println("      デフォルト値[blanco.db]");
        System.out.println("    -tmpdir");
        System.out.println("      説明[テンポラリディレクトリを指定します。無指定の場合にはカレント直下のtmpを用います。]");
        System.out.println("      型[文字列]");
        System.out.println("      デフォルト値[tmp]");
        System.out.println("    -? , -help");
        System.out.println("      説明[使い方を表示します。]");
    }

    /**
     * このバッチ処理クラスの入力パラメータの妥当性チェックを実施するためのメソッドです。
     *
     * @param input バッチ処理の入力パラメータ。
     * @throws IllegalArgumentException 入力値に不正が見つかった場合。
     */
    public void validateInput(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("BlancoBatchProcessBatchProcess: 処理開始失敗。入力パラメータ[input]にnullが与えられました。");
        }
        if (input.getJdbcdriver() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcdriver]に値が設定されていません。");
        }
        if (input.getJdbcurl() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcurl]に値が設定されていません。");
        }
        if (input.getJdbcuser() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcuser]に値が設定されていません。");
        }
        if (input.getJdbcpassword() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: 処理開始失敗。入力パラメータ[input]の必須フィールド値[jdbcpassword]に値が設定されていません。");
        }
    }
}
