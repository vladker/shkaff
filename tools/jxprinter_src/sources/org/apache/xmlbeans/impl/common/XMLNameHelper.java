package org.apache.xmlbeans.impl.common;

import java.io.UnsupportedEncodingException;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.xml.stream.XMLName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XMLNameHelper {
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static XMLName forLN(String str) {
        return new XmlNameImpl("", str);
    }

    public static XMLName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new XmlNameImpl(str2, str);
    }

    public static XMLName forPretty(String str, int i5) {
        int iIndexOf = str.indexOf(64, i5);
        return iIndexOf < 0 ? new XmlNameImpl("", str.substring(i5)) : new XmlNameImpl(str.substring(iIndexOf + 1), str.substring(i5, iIndexOf));
    }

    public static QName getQName(XMLName xMLName) {
        if (xMLName == null) {
            return null;
        }
        return QNameHelper.forLNS(xMLName.getLocalName(), xMLName.getNamespaceUri());
    }

    public static String hexsafe(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (isSafe(cCharAt)) {
                sb.append(cCharAt);
            } else {
                try {
                    byte[] bytes = str.substring(i5, i5 + 1).getBytes("UTF-8");
                    for (int i6 = 0; i6 < bytes.length; i6++) {
                        sb.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        sb.append(cArr[(bytes[i6] >> 4) & 15]);
                        sb.append(cArr[bytes[i6] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    sb.append("_BAD_UTF8_CHAR");
                }
            }
        }
        return sb.toString();
    }

    public static String hexsafedir(XMLName xMLName) {
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().length() == 0) {
            return "_nons/" + hexsafe(xMLName.getLocalName());
        }
        return hexsafe(xMLName.getNamespaceUri()) + PackagingURIHelper.FORWARD_SLASH_STRING + hexsafe(xMLName.getLocalName());
    }

    private static boolean isSafe(int i5) {
        if (i5 >= 97 && i5 <= 122) {
            return true;
        }
        if (i5 < 65 || i5 > 90) {
            return i5 >= 48 && i5 <= 57;
        }
        return true;
    }

    public static String pretty(XMLName xMLName) {
        if (xMLName == null) {
            return AbstractC1127c.NULL;
        }
        if (xMLName.getNamespaceUri() == null || xMLName.getNamespaceUri().length() == 0) {
            return xMLName.getLocalName();
        }
        return xMLName.getLocalName() + "@" + xMLName.getNamespaceUri();
    }
}
