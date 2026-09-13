package org.apache.commons.math3.analysis.polynomials;

import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PolynomialSplineFunction implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double[] knots;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f6751n;
    private final PolynomialFunction[] polynomials;

    public PolynomialSplineFunction(double[] dArr, PolynomialFunction[] polynomialFunctionArr) {
        if (dArr == null || polynomialFunctionArr == null) {
            throw new NullArgumentException();
        }
        if (dArr.length < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, 2, Integer.valueOf(dArr.length), false);
        }
        if (dArr.length - 1 != polynomialFunctionArr.length) {
            throw new DimensionMismatchException(polynomialFunctionArr.length, dArr.length);
        }
        MathArrays.checkOrder(dArr);
        int length = dArr.length;
        int i5 = length - 1;
        this.f6751n = i5;
        double[] dArr2 = new double[length];
        this.knots = dArr2;
        System.arraycopy(dArr, 0, dArr2, 0, length);
        PolynomialFunction[] polynomialFunctionArr2 = new PolynomialFunction[i5];
        this.polynomials = polynomialFunctionArr2;
        System.arraycopy(polynomialFunctionArr, 0, polynomialFunctionArr2, 0, i5);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    public UnivariateFunction derivative() {
        return polynomialSplineDerivative();
    }

    public double[] getKnots() {
        int i5 = this.f6751n;
        double[] dArr = new double[i5 + 1];
        System.arraycopy(this.knots, 0, dArr, 0, i5 + 1);
        return dArr;
    }

    public int getN() {
        return this.f6751n;
    }

    public PolynomialFunction[] getPolynomials() {
        int i5 = this.f6751n;
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[i5];
        System.arraycopy(this.polynomials, 0, polynomialFunctionArr, 0, i5);
        return polynomialFunctionArr;
    }

    public boolean isValidPoint(double d) {
        double[] dArr = this.knots;
        return d >= dArr[0] && d <= dArr[this.f6751n];
    }

    public PolynomialSplineFunction polynomialSplineDerivative() {
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[this.f6751n];
        for (int i5 = 0; i5 < this.f6751n; i5++) {
            polynomialFunctionArr[i5] = this.polynomials[i5].polynomialDerivative();
        }
        return new PolynomialSplineFunction(this.knots, polynomialFunctionArr);
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        double[] dArr = this.knots;
        if (d < dArr[0] || d > dArr[this.f6751n]) {
            throw new OutOfRangeException(Double.valueOf(d), Double.valueOf(this.knots[0]), Double.valueOf(this.knots[this.f6751n]));
        }
        int iBinarySearch = Arrays.binarySearch(dArr, d);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 2;
        }
        PolynomialFunction[] polynomialFunctionArr = this.polynomials;
        if (iBinarySearch >= polynomialFunctionArr.length) {
            iBinarySearch--;
        }
        return polynomialFunctionArr[iBinarySearch].value(d - this.knots[iBinarySearch]);
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        double value = derivativeStructure.getValue();
        double[] dArr = this.knots;
        if (value >= dArr[0] && value <= dArr[this.f6751n]) {
            int iBinarySearch = Arrays.binarySearch(dArr, value);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            PolynomialFunction[] polynomialFunctionArr = this.polynomials;
            if (iBinarySearch >= polynomialFunctionArr.length) {
                iBinarySearch--;
            }
            return polynomialFunctionArr[iBinarySearch].value(derivativeStructure.subtract(this.knots[iBinarySearch]));
        }
        throw new OutOfRangeException(Double.valueOf(value), Double.valueOf(this.knots[0]), Double.valueOf(this.knots[this.f6751n]));
    }
}
