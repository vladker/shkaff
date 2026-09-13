package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {
    private static final double CONTRAST_RATIO_EPSILON = 0.04d;
    private static final double LUMINANCE_GAMUT_MAP_TOLERANCE = 0.4d;
    public static final double RATIO_30 = 3.0d;
    public static final double RATIO_45 = 4.5d;
    public static final double RATIO_70 = 7.0d;
    public static final double RATIO_MAX = 21.0d;
    public static final double RATIO_MIN = 1.0d;

    private Contrast() {
    }

    public static double darker(double d, double d6) {
        if (d >= 0.0d && d <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d);
            double d7 = ((dYFromLstar + 5.0d) / d6) - 5.0d;
            if (d7 >= 0.0d && d7 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(dYFromLstar, d7);
                double dAbs = Math.abs(dRatioOfYs - d6);
                if (dRatioOfYs < d6 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d7) - LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= 0.0d && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double darkerUnsafe(double d, double d6) {
        return Math.max(0.0d, darker(d, d6));
    }

    public static double lighter(double d, double d6) {
        if (d >= 0.0d && d <= 100.0d) {
            double dYFromLstar = ColorUtils.yFromLstar(d);
            double d7 = ((dYFromLstar + 5.0d) * d6) - 5.0d;
            if (d7 >= 0.0d && d7 <= 100.0d) {
                double dRatioOfYs = ratioOfYs(d7, dYFromLstar);
                double dAbs = Math.abs(dRatioOfYs - d6);
                if (dRatioOfYs < d6 && dAbs > CONTRAST_RATIO_EPSILON) {
                    return -1.0d;
                }
                double dLstarFromY = ColorUtils.lstarFromY(d7) + LUMINANCE_GAMUT_MAP_TOLERANCE;
                if (dLstarFromY >= 0.0d && dLstarFromY <= 100.0d) {
                    return dLstarFromY;
                }
            }
        }
        return -1.0d;
    }

    public static double lighterUnsafe(double d, double d6) {
        double dLighter = lighter(d, d6);
        if (dLighter < 0.0d) {
            return 100.0d;
        }
        return dLighter;
    }

    public static double ratioOfTones(double d, double d6) {
        return ratioOfYs(ColorUtils.yFromLstar(d), ColorUtils.yFromLstar(d6));
    }

    public static double ratioOfYs(double d, double d6) {
        double dMax = Math.max(d, d6);
        if (dMax != d6) {
            d = d6;
        }
        return (dMax + 5.0d) / (d + 5.0d);
    }
}
