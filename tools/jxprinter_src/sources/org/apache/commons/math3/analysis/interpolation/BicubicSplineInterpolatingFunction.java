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
@Deprecated
public class BicubicSplineInterpolatingFunction implements BivariateFunction {
    private static final double[][] AINV = {new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{-3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 3.0d, 0.0d, 0.0d, -2.0d, -1.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 0.0d, 1.0d, 1.0d, 0.0d, 0.0d}, new double[]{-3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, -3.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -2.0d, 0.0d, -1.0d, 0.0d}, new double[]{9.0d, -9.0d, -9.0d, 9.0d, 6.0d, 3.0d, -6.0d, -3.0d, 6.0d, -6.0d, 3.0d, -3.0d, 4.0d, 2.0d, 2.0d, 1.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -3.0d, -3.0d, 3.0d, 3.0d, -4.0d, 4.0d, -2.0d, 2.0d, -2.0d, -2.0d, -1.0d, -1.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, -2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 0.0d}, new double[]{-6.0d, 6.0d, 6.0d, -6.0d, -4.0d, -2.0d, 4.0d, 2.0d, -3.0d, 3.0d, -3.0d, 3.0d, -2.0d, -1.0d, -2.0d, -1.0d}, new double[]{4.0d, -4.0d, -4.0d, 4.0d, 2.0d, 2.0d, -2.0d, -2.0d, 2.0d, -2.0d, 2.0d, -2.0d, 1.0d, 1.0d, 1.0d, 1.0d}};
    private static final int NUM_COEFF = 16;
    private final BivariateFunction[][][] partialDerivatives;
    private final BicubicSplineFunction[][] splines;
    private final double[] xval;
    private final double[] yval;

    public BicubicSplineInterpolatingFunction(double[] dArr, double[] dArr2, double[][] dArr3, double[][] dArr4, double[][] dArr5, double[][] dArr6) {
        this(dArr, dArr2, dArr3, dArr4, dArr5, dArr6, false);
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

    private double partialDerivative(int i5, double d, double d6) {
        int iSearchIndex = searchIndex(d, this.xval);
        int iSearchIndex2 = searchIndex(d6, this.yval);
        double[] dArr = this.xval;
        double d7 = dArr[iSearchIndex];
        double d8 = (d - d7) / (dArr[iSearchIndex + 1] - d7);
        double[] dArr2 = this.yval;
        double d9 = dArr2[iSearchIndex2];
        return this.partialDerivatives[i5][iSearchIndex][iSearchIndex2].value(d8, (d6 - d9) / (dArr2[iSearchIndex2 + 1] - d9));
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

    public double partialDerivativeX(double d, double d6) {
        return partialDerivative(0, d, d6);
    }

    public double partialDerivativeXX(double d, double d6) {
        return partialDerivative(2, d, d6);
    }

    public double partialDerivativeXY(double d, double d6) {
        return partialDerivative(4, d, d6);
    }

    public double partialDerivativeY(double d, double d6) {
        return partialDerivative(1, d, d6);
    }

    public double partialDerivativeYY(double d, double d6) {
        return partialDerivative(3, d, d6);
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

    public BicubicSplineInterpolatingFunction(double[] dArr, double[] dArr2, double[][] dArr3, double[][] dArr4, double[][] dArr5, double[][] dArr6, boolean z6) {
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
                this.splines = (BicubicSplineFunction[][]) Array.newInstance((Class<?>) BicubicSplineFunction.class, i6, i7);
                int i8 = 0;
                while (true) {
                    char c7 = 5;
                    char c8 = 4;
                    if (i8 >= i6) {
                        char c9 = c;
                        int i9 = i5;
                        char c10 = c6;
                        if (!z6) {
                            this.partialDerivatives = null;
                            return;
                        }
                        int[] iArr = new int[3];
                        iArr[c10] = i7;
                        iArr[c9] = i6;
                        iArr[i9] = 5;
                        this.partialDerivatives = (BivariateFunction[][][]) Array.newInstance((Class<?>) BivariateFunction.class, iArr);
                        for (int i10 = i9; i10 < i6; i10++) {
                            for (int i11 = i9; i11 < i7; i11++) {
                                BicubicSplineFunction bicubicSplineFunction = this.splines[i10][i11];
                                this.partialDerivatives[i9][i10][i11] = bicubicSplineFunction.partialDerivativeX();
                                this.partialDerivatives[c9][i10][i11] = bicubicSplineFunction.partialDerivativeY();
                                this.partialDerivatives[c10][i10][i11] = bicubicSplineFunction.partialDerivativeXX();
                                this.partialDerivatives[3][i10][i11] = bicubicSplineFunction.partialDerivativeYY();
                                this.partialDerivatives[4][i10][i11] = bicubicSplineFunction.partialDerivativeXY();
                            }
                        }
                        return;
                    }
                    char c11 = c;
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
                    int i12 = i8 + 1;
                    int i13 = i5;
                    while (i5 < i7) {
                        int i14 = i5 + 1;
                        double[] dArr7 = dArr3[i8];
                        double d = dArr7[i5];
                        double[] dArr8 = dArr3[i12];
                        double d6 = dArr8[i5];
                        double d7 = dArr7[i14];
                        double d8 = dArr8[i14];
                        double[] dArr9 = dArr4[i8];
                        double d9 = dArr9[i5];
                        double[] dArr10 = dArr4[i12];
                        double d10 = dArr10[i5];
                        double d11 = dArr9[i14];
                        double d12 = dArr10[i14];
                        double[] dArr11 = dArr5[i8];
                        double d13 = dArr11[i5];
                        double[] dArr12 = dArr5[i12];
                        double d14 = dArr12[i5];
                        double d15 = dArr11[i14];
                        double d16 = dArr12[i14];
                        double[] dArr13 = dArr6[i8];
                        double d17 = dArr13[i5];
                        double[] dArr14 = dArr6[i12];
                        double d18 = dArr14[i5];
                        double d19 = dArr13[i14];
                        double d20 = dArr14[i14];
                        char c12 = c6;
                        double[] dArr15 = new double[16];
                        dArr15[i13] = d;
                        dArr15[c11] = d6;
                        dArr15[c12] = d7;
                        dArr15[3] = d8;
                        dArr15[c8] = d9;
                        dArr15[c7] = d10;
                        dArr15[6] = d11;
                        dArr15[7] = d12;
                        dArr15[8] = d13;
                        dArr15[9] = d14;
                        dArr15[10] = d15;
                        dArr15[11] = d16;
                        dArr15[12] = d17;
                        dArr15[13] = d18;
                        dArr15[14] = d19;
                        dArr15[15] = d20;
                        this.splines[i8][i5] = new BicubicSplineFunction(computeSplineCoefficients(dArr15), z6);
                        c6 = c12;
                        i5 = i14;
                        c7 = c7;
                        c8 = c8;
                    }
                    i8 = i12;
                    i5 = i13;
                    c = c11;
                }
            }
        }
        throw new NoDataException();
    }
}
