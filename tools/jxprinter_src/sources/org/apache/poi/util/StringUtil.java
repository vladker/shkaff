package org.apache.poi.util;

import A3.AbstractC0157z;
import com.google.zxing.pdf417.PDF417Common;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class StringUtil {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 10000000;
    private static int MAX_RECORD_LENGTH = 10000000;
    public static final Charset UTF16LE = StandardCharsets.UTF_16LE;
    public static final Charset UTF8 = StandardCharsets.UTF_8;
    public static final Charset WIN_1252 = Charset.forName("cp1252");
    private static final int[] symbolMap_f020 = {32, 33, 8704, 35, 8707, 37, 38, 8717, 40, 41, 8727, 43, 44, 8722, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 920, PDF417Common.NUMBER_OF_CODEWORDS, 931, CodePageUtil.CP_SJIS, 933, 962, 937, 926, CodePageUtil.CP_GBK, 918, 91, 8765, 93, 8869, 95, 32, 945, 946, 967, 948, CodePageUtil.CP_MS949, 966, 947, 951, 953, 981, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, 123, 124, 125, 8764, 32};
    private static final int[] symbolMap_f0a0 = {8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8591, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 181, 8706, 8729, 247, 8800, 8801, 8776, 8230, 9168, 9135, 8629, 8501, 8475, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, Videoio.CAP_PROP_IOS_DEVICE_FOCUS, 174, 169, 8482, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 32, Videoio.CAP_PROP_IOS_DEVICE_EXPOSURE, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 32};

    private StringUtil() {
    }

    public static int countMatches(CharSequence charSequence, char c) {
        if (charSequence == null) {
            return 0;
        }
        int length = charSequence.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (charSequence.charAt(i6) == c) {
                i5++;
            }
        }
        return i5;
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(true, str.length() - length, str2, 0, length);
    }

    public static int getEncodedSize(String str) {
        return (str.length() * (hasMultibyte(str) ? 2 : 1)) + 3;
    }

    public static String getFromCompressedUTF8(byte[] bArr, int i5, int i6) {
        return new String(bArr, i5, Math.min(i6, bArr.length - i5), StandardCharsets.UTF_8);
    }

    public static String getFromCompressedUnicode(byte[] bArr, int i5, int i6) {
        return new String(bArr, i5, Math.min(i6, bArr.length - i5), StandardCharsets.ISO_8859_1);
    }

    public static String getFromUnicodeLE(byte[] bArr, int i5, int i6) {
        if (i6 == 0) {
            return "";
        }
        if (i5 < 0 || i5 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.l(")", bArr.length, AbstractC0157z.t(i5, "Illegal offset ", " (String data is of length ")));
        }
        if (i6 < 0 || (bArr.length - i5) / 2 < i6) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Illegal length "));
        }
        return new String(bArr, i5, i6 * 2, UTF16LE);
    }

    public static String getFromUnicodeLE0Terminated(byte[] bArr, int i5, int i6) {
        String str;
        if (i5 < 0 || i5 >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0157z.l(")", bArr.length, AbstractC0157z.t(i5, "Illegal offset ", " (String data is of length ")));
        }
        if (i6 < 0 || (bArr.length - i5) / 2 < i6) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Illegal length "));
        }
        int i7 = 0;
        if (i6 <= 0 || i5 >= bArr.length - 1 || bArr[i5] != 0 || bArr[i5 + 1] != 0) {
            str = "";
        } else {
            i5 += 2;
            i6 = Character.isJavaIdentifierPart(i6 > 1 ? LittleEndian.getShort(bArr, i5) : (short) 0) ? i6 - 1 : 0;
            str = "?";
        }
        while (i7 < i6) {
            int i8 = (i7 * 2) + i5;
            if (bArr[i8] == 0 && bArr[i8 + 1] == 0) {
                break;
            }
            i7++;
        }
        int iMin = Math.min(i7, i6);
        return str.concat(iMin != 0 ? new String(bArr, i5, iMin * 2, UTF16LE) : "");
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static String getPreferredEncoding() {
        return StandardCharsets.ISO_8859_1.name();
    }

    public static byte[] getToUnicodeLE(String str) {
        return str.getBytes(UTF16LE);
    }

    public static boolean hasMultibyte(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (c > 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length = length(charSequence);
        if (length == 0) {
            return true;
        }
        for (int i5 = 0; i5 < length; i5++) {
            if (!Character.isWhitespace(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    @Internal
    public static boolean isUpperCase(char c) {
        String string = Character.toString(c);
        return string.toUpperCase(Locale.ROOT).equals(string);
    }

    @Internal
    public static String join(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(objArr[0]);
        for (int i5 = 1; i5 < objArr.length; i5++) {
            sb.append(str);
            sb.append(objArr[i5]);
        }
        return sb.toString();
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mapMsCodepoint(int i5) {
        if (61472 > i5 || i5 > 61567) {
            return (61600 > i5 || i5 > 61695) ? i5 : symbolMap_f0a0[i5 - 61600];
        }
        return symbolMap_f020[i5 - 61472];
    }

    public static String mapMsCodepointString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int[] array = str.codePoints().map(new l()).toArray();
        return new String(array, 0, array.length);
    }

    public static void putCompressedUnicode(String str, byte[] bArr, int i5) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        System.arraycopy(bytes, 0, bArr, i5, bytes.length);
    }

    public static void putUnicodeLE(String str, byte[] bArr, int i5) {
        byte[] bytes = str.getBytes(UTF16LE);
        System.arraycopy(bytes, 0, bArr, i5, bytes.length);
    }

    public static String readCompressedUnicode(LittleEndianInput littleEndianInput, int i5) {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, MAX_RECORD_LENGTH);
        littleEndianInput.readFully(bArrSafelyAllocate);
        return new String(bArrSafelyAllocate, StandardCharsets.ISO_8859_1);
    }

    public static String readUnicodeLE(LittleEndianInput littleEndianInput, int i5) {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(((long) i5) * 2, MAX_RECORD_LENGTH);
        littleEndianInput.readFully(bArrSafelyAllocate);
        return new String(bArrSafelyAllocate, UTF16LE);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput) {
        int uShort = littleEndianInput.readUShort();
        return (littleEndianInput.readByte() & 1) == 0 ? readCompressedUnicode(littleEndianInput, uShort) : readUnicodeLE(littleEndianInput, uShort);
    }

    public static String repeat(char c, int i5) {
        if (i5 <= 0) {
            return "";
        }
        char[] cArr = new char[i5];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        return str.regionMatches(true, 0, str2, 0, str2.length());
    }

    @Internal
    public static String toLowerCase(char c) {
        return Character.toString(c).toLowerCase(Locale.ROOT);
    }

    @Internal
    public static String toUpperCase(char c) {
        return Character.toString(c).toUpperCase(Locale.ROOT);
    }

    public static void writeUnicodeString(LittleEndianOutput littleEndianOutput, String str) {
        littleEndianOutput.writeShort(str.length());
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void writeUnicodeStringFlagAndData(LittleEndianOutput littleEndianOutput, String str) {
        boolean zHasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(zHasMultibyte ? 1 : 0);
        if (zHasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void putCompressedUnicode(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static void putUnicodeLE(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(UTF16LE));
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput, int i5) {
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, i5);
        }
        return readUnicodeLE(littleEndianInput, i5);
    }

    @Internal
    public static String join(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }

    @Internal
    public static String join(String str, Object... objArr) {
        return join(objArr, str);
    }

    public static String getFromUnicodeLE(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        return getFromUnicodeLE(bArr, 0, bArr.length / 2);
    }
}
