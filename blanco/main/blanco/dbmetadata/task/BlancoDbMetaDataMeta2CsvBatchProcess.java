/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.task;

import java.io.IOException;

import blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput;

/**
 * �o�b�`�����N���X [BlancoDbMetaDataMeta2CsvBatchProcess]�B
 *
 * <P>�o�b�`�����̌Ăяo����B</P>
 * <code>
 * java -classpath (�N���X�p�X) blanco.dbmetadata.task.BlancoDbMetaDataMeta2CsvBatchProcess -help
 * </code>
 */
public class BlancoDbMetaDataMeta2CsvBatchProcess {
    /**
     * ����I���B
     */
    public static final int END_SUCCESS = 0;

    /**
     * ���ُ͈�I���B�����I��java.lang.IllegalArgumentException�����������ꍇ�B
     */
    public static final int END_ILLEGAL_ARGUMENT_EXCEPTION = 7;

    /**
     * ���o�͗�O�I���B�����I��java.io.IOException�����������ꍇ�B
     */
    public static final int END_IO_EXCEPTION = 8;

    /**
     * �ُ�I���B�o�b�`�̏����J�n�Ɏ��s�����ꍇ�A����ѓ����I��java.lang.Error�܂���java.lang.RuntimeException�����������ꍇ�B
     */
    public static final int END_ERROR = 9;

    /**
     * �R�}���h���C��������s���ꂽ�ۂ̃G���g���|�C���g�ł��B
     *
     * @param args �R���\�[����������p���ꂽ�����B
     */
    public static final void main(final String[] args) {
        final BlancoDbMetaDataMeta2CsvBatchProcess batchProcess = new BlancoDbMetaDataMeta2CsvBatchProcess();

        // �o�b�`�����̈����B
        final BlancoDbMetaDataMeta2CsvProcessInput input = new BlancoDbMetaDataMeta2CsvProcessInput();

        boolean isNeedUsage = false;
        boolean isFieldJdbcdriverProcessed = false;
        boolean isFieldJdbcurlProcessed = false;
        boolean isFieldJdbcuserProcessed = false;
        boolean isFieldJdbcpasswordProcessed = false;

        // �R�}���h���C�������̉�͂������Ȃ��܂��B
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
                System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: ���̓p�����[�^[" + arg + "]�͖�������܂����B");
                isNeedUsage = true;
            }
        }

        if (isNeedUsage) {
            usage();
        }

        if( isFieldJdbcdriverProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcdriver]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcurlProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcurl]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcuserProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcuser]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }
        if( isFieldJdbcpasswordProcessed == false) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcpassword]�ɒl���ݒ肳��Ă��܂���B");
            System.exit(END_ILLEGAL_ARGUMENT_EXCEPTION);
        }

        int retCode = batchProcess.execute(input);

        // �I���R�[�h��߂��܂��B
        // �����ӁFSystem.exit()���Ăяo���Ă���_�ɒ��ӂ��Ă��������B
        System.exit(retCode);
    }

    /**
     * ��̓I�ȃo�b�`�������e���L�q���邽�߂̃��\�b�h�ł��B
     *
     * ���̃��\�b�h�Ɏ��ۂ̏������e���L�q���܂��B
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR �̂����ꂩ�̒l��߂��܂��B
     * @throws IOException ���o�͗�O�����������ꍇ�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public int process(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IOException, IllegalArgumentException {
        // ���̓p�����[�^���`�F�b�N���܂��B
        validateInput(input);

        // ���̉ӏ��ŃR���p�C���G���[����������ꍇ�ABlancoDbMetaDataMeta2CsvProcess�C���^�t�F�[�X���������� blanco.dbmetadata.task�p�b�P�[�W�� BlancoDbMetaDataMeta2CsvProcessImpl�N���X���쐬���邱�Ƃɂ������ł���ꍇ������܂��B
        final BlancoDbMetaDataMeta2CsvProcess process = new BlancoDbMetaDataMeta2CsvProcessImpl();

        // �����̖{�̂����s���܂��B
        final int retCode = process.execute(input);

        return retCode;
    }

    /**
     * �N���X���C���X�^���X�����ăo�b�`�����s����ۂ̃G���g���|�C���g�ł��B
     *
     * ���̃��\�b�h�͉��L�̎d�l��񋟂��܂��B
     * <ul>
     * <li>���\�b�h�̓��̓p�����[�^�̓��e�`�F�b�N�B
     * <li>IllegalArgumentException, RuntimeException, Error�Ȃǂ̗�O��catch���Ė߂�l�ւƕϊ��B
     * </ul>
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @return �o�b�`�����̏I���R�[�h�BEND_SUCCESS, END_ILLEGAL_ARGUMENT_EXCEPTION, END_IO_EXCEPTION, END_ERROR �̂����ꂩ�̒l��߂��܂��B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public final int execute(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IllegalArgumentException {
        try {
            // �o�b�`�����̖{�̂����s���܂��B
            int retCode = process(input);

            return retCode;
        } catch (IllegalArgumentException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: ���͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_ILLEGAL_ARGUMENT_EXCEPTION;
        } catch (IOException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: ���o�͗�O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            // ���ُ͈�I���B
            return END_IO_EXCEPTION;
        } catch (RuntimeException ex) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����^�C����O���������܂����B�o�b�`�����𒆒f���܂��B:" + ex.toString());
            ex.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        } catch (Error er) {
            System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: �����^�C���G���[���������܂����B�o�b�`�����𒆒f���܂��B:" + er.toString());
            er.printStackTrace();
            // �ُ�I���B
            return END_ERROR;
        }
    }

    /**
     * ���̃o�b�`�����N���X�̎g�����̐�����W���o�͂Ɏ������߂̃��\�b�h�ł��B
     */
    public static final void usage() {
        System.out.println("BlancoDbMetaDataMeta2CsvBatchProcess: Usage:");
        System.out.println("  java blanco.dbmetadata.task.BlancoDbMetaDataMeta2CsvBatchProcess -verbose=�l1 -jdbcdriver=�l2 -jdbcurl=�l3 -jdbcuser=�l4 -jdbcpassword=�l5 -schema=�l6 -table=�l7 -targetdir=�l8 -tmpdir=�l9");
        System.out.println("    -verbose");
        System.out.println("      ����[verbose���[�h�œ��삳���邩�ǂ����B]");
        System.out.println("      �^[�^�U]");
        System.out.println("      �f�t�H���g�l[false]");
        System.out.println("    -jdbcdriver");
        System.out.println("      ����[JDBC�h���C�o�����w�肵�܂��B]");
        System.out.println("      �^[������]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -jdbcurl");
        System.out.println("      ����[JDBC�ڑ���URL���w�肵�܂��B]");
        System.out.println("      �^[������]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -jdbcuser");
        System.out.println("      �^[������]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -jdbcpassword");
        System.out.println("      �^[������]");
        System.out.println("      �K�{�p�����[�^");
        System.out.println("    -schema");
        System.out.println("      ����[�X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B]");
        System.out.println("      �^[������]");
        System.out.println("    -table");
        System.out.println("      ����[�w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B]");
        System.out.println("      �^[������]");
        System.out.println("    -targetdir");
        System.out.println("      ����[�o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B]");
        System.out.println("      �^[������]");
        System.out.println("      �f�t�H���g�l[blanco.db]");
        System.out.println("    -tmpdir");
        System.out.println("      ����[�e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B]");
        System.out.println("      �^[������]");
        System.out.println("      �f�t�H���g�l[tmp]");
        System.out.println("    -? , -help");
        System.out.println("      ����[�g������\�����܂��B]");
    }

    /**
     * ���̃o�b�`�����N���X�̓��̓p�����[�^�̑Ó����`�F�b�N�����{���邽�߂̃��\�b�h�ł��B
     *
     * @param input �o�b�`�����̓��̓p�����[�^�B
     * @throws IllegalArgumentException ���͒l�ɕs�������������ꍇ�B
     */
    public void validateInput(final BlancoDbMetaDataMeta2CsvProcessInput input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("BlancoBatchProcessBatchProcess: �����J�n���s�B���̓p�����[�^[input]��null���^�����܂����B");
        }
        if (input.getJdbcdriver() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcdriver]�ɒl���ݒ肳��Ă��܂���B");
        }
        if (input.getJdbcurl() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcurl]�ɒl���ݒ肳��Ă��܂���B");
        }
        if (input.getJdbcuser() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcuser]�ɒl���ݒ肳��Ă��܂���B");
        }
        if (input.getJdbcpassword() == null) {
            throw new IllegalArgumentException("BlancoDbMetaDataMeta2CsvBatchProcess: �����J�n���s�B���̓p�����[�^[input]�̕K�{�t�B�[���h�l[jdbcpassword]�ɒl���ݒ肳��Ă��܂���B");
        }
    }
}
