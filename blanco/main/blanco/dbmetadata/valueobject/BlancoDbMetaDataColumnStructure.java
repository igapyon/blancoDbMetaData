/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.valueobject;

/**
 * �\�̗�̒�`�����i�[���܂��B
 */
public class BlancoDbMetaDataColumnStructure {
    /**
     * ���^���� COLUMN_NAME
     *
     * �t�B�[���h: [NAME]�B
     */
    private String fName;

    /**
     * ���^���� DATA_TYPE�Bjava.sql.Types�B�擾�����l��short�����Ajava.sql.Types ��int�ł���̂� int�ŋL�����܂��B
     *
     * �t�B�[���h: [DATA_TYPE]�B
     */
    private int fDataType;

    /**
     * DATA_TYPE��\���\�ȕ����ɓǂݑւ������́B[java.sql.Types.] �������������񂪊i�[����܂��B
     *
     * �t�B�[���h: [DATA_TYPE_DISPLAY_NAME]�B
     */
    private String fDataTypeDisplayName;

    /**
     * ���^���� TYPE_NAME�B�f�[�^�\�[�X�ˑ��̌^���B
     *
     * �t�B�[���h: [TYPE_NAME]�B
     */
    private String fTypeName;

    /**
     * ���^���� COLUMN_SIZE�B��T�C�Y�Bchar �� date �͍ő啶�����Bnumeric �� decimal ���x�B
     *
     * �t�B�[���h: [COLUMN_SIZE]�B
     */
    private int fColumnSize;

    /**
     * ���^���� BUFFER_LENGTH�B���g�p�B
     *
     * �t�B�[���h: [BUFFER_LENGTH]�B
     */
    private String fBufferLength;

    /**
     * ���^���� DECIMAL_DIGITS�B�����_�ȉ��̌����B
     *
     * �t�B�[���h: [DECIMAL_DIGITS]�B
     */
    private int fDecimalDigits;

    /**
     * ���^���� NUM_PREC_RADIX�B� (�ʏ�́A10 �܂��� 2 �̂ǂ��炩)
     *
     * �t�B�[���h: [NUM_PREC_RADIX]�B
     */
    private int fNumPrecRadix;

    /**
     * ���^���� NULLABLE�BNULL �͋�����邩�ǂ����BcolumnNoNulls�AcolumnNullable�AcolumnNullableUnknown�̂����ꂩ�̒l�B�f�t�H���g�� columnNullable (1)
     *
     * �t�B�[���h: [NULLABLE]�B
     * �f�t�H���g: [1]�B
     */
    private int fNullable = 1;

    /**
     * NULLABLE��\���\�ȕ����ɓǂݑւ������́B[java.sql.ResultSetMetaData.] �������������񂪊i�[����܂��B
     *
     * �t�B�[���h: [NULLABLE_DISPLAY_NAME]�B
     */
    private String fNullableDisplayName;

    /**
     * ���^���� REMARKS�B�R�����g�L�q�B
     *
     * �t�B�[���h: [REMARKS]�B
     */
    private String fRemarks;

    /**
     * ���^���� COLUMN_DEF�B��̃f�t�H���g�l�B
     *
     * �t�B�[���h: [COLUMN_DEF]�B
     */
    private String fColumnDef;

    /**
     * ���^���� SQL_DATA_TYPE�B���g�p�B
     *
     * �t�B�[���h: [SQL_DATA_TYPE]�B
     */
    private int fSqlDataType;

    /**
     * ���^���� SQL_DATETIME_SUB�B���g�p�B
     *
     * �t�B�[���h: [SQL_DATETIME_SUB]�B
     */
    private int fSqlDatetimeSub;

    /**
     * ���^���� CHAR_OCTET_LENGTH�Bchar�^�͗�̍ő�o�C�g���B
     *
     * �t�B�[���h: [CHAR_OCTET_LENGTH]�B
     */
    private int fCharOctetLength;

    /**
     * ���^���� ORDINAL_POSITION�B�e�[�u�����̗�C���f�b�N�X (1�I���W��)
     *
     * �t�B�[���h: [ORDINAL_POSITION]�B
     */
    private int fOrdinalPosition;

    /**
     * ���^���� IS_NULLABLE�B�g�p�͐�������܂���B
     *
     * �t�B�[���h: [IS_NULLABLE]�B
     */
    private String fIsNullable;

    /**
     * SCOPE_CATLOG
     *
     * �t�B�[���h: [SCOPE_CATLOG]�B
     */
    private String fScopeCatlog;

    /**
     * SCOPE_SCHEMA
     *
     * �t�B�[���h: [SCOPE_SCHEMA]�B
     */
    private String fScopeSchema;

