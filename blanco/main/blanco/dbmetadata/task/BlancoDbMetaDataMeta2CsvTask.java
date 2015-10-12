/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.task;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import blanco.dbmetadata.task.valueobject.BlancoDbMetaDataMeta2CsvProcessInput;

/**
 * Apache Ant�^�X�N [BlancoDbMetaDataMeta2Csv]�̃N���X�B
 *
 * �f�[�^�x�[�X���^��񂩂�CSV�������������邽�߂�AntTask�ł��B<br>
 * ���̃N���X�ł́AApache Ant�^�X�N�ň�ʓI�ɕK�v�ȃ`�F�b�N�Ȃǂ̃R�[�f�B���O�������肵�܂��B
 * ���ۂ̏����� �p�b�P�[�W[blanco.dbmetadata.task]��BlancoDbMetaDataMeta2CsvBatchProcess�N���X���쐬���ċL�q���Ă��������B<br>
 * <br>
 * Ant�^�X�N�ւ̑g�ݍ��ݗ�<br>
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
     * �f�[�^�x�[�X���^��񂩂�CSV�������������邽�߂�AntTask�ł��B
     */
    protected BlancoDbMetaDataMeta2CsvProcessInput fInput = new BlancoDbMetaDataMeta2CsvProcessInput();

    /**
     * �t�B�[���h [jdbcdriver] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldJdbcdriverProcessed = false;

    /**
     * �t�B�[���h [jdbcurl] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldJdbcurlProcessed = false;

    /**
     * �t�B�[���h [jdbcuser] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldJdbcuserProcessed = false;

    /**
     * �t�B�[���h [jdbcpassword] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldJdbcpasswordProcessed = false;

    /**
     * �t�B�[���h [schema] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldSchemaProcessed = false;

    /**
     * �t�B�[���h [table] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldTableProcessed = false;

    /**
     * �t�B�[���h [targetdir] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldTargetdirProcessed = false;

    /**
     * �t�B�[���h [tmpdir] �ɒl���Z�b�g���ꂽ���ǂ����B
     */
    protected boolean fIsFieldTmpdirProcessed = false;

    /**
     * verbose���[�h�œ��삳���邩�ǂ����B
     *
     * @param arg verbose���[�h�œ��삳���邩�ǂ����B
     */
    public void setVerbose(final boolean arg) {
        fInput.setVerbose(arg);
    }

    /**
     * verbose���[�h�œ��삳���邩�ǂ����B
     *
     * @return verbose���[�h�œ��삳���邩�ǂ����B
     */
    public boolean getVerbose() {
        return fInput.getVerbose();
    }

    /**
     * Ant�^�X�N��[jdbcdriver]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 1<br>
     * JDBC�h���C�o�����w�肵�܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setJdbcdriver(final String arg) {
        fInput.setJdbcdriver(arg);
        fIsFieldJdbcdriverProcessed = true;
    }

    /**
     * Ant�^�X�N��[jdbcdriver]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 1<br>
     * JDBC�h���C�o�����w�肵�܂��B<br>
     * �K�{�A�g���r���[�g�ł��BApache Ant�^�X�N��ŕK���l���w�肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getJdbcdriver() {
        return fInput.getJdbcdriver();
    }

    /**
     * Ant�^�X�N��[jdbcurl]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 2<br>
     * JDBC�ڑ���URL���w�肵�܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setJdbcurl(final String arg) {
        fInput.setJdbcurl(arg);
        fIsFieldJdbcurlProcessed = true;
    }

    /**
     * Ant�^�X�N��[jdbcurl]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 2<br>
     * JDBC�ڑ���URL���w�肵�܂��B<br>
     * �K�{�A�g���r���[�g�ł��BApache Ant�^�X�N��ŕK���l���w�肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getJdbcurl() {
        return fInput.getJdbcurl();
    }

    /**
     * Ant�^�X�N��[jdbcuser]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 3<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setJdbcuser(final String arg) {
        fInput.setJdbcuser(arg);
        fIsFieldJdbcuserProcessed = true;
    }

    /**
     * Ant�^�X�N��[jdbcuser]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 3<br>
     * �K�{�A�g���r���[�g�ł��BApache Ant�^�X�N��ŕK���l���w�肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getJdbcuser() {
        return fInput.getJdbcuser();
    }

    /**
     * Ant�^�X�N��[jdbcpassword]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 4<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setJdbcpassword(final String arg) {
        fInput.setJdbcpassword(arg);
        fIsFieldJdbcpasswordProcessed = true;
    }

    /**
     * Ant�^�X�N��[jdbcpassword]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 4<br>
     * �K�{�A�g���r���[�g�ł��BApache Ant�^�X�N��ŕK���l���w�肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getJdbcpassword() {
        return fInput.getJdbcpassword();
    }

    /**
     * Ant�^�X�N��[schema]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 5<br>
     * �X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setSchema(final String arg) {
        fInput.setSchema(arg);
        fIsFieldSchemaProcessed = true;
    }

    /**
     * Ant�^�X�N��[schema]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 5<br>
     * �X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getSchema() {
        return fInput.getSchema();
    }

    /**
     * Ant�^�X�N��[table]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 6<br>
     * �w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setTable(final String arg) {
        fInput.setTable(arg);
        fIsFieldTableProcessed = true;
    }

    /**
     * Ant�^�X�N��[table]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 6<br>
     * �w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getTable() {
        return fInput.getTable();
    }

    /**
     * Ant�^�X�N��[targetdir]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 7<br>
     * �o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setTargetdir(final String arg) {
        fInput.setTargetdir(arg);
        fIsFieldTargetdirProcessed = true;
    }

    /**
     * Ant�^�X�N��[targetdir]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 7<br>
     * �o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B<br>
     * �f�t�H���g�l[blanco.db]���ݒ肳��Ă��܂��BApache Ant�^�X�N��ŃA�g���r���[�g�̎w�肪�����ꍇ�ɂ́A�f�t�H���g�l���ݒ肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getTargetdir() {
        return fInput.getTargetdir();
    }

    /**
     * Ant�^�X�N��[tmpdir]�A�g���r���[�g�̃Z�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 8<br>
     * �e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B<br>
     *
     * @param arg �Z�b�g�������l
     */
    public void setTmpdir(final String arg) {
        fInput.setTmpdir(arg);
        fIsFieldTmpdirProcessed = true;
    }

    /**
     * Ant�^�X�N��[tmpdir]�A�g���r���[�g�̃Q�b�^�[���\�b�h�B
     *
     * ���ڔԍ�: 8<br>
     * �e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B<br>
     * �f�t�H���g�l[tmp]���ݒ肳��Ă��܂��BApache Ant�^�X�N��ŃA�g���r���[�g�̎w�肪�����ꍇ�ɂ́A�f�t�H���g�l���ݒ肳��܂��B<br>
     *
     * @return ���̃t�B�[���h�̒l
     */
    public String getTmpdir() {
        return fInput.getTmpdir();
    }

    /**
     * Ant�^�X�N�̃��C�������BApache Ant���� ���̃��\�b�h���Ăяo����܂��B
     *
     * @throws BuildException �^�X�N�Ƃ��Ă̗�O�����������ꍇ�B
     */
    @Override
    public final void execute() throws BuildException {
        System.out.println("BlancoDbMetaDataMeta2CsvTask begin.");

        // ���ڔԍ�[1]�A�A�g���r���[�g[jdbcdriver]�͕K�{���͂ł��B���̓`�F�b�N���s���܂��B
        if (fIsFieldJdbcdriverProcessed == false) {
            throw new BuildException("�K�{�A�g���r���[�g[jdbcdriver]���ݒ肳��Ă��܂���B�����𒆒f���܂��B");
        }
        // ���ڔԍ�[2]�A�A�g���r���[�g[jdbcurl]�͕K�{���͂ł��B���̓`�F�b�N���s���܂��B
        if (fIsFieldJdbcurlProcessed == false) {
            throw new BuildException("�K�{�A�g���r���[�g[jdbcurl]���ݒ肳��Ă��܂���B�����𒆒f���܂��B");
        }
        // ���ڔԍ�[3]�A�A�g���r���[�g[jdbcuser]�͕K�{���͂ł��B���̓`�F�b�N���s���܂��B
        if (fIsFieldJdbcuserProcessed == false) {
            throw new BuildException("�K�{�A�g���r���[�g[jdbcuser]���ݒ肳��Ă��܂���B�����𒆒f���܂��B");
        }
        // ���ڔԍ�[4]�A�A�g���r���[�g[jdbcpassword]�͕K�{���͂ł��B���̓`�F�b�N���s���܂��B
        if (fIsFieldJdbcpasswordProcessed == false) {
            throw new BuildException("�K�{�A�g���r���[�g[jdbcpassword]���ݒ肳��Ă��܂���B�����𒆒f���܂��B");
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
            // ���ۂ�Ant�^�X�N�̎又�������s���܂��B
            // ���̉ӏ��ŃR���p�C���G���[����������ꍇ�ABlancoDbMetaDataMeta2CsvProcess�C���^�t�F�[�X���������� blanco.dbmetadata.task�p�b�P�[�W�� BlancoDbMetaDataMeta2CsvProcessImpl�N���X���쐬���邱�Ƃɂ������ł���ꍇ������܂��B
            final BlancoDbMetaDataMeta2CsvProcess proc = new BlancoDbMetaDataMeta2CsvProcessImpl();
            if (proc.execute(fInput) != BlancoDbMetaDataMeta2CsvBatchProcess.END_SUCCESS) {
                throw new BuildException("�^�X�N�ُ͈�I�����܂����B");
            }
        } catch (IllegalArgumentException e) {
            if (getVerbose()) {
                e.printStackTrace();
            }
            throw new BuildException(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BuildException("�^�X�N���������ɗ�O���������܂����B�����𒆒f���܂��B" + e.toString());
        } catch (Error e) {
            e.printStackTrace();
            throw new BuildException("�^�X�N���������ɃG���[���������܂����B�����𒆒f���܂��B" + e.toString());
        }
    }
}
