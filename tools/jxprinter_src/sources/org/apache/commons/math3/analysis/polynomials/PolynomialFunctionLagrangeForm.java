package org.apache.commons.math3.analysis.polynomials;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialFunctionLagrangeForm implements UnivariateFunction {
    private double[] coefficients;
    private boolean coefficientsComputed;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final double[] f6748x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final double[] f6749y;

    public PolynomialFunctionLagrangeForm(double[] dArr, double[] dArr2) {
        double[] dArr3 = new double[dArr.length];
        this.f6748x = dArr3;
        double[] dArr4 = new double[dArr2.length];
        this.f6749y = dArr4;
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr4, 0, dArr2.length);
        this.coefficientsComputed = false;
        if (verifyInterpolationArray(dArr, dArr2, false)) {
            return;
        }
        MathArrays.sortInPlace(dArr3, dArr4);
        verifyInterpolationArray(dArr3, dArr4, true);
    }

    public static double evaluate(double[] dArr, double[] dArr2, double d) {
        if (verifyInterpolationArray(dArr, dArr2, false)) {
            return evaluateInternal(dArr, dArr2, d);
        }
        double[] dArr3 = new double[dArr.length];
        double[] dArr4 = new double[dArr2.length];
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr4, 0, dArr2.length);
        MathArrays.sortInPlace(dArr3, dArr4);
        verifyInterpolationArray(dArr3, dArr4, true);
        return evaluateInternal(dArr3, dArr4, d);
    }

    private static double evaluateInternal(double[] dArr, double[] dArr2, double d) {
        int i5;
        double d6;
        int length = dArr.length;
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        double d7 = Double.POSITIVE_INFINITY;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            dArr3[i7] = dArr2[i7];
            dArr4[i7] = dArr2[i7];
            double dAbs = FastMath.abs(d - dArr[i7]);
            if (dAbs < d7) {
                i6 = i7;
                d7 = dAbs;
            }
        }
        double d8 = dArr2[i6];
        for (int i8 = 1; i8 < length; i8++) {
            int i9 = 0;
            while (true) {
                i5 = length - i8;
                if (i9 >= i5) {
                    break;
                }
                double d9 = dArr[i9];
                double d10 = d9 - d;
                double d11 = dArr[i8 + i9];
                double d12 = d11 - d;
                double d13 = d9 - d11;
                int i10 = i9 + 1;
                double d14 = (dArr3[i10] - dArr4[i9]) / d13;
                dArr3[i9] = d10 * d14;
                dArr4[i9] = d12 * d14;
                i9 = i10;
            }
            if (i6 < ((double) (i5 + 1)) * 0.5d) {
                d6 = dArr3[i6];
            } else {
                i6--;
                d6 = dArr4[i6];
            }
            d8 += d6;
        }
        return d8;
    }

    public static boolean verifyInterpolationArray(double[] dArr, double[] dArr2, boolean z6) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length >= 2) {
            return MathArrays.checkOrder(dArr, MathArrays.OrderDirection.INCREASING, true, z6);
        }
        throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 2, Integer.valueOf(dArr.length), true);
    }

    public void computeCoefficients() {
        int iDegree = degree();
        int i5 = iDegree + 1;
        this.coefficients = new double[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            this.coefficients[i7] = 0.0d;
        }
        double[] dArr = new double[iDegree + 2];
        dArr[0] = 1.0d;
        int i8 = 0;
        while (i8 < i5) {
            for (int i9 = i8; i9 > 0; i9--) {
                dArr[i9] = dArr[i9 - 1] - (dArr[i9] * this.f6748x[i8]);
            }
            dArr[0] = dArr[0] * (-this.f6748x[i8]);
            i8++;
            dArr[i8] = 1.0d;
        }
        double[] dArr2 = new double[i5];
        int i10 = 0;
        while (i10 < i5) {
            double d = 1.0d;
            for (int i11 = i6; i11 < i5; i11++) {
                if (i10 != i11) {
                    double[] dArr3 = this.f6748x;
                    d *= dArr3[i10] - dArr3[i11];
                }
            }
            double d6 = this.f6749y[i10] / d;
            double d7 = dArr[i5];
            dArr2[iDegree] = d7;
            double[] dArr4 = this.coefficients;
            dArr4[iDegree] = (d7 * d6) + dArr4[iDegree];
            for (int i12 = iDegree - 1; i12 >= 0; i12--) {
                int i13 = i12 + 1;
                double d8 = (dArr2[i13] * this.f6748x[i10]) + dArr[i13];
                dArr2[i12] = d8;
                double[] dArr5 = this.coefficients;
                dArr5[i12] = (d8 * d6) + dArr5[i12];
            }
            i10++;
            i6 = 0;
        }
        this.coefficientsComputed = true;
    }

    public int degree() {
        return this.f6748x.length - 1;
    }

    public double[] getCoefficients() {
        if (!this.coefficientsComputed) {
            computeCoefficients();
        }
        double[] dArr = this.coefficients;
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    public double[] getInterpolatingPoints() {
        double[] dArr = this.f6748x;
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    public double[] getInterpolatingValues() {
        double[] dArr = this.f6749y;
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return evaluateInternal(this.f6748x, this.f6749y, d);
    }
}