    /**
     * SCOPE_TABLE
     *
     * �t�B�[���h: [SCOPE_TABLE]�B
     */
    private String fScopeTable;

    /**
     * SOURCE_DATA_TYPE
     *
     * �t�B�[���h: [SOURCE_DATA_TYPE]�B
     */
    private int fSourceDataType;

    /**
     * SQL���s: ���̗񂪏������݉\�ł��邩�ǂ����B(�ʏ�̃��^��񂩂�͓����܂���B)
     *
     * �t�B�[���h: [WRITABLE]�B
     */
    private boolean fWritable;

    /**
     * �t�B�[���h [NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_NAME]�B
     *
     * @param argName �t�B�[���h[NAME]�ɐݒ肷��l�B
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * �t�B�[���h [NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_NAME]�B
     *
     * @return �t�B�[���h[NAME]����擾�����l�B
     */
    public String getName() {
        return fName;
    }

    /**
     * �t�B�[���h [DATA_TYPE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� DATA_TYPE�Bjava.sql.Types�B�擾�����l��short�����Ajava.sql.Types ��int�ł���̂� int�ŋL�����܂��B]�B
     *
     * @param argDataType �t�B�[���h[DATA_TYPE]�ɐݒ肷��l�B
     */
    public void setDataType(final int argDataType) {
        fDataType = argDataType;
    }

    /**
     * �t�B�[���h [DATA_TYPE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� DATA_TYPE�Bjava.sql.Types�B�擾�����l��short�����Ajava.sql.Types ��int�ł���̂� int�ŋL�����܂��B]�B
     *
     * @return �t�B�[���h[DATA_TYPE]����擾�����l�B
     */
    public int getDataType() {
        return fDataType;
    }

    /**
     * �t�B�[���h [DATA_TYPE_DISPLAY_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [DATA_TYPE��\���\�ȕ����ɓǂݑւ������́B[java.sql.Types.] �������������񂪊i�[����܂��B]�B
     *
     * @param argDataTypeDisplayName �t�B�[���h[DATA_TYPE_DISPLAY_NAME]�ɐݒ肷��l�B
     */
    public void setDataTypeDisplayName(final String argDataTypeDisplayName) {
        fDataTypeDisplayName = argDataTypeDisplayName;
    }

    /**
     * �t�B�[���h [DATA_TYPE_DISPLAY_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [DATA_TYPE��\���\�ȕ����ɓǂݑւ������́B[java.sql.Types.] �������������񂪊i�[����܂��B]�B
     *
     * @return �t�B�[���h[DATA_TYPE_DISPLAY_NAME]����擾�����l�B
     */
    public String getDataTypeDisplayName() {
        return fDataTypeDisplayName;
    }

    /**
     * �t�B�[���h [TYPE_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� TYPE_NAME�B�f�[�^�\�[�X�ˑ��̌^���B]�B
     *
     * @param argTypeName �t�B�[���h[TYPE_NAME]�ɐݒ肷��l�B
     */
    public void setTypeName(final String argTypeName) {
        fTypeName = argTypeName;
    }

    /**
     * �t�B�[���h [TYPE_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� TYPE_NAME�B�f�[�^�\�[�X�ˑ��̌^���B]�B
     *
     * @return �t�B�[���h[TYPE_NAME]����擾�����l�B
     */
    public String getTypeName() {
        return fTypeName;
    }

    /**
     * �t�B�[���h [COLUMN_SIZE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_SIZE�B��T�C�Y�Bchar �� date �͍ő啶�����Bnumeric �� decimal ���x�B]�B
     *
     * @param argColumnSize �t�B�[���h[COLUMN_SIZE]�ɐݒ肷��l�B
     */
    public void setColumnSize(final int argColumnSize) {
        fColumnSize = argColumnSize;
    }

    /**
     * �t�B�[���h [COLUMN_SIZE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_SIZE�B��T�C�Y�Bchar �� date �͍ő啶�����Bnumeric �� decimal ���x�B]�B
     *
     * @return �t�B�[���h[COLUMN_SIZE]����擾�����l�B
     */
    public int getColumnSize() {
        return fColumnSize;
    }

    /**
     * �t�B�[���h [BUFFER_LENGTH] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� BUFFER_LENGTH�B���g�p�B]�B
     *
     * @param argBufferLength �t�B�[���h[BUFFER_LENGTH]�ɐݒ肷��l�B
     */
    public void setBufferLength(final String argBufferLength) {
        fBufferLength = argBufferLength;
    }

