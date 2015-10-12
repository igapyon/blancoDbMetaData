/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.valueobject;

/**
 * 表の列の定義情報を格納します。
 */
public class BlancoDbMetaDataColumnStructure {
    /**
     * メタ情報の COLUMN_NAME
     *
     * フィールド: [NAME]。
     */
    private String fName;

    /**
     * メタ情報の DATA_TYPE。java.sql.Types。取得される値はshortだが、java.sql.Types がintであるので intで記憶します。
     *
     * フィールド: [DATA_TYPE]。
     */
    private int fDataType;

    /**
     * DATA_TYPEを表示可能な文字に読み替えたもの。[java.sql.Types.] を除いた文字列が格納されます。
     *
     * フィールド: [DATA_TYPE_DISPLAY_NAME]。
     */
    private String fDataTypeDisplayName;

    /**
     * メタ情報の TYPE_NAME。データソース依存の型名。
     *
     * フィールド: [TYPE_NAME]。
     */
    private String fTypeName;

    /**
     * メタ情報の COLUMN_SIZE。列サイズ。char や date は最大文字数。numeric や decimal 精度。
     *
     * フィールド: [COLUMN_SIZE]。
     */
    private int fColumnSize;

    /**
     * メタ情報の BUFFER_LENGTH。未使用。
     *
     * フィールド: [BUFFER_LENGTH]。
     */
    private String fBufferLength;

    /**
     * メタ情報の DECIMAL_DIGITS。小数点以下の桁数。
     *
     * フィールド: [DECIMAL_DIGITS]。
     */
    private int fDecimalDigits;

    /**
     * メタ情報の NUM_PREC_RADIX。基数 (通常は、10 または 2 のどちらか)
     *
     * フィールド: [NUM_PREC_RADIX]。
     */
    private int fNumPrecRadix;

    /**
     * メタ情報の NULLABLE。NULL は許されるかどうか。columnNoNulls、columnNullable、columnNullableUnknownのいずれかの値。デフォルトは columnNullable (1)
     *
     * フィールド: [NULLABLE]。
     * デフォルト: [1]。
     */
    private int fNullable = 1;

    /**
     * NULLABLEを表示可能な文字に読み替えたもの。[java.sql.ResultSetMetaData.] を除いた文字列が格納されます。
     *
     * フィールド: [NULLABLE_DISPLAY_NAME]。
     */
    private String fNullableDisplayName;

    /**
     * メタ情報の REMARKS。コメント記述。
     *
     * フィールド: [REMARKS]。
     */
    private String fRemarks;

    /**
     * メタ情報の COLUMN_DEF。列のデフォルト値。
     *
     * フィールド: [COLUMN_DEF]。
     */
    private String fColumnDef;

    /**
     * メタ情報の SQL_DATA_TYPE。未使用。
     *
     * フィールド: [SQL_DATA_TYPE]。
     */
    private int fSqlDataType;

    /**
     * メタ情報の SQL_DATETIME_SUB。未使用。
     *
     * フィールド: [SQL_DATETIME_SUB]。
     */
    private int fSqlDatetimeSub;

    /**
     * メタ情報の CHAR_OCTET_LENGTH。char型は列の最大バイト数。
     *
     * フィールド: [CHAR_OCTET_LENGTH]。
     */
    private int fCharOctetLength;

    /**
     * メタ情報の ORDINAL_POSITION。テーブル中の列インデックス (1オリジン)
     *
     * フィールド: [ORDINAL_POSITION]。
     */
    private int fOrdinalPosition;

    /**
     * メタ情報の IS_NULLABLE。使用は推奨されません。
     *
     * フィールド: [IS_NULLABLE]。
     */
    private String fIsNullable;

    /**
     * SCOPE_CATLOG
     *
     * フィールド: [SCOPE_CATLOG]。
     */
    private String fScopeCatlog;

    /**
     * SCOPE_SCHEMA
     *
     * フィールド: [SCOPE_SCHEMA]。
     */
    private String fScopeSchema;

    /**
     * SCOPE_TABLE
     *
     * フィールド: [SCOPE_TABLE]。
     */
    private String fScopeTable;

