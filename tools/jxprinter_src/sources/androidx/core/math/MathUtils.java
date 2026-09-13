package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i5, int i6) {
        int i7 = i5 + i6;
        if ((i5 >= 0) == (i6 >= 0)) {
            if ((i5 >= 0) != (i7 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i7;
    }

    public static double clamp(double d, double d6, double d7) {
        if (d < d6) {
            return d6;
        }
        return d > d7 ? d7 : d;
    }

    public static int decrementExact(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            return i5 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i5) {
        if (i5 != Integer.MAX_VALUE) {
            return i5 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i5, int i6) {
        int i7 = i5 * i6;
        if (i5 == 0 || i6 == 0 || (i7 / i5 == i6 && i7 / i6 == i5)) {
            return i7;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            return -i5;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i5, int i6) {
        int i7 = i5 - i6;
        if ((i5 < 0) != (i6 < 0)) {
            if ((i5 < 0) != (i7 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i7;
    }

    public static int toIntExact(long j6) {
        if (j6 > 2147483647L || j6 < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j6;
    }

    public static long addExact(long j6, long j7) {
        long j8 = j6 + j7;
        if ((j6 >= 0) == (j7 >= 0)) {
            if ((j6 >= 0) != (j8 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static float clamp(float f6, float f7, float f8) {
        if (f6 < f7) {
            return f7;
        }
        return f6 > f8 ? f8 : f6;
    }

    public static long decrementExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return j6 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j6) {
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j6 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return -j6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j6, long j7) {
        long j8 = j6 - j7;
        if ((j6 < 0) != (j7 < 0)) {
            if ((j6 < 0) != (j8 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j8;
    }

    public static int clamp(int i5, int i6, int i7) {
        if (i5 < i6) {
            return i6;
        }
        return i5 > i7 ? i7 : i5;
    }

    public static long multiplyExact(long j6, long j7) {
        long j8 = j6 * j7;
        if (j6 == 0 || j7 == 0 || (j8 / j6 == j7 && j8 / j7 == j6)) {
            return j8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j6, long j7, long j8) {
        if (j6 < j7) {
            return j7;
        }
        return j6 > j8 ? j8 : j6;
    }
}
