package org.apache.commons.math3.special;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.ContinuedFraction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Gamma {
    private static final double C_LIMIT = 49.0d;
    private static final double DEFAULT_EPSILON = 1.0E-14d;
    public static final double GAMMA = 0.5772156649015329d;
    private static final double INV_GAMMA1P_M1_A0 = 6.116095104481416E-9d;
    private static final double INV_GAMMA1P_M1_A1 = 6.247308301164655E-9d;
    private static final double INV_GAMMA1P_M1_B1 = 0.203610414066807d;
    private static final double INV_GAMMA1P_M1_B2 = 0.026620534842894922d;
    private static final double INV_GAMMA1P_M1_B3 = 4.939449793824468E-4d;
    private static final double INV_GAMMA1P_M1_B4 = -8.514194324403149E-6d;
    private static final double INV_GAMMA1P_M1_B5 = -6.4304548177935305E-6d;
    private static final double INV_GAMMA1P_M1_B6 = 9.926418406727737E-7d;
    private static final double INV_GAMMA1P_M1_B7 = -6.077618957228252E-8d;
    private static final double INV_GAMMA1P_M1_B8 = 1.9575583661463974E-10d;
    private static final double INV_GAMMA1P_M1_C = -0.42278433509846713d;
    private static final double INV_GAMMA1P_M1_C0 = 0.5772156649015329d;
    private static final double INV_GAMMA1P_M1_C1 = -0.6558780715202539d;
    private static final double INV_GAMMA1P_M1_C10 = -2.013485478078824E-5d;
    private static final double INV_GAMMA1P_M1_C11 = -1.2504934821426706E-6d;
    private static final double INV_GAMMA1P_M1_C12 = 1.133027231981696E-6d;
    private static final double INV_GAMMA1P_M1_C13 = -2.056338416977607E-7d;
    private static final double INV_GAMMA1P_M1_C2 = -0.04200263503409524d;
    private static final double INV_GAMMA1P_M1_C3 = 0.16653861138229148d;
    private static final double INV_GAMMA1P_M1_C4 = -0.04219773455554433d;
    private static final double INV_GAMMA1P_M1_C5 = -0.009621971527876973d;
    private static final double INV_GAMMA1P_M1_C6 = 0.0072189432466631d;
    private static final double INV_GAMMA1P_M1_C7 = -0.0011651675918590652d;
    private static final double INV_GAMMA1P_M1_C8 = -2.1524167411495098E-4d;
    private static final double INV_GAMMA1P_M1_C9 = 1.280502823881162E-4d;
    private static final double INV_GAMMA1P_M1_P0 = 6.116095104481416E-9d;
    private static final double INV_GAMMA1P_M1_P1 = 6.8716741130671986E-9d;
    private static final double INV_GAMMA1P_M1_P2 = 6.820161668496171E-10d;
    private static final double INV_GAMMA1P_M1_P3 = 4.686843322948848E-11d;
    private static final double INV_GAMMA1P_M1_P4 = 1.5728330277104463E-12d;
    private static final double INV_GAMMA1P_M1_P5 = -1.2494415722763663E-13d;
    private static final double INV_GAMMA1P_M1_P6 = 4.343529937408594E-15d;
    private static final double INV_GAMMA1P_M1_Q1 = 0.3056961078365221d;
    private static final double INV_GAMMA1P_M1_Q2 = 0.054642130860422966d;
    private static final double INV_GAMMA1P_M1_Q3 = 0.004956830093825887d;
    private static final double INV_GAMMA1P_M1_Q4 = 2.6923694661863613E-4d;
    public static final double LANCZOS_G = 4.7421875d;
    private static final double SQRT_TWO_PI = 2.5066282746310007d;
    private static final double S_LIMIT = 1.0E-5d;
    private static final double[] LANCZOS = {0.9999999999999971d, 57.15623566586292d, -59.59796035547549d, 14.136097974741746d, -0.4919138160976202d, 3.399464998481189E-5d, 4.652362892704858E-5d, -9.837447530487956E-5d, 1.580887032249125E-4d, -2.1026444172410488E-4d, 2.1743961811521265E-4d, -1.643181065367639E-4d, 8.441822398385275E-5d, -2.6190838401581408E-5d, 3.6899182659531625E-6d};
    private static final double HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;

    private Gamma() {
    }

    public static double digamma(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > 0.0d && d <= 1.0E-5d) {
            return (-0.5772156649015329d) - (1.0d / d);
        }
        if (d < C_LIMIT) {
            return digamma(d + 1.0d) - (1.0d / d);
        }
        double d6 = 1.0d / (d * d);
        return (FastMath.log(d) - (0.5d / d)) - ((((0.008333333333333333d - (d6 / 252.0d)) * d6) + 0.08333333333333333d) * d6);
    }

    public static double gamma(double d) {
        if (d == FastMath.rint(d) && d <= 0.0d) {
            return Double.NaN;
        }
        double dAbs = FastMath.abs(d);
        if (dAbs > 20.0d) {
            double d6 = 4.7421875d + dAbs + 0.5d;
            double dLanczos = lanczos(dAbs) * FastMath.exp(-d6) * FastMath.pow(d6, 0.5d + dAbs) * (SQRT_TWO_PI / dAbs);
            return d > 0.0d ? dLanczos : (-3.141592653589793d) / ((FastMath.sin(3.141592653589793d * d) * d) * dLanczos);
        }
        if (d >= 1.0d) {
            double d7 = 1.0d;
            while (d > 2.5d) {
                d -= 1.0d;
                d7 *= d;
            }
            return d7 / (invGamma1pm1(d - 1.0d) + 1.0d);
        }
        double d8 = d;
        while (d < -0.5d) {
            d += 1.0d;
            d8 *= d;
        }
        return 1.0d / ((invGamma1pm1(d) + 1.0d) * d8);
    }

    public static double invGamma1pm1(double d) {
        if (d < -0.5d) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(-0.5d), true);
        }
        if (d > 1.5d) {
            throw new NumberIsTooLargeException(Double.valueOf(d), Double.valueOf(1.5d), true);
        }
        double d6 = d <= 0.5d ? d : (d - 0.5d) - 0.5d;
        if (d6 < 0.0d) {
            double d7 = ((((((((((((((((((((((((((((((INV_GAMMA1P_M1_A1 * d6) + 6.116095104481416E-9d) / ((((((((((((((((INV_GAMMA1P_M1_B8 * d6) + INV_GAMMA1P_M1_B7) * d6) + INV_GAMMA1P_M1_B6) * d6) + INV_GAMMA1P_M1_B5) * d6) + INV_GAMMA1P_M1_B4) * d6) + INV_GAMMA1P_M1_B3) * d6) + INV_GAMMA1P_M1_B2) * d6) + INV_GAMMA1P_M1_B1) * d6) + 1.0d)) * d6) + INV_GAMMA1P_M1_C13) * d6) + INV_GAMMA1P_M1_C12) * d6) + INV_GAMMA1P_M1_C11) * d6) + INV_GAMMA1P_M1_C10) * d6) + INV_GAMMA1P_M1_C9) * d6) + INV_GAMMA1P_M1_C8) * d6) + INV_GAMMA1P_M1_C7) * d6) + INV_GAMMA1P_M1_C6) * d6) + INV_GAMMA1P_M1_C5) * d6) + INV_GAMMA1P_M1_C4) * d6) + INV_GAMMA1P_M1_C3) * d6) + INV_GAMMA1P_M1_C2) * d6) + INV_GAMMA1P_M1_C1) * d6) + INV_GAMMA1P_M1_C;
            return d > 0.5d ? (d6 * d7) / d : (d7 + 0.5d + 0.5d) * d;
        }
        double d8 = ((((((((((((((((((((((((((((((((((((((((INV_GAMMA1P_M1_P6 * d6) + INV_GAMMA1P_M1_P5) * d6) + INV_GAMMA1P_M1_P4) * d6) + INV_GAMMA1P_M1_P3) * d6) + INV_GAMMA1P_M1_P2) * d6) + INV_GAMMA1P_M1_P1) * d6) + 6.116095104481416E-9d) / ((((((((INV_GAMMA1P_M1_Q4 * d6) + INV_GAMMA1P_M1_Q3) * d6) + INV_GAMMA1P_M1_Q2) * d6) + INV_GAMMA1P_M1_Q1) * d6) + 1.0d)) * d6) + INV_GAMMA1P_M1_C13) * d6) + INV_GAMMA1P_M1_C12) * d6) + INV_GAMMA1P_M1_C11) * d6) + INV_GAMMA1P_M1_C10) * d6) + INV_GAMMA1P_M1_C9) * d6) + INV_GAMMA1P_M1_C8) * d6) + INV_GAMMA1P_M1_C7) * d6) + INV_GAMMA1P_M1_C6) * d6) + INV_GAMMA1P_M1_C5) * d6) + INV_GAMMA1P_M1_C4) * d6) + INV_GAMMA1P_M1_C3) * d6) + INV_GAMMA1P_M1_C2) * d6) + INV_GAMMA1P_M1_C1) * d6) + 0.5772156649015329d;
        if (d > 0.5d) {
            return ((d8 - 0.5d) - 0.5d) * (d6 / d);
        }
        return d * d8;
    }

    public static double lanczos(double d) {
        double d6 = 0.0d;
        for (int length = LANCZOS.length - 1; length > 0; length--) {
            d6 += LANCZOS[length] / (((double) length) + d);
        }
        return d6 + LANCZOS[0];
    }

    public static double logGamma(double d) {
        if (Double.isNaN(d) || d <= 0.0d) {
            return Double.NaN;
        }
        if (d < 0.5d) {
            return logGamma1p(d) - FastMath.log(d);
        }
        if (d <= 2.5d) {
            return logGamma1p((d - 0.5d) - 0.5d);
        }
        if (d > 8.0d) {
            double d6 = 4.7421875d + d + 0.5d;
            return FastMath.log(lanczos(d) / d) + ((FastMath.log(d6) * (0.5d + d)) - d6) + HALF_LOG_2_PI;
        }
        int iFloor = (int) FastMath.floor(d - 1.5d);
        double d7 = 1.0d;
        for (int i5 = 1; i5 <= iFloor; i5++) {
            d7 *= d - ((double) i5);
        }
        return FastMath.log(d7) + logGamma1p(d - ((double) (iFloor + 1)));
    }

    public static double logGamma1p(double d) {
        if (d < -0.5d) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(-0.5d), true);
        }
        if (d <= 1.5d) {
            return -FastMath.log1p(invGamma1pm1(d));
        }
        throw new NumberIsTooLargeException(Double.valueOf(d), Double.valueOf(1.5d), true);
    }

    public static double regularizedGammaP(double d, double d6) {
        return regularizedGammaP(d, d6, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double regularizedGammaQ(double d, double d6) {
        return regularizedGammaQ(d, d6, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    public static double trigamma(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > 0.0d && d <= 1.0E-5d) {
            return 1.0d / (d * d);
        }
        if (d < C_LIMIT) {
            return (1.0d / (d * d)) + trigamma(d + 1.0d);
        }
        double d6 = 1.0d / (d * d);
        return ((0.16666666666666666d - (((d6 / 42.0d) + 0.03333333333333333d) * d6)) * (d6 / d)) + (d6 / 2.0d) + (1.0d / d);
    }

    public static double regularizedGammaP(double d, double d6, double d7, int i5) {
        if (Double.isNaN(d) || Double.isNaN(d6)) {
            return Double.NaN;
        }
        double d8 = 0.0d;
        if (d <= 0.0d || d6 < 0.0d) {
            return Double.NaN;
        }
        if (d6 == 0.0d) {
            return 0.0d;
        }
        if (d6 >= d + 1.0d) {
            return 1.0d - regularizedGammaQ(d, d6, d7, i5);
        }
        double d9 = 1.0d / d;
        double d10 = d9;
        while (FastMath.abs(d9 / d10) > d7 && d8 < i5 && d10 < Double.POSITIVE_INFINITY) {
            d8 += 1.0d;
            d9 *= d6 / (d + d8);
            d10 += d9;
        }
        if (d8 >= i5) {
            throw new MaxCountExceededException(Integer.valueOf(i5));
        }
        if (Double.isInfinite(d10)) {
            return 1.0d;
        }
        return FastMath.exp(((FastMath.log(d6) * d) + (-d6)) - logGamma(d)) * d10;
    }

    public static double regularizedGammaQ(final double d, double d6, double d7, int i5) {
        if (Double.isNaN(d) || Double.isNaN(d6) || d <= 0.0d || d6 < 0.0d) {
            return Double.NaN;
        }
        if (d6 == 0.0d) {
            return 1.0d;
        }
        if (d6 < d + 1.0d) {
            return 1.0d - regularizedGammaP(d, d6, d7, i5);
        }
        return FastMath.exp(((FastMath.log(d6) * d) + (-d6)) - logGamma(d)) * (1.0d / new ContinuedFraction() { // from class: org.apache.commons.math3.special.Gamma.1
            @Override // org.apache.commons.math3.util.ContinuedFraction
            public double getA(int i6, double d8) {
                return (((((double) i6) * 2.0d) + 1.0d) - d) + d8;
            }

            @Override // org.apache.commons.math3.util.ContinuedFraction
            public double getB(int i6, double d8) {
                double d9 = i6;
                return (d - d9) * d9;
            }
        }.evaluate(d6, d7, i5));
    }
}
