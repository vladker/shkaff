package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double d, double d6, double d7) {
        if (d7 < d) {
            return d;
        }
        return d7 > d6 ? d6 : d7;
    }

    public static int clampInt(int i5, int i6, int i7) {
        if (i7 < i5) {
            return i5;
        }
        return i7 > i6 ? i6 : i7;
    }

    public static double differenceDegrees(double d, double d6) {
        return 180.0d - Math.abs(Math.abs(d - d6) - 180.0d);
    }

    public static double lerp(double d, double d6, double d7) {
        return (d7 * d6) + ((1.0d - d7) * d);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d6 = dArr3[0] * d;
        double d7 = dArr[1];
        double d8 = (dArr3[1] * d7) + d6;
        double d9 = dArr[2];
        double d10 = (dArr3[2] * d9) + d8;
        double[] dArr4 = dArr2[1];
        double d11 = (dArr4[2] * d9) + (dArr4[1] * d7) + (dArr4[0] * d);
        double[] dArr5 = dArr2[2];
        return new double[]{d10, d11, (d9 * dArr5[2]) + (d7 * dArr5[1]) + (d * dArr5[0])};
    }

    public static double rotationDirection(double d, double d6) {
        return sanitizeDegreesDouble(d6 - d) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double sanitizeDegreesDouble(double d) {
        double d6 = d % 360.0d;
        return d6 < 0.0d ? d6 + 360.0d : d6;
    }

    public static int sanitizeDegreesInt(int i5) {
        int i6 = i5 % 360;
        return i6 < 0 ? i6 + 360 : i6;
    }

    public static int signum(double d) {
        if (d < 0.0d) {
            return -1;
        }
        return d == 0.0d ? 0 : 1;
    }
}
