package org.apache.xmlbeans.impl.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class XsTypeConverter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_PREFIX = "";
    private static final char NAMESPACE_SEP = ':';
    private static final String NAN_LEX = "NaN";
    private static final String NEG_INF_LEX = "-INF";
    private static final String POS_INF_LEX = "INF";
    private static final BigDecimal DECIMAL__ZERO = new BigDecimal(0.0d);
    private static final String[] URI_CHARS_TO_BE_REPLACED = {" ", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, "|", "\\", "^", "[", "]", "`"};
    private static final String[] URI_CHARS_REPLACED_WITH = {"%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60"};
    private static final char[] CH_ZEROS = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};

    public static GDateSpecification getGDateValue(Date date, int i5) {
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(i5);
        return gDateBuilder.toGDate();
    }

    public static String getQNameString(String str, String str2, String str3) {
        if (str3 == null || str == null || str.length() <= 0 || str3.length() <= 0) {
            return str2;
        }
        return str3 + ':' + str2;
    }

    public static CharSequence lexAnyURI(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.toString());
        for (int i5 = 0; i5 < URI_CHARS_TO_BE_REPLACED.length; i5++) {
            int i6 = 0;
            while (true) {
                int iIndexOf = sb.indexOf(URI_CHARS_TO_BE_REPLACED[i5], i6);
                if (iIndexOf >= 0) {
                    sb.replace(iIndexOf, iIndexOf + 1, URI_CHARS_REPLACED_WITH[i5]);
                    i6 = iIndexOf + 3;
                }
            }
        }
        try {
            URI.create(sb.toString());
            return charSequence;
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException("invalid anyURI value: " + ((Object) charSequence), e);
        }
    }

    public static boolean lexBoolean(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            if ('0' == cCharAt) {
                return false;
            }
            if ('1' == cCharAt) {
                return true;
            }
        } else if (length != 4) {
            if (length == 5 && 'f' == charSequence.charAt(0) && 'a' == charSequence.charAt(1) && 'l' == charSequence.charAt(2) && 's' == charSequence.charAt(3) && 'e' == charSequence.charAt(4)) {
                return false;
            }
        } else if ('t' == charSequence.charAt(0) && 'r' == charSequence.charAt(1) && 'u' == charSequence.charAt(2) && 'e' == charSequence.charAt(3)) {
            return true;
        }
        throw new InvalidLexicalValueException("invalid boolean: " + ((Object) charSequence));
    }

    public static byte lexByte(CharSequence charSequence) {
        return parseByte(charSequence);
    }

    public static XmlCalendar lexDateTime(CharSequence charSequence) {
        return getGDateValue(charSequence, 14).getCalendar();
    }

    public static BigDecimal lexDecimal(CharSequence charSequence) {
        return new BigDecimal(trimTrailingZeros(charSequence.toString()));
    }

    public static double lexDouble(CharSequence charSequence) {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && ((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'd' || cCharAt == 'D')) {
                throw new NumberFormatException("Invalid char '" + cCharAt + "' in double.");
            }
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Double.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Double.NaN;
            }
            throw e;
        }
    }

    public static float lexFloat(CharSequence charSequence) {
        char cCharAt;
        String string = charSequence.toString();
        try {
            if (charSequence.length() > 0 && (((cCharAt = charSequence.charAt(charSequence.length() - 1)) == 'f' || cCharAt == 'F') && charSequence.charAt(charSequence.length() - 2) != 'N')) {
                throw new NumberFormatException("Invalid char '" + cCharAt + "' in float.");
            }
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            if (string.equals(POS_INF_LEX)) {
                return Float.POSITIVE_INFINITY;
            }
            if (string.equals(NEG_INF_LEX)) {
                return Float.NEGATIVE_INFINITY;
            }
            if (string.equals(NAN_LEX)) {
                return Float.NaN;
            }
            throw e;
        }
    }

    public static GDate lexGDate(CharSequence charSequence) {
        return new GDate(charSequence);
    }

    public static int lexInt(CharSequence charSequence) {
        return parseInt(charSequence);
    }

    public static BigInteger lexInteger(CharSequence charSequence) {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '+' && charSequence.charAt(1) == '-') {
            throw new NumberFormatException("Illegal char sequence '+-'");
        }
        return new BigInteger(trimInitialPlus(charSequence.toString()));
    }

    public static long lexLong(CharSequence charSequence) {
        return Long.parseLong(trimInitialPlus(charSequence.toString()));
    }

    public static QName lexQName(CharSequence charSequence, NamespaceContext namespaceContext) {
        String str;
        String string;
        String string2;
        int i5 = 0;
        while (true) {
            str = "";
            if (i5 >= charSequence.length()) {
                string = charSequence.toString();
                string2 = "";
                break;
            }
            if (charSequence.charAt(i5) == ':') {
                string2 = charSequence.subSequence(0, i5).toString();
                string = charSequence.subSequence(i5 + 1, charSequence.length()).toString();
                if (i5 != 0) {
                    break;
                }
                throw new InvalidLexicalValueException("invalid xsd:QName '" + charSequence.toString() + "'");
            }
            i5++;
        }
        String namespaceURI = namespaceContext.getNamespaceURI(string2);
        if (namespaceURI != null) {
            str = namespaceURI;
        } else if (string2 != null && string2.length() > 0) {
            throw new InvalidLexicalValueException("Can't resolve prefix: ".concat(string2));
        }
        return new QName(str, string);
    }

    public static short lexShort(CharSequence charSequence) {
        return parseShort(charSequence);
    }

    private static byte parseByte(CharSequence charSequence) {
        return (byte) parseIntXsdNumber(charSequence, -128, 127);
    }

    private static int parseInt(CharSequence charSequence) {
        return parseIntXsdNumber(charSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int parseIntXsdNumber(CharSequence charSequence, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int length = charSequence.length();
        int i10 = 1;
        if (length < 1) {
            throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
        }
        char cCharAt = charSequence.charAt(0);
        if (cCharAt == '-') {
            i7 = i5 / 10;
            i8 = -(i5 % 10);
            i9 = 1;
        } else {
            if (cCharAt == '+') {
                int i11 = -(i6 / 10);
                int i12 = i6 % 10;
                i7 = i11;
                i8 = i12;
                i9 = 1;
            } else {
                int i13 = -(i6 / 10);
                int i14 = i6 % 10;
                i7 = i13;
                i8 = i14;
                i9 = 0;
            }
            i10 = -1;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < length - i9; i16++) {
            int iDigit = Character.digit(charSequence.charAt(i16 + i9), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
            }
            if (i15 < i7 || (i15 == i7 && iDigit > i8)) {
                throw new NumberFormatException("For input string: \"" + charSequence.toString() + "\"");
            }
            i15 = (i15 * 10) - iDigit;
        }
        return i10 * i15;
    }

    private static short parseShort(CharSequence charSequence) {
        return (short) parseIntXsdNumber(charSequence, -32768, 32767);
    }

    public static String printBoolean(boolean z6) {
        return z6 ? "true" : "false";
    }

    public static String printByte(byte b) {
        return Byte.toString(b);
    }

    public static String printDate(Calendar calendar) {
        return printDateTime(calendar, 16);
    }

    public static String printDateTime(Calendar calendar) {
        return printDateTime(calendar, 14);
    }

    public static String printDecimal(BigDecimal bigDecimal) {
        char[] cArr;
        char[] cArr2;
        String string = bigDecimal.unscaledValue().toString();
        int iScale = bigDecimal.scale();
        if (iScale == 0 || (bigDecimal.longValue() == 0 && iScale < 0)) {
            return string;
        }
        int i5 = bigDecimal.signum() < 0 ? 1 : 0;
        StringBuilder sb = new StringBuilder(Math.abs(iScale) + string.length() + 1);
        if (i5 == 1) {
            sb.append('-');
        }
        if (iScale > 0) {
            int length = iScale - (string.length() - i5);
            if (length >= 0) {
                sb.append("0.");
                while (true) {
                    cArr2 = CH_ZEROS;
                    if (length <= cArr2.length) {
                        break;
                    }
                    sb.append(cArr2);
                    length -= cArr2.length;
                }
                sb.append(cArr2, 0, length);
                sb.append(string.substring(i5));
            } else {
                int i6 = i5 - length;
                sb.append(string.substring(i5, i6));
                sb.append('.');
                sb.append(string.substring(i6));
            }
        } else {
            sb.append(string.substring(i5));
            while (true) {
                cArr = CH_ZEROS;
                if (iScale >= (-cArr.length)) {
                    break;
                }
                sb.append(cArr);
                iScale += cArr.length;
            }
            sb.append(cArr, 0, -iScale);
        }
        return sb.toString();
    }

    public static String printDouble(double d) {
        if (d == Double.POSITIVE_INFINITY) {
            return POS_INF_LEX;
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return NEG_INF_LEX;
        }
        return Double.isNaN(d) ? NAN_LEX : Double.toString(d);
    }

    public static String printFloat(float f6) {
        if (f6 == Float.POSITIVE_INFINITY) {
            return POS_INF_LEX;
        }
        if (f6 == Float.NEGATIVE_INFINITY) {
            return NEG_INF_LEX;
        }
        return Float.isNaN(f6) ? NAN_LEX : Float.toString(f6);
    }

    public static String printGDate(GDate gDate, Collection<XmlError> collection) {
        return gDate.toString();
    }

    public static CharSequence printHexBinary(byte[] bArr) {
        return HexBin.bytesToString(bArr);
    }

    public static String printInt(int i5) {
        return Integer.toString(i5);
    }

    public static String printInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static String printLong(long j6) {
        return Long.toString(j6);
    }

    public static String printQName(QName qName, NamespaceContext namespaceContext, Collection<XmlError> collection) {
        String prefix;
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.length() > 0) {
            prefix = namespaceContext.getPrefix(namespaceURI);
            if (prefix == null) {
                collection.add(XmlError.forMessage("NamespaceContext does not provide prefix for namespaceURI ".concat(namespaceURI)));
            }
        } else {
            prefix = null;
        }
        return getQNameString(namespaceURI, qName.getLocalPart(), prefix);
    }

    public static String printShort(short s6) {
        return Short.toString(s6);
    }

    public static String printTime(Calendar calendar) {
        return printDateTime(calendar, 15);
    }

    private static String trimInitialPlus(String str) {
        return (str.length() <= 0 || str.charAt(0) != '+') ? str : str.substring(1);
    }

    private static String trimTrailingZeros(String str) {
        int iLastIndexOf;
        int length = str.length() - 1;
        if (str.charAt(length) != '0' || (iLastIndexOf = str.lastIndexOf(46)) < 0) {
            return str;
        }
        while (length > iLastIndexOf) {
            if (str.charAt(length) != '0') {
                return str.substring(0, length + 1);
            }
            length--;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static byte lexByte(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexByte(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid byte: " + ((Object) charSequence)));
            return (byte) 0;
        }
    }

    public static GDate lexGDate(String str, Collection<XmlError> collection) {
        try {
            return lexGDate(str);
        } catch (IllegalArgumentException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new GDateBuilder().toGDate();
        }
    }

    public static int lexInt(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexInt(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid int:" + ((Object) charSequence)));
            return 0;
        }
    }

    public static short lexShort(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexShort(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid short: " + ((Object) charSequence)));
            return (short) 0;
        }
    }

    public static String printDate(Date date) {
        return getGDateValue(date, 16).toString();
    }

    public static String printDateTime(Calendar calendar, int i5) {
        return getGDateValue(calendar, i5).toString();
    }

    public static long lexLong(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexLong(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid long: " + ((Object) charSequence)));
            return 0L;
        }
    }

    public static GDateSpecification getGDateValue(Calendar calendar, int i5) {
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(i5);
        return gDateBuilder.toGDate();
    }

    public static String printDateTime(Date date) {
        return getGDateValue(date, 14).toString();
    }

    public static BigInteger lexInteger(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexInteger(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid long: " + ((Object) charSequence)));
            return BigInteger.ZERO;
        }
    }

    public static GDateSpecification getGDateValue(CharSequence charSequence, int i5) {
        GDateBuilder gDateBuilder = new GDateBuilder(charSequence);
        gDateBuilder.setBuiltinTypeCode(i5);
        return gDateBuilder.toGDate();
    }

    public static double lexDouble(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexDouble(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid double: " + ((Object) charSequence)));
            return Double.NaN;
        }
    }

    public static float lexFloat(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexFloat(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage("invalid float: " + ((Object) charSequence)));
            return Float.NaN;
        }
    }

    public static QName lexQName(String str, Collection<XmlError> collection, NamespaceContext namespaceContext) {
        try {
            return lexQName(str, namespaceContext);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new QName(null, str.substring(str.indexOf(58)));
        }
    }

    public static boolean lexBoolean(CharSequence charSequence, Collection<XmlError> collection) {
        try {
            return lexBoolean(charSequence);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return false;
        }
    }

    public static String printString(String str) {
        return str;
    }
}
