package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BicubicInterpolatingFunction implements BivariateFunction {
    private static final double[][] AINV = {new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    private static final int NUM_COEFF = 16;
    private final BicubicFunction[][] splines;
    private final double[] xval;
    private final double[] yval;

    public BicubicInterpolatingFunction(double[] dArr, double[] dArr2, double[][] dArr3, double[][] dArr4, double[][] dArr5, double[][] dArr6) {
        int length = dArr.length;
        int length2 = dArr2.length;
        if (length != 0 && length2 != 0 && dArr3.length != 0) {
            int i5 = 0;
            if (dArr3[0].length != 0) {
                if (length != dArr3.length) {
                    throw new DimensionMismatchException(length, dArr3.length);
                }
                if (length != dArr4.length) {
                    throw new DimensionMismatchException(length, dArr4.length);
                }
                if (length != dArr5.length) {
                    throw new DimensionMismatchException(length, dArr5.length);
                }
                if (length != dArr6.length) {
                    throw new DimensionMismatchException(length, dArr6.length);
                }
                MathArrays.checkOrder(dArr);
                MathArrays.checkOrder(dArr2);
                this.xval = (double[]) dArr.clone();
                this.yval = (double[]) dArr2.clone();
                char c = 1;
                int i6 = length - 1;
                int i7 = length2 - 1;
                char c6 = 2;
                this.splines = (BicubicFunction[][]) Array.newInstance((Class<?>) BicubicFunction.class, i6, i7);
                int i8 = 0;
                while (i8 < i6) {
                    if (dArr3[i8].length != length2) {
                        throw new DimensionMismatchException(dArr3[i8].length, length2);
                    }
                    if (dArr4[i8].length != length2) {
                        throw new DimensionMismatchException(dArr4[i8].length, length2);
                    }
                    if (dArr5[i8].length != length2) {
                        throw new DimensionMismatchException(dArr5[i8].length, length2);
                    }
                    if (dArr6[i8].length != length2) {
                        throw new DimensionMismatchException(dArr6[i8].length, length2);
                    }
                    int i9 = i8 + 1;
                    double[] dArr7 = this.xval;
                    double d = dArr7[i9] - dArr7[i8];
                    int i10 = i5;
                    while (i10 < i7) {
                        int i11 = i10 + 1;
                        char c7 = c;
                        double[] dArr8 = this.yval;
                        double d6 = dArr8[i11] - dArr8[i10];
                        double d7 = d * d6;
                        double[] dArr9 = dArr3[i8];
                        double d8 = dArr9[i10];
                        double[] dArr10 = dArr3[i9];
                        double d9 = dArr10[i10];
                        double d10 = dArr9[i11];
                        double d11 = dArr10[i11];
                        double[] dArr11 = dArr4[i8];
                        double d12 = dArr11[i10] * d;
                        double[] dArr12 = dArr4[i9];
                        double d13 = dArr12[i10] * d;
                        double d14 = dArr11[i11] * d;
                        double d15 = dArr12[i11] * d;
                        double[] dArr13 = dArr5[i8];
                        double d16 = dArr13[i10] * d6;
                        double[] dArr14 = dArr5[i9];
                        double d17 = dArr14[i10] * d6;
                        double d18 = dArr13[i11] * d6;
                        double d19 = dArr14[i11] * d6;
                        double[] dArr15 = dArr6[i8];
                        double d20 = dArr15[i10] * d7;
                        double[] dArr16 = dArr6[i9];
                        double d21 = dArr16[i10] * d7;
                        double d22 = dArr15[i11] * d7;
                        double d23 = dArr16[i11] * d7;
                        double[] dArr17 = new double[16];
                        dArr17[i5] = d8;
                        dArr17[c7] = d9;
                        dArr17[c6] = d10;
                        dArr17[3] = d11;
                        dArr17[4] = d12;
                        dArr17[5] = d13;
                        dArr17[6] = d14;
                        dArr17[7] = d15;
                        dArr17[8] = d16;
                        dArr17[9] = d17;
                        dArr17[10] = d18;
                        dArr17[11] = d19;
                        dArr17[12] = d20;
                        dArr17[13] = d21;
                        dArr17[14] = d22;
                        dArr17[15] = d23;
                        this.splines[i8][i10] = new BicubicFunction(computeSplineCoefficients(dArr17));
                        c = c7;
                        i10 = i11;
                        i5 = 0;
                        c6 = 2;
                    }
                    i8 = i9;
                }
                return;
            }
        }
        throw new NoDataException();
    }

    private double[] computeSplineCoefficients(double[] dArr) {
        double[] dArr2 = new double[16];
        for (int i5 = 0; i5 < 16; i5++) {
            double[] dArr3 = AINV[i5];
            double d = 0.0d;
            for (int i6 = 0; i6 < 16; i6++) {
                d += dArr3[i6] * dArr[i6];
            }
            dArr2[i5] = d;
        }
        return dArr2;
    }

    private int searchIndex(double d, double[] dArr) {
        int iBinarySearch = Arrays.binarySearch(dArr, d);
        if (iBinarySearch == -1 || iBinarySearch == (-dArr.length) - 1) {
            throw new OutOfRangeException(Double.valueOf(d), Double.valueOf(dArr[0]), Double.valueOf(dArr[dArr.length - 1]));
        }
        if (iBinarySearch < 0) {
            return (-iBinarySearch) - 2;
        }
        int length = dArr.length;
        return iBinarySearch == length + (-1) ? length - 2 : iBinarySearch;
    }

    public boolean isValidPoint(double d, double d6) {
        double[] dArr = this.xval;
        if (d >= dArr[0] && d <= dArr[dArr.length - 1]) {
            double[] dArr2 = this.yval;
            if (d6 >= dArr2[0] && d6 <= dArr2[dArr2.length - 1]) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.math3.analysis.BivariateFunction
    public double value(double d, double d6) {
        int iSearchIndex = searchIndex(d, this.xval);
        int iSearchIndex2 = searchIndex(d6, this.yval);
        double[] dArr = this.xval;
        double d7 = dArr[iSearchIndex];
        double d8 = (d - d7) / (dArr[iSearchIndex + 1] - d7);
        double[] dArr2 = this.yval;
        double d9 = dArr2[iSearchIndex2];
        return this.splines[iSearchIndex][iSearchIndex2].value(d8, (d6 - d9) / (dArr2[iSearchIndex2 + 1] - d9));
    }
}