    /**
     * �t�B�[���h [BUFFER_LENGTH] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� BUFFER_LENGTH�B���g�p�B]�B
     *
     * @return �t�B�[���h[BUFFER_LENGTH]����擾�����l�B
     */
    public String getBufferLength() {
        return fBufferLength;
    }

    /**
     * �t�B�[���h [DECIMAL_DIGITS] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� DECIMAL_DIGITS�B�����_�ȉ��̌����B]�B
     *
     * @param argDecimalDigits �t�B�[���h[DECIMAL_DIGITS]�ɐݒ肷��l�B
     */
    public void setDecimalDigits(final int argDecimalDigits) {
        fDecimalDigits = argDecimalDigits;
    }

    /**
     * �t�B�[���h [DECIMAL_DIGITS] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� DECIMAL_DIGITS�B�����_�ȉ��̌����B]�B
     *
     * @return �t�B�[���h[DECIMAL_DIGITS]����擾�����l�B
     */
    public int getDecimalDigits() {
        return fDecimalDigits;
    }

    /**
     * �t�B�[���h [NUM_PREC_RADIX] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� NUM_PREC_RADIX�B� (�ʏ�́A10 �܂��� 2 �̂ǂ��炩)]�B
     *
     * @param argNumPrecRadix �t�B�[���h[NUM_PREC_RADIX]�ɐݒ肷��l�B
     */
    public void setNumPrecRadix(final int argNumPrecRadix) {
        fNumPrecRadix = argNumPrecRadix;
    }

    /**
     * �t�B�[���h [NUM_PREC_RADIX] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� NUM_PREC_RADIX�B� (�ʏ�́A10 �܂��� 2 �̂ǂ��炩)]�B
     *
     * @return �t�B�[���h[NUM_PREC_RADIX]����擾�����l�B
     */
    public int getNumPrecRadix() {
        return fNumPrecRadix;
    }

    /**
     * �t�B�[���h [NULLABLE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� NULLABLE�BNULL �͋�����邩�ǂ����BcolumnNoNulls�AcolumnNullable�AcolumnNullableUnknown�̂����ꂩ�̒l�B�f�t�H���g�� columnNullable (1)]�B
     *
     * @param argNullable �t�B�[���h[NULLABLE]�ɐݒ肷��l�B
     */
    public void setNullable(final int argNullable) {
        fNullable = argNullable;
    }

    /**
     * �t�B�[���h [NULLABLE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� NULLABLE�BNULL �͋�����邩�ǂ����BcolumnNoNulls�AcolumnNullable�AcolumnNullableUnknown�̂����ꂩ�̒l�B�f�t�H���g�� columnNullable (1)]�B
     * �f�t�H���g: [1]�B
     *
     * @return �t�B�[���h[NULLABLE]����擾�����l�B
     */
    public int getNullable() {
        return fNullable;
    }

    /**
     * �t�B�[���h [NULLABLE_DISPLAY_NAME] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [NULLABLE��\���\�ȕ����ɓǂݑւ������́B[java.sql.ResultSetMetaData.] �������������񂪊i�[����܂��B]�B
     *
     * @param argNullableDisplayName �t�B�[���h[NULLABLE_DISPLAY_NAME]�ɐݒ肷��l�B
     */
    public void setNullableDisplayName(final String argNullableDisplayName) {
        fNullableDisplayName = argNullableDisplayName;
    }

    /**
     * �t�B�[���h [NULLABLE_DISPLAY_NAME] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [NULLABLE��\���\�ȕ����ɓǂݑւ������́B[java.sql.ResultSetMetaData.] �������������񂪊i�[����܂��B]�B
     *
     * @return �t�B�[���h[NULLABLE_DISPLAY_NAME]����擾�����l�B
     */
    public String getNullableDisplayName() {
        return fNullableDisplayName;
    }

    /**
     * �t�B�[���h [REMARKS] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� REMARKS�B�R�����g�L�q�B]�B
     *
     * @param argRemarks �t�B�[���h[REMARKS]�ɐݒ肷��l�B
     */
    public void setRemarks(final String argRemarks) {
        fRemarks = argRemarks;
    }

    /**
     * �t�B�[���h [REMARKS] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� REMARKS�B�R�����g�L�q�B]�B
     *
     * @return �t�B�[���h[REMARKS]����擾�����l�B
     */
    public String getRemarks() {
        return fRemarks;
    }

    /**
     * �t�B�[���h [COLUMN_DEF] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_DEF�B��̃f�t�H���g�l�B]�B
     *
     * @param argColumnDef �t�B�[���h[COLUMN_DEF]�ɐݒ肷��l�B
     */
    public void setColumnDef(final String argColumnDef) {
        fColumnDef = argColumnDef;
    }

