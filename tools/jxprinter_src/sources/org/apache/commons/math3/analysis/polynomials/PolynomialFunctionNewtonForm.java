package org.apache.commons.math3.analysis.polynomials;

import androidx.collection.a;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialFunctionNewtonForm implements UnivariateDifferentiableFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f6750a;
    private final double[] c;
    private double[] coefficients;
    private boolean coefficientsComputed;

    public PolynomialFunctionNewtonForm(double[] dArr, double[] dArr2) {
        verifyInputArray(dArr, dArr2);
        double[] dArr3 = new double[dArr.length];
        this.f6750a = dArr3;
        double[] dArr4 = new double[dArr2.length];
        this.c = dArr4;
        System.arraycopy(dArr, 0, dArr3, 0, dArr.length);
        System.arraycopy(dArr2, 0, dArr4, 0, dArr2.length);
        this.coefficientsComputed = false;
    }

    public static double evaluate(double[] dArr, double[] dArr2, double d) {
        verifyInputArray(dArr, dArr2);
        int length = dArr2.length;
        double d6 = dArr[length];
        double dA = d6;
        for (int i5 = length - 1; i5 >= 0; i5--) {
            dA = a.a(d, dArr2[i5], dA, dArr[i5]);
        }
        return dA;
    }

    public static void verifyInputArray(double[] dArr, double[] dArr2) {
        MathUtils.checkNotNull(dArr);
        MathUtils.checkNotNull(dArr2);
        if (dArr.length == 0 || dArr2.length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        if (dArr.length != dArr2.length + 1) {
            throw new DimensionMismatchException(LocalizedFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, dArr.length, dArr2.length);
        }
    }

    public void computeCoefficients() {
        int iDegree = degree();
        this.coefficients = new double[iDegree + 1];
        for (int i5 = 0; i5 <= iDegree; i5++) {
            this.coefficients[i5] = 0.0d;
        }
        this.coefficients[0] = this.f6750a[iDegree];
        for (int i6 = iDegree - 1; i6 >= 0; i6--) {
            for (int i7 = iDegree - i6; i7 > 0; i7--) {
                double[] dArr = this.coefficients;
                dArr[i7] = dArr[i7 - 1] - (this.c[i6] * dArr[i7]);
            }
            double[] dArr2 = this.coefficients;
            dArr2[0] = this.f6750a[i6] - (this.c[i6] * dArr2[0]);
        }
        this.coefficientsComputed = true;
    }

    public int degree() {
        return this.c.length;
    }

    public double[] getCenters() {
        double[] dArr = this.c;
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
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

    public double[] getNewtonCoefficients() {
        double[] dArr = this.f6750a;
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return evaluate(this.f6750a, this.c, d);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        verifyInputArray(this.f6750a, this.c);
        int length = this.c.length;
        DerivativeStructure derivativeStructure2 = new DerivativeStructure(derivativeStructure.getFreeParameters(), derivativeStructure.getOrder(), this.f6750a[length]);
        for (int i5 = length - 1; i5 >= 0; i5--) {
            derivativeStructure2 = derivativeStructure.subtract(this.c[i5]).multiply(derivativeStructure2).add(this.f6750a[i5]);
        }
        return derivativeStructure2;
    }
}
