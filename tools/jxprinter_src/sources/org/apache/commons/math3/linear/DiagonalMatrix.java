package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DiagonalMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 20121229;
    private final double[] data;

    public DiagonalMatrix(int i5) {
        super(i5, i5);
        this.data = new double[i5];
    }

    private void ensureZero(double d) {
        if (!Precision.equals(0.0d, d, 1)) {
            throw new NumberIsTooLargeException(Double.valueOf(FastMath.abs(d)), 0, true);
        }
    }

    public DiagonalMatrix add(DiagonalMatrix diagonalMatrix) {
        MatrixUtils.checkAdditionCompatible(this, diagonalMatrix);
        int rowDimension = getRowDimension();
        double[] dArr = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            dArr[i5] = this.data[i5] + diagonalMatrix.data[i5];
        }
        return new DiagonalMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int i5, int i6, double d) {
        if (i5 != i6) {
            ensureZero(d);
            return;
        }
        MatrixUtils.checkRowIndex(this, i5);
        double[] dArr = this.data;
        dArr[i5] = dArr[i5] + d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix copy() {
        return new DiagonalMatrix(this.data);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix createMatrix(int i5, int i6) {
        if (i5 == i6) {
            return new DiagonalMatrix(i5);
        }
        throw new DimensionMismatchException(i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        int rowDimension = getRowDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, rowDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            dArr[i5][i5] = this.data[i5];
        }
        return dArr;
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i5, int i6) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        if (i5 == i6) {
            return this.data[i5];
        }
        return 0.0d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.data.length;
    }

    public DiagonalMatrix inverse() {
        return inverse(0.0d);
    }

    public boolean isSingular(double d) {
        int i5 = 0;
        while (true) {
            double[] dArr = this.data;
            if (i5 >= dArr.length) {
                return false;
            }
            double d6 = d;
            if (Precision.equals(dArr[i5], 0.0d, d6)) {
                return true;
            }
            i5++;
            d = d6;
        }
    }

    public DiagonalMatrix multiply(DiagonalMatrix diagonalMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, diagonalMatrix);
        int rowDimension = getRowDimension();
        double[] dArr = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            dArr[i5] = this.data[i5] * diagonalMatrix.data[i5];
        }
        return new DiagonalMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int i5, int i6, double d) {
        if (i5 == i6) {
            MatrixUtils.checkRowIndex(this, i5);
            double[] dArr = this.data;
            dArr[i5] = dArr[i5] * d;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        return multiply(new DiagonalMatrix(dArr, false)).getDataRef();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] dArr) {
        return operate(dArr);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i5, int i6, double d) {
        if (i5 != i6) {
            ensureZero(d);
        } else {
            MatrixUtils.checkRowIndex(this, i5);
            this.data[i5] = d;
        }
    }

    public DiagonalMatrix subtract(DiagonalMatrix diagonalMatrix) {
        MatrixUtils.checkSubtractionCompatible(this, diagonalMatrix);
        int rowDimension = getRowDimension();
        double[] dArr = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            dArr[i5] = this.data[i5] - diagonalMatrix.data[i5];
        }
        return new DiagonalMatrix(dArr, false);
    }

    public DiagonalMatrix inverse(double d) {
        if (isSingular(d)) {
            throw new SingularMatrixException();
        }
        double[] dArr = new double[this.data.length];
        int i5 = 0;
        while (true) {
            double[] dArr2 = this.data;
            if (i5 >= dArr2.length) {
                return new DiagonalMatrix(dArr, false);
            }
            dArr[i5] = 1.0d / dArr2[i5];
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector preMultiply(RealVector realVector) {
        return MatrixUtils.createRealVector(preMultiply(realVector instanceof ArrayRealVector ? ((ArrayRealVector) realVector).getDataRef() : realVector.toArray()));
    }

    public DiagonalMatrix(double[] dArr) {
        this(dArr, true);
    }

    public DiagonalMatrix(double[] dArr, boolean z6) {
        MathUtils.checkNotNull(dArr);
        this.data = z6 ? (double[]) dArr.clone() : dArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix realMatrix) {
        if (realMatrix instanceof DiagonalMatrix) {
            return multiply((DiagonalMatrix) realMatrix);
        }
        MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
        int rowDimension = realMatrix.getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                dArr[i5][i6] = realMatrix.getEntry(i5, i6) * this.data[i5];
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }
}
