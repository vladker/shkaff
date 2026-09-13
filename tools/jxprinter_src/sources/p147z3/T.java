package p147z3;

import X3.AbstractC0239e;
import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class T {
    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return G.m1188constructorimpl((int) d);
        }
        return G.m1188constructorimpl(G.m1188constructorimpl(Integer.MAX_VALUE) + G.m1188constructorimpl((int) (d - ((double) Integer.MAX_VALUE))));
    }

    public static final long doubleToULong(double d) {
        if (Double.isNaN(d) || d <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d < 9.223372036854776E18d ? J.m1247constructorimpl((long) d) : J.m1247constructorimpl(J.m1247constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    private static final int floatToUInt(float f6) {
        return doubleToUInt(f6);
    }

    private static final long floatToULong(float f6) {
        return doubleToULong(f6);
    }

    public static final int uintCompare(int i5, int i6) {
        return E.h(i5 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m1357uintDivideJ1ME1BU(int i5, int i6) {
        return G.m1188constructorimpl((int) ((((long) i5) & KeyboardMap.kValueMask) / (((long) i6) & KeyboardMap.kValueMask)));
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m1358uintRemainderJ1ME1BU(int i5, int i6) {
        return G.m1188constructorimpl((int) ((((long) i5) & KeyboardMap.kValueMask) % (((long) i6) & KeyboardMap.kValueMask)));
    }

    public static final double uintToDouble(int i5) {
        return (((double) ((i5 >>> 31) << 30)) * ((double) 2)) + ((double) (Integer.MAX_VALUE & i5));
    }

    private static final float uintToFloat(int i5) {
        return (float) uintToDouble(i5);
    }

    private static final long uintToLong(int i5) {
        return ((long) i5) & KeyboardMap.kValueMask;
    }

    private static final String uintToString(int i5) {
        return String.valueOf(((long) i5) & KeyboardMap.kValueMask);
    }

    private static final long uintToULong(int i5) {
        return J.m1247constructorimpl(((long) i5) & KeyboardMap.kValueMask);
    }

    public static final int ulongCompare(long j6, long j7) {
        long j8 = j6 ^ Long.MIN_VALUE;
        long j9 = j7 ^ Long.MIN_VALUE;
        if (j8 < j9) {
            return -1;
        }
        return j8 == j9 ? 0 : 1;
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m1359ulongDivideeb3DHEI(long j6, long j7) {
        if (j7 < 0) {
            return Long.compareUnsigned(j6, j7) < 0 ? J.m1247constructorimpl(0L) : J.m1247constructorimpl(1L);
        }
        if (j6 >= 0) {
            return J.m1247constructorimpl(j6 / j7);
        }
        long j8 = ((j6 >>> 1) / j7) << 1;
        return J.m1247constructorimpl(j8 + ((long) (Long.compareUnsigned(J.m1247constructorimpl(j6 - (j8 * j7)), J.m1247constructorimpl(j7)) < 0 ? 0 : 1)));
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m1360ulongRemaindereb3DHEI(long j6, long j7) {
        if (j7 < 0) {
            return Long.compareUnsigned(j6, j7) < 0 ? j6 : J.m1247constructorimpl(j6 - j7);
        }
        if (j6 >= 0) {
            return J.m1247constructorimpl(j6 % j7);
        }
        long j8 = j6 - ((((j6 >>> 1) / j7) << 1) * j7);
        if (Long.compareUnsigned(J.m1247constructorimpl(j8), J.m1247constructorimpl(j7)) < 0) {
            j7 = 0;
        }
        return J.m1247constructorimpl(j8 - j7);
    }

    public static final double ulongToDouble(long j6) {
        return ((j6 >>> 11) * ((double) 2048)) + (j6 & 2047);
    }

    private static final float ulongToFloat(long j6) {
        return (float) ulongToDouble(j6);
    }

    private static final String ulongToString(long j6) {
        return ulongToString(j6, 10);
    }

    private static final String uintToString(int i5, int i6) {
        return ulongToString(((long) i5) & KeyboardMap.kValueMask, i6);
    }

    public static final String ulongToString(long j6, int i5) {
        if (j6 >= 0) {
            String string = Long.toString(j6, AbstractC0239e.checkRadix(i5));
            E.e(string, "toString(...)");
            return string;
        }
        long j7 = i5;
        long j8 = ((j6 >>> 1) / j7) << 1;
        long j9 = j6 - (j8 * j7);
        if (j9 >= j7) {
            j9 -= j7;
            j8++;
        }
        String string2 = Long.toString(j8, AbstractC0239e.checkRadix(i5));
        E.e(string2, "toString(...)");
        String string3 = Long.toString(j9, AbstractC0239e.checkRadix(i5));
        E.e(string3, "toString(...)");
        return string2.concat(string3);
    }
}