    /**
     * �t�B�[���h [COLUMN_DEF] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� COLUMN_DEF�B��̃f�t�H���g�l�B]�B
     *
     * @return �t�B�[���h[COLUMN_DEF]����擾�����l�B
     */
    public String getColumnDef() {
        return fColumnDef;
    }

    /**
     * �t�B�[���h [SQL_DATA_TYPE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� SQL_DATA_TYPE�B���g�p�B]�B
     *
     * @param argSqlDataType �t�B�[���h[SQL_DATA_TYPE]�ɐݒ肷��l�B
     */
    public void setSqlDataType(final int argSqlDataType) {
        fSqlDataType = argSqlDataType;
    }

    /**
     * �t�B�[���h [SQL_DATA_TYPE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� SQL_DATA_TYPE�B���g�p�B]�B
     *
     * @return �t�B�[���h[SQL_DATA_TYPE]����擾�����l�B
     */
    public int getSqlDataType() {
        return fSqlDataType;
    }

    /**
     * �t�B�[���h [SQL_DATETIME_SUB] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� SQL_DATETIME_SUB�B���g�p�B]�B
     *
     * @param argSqlDatetimeSub �t�B�[���h[SQL_DATETIME_SUB]�ɐݒ肷��l�B
     */
    public void setSqlDatetimeSub(final int argSqlDatetimeSub) {
        fSqlDatetimeSub = argSqlDatetimeSub;
    }

    /**
     * �t�B�[���h [SQL_DATETIME_SUB] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� SQL_DATETIME_SUB�B���g�p�B]�B
     *
     * @return �t�B�[���h[SQL_DATETIME_SUB]����擾�����l�B
     */
    public int getSqlDatetimeSub() {
        return fSqlDatetimeSub;
    }

    /**
     * �t�B�[���h [CHAR_OCTET_LENGTH] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� CHAR_OCTET_LENGTH�Bchar�^�͗�̍ő�o�C�g���B]�B
     *
     * @param argCharOctetLength �t�B�[���h[CHAR_OCTET_LENGTH]�ɐݒ肷��l�B
     */
    public void setCharOctetLength(final int argCharOctetLength) {
        fCharOctetLength = argCharOctetLength;
    }

    /**
     * �t�B�[���h [CHAR_OCTET_LENGTH] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� CHAR_OCTET_LENGTH�Bchar�^�͗�̍ő�o�C�g���B]�B
     *
     * @return �t�B�[���h[CHAR_OCTET_LENGTH]����擾�����l�B
     */
    public int getCharOctetLength() {
        return fCharOctetLength;
    }

    /**
     * �t�B�[���h [ORDINAL_POSITION] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� ORDINAL_POSITION�B�e�[�u�����̗�C���f�b�N�X (1�I���W��)]�B
     *
     * @param argOrdinalPosition �t�B�[���h[ORDINAL_POSITION]�ɐݒ肷��l�B
     */
    public void setOrdinalPosition(final int argOrdinalPosition) {
        fOrdinalPosition = argOrdinalPosition;
    }

    /**
     * �t�B�[���h [ORDINAL_POSITION] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� ORDINAL_POSITION�B�e�[�u�����̗�C���f�b�N�X (1�I���W��)]�B
     *
     * @return �t�B�[���h[ORDINAL_POSITION]����擾�����l�B
     */
    public int getOrdinalPosition() {
        return fOrdinalPosition;
    }

    /**
     * �t�B�[���h [IS_NULLABLE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [���^���� IS_NULLABLE�B�g�p�͐�������܂���B]�B
     *
     * @param argIsNullable �t�B�[���h[IS_NULLABLE]�ɐݒ肷��l�B
     */
    public void setIsNullable(final String argIsNullable) {
        fIsNullable = argIsNullable;
    }

    /**
     * �t�B�[���h [IS_NULLABLE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [���^���� IS_NULLABLE�B�g�p�͐�������܂���B]�B
     *
     * @return �t�B�[���h[IS_NULLABLE]����擾�����l�B
     */
    public String getIsNullable() {
        return fIsNullable;
    }

    /**
     * �t�B�[���h [SCOPE_CATLOG] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_CATLOG]�B
     *
     * @param argScopeCatlog �t�B�[���h[SCOPE_CATLOG]�ɐݒ肷��l�B
     */
    public void setScopeCatlog(final String argScopeCatlog) {
        fScopeCatlog = argScopeCatlog;
    }

    /**
     * �t�B�[���h [SCOPE_CATLOG] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_CATLOG]�B
     *
     * @return �t�B�[���h[SCOPE_CATLOG]����擾�����l�B
     */
    public String getScopeCatlog() {
        return fScopeCatlog;
    }

