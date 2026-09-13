package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class QRDecomposition {
    private RealMatrix cachedH;
    private RealMatrix cachedQ;
    private RealMatrix cachedQT;
    private RealMatrix cachedR;
    private double[][] qrt;
    private double[] rDiag;
    private final double threshold;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {
        private final double[][] qrt;
        private final double[] rDiag;
        private final double threshold;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.qrt[0].length));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            for (double d : this.rDiag) {
                if (FastMath.abs(d) <= this.threshold) {
                    return false;
                }
            }
            return true;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            double[][] dArr = this.qrt;
            int length = dArr.length;
            int length2 = dArr[0].length;
            if (realVector.getDimension() != length2) {
                throw new DimensionMismatchException(realVector.getDimension(), length2);
            }
            if (!isNonSingular()) {
                throw new SingularMatrixException();
            }
            double[] dArr2 = new double[length];
            double[] array = realVector.toArray();
            for (int i5 = 0; i5 < FastMath.min(length2, length); i5++) {
                double[] dArr3 = this.qrt[i5];
                double d = 0.0d;
                for (int i6 = i5; i6 < length2; i6++) {
                    d += array[i6] * dArr3[i6];
                }
                double d6 = d / (this.rDiag[i5] * dArr3[i5]);
                for (int i7 = i5; i7 < length2; i7++) {
                    array[i7] = (dArr3[i7] * d6) + array[i7];
                }
            }
            for (int length3 = this.rDiag.length - 1; length3 >= 0; length3--) {
                double d7 = array[length3] / this.rDiag[length3];
                array[length3] = d7;
                double[] dArr4 = this.qrt[length3];
                dArr2[length3] = d7;
                for (int i8 = 0; i8 < length3; i8++) {
                    array[i8] = array[i8] - (dArr4[i8] * d7);
                }
            }
            return new ArrayRealVector(dArr2, false);
        }

        private Solver(double[][] dArr, double[] dArr2, double d) {
            this.qrt = dArr;
            this.rDiag = dArr2;
            this.threshold = d;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            double d;
            double[][] dArr = this.qrt;
            int length = dArr.length;
            int i5 = 0;
            int length2 = dArr[0].length;
            if (realMatrix.getRowDimension() == length2) {
                if (isNonSingular()) {
                    int columnDimension = realMatrix.getColumnDimension();
                    int i6 = (columnDimension + 51) / 52;
                    double[][] dArrCreateBlocksLayout = BlockRealMatrix.createBlocksLayout(length, columnDimension);
                    boolean z6 = true;
                    double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, realMatrix.getRowDimension(), 52);
                    double[] dArr3 = new double[52];
                    int i7 = 0;
                    while (i7 < i6) {
                        int i8 = i7 * 52;
                        int iMin = FastMath.min(i8 + 52, columnDimension);
                        int i9 = iMin - i8;
                        realMatrix.copySubMatrix(0, length2 - 1, i8, iMin - 1, dArr2);
                        int i10 = i5;
                        while (true) {
                            d = 1.0d;
                            if (i10 >= FastMath.min(length2, length)) {
                                break;
                            }
                            double[] dArr4 = this.qrt[i10];
                            double d6 = 1.0d / (this.rDiag[i10] * dArr4[i10]);
                            boolean z7 = z6;
                            int i11 = i10;
                            Arrays.fill(dArr3, i5, i9, 0.0d);
                            int i12 = i11;
                            while (i12 < length2) {
                                double d7 = dArr4[i12];
                                double[] dArr5 = dArr2[i12];
                                boolean z8 = z7;
                                for (int i13 = i5; i13 < i9; i13++) {
                                    dArr3[i13] = (dArr5[i13] * d7) + dArr3[i13];
                                }
                                i12++;
                                z7 = z8;
                            }
                            boolean z9 = z7;
                            for (int i14 = i5; i14 < i9; i14++) {
                                dArr3[i14] = dArr3[i14] * d6;
                            }
                            for (int i15 = i11; i15 < length2; i15++) {
                                double d8 = dArr4[i15];
                                double[] dArr6 = dArr2[i15];
                                for (int i16 = i5; i16 < i9; i16++) {
                                    dArr6[i16] = (dArr3[i16] * d8) + dArr6[i16];
                                }
                            }
                            i10 = i11 + 1;
                            z6 = z9;
                        }
                        boolean z10 = z6;
                        int length3 = this.rDiag.length - 1;
                        while (length3 >= 0) {
                            int i17 = length3 / 52;
                            int i18 = i17 * 52;
                            double d9 = d / this.rDiag[length3];
                            double[] dArr7 = dArr2[length3];
                            double[] dArr8 = dArrCreateBlocksLayout[(i17 * i6) + i7];
                            int i19 = (length3 - i18) * i9;
                            int i20 = i5;
                            while (i20 < i9) {
                                double d10 = dArr7[i20] * d9;
                                dArr7[i20] = d10;
                                dArr8[i19] = d10;
                                i20++;
                                i19++;
                            }
                            double[] dArr9 = this.qrt[length3];
                            int i21 = i5;
                            while (i21 < length3) {
                                double d11 = dArr9[i21];
                                double[] dArr10 = dArr2[i21];
                                while (i5 < i9) {
                                    dArr10[i5] = dArr10[i5] - (dArr7[i5] * d11);
                                    i5++;
                                }
                                i21++;
                                i5 = 0;
                            }
                            length3--;
                            i5 = 0;
                            d = 1.0d;
                        }
                        i7++;
                        z6 = z10;
                        i5 = 0;
                    }
                    return new BlockRealMatrix(length, columnDimension, dArrCreateBlocksLayout, false);
                }
                throw new SingularMatrixException();
            }
            throw new DimensionMismatchException(realMatrix.getRowDimension(), length2);
        }
    }

    public QRDecomposition(RealMatrix realMatrix) {
        this(realMatrix, 0.0d);
    }

    public void decompose(double[][] dArr) {
        for (int i5 = 0; i5 < FastMath.min(dArr.length, dArr[0].length); i5++) {
            performHouseholderReflection(i5, dArr);
        }
    }

    public RealMatrix getH() {
        int i5;
        if (this.cachedH == null) {
            double[][] dArr = this.qrt;
            int length = dArr.length;
            int length2 = dArr[0].length;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length);
            int i6 = 0;
            while (i6 < length2) {
                int i7 = 0;
                while (true) {
                    i5 = i6 + 1;
                    if (i7 < FastMath.min(i5, length)) {
                        dArr2[i6][i7] = this.qrt[i7][i6] / (-this.rDiag[i7]);
                        i7++;
                    }
                }
                i6 = i5;
            }
            this.cachedH = MatrixUtils.createRealMatrix(dArr2);
        }
        return this.cachedH;
    }

    public RealMatrix getQ() {
        if (this.cachedQ == null) {
            this.cachedQ = getQT().transpose();
        }
        return this.cachedQ;
    }

    public RealMatrix getQT() {
        double d;
        if (this.cachedQT == null) {
            double[][] dArr = this.qrt;
            int length = dArr.length;
            int length2 = dArr[0].length;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length2);
            int i5 = length2 - 1;
            while (true) {
                d = 1.0d;
                if (i5 < FastMath.min(length2, length)) {
                    break;
                }
                dArr2[i5][i5] = 1.0d;
                i5--;
            }
            int iMin = FastMath.min(length2, length) - 1;
            while (iMin >= 0) {
                double[] dArr3 = this.qrt[iMin];
                dArr2[iMin][iMin] = d;
                if (dArr3[iMin] != 0.0d) {
                    for (int i6 = iMin; i6 < length2; i6++) {
                        double d6 = 0.0d;
                        for (int i7 = iMin; i7 < length2; i7++) {
                            d6 -= dArr2[i6][i7] * dArr3[i7];
                        }
                        double d7 = d6 / (this.rDiag[iMin] * dArr3[iMin]);
                        for (int i8 = iMin; i8 < length2; i8++) {
                            double[] dArr4 = dArr2[i6];
                            dArr4[i8] = ((-d7) * dArr3[i8]) + dArr4[i8];
                        }
                    }
                }
                iMin--;
                d = 1.0d;
            }
            this.cachedQT = MatrixUtils.createRealMatrix(dArr2);
        }
        return this.cachedQT;
    }

    public RealMatrix getR() {
        if (this.cachedR == null) {
            double[][] dArr = this.qrt;
            int length = dArr.length;
            int length2 = dArr[0].length;
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length);
            for (int iMin = FastMath.min(length2, length) - 1; iMin >= 0; iMin--) {
                dArr2[iMin][iMin] = this.rDiag[iMin];
                for (int i5 = iMin + 1; i5 < length; i5++) {
                    dArr2[iMin][i5] = this.qrt[i5][iMin];
                }
            }
            this.cachedR = MatrixUtils.createRealMatrix(dArr2);
        }
        return this.cachedR;
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.qrt, this.rDiag, this.threshold);
    }

    public void performHouseholderReflection(int i5, double[][] dArr) {
        double[] dArr2 = dArr[i5];
        double d = 0.0d;
        for (int i6 = i5; i6 < dArr2.length; i6++) {
            double d6 = dArr2[i6];
            d += d6 * d6;
        }
        double dSqrt = dArr2[i5] > 0.0d ? -FastMath.sqrt(d) : FastMath.sqrt(d);
        this.rDiag[i5] = dSqrt;
        if (dSqrt != 0.0d) {
            dArr2[i5] = dArr2[i5] - dSqrt;
            for (int i7 = i5 + 1; i7 < dArr.length; i7++) {
                double[] dArr3 = dArr[i7];
                double d7 = 0.0d;
                for (int i8 = i5; i8 < dArr3.length; i8++) {
                    d7 -= dArr3[i8] * dArr2[i8];
                }
                double d8 = d7 / (dArr2[i5] * dSqrt);
                for (int i9 = i5; i9 < dArr3.length; i9++) {
                    dArr3[i9] = dArr3[i9] - (dArr2[i9] * d8);
                }
            }
        }
    }

    public QRDecomposition(RealMatrix realMatrix, double d) {
        this.threshold = d;
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        this.qrt = realMatrix.transpose().getData();
        this.rDiag = new double[FastMath.min(rowDimension, columnDimension)];
        this.cachedQ = null;
        this.cachedQT = null;
        this.cachedR = null;
        this.cachedH = null;
        decompose(this.qrt);
    }
}
