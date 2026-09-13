package org.apache.poi.xssf.usermodel.helpers;

import androidx.collection.a;
import java.util.Arrays;
import java.util.Base64;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.Internal;
import org.apache.poi.util.RandomSingleton;
import org.apache.poi.util.StringUtil;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal(since = "3.15 beta 3")
public final class XSSFPasswordHelper {
    private XSSFPasswordHelper() {
    }

    private static QName getAttrName(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return new QName(str2);
        }
        StringBuilder sbR = a.r(str);
        sbR.append(StringUtil.toUpperCase(str2.charAt(0)));
        sbR.append(str2.substring(1));
        return new QName(sbR.toString());
    }

    public static void setPassword(XmlObject xmlObject, String str, HashAlgorithm hashAlgorithm, String str2) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            if (str == null) {
                xmlCursorNewCursor.removeAttribute(getAttrName(str2, "password"));
                xmlCursorNewCursor.removeAttribute(getAttrName(str2, "algorithmName"));
                xmlCursorNewCursor.removeAttribute(getAttrName(str2, "hashValue"));
                xmlCursorNewCursor.removeAttribute(getAttrName(str2, "saltValue"));
                xmlCursorNewCursor.removeAttribute(getAttrName(str2, "spinCount"));
                xmlCursorNewCursor.close();
                return;
            }
            xmlCursorNewCursor.toFirstContentToken();
            if (hashAlgorithm == null) {
                int iCreateXorVerifier1 = CryptoFunctions.createXorVerifier1(str);
                QName attrName = getAttrName(str2, "password");
                Locale locale = Locale.ROOT;
                xmlCursorNewCursor.insertAttributeWithValue(attrName, String.format(locale, "%04X", Integer.valueOf(iCreateXorVerifier1)).toUpperCase(locale));
            } else {
                byte[] bArrGenerateSeed = RandomSingleton.getInstance().generateSeed(16);
                byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, hashAlgorithm, bArrGenerateSeed, BZip2Constants.BASEBLOCKSIZE, false);
                Base64.Encoder encoder = Base64.getEncoder();
                xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "algorithmName"), hashAlgorithm.jceId);
                xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "hashValue"), encoder.encodeToString(bArrHashPassword));
                xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "saltValue"), encoder.encodeToString(bArrGenerateSeed));
                xmlCursorNewCursor.insertAttributeWithValue(getAttrName(str2, "spinCount"), "100000");
            }
            xmlCursorNewCursor.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static boolean validatePassword(XmlObject xmlObject, String str, String str2) {
        if (str == null) {
            return false;
        }
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            String attributeText = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "password"));
            String attributeText2 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "algorithmName"));
            String attributeText3 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "hashValue"));
            String attributeText4 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "saltValue"));
            String attributeText5 = xmlCursorNewCursor.getAttributeText(getAttrName(str2, "spinCount"));
            if (attributeText != null) {
                boolean z6 = Integer.parseInt(attributeText, 16) == CryptoFunctions.createXorVerifier1(str);
                xmlCursorNewCursor.close();
                return z6;
            }
            if (attributeText3 == null || attributeText2 == null || attributeText4 == null || attributeText5 == null) {
                xmlCursorNewCursor.close();
                return false;
            }
            Base64.Decoder decoder = Base64.getDecoder();
            boolean zEquals = Arrays.equals(decoder.decode(attributeText3), CryptoFunctions.hashPassword(str, HashAlgorithm.fromString(attributeText2), decoder.decode(attributeText4), Integer.parseInt(attributeText5), false));
            xmlCursorNewCursor.close();
            return zEquals;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
