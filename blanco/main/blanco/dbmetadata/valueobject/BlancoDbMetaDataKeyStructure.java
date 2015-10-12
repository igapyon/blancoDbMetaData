/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.valueobject;

/**
 * �L�[�Ɋւ�������i�[���܂��Bjava.sql.DatabaseMetaData.getImportedKeys �Ajava.sql.DatabaseMetaData.getExportedKeys �A java.sql.DatabaseMetaData.getPrimaryKeys �̖߂�l���i�[���܂��B
 */
public class BlancoDbMetaDataKeyStructure {
    /**
     * ��L�[�̕\�J�^���O�B
     *
     * �t�B�[���h: [PKTABLE_CAT]�B
     */
    private String fPktableCat;

    /**
     * ��L�[�̕\�X�L�[�}�B
     *
     * �t�B�[���h: [PKTABLE_SCHEM]�B
     */
    private String fPktableSchem;

    /**
     * ��L�[�̕\���B
     *
     * �t�B�[���h: [PKTABLE_NAME]�B
     */
    private String fPktableName;

    /**
     * PKCOLUMN_NAME�A�܂���COLUMN_NAME: ��L�[�̗񖼁Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��BCOLUMN_NAME���i�[����܂��B
     *
     * �t�B�[���h: [PKCOLUMN_NAME]�B
     */
    private String fPkcolumnName;

    /**
     * �O���L�[�̕\�J�^���O�B
     *
     * �t�B�[���h: [FKTABLE_CAT]�B
     */
    private String fFktableCat;

    /**
     * �O���L�[�̕\�X�L�[�}�B
     *
     * �t�B�[���h: [FKTABLE_SCHEM]�B
     */
    private String fFktableSchem;

    /**
     * �O���L�[�̕\���B
     *
     * �t�B�[���h: [FKTABLE_NAME]�B
     */
    private String fFktableName;

    /**
     * �O���L�[�̗񖼁B
     *
     * �t�B�[���h: [FKCOLUMN_NAME]�B
     */
    private String fFkcolumnName;

    /**
     * KEY_SEQ: �L�[�̂Ȃ��̘A�ԁBjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B
     *
     * �t�B�[���h: [KEY_SEQ]�B
     */
    private short fKeySeq;

    /**
     * �t�B�[���h: [UPDATE_RULE]�B
     */
    private short fUpdateRule;

    /**
     * �t�B�[���h: [DELETE_RULE]�B
     */
    private short fDeleteRule;

    /**
     * �O���L�[���B
     *
     * �t�B�[���h: [FK_NAME]�B
     */
    private String fFkName;

    /**
     * PK_NAME: ��L�[���Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B
     *
     * �t�B�[���h: [PK_NAME]�B
     */
    private String fPkName;

    /**
     * �t�B�[���h: [DEFERRABILITY]�B
     */
    private short fDeferrability;

    /**
     * �t�B�[���h [PKTABLE_CAT] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\�J�^���O�B]�B
     *
     * @param argPktableCat �t�B�[���h[PKTABLE_CAT]�ɐݒ肷��l�B
     */
    public void setPktableCat(final String argPktableCat) {
        fPktableCat = argPktableCat;
    }

    /**
     * �t�B�[���h [PKTABLE_CAT] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\�J�^���O�B]�B
     *
     * @return �t�B�[���h[PKTABLE_CAT]����擾�����l�B
     */
    public String getPktableCat() {
        return fPktableCat;
    }

    /**
     * �t�B�[���h [PKTABLE_SCHEM] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\�X�L�[�}�B]�B
     *
     * @param argPktableSchem �t�B�[���h[PKTABLE_SCHEM]�ɐݒ肷��l�B
     */
    public void setPktableSchem(final String argPktableSchem) {
        fPktableSchem = argPktableSchem;
    }

    /**
     * �t�B�[���h [PKTABLE_SCHEM] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\�X�L�[�}�B]�B
     *
     * @return �t�B�[���h[PKTABLE_SCHEM]����擾�����l�B
     */
    public String getPktableSchem() {
        return fPktableSchem;
    }

