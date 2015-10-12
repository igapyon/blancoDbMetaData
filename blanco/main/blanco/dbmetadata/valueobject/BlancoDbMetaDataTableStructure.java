/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.valueobject;

import java.util.List;

/**
 * �\�̒�`�����i�[���܂��B
 */
public class BlancoDbMetaDataTableStructure {
    /**
     * ���^���� TABLE_NAME
     *
     * �t�B�[���h: [NAME]�B
     */
    private String fName;

    /**
     * ���^���� TABLE_TYPE
     *
     * �t�B�[���h: [TYPE]�B
     */
    private String fType;

    /**
     * ���^���� TABLE_CAT
     *
     * �t�B�[���h: [CATALOG]�B
     */
    private String fCatalog;

    /**
     * ���^���� TABLE_SCHEM
     *
     * �t�B�[���h: [SCHEMA]�B
     */
    private String fSchema;

    /**
     * ���^���� REMARKS
     *
     * �t�B�[���h: [REMARKS]�B
     */
    private String fRemarks;

    /**
     * �\�Ɋ܂܂�鍀�ځB
     *
     * �t�B�[���h: [columns]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>()]�B
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> fColumns = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>();

    /**
     * �\�Ɋ܂܂��v���C�}���L�[���B
     *
     * �t�B�[���h: [primaryKeys]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fPrimaryKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * �t�B�[���h: [importedKeys]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fImportedKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * �t�B�[���h: [exportedKeys]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fExportedKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * �t�B�[���h: [crossReferenceKeys]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fCrossReferenceKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * �t�B�[���h [NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_NAME]�B
     *
     * @param argName �t�B�[���h[NAME]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_NAME]�B
     *
     * @return �t�B�[���h[NAME]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [TYPE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_TYPE]�B
     *
     * @param argType �t�B�[���h[TYPE]�ɐݒ肷��l�B
     */
    public void setType(final String argType) {
        fType = argType;
    }

    /**
     * �t�B�[���h [TYPE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_TYPE]�B
     *
     * @return �t�B�[���h[TYPE]����擾�����l�B
     */
    public String getType() {
        return fType;
    }

    /**
     * �t�B�[���h [CATALOG] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_CAT]�B
     *
     * @param argCatalog �t�B�[���h[CATALOG]�ɐݒ肷��l�B
     */
    public void setCatalog(final String argCatalog) {
        fCatalog = argCatalog;
    }

    /**
     * �t�B�[���h [CATALOG] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_CAT]�B
     *
     * @return �t�B�[���h[CATALOG]����擾�����l�B
     */
    public String getCatalog() {
        return fCatalog;
    }

    /**
     * �t�B�[���h [SCHEMA] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_SCHEM]�B
     *
     * @param argSchema �t�B�[���h[SCHEMA]�ɐݒ肷��l�B
     */
    public void setSchema(final String argSchema) {
        fSchema = argSchema;
    }

    /**
     * �t�B�[���h [SCHEMA] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� TABLE_SCHEM]�B
     *
     * @return �t�B�[���h[SCHEMA]����擾�����l�B
     */
    public String getSchema() {
        return fSchema;
    }

    /**
     * �t�B�[���h [REMARKS] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� REMARKS]�B
     *
     * @param argRemarks �t�B�[���h[REMARKS]�ɐݒ肷��l�B
     */
    public void setRemarks(final String argRemarks) {
        fRemarks = argRemarks;
    }

    /**
     * �t�B�[���h [REMARKS] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� REMARKS]�B
     *
     * @return �t�B�[���h[REMARKS]����擾�����l�B
     */
    public String getRemarks() {
        return fRemarks;
    }

    /**
     * �t�B�[���h [columns] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\�Ɋ܂܂�鍀�ځB]�B
     *
     * @param argColumns �t�B�[���h[columns]�ɐݒ肷��l�B
     */
    public void setColumns(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> argColumns) {
        fColumns = argColumns;
    }

    /**
     * �t�B�[���h [columns] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\�Ɋ܂܂�鍀�ځB]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>()]�B
     *
     * @return �t�B�[���h[columns]����擾�����l�B
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> getColumns() {
        return fColumns;
    }

    /**
     * �t�B�[���h [primaryKeys] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [�\�Ɋ܂܂��v���C�}���L�[���B]�B
     *
     * @param argPrimaryKeys �t�B�[���h[primaryKeys]�ɐݒ肷��l�B
     */
    public void setPrimaryKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argPrimaryKeys) {
        fPrimaryKeys = argPrimaryKeys;
    }

    /**
     * �t�B�[���h [primaryKeys] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [�\�Ɋ܂܂��v���C�}���L�[���B]�B
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     *
     * @return �t�B�[���h[primaryKeys]����擾�����l�B
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getPrimaryKeys() {
        return fPrimaryKeys;
    }

    /**
     * �t�B�[���h [importedKeys] �̒l��ݒ肵�܂��B
     *
     * @param argImportedKeys �t�B�[���h[importedKeys]�ɐݒ肷��l�B
     */
    public void setImportedKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argImportedKeys) {
        fImportedKeys = argImportedKeys;
    }

    /**
     * �t�B�[���h [importedKeys] �̒l���擾���܂��B
     *
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     *
     * @return �t�B�[���h[importedKeys]����擾�����l�B
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getImportedKeys() {
        return fImportedKeys;
    }

    /**
     * �t�B�[���h [exportedKeys] �̒l��ݒ肵�܂��B
     *
     * @param argExportedKeys �t�B�[���h[exportedKeys]�ɐݒ肷��l�B
     */
    public void setExportedKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argExportedKeys) {
        fExportedKeys = argExportedKeys;
    }

    /**
     * �t�B�[���h [exportedKeys] �̒l���擾���܂��B
     *
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     *
     * @return �t�B�[���h[exportedKeys]����擾�����l�B
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getExportedKeys() {
        return fExportedKeys;
    }

    /**
     * �t�B�[���h [crossReferenceKeys] �̒l��ݒ肵�܂��B
     *
     * @param argCrossReferenceKeys �t�B�[���h[crossReferenceKeys]�ɐݒ肷��l�B
     */
    public void setCrossReferenceKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argCrossReferenceKeys) {
        fCrossReferenceKeys = argCrossReferenceKeys;
    }

    /**
     * �t�B�[���h [crossReferenceKeys] �̒l���擾���܂��B
     *
     * �f�t�H���g: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]�B
     *
     * @return �t�B�[���h[crossReferenceKeys]����擾�����l�B
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getCrossReferenceKeys() {
        return fCrossReferenceKeys;
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
        buf.append("blanco.dbmetadata.valueobject.BlancoDbMetaDataTableStructure[");
        buf.append("NAME=" + fName);
        buf.append(",TYPE=" + fType);
        buf.append(",CATALOG=" + fCatalog);
        buf.append(",SCHEMA=" + fSchema);
        buf.append(",REMARKS=" + fRemarks);
        buf.append(",columns=" + fColumns);
        buf.append(",primaryKeys=" + fPrimaryKeys);
        buf.append(",importedKeys=" + fImportedKeys);
        buf.append(",exportedKeys=" + fExportedKeys);
        buf.append(",crossReferenceKeys=" + fCrossReferenceKeys);
        buf.append("]");
        return buf.toString();
    }
}
