package org.apache.commons.math3.analysis.interpolation;

import com.google.android.gms.auth.api.accounttransfer.a;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SplineInterpolator implements UnivariateInterpolator {
    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] dArr, double[] dArr2) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length < 3) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(dArr.length), 3, true);
        }
        int length = dArr.length;
        int i5 = length - 1;
        MathArrays.checkOrder(dArr);
        double[] dArr3 = new double[i5];
        int i6 = 0;
        while (i6 < i5) {
            int i7 = i6 + 1;
            dArr3[i6] = dArr[i7] - dArr[i6];
            i6 = i7;
        }
        double[] dArr4 = new double[i5];
        double[] dArr5 = new double[length];
        dArr4[0] = 0.0d;
        dArr5[0] = 0.0d;
        int i8 = 1;
        while (i8 < i5) {
            int i9 = i8 + 1;
            int i10 = i8 - 1;
            double d = ((dArr[i9] - dArr[i10]) * 2.0d) - (dArr3[i10] * dArr4[i10]);
            dArr4[i8] = dArr3[i8] / d;
            double d6 = dArr2[i9];
            double d7 = dArr3[i10];
            double d8 = (d6 * d7) - ((dArr[i9] - dArr[i10]) * dArr2[i8]);
            double d9 = dArr2[i10];
            double d10 = dArr3[i8];
            dArr5[i8] = a.a(d7, dArr5[i10], androidx.collection.a.B(d9, d10, d8, 3.0d) / (d10 * d7), d);
            i8 = i9;
        }
        double[] dArr6 = new double[i5];
        double[] dArr7 = new double[length];
        double[] dArr8 = new double[i5];
        dArr5[i5] = 0.0d;
        dArr7[i5] = 0.0d;
        for (int i11 = length - 2; i11 >= 0; i11--) {
            int i12 = i11 + 1;
            double d11 = dArr5[i11] - (dArr4[i11] * dArr7[i12]);
            dArr7[i11] = d11;
            double d12 = dArr2[i12] - dArr2[i11];
            double d13 = dArr3[i11];
            dArr6[i11] = (d12 / d13) - ((((d11 * 2.0d) + dArr7[i12]) * d13) / 3.0d);
            dArr8[i11] = (dArr7[i12] - dArr7[i11]) / (dArr3[i11] * 3.0d);
        }
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[i5];
        for (int i13 = 0; i13 < i5; i13++) {
            polynomialFunctionArr[i13] = new PolynomialFunction(new double[]{dArr2[i13], dArr6[i13], dArr7[i13], dArr8[i13]});
        }
        return new PolynomialSplineFunction(dArr, polynomialFunctionArr);
    }
}
