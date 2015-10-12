/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.valueobject;

import java.util.List;

/**
 * 表の定義情報を格納します。
 */
public class BlancoDbMetaDataTableStructure {
    /**
     * メタ情報の TABLE_NAME
     *
     * フィールド: [NAME]。
     */
    private String fName;

    /**
     * メタ情報の TABLE_TYPE
     *
     * フィールド: [TYPE]。
     */
    private String fType;

    /**
     * メタ情報の TABLE_CAT
     *
     * フィールド: [CATALOG]。
     */
    private String fCatalog;

    /**
     * メタ情報の TABLE_SCHEM
     *
     * フィールド: [SCHEMA]。
     */
    private String fSchema;

    /**
     * メタ情報の REMARKS
     *
     * フィールド: [REMARKS]。
     */
    private String fRemarks;

    /**
     * 表に含まれる項目。
     *
     * フィールド: [columns]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>()]。
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> fColumns = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>();

    /**
     * 表に含まれるプライマリキー情報。
     *
     * フィールド: [primaryKeys]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fPrimaryKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * フィールド: [importedKeys]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fImportedKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * フィールド: [exportedKeys]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fExportedKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * フィールド: [crossReferenceKeys]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     */
    private List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> fCrossReferenceKeys = new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>();

    /**
     * フィールド [NAME] の値を設定します。
     *
     * フィールドの説明: [メタ情報の TABLE_NAME]。
     *
     * @param argName フィールド[NAME]に設定する値。
     */
    public void setName(final String argName) {
        fName = argName;
    }

    /**
     * フィールド [NAME] の値を取得します。
     *
     * フィールドの説明: [メタ情報の TABLE_NAME]。
     *
     * @return フィールド[NAME]から取得した値。
     */
    public String getName() {
        return fName;
    }

    /**
     * フィールド [TYPE] の値を設定します。
     *
     * フィールドの説明: [メタ情報の TABLE_TYPE]。
     *
     * @param argType フィールド[TYPE]に設定する値。
     */
    public void setType(final String argType) {
        fType = argType;
    }

    /**
     * フィールド [TYPE] の値を取得します。
     *
     * フィールドの説明: [メタ情報の TABLE_TYPE]。
     *
     * @return フィールド[TYPE]から取得した値。
     */
    public String getType() {
        return fType;
    }

    /**
     * フィールド [CATALOG] の値を設定します。
     *
     * フィールドの説明: [メタ情報の TABLE_CAT]。
     *
     * @param argCatalog フィールド[CATALOG]に設定する値。
     */
    public void setCatalog(final String argCatalog) {
        fCatalog = argCatalog;
    }

    /**
     * フィールド [CATALOG] の値を取得します。
     *
     * フィールドの説明: [メタ情報の TABLE_CAT]。
     *
     * @return フィールド[CATALOG]から取得した値。
     */
    public String getCatalog() {
        return fCatalog;
    }

    /**
     * フィールド [SCHEMA] の値を設定します。
     *
     * フィールドの説明: [メタ情報の TABLE_SCHEM]。
     *
     * @param argSchema フィールド[SCHEMA]に設定する値。
     */
    public void setSchema(final String argSchema) {
        fSchema = argSchema;
    }

    /**
     * フィールド [SCHEMA] の値を取得します。
     *
     * フィールドの説明: [メタ情報の TABLE_SCHEM]。
     *
     * @return フィールド[SCHEMA]から取得した値。
     */
    public String getSchema() {
        return fSchema;
    }

    /**
     * フィールド [REMARKS] の値を設定します。
     *
     * フィールドの説明: [メタ情報の REMARKS]。
     *
     * @param argRemarks フィールド[REMARKS]に設定する値。
     */
    public void setRemarks(final String argRemarks) {
        fRemarks = argRemarks;
    }

    /**
     * フィールド [REMARKS] の値を取得します。
     *
     * フィールドの説明: [メタ情報の REMARKS]。
     *
     * @return フィールド[REMARKS]から取得した値。
     */
    public String getRemarks() {
        return fRemarks;
    }

    /**
     * フィールド [columns] の値を設定します。
     *
     * フィールドの説明: [表に含まれる項目。]。
     *
     * @param argColumns フィールド[columns]に設定する値。
     */
    public void setColumns(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> argColumns) {
        fColumns = argColumns;
    }

    /**
     * フィールド [columns] の値を取得します。
     *
     * フィールドの説明: [表に含まれる項目。]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure>()]。
     *
     * @return フィールド[columns]から取得した値。
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataColumnStructure> getColumns() {
        return fColumns;
    }

    /**
     * フィールド [primaryKeys] の値を設定します。
     *
     * フィールドの説明: [表に含まれるプライマリキー情報。]。
     *
     * @param argPrimaryKeys フィールド[primaryKeys]に設定する値。
     */
    public void setPrimaryKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argPrimaryKeys) {
        fPrimaryKeys = argPrimaryKeys;
    }

    /**
     * フィールド [primaryKeys] の値を取得します。
     *
     * フィールドの説明: [表に含まれるプライマリキー情報。]。
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     *
     * @return フィールド[primaryKeys]から取得した値。
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getPrimaryKeys() {
        return fPrimaryKeys;
    }

    /**
     * フィールド [importedKeys] の値を設定します。
     *
     * @param argImportedKeys フィールド[importedKeys]に設定する値。
     */
    public void setImportedKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argImportedKeys) {
        fImportedKeys = argImportedKeys;
    }

    /**
     * フィールド [importedKeys] の値を取得します。
     *
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     *
     * @return フィールド[importedKeys]から取得した値。
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getImportedKeys() {
        return fImportedKeys;
    }

    /**
     * フィールド [exportedKeys] の値を設定します。
     *
     * @param argExportedKeys フィールド[exportedKeys]に設定する値。
     */
    public void setExportedKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argExportedKeys) {
        fExportedKeys = argExportedKeys;
    }

    /**
     * フィールド [exportedKeys] の値を取得します。
     *
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     *
     * @return フィールド[exportedKeys]から取得した値。
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getExportedKeys() {
        return fExportedKeys;
    }

    /**
     * フィールド [crossReferenceKeys] の値を設定します。
     *
     * @param argCrossReferenceKeys フィールド[crossReferenceKeys]に設定する値。
     */
    public void setCrossReferenceKeys(final List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> argCrossReferenceKeys) {
        fCrossReferenceKeys = argCrossReferenceKeys;
    }

    /**
     * フィールド [crossReferenceKeys] の値を取得します。
     *
     * デフォルト: [new java.util.ArrayList<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure>()]。
     *
     * @return フィールド[crossReferenceKeys]から取得した値。
     */
    public List<blanco.dbmetadata.valueobject.BlancoDbMetaDataKeyStructure> getCrossReferenceKeys() {
        return fCrossReferenceKeys;
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
