package org.apache.commons.math3.util;

import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class MathUtils {
    public static final double PI_SQUARED = 9.869604401089358d;
    public static final double TWO_PI = 6.283185307179586d;

    private MathUtils() {
    }

    public static void checkFinite(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new NotFiniteNumberException(Double.valueOf(d), new Object[0]);
        }
    }

    public static void checkNotNull(Object obj, Localizable localizable, Object... objArr) {
        if (obj == null) {
            throw new NullArgumentException(localizable, objArr);
        }
    }

    public static byte copySign(byte b, byte b6) {
        if ((b >= 0 && b6 >= 0) || (b < 0 && b6 < 0)) {
            return b;
        }
        if (b6 < 0 || b != -128) {
            return (byte) (-b);
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }

    public static boolean equals(double d, double d6) {
        return new Double(d).equals(new Double(d6));
    }

    public static int hash(double d) {
        return new Double(d).hashCode();
    }

    public static <T extends RealFieldElement<T>> T max(T t6, T t7) {
        return ((RealFieldElement) t6.subtract(t7)).getReal() >= 0.0d ? t6 : t7;
    }

    public static <T extends RealFieldElement<T>> T min(T t6, T t7) {
        return ((RealFieldElement) t6.subtract(t7)).getReal() >= 0.0d ? t7 : t6;
    }

    public static double normalizeAngle(double d, double d6) {
        return d - (FastMath.floor(((3.141592653589793d + d) - d6) / 6.283185307179586d) * 6.283185307179586d);
    }

    public static double reduce(double d, double d6, double d7) {
        double dAbs = FastMath.abs(d6);
        return (d - (FastMath.floor((d - d7) / dAbs) * dAbs)) - d7;
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullArgumentException();
        }
    }

    public static short copySign(short s6, short s7) {
        if ((s6 >= 0 && s7 >= 0) || (s6 < 0 && s7 < 0)) {
            return s6;
        }
        if (s7 < 0 || s6 != Short.MIN_VALUE) {
            return (short) (-s6);
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }

    public static int hash(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    public static void checkFinite(double[] dArr) {
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double d = dArr[i5];
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                throw new NotFiniteNumberException(LocalizedFormats.ARRAY_ELEMENT, Double.valueOf(d), Integer.valueOf(i5));
            }
        }
    }

    public static int copySign(int i5, int i6) {
        if ((i5 >= 0 && i6 >= 0) || (i5 < 0 && i6 < 0)) {
            return i5;
        }
        if (i6 < 0 || i5 != Integer.MIN_VALUE) {
            return -i5;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }

    public static long copySign(long j6, long j7) {
        if ((j6 >= 0 && j7 >= 0) || (j6 < 0 && j7 < 0)) {
            return j6;
        }
        if (j7 < 0 || j6 != Long.MIN_VALUE) {
            return -j6;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
    }
}
