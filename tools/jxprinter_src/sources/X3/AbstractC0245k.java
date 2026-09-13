package X3;

import A3.AbstractC0139g;
import A3.AbstractC0151t;
import A3.AbstractC0157z;
import A3.C0136d;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: renamed from: X3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0245k {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            iArr[i6] = LOWER_CASE_HEX_DIGITS.charAt(i6 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(i6 >> 4) << '\b');
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i7 = 0; i7 < 256; i7++) {
            iArr2[i7] = UPPER_CASE_HEX_DIGITS.charAt(i7 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(i7 >> 4) << '\b');
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i8 = 0; i8 < 256; i8++) {
            iArr3[i8] = -1;
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < LOWER_CASE_HEX_DIGITS.length()) {
            iArr3[LOWER_CASE_HEX_DIGITS.charAt(i9)] = i10;
            i9++;
            i10++;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < UPPER_CASE_HEX_DIGITS.length()) {
            iArr3[UPPER_CASE_HEX_DIGITS.charAt(i11)] = i12;
            i11++;
            i12++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i13 = 0; i13 < 256; i13++) {
            jArr[i13] = -1;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < LOWER_CASE_HEX_DIGITS.length()) {
            jArr[LOWER_CASE_HEX_DIGITS.charAt(i14)] = i15;
            i14++;
            i15++;
        }
        int i16 = 0;
        while (i5 < UPPER_CASE_HEX_DIGITS.length()) {
            jArr[UPPER_CASE_HEX_DIGITS.charAt(i5)] = i16;
            i5++;
            i16++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    public static final long a(long j6, int i5, int i6) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j7 = i5;
        return ((j7 - 1) * ((long) i6)) + (j6 * j7);
    }

    public static final int b(long j6) {
        if (0 <= j6 && j6 <= 2147483647L) {
            return (int) j6;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) p147z3.J.m1290toStringimpl(p147z3.J.m1247constructorimpl(j6))));
    }

    public static final void c(String str, int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if (i8 < 1) {
            k(str, i5, i6, 1, "at least");
            throw null;
        }
        if (i8 > i7) {
            int i9 = (i8 + i5) - i7;
            while (i5 < i9) {
                if (str.charAt(i5) != '0') {
                    StringBuilder sbT = AbstractC0157z.t(i5, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    sbT.append(str.charAt(i5));
                    sbT.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(sbT.toString());
                }
                i5++;
            }
        }
    }

    public static final void d(String str, int i5, int i6, String str2, String str3, boolean z6, int i7) {
        if ((i6 - i5) - str2.length() <= str3.length()) {
            String strSubstring = str.substring(i5, i6);
            kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
            StringBuilder sbU = androidx.collection.a.u("Expected a hexadecimal number with prefix \"", str2, "\" and suffix \"", str3, "\", but was ");
            sbU.append(strSubstring);
            throw new NumberFormatException(sbU.toString());
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i8 = 0; i8 < length; i8++) {
                if (!AbstractC0240f.b(str2.charAt(i8), str.charAt(i5 + i8), z6)) {
                    l(str, i5, i6, str2, "prefix");
                    throw null;
                }
            }
            i5 += str2.length();
        }
        int length2 = i6 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i9 = 0; i9 < length3; i9++) {
                if (!AbstractC0240f.b(str3.charAt(i9), str.charAt(length2 + i9), z6)) {
                    l(str, length2, i6, str3, "suffix");
                    throw null;
                }
            }
        }
        c(str, i5, length2, i7);
    }

    public static final int e(byte[] bArr, int i5, int[] iArr, char[] cArr, int i6) {
        int i7 = iArr[bArr[i5] & UnsignedBytes.MAX_VALUE];
        cArr[i6] = (char) (i7 >> 8);
        cArr[i6 + 1] = (char) (i7 & 255);
        return i6 + 2;
    }

    public static final byte g(int i5, String str) {
        int[] iArr;
        int i6;
        int i7;
        char cCharAt = str.charAt(i5);
        if ((cCharAt >>> '\b') != 0 || (i6 = (iArr = HEX_DIGITS_TO_DECIMAL)[cCharAt]) < 0) {
            j(i5, str);
            throw null;
        }
        int i8 = i5 + 1;
        char cCharAt2 = str.charAt(i8);
        if ((cCharAt2 >>> '\b') == 0 && (i7 = iArr[cCharAt2]) >= 0) {
            return (byte) ((i6 << 4) | i7);
        }
        j(i8, str);
        throw null;
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    public static final int h(String str, int i5, int i6) {
        int i7;
        int i8 = 0;
        while (i5 < i6) {
            int i9 = i8 << 4;
            char cCharAt = str.charAt(i5);
            if ((cCharAt >>> '\b') != 0 || (i7 = HEX_DIGITS_TO_DECIMAL[cCharAt]) < 0) {
                j(i5, str);
                throw null;
            }
            i8 = i9 | i7;
            i5++;
        }
        return i8;
    }

    public static final byte hexToByte(String str, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    public static final byte[] hexToByteArray(String str, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i5, int i6, C0246l.b bVar) {
        return bVar.d ? hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i5, i6, bVar) : hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i5, i6, bVar);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i5, int i6, C0246l.b bVar) {
        String bytePrefix = bVar.getBytePrefix();
        String byteSuffix = bVar.getByteSuffix();
        String byteSeparator = bVar.getByteSeparator();
        long length = byteSeparator.length();
        long length2 = ((long) bytePrefix.length()) + 2 + ((long) byteSuffix.length()) + length;
        long j6 = i6 - i5;
        int i7 = (int) ((j6 + length) / length2);
        if ((((long) i7) * length2) - length != j6) {
            return null;
        }
        boolean z6 = bVar.e;
        byte[] bArr = new byte[i7];
        if (bytePrefix.length() != 0) {
            int length3 = bytePrefix.length();
            for (int i8 = 0; i8 < length3; i8++) {
                if (!AbstractC0240f.b(bytePrefix.charAt(i8), str.charAt(i5 + i8), z6)) {
                    l(str, i5, i6, bytePrefix, "byte prefix");
                    throw null;
                }
            }
            i5 += bytePrefix.length();
        }
        String strO = androidx.collection.a.o(byteSuffix, byteSeparator, bytePrefix);
        int i9 = i7 - 1;
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i10] = g(i5, str);
            i5 += 2;
            if (strO.length() != 0) {
                int length4 = strO.length();
                for (int i11 = 0; i11 < length4; i11++) {
                    if (!AbstractC0240f.b(strO.charAt(i11), str.charAt(i5 + i11), z6)) {
                        l(str, i5, i6, strO, "byte suffix + byte separator + byte prefix");
                        throw null;
                    }
                }
                i5 = strO.length() + i5;
            }
        }
        bArr[i9] = g(i5, str);
        int i12 = i5 + 2;
        if (byteSuffix.length() == 0) {
            return bArr;
        }
        int length5 = byteSuffix.length();
        for (int i13 = 0; i13 < length5; i13++) {
            if (!AbstractC0240f.b(byteSuffix.charAt(i13), str.charAt(i12 + i13), z6)) {
                l(str, i12, i6, byteSuffix, "byte suffix");
                throw null;
            }
        }
        return bArr;
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i5, int i6, C0246l.b bVar) {
        int length = bVar.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i7 = i6 - i5;
        int i8 = 2;
        if (length == 0) {
            if ((i7 & 1) != 0) {
                return null;
            }
            int i9 = i7 >> 1;
            byte[] bArr = new byte[i9];
            int i10 = 0;
            for (int i11 = 0; i11 < i9; i11++) {
                bArr[i11] = g(i10, str);
                i10 += 2;
            }
            return bArr;
        }
        if (i7 % 3 != 2) {
            return null;
        }
        int i12 = (i7 / 3) + 1;
        byte[] bArr2 = new byte[i12];
        char cCharAt = bVar.getByteSeparator().charAt(0);
        bArr2[0] = g(0, str);
        for (int i13 = 1; i13 < i12; i13++) {
            if (str.charAt(i8) != cCharAt) {
                String byteSeparator = bVar.getByteSeparator();
                boolean z6 = bVar.e;
                if (byteSeparator.length() == 0) {
                    continue;
                } else {
                    int length2 = byteSeparator.length();
                    for (int i14 = 0; i14 < length2; i14++) {
                        if (!AbstractC0240f.b(byteSeparator.charAt(i14), str.charAt(i8 + i14), z6)) {
                            l(str, i8, i6, byteSeparator, "byte separator");
                            throw null;
                        }
                    }
                    byteSeparator.length();
                }
            }
            bArr2[i13] = g(i8 + 1, str);
            i8 += 3;
        }
        return bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0183  */
    /* JADX WARN: Code duplicated, block: B:65:0x0186  */
    /* JADX WARN: Code duplicated, block: B:67:0x018d  */
    /* JADX WARN: Code duplicated, block: B:69:0x01a1 A[LOOP:2: B:66:0x018b->B:69:0x01a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ed A[LOOP:1: B:79:0x01d5->B:82:0x01ed, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x01a8 A[SYNTHETIC] */
    private static final byte[] hexToByteArraySlowPath(String str, int i5, int i6, C0246l.b bVar) throws Throwable {
        long jA;
        String str2;
        int i7;
        int length;
        int i8;
        String str3;
        String str4;
        int i9;
        int i10;
        int length2;
        int i11;
        int i12;
        String str5;
        int i13;
        String str6;
        int i14;
        int i15;
        int i16 = bVar.f863a;
        int i17 = bVar.b;
        String bytePrefix = bVar.getBytePrefix();
        String byteSuffix = bVar.getByteSuffix();
        String byteSeparator = bVar.getByteSeparator();
        String groupSeparator = bVar.getGroupSeparator();
        boolean z6 = bVar.e;
        int i18 = i6 - i5;
        int length3 = groupSeparator.length();
        int length4 = byteSeparator.length();
        int length5 = bytePrefix.length();
        int length6 = byteSuffix.length();
        if (i18 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j6 = ((long) length5) + 2 + ((long) length6);
        long jA2 = a(j6, i17, length4);
        if (i16 <= i17) {
            jA = a(j6, i16, length4);
        } else {
            long jA3 = a(jA2, i16 / i17, length3);
            int i19 = i16 % i17;
            if (i19 != 0) {
                jA3 = a(j6, i19, length4) + jA3 + ((long) length3);
            }
            jA = jA3;
        }
        long j7 = i18;
        String str7 = bytePrefix;
        long jN = n(j7, jA, 1);
        long j8 = j7 - ((jA + 1) * jN);
        long jN2 = n(j8, jA2, length3);
        long j9 = j8 - ((jA2 + ((long) length3)) * jN2);
        long jN3 = n(j9, j6, length4);
        int i20 = (int) ((((long) i17) * jN2) + (jN * ((long) i16)) + jN3 + ((long) (j9 - ((j6 + ((long) length4)) * jN3) > 0 ? 1 : 0)));
        byte[] bArr = new byte[i20];
        int length7 = i5;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (length7 < i6) {
            Throwable th = null;
            if (i22 == i16) {
                if (str.charAt(length7) == '\r') {
                    int i24 = length7 + 1;
                    length7 = (i24 >= i6 || str.charAt(i24) != '\n') ? i24 : length7 + 2;
                } else {
                    if (str.charAt(length7) != '\n') {
                        StringBuilder sbT = AbstractC0157z.t(length7, "Expected a new line at index ", ", but was ");
                        sbT.append(str.charAt(length7));
                        throw new NumberFormatException(sbT.toString());
                    }
                    length7++;
                }
                str2 = groupSeparator;
                i22 = 0;
            } else {
                if (i23 != i17) {
                    str2 = groupSeparator;
                    if (i23 == 0 || byteSeparator.length() == 0) {
                        th = null;
                        byteSeparator = byteSeparator;
                        i7 = i16;
                    } else {
                        int length8 = byteSeparator.length();
                        int i25 = 0;
                        while (i25 < length8) {
                            Throwable th2 = th;
                            String str8 = byteSeparator;
                            int i26 = i16;
                            if (!AbstractC0240f.b(str8.charAt(i25), str.charAt(length7 + i25), z6)) {
                                l(str, length7, i6, str8, "byte separator");
                                throw th2;
                            }
                            i25++;
                            th = th2;
                            i16 = i26;
                            byteSeparator = str8;
                        }
                        th = th;
                        byteSeparator = byteSeparator;
                        i7 = i16;
                        length7 += byteSeparator.length();
                    }
                } else if (groupSeparator.length() == 0) {
                    str2 = groupSeparator;
                } else {
                    int length9 = groupSeparator.length();
                    int i27 = 0;
                    while (i27 < length9) {
                        String str9 = groupSeparator;
                        if (!AbstractC0240f.b(str9.charAt(i27), str.charAt(length7 + i27), z6)) {
                            l(str, length7, i6, str9, "group separator");
                            throw null;
                        }
                        i27++;
                        groupSeparator = str9;
                    }
                    str2 = groupSeparator;
                    length7 += str2.length();
                }
                i22++;
                i23++;
                if (str7.length() == 0) {
                    str3 = str7;
                } else {
                    length = str7.length();
                    i8 = 0;
                    while (i8 < length) {
                        str4 = str7;
                        i9 = length;
                        if (AbstractC0240f.b(str4.charAt(i8), str.charAt(length7 + i8), z6)) {
                            l(str, length7, i6, str4, "byte prefix");
                            throw th;
                        }
                        i8++;
                        length = i9;
                        str7 = str4;
                    }
                    str3 = str7;
                    length7 += str3.length();
                }
                if (i6 - 2 >= length7) {
                    k(str, length7, i6, 2, "exactly");
                    throw th;
                }
                i10 = i21 + 1;
                bArr[i21] = g(length7, str);
                length7 += 2;
                if (byteSuffix.length() == 0) {
                    i12 = i17;
                    str5 = byteSuffix;
                    i13 = i10;
                } else {
                    length2 = byteSuffix.length();
                    i11 = 0;
                    while (i11 < length2) {
                        str6 = byteSuffix;
                        i14 = i10;
                        i15 = i17;
                        if (AbstractC0240f.b(str6.charAt(i11), str.charAt(length7 + i11), z6)) {
                            l(str, length7, i6, str6, "byte suffix");
                            throw th;
                        }
                        i11++;
                        i10 = i14;
                        i17 = i15;
                        byteSuffix = str6;
                    }
                    i12 = i17;
                    str5 = byteSuffix;
                    i13 = i10;
                    length7 = str5.length() + length7;
                }
                groupSeparator = str2;
                i21 = i13;
                i17 = i12;
                i16 = i7;
                str7 = str3;
                byteSuffix = str5;
                byteSeparator = byteSeparator;
            }
            i23 = 0;
            i7 = i16;
            i22++;
            i23++;
            if (str7.length() == 0) {
                str3 = str7;
            } else {
                length = str7.length();
                i8 = 0;
                while (i8 < length) {
                    str4 = str7;
                    i9 = length;
                    if (AbstractC0240f.b(str4.charAt(i8), str.charAt(length7 + i8), z6)) {
                        l(str, length7, i6, str4, "byte prefix");
                        throw th;
                    }
                    i8++;
                    length = i9;
                    str7 = str4;
                }
                str3 = str7;
                length7 += str3.length();
            }
            if (i6 - 2 >= length7) {
                k(str, length7, i6, 2, "exactly");
                throw th;
            }
            i10 = i21 + 1;
            bArr[i21] = g(length7, str);
            length7 += 2;
            if (byteSuffix.length() == 0) {
                i12 = i17;
                str5 = byteSuffix;
                i13 = i10;
            } else {
                length2 = byteSuffix.length();
                i11 = 0;
                while (i11 < length2) {
                    str6 = byteSuffix;
                    i14 = i10;
                    i15 = i17;
                    if (AbstractC0240f.b(str6.charAt(i11), str.charAt(length7 + i11), z6)) {
                        l(str, length7, i6, str6, "byte suffix");
                        throw th;
                    }
                    i11++;
                    i10 = i14;
                    i17 = i15;
                    byteSuffix = str6;
                }
                i12 = i17;
                str5 = byteSuffix;
                i13 = i10;
                length7 = str5.length() + length7;
            }
            groupSeparator = str2;
            i21 = i13;
            i17 = i12;
            i16 = i7;
            str7 = str3;
            byteSuffix = str5;
            byteSeparator = byteSeparator;
        }
        if (i21 == i20) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i21);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    public static final int hexToInt(String str, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    private static final int hexToIntImpl(String str, int i5, int i6, C0246l c0246l, int i7) {
        C0136d c0136d = AbstractC0139g.Companion;
        int length = str.length();
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        C0246l.c number = c0246l.getNumber();
        if (number.c) {
            c(str, i5, i6, i7);
            return h(str, i5, i6);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        d(str, i5, i6, prefix, suffix, number.e, i7);
        return h(str, prefix.length() + i5, i6 - suffix.length());
    }

    public static final long hexToLong(String str, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    private static final long hexToLongImpl(String str, int i5, int i6, C0246l c0246l, int i7) {
        C0136d c0136d = AbstractC0139g.Companion;
        int length = str.length();
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        C0246l.c number = c0246l.getNumber();
        if (number.c) {
            c(str, i5, i6, i7);
            return i(i5, i6, str);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        d(str, i5, i6, prefix, suffix, number.e, i7);
        return i(prefix.length() + i5, i6 - suffix.length(), str);
    }

    public static final short hexToShort(String str, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    public static final long i(int i5, int i6, String str) {
        long j6 = 0;
        while (i5 < i6) {
            long j7 = j6 << 4;
            char cCharAt = str.charAt(i5);
            if ((cCharAt >>> '\b') == 0) {
                long j8 = HEX_DIGITS_TO_LONG_DECIMAL[cCharAt];
                if (j8 >= 0) {
                    j6 = j7 | j8;
                    i5++;
                }
            }
            j(i5, str);
            throw null;
        }
        return j6;
    }

    public static final void j(int i5, String str) {
        StringBuilder sbT = AbstractC0157z.t(i5, "Expected a hexadecimal digit at index ", ", but was ");
        sbT.append(str.charAt(i5));
        throw new NumberFormatException(sbT.toString());
    }

    public static final void k(String str, int i5, int i6, int i7, String str2) {
        kotlin.jvm.internal.E.d(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i5, i6);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + Chars.SPACE + i7 + " hexadecimal digits at index " + i5 + ", but was \"" + strSubstring + "\" of length " + (i6 - i5));
    }

    public static final void l(String str, int i5, int i6, String str2, String str3) {
        int length = str2.length() + i5;
        if (length <= i6) {
            i6 = length;
        }
        String strSubstring = str.substring(i5, i6);
        kotlin.jvm.internal.E.e(strSubstring, "substring(...)");
        StringBuilder sbU = androidx.collection.a.u("Expected ", str3, " \"", str2, "\" at index ");
        sbU.append(i5);
        sbU.append(", but was ");
        sbU.append(strSubstring);
        throw new NumberFormatException(sbU.toString());
    }

    public static final int m(int i5, String str, char[] cArr) {
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                str.getChars(0, str.length(), cArr, i5);
            } else {
                cArr[i5] = str.charAt(0);
            }
        }
        return str.length() + i5;
    }

    public static final long n(long j6, long j7, int i5) {
        if (j6 <= 0 || j7 <= 0) {
            return 0L;
        }
        long j8 = i5;
        return (j6 + j8) / (j7 + j8);
    }

    public static final String toHexString(byte b, C0246l format) {
        kotlin.jvm.internal.E.f(format, "format");
        String str = format.f861a ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        C0246l.c number = format.getNumber();
        if (!number.d) {
            return toHexStringImpl(b, number, str, 8);
        }
        char[] cArr = {str.charAt((b >> 4) & 15), str.charAt(b & 15)};
        if (!number.f864a) {
            return W.concatToString(cArr);
        }
        int iNumberOfLeadingZeros = (Integer.numberOfLeadingZeros(b & UnsignedBytes.MAX_VALUE) - 24) >> 2;
        return W.a(iNumberOfLeadingZeros <= 1 ? iNumberOfLeadingZeros : 1, cArr, 0, 2);
    }

    private static final String toHexStringImpl(long j6, C0246l.c cVar, String str, int i5) {
        if ((i5 & 3) != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i6 = i5 >> 2;
        int i7 = cVar.b;
        int i8 = i7 - i6;
        if (i8 < 0) {
            i8 = 0;
        }
        String prefix = cVar.getPrefix();
        String suffix = cVar.getSuffix();
        boolean z6 = cVar.f864a;
        int iB = b(((long) prefix.length()) + ((long) i8) + ((long) i6) + ((long) suffix.length()));
        char[] cArr = new char[iB];
        int iM = m(0, prefix, cArr);
        if (i8 > 0) {
            int i9 = i8 + iM;
            AbstractC0151t.fill(cArr, str.charAt(0), iM, i9);
            iM = i9;
        }
        boolean z7 = z6;
        int i10 = i5;
        for (int i11 = 0; i11 < i6; i11++) {
            i10 -= 4;
            int i12 = (int) ((j6 >> i10) & 15);
            z7 = z7 && i12 == 0 && (i10 >> 2) >= i7;
            if (!z7) {
                cArr[iM] = str.charAt(i12);
                iM++;
            }
        }
        int iM2 = m(iM, suffix, cArr);
        return iM2 == iB ? W.concatToString(cArr) : W.a(0, cArr, iM2, 1);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i5, int i6, C0246l.b bVar, int[] iArr) {
        return bVar.d ? toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i5, i6, bVar, iArr) : toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i5, i6, bVar, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i5, int i6, C0246l.b bVar, int[] iArr) {
        String bytePrefix = bVar.getBytePrefix();
        String byteSuffix = bVar.getByteSuffix();
        String byteSeparator = bVar.getByteSeparator();
        int i7 = i6 - i5;
        int length = byteSeparator.length();
        int length2 = bytePrefix.length();
        int length3 = byteSuffix.length();
        if (i7 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        long j6 = length;
        char[] cArr = new char[b((((long) i7) * (((((long) length2) + 2) + ((long) length3)) + j6)) - j6)];
        int iM = m(e(bArr, i5, iArr, cArr, m(0, bytePrefix, cArr)), byteSuffix, cArr);
        while (true) {
            i5++;
            if (i5 >= i6) {
                return W.concatToString(cArr);
            }
            iM = m(e(bArr, i5, iArr, cArr, m(m(iM, byteSeparator, cArr), bytePrefix, cArr)), byteSuffix, cArr);
        }
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i5, int i6, C0246l.b bVar, int[] iArr) {
        int length = bVar.getByteSeparator().length();
        if (length > 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i7 = i6 - i5;
        int iE = 0;
        if (length == 0) {
            char[] cArr = new char[b(((long) i7) * 2)];
            while (i5 < i6) {
                iE = e(bArr, i5, iArr, cArr, iE);
                i5++;
            }
            return W.concatToString(cArr);
        }
        char[] cArr2 = new char[b((((long) i7) * 3) - 1)];
        char cCharAt = bVar.getByteSeparator().charAt(0);
        int iE2 = e(bArr, i5, iArr, cArr2, 0);
        for (int i8 = i5 + 1; i8 < i6; i8++) {
            cArr2[iE2] = cCharAt;
            iE2 = e(bArr, i8, iArr, cArr2, iE2 + 1);
        }
        return W.concatToString(cArr2);
    }

    private static final String toHexStringSlowPath(byte[] bArr, int i5, int i6, C0246l.b bVar, int[] iArr) {
        int i7 = bVar.f863a;
        int i8 = bVar.b;
        String bytePrefix = bVar.getBytePrefix();
        String byteSuffix = bVar.getByteSuffix();
        String byteSeparator = bVar.getByteSeparator();
        String groupSeparator = bVar.getGroupSeparator();
        int i9 = i6 - i5;
        int length = groupSeparator.length();
        int length2 = byteSeparator.length();
        int length3 = bytePrefix.length();
        int length4 = byteSuffix.length();
        if (i9 <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i10 = i9 - 1;
        int i11 = i10 / i7;
        int i12 = (i7 - 1) / i8;
        int i13 = i9 % i7;
        if (i13 == 0) {
            i13 = i7;
        }
        int i14 = (i12 * i11) + ((i13 - 1) / i8);
        int iB = b(((((long) length3) + 2 + ((long) length4)) * ((long) i9)) + (((long) ((i10 - i11) - i14)) * ((long) length2)) + (((long) i14) * ((long) length)) + ((long) i11));
        char[] cArr = new char[iB];
        int iM = 0;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = i5; i17 < i6; i17++) {
            if (i15 == i7) {
                cArr[iM] = '\n';
                i16 = 0;
                iM++;
                i15 = 0;
            } else if (i16 == i8) {
                iM = m(iM, groupSeparator, cArr);
                i16 = 0;
            }
            if (i16 != 0) {
                iM = m(iM, byteSeparator, cArr);
            }
            iM = m(e(bArr, i17, iArr, cArr, m(iM, bytePrefix, cArr)), byteSuffix, cArr);
            i16++;
            i15++;
        }
        if (iM == iB) {
            return W.concatToString(cArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    private static final byte hexToByte(String str, int i5, int i6, C0246l c0246l) {
        return (byte) hexToIntImpl(str, i5, i6, c0246l, 2);
    }

    private static final byte[] hexToByteArray(String str, int i5, int i6, C0246l c0246l) {
        byte[] bArrHexToByteArrayNoLineAndGroupSeparator;
        C0136d c0136d = AbstractC0139g.Companion;
        int length = str.length();
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        if (i5 == i6) {
            return new byte[0];
        }
        C0246l.b bytes = c0246l.getBytes();
        return (!bytes.c || (bArrHexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i5, i6, bytes)) == null) ? hexToByteArraySlowPath(str, i5, i6, bytes) : bArrHexToByteArrayNoLineAndGroupSeparator;
    }

    private static final int hexToInt(String str, int i5, int i6, C0246l c0246l) {
        return hexToIntImpl(str, i5, i6, c0246l, 8);
    }

    public static final long hexToLong(String str, int i5, int i6, C0246l format) {
        kotlin.jvm.internal.E.f(str, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return hexToLongImpl(str, i5, i6, format, 16);
    }

    private static final short hexToShort(String str, int i5, int i6, C0246l c0246l) {
        return (short) hexToIntImpl(str, i5, i6, c0246l, 4);
    }

    public static final String toHexString(int i5, C0246l format) {
        kotlin.jvm.internal.E.f(format, "format");
        String str = format.f861a ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        C0246l.c number = format.getNumber();
        if (number.d) {
            char[] cArr = {str.charAt((i5 >> 28) & 15), str.charAt((i5 >> 24) & 15), str.charAt((i5 >> 20) & 15), str.charAt((i5 >> 16) & 15), str.charAt((i5 >> 12) & 15), str.charAt((i5 >> 8) & 15), str.charAt((i5 >> 4) & 15), str.charAt(i5 & 15)};
            if (number.f864a) {
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i5) >> 2;
                return W.a(iNumberOfLeadingZeros <= 7 ? iNumberOfLeadingZeros : 7, cArr, 0, 2);
            }
            return W.concatToString(cArr);
        }
        return toHexStringImpl(i5, number, str, 32);
    }

    public static /* synthetic */ void getBYTE_TO_LOWER_CASE_HEX_DIGITS$annotations() {
    }

    public static final String toHexString(long j6, C0246l format) {
        kotlin.jvm.internal.E.f(format, "format");
        String str = format.f861a ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        C0246l.c number = format.getNumber();
        if (number.d) {
            char[] cArr = {str.charAt((int) ((j6 >> 60) & 15)), str.charAt((int) ((j6 >> 56) & 15)), str.charAt((int) ((j6 >> 52) & 15)), str.charAt((int) ((j6 >> 48) & 15)), str.charAt((int) ((j6 >> 44) & 15)), str.charAt((int) ((j6 >> 40) & 15)), str.charAt((int) ((j6 >> 36) & 15)), str.charAt((int) ((j6 >> 32) & 15)), str.charAt((int) ((j6 >> 28) & 15)), str.charAt((int) ((j6 >> 24) & 15)), str.charAt((int) ((j6 >> 20) & 15)), str.charAt((int) ((j6 >> 16) & 15)), str.charAt((int) ((j6 >> 12) & 15)), str.charAt((int) ((j6 >> 8) & 15)), str.charAt((int) ((j6 >> 4) & 15)), str.charAt((int) (j6 & 15))};
            if (number.f864a) {
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j6) >> 2;
                return W.a(iNumberOfLeadingZeros <= 15 ? iNumberOfLeadingZeros : 15, cArr, 0, 2);
            }
            return W.concatToString(cArr);
        }
        return toHexStringImpl(j6, number, str, 64);
    }

    public static final String toHexString(short s6, C0246l format) {
        kotlin.jvm.internal.E.f(format, "format");
        String str = format.f861a ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        C0246l.c number = format.getNumber();
        if (number.d) {
            char[] cArr = {str.charAt((s6 >> 12) & 15), str.charAt((s6 >> 8) & 15), str.charAt((s6 >> 4) & 15), str.charAt(s6 & 15)};
            if (number.f864a) {
                int iNumberOfLeadingZeros = (Integer.numberOfLeadingZeros(s6 & 65535) - 16) >> 2;
                return W.a(iNumberOfLeadingZeros <= 3 ? iNumberOfLeadingZeros : 3, cArr, 0, 2);
            }
            return W.concatToString(cArr);
        }
        return toHexStringImpl(s6, number, str, 16);
    }

    public static final String toHexString(byte[] bArr, C0246l format) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static final String toHexString(byte[] bArr, int i5, int i6, C0246l format) {
        kotlin.jvm.internal.E.f(bArr, "<this>");
        kotlin.jvm.internal.E.f(format, "format");
        C0136d c0136d = AbstractC0139g.Companion;
        int length = bArr.length;
        c0136d.getClass();
        C0136d.a(i5, i6, length);
        if (i5 == i6) {
            return "";
        }
        int[] iArr = format.f861a ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        C0246l.b bytes = format.getBytes();
        if (bytes.c) {
            return toHexStringNoLineAndGroupSeparator(bArr, i5, i6, bytes, iArr);
        }
        return toHexStringSlowPath(bArr, i5, i6, bytes, iArr);
    }
}
