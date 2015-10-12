/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.task.valueobject;

/**
 * �����N���X [BlancoDbMetaDataMeta2CsvProcess]�̓��̓o�����[�I�u�W�F�N�g�N���X�ł��B
 */
public class BlancoDbMetaDataMeta2CsvProcessInput {
    /**
     * verbose���[�h�œ��삳���邩�ǂ����B
     *
     * �t�B�[���h: [verbose]�B
     * �f�t�H���g: [false]�B
     */
    private boolean fVerbose = false;

    /**
     * JDBC�h���C�o�����w�肵�܂��B
     *
     * �t�B�[���h: [jdbcdriver]�B
     */
    private String fJdbcdriver;

    /**
     * JDBC�ڑ���URL���w�肵�܂��B
     *
     * �t�B�[���h: [jdbcurl]�B
     */
    private String fJdbcurl;

    /**
     * �t�B�[���h: [jdbcuser]�B
     */
    private String fJdbcuser;

    /**
     * �t�B�[���h: [jdbcpassword]�B
     */
    private String fJdbcpassword;

    /**
     * �X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B
     *
     * �t�B�[���h: [schema]�B
     */
    private String fSchema;

    /**
     * �w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B
     *
     * �t�B�[���h: [table]�B
     */
    private String fTable;

    /**
     * �o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B
     *
     * �t�B�[���h: [targetdir]�B
     * �f�t�H���g: [blanco.db]�B
     */
    private String fTargetdir = "blanco.db";

    /**
     * �e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B
     *
     * �t�B�[���h: [tmpdir]�B
     * �f�t�H���g: [tmp]�B
     */
    private String fTmpdir = "tmp";

    /**
     * �t�B�[���h [verbose] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [verbose���[�h�œ��삳���邩�ǂ����B]�B
     *
     * @param argVerbose �t�B�[���h[verbose]�ɐݒ肷��l�B
     */
    public void setVerbose(final boolean argVerbose) {
        fVerbose = argVerbose;
    }

    /**
     * �t�B�[���h [verbose] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [verbose���[�h�œ��삳���邩�ǂ����B]�B
     * �f�t�H���g: [false]�B
     *
     * @return �t�B�[���h[verbose]����擾�����l�B
     */
    public boolean getVerbose() {
        return fVerbose;
    }

    /**
     * �t�B�[���h [jdbcdriver] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [JDBC�h���C�o�����w�肵�܂��B]�B
     *
     * @param argJdbcdriver �t�B�[���h[jdbcdriver]�ɐݒ肷��l�B
     */
    public void setJdbcdriver(final String argJdbcdriver) {
        fJdbcdriver = argJdbcdriver;
    }

    /**
     * �t�B�[���h [jdbcdriver] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [JDBC�h���C�o�����w�肵�܂��B]�B
     *
     * @return �t�B�[���h[jdbcdriver]����擾�����l�B
     */
    public String getJdbcdriver() {
        return fJdbcdriver;
    }

    /**
     * �t�B�[���h [jdbcurl] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [JDBC�ڑ���URL���w�肵�܂��B]�B
     *
     * @param argJdbcurl �t�B�[���h[jdbcurl]�ɐݒ肷��l�B
     */
    public void setJdbcurl(final String argJdbcurl) {
        fJdbcurl = argJdbcurl;
    }

    /**
     * �t�B�[���h [jdbcurl] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [JDBC�ڑ���URL���w�肵�܂��B]�B
     *
     * @return �t�B�[���h[jdbcurl]����擾�����l�B
     */
    public String getJdbcurl() {
        return fJdbcurl;
    }

    /**
     * �t�B�[���h [jdbcuser] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argJdbcuser �t�B�[���h[jdbcuser]�ɐݒ肷��l�B
     */
    public void setJdbcuser(final String argJdbcuser) {
        fJdbcuser = argJdbcuser;
    }

    /**
     * �t�B�[���h [jdbcuser] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[jdbcuser]����擾�����l�B
     */
    public String getJdbcuser() {
        return fJdbcuser;
    }

    /**
     * �t�B�[���h [jdbcpassword] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @param argJdbcpassword �t�B�[���h[jdbcpassword]�ɐݒ肷��l�B
     */
    public void setJdbcpassword(final String argJdbcpassword) {
        fJdbcpassword = argJdbcpassword;
    }

    /**
     * �t�B�[���h [jdbcpassword] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: []�B
     *
     * @return �t�B�[���h[jdbcpassword]����擾�����l�B
     */
    public String getJdbcpassword() {
        return fJdbcpassword;
    }

    /**
     * �t�B�[���h [schema] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B]�B
     *
     * @param argSchema �t�B�[���h[schema]�ɐݒ肷��l�B
     */
    public void setSchema(final String argSchema) {
        fSchema = argSchema;
    }

    /**
     * �t�B�[���h [schema] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�X�L�[�}���BOracle�̏ꍇ�ɂ̓��[�U����^����K�v������܂��B]�B
     *
     * @return �t�B�[���h[schema]����擾�����l�B
     */
    public String getSchema() {
        return fSchema;
    }

    /**
     * �t�B�[���h [table] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B]�B
     *
     * @param argTable �t�B�[���h[table]�ɐݒ肷��l�B
     */
    public void setTable(final String argTable) {
        fTable = argTable;
    }

    /**
     * �t�B�[���h [table] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�w�肳�ꂽ�ꍇ�ɂ́A���̕\�݂̂��������܂��B]�B
     *
     * @return �t�B�[���h[table]����擾�����l�B
     */
    public String getTable() {
        return fTable;
    }

    /**
     * �t�B�[���h [targetdir] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B]�B
     *
     * @param argTargetdir �t�B�[���h[targetdir]�ɐݒ肷��l�B
     */
    public void setTargetdir(final String argTargetdir) {
        fTargetdir = argTargetdir;
    }

    /**
     * �t�B�[���h [targetdir] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�o�͐�t�H���_���w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������blanco��p���܂��B]�B
     * �f�t�H���g: [blanco.db]�B
     *
     * @return �t�B�[���h[targetdir]����擾�����l�B
     */
    public String getTargetdir() {
        return fTargetdir;
    }

    /**
     * �t�B�[���h [tmpdir] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B]�B
     *
     * @param argTmpdir �t�B�[���h[tmpdir]�ɐݒ肷��l�B
     */
    public void setTmpdir(final String argTmpdir) {
        fTmpdir = argTmpdir;
    }

    /**
     * �t�B�[���h [tmpdir] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�e���|�����f�B���N�g�����w�肵�܂��B���w��̏ꍇ�ɂ̓J�����g������tmp��p���܂��B]�B
     * �f�t�H���g: [tmp]�B
     *
     * @return �t�B�[���h[tmpdir]����擾�����l�B
     */
    public String getTmpdir() {
        return fTmpdir;
    }

    /**
     * ���̃o�����[�I�u�W�F�N�g�̕�����\�����擾���܂��B
     *
     * <P>�g�p��̒���</P>
     * <UL>
     * <LI>�I�u�W�F�N�g�̃V�����[�͈͂̂ݕ����񉻂̏����ΏۂƂȂ�܂��B
     * <LI>�I�u�W�F�N�g���z�Q�Ƃ��Ă���ꍇ�ɂ́A���̃��\�b�h�͎g��Ȃ��ł��������B
     * </UL>
     *
     * @return �o�����[�I�u�W�F�N�g�̕�����\���B
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
