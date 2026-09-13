package org.apache.commons.math3.analysis.interpolation;

import androidx.collection.a;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AkimaSplineInterpolator implements UnivariateInterpolator {
    private static final int MINIMUM_NUMBER_POINTS = 5;

    private double differentiateThreePoint(double[] dArr, double[] dArr2, int i5, int i6, int i7, int i8) {
        double d = dArr2[i6];
        double d6 = dArr2[i7];
        double d7 = dArr2[i8];
        double d8 = dArr[i5];
        double d9 = dArr[i6];
        double d10 = d8 - d9;
        double d11 = dArr[i7] - d9;
        double d12 = dArr[i8] - d9;
        double d13 = d6 - d;
        double d14 = ((d7 - d) - ((d12 / d11) * d13)) / ((d12 * d12) - (d12 * d11));
        return a.C(d14, 2.0d, d10, (d13 - ((d14 * d11) * d11)) / d11);
    }

    private PolynomialSplineFunction interpolateHermiteSorted(double[] dArr, double[] dArr2, double[] dArr3) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length != dArr3.length) {
            throw new DimensionMismatchException(dArr.length, dArr3.length);
        }
        if (dArr.length < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(dArr.length), 2, true);
        }
        int length = dArr.length - 1;
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[length];
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            double d = dArr[i6] - dArr[i5];
            double d6 = dArr2[i5];
            double d7 = dArr2[i6];
            double d8 = dArr3[i5];
            double d9 = dArr3[i6];
            polynomialFunctionArr[i5] = new PolynomialFunction(new double[]{d6, d8, (((((d7 - d6) * 3.0d) / d) - (d8 * 2.0d)) - d9) / d, (((((d6 - d7) * 2.0d) / d) + d8) + d9) / (d * d)});
            i5 = i6;
        }
        return new PolynomialSplineFunction(dArr, polynomialFunctionArr);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] dArr, double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        boolean z6 = true;
        if (dArr.length < 5) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(dArr.length), 5, true);
        }
        MathArrays.checkOrder(dArr);
        int length = dArr.length - 1;
        double[] dArr3 = new double[length];
        double[] dArr4 = new double[length];
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            dArr3[i5] = (dArr2[i6] - dArr2[i5]) / (dArr[i6] - dArr[i5]);
            i5 = i6;
        }
        for (int i7 = 1; i7 < length; i7++) {
            dArr4[i7] = FastMath.abs(dArr3[i7] - dArr3[i7 - 1]);
        }
        int length2 = dArr.length;
        double[] dArr5 = new double[length2];
        int i8 = 2;
        while (i8 < length2 - 2) {
            int i9 = i8 + 1;
            double d = dArr4[i9];
            int i10 = i8 - 1;
            double d6 = dArr4[i10];
            boolean z7 = z6;
            if (Precision.equals(d, 0.0d) && Precision.equals(d6, 0.0d)) {
                double d7 = dArr[i8];
                double d8 = dArr[i9];
                double d9 = dArr[i10];
                dArr5[i8] = (((d7 - d9) * dArr3[i8]) + ((d8 - d7) * dArr3[i10])) / (d8 - d9);
            } else {
                dArr5[i8] = ((dArr3[i8] * d6) + (dArr3[i10] * d)) / (d + d6);
            }
            i8 = i9;
            z6 = z7;
        }
        dArr5[0] = differentiateThreePoint(dArr, dArr2, 0, 0, 1, 2);
        dArr5[z6 ? 1 : 0] = differentiateThreePoint(dArr, dArr2, 1, 0, 1, 2);
        dArr5[dArr.length - 2] = differentiateThreePoint(dArr, dArr2, dArr.length - 2, dArr.length - 3, dArr.length - 2, dArr.length - 1);
        dArr5[dArr.length - 1] = differentiateThreePoint(dArr, dArr2, dArr.length - 1, dArr.length - 3, dArr.length - 2, dArr.length - 1);
        return interpolateHermiteSorted(dArr, dArr2, dArr5);
    }
}