    /**
     * �t�B�[���h [PKTABLE_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\���B]�B
     *
     * @param argPktableName �t�B�[���h[PKTABLE_NAME]�ɐݒ肷��l�B
     */
    public void setPktableName(final String argPktableName) {
        fPktableName = argPktableName;
    }

    /**
     * �t�B�[���h [PKTABLE_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [��L�[�̕\���B]�B
     *
     * @return �t�B�[���h[PKTABLE_NAME]����擾�����l�B
     */
    public String getPktableName() {
        return fPktableName;
    }

    /**
     * �t�B�[���h [PKCOLUMN_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [PKCOLUMN_NAME�A�܂���COLUMN_NAME: ��L�[�̗񖼁Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��BCOLUMN_NAME���i�[����܂��B]�B
     *
     * @param argPkcolumnName �t�B�[���h[PKCOLUMN_NAME]�ɐݒ肷��l�B
     */
    public void setPkcolumnName(final String argPkcolumnName) {
        fPkcolumnName = argPkcolumnName;
    }

    /**
     * �t�B�[���h [PKCOLUMN_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [PKCOLUMN_NAME�A�܂���COLUMN_NAME: ��L�[�̗񖼁Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��BCOLUMN_NAME���i�[����܂��B]�B
     *
     * @return �t�B�[���h[PKCOLUMN_NAME]����擾�����l�B
     */
    public String getPkcolumnName() {
        return fPkcolumnName;
    }

    /**
     * �t�B�[���h [FKTABLE_CAT] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\�J�^���O�B]�B
     *
     * @param argFktableCat �t�B�[���h[FKTABLE_CAT]�ɐݒ肷��l�B
     */
    public void setFktableCat(final String argFktableCat) {
        fFktableCat = argFktableCat;
    }

    /**
     * �t�B�[���h [FKTABLE_CAT] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\�J�^���O�B]�B
     *
     * @return �t�B�[���h[FKTABLE_CAT]����擾�����l�B
     */
    public String getFktableCat() {
        return fFktableCat;
    }

    /**
     * �t�B�[���h [FKTABLE_SCHEM] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\�X�L�[�}�B]�B
     *
     * @param argFktableSchem �t�B�[���h[FKTABLE_SCHEM]�ɐݒ肷��l�B
     */
    public void setFktableSchem(final String argFktableSchem) {
        fFktableSchem = argFktableSchem;
    }

    /**
     * �t�B�[���h [FKTABLE_SCHEM] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\�X�L�[�}�B]�B
     *
     * @return �t�B�[���h[FKTABLE_SCHEM]����擾�����l�B
     */
    public String getFktableSchem() {
        return fFktableSchem;
    }

    /**
     * �t�B�[���h [FKTABLE_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\���B]�B
     *
     * @param argFktableName �t�B�[���h[FKTABLE_NAME]�ɐݒ肷��l�B
     */
    public void setFktableName(final String argFktableName) {
        fFktableName = argFktableName;
    }

    /**
     * �t�B�[���h [FKTABLE_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̕\���B]�B
     *
     * @return �t�B�[���h[FKTABLE_NAME]����擾�����l�B
     */
    public String getFktableName() {
        return fFktableName;
    }

    /**
     * �t�B�[���h [FKCOLUMN_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̗񖼁B]�B
     *
     * @param argFkcolumnName �t�B�[���h[FKCOLUMN_NAME]�ɐݒ肷��l�B
     */
    public void setFkcolumnName(final String argFkcolumnName) {
        fFkcolumnName = argFkcolumnName;
    }

    /**
     * �t�B�[���h [FKCOLUMN_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[�̗񖼁B]�B
     *
     * @return �t�B�[���h[FKCOLUMN_NAME]����擾�����l�B
     */
    public String getFkcolumnName() {
        return fFkcolumnName;
    }

    /**
     * �t�B�[���h [KEY_SEQ] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [KEY_SEQ: �L�[�̂Ȃ��̘A�ԁBjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B]�B
     *
     * @param argKeySeq �t�B�[���h[KEY_SEQ]�ɐݒ肷��l�B
     */
    public void setKeySeq(final short argKeySeq) {
        fKeySeq = argKeySeq;
    }