    /**
     * SOURCE_DATA_TYPE
     *
     * フィールド: [SOURCE_DATA_TYPE]。
     */
    private int fSourceDataType;

    /**
     * SQL実行: その列が書き込み可能であるかどうか。(通常のメタ情報からは得られません。)
     *
     * フィールド: [WRITABLE]。
     */
    private boolean fWritable;

    /**
     * フィールド [NAME] の値を設定します。
     *
     * フィールドの説明: [メタ情報の COLUMN_NAME]。
     *
     * @param argName フィールド[NAME]に設定する値。
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * フィールド [NAME] の値を取得します。
     *
     * フィールドの説明: [メタ情報の COLUMN_NAME]。
     *
     * @return フィールド[NAME]から取得した値。
     */
    public String getName() {
        return fName;
    }

    /**
     * フィールド [DATA_TYPE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の DATA_TYPE。java.sql.Types。取得される値はshortだが、java.sql.Types がintであるので intで記憶します。]。
     *
     * @param argDataType フィールド[DATA_TYPE]に設定する値。
     */
    public void setDataType(final int argDataType) {
        fDataType = argDataType;
    }

    /**
     * フィールド [DATA_TYPE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の DATA_TYPE。java.sql.Types。取得される値はshortだが、java.sql.Types がintであるので intで記憶します。]。
     *
     * @return フィールド[DATA_TYPE]から取得した値。
     */
    public int getDataType() {
        return fDataType;
    }

    /**
     * フィールド [DATA_TYPE_DISPLAY_NAME] の値を設定します。
     *
     * フィールドの説明: [DATA_TYPEを表示可能な文字に読み替えたもの。[java.sql.Types.] を除いた文字列が格納されます。]。
     *
     * @param argDataTypeDisplayName フィールド[DATA_TYPE_DISPLAY_NAME]に設定する値。
     */
    public void setDataTypeDisplayName(final String argDataTypeDisplayName) {
        fDataTypeDisplayName = argDataTypeDisplayName;
    }

    /**
     * フィールド [DATA_TYPE_DISPLAY_NAME] の値を取得します。
     *
     * フィールドの説明: [DATA_TYPEを表示可能な文字に読み替えたもの。[java.sql.Types.] を除いた文字列が格納されます。]。
     *
     * @return フィールド[DATA_TYPE_DISPLAY_NAME]から取得した値。
     */
    public String getDataTypeDisplayName() {
        return fDataTypeDisplayName;
    }

    /**
     * フィールド [TYPE_NAME] の値を設定します。
     *
     * フィールドの説明: [メタ情報の TYPE_NAME。データソース依存の型名。]。
     *
     * @param argTypeName フィールド[TYPE_NAME]に設定する値。
     */
    public void setTypeName(final String argTypeName) {
        fTypeName = argTypeName;
    }

    /**
     * フィールド [TYPE_NAME] の値を取得します。
     *
     * フィールドの説明: [メタ情報の TYPE_NAME。データソース依存の型名。]。
     *
     * @return フィールド[TYPE_NAME]から取得した値。
     */
    public String getTypeName() {
        return fTypeName;
    }

    /**
     * フィールド [COLUMN_SIZE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の COLUMN_SIZE。列サイズ。char や date は最大文字数。numeric や decimal 精度。]。
     *
     * @param argColumnSize フィールド[COLUMN_SIZE]に設定する値。
     */
    public void setColumnSize(final int argColumnSize) {
        fColumnSize = argColumnSize;
    }

    /**
     * フィールド [COLUMN_SIZE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の COLUMN_SIZE。列サイズ。char や date は最大文字数。numeric や decimal 精度。]。
     *
     * @return フィールド[COLUMN_SIZE]から取得した値。
     */
    public int getColumnSize() {
        return fColumnSize;
    }

    /**
     * フィールド [BUFFER_LENGTH] の値を設定します。
     *
     * フィールドの説明: [メタ情報の BUFFER_LENGTH。未使用。]。
     *
     * @param argBufferLength フィールド[BUFFER_LENGTH]に設定する値。
     */
    public void setBufferLength(final String argBufferLength) {
        fBufferLength = argBufferLength;
    }

