package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Cam16 {
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final double f3317j;
    private final double jstar;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final double f3318m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final double f3319q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final double f3320s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    private Cam16(double d, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        this.hue = d;
        this.chroma = d6;
        this.f3317j = d7;
        this.f3319q = d8;
        this.f3318m = d9;
        this.f3320s = d10;
        this.jstar = d11;
        this.astar = d12;
        this.bstar = d13;
    }

    public static Cam16 fromInt(int i5) {
        return fromIntInViewingConditions(i5, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i5, ViewingConditions viewingConditions) {
        double dLinearized = ColorUtils.linearized((16711680 & i5) >> 16);
        double dLinearized2 = ColorUtils.linearized((65280 & i5) >> 8);
        double dLinearized3 = ColorUtils.linearized(i5 & 255);
        return fromXyzInViewingConditions((0.18051042d * dLinearized3) + (0.35762064d * dLinearized2) + (0.41233895d * dLinearized), (0.0722d * dLinearized3) + (0.7152d * dLinearized2) + (0.2126d * dLinearized), (dLinearized3 * 0.95034478d) + (dLinearized2 * 0.11916382d) + (dLinearized * 0.01932141d), viewingConditions);
    }

    public static Cam16 fromJch(double d, double d6, double d7) {
        return fromJchInViewingConditions(d, d6, d7, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d, double d6, double d7, ViewingConditions viewingConditions) {
        double d8 = d / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d8) * (4.0d / viewingConditions.getC());
        double flRoot2 = viewingConditions.getFlRoot() * d6;
        double dSqrt = Math.sqrt((viewingConditions.getC() * (d6 / Math.sqrt(d8))) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double radians = Math.toRadians(d7);
        double d9 = (1.7000000000000002d * d) / ((0.007d * d) + 1.0d);
        double dLog1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d7, d6, d, flRoot, flRoot2, dSqrt, d9, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public static Cam16 fromUcs(double d, double d6, double d7) {
        return fromUcsInViewingConditions(d, d6, d7, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d, double d6, double d7, ViewingConditions viewingConditions) {
        double dExpm1 = (Math.expm1(Math.hypot(d6, d7) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double dAtan2 = Math.atan2(d7, d6) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        return fromJchInViewingConditions(d / (1.0d - ((d - 100.0d) * 0.007d)), dExpm1, dAtan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d, double d6, double d7, ViewingConditions viewingConditions) {
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d8 = (dArr2[2] * d7) + (dArr2[1] * d6) + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d9 = (dArr3[2] * d7) + (dArr3[1] * d6) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        double d10 = (dArr4[2] * d7) + (dArr4[1] * d6) + (dArr4[0] * d);
        double d11 = viewingConditions.getRgbD()[0] * d8;
        double d12 = viewingConditions.getRgbD()[1] * d9;
        double d13 = viewingConditions.getRgbD()[2] * d10;
        double dPow = Math.pow((Math.abs(d11) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow2 = Math.pow((Math.abs(d12) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dPow3 = Math.pow((Math.abs(d13) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double dSignum = ((Math.signum(d11) * 400.0d) * dPow) / (dPow + 27.13d);
        double dSignum2 = ((Math.signum(d12) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        double dSignum3 = ((Math.signum(d13) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d14 = ((((-12.0d) * dSignum2) + (dSignum * 11.0d)) + dSignum3) / 11.0d;
        double dA = com.google.android.gms.auth.api.accounttransfer.a.a(dSignum3, 2.0d, dSignum + dSignum2, 9.0d);
        double d15 = dSignum2 * 20.0d;
        double D6 = androidx.collection.a.D(dSignum3, 21.0d, (dSignum * 20.0d) + d15, 20.0d);
        double d16 = (((dSignum * 40.0d) + d15) + dSignum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(dA, d14));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d17 = degrees;
        double radians = Math.toRadians(d17);
        double dPow4 = Math.pow((viewingConditions.getNbb() * d16) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d18 = dPow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d18) * (4.0d / viewingConditions.getC());
        double dPow5 = Math.pow((Math.hypot(d14, dA) * (viewingConditions.getNcb() * (viewingConditions.getNc() * (((Math.cos(Math.toRadians(d17 < 20.14d ? d17 + 360.0d : d17) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d)))) / (D6 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double dSqrt = Math.sqrt(d18) * dPow5;
        double flRoot2 = viewingConditions.getFlRoot() * dSqrt;
        double dSqrt2 = Math.sqrt((viewingConditions.getC() * dPow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d19 = (1.7000000000000002d * dPow4) / ((0.007d * dPow4) + 1.0d);
        double dLog1p = Math.log1p(0.0228d * flRoot2) * 43.859649122807014d;
        return new Cam16(d17, dSqrt, dPow4, flRoot, flRoot2, dSqrt2, d19, Math.cos(radians) * dLog1p, Math.sin(radians) * dLog1p);
    }

    public double distance(Cam16 cam16) {
        double jstar = getJstar() - cam16.getJstar();
        double astar = getAstar() - cam16.getAstar();
        double bstar = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((bstar * bstar) + (astar * astar) + (jstar * jstar)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.f3317j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.f3318m;
    }

    public double getQ() {
        return this.f3319q;
    }

    public double getS() {
        return this.f3320s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] dArrXyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(dArrXyzInViewingConditions[0], dArrXyzInViewingConditions[1], dArrXyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double dPow = Math.pow(((getChroma() == 0.0d || getJ() == 0.0d) ? 0.0d : getChroma() / Math.sqrt(getJ() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double dCos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double dPow2 = Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw();
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * dCos * 3846.153846153846d;
        double nbb = dPow2 / viewingConditions.getNbb();
        double dSin = Math.sin(radians);
        double dCos2 = Math.cos(radians);
        double dC = (((nbb + 0.305d) * 23.0d) * dPow) / (((dPow * 108.0d) * dSin) + androidx.collection.a.C(dPow, 11.0d, dCos2, ncb * 23.0d));
        double d = dCos2 * dC;
        double d6 = dC * dSin;
        double d7 = nbb * 460.0d;
        double D6 = androidx.collection.a.D(d6, 288.0d, (451.0d * d) + d7, 1403.0d);
        double dA = com.google.android.gms.auth.api.accounttransfer.a.a(d6, 261.0d, d7 - (891.0d * d), 1403.0d);
        double dA2 = com.google.android.gms.auth.api.accounttransfer.a.a(d6, 6300.0d, d7 - (d * 220.0d), 1403.0d);
        double dPow3 = Math.pow(Math.max(0.0d, (Math.abs(D6) * 27.13d) / (400.0d - Math.abs(D6))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(D6);
        double dPow4 = Math.pow(Math.max(0.0d, (Math.abs(dA) * 27.13d) / (400.0d - Math.abs(dA))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(dA);
        double dPow5 = Math.pow(Math.max(0.0d, (Math.abs(dA2) * 27.13d) / (400.0d - Math.abs(dA2))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(dA2);
        double d8 = dPow3 / viewingConditions.getRgbD()[0];
        double d9 = dPow4 / viewingConditions.getRgbD()[1];
        double d10 = dPow5 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d11 = (dArr3[2] * d10) + (dArr3[1] * d9) + (dArr3[0] * d8);
        double[] dArr4 = dArr2[1];
        double d12 = (dArr4[2] * d10) + (dArr4[1] * d9) + (dArr4[0] * d8);
        double[] dArr5 = dArr2[2];
        double d13 = (d10 * dArr5[2]) + (d9 * dArr5[1]) + (d8 * dArr5[0]);
        if (dArr == null) {
            return new double[]{d11, d12, d13};
        }
        dArr[0] = d11;
        dArr[1] = d12;
        dArr[2] = d13;
        return dArr;
    }
}
