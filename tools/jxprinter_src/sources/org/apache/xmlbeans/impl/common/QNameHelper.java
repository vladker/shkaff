package org.apache.xmlbeans.impl.common;

import A3.AbstractC0157z;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.namespace.QName;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.soap.SOAPConstants;
import org.apache.xmlbeans.xml.stream.XMLName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QNameHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_NAME_LENGTH = 64;
    public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
    private static final Map<String, String> WELL_KNOWN_PREFIXES = buildWKP();
    private static final char[] hexdigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static Map<String, String> buildWKP() {
        HashMap map = new HashMap();
        map.put("http://www.w3.org/XML/1998/namespace", "xml");
        map.put("http://www.w3.org/2001/XMLSchema", "xs");
        map.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        map.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
        map.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
        map.put(SOAPConstants.URI_NS_SOAP_ENVELOPE, "soapenv");
        return Collections.unmodifiableMap(map);
    }

    public static QName forLN(String str) {
        return new QName("", str);
    }

    public static QName forLNS(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new QName(str2, str);
    }

    public static QName forPretty(String str, int i5) {
        int iIndexOf = str.indexOf(64, i5);
        return iIndexOf < 0 ? new QName("", str.substring(i5)) : new QName(str.substring(iIndexOf + 1), str.substring(i5, iIndexOf));
    }

    public static String getLocalPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public static String getPrefixPart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : "";
    }

    public static XMLName getXMLName(QName qName) {
        if (qName == null) {
            return null;
        }
        return XMLNameHelper.forLNS(qName.getLocalPart(), qName.getNamespaceURI());
    }

    public static String hexsafe(String str) {
        byte[] bytes;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (isSafe(cCharAt)) {
                sb.append(cCharAt);
            } else {
                try {
                    byte[] bytes2 = str.substring(i5, i5 + 1).getBytes("UTF-8");
                    for (int i6 = 0; i6 < bytes2.length; i6++) {
                        sb.append(NameUtil.USCORE);
                        char[] cArr = hexdigits;
                        sb.append(cArr[(bytes2[i6] >> 4) & 15]);
                        sb.append(cArr[bytes2[i6] & 15]);
                    }
                } catch (UnsupportedEncodingException unused) {
                    sb.append("_BAD_UTF8_CHAR");
                }
            }
        }
        if (sb.length() <= 64) {
            return sb.toString();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            try {
                bytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                bytes = new byte[0];
            }
            byte[] bArrDigest = messageDigest.digest(bytes);
            StringBuilder sb2 = new StringBuilder(URI_SHA1_PREFIX);
            for (int i7 = 0; i7 < bArrDigest.length; i7++) {
                char[] cArr2 = hexdigits;
                sb2.append(cArr2[(bArrDigest[i7] >> 4) & 15]);
                sb2.append(cArr2[bArrDigest[i7] & 15]);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused3) {
            throw new IllegalStateException("Using in a JDK without an SHA implementation");
        }
    }

    public static String hexsafedir(QName qName) {
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return "_nons/" + hexsafe(qName.getLocalPart());
        }
        return hexsafe(qName.getNamespaceURI()) + PackagingURIHelper.FORWARD_SLASH_STRING + hexsafe(qName.getLocalPart());
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

    private static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String namespace(SchemaType schemaType) {
        while (schemaType != null) {
            if (schemaType.getName() != null) {
                return schemaType.getName().getNamespaceURI();
            }
            if (schemaType.getContainerField() != null && schemaType.getContainerField().getName().getNamespaceURI().length() > 0) {
                return schemaType.getContainerField().getName().getNamespaceURI();
            }
            schemaType = schemaType.getOuterType();
        }
        return "";
    }

    public static String pretty(QName qName) {
        if (qName == null) {
            return AbstractC1127c.NULL;
        }
        if (qName.getNamespaceURI() == null || qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    public static String readable(SchemaType schemaType) {
        return readable(schemaType, WELL_KNOWN_PREFIXES);
    }

    private static boolean startsWithXml(String str, int i5) {
        if (str.length() < i5 + 3) {
            return false;
        }
        if (str.charAt(i5) != 'X' && str.charAt(i5) != 'x') {
            return false;
        }
        int i6 = i5 + 1;
        if (str.charAt(i6) != 'M' && str.charAt(i6) != 'm') {
            return false;
        }
        int i7 = i5 + 2;
        return str.charAt(i7) == 'L' || str.charAt(i7) == 'l';
    }

    public static String suggestPrefix(String str) {
        String str2 = WELL_KNOWN_PREFIXES.get(str);
        if (str2 != null) {
            return str2;
        }
        int length = str.length();
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf > 0 && iLastIndexOf == str.length() - 1) {
            iLastIndexOf = str.lastIndexOf(47, iLastIndexOf - 1);
            length = iLastIndexOf;
        }
        int i5 = iLastIndexOf + 1;
        if (str.startsWith("www.", i5)) {
            i5 = iLastIndexOf + 5;
        }
        while (i5 < length && !XMLChar.isNCNameStart(str.charAt(i5))) {
            i5++;
        }
        for (int i6 = i5 + 1; i6 < length; i6++) {
            if (!XMLChar.isNCName(str.charAt(i6)) || !Character.isLetterOrDigit(str.charAt(i6))) {
                length = i6;
                break;
            }
        }
        int i7 = i5 + 3;
        if (str.length() < i7 || !startsWithXml(str, i5)) {
            if (length - i5 > 4) {
                length = (!isVowel(str.charAt(i5 + 2)) || isVowel(str.charAt(i7))) ? i7 : i5 + 4;
            }
            return length - i5 == 0 ? "ns" : str.substring(i5, length).toLowerCase(Locale.ROOT);
        }
        if (str.length() < i5 + 4) {
            return "ns";
        }
        return "x" + Character.toLowerCase(str.charAt(i7));
    }

    public static String readable(SchemaType schemaType, Map<String, String> map) {
        if (schemaType.getName() != null) {
            return readable(schemaType.getName(), map);
        }
        if (schemaType.isAttributeType()) {
            return "attribute type " + readable(schemaType.getAttributeTypeAttributeName(), map);
        }
        if (schemaType.isDocumentType()) {
            return "document type " + readable(schemaType.getDocumentElementName(), map);
        }
        if (schemaType.isNoType() || schemaType.getOuterType() == null) {
            return "invalid type";
        }
        SchemaType outerType = schemaType.getOuterType();
        SchemaField containerField = schemaType.getContainerField();
        if (outerType.isAttributeType()) {
            return "type of attribute " + readable(containerField.getName(), map);
        }
        if (outerType.isDocumentType()) {
            return "type of element " + readable(containerField.getName(), map);
        }
        if (containerField != null) {
            if (containerField.isAttribute()) {
                return "type of " + containerField.getName().getLocalPart() + " attribute in " + readable(outerType, map);
            }
            return "type of " + containerField.getName().getLocalPart() + " element in " + readable(outerType, map);
        }
        if (outerType.getBaseType() == schemaType) {
            return "base type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() == 3) {
            return "item type of " + readable(outerType, map);
        }
        if (outerType.getSimpleVariety() != 2) {
            return "inner type in " + readable(outerType, map);
        }
        return "member type " + schemaType.getAnonymousUnionMemberOrdinal() + " of " + readable(outerType, map);
    }

    public static String readable(QName qName) {
        return readable(qName, WELL_KNOWN_PREFIXES);
    }

    public static String readable(QName qName, Map<String, String> map) {
        if (qName.getNamespaceURI().length() == 0) {
            return qName.getLocalPart();
        }
        String str = map.get(qName.getNamespaceURI());
        if (str != null) {
            StringBuilder sbX = AbstractC0157z.x(str, ParameterizedMessage.ERROR_MSG_SEPARATOR);
            sbX.append(qName.getLocalPart());
            return sbX.toString();
        }
        return qName.getLocalPart() + " in namespace " + qName.getNamespaceURI();
    }
}
