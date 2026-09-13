package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TricubicInterpolator implements TrivariateGridInterpolator {
    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public TricubicInterpolatingFunction interpolate(final double[] dArr, final double[] dArr2, final double[] dArr3, double[][][] dArr4) {
        if (dArr.length == 0 || dArr2.length == 0 || dArr3.length == 0 || dArr4.length == 0) {
            throw new NoDataException();
        }
        if (dArr.length != dArr4.length) {
            throw new DimensionMismatchException(dArr.length, dArr4.length);
        }
        MathArrays.checkOrder(dArr);
        MathArrays.checkOrder(dArr2);
        MathArrays.checkOrder(dArr3);
        int length = dArr.length;
        int length2 = dArr2.length;
        int length3 = dArr3.length;
        Class cls = Double.TYPE;
        double[][][] dArr5 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr6 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr7 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr8 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr9 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr10 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        double[][][] dArr11 = (double[][][]) Array.newInstance((Class<?>) cls, length, length2, length3);
        int i5 = 1;
        while (i5 < length - 1) {
            int i6 = length;
            if (dArr2.length != dArr4[i5].length) {
                throw new DimensionMismatchException(dArr2.length, dArr4[i5].length);
            }
            int i7 = i5 + 1;
            int i8 = i5 - 1;
            double d = dArr[i7] - dArr[i8];
            int i9 = length2;
            int i10 = 1;
            while (i10 < i9 - 1) {
                int i11 = i10;
                if (dArr3.length != dArr4[i5][i11].length) {
                    throw new DimensionMismatchException(dArr3.length, dArr4[i5][i11].length);
                }
                int i12 = i11 + 1;
                int i13 = i11 - 1;
                double d6 = dArr2[i12] - dArr2[i13];
                double d7 = d * d6;
                int i14 = 1;
                while (i14 < length3 - 1) {
                    int i15 = i14 + 1;
                    int i16 = i14 - 1;
                    double d8 = dArr3[i15] - dArr3[i16];
                    double[] dArr12 = dArr5[i5][i11];
                    double[][] dArr13 = dArr4[i7];
                    double[] dArr14 = dArr13[i11];
                    double d9 = dArr14[i14];
                    double[][] dArr15 = dArr4[i8];
                    double[] dArr16 = dArr15[i11];
                    dArr12[i14] = (d9 - dArr16[i14]) / d;
                    double[] dArr17 = dArr6[i5][i11];
                    double[][] dArr18 = dArr4[i5];
                    double[] dArr19 = dArr18[i12];
                    double d10 = dArr19[i14];
                    double[] dArr20 = dArr18[i13];
                    dArr17[i14] = (d10 - dArr20[i14]) / d6;
                    double[] dArr21 = dArr7[i5][i11];
                    double[] dArr22 = dArr18[i11];
                    dArr21[i14] = (dArr22[i15] - dArr22[i16]) / d8;
                    double[] dArr23 = dArr8[i5][i11];
                    double[] dArr24 = dArr13[i12];
                    double d11 = dArr24[i14];
                    double[] dArr25 = dArr13[i13];
                    double d12 = d11 - dArr25[i14];
                    double[] dArr26 = dArr15[i12];
                    double d13 = d12 - dArr26[i14];
                    double[] dArr27 = dArr15[i13];
                    dArr23[i14] = (d13 + dArr27[i14]) / d7;
                    dArr9[i5][i11][i14] = (((dArr14[i15] - dArr14[i16]) - dArr16[i15]) + dArr16[i16]) / (d * d8);
                    dArr10[i5][i11][i14] = (((dArr19[i15] - dArr19[i16]) - dArr20[i15]) + dArr20[i16]) / (d6 * d8);
                    dArr11[i5][i11][i14] = (((((((dArr24[i15] - dArr25[i15]) - dArr26[i15]) + dArr27[i15]) - dArr24[i16]) + dArr25[i16]) + dArr26[i16]) - dArr27[i16]) / (d8 * d7);
                    i14 = i15;
                }
                i10 = i12;
            }
            length = i6;
            i5 = i7;
            length2 = i9;
        }
        return new TricubicInterpolatingFunction(dArr, dArr2, dArr3, dArr4, dArr5, dArr6, dArr7, dArr8, dArr9, dArr10, dArr11) { // from class: org.apache.commons.math3.analysis.interpolation.TricubicInterpolator.1
            @Override // org.apache.commons.math3.analysis.interpolation.TricubicInterpolatingFunction
            public boolean isValidPoint(double d14, double d15, double d16) {
                double[] dArr28 = dArr;
                if (d14 < dArr28[1] || d14 > dArr28[dArr28.length - 2]) {
                    return false;
                }
                double[] dArr29 = dArr2;
                if (d15 < dArr29[1] || d15 > dArr29[dArr29.length - 2]) {
                    return false;
                }
                double[] dArr30 = dArr3;
                return d16 >= dArr30[1] && d16 <= dArr30[dArr30.length + (-2)];
            }
        };
    }
}
