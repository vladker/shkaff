package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.fitting.PolynomialFitter;
import org.apache.commons.math3.optim.SimpleVectorValueChecker;
import org.apache.commons.math3.optim.nonlinear.vector.jacobian.GaussNewtonOptimizer;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class SmoothingPolynomialBicubicSplineInterpolator extends BicubicSplineInterpolator {
    private final int xDegree;
    private final PolynomialFitter xFitter;
    private final int yDegree;
    private final PolynomialFitter yFitter;

    public SmoothingPolynomialBicubicSplineInterpolator() {
        this(3);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int i5) {
        this(i5, i5);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolator, org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] dArr, double[] dArr2, double[][] dArr3) {
        if (dArr.length == 0 || dArr2.length == 0 || dArr3.length == 0) {
            throw new NoDataException();
        }
        if (dArr.length != dArr3.length) {
            throw new DimensionMismatchException(dArr.length, dArr3.length);
        }
        int length = dArr.length;
        int length2 = dArr2.length;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (dArr3[i6].length != length2) {
                throw new DimensionMismatchException(dArr3[i6].length, length2);
            }
        }
        MathArrays.checkOrder(dArr);
        MathArrays.checkOrder(dArr2);
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[length2];
        for (int i7 = 0; i7 < length2; i7++) {
            this.xFitter.clearObservations();
            for (int i8 = 0; i8 < length; i8++) {
                this.xFitter.addObservedPoint(1.0d, dArr[i8], dArr3[i8][i7]);
            }
            polynomialFunctionArr[i7] = new PolynomialFunction(this.xFitter.fit(new double[this.xDegree + 1]));
        }
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i9 = 0; i9 < length2; i9++) {
            PolynomialFunction polynomialFunction = polynomialFunctionArr[i9];
            int i10 = i5;
            while (i10 < length) {
                dArr4[i10][i9] = polynomialFunction.value(dArr[i10]);
                i10++;
                i5 = i5;
                polynomialFunctionArr = polynomialFunctionArr;
            }
        }
        int i11 = i5;
        PolynomialFunction[] polynomialFunctionArr2 = new PolynomialFunction[length];
        for (int i12 = i11; i12 < length; i12++) {
            this.yFitter.clearObservations();
            for (int i13 = i11; i13 < length2; i13++) {
                this.yFitter.addObservedPoint(1.0d, dArr2[i13], dArr4[i12][i13]);
            }
            polynomialFunctionArr2[i12] = new PolynomialFunction(this.yFitter.fit(new double[this.yDegree + 1]));
        }
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[i11] = length;
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        for (int i14 = i11; i14 < length; i14++) {
            PolynomialFunction polynomialFunction2 = polynomialFunctionArr2[i14];
            for (int i15 = i11; i15 < length2; i15++) {
                dArr5[i14][i15] = polynomialFunction2.value(dArr2[i15]);
            }
        }
        return super.interpolate(dArr, dArr2, dArr5);
    }

    public SmoothingPolynomialBicubicSplineInterpolator(int i5, int i6) {
        if (i5 < 0) {
            throw new NotPositiveException(Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            this.xDegree = i5;
            this.yDegree = i6;
            SimpleVectorValueChecker simpleVectorValueChecker = new SimpleVectorValueChecker(Precision.EPSILON * 100.0d, Precision.SAFE_MIN * 100.0d);
            this.xFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, simpleVectorValueChecker));
            this.yFitter = new PolynomialFitter(new GaussNewtonOptimizer(false, simpleVectorValueChecker));
            return;
        }
        throw new NotPositiveException(Integer.valueOf(i6));
    }
}
