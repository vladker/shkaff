package org.apache.commons.math3.distribution;

import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class SaddlePointExpansion {
    private static final double HALF_LOG_2_PI = FastMath.log(6.283185307179586d) * 0.5d;
    private static final double[] EXACT_STIRLING_ERRORS = {0.0d, 0.15342640972002736d, 0.08106146679532726d, 0.05481412105191765d, 0.0413406959554093d, 0.03316287351993629d, 0.02767792568499834d, 0.023746163656297496d, 0.020790672103765093d, 0.018488450532673187d, 0.016644691189821193d, 0.015134973221917378d, 0.013876128823070748d, 0.012810465242920227d, 0.01189670994589177d, 0.011104559758206917d, 0.010411265261972096d, 0.009799416126158804d, 0.009255462182712733d, 0.008768700134139386d, 0.00833056343336287d, 0.00793411456431402d, 0.007573675487951841d, 0.007244554301320383d, 0.00694284010720953d, 0.006665247032707682d, 0.006408994188004207d, 0.006171712263039458d, 0.0059513701127588475d, 0.0057462165130101155d, 0.005554733551962801d};

    private SaddlePointExpansion() {
    }

    public static double getDeviancePart(double d, double d6) {
        double d7 = d - d6;
        double d8 = d + d6;
        if (FastMath.abs(d7) >= 0.1d * d8) {
            return ((FastMath.log(d / d6) * d) + d6) - d;
        }
        double d9 = d7 / d8;
        double d10 = d7 * d9;
        double d11 = d * 2.0d * d9;
        double d12 = d9 * d9;
        double d13 = Double.NaN;
        int i5 = 1;
        while (d10 != d13) {
            d11 *= d12;
            double d14 = (d11 / ((double) ((i5 * 2) + 1))) + d10;
            i5++;
            d13 = d10;
            d10 = d14;
        }
        return d10;
    }

    public static double getStirlingError(double d) {
        if (d >= 15.0d) {
            double d6 = d * d;
            return (0.08333333333333333d - ((0.002777777777777778d - ((7.936507936507937E-4d - ((5.952380952380953E-4d - (8.417508417508417E-4d / d6)) / d6)) / d6)) / d6)) / d;
        }
        double d7 = 2.0d * d;
        if (FastMath.floor(d7) == d7) {
            return EXACT_STIRLING_ERRORS[(int) d7];
        }
        return ((Gamma.logGamma(1.0d + d) - (FastMath.log(d) * (0.5d + d))) + d) - HALF_LOG_2_PI;
    }

    public static double logBinomialProbability(int i5, int i6, double d, double d6) {
        if (i5 == 0) {
            if (d < 0.1d) {
                double d7 = i6;
                return (-getDeviancePart(d7, d6 * d7)) - (d7 * d);
            }
            return FastMath.log(d6) * ((double) i6);
        }
        if (i5 == i6) {
            if (d6 < 0.1d) {
                double d8 = i6;
                return (-getDeviancePart(d8, d * d8)) - (d8 * d6);
            }
            return FastMath.log(d) * ((double) i6);
        }
        double d9 = i6;
        double d10 = i5;
        double d11 = i6 - i5;
        return (FastMath.log(((d10 * 6.283185307179586d) * d11) / d9) * (-0.5d)) + ((((getStirlingError(d9) - getStirlingError(d10)) - getStirlingError(d11)) - getDeviancePart(d10, d * d9)) - getDeviancePart(d11, d6 * d9));
    }
}
