package org.apache.poi.openxml4j.opc;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ContentTypes {
    public static final String CORE_PROPERTIES_PART = "application/vnd.openxmlformats-package.core-properties+xml";
    public static final String CUSTOM_XML_PART = "application/vnd.openxmlformats-officedocument.customXmlProperties+xml";
    public static final String DIGITAL_SIGNATURE_CERTIFICATE_PART = "application/vnd.openxmlformats-package.digital-signature-certificate";
    public static final String DIGITAL_SIGNATURE_ORIGIN_PART = "application/vnd.openxmlformats-package.digital-signature-origin";
    public static final String DIGITAL_SIGNATURE_XML_SIGNATURE_PART = "application/vnd.openxmlformats-package.digital-signature-xmlsignature+xml";
    public static final String EXTENSION_GIF = "gif";
    public static final String EXTENSION_JPG_1 = "jpg";
    public static final String EXTENSION_JPG_2 = "jpeg";
    public static final String EXTENSION_PICT = "pict";
    public static final String EXTENSION_PNG = "png";
    public static final String EXTENSION_TIFF = "tiff";
    public static final String EXTENSION_XML = "xml";
    public static final String IMAGE_GIF = "image/gif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PICT = "image/x-pict";
    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_TIFF = "image/tiff";
    public static final String PLAIN_OLD_XML = "application/xml";
    public static final String RELATIONSHIPS_PART = "application/vnd.openxmlformats-package.relationships+xml";
    public static final String XML = "text/xml";

    public static String getContentTypeFromFileExtension(String str) {
        byte b = 1;
        String lowerCase = str.substring(str.lastIndexOf(46) + 1).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        switch (lowerCase.hashCode()) {
            case 102340:
                b = !lowerCase.equals(EXTENSION_GIF) ? (byte) -1 : (byte) 0;
                break;
            case 105441:
                if (!lowerCase.equals(EXTENSION_JPG_1)) {
                    b = -1;
                }
                break;
            case 111145:
                b = !lowerCase.equals(EXTENSION_PNG) ? (byte) -1 : (byte) 2;
                break;
            case 118807:
                b = !lowerCase.equals("xml") ? (byte) -1 : (byte) 3;
                break;
            case 3268712:
                b = !lowerCase.equals(EXTENSION_JPG_2) ? (byte) -1 : (byte) 4;
                break;
            case 3440682:
                b = !lowerCase.equals(EXTENSION_PICT) ? (byte) -1 : (byte) 5;
                break;
            case 3559925:
                b = !lowerCase.equals(EXTENSION_TIFF) ? (byte) -1 : (byte) 6;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return IMAGE_GIF;
            case 1:
            case 4:
                return IMAGE_JPEG;
            case 2:
                return IMAGE_PNG;
            case 3:
                return XML;
            case 5:
                return IMAGE_PICT;
            case 6:
                return IMAGE_TIFF;
            default:
                return null;
        }
    }
}
