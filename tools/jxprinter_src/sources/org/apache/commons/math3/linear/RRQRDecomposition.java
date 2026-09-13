package org.apache.commons.math3.linear;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RRQRDecomposition extends QRDecomposition {
    private RealMatrix cachedP;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f6808p;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Solver implements DecompositionSolver {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private RealMatrix f6809p;
        private final DecompositionSolver upper;

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return solve(MatrixUtils.createRealIdentityMatrix(this.f6809p.getRowDimension()));
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public boolean isNonSingular() {
            return this.upper.isNonSingular();
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector realVector) {
            return this.f6809p.operate(this.upper.solve(realVector));
        }

        private Solver(DecompositionSolver decompositionSolver, RealMatrix realMatrix) {
            this.upper = decompositionSolver;
            this.f6809p = realMatrix;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix solve(RealMatrix realMatrix) {
            return this.f6809p.multiply(this.upper.solve(realMatrix));
        }
    }

    public RRQRDecomposition(RealMatrix realMatrix) {
        this(realMatrix, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    public void decompose(double[][] dArr) {
        this.f6808p = new int[dArr.length];
        int i5 = 0;
        while (true) {
            int[] iArr = this.f6808p;
            if (i5 >= iArr.length) {
                super.decompose(dArr);
                return;
            } else {
                iArr[i5] = i5;
                i5++;
            }
        }
    }

    public RealMatrix getP() {
        if (this.cachedP == null) {
            int length = this.f6808p.length;
            this.cachedP = MatrixUtils.createRealMatrix(length, length);
            for (int i5 = 0; i5 < length; i5++) {
                this.cachedP.setEntry(this.f6808p[i5], i5, 1.0d);
            }
        }
        return this.cachedP;
    }

    public int getRank(double d) {
        RealMatrix r6 = getR();
        int rowDimension = r6.getRowDimension();
        int columnDimension = r6.getColumnDimension();
        double frobeniusNorm = r6.getFrobeniusNorm();
        int i5 = 1;
        double d6 = frobeniusNorm;
        while (i5 < FastMath.min(rowDimension, columnDimension)) {
            double frobeniusNorm2 = r6.getSubMatrix(i5, rowDimension - 1, i5, columnDimension - 1).getFrobeniusNorm();
            if (frobeniusNorm2 == 0.0d || (frobeniusNorm2 / d6) * frobeniusNorm < d) {
                break;
            }
            i5++;
            d6 = frobeniusNorm2;
        }
        return i5;
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    public DecompositionSolver getSolver() {
        return new Solver(super.getSolver(), getP());
    }

    @Override // org.apache.commons.math3.linear.QRDecomposition
    public void performHouseholderReflection(int i5, double[][] dArr) {
        int i6 = i5;
        int i7 = i6;
        double d = 0.0d;
        while (i6 < dArr.length) {
            int i8 = 0;
            double d6 = 0.0d;
            while (true) {
                double[] dArr2 = dArr[i6];
                if (i8 >= dArr2.length) {
                    break;
                }
                double d7 = dArr2[i8];
                d6 += d7 * d7;
                i8++;
            }
            if (d6 > d) {
                i7 = i6;
                d = d6;
            }
            i6++;
        }
        if (i7 != i5) {
            double[] dArr3 = dArr[i5];
            dArr[i5] = dArr[i7];
            dArr[i7] = dArr3;
            int[] iArr = this.f6808p;
            int i9 = iArr[i5];
            iArr[i5] = iArr[i7];
            iArr[i7] = i9;
        }
        super.performHouseholderReflection(i5, dArr);
    }

    public RRQRDecomposition(RealMatrix realMatrix, double d) {
        super(realMatrix, d);
    }
}
