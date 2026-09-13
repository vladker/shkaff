package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class HessenbergTransformer {
    private RealMatrix cachedH;
    private RealMatrix cachedP;
    private RealMatrix cachedPt;
    private final double[][] householderVectors;
    private final double[] ort;

    public HessenbergTransformer(RealMatrix realMatrix) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        this.householderVectors = realMatrix.getData();
        this.ort = new double[rowDimension];
        this.cachedP = null;
        this.cachedPt = null;
        this.cachedH = null;
        transform();
    }

    private void transform() {
        int length = this.householderVectors.length;
        int i5 = length - 1;
        for (int i6 = 1; i6 <= length - 2; i6++) {
            double d = 0.0d;
            double dAbs = 0.0d;
            for (int i7 = i6; i7 <= i5; i7++) {
                dAbs += FastMath.abs(this.householderVectors[i7][i6 - 1]);
            }
            if (!Precision.equals(dAbs, 0.0d)) {
                double d6 = 0.0d;
                for (int i8 = i5; i8 >= i6; i8--) {
                    double[] dArr = this.ort;
                    double d7 = this.householderVectors[i8][i6 - 1] / dAbs;
                    dArr[i8] = d7;
                    d6 += d7 * d7;
                }
                double d8 = this.ort[i6];
                double dSqrt = FastMath.sqrt(d6);
                if (d8 > 0.0d) {
                    dSqrt = -dSqrt;
                }
                double[] dArr2 = this.ort;
                double d9 = dArr2[i6];
                double d10 = d6 - (d9 * dSqrt);
                dArr2[i6] = d9 - dSqrt;
                int i9 = i6;
                while (i9 < length) {
                    double d11 = d;
                    for (int i10 = i5; i10 >= i6; i10--) {
                        d11 = (this.ort[i10] * this.householderVectors[i10][i9]) + d11;
                    }
                    double d12 = d11 / d10;
                    for (int i11 = i6; i11 <= i5; i11++) {
                        double[] dArr3 = this.householderVectors[i11];
                        dArr3[i9] = dArr3[i9] - (this.ort[i11] * d12);
                    }
                    i9++;
                    d = 0.0d;
                }
                for (int i12 = 0; i12 <= i5; i12++) {
                    double d13 = 0.0d;
                    for (int i13 = i5; i13 >= i6; i13--) {
                        d13 = (this.ort[i13] * this.householderVectors[i12][i13]) + d13;
                    }
                    double d14 = d13 / d10;
                    for (int i14 = i6; i14 <= i5; i14++) {
                        double[] dArr4 = this.householderVectors[i12];
                        dArr4[i14] = dArr4[i14] - (this.ort[i14] * d14);
                    }
                }
                double[] dArr5 = this.ort;
                dArr5[i6] = dArr5[i6] * dAbs;
                this.householderVectors[i6][i6 - 1] = dAbs * dSqrt;
            }
        }
    }

    public RealMatrix getH() {
        if (this.cachedH == null) {
            int length = this.householderVectors.length;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            for (int i5 = 0; i5 < length; i5++) {
                if (i5 > 0) {
                    int i6 = i5 - 1;
                    dArr[i5][i6] = this.householderVectors[i5][i6];
                }
                for (int i7 = i5; i7 < length; i7++) {
                    dArr[i5][i7] = this.householderVectors[i5][i7];
                }
            }
            this.cachedH = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedH;
    }

    public double[][] getHouseholderVectorsRef() {
        return this.householderVectors;
    }

    public RealMatrix getP() {
        if (this.cachedP == null) {
            int length = this.householderVectors.length;
            int i5 = length - 1;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
            int i6 = 0;
            while (i6 < length) {
                int i7 = 0;
                while (i7 < length) {
                    dArr[i6][i7] = i6 == i7 ? 1.0d : 0.0d;
                    i7++;
                }
                i6++;
            }
            for (int i8 = length - 2; i8 >= 1; i8--) {
                int i9 = i8 - 1;
                if (this.householderVectors[i8][i9] != 0.0d) {
                    for (int i10 = i8 + 1; i10 <= i5; i10++) {
                        this.ort[i10] = this.householderVectors[i10][i9];
                    }
                    for (int i11 = i8; i11 <= i5; i11++) {
                        double d = 0.0d;
                        for (int i12 = i8; i12 <= i5; i12++) {
                            d += this.ort[i12] * dArr[i12][i11];
                        }
                        double d6 = (d / this.ort[i8]) / this.householderVectors[i8][i9];
                        for (int i13 = i8; i13 <= i5; i13++) {
                            double[] dArr2 = dArr[i13];
                            dArr2[i11] = (this.ort[i13] * d6) + dArr2[i11];
                        }
                    }
                }
            }
            this.cachedP = MatrixUtils.createRealMatrix(dArr);
        }
        return this.cachedP;
    }

    public RealMatrix getPT() {
        if (this.cachedPt == null) {
            this.cachedPt = getP().transpose();
        }
        return this.cachedPt;
    }
}
