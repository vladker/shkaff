package com.google.common.primitives;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.auth.api.accounttransfer.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtCompatible
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                long j6 = jArr[i5];
                long j7 = jArr2[i5];
                if (j6 != j7) {
                    return UnsignedLongs.compare(j6, j7);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ParseOverflowDetection {
        static final long[] maxValueDivs = new long[37];
        static final int[] maxValueMods = new int[37];
        static final int[] maxSafeDigits = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i5 = 2; i5 <= 36; i5++) {
                long j6 = i5;
                maxValueDivs[i5] = UnsignedLongs.divide(-1L, j6);
                maxValueMods[i5] = (int) UnsignedLongs.remainder(-1L, j6);
                maxSafeDigits[i5] = bigInteger.toString(i5).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        public static boolean overflowInParse(long j6, int i5, int i6) {
            if (j6 < 0) {
                return true;
            }
            long j7 = maxValueDivs[i6];
            if (j6 < j7) {
                return false;
            }
            return j6 > j7 || i5 > maxValueMods[i6];
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j6, long j7) {
        return Longs.compare(flip(j6), flip(j7));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest parseRequestFromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(parseRequestFromString.rawValue, parseRequestFromString.radix);
        } catch (NumberFormatException e) {
            String strValueOf = String.valueOf(str);
            NumberFormatException numberFormatException = new NumberFormatException(strValueOf.length() != 0 ? "Error parsing value: ".concat(strValueOf) : new String("Error parsing value: "));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j6, long j7) {
        if (j7 < 0) {
            return compare(j6, j7) < 0 ? 0L : 1L;
        }
        if (j6 >= 0) {
            return j6 / j7;
        }
        long j8 = ((j6 >>> 1) / j7) << 1;
        return j8 + ((long) (compare(j6 - (j8 * j7), j7) < 0 ? 0 : 1));
    }

    private static long flip(long j6) {
        return j6 ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i5 = 1; i5 < jArr.length; i5++) {
            sb.append(str);
            sb.append(toString(jArr[i5]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long jFlip = flip(jArr[0]);
        for (int i5 = 1; i5 < jArr.length; i5++) {
            long jFlip2 = flip(jArr[i5]);
            if (jFlip2 > jFlip) {
                jFlip = jFlip2;
            }
        }
        return flip(jFlip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long jFlip = flip(jArr[0]);
        for (int i5 = 1; i5 < jArr.length; i5++) {
            long jFlip2 = flip(jArr[i5]);
            if (jFlip2 < jFlip) {
                jFlip = jFlip2;
            }
        }
        return flip(jFlip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j6, long j7) {
        if (j7 < 0) {
            return compare(j6, j7) < 0 ? j6 : j6 - j7;
        }
        if (j6 >= 0) {
            return j6 % j7;
        }
        long j8 = j6 - ((((j6 >>> 1) / j7) << 1) * j7);
        if (compare(j8, j7) < 0) {
            j7 = 0;
        }
        return j8 - j7;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j6) {
        return toString(j6, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i5) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i5 < 2 || i5 > 36) {
            throw new NumberFormatException(a.h(26, i5, "illegal radix: "));
        }
        int i6 = ParseOverflowDetection.maxSafeDigits[i5] - 1;
        long j6 = 0;
        for (int i7 = 0; i7 < str.length(); i7++) {
            int iDigit = Character.digit(str.charAt(i7), i5);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i7 > i6 && ParseOverflowDetection.overflowInParse(j6, iDigit, i5)) {
                throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
            }
            j6 = (j6 * ((long) i5)) + ((long) iDigit);
        }
        return j6;
    }

    public static String toString(long j6, int i5) {
        Preconditions.checkArgument(i5 >= 2 && i5 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i5);
        if (j6 == 0) {
            return "0";
        }
        if (j6 > 0) {
            return Long.toString(j6, i5);
        }
        int i6 = 64;
        char[] cArr = new char[64];
        int i7 = i5 - 1;
        if ((i5 & i7) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i5);
            do {
                i6--;
                cArr[i6] = Character.forDigit(((int) j6) & i7, i5);
                j6 >>>= iNumberOfTrailingZeros;
            } while (j6 != 0);
        } else {
            long jDivide = (i5 & 1) == 0 ? (j6 >>> 1) / ((long) (i5 >>> 1)) : divide(j6, i5);
            long j7 = i5;
            int i8 = 63;
            cArr[63] = Character.forDigit((int) (j6 - (jDivide * j7)), i5);
            while (jDivide > 0) {
                i8--;
                cArr[i8] = Character.forDigit((int) (jDivide % j7), i5);
                jDivide /= j7;
            }
            i6 = i8;
        }
        return new String(cArr, i6, 64 - i6);
    }

    public static void sort(long[] jArr, int i5, int i6) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i5, i6, jArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            jArr[i7] = flip(jArr[i7]);
        }
        Arrays.sort(jArr, i5, i6);
        while (i5 < i6) {
            jArr[i5] = flip(jArr[i5]);
            i5++;
        }
    }

    public static void sortDescending(long[] jArr, int i5, int i6) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i5, i6, jArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            jArr[i7] = LocationRequestCompat.PASSIVE_INTERVAL ^ jArr[i7];
        }
        Arrays.sort(jArr, i5, i6);
        while (i5 < i6) {
            jArr[i5] = jArr[i5] ^ LocationRequestCompat.PASSIVE_INTERVAL;
            i5++;
        }
    }
}
