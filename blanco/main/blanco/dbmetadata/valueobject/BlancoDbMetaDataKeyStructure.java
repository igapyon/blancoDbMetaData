/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.valueobject;

/**
 * キーに関する情報を格納します。java.sql.DatabaseMetaData.getImportedKeys 、java.sql.DatabaseMetaData.getExportedKeys 、 java.sql.DatabaseMetaData.getPrimaryKeys の戻り値を格納します。
 */
public class BlancoDbMetaDataKeyStructure {
    /**
     * 主キーの表カタログ。
     *
     * フィールド: [PKTABLE_CAT]。
     */
    private String fPktableCat;

    /**
     * 主キーの表スキーマ。
     *
     * フィールド: [PKTABLE_SCHEM]。
     */
    private String fPktableSchem;

    /**
     * 主キーの表名。
     *
     * フィールド: [PKTABLE_NAME]。
     */
    private String fPktableName;

    /**
     * PKCOLUMN_NAME、またはCOLUMN_NAME: 主キーの列名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。COLUMN_NAMEが格納されます。
     *
     * フィールド: [PKCOLUMN_NAME]。
     */
    private String fPkcolumnName;

    /**
     * 外部キーの表カタログ。
     *
     * フィールド: [FKTABLE_CAT]。
     */
    private String fFktableCat;

    /**
     * 外部キーの表スキーマ。
     *
     * フィールド: [FKTABLE_SCHEM]。
     */
    private String fFktableSchem;

    /**
     * 外部キーの表名。
     *
     * フィールド: [FKTABLE_NAME]。
     */
    private String fFktableName;

    /**
     * 外部キーの列名。
     *
     * フィールド: [FKCOLUMN_NAME]。
     */
    private String fFkcolumnName;

    /**
     * KEY_SEQ: キーのなかの連番。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。
     *
     * フィールド: [KEY_SEQ]。
     */
    private short fKeySeq;

    /**
     * フィールド: [UPDATE_RULE]。
     */
    private short fUpdateRule;

    /**
     * フィールド: [DELETE_RULE]。
     */
    private short fDeleteRule;

    /**
     * 外部キー名。
     *
     * フィールド: [FK_NAME]。
     */
    private String fFkName;

    /**
     * PK_NAME: 主キー名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。
     *
     * フィールド: [PK_NAME]。
     */
    private String fPkName;

    /**
     * フィールド: [DEFERRABILITY]。
     */
    private short fDeferrability;

    /**
     * フィールド [PKTABLE_CAT] の値を設定します。
     *
     * フィールドの説明: [主キーの表カタログ。]。
     *
     * @param argPktableCat フィールド[PKTABLE_CAT]に設定する値。
     */
    public void setPktableCat(final String argPktableCat) {
        fPktableCat = argPktableCat;
    }

    /**
     * フィールド [PKTABLE_CAT] の値を取得します。
     *
     * フィールドの説明: [主キーの表カタログ。]。
     *
     * @return フィールド[PKTABLE_CAT]から取得した値。
     */
    public String getPktableCat() {
        return fPktableCat;
    }

    /**
     * フィールド [PKTABLE_SCHEM] の値を設定します。
     *
     * フィールドの説明: [主キーの表スキーマ。]。
     *
     * @param argPktableSchem フィールド[PKTABLE_SCHEM]に設定する値。
     */
    public void setPktableSchem(final String argPktableSchem) {
        fPktableSchem = argPktableSchem;
    }

    /**
     * フィールド [PKTABLE_SCHEM] の値を取得します。
     *
     * フィールドの説明: [主キーの表スキーマ。]。
     *
     * @return フィールド[PKTABLE_SCHEM]から取得した値。
     */
    public String getPktableSchem() {
        return fPktableSchem;
    }

    /**
     * フィールド [PKTABLE_NAME] の値を設定します。
     *
     * フィールドの説明: [主キーの表名。]。
     *
     * @param argPktableName フィールド[PKTABLE_NAME]に設定する値。
     */
    public void setPktableName(final String argPktableName) {
        fPktableName = argPktableName;
    }

    /**
     * フィールド [PKTABLE_NAME] の値を取得します。
     *
     * フィールドの説明: [主キーの表名。]。
     *
     * @return フィールド[PKTABLE_NAME]から取得した値。
     */
    public String getPktableName() {
        return fPktableName;
    }

    /**
     * フィールド [PKCOLUMN_NAME] の値を設定します。
     *
     * フィールドの説明: [PKCOLUMN_NAME、またはCOLUMN_NAME: 主キーの列名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。COLUMN_NAMEが格納されます。]。
     *
     * @param argPkcolumnName フィールド[PKCOLUMN_NAME]に設定する値。
     */
    public void setPkcolumnName(final String argPkcolumnName) {
        fPkcolumnName = argPkcolumnName;
    }

    /**
     * フィールド [PKCOLUMN_NAME] の値を取得します。
     *
     * フィールドの説明: [PKCOLUMN_NAME、またはCOLUMN_NAME: 主キーの列名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。COLUMN_NAMEが格納されます。]。
     *
     * @return フィールド[PKCOLUMN_NAME]から取得した値。
     */
    public String getPkcolumnName() {
        return fPkcolumnName;
    }

    /**
     * フィールド [FKTABLE_CAT] の値を設定します。
     *
     * フィールドの説明: [外部キーの表カタログ。]。
     *
     * @param argFktableCat フィールド[FKTABLE_CAT]に設定する値。
     */
    public void setFktableCat(final String argFktableCat) {
        fFktableCat = argFktableCat;
    }

