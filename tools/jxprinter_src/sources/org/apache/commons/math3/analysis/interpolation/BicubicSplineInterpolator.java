package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BicubicSplineInterpolator implements BivariateGridInterpolator {
    private final boolean initializeDerivatives;

    public BicubicSplineInterpolator() {
        this(false);
    }

    private int nextIndex(int i5, int i6) {
        int i7 = i5 + 1;
        return i7 < i6 ? i7 : i5;
    }

    private int previousIndex(int i5) {
        int i6 = i5 - 1;
        if (i6 >= 0) {
            return i6;
        }
        return 0;
    }

    public BicubicSplineInterpolator(boolean z6) {
        this.initializeDerivatives = z6;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicSplineInterpolatingFunction interpolate(double[] dArr, double[] dArr2, double[][] dArr3) {
        if (dArr.length == 0 || dArr2.length == 0 || dArr3.length == 0) {
            throw new NoDataException();
        }
        if (dArr.length != dArr3.length) {
            throw new DimensionMismatchException(dArr.length, dArr3.length);
        }
        MathArrays.checkOrder(dArr);
        MathArrays.checkOrder(dArr2);
        int length = dArr.length;
        int length2 = dArr2.length;
        int i5 = 2;
        boolean z6 = true;
        int i6 = 0;
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length2, length);
        for (int i7 = 0; i7 < length; i7++) {
            if (dArr3[i7].length != length2) {
                throw new DimensionMismatchException(dArr3[i7].length, length2);
            }
            for (int i8 = 0; i8 < length2; i8++) {
                dArr4[i8][i7] = dArr3[i7][i8];
            }
        }
        SplineInterpolator splineInterpolator = new SplineInterpolator();
        PolynomialSplineFunction[] polynomialSplineFunctionArr = new PolynomialSplineFunction[length2];
        for (int i9 = 0; i9 < length2; i9++) {
            polynomialSplineFunctionArr[i9] = splineInterpolator.interpolate(dArr, dArr4[i9]);
        }
        PolynomialSplineFunction[] polynomialSplineFunctionArr2 = new PolynomialSplineFunction[length];
        for (int i10 = 0; i10 < length; i10++) {
            polynomialSplineFunctionArr2[i10] = splineInterpolator.interpolate(dArr2, dArr3[i10]);
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i11 = 0; i11 < length2; i11++) {
            UnivariateFunction univariateFunctionDerivative = polynomialSplineFunctionArr[i11].derivative();
            int i12 = i6;
            while (i12 < length) {
                dArr5[i12][i11] = univariateFunctionDerivative.value(dArr[i12]);
                i12++;
                z6 = z6;
                i6 = i6;
            }
        }
        boolean z7 = z6;
        int i13 = i6;
        int[] iArr = new int[2];
        iArr[z7 ? 1 : 0] = length2;
        iArr[i13] = length;
        double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr);
        while (i6 < length) {
            UnivariateFunction univariateFunctionDerivative2 = polynomialSplineFunctionArr2[i6].derivative();
            int i14 = i13;
            while (i14 < length2) {
                dArr6[i6][i14] = univariateFunctionDerivative2.value(dArr2[i14]);
                i14++;
                polynomialSplineFunctionArr2 = polynomialSplineFunctionArr2;
            }
            i6++;
            i5 = 2;
        }
        int[] iArr2 = new int[i5];
        iArr2[z7 ? 1 : 0] = length2;
        iArr2[i13] = length;
        double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        for (int i15 = i13; i15 < length; i15++) {
            int iNextIndex = nextIndex(i15, length);
            int iPreviousIndex = previousIndex(i15);
            for (int i16 = i13; i16 < length2; i16++) {
                int iNextIndex2 = nextIndex(i16, length2);
                int iPreviousIndex2 = previousIndex(i16);
                double[] dArr8 = dArr7[i15];
                double[] dArr9 = dArr3[iNextIndex];
                double d = dArr9[iNextIndex2] - dArr9[iPreviousIndex2];
                double[] dArr10 = dArr3[iPreviousIndex];
                dArr8[i16] = ((d - dArr10[iNextIndex2]) + dArr10[iPreviousIndex2]) / ((dArr2[iNextIndex2] - dArr2[iPreviousIndex2]) * (dArr[iNextIndex] - dArr[iPreviousIndex]));
            }
        }
        return new BicubicSplineInterpolatingFunction(dArr, dArr2, dArr3, dArr5, dArr6, dArr7, this.initializeDerivatives);
    }
}
