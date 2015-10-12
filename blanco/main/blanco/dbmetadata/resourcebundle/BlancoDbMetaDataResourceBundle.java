/*
 * ���̃\�[�X�R�[�h�� blanco Framework�ɂ�莩����������܂����B
 */
package blanco.dbmetadata.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * BlancoDbMetaData�����p���郊�\�[�X�o���h����~���܂��B
 *
 * ���\�[�X�o���h����`: [BlancoDbMetaData]�B<BR>
 * ���̃N���X�̓��\�[�X�o���h����`�����玩���������ꂽ���\�[�X�o���h���N���X�ł��B<BR>
 * ���m�̃��P�[��<BR>
 * <UL>
 * <LI>ja
 * </UL>
 */
public class BlancoDbMetaDataResourceBundle {
    /**
     * ���\�[�X�o���h���I�u�W�F�N�g�B
     *
     * �����I�Ɏ��ۂɓ��͂��s�����\�[�X�o���h�����L�����܂��B
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoDbMetaDataResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoDbMetaData]�A�f�t�H���g�̃��P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     */
    public BlancoDbMetaDataResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoDbMetaDataResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoDbMetaData]�A�w�肳�ꂽ���P�[���A�Ăяo�����̃N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     */
    public BlancoDbMetaDataResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoDbMetaDataResourceBundle�N���X�̃R���X�g���N�^�B
     *
     * ��ꖼ[BlancoDbMetaData]�A�w�肳�ꂽ���P�[���A�w�肳�ꂽ�N���X���[�_���g�p���āA���\�[�X�o���h�����擾���܂��B
     *
     * @param locale ���P�[���̎w��
     * @param loader �N���X���[�_�̎w��
     */
    public BlancoDbMetaDataResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("blanco/dbmetadata/resourcebundle/BlancoDbMetaData", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g���擾���܂��B
     *
     * @return �����I�ɕێ����Ă��郊�\�[�X�o���h���I�u�W�F�N�g�B
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoDbMetaData], key[META2XML.ERR001]
     *
     * [�G���[���b�Z�[�W] (ja)<br>
     *
     * @return key[META2XML.ERR001]�ɑΉ�����l�B�O������ǂݍ��݂��ł��Ȃ��ꍇ�ɂ́A��`���̒l��߂��܂��B�K��null�ȊO�̒l���߂�܂��B
     */
    public String getMeta2xmlErr001() {
        // �����l�Ƃ��Ē�`���̒l�𗘗p���܂��B
        String strFormat = "�G���[���b�Z�[�W";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("META2XML.ERR001");
            }
        } catch (MissingResourceException ex) {
        }
        // �u��������͂ЂƂ�����܂���B
        return strFormat;
    }
}
