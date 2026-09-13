package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BicubicSplineFunction implements BivariateFunction {

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final short f6742N = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[][] f6743a;
    private final BivariateFunction partialDerivativeX;
    private final BivariateFunction partialDerivativeXX;
    private final BivariateFunction partialDerivativeXY;
    private final BivariateFunction partialDerivativeY;
    private final BivariateFunction partialDerivativeYY;

    public BicubicSplineFunction(double[] dArr) {
        this(dArr, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double apply(double[] dArr, double[] dArr2, double[][] dArr3) {
        double d = 0.0d;
        for (int i5 = 0; i5 < 4; i5++) {
            for (int i6 = 0; i6 < 4; i6++) {
                d += dArr3[i5][i6] * dArr[i5] * dArr2[i6];
            }
        }
        return d;
    }

    public BivariateFunction partialDerivativeX() {
        return this.partialDerivativeX;
    }

    public BivariateFunction partialDerivativeXX() {
        return this.partialDerivativeXX;
    }

    public BivariateFunction partialDerivativeXY() {
        return this.partialDerivativeXY;
    }

    public BivariateFunction partialDerivativeY() {
        return this.partialDerivativeY;
    }

    public BivariateFunction partialDerivativeYY() {
        return this.partialDerivativeYY;
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double d, double d6) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d6 < 0.0d || d6 > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d6), 0, 1);
        }
        double d7 = d * d;
        double[] dArr = {1.0d, d, d7, d7 * d};
        double d8 = d6 * d6;
        return apply(dArr, new double[]{1.0d, d6, d8, d8 * d6}, this.f6743a);
    }

    public BicubicSplineFunction(double[] dArr, boolean z6) {
        int i5 = 4;
        int i6 = 0;
        Class cls = Double.TYPE;
        this.f6743a = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        for (int i7 = 0; i7 < 4; i7++) {
            for (int i8 = 0; i8 < 4; i8++) {
                this.f6743a[i7][i8] = dArr[(i7 * 4) + i8];
            }
        }
        if (!z6) {
            this.partialDerivativeX = null;
            this.partialDerivativeY = null;
            this.partialDerivativeXX = null;
            this.partialDerivativeYY = null;
            this.partialDerivativeXY = null;
            return;
        }
        final double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        final double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        final double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        final double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        final double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, 4, 4);
        int i9 = 0;
        while (i9 < i5) {
            int i10 = i6;
            while (i10 < i5) {
                double d = this.f6743a[i9][i10];
                double[] dArr7 = dArr2[i9];
                dArr7[i10] = ((double) i9) * d;
                double[] dArr8 = dArr3[i9];
                double d6 = i10;
                dArr8[i10] = d * d6;
                dArr4[i9][i10] = ((double) (i9 - 1)) * dArr7[i10];
                dArr5[i9][i10] = ((double) (i10 - 1)) * dArr8[i10];
                dArr6[i9][i10] = d6 * dArr7[i10];
                i10++;
                i5 = 4;
            }
            i9++;
            i5 = 4;
            i6 = 0;
        }
        this.partialDerivativeX = new BivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.1
            @Override // org.apache.commons.math3.analysis.BivariateFunction
            public double value(double d7, double d8) {
                double d9 = d8 * d8;
                return BicubicSplineFunction.this.apply(new double[]{0.0d, 1.0d, d7, d7 * d7}, new double[]{1.0d, d8, d9, d9 * d8}, dArr2);
            }
        };
        this.partialDerivativeY = new BivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.2
            @Override // org.apache.commons.math3.analysis.BivariateFunction
            public double value(double d7, double d8) {
                double d9 = d7 * d7;
                return BicubicSplineFunction.this.apply(new double[]{1.0d, d7, d9, d9 * d7}, new double[]{0.0d, 1.0d, d8, d8 * d8}, dArr3);
            }
        };
        this.partialDerivativeXX = new BivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.3
            @Override // org.apache.commons.math3.analysis.BivariateFunction
            public double value(double d7, double d8) {
                double[] dArr9 = {0.0d, 0.0d, 1.0d, d7};
                double d9 = d8 * d8;
                return BicubicSplineFunction.this.apply(dArr9, new double[]{1.0d, d8, d9, d9 * d8}, dArr4);
            }
        };
        this.partialDerivativeYY = new BivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.4
            @Override // org.apache.commons.math3.analysis.BivariateFunction
            public double value(double d7, double d8) {
                double d9 = d7 * d7;
                return BicubicSplineFunction.this.apply(new double[]{1.0d, d7, d9, d9 * d7}, new double[]{0.0d, 0.0d, 1.0d, d8}, dArr5);
            }
        };
        this.partialDerivativeXY = new BivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.5
            @Override // org.apache.commons.math3.analysis.BivariateFunction
            public double value(double d7, double d8) {
                return BicubicSplineFunction.this.apply(new double[]{0.0d, 1.0d, d7, d7 * d7}, new double[]{0.0d, 1.0d, d8, d8 * d8}, dArr6);
            }
        };
    }
}
