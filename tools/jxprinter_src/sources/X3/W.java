package X3;

import A3.AbstractC0139g;
import A3.AbstractC0151t;
import A3.C0136d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class W extends V {
    private static final String String(byte[] bytes, int i5, int i6, Charset charset) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        kotlin.jvm.internal.E.f(charset, "charset");
        return new String(bytes, i5, i6, charset);
    }

    public static /* synthetic */ String a(int i5, char[] cArr, int i6, int i7) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = cArr.length;
        }
        return concatToString(cArr, i5, i6);
    }

    public static final String capitalize(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.E.e(locale, "getDefault(...)");
        return capitalize(str, locale);
    }

    private static final int codePointAt(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.codePointAt(i5);
    }

    private static final int codePointBefore(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.codePointBefore(i5);
    }

    private static final int codePointCount(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.codePointCount(i5, i6);
    }

    public static final int compareTo(String str, String other, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        return z6 ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static String concatToString(char[] cArr) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        return new String(cArr);
    }

    private static final boolean contentEquals(String str, CharSequence charSequence) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(charSequence, "charSequence");
        return str.contentEquals(charSequence);
    }

    public static final String decapitalize(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        String strSubstring = str.substring(0, 1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.E.e(locale, "getDefault(...)");
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        String strSubstring2 = str.substring(1);
        kotlin.jvm.internal.E.e(strSubstring2, "substring(...)");
        return lowerCase.concat(strSubstring2);
    }

    public static String decodeToString(byte[] bArr) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        return new String(bArr, C0241g.UTF_8);
    }

    public static byte[] encodeToByteArray(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        byte[] bytes = str.getBytes(C0241g.UTF_8);
        kotlin.jvm.internal.E.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean endsWith(String str, String suffix, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(suffix, "suffix");
        return !z6 ? str.endsWith(suffix) : regionMatches(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static boolean equals(String str, String str2, boolean z6) {
        if (str == null) {
            return str2 == null;
        }
        return !z6 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    private static final String format(String str, Object... args) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(args, "args");
        return String.format(str, Arrays.copyOf(args, args.length));
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(kotlin.jvm.internal.X x6) {
        kotlin.jvm.internal.E.f(x6, "<this>");
        Comparator<String> CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.E.e(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    private static final String intern(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String strIntern = str.intern();
        kotlin.jvm.internal.E.e(strIntern, "intern(...)");
        return strIntern;
    }

    private static final String lowercase(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final int nativeIndexOf(String str, char c, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.indexOf(c, i5);
    }

    private static final int nativeLastIndexOf(String str, char c, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.lastIndexOf(c, i5);
    }

    private static final int offsetByCodePoints(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return str.offsetByCodePoints(i5, i6);
    }

    public static final boolean regionMatches(CharSequence charSequence, int i5, CharSequence other, int i6, int i7, boolean z6) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        return ((charSequence instanceof String) && (other instanceof String)) ? regionMatches((String) charSequence, i5, (String) other, i6, i7, z6) : b0.regionMatchesImpl(charSequence, i5, other, i6, i7, z6);
    }

    public static final String repeat(CharSequence charSequence, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i5 + '.').toString());
        }
        if (i5 == 0) {
            return "";
        }
        int i6 = 1;
        if (i5 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                cArr[i7] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i5);
        if (1 <= i5) {
            while (true) {
                sb.append(charSequence);
                if (i6 == i5) {
                    break;
                }
                i6++;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.E.c(string);
        return string;
    }

    public static final String replace(String str, char c, char c6, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        if (!z6) {
            String strReplace = str.replace(c, c6);
            kotlin.jvm.internal.E.e(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (AbstractC0240f.b(cCharAt, c, z6)) {
                cCharAt = c6;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final String replaceFirst(String str, char c, char c6, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        int iD = b0.d(str, c, 0, z6, 2);
        return iD < 0 ? str : b0.replaceRange((CharSequence) str, iD, iD + 1, (CharSequence) String.valueOf(c6)).toString();
    }

    public static final List<String> split(CharSequence charSequence, Pattern regex, int i5) {
        kotlin.jvm.internal.E.f(charSequence, "<this>");
        kotlin.jvm.internal.E.f(regex, "regex");
        b0.j(i5);
        if (i5 == 0) {
            i5 = -1;
        }
        String[] strArrSplit = regex.split(charSequence, i5);
        kotlin.jvm.internal.E.e(strArrSplit, "split(...)");
        return AbstractC0151t.asList(strArrSplit);
    }

    public static boolean startsWith(String str, String prefix, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        return !z6 ? str.startsWith(prefix) : regionMatches(str, 0, prefix, 0, prefix.length(), z6);
    }

    private static final String substring(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String strSubstring = str.substring(i5);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    private static final byte[] toByteArray(String str, Charset charset) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.E.e(bytes, "getBytes(...)");
        return bytes;
    }

    public static final char[] toCharArray(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = str.length();
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        char[] cArr = new char[i6 - i5];
        str.getChars(i5, i6, cArr, 0);
        return cArr;
    }

    private static final String toLowerCase(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String lowerCase = str.toLowerCase();
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final Pattern toPattern(String str, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        Pattern patternCompile = Pattern.compile(str, i5);
        kotlin.jvm.internal.E.e(patternCompile, "compile(...)");
        return patternCompile;
    }

    private static final String toUpperCase(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String upperCase = str.toUpperCase();
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String upperCase = str.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String String(byte[] bytes, Charset charset) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        kotlin.jvm.internal.E.f(charset, "charset");
        return new String(bytes, charset);
    }

    public static final String capitalize(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            String upperCase = strSubstring.toUpperCase(locale);
            kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        kotlin.jvm.internal.E.e(strSubstring2, "substring(...)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static String concatToString(char[] cArr, int i5, int i6) {
        kotlin.jvm.internal.E.f(cArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = cArr.length;
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        return new String(cArr, i5, i6 - i5);
    }

    private static final boolean contentEquals(String str, StringBuffer stringBuilder) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(stringBuilder, "stringBuilder");
        return str.contentEquals(stringBuilder);
    }

    public static final String decapitalize(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        String strSubstring = str.substring(0, 1);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        String strSubstring2 = str.substring(1);
        kotlin.jvm.internal.E.e(strSubstring2, "substring(...)");
        return lowerCase.concat(strSubstring2);
    }

    public static final String decodeToString(byte[] bArr, int i5, int i6, boolean z6) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = bArr.length;
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        if (!z6) {
            return new String(bArr, i5, i6 - i5, C0241g.UTF_8);
        }
        CharsetDecoder charsetDecoderNewDecoder = C0241g.UTF_8.newDecoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr, i5, i6 - i5)).toString();
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public static final byte[] encodeToByteArray(String str, int i5, int i6, boolean z6) throws CharacterCodingException {
        kotlin.jvm.internal.E.f(str, "<this>");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = str.length();
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        if (!z6) {
            String strSubstring = str.substring(i5, i6);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            byte[] bytes = strSubstring.getBytes(C0241g.UTF_8);
            kotlin.jvm.internal.E.e(bytes, "getBytes(...)");
            return bytes;
        }
        CharsetEncoder charsetEncoderNewEncoder = C0241g.UTF_8.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
        ByteBuffer byteBufferEncode = charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).encode(CharBuffer.wrap(str, i5, i6));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            kotlin.jvm.internal.E.c(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                kotlin.jvm.internal.E.c(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    private static final String format(kotlin.jvm.internal.X x6, String format, Object... args) {
        kotlin.jvm.internal.E.f(x6, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        kotlin.jvm.internal.E.f(args, "args");
        return String.format(format, Arrays.copyOf(args, args.length));
    }

    private static final String lowercase(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final int nativeIndexOf(String str, String str2, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(str2, "str");
        return str.indexOf(str2, i5);
    }

    private static final int nativeLastIndexOf(String str, String str2, int i5) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(str2, "str");
        return str.lastIndexOf(str2, i5);
    }

    private static final String substring(String str, int i5, int i6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        String strSubstring = str.substring(i5, i6);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    private static final String toLowerCase(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        String lowerCase = str.toLowerCase(locale);
        kotlin.jvm.internal.E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final String toUpperCase(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String uppercase(String str, Locale locale) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(locale, "locale");
        String upperCase = str.toUpperCase(locale);
        kotlin.jvm.internal.E.e(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private static final String String(byte[] bytes, int i5, int i6) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return new String(bytes, i5, i6, C0241g.UTF_8);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return b0.contentEqualsImpl(charSequence, charSequence2);
    }

    private static final String format(String str, Locale locale, Object... args) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(args, "args");
        return String.format(locale, str, Arrays.copyOf(args, args.length));
    }

    public static final String replaceFirst(String str, String oldValue, String newValue, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(oldValue, "oldValue");
        kotlin.jvm.internal.E.f(newValue, "newValue");
        int iE = b0.e(str, oldValue, 0, z6, 2);
        return iE < 0 ? str : b0.replaceRange((CharSequence) str, iE, oldValue.length() + iE, (CharSequence) newValue).toString();
    }

    public static final boolean startsWith(String str, String prefix, int i5, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(prefix, "prefix");
        if (!z6) {
            return str.startsWith(prefix, i5);
        }
        return regionMatches(str, i5, prefix, 0, prefix.length(), z6);
    }

    private static final char[] toCharArray(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        char[] charArray = str.toCharArray();
        kotlin.jvm.internal.E.e(charArray, "toCharArray(...)");
        return charArray;
    }

    private static final String String(byte[] bytes) {
        kotlin.jvm.internal.E.f(bytes, "bytes");
        return new String(bytes, C0241g.UTF_8);
    }

    private static final String format(kotlin.jvm.internal.X x6, Locale locale, String format, Object... args) {
        kotlin.jvm.internal.E.f(x6, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        kotlin.jvm.internal.E.f(args, "args");
        return String.format(locale, format, Arrays.copyOf(args, args.length));
    }

    public static boolean regionMatches(String str, int i5, String other, int i6, int i7, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(other, "other");
        if (!z6) {
            return str.regionMatches(i5, other, i6, i7);
        }
        return str.regionMatches(z6, i5, other, i6, i7);
    }

    private static final char[] toCharArray(String str, char[] destination, int i5, int i6, int i7) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(destination, "destination");
        str.getChars(i6, i7, destination, i5);
        return destination;
    }

    private static final String String(char[] chars) {
        kotlin.jvm.internal.E.f(chars, "chars");
        return new String(chars);
    }

    private static final String String(char[] chars, int i5, int i6) {
        kotlin.jvm.internal.E.f(chars, "chars");
        return new String(chars, i5, i6);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2, boolean z6) {
        if (z6) {
            return b0.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return contentEquals(charSequence, charSequence2);
    }

    public static final String replace(String str, String oldValue, String newValue, boolean z6) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(oldValue, "oldValue");
        kotlin.jvm.internal.E.f(newValue, "newValue");
        int i5 = 0;
        int iIndexOf = b0.indexOf(str, oldValue, 0, z6);
        if (iIndexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        int i6 = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i5, iIndexOf);
                sb.append(newValue);
                i5 = iIndexOf + length;
                if (iIndexOf >= str.length()) {
                    break;
                }
                iIndexOf = b0.indexOf(str, oldValue, iIndexOf + i6, z6);
            } while (iIndexOf > 0);
            sb.append((CharSequence) str, i5, str.length());
            String string = sb.toString();
            kotlin.jvm.internal.E.e(string, "toString(...)");
            return string;
        }
        throw new OutOfMemoryError();
    }

    private static final String String(int[] codePoints, int i5, int i6) {
        kotlin.jvm.internal.E.f(codePoints, "codePoints");
        return new String(codePoints, i5, i6);
    }

    private static final String String(StringBuffer stringBuffer) {
        kotlin.jvm.internal.E.f(stringBuffer, "stringBuffer");
        return new String(stringBuffer);
    }

    private static final String String(StringBuilder stringBuilder) {
        kotlin.jvm.internal.E.f(stringBuilder, "stringBuilder");
        return new String(stringBuilder);
    }
}
