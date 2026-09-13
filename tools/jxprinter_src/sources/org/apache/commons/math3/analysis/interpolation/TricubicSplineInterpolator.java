package org.apache.commons.math3.analysis.interpolation;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TricubicSplineInterpolator implements TrivariateGridInterpolator {
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

    @Override // org.apache.commons.math3.analysis.interpolation.TrivariateGridInterpolator
    public TricubicSplineInterpolatingFunction interpolate(double[] dArr, double[] dArr2, double[] dArr3, double[][][] dArr4) {
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
        char c = 2;
        boolean z6 = true;
        int i5 = 0;
        Class cls = Double.TYPE;
        double[][][] dArr5 = (double[][][]) Array.newInstance((Class<?>) cls, length3, length, length2);
        double[][][] dArr6 = (double[][][]) Array.newInstance((Class<?>) cls, length2, length3, length);
        int i6 = 0;
        while (i6 < length) {
            char c6 = c;
            if (dArr4[i6].length != length2) {
                throw new DimensionMismatchException(dArr4[i6].length, length2);
            }
            int i7 = i5;
            while (i7 < length2) {
                int i8 = i5;
                if (dArr4[i6][i7].length != length3) {
                    throw new DimensionMismatchException(dArr4[i6][i7].length, length3);
                }
                for (int i9 = i8; i9 < length3; i9++) {
                    double d = dArr4[i6][i7][i9];
                    dArr5[i9][i6][i7] = d;
                    dArr6[i7][i9][i6] = d;
                }
                i7++;
                i5 = i8;
            }
            i6++;
            c = c6;
        }
        char c7 = c;
        int i10 = i5;
        BicubicSplineInterpolator bicubicSplineInterpolator = new BicubicSplineInterpolator(true);
        BicubicSplineInterpolatingFunction[] bicubicSplineInterpolatingFunctionArr = new BicubicSplineInterpolatingFunction[length];
        int i11 = i10;
        while (i11 < length) {
            bicubicSplineInterpolatingFunctionArr[i11] = bicubicSplineInterpolator.interpolate(dArr2, dArr3, dArr4[i11]);
            i11++;
            z6 = z6;
        }
        boolean z7 = z6;
        BicubicSplineInterpolatingFunction[] bicubicSplineInterpolatingFunctionArr2 = new BicubicSplineInterpolatingFunction[length2];
        for (int i12 = i10; i12 < length2; i12++) {
            bicubicSplineInterpolatingFunctionArr2[i12] = bicubicSplineInterpolator.interpolate(dArr3, dArr, dArr6[i12]);
        }
        BicubicSplineInterpolatingFunction[] bicubicSplineInterpolatingFunctionArr3 = new BicubicSplineInterpolatingFunction[length3];
        for (int i13 = i10; i13 < length3; i13++) {
            bicubicSplineInterpolatingFunctionArr3[i13] = bicubicSplineInterpolator.interpolate(dArr, dArr2, dArr5[i13]);
        }
        int[] iArr = new int[3];
        iArr[c7] = length3;
        iArr[z7 ? 1 : 0] = length2;
        iArr[i10] = length;
        double[][][] dArr7 = (double[][][]) Array.newInstance((Class<?>) cls, iArr);
        int[] iArr2 = new int[3];
        iArr2[c7] = length3;
        iArr2[z7 ? 1 : 0] = length2;
        iArr2[i10] = length;
        double[][][] dArr8 = (double[][][]) Array.newInstance((Class<?>) cls, iArr2);
        int[] iArr3 = new int[3];
        iArr3[c7] = length3;
        iArr3[z7 ? 1 : 0] = length2;
        iArr3[i10] = length;
        double[][][] dArr9 = (double[][][]) Array.newInstance((Class<?>) cls, iArr3);
        for (int i14 = i10; i14 < length3; i14++) {
            BicubicSplineInterpolatingFunction bicubicSplineInterpolatingFunction = bicubicSplineInterpolatingFunctionArr3[i14];
            int i15 = i10;
            while (i15 < length) {
                int i16 = i15;
                double d6 = dArr[i16];
                int i17 = i10;
                while (i17 < length2) {
                    BicubicSplineInterpolatingFunction[] bicubicSplineInterpolatingFunctionArr4 = bicubicSplineInterpolatingFunctionArr3;
                    double[][][] dArr10 = dArr7;
                    double d7 = dArr2[i17];
                    dArr10[i16][i17][i14] = bicubicSplineInterpolatingFunction.partialDerivativeX(d6, d7);
                    dArr8[i16][i17][i14] = bicubicSplineInterpolatingFunction.partialDerivativeY(d6, d7);
                    dArr9[i16][i17][i14] = bicubicSplineInterpolatingFunction.partialDerivativeXY(d6, d7);
                    i17++;
                    bicubicSplineInterpolatingFunctionArr3 = bicubicSplineInterpolatingFunctionArr4;
                    dArr7 = dArr10;
                }
                i15 = i16 + 1;
            }
        }
        double[][][] dArr11 = dArr7;
        int[] iArr4 = new int[3];
        iArr4[c7] = length3;
        iArr4[z7 ? 1 : 0] = length2;
        iArr4[i10] = length;
        double[][][] dArr12 = (double[][][]) Array.newInstance((Class<?>) cls, iArr4);
        int[] iArr5 = new int[3];
        iArr5[c7] = length3;
        iArr5[z7 ? 1 : 0] = length2;
        iArr5[i10] = length;
        double[][][] dArr13 = (double[][][]) Array.newInstance((Class<?>) cls, iArr5);
        int i18 = i10;
        while (i18 < length) {
            BicubicSplineInterpolatingFunction bicubicSplineInterpolatingFunction2 = bicubicSplineInterpolatingFunctionArr[i18];
            int i19 = i10;
            while (i19 < length2) {
                double[][][] dArr14 = dArr13;
                int i20 = i18;
                double d8 = dArr2[i19];
                int i21 = i19;
                int i22 = i10;
                while (i22 < length3) {
                    double[][][] dArr15 = dArr12;
                    double[][][] dArr16 = dArr14;
                    double d9 = dArr3[i22];
                    dArr15[i20][i21][i22] = bicubicSplineInterpolatingFunction2.partialDerivativeY(d8, d9);
                    dArr16[i20][i21][i22] = bicubicSplineInterpolatingFunction2.partialDerivativeXY(d8, d9);
                    i22++;
                    dArr12 = dArr15;
                    dArr14 = dArr16;
                }
                i19 = i21 + 1;
                i18 = i20;
                dArr13 = dArr14;
            }
            i18++;
        }
        double[][][] dArr17 = dArr13;
        double[][][] dArr18 = dArr12;
        int[] iArr6 = new int[3];
        iArr6[c7] = length3;
        iArr6[z7 ? 1 : 0] = length2;
        iArr6[i10] = length;
        double[][][] dArr19 = (double[][][]) Array.newInstance((Class<?>) cls, iArr6);
        int i23 = i10;
        while (i23 < length2) {
            BicubicSplineInterpolatingFunction bicubicSplineInterpolatingFunction3 = bicubicSplineInterpolatingFunctionArr2[i23];
            for (int i24 = i10; i24 < length3; i24++) {
                double d10 = dArr3[i24];
                int i25 = i10;
                while (i25 < length) {
                    double[][][] dArr20 = dArr19;
                    int i26 = i23;
                    dArr20[i25][i26][i24] = bicubicSplineInterpolatingFunction3.partialDerivativeXY(d10, dArr[i25]);
                    i25++;
                    dArr19 = dArr20;
                    i23 = i26;
                }
            }
            i23++;
        }
        double[][][] dArr21 = dArr19;
        int[] iArr7 = new int[3];
        iArr7[c7] = length3;
        iArr7[z7 ? 1 : 0] = length2;
        iArr7[i10] = length;
        double[][][] dArr22 = (double[][][]) Array.newInstance((Class<?>) cls, iArr7);
        for (int i27 = i10; i27 < length; i27++) {
            int iNextIndex = nextIndex(i27, length);
            int iPreviousIndex = previousIndex(i27);
            for (int i28 = i10; i28 < length2; i28++) {
                int iNextIndex2 = nextIndex(i28, length2);
                int iPreviousIndex2 = previousIndex(i28);
                for (int i29 = i10; i29 < length3; i29++) {
                    int iNextIndex3 = nextIndex(i29, length3);
                    int iPreviousIndex3 = previousIndex(i29);
                    double[] dArr23 = dArr22[i27][i28];
                    double[][] dArr24 = dArr4[iNextIndex];
                    double[] dArr25 = dArr24[iNextIndex2];
                    double d11 = dArr25[iNextIndex3];
                    double[] dArr26 = dArr24[iPreviousIndex2];
                    double d12 = d11 - dArr26[iNextIndex3];
                    double[][] dArr27 = dArr4[iPreviousIndex];
                    double[] dArr28 = dArr27[iNextIndex2];
                    double d13 = d12 - dArr28[iNextIndex3];
                    double[] dArr29 = dArr27[iPreviousIndex2];
                    dArr23[i29] = (((((d13 + dArr29[iNextIndex3]) - dArr25[iPreviousIndex3]) + dArr26[iPreviousIndex3]) + dArr28[iPreviousIndex3]) - dArr29[iPreviousIndex3]) / ((dArr3[iNextIndex3] - dArr3[iPreviousIndex3]) * ((dArr2[iNextIndex2] - dArr2[iPreviousIndex2]) * (dArr[iNextIndex] - dArr[iPreviousIndex])));
                }
            }
        }
        return new TricubicSplineInterpolatingFunction(dArr, dArr2, dArr3, dArr4, dArr11, dArr8, dArr18, dArr9, dArr21, dArr17, dArr22);
    }
}