    /**
     * フィールド [BUFFER_LENGTH] の値を取得します。
     *
     * フィールドの説明: [メタ情報の BUFFER_LENGTH。未使用。]。
     *
     * @return フィールド[BUFFER_LENGTH]から取得した値。
     */
    public String getBufferLength() {
        return fBufferLength;
    }

    /**
     * フィールド [DECIMAL_DIGITS] の値を設定します。
     *
     * フィールドの説明: [メタ情報の DECIMAL_DIGITS。小数点以下の桁数。]。
     *
     * @param argDecimalDigits フィールド[DECIMAL_DIGITS]に設定する値。
     */
    public void setDecimalDigits(final int argDecimalDigits) {
        fDecimalDigits = argDecimalDigits;
    }

    /**
     * フィールド [DECIMAL_DIGITS] の値を取得します。
     *
     * フィールドの説明: [メタ情報の DECIMAL_DIGITS。小数点以下の桁数。]。
     *
     * @return フィールド[DECIMAL_DIGITS]から取得した値。
     */
    public int getDecimalDigits() {
        return fDecimalDigits;
    }

    /**
     * フィールド [NUM_PREC_RADIX] の値を設定します。
     *
     * フィールドの説明: [メタ情報の NUM_PREC_RADIX。基数 (通常は、10 または 2 のどちらか)]。
     *
     * @param argNumPrecRadix フィールド[NUM_PREC_RADIX]に設定する値。
     */
    public void setNumPrecRadix(final int argNumPrecRadix) {
        fNumPrecRadix = argNumPrecRadix;
    }

    /**
     * フィールド [NUM_PREC_RADIX] の値を取得します。
     *
     * フィールドの説明: [メタ情報の NUM_PREC_RADIX。基数 (通常は、10 または 2 のどちらか)]。
     *
     * @return フィールド[NUM_PREC_RADIX]から取得した値。
     */
    public int getNumPrecRadix() {
        return fNumPrecRadix;
    }

    /**
     * フィールド [NULLABLE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の NULLABLE。NULL は許されるかどうか。columnNoNulls、columnNullable、columnNullableUnknownのいずれかの値。デフォルトは columnNullable (1)]。
     *
     * @param argNullable フィールド[NULLABLE]に設定する値。
     */
    public void setNullable(final int argNullable) {
        fNullable = argNullable;
    }

    /**
     * フィールド [NULLABLE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の NULLABLE。NULL は許されるかどうか。columnNoNulls、columnNullable、columnNullableUnknownのいずれかの値。デフォルトは columnNullable (1)]。
     * デフォルト: [1]。
     *
     * @return フィールド[NULLABLE]から取得した値。
     */
    public int getNullable() {
        return fNullable;
    }

    /**
     * フィールド [NULLABLE_DISPLAY_NAME] の値を設定します。
     *
     * フィールドの説明: [NULLABLEを表示可能な文字に読み替えたもの。[java.sql.ResultSetMetaData.] を除いた文字列が格納されます。]。
     *
     * @param argNullableDisplayName フィールド[NULLABLE_DISPLAY_NAME]に設定する値。
     */
    public void setNullableDisplayName(final String argNullableDisplayName) {
        fNullableDisplayName = argNullableDisplayName;
    }

    /**
     * フィールド [NULLABLE_DISPLAY_NAME] の値を取得します。
     *
     * フィールドの説明: [NULLABLEを表示可能な文字に読み替えたもの。[java.sql.ResultSetMetaData.] を除いた文字列が格納されます。]。
     *
     * @return フィールド[NULLABLE_DISPLAY_NAME]から取得した値。
     */
    public String getNullableDisplayName() {
        return fNullableDisplayName;
    }

    /**
     * フィールド [REMARKS] の値を設定します。
     *
     * フィールドの説明: [メタ情報の REMARKS。コメント記述。]。
     *
     * @param argRemarks フィールド[REMARKS]に設定する値。
     */
    public void setRemarks(final String argRemarks) {
        fRemarks = argRemarks;
    }

