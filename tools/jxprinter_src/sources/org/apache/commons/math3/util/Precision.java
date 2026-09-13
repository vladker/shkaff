package org.apache.commons.math3.util;

import java.math.BigDecimal;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Precision {
    private static final long EXPONENT_OFFSET = 1023;
    private static final long SGN_MASK = Long.MIN_VALUE;
    private static final int SGN_MASK_FLOAT = Integer.MIN_VALUE;
    private static final double POSITIVE_ZERO = 0.0d;
    private static final long POSITIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(POSITIVE_ZERO);
    private static final long NEGATIVE_ZERO_DOUBLE_BITS = Double.doubleToRawLongBits(-0.0d);
    private static final int POSITIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(0.0f);
    private static final int NEGATIVE_ZERO_FLOAT_BITS = Float.floatToRawIntBits(-0.0f);
    public static final double EPSILON = Double.longBitsToDouble(4368491638549381120L);
    public static final double SAFE_MIN = Double.longBitsToDouble(IEEEDouble.FRAC_ASSUMED_HIGH_BIT);

    private Precision() {
    }

    public static int compareTo(double d, double d6, double d7) {
        if (equals(d, d6, d7)) {
            return 0;
        }
        return d < d6 ? -1 : 1;
    }

    public static boolean equals(float f6, float f7) {
        return equals(f6, f7, 1);
    }

    public static boolean equalsIncludingNaN(float f6, float f7) {
        if (f6 == f6 && f7 == f7) {
            return equals(f6, f7, 1);
        }
        return !(((f7 > f7 ? 1 : (f7 == f7 ? 0 : -1)) != 0) ^ ((f6 > f6 ? 1 : (f6 == f6 ? 0 : -1)) != 0));
    }

    public static boolean equalsWithRelativeTolerance(double d, double d6, double d7) {
        if (equals(d, d6, 1)) {
            return true;
        }
        return FastMath.abs((d - d6) / FastMath.max(FastMath.abs(d), FastMath.abs(d6))) <= d7;
    }

    public static double representableDelta(double d, double d6) {
        return (d6 + d) - d;
    }

    public static double round(double d, int i5) {
        return round(d, i5, 4);
    }

    private static double roundUnscaled(double d, double d6, int i5) {
        switch (i5) {
            case 0:
                return d != FastMath.floor(d) ? FastMath.ceil(FastMath.nextAfter(d, Double.POSITIVE_INFINITY)) : d;
            case 1:
                return FastMath.floor(FastMath.nextAfter(d, Double.NEGATIVE_INFINITY));
            case 2:
                return d6 == -1.0d ? FastMath.floor(FastMath.nextAfter(d, Double.NEGATIVE_INFINITY)) : FastMath.ceil(FastMath.nextAfter(d, Double.POSITIVE_INFINITY));
            case 3:
                return d6 == -1.0d ? FastMath.ceil(FastMath.nextAfter(d, Double.POSITIVE_INFINITY)) : FastMath.floor(FastMath.nextAfter(d, Double.NEGATIVE_INFINITY));
            case 4:
                double dNextAfter = FastMath.nextAfter(d, Double.POSITIVE_INFINITY);
                return dNextAfter - FastMath.floor(dNextAfter) >= 0.5d ? FastMath.ceil(dNextAfter) : FastMath.floor(dNextAfter);
            case 5:
                double dNextAfter2 = FastMath.nextAfter(d, Double.NEGATIVE_INFINITY);
                return dNextAfter2 - FastMath.floor(dNextAfter2) > 0.5d ? FastMath.ceil(dNextAfter2) : FastMath.floor(dNextAfter2);
            case 6:
                double dFloor = d - FastMath.floor(d);
                if (dFloor > 0.5d) {
                    return FastMath.ceil(d);
                }
                if (dFloor < 0.5d) {
                    return FastMath.floor(d);
                }
                return FastMath.floor(d) / 2.0d == FastMath.floor(FastMath.floor(d) / 2.0d) ? FastMath.floor(d) : FastMath.ceil(d);
            case 7:
                if (d == FastMath.floor(d)) {
                    return d;
                }
                throw new MathArithmeticException();
            default:
                throw new MathIllegalArgumentException(LocalizedFormats.INVALID_ROUNDING_METHOD, Integer.valueOf(i5), "ROUND_CEILING", 2, "ROUND_DOWN", 1, "ROUND_FLOOR", 3, "ROUND_HALF_DOWN", 5, "ROUND_HALF_EVEN", 6, "ROUND_HALF_UP", 4, "ROUND_UNNECESSARY", 7, "ROUND_UP", 0);
        }
    }

    public static int compareTo(double d, double d6, int i5) {
        if (equals(d, d6, i5)) {
            return 0;
        }
        return d < d6 ? -1 : 1;
    }

    public static boolean equals(float f6, float f7, float f8) {
        return equals(f6, f7, 1) || FastMath.abs(f7 - f6) <= f8;
    }

    public static boolean equalsIncludingNaN(float f6, float f7, float f8) {
        return equalsIncludingNaN(f6, f7) || FastMath.abs(f7 - f6) <= f8;
    }

    public static double round(double d, int i5, int i6) {
        try {
            double dDoubleValue = new BigDecimal(Double.toString(d)).setScale(i5, i6).doubleValue();
            return dDoubleValue == POSITIVE_ZERO ? d * POSITIVE_ZERO : dDoubleValue;
        } catch (NumberFormatException unused) {
            if (Double.isInfinite(d)) {
                return d;
            }
            return Double.NaN;
        }
    }

    public static boolean equals(float f6, float f7, int i5) {
        int i6;
        int i7;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f6);
        int iFloatToRawIntBits2 = Float.floatToRawIntBits(f7);
        if (((iFloatToRawIntBits ^ iFloatToRawIntBits2) & Integer.MIN_VALUE) != 0) {
            if (iFloatToRawIntBits < iFloatToRawIntBits2) {
                i6 = iFloatToRawIntBits2 - POSITIVE_ZERO_FLOAT_BITS;
                i7 = iFloatToRawIntBits - NEGATIVE_ZERO_FLOAT_BITS;
            } else {
                int i8 = iFloatToRawIntBits - POSITIVE_ZERO_FLOAT_BITS;
                int i9 = iFloatToRawIntBits2 - NEGATIVE_ZERO_FLOAT_BITS;
                i6 = i8;
                i7 = i9;
            }
            if (i6 > i5 || i7 > i5 - i6) {
                return false;
            }
        } else if (FastMath.abs(iFloatToRawIntBits - iFloatToRawIntBits2) > i5) {
            return false;
        }
        return (Float.isNaN(f6) || Float.isNaN(f7)) ? false : true;
    }

    public static boolean equalsIncludingNaN(float f6, float f7, int i5) {
        if (f6 == f6 && f7 == f7) {
            return equals(f6, f7, i5);
        }
        return !(((f7 > f7 ? 1 : (f7 == f7 ? 0 : -1)) != 0) ^ ((f6 > f6 ? 1 : (f6 == f6 ? 0 : -1)) != 0));
    }

    public static boolean equalsIncludingNaN(double d, double d6) {
        if (d == d && d6 == d6) {
            return equals(d, d6, 1);
        }
        return !(((d > d ? 1 : (d == d ? 0 : -1)) != 0) ^ ((d6 > d6 ? 1 : (d6 == d6 ? 0 : -1)) != 0));
    }

    public static float round(float f6, int i5) {
        return round(f6, i5, 4);
    }

    public static boolean equalsIncludingNaN(double d, double d6, double d7) {
        return equalsIncludingNaN(d, d6) || FastMath.abs(d6 - d) <= d7;
    }

    public static float round(float f6, int i5, int i6) {
        float fCopySign = FastMath.copySign(1.0f, f6);
        float fPow = ((float) FastMath.pow(10.0d, i5)) * fCopySign;
        return ((float) roundUnscaled(f6 * fPow, fCopySign, i6)) / fPow;
    }

    public static boolean equalsIncludingNaN(double d, double d6, int i5) {
        if (d == d && d6 == d6) {
            return equals(d, d6, i5);
        }
        return !(((d6 > d6 ? 1 : (d6 == d6 ? 0 : -1)) != 0) ^ ((d > d ? 1 : (d == d ? 0 : -1)) != 0));
    }

    public static boolean equals(double d, double d6) {
        return equals(d, d6, 1);
    }

    public static boolean equals(double d, double d6, double d7) {
        return equals(d, d6, 1) || FastMath.abs(d6 - d) <= d7;
    }

    public static boolean equals(double d, double d6, int i5) {
        long j6;
        long j7;
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d6);
        if (((jDoubleToRawLongBits ^ jDoubleToRawLongBits2) & SGN_MASK) != 0) {
            if (jDoubleToRawLongBits < jDoubleToRawLongBits2) {
                j6 = jDoubleToRawLongBits2 - POSITIVE_ZERO_DOUBLE_BITS;
                j7 = jDoubleToRawLongBits - NEGATIVE_ZERO_DOUBLE_BITS;
            } else {
                long j8 = jDoubleToRawLongBits - POSITIVE_ZERO_DOUBLE_BITS;
                long j9 = jDoubleToRawLongBits2 - NEGATIVE_ZERO_DOUBLE_BITS;
                j6 = j8;
                j7 = j9;
            }
            long j10 = i5;
            if (j6 > j10 || j7 > j10 - j6) {
                return false;
            }
        } else if (FastMath.abs(jDoubleToRawLongBits - jDoubleToRawLongBits2) > i5) {
            return false;
        }
        return (Double.isNaN(d) || Double.isNaN(d6)) ? false : true;
    }
}
