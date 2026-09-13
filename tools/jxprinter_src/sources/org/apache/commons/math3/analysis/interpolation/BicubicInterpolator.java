package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BicubicInterpolator implements BivariateGridInterpolator {
    @Override // org.apache.commons.math3.analysis.interpolation.BivariateGridInterpolator
    public BicubicInterpolatingFunction interpolate(final double[] dArr, final double[] dArr2, double[][] dArr3) {
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
        Class cls = Double.TYPE;
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        int i5 = 1;
        while (i5 < length - 1) {
            int i6 = i5 + 1;
            int i7 = i5 - 1;
            double d = dArr[i6] - dArr[i7];
            int i8 = 1;
            while (i8 < length2 - 1) {
                int i9 = i8 + 1;
                int i10 = i8 - 1;
                double d6 = dArr2[i9] - dArr2[i10];
                double[] dArr7 = dArr4[i5];
                double[] dArr8 = dArr3[i6];
                double d7 = dArr8[i8];
                double[] dArr9 = dArr3[i7];
                dArr7[i8] = (d7 - dArr9[i8]) / d;
                double[] dArr10 = dArr5[i5];
                double[] dArr11 = dArr3[i5];
                dArr10[i8] = (dArr11[i9] - dArr11[i10]) / d6;
                dArr6[i5][i8] = (((dArr8[i9] - dArr8[i10]) - dArr9[i9]) + dArr9[i10]) / (d6 * d);
                i8 = i9;
            }
            i5 = i6;
        }
        return new BicubicInterpolatingFunction(dArr, dArr2, dArr3, dArr4, dArr5, dArr6) { // from class: org.apache.commons.math3.analysis.interpolation.BicubicInterpolator.1
            @Override // org.apache.commons.math3.analysis.interpolation.BicubicInterpolatingFunction
            public boolean isValidPoint(double d8, double d9) {
                double[] dArr12 = dArr;
                if (d8 < dArr12[1] || d8 > dArr12[dArr12.length - 2]) {
                    return false;
                }
                double[] dArr13 = dArr2;
                return d9 >= dArr13[1] && d9 <= dArr13[dArr13.length + (-2)];
            }
        };
    }
}