    /**
     * �t�B�[���h [KEY_SEQ] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [KEY_SEQ: �L�[�̂Ȃ��̘A�ԁBjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B]�B
     *
     * @return �t�B�[���h[KEY_SEQ]����擾�����l�B
     */
    public short getKeySeq() {
        return fKeySeq;
    }

    /**
     * �t�B�[���h [UPDATE_RULE] �̒l��ݒ肵�܂��B
     *
     * @param argUpdateRule �t�B�[���h[UPDATE_RULE]�ɐݒ肷��l�B
     */
    public void setUpdateRule(final short argUpdateRule) {
        fUpdateRule = argUpdateRule;
    }

    /**
     * �t�B�[���h [UPDATE_RULE] �̒l���擾���܂��B
     *
     * @return �t�B�[���h[UPDATE_RULE]����擾�����l�B
     */
    public short getUpdateRule() {
        return fUpdateRule;
    }

    /**
     * �t�B�[���h [DELETE_RULE] �̒l��ݒ肵�܂��B
     *
     * @param argDeleteRule �t�B�[���h[DELETE_RULE]�ɐݒ肷��l�B
     */
    public void setDeleteRule(final short argDeleteRule) {
        fDeleteRule = argDeleteRule;
    }

    /**
     * �t�B�[���h [DELETE_RULE] �̒l���擾���܂��B
     *
     * @return �t�B�[���h[DELETE_RULE]����擾�����l�B
     */
    public short getDeleteRule() {
        return fDeleteRule;
    }

    /**
     * �t�B�[���h [FK_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[���B]�B
     *
     * @param argFkName �t�B�[���h[FK_NAME]�ɐݒ肷��l�B
     */
    public void setFkName(final String argFkName) {
        fFkName = argFkName;
    }

    /**
     * �t�B�[���h [FK_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�O���L�[���B]�B
     *
     * @return �t�B�[���h[FK_NAME]����擾�����l�B
     */
    public String getFkName() {
        return fFkName;
    }

    /**
     * �t�B�[���h [PK_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [PK_NAME: ��L�[���Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B]�B
     *
     * @param argPkName �t�B�[���h[PK_NAME]�ɐݒ肷��l�B
     */
    public void setPkName(final String argPkName) {
        fPkName = argPkName;
    }

    /**
     * �t�B�[���h [PK_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [PK_NAME: ��L�[���Bjava.sql.DatabaseMetaData.getPrimaryKeys �ŗ��p����Ă��܂��B]�B
     *
     * @return �t�B�[���h[PK_NAME]����擾�����l�B
     */
    public String getPkName() {
        return fPkName;
    }

    /**
     * �t�B�[���h [DEFERRABILITY] �̒l��ݒ肵�܂��B
     *
     * @param argDeferrability �t�B�[���h[DEFERRABILITY]�ɐݒ肷��l�B
     */
    public void setDeferrability(final short argDeferrability) {
        fDeferrability = argDeferrability;
    }

    /**
     * �t�B�[���h [DEFERRABILITY] �̒l���擾���܂��B
     *
     * @return �t�B�[���h[DEFERRABILITY]����擾�����l�B
     */
    public short getDeferrability() {
        return fDeferrability;
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
        buf.append("blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure[");
        buf.append("PKTABLE_CAT=" + fPktableCat);
        buf.append(",PKTABLE_SCHEM=" + fPktableSchem);
        buf.append(",PKTABLE_NAME=" + fPktableName);
        buf.append(",PKCOLUMN_NAME=" + fPkcolumnName);
        buf.append(",FKTABLE_CAT=" + fFktableCat);
        buf.append(",FKTABLE_SCHEM=" + fFktableSchem);
        buf.append(",FKTABLE_NAME=" + fFktableName);
        buf.append(",FKCOLUMN_NAME=" + fFkcolumnName);
        buf.append(",KEY_SEQ=" + fKeySeq);
        buf.append(",UPDATE_RULE=" + fUpdateRule);
        buf.append(",DELETE_RULE=" + fDeleteRule);
        buf.append(",FK_NAME=" + fFkName);
        buf.append(",PK_NAME=" + fPkName);
        buf.append(",DEFERRABILITY=" + fDeferrability);
        buf.append("]");
        return buf.toString();
    }
}
