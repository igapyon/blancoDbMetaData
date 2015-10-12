/*
 * このソースコードは blanco Frameworkにより自動生成されました。
 */
package blanco.dbmetadata.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * BlancoDbMetaDataが利用するリソースバンドルを蓄えます。
 *
 * リソースバンドル定義: [BlancoDbMetaData]。<BR>
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>ja
 * </UL>
 */
public class BlancoDbMetaDataResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoDbMetaDataResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoDbMetaData]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public BlancoDbMetaDataResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoDbMetaDataResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoDbMetaData]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public BlancoDbMetaDataResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoDbMetaDataResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoDbMetaData]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public BlancoDbMetaDataResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * 内部的に保持しているリソースバンドルオブジェクトを取得します。
     *
     * @return 内部的に保持しているリソースバンドルオブジェクト。
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoDbMetaData], key[META2XML.ERR001]
     *
     * [エラーメッセージ] (ja)<br>
     *
     * @return key[META2XML.ERR001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMeta2xmlErr001() {
        // 初期値として定義書の値を利用します。
        String strFormat = "エラーメッセージ";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ERR001");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
