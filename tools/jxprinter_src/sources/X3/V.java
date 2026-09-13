package X3;

import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class V extends U {
    public static final Void numberFormatError(String input) {
        kotlin.jvm.internal.E.f(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + Chars.QUOTE);
    }

    public static final Byte toByteOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toByteOrNull(str, 10);
    }

    public static Integer toIntOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toIntOrNull(str, 10);
    }

    public static Long toLongOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toLongOrNull(str, 10);
    }

    public static final Short toShortOrNull(String str) {
        kotlin.jvm.internal.E.f(str, "<this>");
        return toShortOrNull(str, 10);
    }

    public static final Byte toByteOrNull(String str, int i5) {
        int iIntValue;
        kotlin.jvm.internal.E.f(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i5);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    public static final Integer toIntOrNull(String str, int i5) {
        boolean z6;
        int i6;
        int i7;
        kotlin.jvm.internal.E.f(str, "<this>");
        AbstractC0239e.checkRadix(i5);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        int i9 = -2147483647;
        if (kotlin.jvm.internal.E.h(cCharAt, 48) < 0) {
            i6 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z6 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i9 = Integer.MIN_VALUE;
                z6 = true;
            }
        } else {
            z6 = false;
            i6 = 0;
        }
        int i10 = -59652323;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), i5);
            if (iDigit < 0) {
                return null;
            }
            if ((i8 < i10 && (i10 != -59652323 || i8 < (i10 = i9 / i5))) || (i7 = i8 * i5) < i9 + iDigit) {
                return null;
            }
            i8 = i7 - iDigit;
            i6++;
        }
        return z6 ? Integer.valueOf(i8) : Integer.valueOf(-i8);
    }

    public static final Long toLongOrNull(String str, int i5) {
        boolean z6;
        kotlin.jvm.internal.E.f(str, "<this>");
        AbstractC0239e.checkRadix(i5);
        int length = str.length();
        Long l6 = null;
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        long j6 = -9223372036854775807L;
        if (kotlin.jvm.internal.E.h(cCharAt, 48) < 0) {
            z6 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z6 = false;
                i6 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j6 = Long.MIN_VALUE;
                i6 = 1;
            }
        } else {
            z6 = false;
        }
        long j7 = 0;
        long j8 = -256204778801521550L;
        while (i6 < length) {
            int iDigit = Character.digit((int) str.charAt(i6), i5);
            if (iDigit < 0) {
                return l6;
            }
            if (j7 < j8) {
                if (j8 != -256204778801521550L) {
                    return l6;
                }
                j8 = j6 / ((long) i5);
                if (j7 < j8) {
                    return l6;
                }
            }
            Long l7 = l6;
            int i7 = i6;
            long j9 = j7 * ((long) i5);
            long j10 = iDigit;
            if (j9 < j6 + j10) {
                return l7;
            }
            j7 = j9 - j10;
            i6 = i7 + 1;
            l6 = l7;
        }
        return z6 ? Long.valueOf(j7) : Long.valueOf(-j7);
    }

    public static final Short toShortOrNull(String str, int i5) {
        int iIntValue;
        kotlin.jvm.internal.E.f(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i5);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }
}
