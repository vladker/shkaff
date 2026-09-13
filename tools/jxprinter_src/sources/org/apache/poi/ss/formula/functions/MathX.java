package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class MathX {
    private MathX() {
    }

    public static double acosh(double d) {
        return Math.log(Math.sqrt(Math.pow(d, 2.0d) - 1.0d) + d);
    }

    public static double asinh(double d) {
        return Math.log(Math.sqrt((d * d) + 1.0d) + d);
    }

    public static double atanh(double d) {
        return Math.log((d + 1.0d) / (1.0d - d)) / 2.0d;
    }

    public static double average(double[] dArr) {
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6;
        }
        return d / ((double) dArr.length);
    }

    public static double ceiling(double d, double d6) {
        if (d > 0.0d && d6 < 0.0d) {
            return Double.NaN;
        }
        if (d == 0.0d || d6 == 0.0d) {
            return 0.0d;
        }
        return d6 == 1.0d ? Math.ceil(d) : scaledRoundUsingBigDecimal(d, d6, RoundingMode.CEILING);
    }

    public static double cosh(double d) {
        return (Math.pow(2.718281828459045d, -d) + Math.pow(2.718281828459045d, d)) / 2.0d;
    }

    public static double factorial(int i5) {
        if (i5 < 0) {
            return Double.NaN;
        }
        if (i5 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        for (int i6 = 1; i6 <= i5; i6++) {
            d *= (double) i6;
        }
        return d;
    }

    public static double floor(double d, double d6) {
        if (d6 == 0.0d && d != 0.0d) {
            return Double.NaN;
        }
        if (d == 0.0d || d6 == 0.0d) {
            return 0.0d;
        }
        if (d6 == 1.0d) {
            return Math.floor(d);
        }
        if (d6 >= 0.0d || d < 0.0d) {
            return scaledRoundUsingBigDecimal(d, d6, RoundingMode.FLOOR);
        }
        return Double.NaN;
    }

    public static double max(double[] dArr) {
        double dMax = Double.NEGATIVE_INFINITY;
        for (double d : dArr) {
            dMax = Math.max(dMax, d);
        }
        return dMax;
    }

    public static double min(double[] dArr) {
        double dMin = Double.POSITIVE_INFINITY;
        for (double d : dArr) {
            dMin = Math.min(dMin, d);
        }
        return dMin;
    }

    public static double mod(double d, double d6) {
        if (d6 == 0.0d) {
            return Double.NaN;
        }
        return sign(d) == sign(d6) ? d % d6 : ((d % d6) + d6) % d6;
    }

    public static double nChooseK(int i5, int i6) {
        if (i6 < 0 || i5 < i6) {
            return Double.NaN;
        }
        int i7 = i5 - i6;
        int iMin = Math.min(i7, i6);
        int iMax = Math.max(i7, i6);
        double d = 1.0d;
        while (iMax < i5) {
            iMax++;
            d *= (double) iMax;
        }
        return d / factorial(iMin);
    }

    public static double product(double[] dArr) {
        if (dArr == null || dArr.length <= 0) {
            return 0.0d;
        }
        double d = 1.0d;
        for (double d6 : dArr) {
            d *= d6;
        }
        return d;
    }

    public static double round(double d, int i5) {
        return round(d, i5, RoundingMode.HALF_UP);
    }

    public static double roundDown(double d, int i5) {
        return round(d, i5, RoundingMode.DOWN);
    }

    public static double roundUp(double d, int i5) {
        return round(d, i5, RoundingMode.UP);
    }

    @Internal
    public static double scaledRoundUsingBigDecimal(double d, double d6, RoundingMode roundingMode) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d6);
        return BigDecimal.valueOf(d).divide(bigDecimalValueOf, MathContext.DECIMAL128).setScale(0, roundingMode).multiply(bigDecimalValueOf).doubleValue();
    }

    public static short sign(double d) {
        int i5;
        if (d == 0.0d) {
            i5 = 0;
        } else {
            i5 = d < 0.0d ? -1 : 1;
        }
        return (short) i5;
    }

    public static double sinh(double d) {
        return (Math.pow(2.718281828459045d, d) - Math.pow(2.718281828459045d, -d)) / 2.0d;
    }

    public static double sum(double[] dArr) {
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6;
        }
        return d;
    }

    public static double sumsq(double[] dArr) {
        double d = 0.0d;
        for (double d6 : dArr) {
            d += d6 * d6;
        }
        return d;
    }

    public static double tanh(double d) {
        double dPow = Math.pow(2.718281828459045d, d);
        double dPow2 = Math.pow(2.718281828459045d, -d);
        return (dPow - dPow2) / (dPow + dPow2);
    }

    public static double factorial(double d) {
        return factorial((int) d);
    }

    public static double round(double d, double d6) {
        return round(d, (int) d6);
    }

    public static double roundDown(double d, double d6) {
        return roundDown(d, (int) d6);
    }

    public static double roundUp(double d, double d6) {
        return roundUp(d, (int) d6);
    }

    private static double round(double d, int i5, RoundingMode roundingMode) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return Double.NaN;
        }
        return new BigDecimal(NumberToTextConverter.toText(d)).setScale(i5, roundingMode).doubleValue();
    }
}
