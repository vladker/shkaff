package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LUDecomposition {
    private static final double DEFAULT_TOO_SMALL = 1.0E-11d;
    private RealMatrix cachedL;
    private RealMatrix cachedP;
    private RealMatrix cachedU;
    private boolean even;
    private final double[][] lu;
    private final int[] pivot;
    private boolean singular;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {
        private final double[][] lu;
        private final int[] pivot;
        private final boolean singular;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.pivot.length));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return !this.singular;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            int length = this.pivot.length;
            if (realVector.getDimension() != length) {
                throw new DimensionMismatchException(realVector.getDimension(), length);
            }
            if (this.singular) {
                throw new SingularMatrixException();
            }
            double[] dArr = new double[length];
            for (int i5 = 0; i5 < length; i5++) {
                dArr[i5] = realVector.getEntry(this.pivot[i5]);
            }
            int i6 = 0;
            while (i6 < length) {
                double d = dArr[i6];
                int i7 = i6 + 1;
                for (int i8 = i7; i8 < length; i8++) {
                    dArr[i8] = dArr[i8] - (this.lu[i8][i6] * d);
                }
                i6 = i7;
            }
            for (int i9 = length - 1; i9 >= 0; i9--) {
                double d6 = dArr[i9] / this.lu[i9][i9];
                dArr[i9] = d6;
                for (int i10 = 0; i10 < i9; i10++) {
                    dArr[i10] = dArr[i10] - (this.lu[i10][i9] * d6);
                }
            }
            return new ArrayRealVector(dArr, false);
        }

        private Solver(double[][] dArr, int[] iArr, boolean z6) {
            this.lu = dArr;
            this.pivot = iArr;
            this.singular = z6;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            int length = this.pivot.length;
            if (realMatrix.getRowDimension() == length) {
                if (!this.singular) {
                    int columnDimension = realMatrix.getColumnDimension();
                    double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, columnDimension);
                    for (int i5 = 0; i5 < length; i5++) {
                        double[] dArr2 = dArr[i5];
                        int i6 = this.pivot[i5];
                        for (int i7 = 0; i7 < columnDimension; i7++) {
                            dArr2[i7] = realMatrix.getEntry(i6, i7);
                        }
                    }
                    int i8 = 0;
                    while (i8 < length) {
                        double[] dArr3 = dArr[i8];
                        int i9 = i8 + 1;
                        for (int i10 = i9; i10 < length; i10++) {
                            double[] dArr4 = dArr[i10];
                            double d = this.lu[i10][i8];
                            for (int i11 = 0; i11 < columnDimension; i11++) {
                                dArr4[i11] = dArr4[i11] - (dArr3[i11] * d);
                            }
                        }
                        i8 = i9;
                    }
                    for (int i12 = length - 1; i12 >= 0; i12--) {
                        double[] dArr5 = dArr[i12];
                        double d6 = this.lu[i12][i12];
                        for (int i13 = 0; i13 < columnDimension; i13++) {
                            dArr5[i13] = dArr5[i13] / d6;
                        }
                        for (int i14 = 0; i14 < i12; i14++) {
                            double[] dArr6 = dArr[i14];
                            double d7 = this.lu[i14][i12];
                            for (int i15 = 0; i15 < columnDimension; i15++) {
                                dArr6[i15] = dArr6[i15] - (dArr5[i15] * d7);
                            }
                        }
                    }
                    return new Array2DRowRealMatrix(dArr, false);
                }
                throw new SingularMatrixException();
            }
            throw new DimensionMismatchException(realMatrix.getRowDimension(), length);
        }
    }

    public LUDecomposition(RealMatrix realMatrix) {
        this(realMatrix, DEFAULT_TOO_SMALL);
    }

    public double getDeterminant() {
        if (this.singular) {
            return 0.0d;
        }
        int length = this.pivot.length;
        double d = this.even ? 1.0d : -1.0d;
        for (int i5 = 0; i5 < length; i5++) {
            d *= this.lu[i5][i5];
        }
        return d;
    }

    public RealMatrix getL() {
        if (this.cachedL == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedL = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                double[] dArr = this.lu[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    this.cachedL.setEntry(i5, i6, dArr[i6]);
                }
                this.cachedL.setEntry(i5, i5, 1.0d);
            }
        }
        return this.cachedL;
    }

    public RealMatrix getP() {
        if (this.cachedP == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedP = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                this.cachedP.setEntry(i5, this.pivot[i5], 1.0d);
            }
        }
        return this.cachedP;
    }

    public int[] getPivot() {
        return (int[]) this.pivot.clone();
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.lu, this.pivot, this.singular);
    }

    public RealMatrix getU() {
        if (this.cachedU == null && !this.singular) {
            int length = this.pivot.length;
            this.cachedU = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                double[] dArr = this.lu[i5];
                for (int i6 = i5; i6 < length; i6++) {
                    this.cachedU.setEntry(i5, i6, dArr[i6]);
                }
            }
        }
        return this.cachedU;
    }

    public LUDecomposition(RealMatrix realMatrix, double d) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int columnDimension = realMatrix.getColumnDimension();
        this.lu = realMatrix.getData();
        this.pivot = new int[columnDimension];
        this.cachedL = null;
        this.cachedU = null;
        this.cachedP = null;
        for (int i5 = 0; i5 < columnDimension; i5++) {
            this.pivot[i5] = i5;
        }
        this.even = true;
        this.singular = false;
        int i6 = 0;
        while (i6 < columnDimension) {
            for (int i7 = 0; i7 < i6; i7++) {
                double[] dArr = this.lu[i7];
                double d6 = dArr[i6];
                for (int i8 = 0; i8 < i7; i8++) {
                    d6 -= dArr[i8] * this.lu[i8][i6];
                }
                dArr[i6] = d6;
            }
            double dAbs = Double.NEGATIVE_INFINITY;
            int i9 = i6;
            int i10 = i9;
            while (i9 < columnDimension) {
                double[] dArr2 = this.lu[i9];
                double d7 = dArr2[i6];
                for (int i11 = 0; i11 < i6; i11++) {
                    d7 -= dArr2[i11] * this.lu[i11][i6];
                }
                dArr2[i6] = d7;
                if (FastMath.abs(d7) > dAbs) {
                    dAbs = FastMath.abs(d7);
                    i10 = i9;
                }
                i9++;
            }
            if (FastMath.abs(this.lu[i10][i6]) < d) {
                this.singular = true;
                return;
            }
            if (i10 != i6) {
                double[][] dArr3 = this.lu;
                double[] dArr4 = dArr3[i10];
                double[] dArr5 = dArr3[i6];
                for (int i12 = 0; i12 < columnDimension; i12++) {
                    double d8 = dArr4[i12];
                    dArr4[i12] = dArr5[i12];
                    dArr5[i12] = d8;
                }
                int[] iArr = this.pivot;
                int i13 = iArr[i10];
                iArr[i10] = iArr[i6];
                iArr[i6] = i13;
                this.even = !this.even;
            }
            double d9 = this.lu[i6][i6];
            int i14 = i6 + 1;
            for (int i15 = i14; i15 < columnDimension; i15++) {
                double[] dArr6 = this.lu[i15];
                dArr6[i6] = dArr6[i6] / d9;
            }
            i6 = i14;
        }
    }
}
