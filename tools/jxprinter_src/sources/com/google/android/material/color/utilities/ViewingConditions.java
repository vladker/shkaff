package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final double f3330n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final double f3331z;

    private ViewingConditions(double d, double d6, double d7, double d8, double d9, double d10, double[] dArr, double d11, double d12, double d13) {
        this.f3330n = d;
        this.aw = d6;
        this.nbb = d7;
        this.ncb = d8;
        this.c = d9;
        this.nc = d10;
        this.rgbD = dArr;
        this.fl = d11;
        this.flRoot = d12;
        this.f3331z = d13;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d, 2.0d, false);
    }

    public static ViewingConditions make(double[] dArr, double d, double d6, double d7, boolean z6) {
        double dMax = Math.max(0.1d, d6);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d8 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d9 = dArr3[0] * d8;
        double d10 = dArr[1];
        double d11 = (dArr3[1] * d10) + d9;
        double d12 = dArr[2];
        double d13 = (dArr3[2] * d12) + d11;
        double[] dArr4 = dArr2[1];
        double d14 = (dArr4[2] * d12) + (dArr4[1] * d10) + (dArr4[0] * d8);
        double[] dArr5 = dArr2[2];
        double d15 = (d12 * dArr5[2]) + (d10 * dArr5[1]) + (d8 * dArr5[0]);
        double d16 = (d7 / 10.0d) + 0.8d;
        double dLerp = d16 >= 0.9d ? MathUtils.lerp(0.59d, 0.69d, (d16 - 0.9d) * 10.0d) : MathUtils.lerp(0.525d, 0.59d, (d16 - 0.8d) * 10.0d);
        double dClampDouble = MathUtils.clampDouble(0.0d, 1.0d, z6 ? 1.0d : (1.0d - (Math.exp(((-d) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d16);
        double[] dArr6 = {(((100.0d / d13) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d14) * dClampDouble) + 1.0d) - dClampDouble, (((100.0d / d15) * dClampDouble) + 1.0d) - dClampDouble};
        double d17 = 5.0d * d;
        double d18 = 1.0d / (d17 + 1.0d);
        double d19 = d18 * d18 * d18 * d18;
        double d20 = 1.0d - d19;
        double dCbrt = (Math.cbrt(d17) * 0.1d * d20 * d20) + (d19 * d);
        double dYFromLstar = ColorUtils.yFromLstar(dMax) / dArr[1];
        double dSqrt = Math.sqrt(dYFromLstar) + 1.48d;
        double dPow = 0.725d / Math.pow(dYFromLstar, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * dCbrt) * d13) / 100.0d, 0.42d), Math.pow(((dArr6[1] * dCbrt) * d14) / 100.0d, 0.42d), Math.pow(((dArr6[2] * dCbrt) * d15) / 100.0d, 0.42d)};
        double d21 = dArr7[0];
        double d22 = (d21 * 400.0d) / (d21 + 27.13d);
        double d23 = dArr7[1];
        double d24 = (d23 * 400.0d) / (d23 + 27.13d);
        double d25 = dArr7[2];
        double[] dArr8 = {d22, d24, (400.0d * d25) / (d25 + 27.13d)};
        return new ViewingConditions(dYFromLstar, androidx.collection.a.B(dArr8[2], 0.05d, (dArr8[0] * 2.0d) + dArr8[1], dPow), dPow, dPow, dLerp, d16, dArr6, dCbrt, Math.pow(dCbrt, 0.25d), dSqrt);
    }

    public double getAw() {
        return this.aw;
    }

    public double getC() {
        return this.c;
    }

    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.f3330n;
    }

    public double getNbb() {
        return this.nbb;
    }

    public double getNc() {
        return this.nc;
    }

    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    public double getZ() {
        return this.f3331z;
    }
}