    /**
     * フィールド [REMARKS] の値を取得します。
     *
     * フィールドの説明: [メタ情報の REMARKS。コメント記述。]。
     *
     * @return フィールド[REMARKS]から取得した値。
     */
    public String getRemarks() {
        return fRemarks;
    }

    /**
     * フィールド [COLUMN_DEF] の値を設定します。
     *
     * フィールドの説明: [メタ情報の COLUMN_DEF。列のデフォルト値。]。
     *
     * @param argColumnDef フィールド[COLUMN_DEF]に設定する値。
     */
    public void setColumnDef(final String argColumnDef) {
        fColumnDef = argColumnDef;
    }

    /**
     * フィールド [COLUMN_DEF] の値を取得します。
     *
     * フィールドの説明: [メタ情報の COLUMN_DEF。列のデフォルト値。]。
     *
     * @return フィールド[COLUMN_DEF]から取得した値。
     */
    public String getColumnDef() {
        return fColumnDef;
    }

    /**
     * フィールド [SQL_DATA_TYPE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の SQL_DATA_TYPE。未使用。]。
     *
     * @param argSqlDataType フィールド[SQL_DATA_TYPE]に設定する値。
     */
    public void setSqlDataType(final int argSqlDataType) {
        fSqlDataType = argSqlDataType;
    }

    /**
     * フィールド [SQL_DATA_TYPE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の SQL_DATA_TYPE。未使用。]。
     *
     * @return フィールド[SQL_DATA_TYPE]から取得した値。
     */
    public int getSqlDataType() {
        return fSqlDataType;
    }

    /**
     * フィールド [SQL_DATETIME_SUB] の値を設定します。
     *
     * フィールドの説明: [メタ情報の SQL_DATETIME_SUB。未使用。]。
     *
     * @param argSqlDatetimeSub フィールド[SQL_DATETIME_SUB]に設定する値。
     */
    public void setSqlDatetimeSub(final int argSqlDatetimeSub) {
        fSqlDatetimeSub = argSqlDatetimeSub;
    }

    /**
     * フィールド [SQL_DATETIME_SUB] の値を取得します。
     *
     * フィールドの説明: [メタ情報の SQL_DATETIME_SUB。未使用。]。
     *
     * @return フィールド[SQL_DATETIME_SUB]から取得した値。
     */
    public int getSqlDatetimeSub() {
        return fSqlDatetimeSub;
    }

    /**
     * フィールド [CHAR_OCTET_LENGTH] の値を設定します。
     *
     * フィールドの説明: [メタ情報の CHAR_OCTET_LENGTH。char型は列の最大バイト数。]。
     *
     * @param argCharOctetLength フィールド[CHAR_OCTET_LENGTH]に設定する値。
     */
    public void setCharOctetLength(final int argCharOctetLength) {
        fCharOctetLength = argCharOctetLength;
    }

    /**
     * フィールド [CHAR_OCTET_LENGTH] の値を取得します。
     *
     * フィールドの説明: [メタ情報の CHAR_OCTET_LENGTH。char型は列の最大バイト数。]。
     *
     * @return フィールド[CHAR_OCTET_LENGTH]から取得した値。
     */
    public int getCharOctetLength() {
        return fCharOctetLength;
    }

    /**
     * フィールド [ORDINAL_POSITION] の値を設定します。
     *
     * フィールドの説明: [メタ情報の ORDINAL_POSITION。テーブル中の列インデックス (1オリジン)]。
     *
     * @param argOrdinalPosition フィールド[ORDINAL_POSITION]に設定する値。
     */
    public void setOrdinalPosition(final int argOrdinalPosition) {
        fOrdinalPosition = argOrdinalPosition;
    }

    /**
     * フィールド [ORDINAL_POSITION] の値を取得します。
     *
     * フィールドの説明: [メタ情報の ORDINAL_POSITION。テーブル中の列インデックス (1オリジン)]。
     *
     * @return フィールド[ORDINAL_POSITION]から取得した値。
     */
    public int getOrdinalPosition() {
        return fOrdinalPosition;
    }