    /**
     * �t�B�[���h [SCOPE_SCHEMA] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_SCHEMA]�B
     *
     * @param argScopeSchema �t�B�[���h[SCOPE_SCHEMA]�ɐݒ肷��l�B
     */
    public void setScopeSchema(final String argScopeSchema) {
        fScopeSchema = argScopeSchema;
    }

    /**
     * �t�B�[���h [SCOPE_SCHEMA] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_SCHEMA]�B
     *
     * @return �t�B�[���h[SCOPE_SCHEMA]����擾�����l�B
     */
    public String getScopeSchema() {
        return fScopeSchema;
    }

    /**
     * �t�B�[���h [SCOPE_TABLE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_TABLE]�B
     *
     * @param argScopeTable �t�B�[���h[SCOPE_TABLE]�ɐݒ肷��l�B
     */
    public void setScopeTable(final String argScopeTable) {
        fScopeTable = argScopeTable;
    }

    /**
     * �t�B�[���h [SCOPE_TABLE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [SCOPE_TABLE]�B
     *
     * @return �t�B�[���h[SCOPE_TABLE]����擾�����l�B
     */
    public String getScopeTable() {
        return fScopeTable;
    }

    /**
     * �t�B�[���h [SOURCE_DATA_TYPE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [SOURCE_DATA_TYPE]�B
     *
     * @param argSourceDataType �t�B�[���h[SOURCE_DATA_TYPE]�ɐݒ肷��l�B
     */
    public void setSourceDataType(final int argSourceDataType) {
        fSourceDataType = argSourceDataType;
    }

    /**
     * �t�B�[���h [SOURCE_DATA_TYPE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [SOURCE_DATA_TYPE]�B
     *
     * @return �t�B�[���h[SOURCE_DATA_TYPE]����擾�����l�B
     */
    public int getSourceDataType() {
        return fSourceDataType;
    }

    /**
     * �t�B�[���h [WRITABLE] �̒l��ݒ肵�܂��B
     *
     * �t�B�[���h�̐���: [SQL���s: ���̗񂪏������݉\�ł��邩�ǂ����B(�ʏ�̃��^��񂩂�͓����܂���B)]�B
     *
     * @param argWritable �t�B�[���h[WRITABLE]�ɐݒ肷��l�B
     */
    public void setWritable(final boolean argWritable) {
        fWritable = argWritable;
    }

    /**
     * �t�B�[���h [WRITABLE] �̒l���擾���܂��B
     *
     * �t�B�[���h�̐���: [SQL���s: ���̗񂪏������݉\�ł��邩�ǂ����B(�ʏ�̃��^��񂩂�͓����܂���B)]�B
     *
     * @return �t�B�[���h[WRITABLE]����擾�����l�B
     */
    public boolean getWritable() {
        return fWritable;
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
        buf.append("blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure[");
        buf.append("NAME=" + fName);
        buf.append(",DATA_TYPE=" + fDataType);
        buf.append(",DATA_TYPE_DISPLAY_NAME=" + fDataTypeDisplayName);
        buf.append(",TYPE_NAME=" + fTypeName);
        buf.append(",COLUMN_SIZE=" + fColumnSize);
        buf.append(",BUFFER_LENGTH=" + fBufferLength);
        buf.append(",DECIMAL_DIGITS=" + fDecimalDigits);
        buf.append(",NUM_PREC_RADIX=" + fNumPrecRadix);
        buf.append(",NULLABLE=" + fNullable);
        buf.append(",NULLABLE_DISPLAY_NAME=" + fNullableDisplayName);
        buf.append(",REMARKS=" + fRemarks);
        buf.append(",COLUMN_DEF=" + fColumnDef);
        buf.append(",SQL_DATA_TYPE=" + fSqlDataType);
        buf.append(",SQL_DATETIME_SUB=" + fSqlDatetimeSub);
        buf.append(",CHAR_OCTET_LENGTH=" + fCharOctetLength);
        buf.append(",ORDINAL_POSITION=" + fOrdinalPosition);
        buf.append(",IS_NULLABLE=" + fIsNullable);
        buf.append(",SCOPE_CATLOG=" + fScopeCatlog);
        buf.append(",SCOPE_SCHEMA=" + fScopeSchema);
        buf.append(",SCOPE_TABLE=" + fScopeTable);
        buf.append(",SOURCE_DATA_TYPE=" + fSourceDataType);
        buf.append(",WRITABLE=" + fWritable);
        buf.append("]");
        return buf.toString();
    }
}