    /**
     * フィールド [FKTABLE_CAT] の値を取得します。
     *
     * フィールドの説明: [外部キーの表カタログ。]。
     *
     * @return フィールド[FKTABLE_CAT]から取得した値。
     */
    public String getFktableCat() {
        return fFktableCat;
    }

    /**
     * フィールド [FKTABLE_SCHEM] の値を設定します。
     *
     * フィールドの説明: [外部キーの表スキーマ。]。
     *
     * @param argFktableSchem フィールド[FKTABLE_SCHEM]に設定する値。
     */
    public void setFktableSchem(final String argFktableSchem) {
        fFktableSchem = argFktableSchem;
    }

    /**
     * フィールド [FKTABLE_SCHEM] の値を取得します。
     *
     * フィールドの説明: [外部キーの表スキーマ。]。
     *
     * @return フィールド[FKTABLE_SCHEM]から取得した値。
     */
    public String getFktableSchem() {
        return fFktableSchem;
    }

    /**
     * フィールド [FKTABLE_NAME] の値を設定します。
     *
     * フィールドの説明: [外部キーの表名。]。
     *
     * @param argFktableName フィールド[FKTABLE_NAME]に設定する値。
     */
    public void setFktableName(final String argFktableName) {
        fFktableName = argFktableName;
    }

    /**
     * フィールド [FKTABLE_NAME] の値を取得します。
     *
     * フィールドの説明: [外部キーの表名。]。
     *
     * @return フィールド[FKTABLE_NAME]から取得した値。
     */
    public String getFktableName() {
        return fFktableName;
    }

    /**
     * フィールド [FKCOLUMN_NAME] の値を設定します。
     *
     * フィールドの説明: [外部キーの列名。]。
     *
     * @param argFkcolumnName フィールド[FKCOLUMN_NAME]に設定する値。
     */
    public void setFkcolumnName(final String argFkcolumnName) {
        fFkcolumnName = argFkcolumnName;
    }

    /**
     * フィールド [FKCOLUMN_NAME] の値を取得します。
     *
     * フィールドの説明: [外部キーの列名。]。
     *
     * @return フィールド[FKCOLUMN_NAME]から取得した値。
     */
    public String getFkcolumnName() {
        return fFkcolumnName;
    }

    /**
     * フィールド [KEY_SEQ] の値を設定します。
     *
     * フィールドの説明: [KEY_SEQ: キーのなかの連番。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。]。
     *
     * @param argKeySeq フィールド[KEY_SEQ]に設定する値。
     */
    public void setKeySeq(final short argKeySeq) {
        fKeySeq = argKeySeq;
    }

    /**
     * フィールド [KEY_SEQ] の値を取得します。
     *
     * フィールドの説明: [KEY_SEQ: キーのなかの連番。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。]。
     *
     * @return フィールド[KEY_SEQ]から取得した値。
     */
    public short getKeySeq() {
        return fKeySeq;
    }

    /**
     * フィールド [UPDATE_RULE] の値を設定します。
     *
     * @param argUpdateRule フィールド[UPDATE_RULE]に設定する値。
     */
    public void setUpdateRule(final short argUpdateRule) {
        fUpdateRule = argUpdateRule;
    }

    /**
     * フィールド [UPDATE_RULE] の値を取得します。
     *
     * @return フィールド[UPDATE_RULE]から取得した値。
     */
    public short getUpdateRule() {
        return fUpdateRule;
    }

    /**
     * フィールド [DELETE_RULE] の値を設定します。
     *
     * @param argDeleteRule フィールド[DELETE_RULE]に設定する値。
     */
    public void setDeleteRule(final short argDeleteRule) {
        fDeleteRule = argDeleteRule;
    }

    /**
     * フィールド [DELETE_RULE] の値を取得します。
     *
     * @return フィールド[DELETE_RULE]から取得した値。
     */
    public short getDeleteRule() {
        return fDeleteRule;
    }

    /**
     * フィールド [FK_NAME] の値を設定します。
     *
     * フィールドの説明: [外部キー名。]。
     *
     * @param argFkName フィールド[FK_NAME]に設定する値。
     */
    public void setFkName(final String argFkName) {
        fFkName = argFkName;
    }

    /**
     * フィールド [FK_NAME] の値を取得します。
     *
     * フィールドの説明: [外部キー名。]。
     *
     * @return フィールド[FK_NAME]から取得した値。
     */
    public String getFkName() {
        return fFkName;
    }

    /**
     * フィールド [PK_NAME] の値を設定します。
     *
     * フィールドの説明: [PK_NAME: 主キー名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。]。
     *
     * @param argPkName フィールド[PK_NAME]に設定する値。
     */
    public void setPkName(final String argPkName) {
        fPkName = argPkName;
    }

    /**
     * フィールド [PK_NAME] の値を取得します。
     *
     * フィールドの説明: [PK_NAME: 主キー名。java.sql.DatabaseMetaData.getPrimaryKeys で利用されています。]。
     *
     * @return フィールド[PK_NAME]から取得した値。
     */
    public String getPkName() {
        return fPkName;
    }

    /**
     * フィールド [DEFERRABILITY] の値を設定します。
     *
     * @param argDeferrability フィールド[DEFERRABILITY]に設定する値。
     */
    public void setDeferrability(final short argDeferrability) {
        fDeferrability = argDeferrability;
    }

    /**
     * フィールド [DEFERRABILITY] の値を取得します。
     *
     * @return フィールド[DEFERRABILITY]から取得した値。
     */
    public short getDeferrability() {
        return fDeferrability;
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
