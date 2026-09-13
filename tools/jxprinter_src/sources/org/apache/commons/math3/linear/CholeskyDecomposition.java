package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CholeskyDecomposition {
    public static final double DEFAULT_ABSOLUTE_POSITIVITY_THRESHOLD = 1.0E-10d;
    public static final double DEFAULT_RELATIVE_SYMMETRY_THRESHOLD = 1.0E-15d;
    private RealMatrix cachedL;
    private RealMatrix cachedLT;
    private double[][] lTData;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {
        private final double[][] lTData;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.lTData.length));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return true;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            int length = this.lTData.length;
            if (realVector.getDimension() != length) {
                throw new DimensionMismatchException(realVector.getDimension(), length);
            }
            double[] array = realVector.toArray();
            int i5 = 0;
            while (i5 < length) {
                double[] dArr = this.lTData[i5];
                double d = array[i5] / dArr[i5];
                array[i5] = d;
                i5++;
                for (int i6 = i5; i6 < length; i6++) {
                    array[i6] = array[i6] - (dArr[i6] * d);
                }
            }
            for (int i7 = length - 1; i7 >= 0; i7--) {
                double d6 = array[i7] / this.lTData[i7][i7];
                array[i7] = d6;
                for (int i8 = 0; i8 < i7; i8++) {
                    array[i8] = array[i8] - (this.lTData[i8][i7] * d6);
                }
            }
            return new ArrayRealVector(array, false);
        }

        private Solver(double[][] dArr) {
            this.lTData = dArr;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            int length = this.lTData.length;
            if (realMatrix.getRowDimension() == length) {
                int columnDimension = realMatrix.getColumnDimension();
                double[][] data = realMatrix.getData();
                int i5 = 0;
                while (i5 < length) {
                    double[] dArr = this.lTData[i5];
                    double d = dArr[i5];
                    double[] dArr2 = data[i5];
                    for (int i6 = 0; i6 < columnDimension; i6++) {
                        dArr2[i6] = dArr2[i6] / d;
                    }
                    i5++;
                    for (int i7 = i5; i7 < length; i7++) {
                        double[] dArr3 = data[i7];
                        double d6 = dArr[i7];
                        for (int i8 = 0; i8 < columnDimension; i8++) {
                            dArr3[i8] = dArr3[i8] - (dArr2[i8] * d6);
                        }
                    }
                }
                for (int i9 = length - 1; i9 >= 0; i9--) {
                    double d7 = this.lTData[i9][i9];
                    double[] dArr4 = data[i9];
                    for (int i10 = 0; i10 < columnDimension; i10++) {
                        dArr4[i10] = dArr4[i10] / d7;
                    }
                    for (int i11 = 0; i11 < i9; i11++) {
                        double[] dArr5 = data[i11];
                        double d8 = this.lTData[i11][i9];
                        for (int i12 = 0; i12 < columnDimension; i12++) {
                            dArr5[i12] = dArr5[i12] - (dArr4[i12] * d8);
                        }
                    }
                }
                return new Array2DRowRealMatrix(data);
            }
            throw new DimensionMismatchException(realMatrix.getRowDimension(), length);
        }
    }

    public CholeskyDecomposition(RealMatrix realMatrix) {
        this(realMatrix, 1.0E-15d, 1.0E-10d);
    }

    public double getDeterminant() {
        double d = 1.0d;
        int i5 = 0;
        while (true) {
            double[][] dArr = this.lTData;
            if (i5 >= dArr.length) {
                return d;
            }
            double d6 = dArr[i5][i5];
            d *= d6 * d6;
            i5++;
        }
    }

    public RealMatrix getL() {
        if (this.cachedL == null) {
            this.cachedL = getLT().transpose();
        }
        return this.cachedL;
    }

    public RealMatrix getLT() {
        if (this.cachedLT == null) {
            this.cachedLT = MatrixUtils.createRealMatrix(this.lTData);
        }
        return this.cachedLT;
    }

    public DecompositionSolver getSolver() {
        return new Solver(this.lTData);
    }

    public CholeskyDecomposition(RealMatrix realMatrix, double d, double d6) {
        if (!realMatrix.isSquare()) {
            throw new NonSquareMatrixException(realMatrix.getRowDimension(), realMatrix.getColumnDimension());
        }
        int rowDimension = realMatrix.getRowDimension();
        this.lTData = realMatrix.getData();
        this.cachedL = null;
        this.cachedLT = null;
        int i5 = 0;
        while (i5 < rowDimension) {
            double[] dArr = this.lTData[i5];
            int i6 = i5 + 1;
            int i7 = i6;
            while (i7 < rowDimension) {
                double[] dArr2 = this.lTData[i7];
                double d7 = dArr[i7];
                double d8 = dArr2[i5];
                int i8 = i5;
                if (FastMath.abs(d7 - d8) > FastMath.max(FastMath.abs(d7), FastMath.abs(d8)) * d) {
                    throw new NonSymmetricMatrixException(i8, i7, d);
                }
                dArr2[i8] = 0.0d;
                i7++;
                i5 = i8;
            }
            i5 = i6;
        }
        for (int i9 = 0; i9 < rowDimension; i9++) {
            double[] dArr3 = this.lTData[i9];
            double d9 = dArr3[i9];
            if (d9 <= d6) {
                throw new NonPositiveDefiniteMatrixException(dArr3[i9], i9, d6);
            }
            double dSqrt = FastMath.sqrt(d9);
            dArr3[i9] = dSqrt;
            double d10 = 1.0d / dSqrt;
            for (int i10 = rowDimension - 1; i10 > i9; i10--) {
                dArr3[i10] = dArr3[i10] * d10;
                double[] dArr4 = this.lTData[i10];
                for (int i11 = i10; i11 < rowDimension; i11++) {
                    dArr4[i11] = dArr4[i11] - (dArr3[i10] * dArr3[i11]);
                }
            }
        }
    }
}
