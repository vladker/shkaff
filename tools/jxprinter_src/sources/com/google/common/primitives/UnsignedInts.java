package com.google.common.primitives;

import androidx.exifinterface.media.a;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtCompatible
public final class UnsignedInts {
    static final long INT_MASK = 4294967295L;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i5 = 0; i5 < iMin; i5++) {
                int i6 = iArr[i5];
                int i7 = iArr2[i5];
                if (i6 != i7) {
                    return UnsignedInts.compare(i6, i7);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long j6) {
        Preconditions.checkArgument((j6 >> 32) == 0, "out of range: %s", j6);
        return (int) j6;
    }

    public static int compare(int i5, int i6) {
        return Ints.compare(flip(i5), flip(i6));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest parseRequestFromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(parseRequestFromString.rawValue, parseRequestFromString.radix);
        } catch (NumberFormatException e) {
            String strValueOf = String.valueOf(str);
            NumberFormatException numberFormatException = new NumberFormatException(strValueOf.length() != 0 ? "Error parsing value: ".concat(strValueOf) : new String("Error parsing value: "));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static int divide(int i5, int i6) {
        return (int) (toLong(i5) / toLong(i6));
    }

    public static int flip(int i5) {
        return i5 ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i5 = 1; i5 < iArr.length; i5++) {
            sb.append(str);
            sb.append(toString(iArr[i5]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int iFlip = flip(iArr[0]);
        for (int i5 = 1; i5 < iArr.length; i5++) {
            int iFlip2 = flip(iArr[i5]);
            if (iFlip2 > iFlip) {
                iFlip = iFlip2;
            }
        }
        return flip(iFlip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int iFlip = flip(iArr[0]);
        for (int i5 = 1; i5 < iArr.length; i5++) {
            int iFlip2 = flip(iArr[i5]);
            if (iFlip2 < iFlip) {
                iFlip = iFlip2;
            }
        }
        return flip(iFlip);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int remainder(int i5, int i6) {
        return (int) (toLong(i5) % toLong(i6));
    }

    public static int saturatedCast(long j6) {
        if (j6 <= 0) {
            return 0;
        }
        if (j6 >= 4294967296L) {
            return -1;
        }
        return (int) j6;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i5) {
        return ((long) i5) & 4294967295L;
    }

    public static String toString(int i5) {
        return toString(i5, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i5) {
        Preconditions.checkNotNull(str);
        long j6 = Long.parseLong(str, i5);
        if ((4294967295L & j6) == j6) {
            return (int) j6;
        }
        StringBuilder sb = new StringBuilder(a.b(69, str));
        sb.append("Input ");
        sb.append(str);
        sb.append(" in base ");
        sb.append(i5);
        sb.append(" is not in the range of an unsigned integer");
        throw new NumberFormatException(sb.toString());
    }

    public static String toString(int i5, int i6) {
        return Long.toString(((long) i5) & 4294967295L, i6);
    }

    public static void sort(int[] iArr, int i5, int i6) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i5, i6, iArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            iArr[i7] = flip(iArr[i7]);
        }
        Arrays.sort(iArr, i5, i6);
        while (i5 < i6) {
            iArr[i5] = flip(iArr[i5]);
            i5++;
        }
    }

    public static void sortDescending(int[] iArr, int i5, int i6) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i5, i6, iArr.length);
        for (int i7 = i5; i7 < i6; i7++) {
            iArr[i7] = Integer.MAX_VALUE ^ iArr[i7];
        }
        Arrays.sort(iArr, i5, i6);
        while (i5 < i6) {
            iArr[i5] = iArr[i5] ^ Integer.MAX_VALUE;
            i5++;
        }
    }
}
