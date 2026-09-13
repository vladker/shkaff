package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class TriDiagonalTransformer {
    private RealMatrix cachedQ;
    private RealMatrix cachedQt;
    private RealMatrix cachedT;
    private final double[][] householderVectors;
    private final double[] main;
    private final double[] secondary;

    public TriDiagonalTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        this.householderVectors = realMatrix.getData();
        this.main = new double[rowDimension];
        this.secondary = new double[rowDimension - 1];
        this.cachedQ = null;
        this.cachedQt = null;
        this.cachedT = null;
        transform();
    }

    private void transform() {
        int length = this.householderVectors.length;
        double[] dArr = new double[length];
        int i5 = 0;
        while (true) {
            int i6 = length - 1;
            if (i5 >= i6) {
                this.main[i6] = this.householderVectors[i6][i6];
                return;
            }
            double[] dArr2 = this.householderVectors[i5];
            this.main[i5] = dArr2[i5];
            int i7 = i5 + 1;
            double d = 0.0d;
            for (int i8 = i7; i8 < length; i8++) {
                double d6 = dArr2[i8];
                d += d6 * d6;
            }
            double dSqrt = dArr2[i7] > 0.0d ? -FastMath.sqrt(d) : FastMath.sqrt(d);
            this.secondary[i5] = dSqrt;
            if (dSqrt != 0.0d) {
                double d7 = dArr2[i7] - dSqrt;
                dArr2[i7] = d7;
                double d8 = (-1.0d) / (dSqrt * d7);
                Arrays.fill(dArr, i7, length, 0.0d);
                int i9 = i7;
                while (i9 < length) {
                    double[] dArr3 = this.householderVectors[i9];
                    double d9 = dArr2[i9];
                    double d10 = dArr3[i9] * d9;
                    int i10 = i9 + 1;
                    for (int i11 = i10; i11 < length; i11++) {
                        double d11 = dArr3[i11];
                        d10 = (dArr2[i11] * d11) + d10;
                        dArr[i11] = (d11 * d9) + dArr[i11];
                    }
                    dArr[i9] = (dArr[i9] + d10) * d8;
                    i9 = i10;
                }
                double d12 = 0.0d;
                for (int i12 = i7; i12 < length; i12++) {
                    d12 += dArr[i12] * dArr2[i12];
                }
                double d13 = (d8 / 2.0d) * d12;
                for (int i13 = i7; i13 < length; i13++) {
                    dArr[i13] = dArr[i13] - (dArr2[i13] * d13);
                }
                for (int i14 = i7; i14 < length; i14++) {
                    double[] dArr4 = this.householderVectors[i14];
                    for (int i15 = i14; i15 < length; i15++) {
                        dArr4[i15] = dArr4[i15] - ((dArr[i14] * dArr2[i15]) + (dArr2[i14] * dArr[i15]));
                    }
                }
            }
            i5 = i7;
        }
    }

    public double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    public double[] getMainDiagonalRef() {
        return this.main;
    }

    public RealMatrix getQ() {
        if (this.cachedQ == null) {
            this.cachedQ = getQT().transpose();
        }
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        if (this.cachedQt == null) {
            int length = this.householderVectors.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i5 = length - 1; i5 >= 1; i5--) {
                int i6 = i5 - 1;
                double[] dArr2 = this.householderVectors[i6];
                double[] dArr3 = dArr[i5];
                dArr3[i5] = 1.0d;
                double d = dArr2[i5];
                if (d != 0.0d) {
                    double d6 = this.secondary[i6];
                    double d7 = 1.0d / (d6 * d);
                    double d8 = 1.0d / d6;
                    dArr3[i5] = (d * d8) + 1.0d;
                    int i7 = i5 + 1;
                    for (int i8 = i7; i8 < length; i8++) {
                        dArr[i5][i8] = dArr2[i8] * d8;
                    }
                    for (int i9 = i7; i9 < length; i9++) {
                        double d9 = 0.0d;
                        for (int i10 = i7; i10 < length; i10++) {
                            d9 += dArr[i9][i10] * dArr2[i10];
                        }
                        double d10 = d9 * d7;
                        dArr[i9][i5] = dArr2[i5] * d10;
                        for (int i11 = i7; i11 < length; i11++) {
                            double[] dArr4 = dArr[i9];
                            dArr4[i11] = (dArr2[i11] * d10) + dArr4[i11];
                        }
                    }
                }
            }
            dArr[0][0] = 1.0d;
            this.cachedQt = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedQt;
    }

    public double[] getSecondaryDiagonalRef() {
        return this.secondary;
    }

    public RealMatrix getT() {
        if (this.cachedT == null) {
            int length = this.main.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                double[] dArr2 = dArr[i5];
                double[] dArr3 = this.main;
                dArr2[i5] = dArr3[i5];
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    dArr2[i6] = this.secondary[i6];
                }
                if (i5 < dArr3.length - 1) {
                    dArr2[i5 + 1] = this.secondary[i5];
                }
            }
            this.cachedT = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedT;
    }
}
