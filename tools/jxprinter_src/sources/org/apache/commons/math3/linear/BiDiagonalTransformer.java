package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class BiDiagonalTransformer {
    private RealMatrix cachedB;
    private RealMatrix cachedU;
    private RealMatrix cachedV;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    public BiDiagonalTransformer(RealMatrix realMatrix) {
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        int iMin = FastMath.min(rowDimension, columnDimension);
        this.householderVectors = realMatrix.getData();
        this.main = new double[iMin];
        this.secondary = new double[iMin - 1];
        this.cachedU = null;
        this.cachedB = null;
        this.cachedV = null;
        if (rowDimension >= columnDimension) {
            transformToUpperBiDiagonal();
        } else {
            transformToLowerBiDiagonal();
        }
    }

    private void transformToLowerBiDiagonal() {
        double[][] dArr = this.householderVectors;
        int length = dArr.length;
        int length2 = dArr[0].length;
        for (int i5 = 0; i5 < length; i5++) {
            double[] dArr2 = this.householderVectors[i5];
            double d = 0.0d;
            for (int i6 = i5; i6 < length2; i6++) {
                double d6 = dArr2[i6];
                d += d6 * d6;
            }
            double dSqrt = dArr2[i5] > 0.0d ? -FastMath.sqrt(d) : FastMath.sqrt(d);
            this.main[i5] = dSqrt;
            if (dSqrt != 0.0d) {
                dArr2[i5] = dArr2[i5] - dSqrt;
                for (int i7 = i5 + 1; i7 < length; i7++) {
                    double[] dArr3 = this.householderVectors[i7];
                    double d7 = 0.0d;
                    for (int i8 = i5; i8 < length2; i8++) {
                        d7 -= dArr3[i8] * dArr2[i8];
                    }
                    double d8 = d7 / (this.householderVectors[i5][i5] * dSqrt);
                    for (int i9 = i5; i9 < length2; i9++) {
                        dArr3[i9] = dArr3[i9] - (dArr2[i9] * d8);
                    }
                }
            }
            if (i5 < length - 1) {
                int i10 = i5 + 1;
                double[] dArr4 = this.householderVectors[i10];
                double d9 = 0.0d;
                for (int i11 = i10; i11 < length; i11++) {
                    double d10 = this.householderVectors[i11][i5];
                    d9 += d10 * d10;
                }
                double dSqrt2 = dArr4[i5] > 0.0d ? -FastMath.sqrt(d9) : FastMath.sqrt(d9);
                this.secondary[i5] = dSqrt2;
                if (dSqrt2 != 0.0d) {
                    dArr4[i5] = dArr4[i5] - dSqrt2;
                    for (int i12 = i10; i12 < length2; i12++) {
                        double d11 = 0.0d;
                        for (int i13 = i10; i13 < length; i13++) {
                            double[] dArr5 = this.householderVectors[i13];
                            d11 -= dArr5[i12] * dArr5[i5];
                        }
                        double d12 = d11 / (dArr4[i5] * dSqrt2);
                        for (int i14 = i10; i14 < length; i14++) {
                            double[] dArr6 = this.householderVectors[i14];
                            dArr6[i12] = dArr6[i12] - (dArr6[i5] * d12);
                        }
                    }
                }
            }
        }
    }

    private void transformToUpperBiDiagonal() {
        double[][] dArr = this.householderVectors;
        int length = dArr.length;
        int length2 = dArr[0].length;
        for (int i5 = 0; i5 < length2; i5++) {
            double d = 0.0d;
            for (int i6 = i5; i6 < length; i6++) {
                double d6 = this.householderVectors[i6][i5];
                d += d6 * d6;
            }
            double[] dArr2 = this.householderVectors[i5];
            double d7 = dArr2[i5];
            double dSqrt = FastMath.sqrt(d);
            if (d7 > 0.0d) {
                dSqrt = -dSqrt;
            }
            this.main[i5] = dSqrt;
            if (dSqrt != 0.0d) {
                dArr2[i5] = dArr2[i5] - dSqrt;
                for (int i7 = i5 + 1; i7 < length2; i7++) {
                    double d8 = 0.0d;
                    for (int i8 = i5; i8 < length; i8++) {
                        double[] dArr3 = this.householderVectors[i8];
                        d8 -= dArr3[i7] * dArr3[i5];
                    }
                    double d9 = d8 / (this.householderVectors[i5][i5] * dSqrt);
                    for (int i9 = i5; i9 < length; i9++) {
                        double[] dArr4 = this.householderVectors[i9];
                        dArr4[i7] = dArr4[i7] - (dArr4[i5] * d9);
                    }
                }
            }
            if (i5 < length2 - 1) {
                int i10 = i5 + 1;
                double d10 = 0.0d;
                for (int i11 = i10; i11 < length2; i11++) {
                    double d11 = dArr2[i11];
                    d10 += d11 * d11;
                }
                double dSqrt2 = dArr2[i10] > 0.0d ? -FastMath.sqrt(d10) : FastMath.sqrt(d10);
                this.secondary[i5] = dSqrt2;
                if (dSqrt2 != 0.0d) {
                    dArr2[i10] = dArr2[i10] - dSqrt2;
                    for (int i12 = i10; i12 < length; i12++) {
                        double[] dArr5 = this.householderVectors[i12];
                        double d12 = 0.0d;
                        for (int i13 = i10; i13 < length2; i13++) {
                            d12 -= dArr5[i13] * dArr2[i13];
                        }
                        double d13 = d12 / (dArr2[i10] * dSqrt2);
                        for (int i14 = i10; i14 < length2; i14++) {
                            dArr5[i14] = dArr5[i14] - (dArr2[i14] * d13);
                        }
                    }
                }
            }
        }
    }

    public RealMatrix getB() {
        if (this.cachedB == null) {
            double[][] dArr = this.householderVectors;
            int length = dArr.length;
            int i5 = 0;
            int length2 = dArr[0].length;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
            while (true) {
                double[] dArr3 = this.main;
                if (i5 >= dArr3.length) {
                    break;
                }
                double[] dArr4 = dArr2[i5];
                dArr4[i5] = dArr3[i5];
                if (length < length2) {
                    if (i5 > 0) {
                        int i6 = i5 - 1;
                        dArr4[i6] = this.secondary[i6];
                    }
                } else if (i5 < dArr3.length - 1) {
                    dArr4[i5 + 1] = this.secondary[i5];
                }
                i5++;
            }
            this.cachedB = MatrixUtils.createRealMatrix(dArr2);
        }
        return this.cachedB;
    }

    public double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    public double[] getMainDiagonalRef() {
        return this.main;
    }

    public double[] getSecondaryDiagonalRef() {
        return this.secondary;
    }

    public RealMatrix getU() {
        double d;
        if (this.cachedU == null) {
            double[][] dArr = this.householderVectors;
            int length = dArr.length;
            boolean z6 = false;
            int length2 = dArr[0].length;
            double[] dArr2 = this.main;
            int length3 = dArr2.length;
            int i5 = length >= length2 ? 0 : 1;
            if (length < length2) {
                dArr2 = this.secondary;
            }
            double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            int i6 = length - 1;
            while (true) {
                d = 1.0d;
                if (i6 < length3) {
                    break;
                }
                dArr3[i6][i6] = 1.0d;
                i6--;
            }
            int i7 = length3 - 1;
            while (i7 >= i5) {
                double[] dArr4 = this.householderVectors[i7];
                dArr3[i7][i7] = d;
                int i8 = i7 - i5;
                double d6 = 0.0d;
                if (dArr4[i8] != 0.0d) {
                    int i9 = i7;
                    while (i9 < length) {
                        int i10 = i7;
                        double d7 = d6;
                        while (i10 < length) {
                            d7 -= dArr3[i10][i9] * this.householderVectors[i10][i8];
                            i10++;
                            z6 = z6;
                        }
                        boolean z7 = z6;
                        double d8 = d;
                        double d9 = d7 / (dArr2[i8] * dArr4[i8]);
                        int i11 = i7;
                        while (i11 < length) {
                            double[] dArr5 = dArr3[i11];
                            dArr5[i9] = ((-d9) * this.householderVectors[i11][i8]) + dArr5[i9];
                            i11++;
                            dArr3 = dArr3;
                        }
                        i9++;
                        z6 = z7;
                        d = d8;
                        d6 = 0.0d;
                    }
                }
                i7--;
                z6 = z6;
                d = d;
                dArr3 = dArr3;
            }
            double[][] dArr6 = dArr3;
            boolean z8 = z6;
            double d10 = d;
            if (i5 > 0) {
                dArr6[z8 ? 1 : 0][z8 ? 1 : 0] = d10;
            }
            this.cachedU = MatrixUtils.createRealMatrix(dArr6);
        }
        return this.cachedU;
    }

    public RealMatrix getV() {
        double d;
        if (this.cachedV == null) {
            double[][] dArr = this.householderVectors;
            int length = dArr.length;
            boolean z6 = false;
            int length2 = dArr[0].length;
            double[] dArr2 = this.main;
            int length3 = dArr2.length;
            int i5 = length >= length2 ? 1 : 0;
            if (length >= length2) {
                dArr2 = this.secondary;
            }
            double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length2);
            int i6 = length2 - 1;
            while (true) {
                d = 1.0d;
                if (i6 < length3) {
                    break;
                }
                dArr3[i6][i6] = 1.0d;
                i6--;
            }
            int i7 = length3 - 1;
            while (i7 >= i5) {
                int i8 = i7 - i5;
                double[] dArr4 = this.householderVectors[i8];
                dArr3[i7][i7] = d;
                if (dArr4[i7] != 0.0d) {
                    int i9 = i7;
                    while (i9 < length2) {
                        double d6 = 0.0d;
                        for (int i10 = i7; i10 < length2; i10++) {
                            d6 -= dArr3[i10][i9] * dArr4[i10];
                        }
                        boolean z7 = z6;
                        double[] dArr5 = dArr2;
                        double d7 = d6 / (dArr2[i8] * dArr4[i7]);
                        int i11 = i7;
                        while (i11 < length2) {
                            double[] dArr6 = dArr3[i11];
                            dArr6[i9] = ((-d7) * dArr4[i11]) + dArr6[i9];
                            i11++;
                            d = d;
                        }
                        i9++;
                        z6 = z7;
                        dArr2 = dArr5;
                    }
                }
                i7--;
                z6 = z6;
                dArr2 = dArr2;
                d = d;
            }
            boolean z8 = z6;
            double d8 = d;
            if (i5 > 0) {
                dArr3[z8 ? 1 : 0][z8 ? 1 : 0] = d8;
            }
            this.cachedV = MatrixUtils.createRealMatrix(dArr3);
        }
        return this.cachedV;
    }

    public boolean isUpperBiDiagonal() {
        double[][] dArr = this.householderVectors;
        return dArr.length >= dArr[0].length;
    }
}