    /**
     * フィールド [IS_NULLABLE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の IS_NULLABLE。使用は推奨されません。]。
     *
     * @param argIsNullable フィールド[IS_NULLABLE]に設定する値。
     */
    public void setIsNullable(final String argIsNullable) {
        fIsNullable = argIsNullable;
    }

    /**
     * フィールド [IS_NULLABLE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の IS_NULLABLE。使用は推奨されません。]。
     *
     * @return フィールド[IS_NULLABLE]から取得した値。
     */
    public String getIsNullable() {
        return fIsNullable;
    }

    /**
     * フィールド [SCOPE_CATLOG] の値を設定します。
     *
     * フィールドの説明: [SCOPE_CATLOG]。
     *
     * @param argScopeCatlog フィールド[SCOPE_CATLOG]に設定する値。
     */
    public void setScopeCatlog(final String argScopeCatlog) {
        fScopeCatlog = argScopeCatlog;
    }

    /**
     * フィールド [SCOPE_CATLOG] の値を取得します。
     *
     * フィールドの説明: [SCOPE_CATLOG]。
     *
     * @return フィールド[SCOPE_CATLOG]から取得した値。
     */
    public String getScopeCatlog() {
        return fScopeCatlog;
    }

    /**
     * フィールド [SCOPE_SCHEMA] の値を設定します。
     *
     * フィールドの説明: [SCOPE_SCHEMA]。
     *
     * @param argScopeSchema フィールド[SCOPE_SCHEMA]に設定する値。
     */
    public void setScopeSchema(final String argScopeSchema) {
        fScopeSchema = argScopeSchema;
    }

    /**
     * フィールド [SCOPE_SCHEMA] の値を取得します。
     *
     * フィールドの説明: [SCOPE_SCHEMA]。
     *
     * @return フィールド[SCOPE_SCHEMA]から取得した値。
     */
    public String getScopeSchema() {
        return fScopeSchema;
    }

    /**
     * フィールド [SCOPE_TABLE] の値を設定します。
     *
     * フィールドの説明: [SCOPE_TABLE]。
     *
     * @param argScopeTable フィールド[SCOPE_TABLE]に設定する値。
     */
    public void setScopeTable(final String argScopeTable) {
        fScopeTable = argScopeTable;
    }

    /**
     * フィールド [SCOPE_TABLE] の値を取得します。
     *
     * フィールドの説明: [SCOPE_TABLE]。
     *
     * @return フィールド[SCOPE_TABLE]から取得した値。
     */
    public String getScopeTable() {
        return fScopeTable;
    }

    /**
     * フィールド [SOURCE_DATA_TYPE] の値を設定します。
     *
     * フィールドの説明: [SOURCE_DATA_TYPE]。
     *
     * @param argSourceDataType フィールド[SOURCE_DATA_TYPE]に設定する値。
     */
    public void setSourceDataType(final int argSourceDataType) {
        fSourceDataType = argSourceDataType;
    }

    /**
     * フィールド [SOURCE_DATA_TYPE] の値を取得します。
     *
     * フィールドの説明: [SOURCE_DATA_TYPE]。
     *
     * @return フィールド[SOURCE_DATA_TYPE]から取得した値。
     */
    public int getSourceDataType() {
        return fSourceDataType;
    }

    /**
     * フィールド [WRITABLE] の値を設定します。
     *
     * フィールドの説明: [SQL実行: その列が書き込み可能であるかどうか。(通常のメタ情報からは得られません。)]。
     *
     * @param argWritable フィールド[WRITABLE]に設定する値。
     */
    public void setWritable(final boolean argWritable) {
        fWritable = argWritable;
    }

    /**
     * フィールド [WRITABLE] の値を取得します。
     *
     * フィールドの説明: [SQL実行: その列が書き込み可能であるかどうか。(通常のメタ情報からは得られません。)]。
     *
     * @return フィールド[WRITABLE]から取得した値。
     */
    public boolean getWritable() {
        return fWritable;
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
