package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LinearInterpolator implements UnivariateInterpolator {
    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] dArr, double[] dArr2) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr.length < 2) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(dArr.length), 2, true);
        }
        int length = dArr.length - 1;
        MathArrays.checkOrder(dArr);
        double[] dArr3 = new double[length];
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            dArr3[i5] = (dArr2[i6] - dArr2[i5]) / (dArr[i6] - dArr[i5]);
            i5 = i6;
        }
        PolynomialFunction[] polynomialFunctionArr = new PolynomialFunction[length];
        for (int i7 = 0; i7 < length; i7++) {
            polynomialFunctionArr[i7] = new PolynomialFunction(new double[]{dArr2[i7], dArr3[i7]});
        }
        return new PolynomialSplineFunction(dArr, polynomialFunctionArr);
    }
}
