package org.apache.commons.math3.special;

import androidx.collection.a;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.ContinuedFraction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Beta {
    private static final double DEFAULT_EPSILON = 1.0E-14d;
    private static final double[] DELTA = {0.08333333333333333d, -2.777777777777778E-5d, 7.936507936507937E-8d, -5.952380952380953E-10d, 8.417508417508329E-12d, -1.917526917518546E-13d, 6.410256405103255E-15d, -2.955065141253382E-16d, 1.7964371635940225E-17d, -1.3922896466162779E-18d, 1.338028550140209E-19d, -1.542460098679661E-20d, 1.9770199298095743E-21d, -2.3406566479399704E-22d, 1.713480149663986E-23d};
    private static final double HALF_LOG_TWO_PI = 0.9189385332046727d;

    private Beta() {
    }

    private static double deltaMinusDeltaSum(double d, double d6) {
        if (d < 0.0d || d > d6) {
            throw new OutOfRangeException(Double.valueOf(d), 0, Double.valueOf(d6));
        }
        if (d6 < 10.0d) {
            throw new NumberIsTooSmallException(Double.valueOf(d6), 10, true);
        }
        double d7 = d / d6;
        double d8 = d7 + 1.0d;
        double d9 = d7 / d8;
        double d10 = 1.0d / d8;
        double d11 = d10 * d10;
        int length = DELTA.length;
        double[] dArr = new double[length];
        dArr[0] = 1.0d;
        for (int i5 = 1; i5 < length; i5++) {
            dArr[i5] = a.A(d11, dArr[i5 - 1], d10, 1.0d);
        }
        double d12 = 10.0d / d6;
        double d13 = d12 * d12;
        double[] dArr2 = DELTA;
        double d14 = dArr2[dArr2.length - 1] * dArr[length - 1];
        for (int length2 = dArr2.length - 2; length2 >= 0; length2--) {
            d14 = (d14 * d13) + (DELTA[length2] * dArr[length2]);
        }
        return (d14 * d9) / d6;
    }

    @Deprecated
    public static double logBeta(double d, double d6, double d7, int i5) {
        return logBeta(d, d6);
    }

    private static double logGammaMinusLogGammaSum(double d, double d6) {
        double d7;
        double dDeltaMinusDeltaSum;
        if (d < 0.0d) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(0.0d), true);
        }
        if (d6 < 10.0d) {
            throw new NumberIsTooSmallException(Double.valueOf(d6), Double.valueOf(10.0d), true);
        }
        if (d <= d6) {
            d7 = (d - 0.5d) + d6;
            dDeltaMinusDeltaSum = deltaMinusDeltaSum(d, d6);
        } else {
            d7 = (d6 - 0.5d) + d;
            dDeltaMinusDeltaSum = deltaMinusDeltaSum(d6, d);
        }
        double dLog1p = FastMath.log1p(d / d6) * d7;
        double dLog = (FastMath.log(d6) - 1.0d) * d;
        return dLog1p <= dLog ? (dDeltaMinusDeltaSum - dLog1p) - dLog : (dDeltaMinusDeltaSum - dLog) - dLog1p;
    }

    private static double logGammaSum(double d, double d6) {
        double dLogGamma1p;
        double dLog;
        Double dValueOf = Double.valueOf(2.0d);
        Double dValueOf2 = Double.valueOf(1.0d);
        if (d < 1.0d || d > 2.0d) {
            throw new OutOfRangeException(Double.valueOf(d), dValueOf2, dValueOf);
        }
        if (d6 < 1.0d || d6 > 2.0d) {
            throw new OutOfRangeException(Double.valueOf(d6), dValueOf2, dValueOf);
        }
        double d7 = (d6 - 1.0d) + (d - 1.0d);
        if (d7 <= 0.5d) {
            return Gamma.logGamma1p(d7 + 1.0d);
        }
        if (d7 <= 1.5d) {
            dLogGamma1p = Gamma.logGamma1p(d7);
            dLog = FastMath.log1p(d7);
        } else {
            dLogGamma1p = Gamma.logGamma1p(d7 - 1.0d);
            dLog = FastMath.log((1.0d + d7) * d7);
        }
        return dLog + dLogGamma1p;
    }

    public static double regularizedBeta(double d, double d6, double d7) {
        return regularizedBeta(d, d6, d7, DEFAULT_EPSILON, Integer.MAX_VALUE);
    }

    private static double sumDeltaMinusDeltaSum(double d, double d6) {
        Double dValueOf = Double.valueOf(10.0d);
        if (d < 10.0d) {
            throw new NumberIsTooSmallException(Double.valueOf(d), dValueOf, true);
        }
        if (d6 < 10.0d) {
            throw new NumberIsTooSmallException(Double.valueOf(d6), dValueOf, true);
        }
        double dMin = FastMath.min(d, d6);
        double dMax = FastMath.max(d, d6);
        double d7 = 10.0d / dMin;
        double d8 = d7 * d7;
        double[] dArr = DELTA;
        double d9 = dArr[dArr.length - 1];
        for (int length = dArr.length - 2; length >= 0; length--) {
            d9 = (d9 * d8) + DELTA[length];
        }
        return (d9 / dMin) + deltaMinusDeltaSum(dMin, dMax);
    }

    public static double logBeta(double d, double d6) {
        double dLogGamma;
        double dLogGammaMinusLogGammaSum;
        double dLog;
        double dLogGamma2;
        double dLogGamma3;
        double dLogGammaSum;
        if (Double.isNaN(d) || Double.isNaN(d6) || d <= 0.0d || d6 <= 0.0d) {
            return Double.NaN;
        }
        double dMin = FastMath.min(d, d6);
        double dMax = FastMath.max(d, d6);
        if (dMin >= 10.0d) {
            double dSumDeltaMinusDeltaSum = sumDeltaMinusDeltaSum(dMin, dMax);
            double d7 = dMin / dMax;
            double dLog2 = FastMath.log(d7 / (1.0d + d7)) * (-(dMin - 0.5d));
            double dLog1p = FastMath.log1p(d7) * dMax;
            return dLog2 <= dLog1p ? ((((FastMath.log(dMax) * (-0.5d)) + HALF_LOG_TWO_PI) + dSumDeltaMinusDeltaSum) - dLog2) - dLog1p : ((((FastMath.log(dMax) * (-0.5d)) + HALF_LOG_TWO_PI) + dSumDeltaMinusDeltaSum) - dLog1p) - dLog2;
        }
        if (dMin <= 2.0d) {
            if (dMin >= 1.0d) {
                if (dMax <= 2.0d) {
                    return (Gamma.logGamma(dMax) + Gamma.logGamma(dMin)) - logGammaSum(dMin, dMax);
                }
                if (dMax < 10.0d) {
                    double d8 = 1.0d;
                    while (dMax > 2.0d) {
                        dMax -= 1.0d;
                        d8 *= dMax / (dMin + dMax);
                    }
                    dLog = FastMath.log(d8);
                    dLogGamma2 = Gamma.logGamma(dMin);
                    dLogGamma3 = Gamma.logGamma(dMax);
                    dLogGammaSum = logGammaSum(dMin, dMax);
                } else {
                    dLogGamma = Gamma.logGamma(dMin);
                    dLogGammaMinusLogGammaSum = logGammaMinusLogGammaSum(dMin, dMax);
                }
            } else {
                if (dMax < 10.0d) {
                    return FastMath.log((Gamma.gamma(dMax) * Gamma.gamma(dMin)) / Gamma.gamma(dMin + dMax));
                }
                dLogGamma = Gamma.logGamma(dMin);
                dLogGammaMinusLogGammaSum = logGammaMinusLogGammaSum(dMin, dMax);
            }
            return dLogGamma + dLogGammaMinusLogGammaSum;
        }
        if (dMax > 1000.0d) {
            int iFloor = (int) FastMath.floor(dMin - 1.0d);
            double d9 = 1.0d;
            for (int i5 = 0; i5 < iFloor; i5++) {
                dMin -= 1.0d;
                d9 *= dMin / ((dMin / dMax) + 1.0d);
            }
            return Gamma.logGamma(dMin) + logGammaMinusLogGammaSum(dMin, dMax) + (FastMath.log(d9) - (FastMath.log(dMax) * ((double) iFloor)));
        }
        double d10 = 1.0d;
        while (dMin > 2.0d) {
            dMin -= 1.0d;
            double d11 = dMin / dMax;
            d10 *= d11 / (d11 + 1.0d);
        }
        if (dMax >= 10.0d) {
            return Gamma.logGamma(dMin) + FastMath.log(d10) + logGammaMinusLogGammaSum(dMin, dMax);
        }
        double d12 = 1.0d;
        while (dMax > 2.0d) {
            dMax -= 1.0d;
            d12 *= dMax / (dMin + dMax);
        }
        dLog = FastMath.log(d12) + FastMath.log(d10);
        dLogGamma2 = Gamma.logGamma(dMin);
        dLogGamma3 = Gamma.logGamma(dMax);
        dLogGammaSum = logGammaSum(dMin, dMax);
        return (dLogGamma3 - dLogGammaSum) + dLogGamma2 + dLog;
    }

    public static double regularizedBeta(double d, double d6, double d7, double d8) {
        return regularizedBeta(d, d6, d7, d8, Integer.MAX_VALUE);
    }

    public static double regularizedBeta(double d, double d6, double d7, int i5) {
        return regularizedBeta(d, d6, d7, DEFAULT_EPSILON, i5);
    }

    public static double regularizedBeta(double d, final double d6, final double d7, double d8, int i5) {
        if (Double.isNaN(d) || Double.isNaN(d6) || Double.isNaN(d7) || d < 0.0d || d > 1.0d || d6 <= 0.0d || d7 <= 0.0d) {
            return Double.NaN;
        }
        double d9 = d7 + 2.0d + d6;
        if (d > (d6 + 1.0d) / d9) {
            double d10 = 1.0d - d;
            if (d10 <= (d7 + 1.0d) / d9) {
                return 1.0d - regularizedBeta(d10, d7, d6, d8, i5);
            }
        }
        ContinuedFraction continuedFraction = new ContinuedFraction() { // from class: org.apache.commons.math3.special.Beta.1
            @Override // org.apache.commons.math3.util.ContinuedFraction
            public double getA(int i6, double d11) {
                return 1.0d;
            }

            @Override // org.apache.commons.math3.util.ContinuedFraction
            public double getB(int i6, double d11) {
                if (i6 % 2 == 0) {
                    double d12 = ((double) i6) / 2.0d;
                    double d13 = (d7 - d12) * d12 * d11;
                    double d14 = d6;
                    double d15 = d12 * 2.0d;
                    return d13 / ((d14 + d15) * ((d14 + d15) - 1.0d));
                }
                double d16 = (((double) i6) - 1.0d) / 2.0d;
                double d17 = d6;
                double d18 = -((d7 + d17 + d16) * (d17 + d16) * d11);
                double d19 = d16 * 2.0d;
                return d18 / (((d17 + d19) + 1.0d) * (d17 + d19));
            }
        };
        return (FastMath.exp((((FastMath.log1p(-d) * d7) + (FastMath.log(d) * d6)) - FastMath.log(d6)) - logBeta(d6, d7)) * 1.0d) / continuedFraction.evaluate(d, d8, i5);
    }
}
