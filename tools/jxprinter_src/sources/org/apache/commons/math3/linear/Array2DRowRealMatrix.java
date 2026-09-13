package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Array2DRowRealMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;
    private double[][] data;

    public Array2DRowRealMatrix() {
    }

    private void copyIn(double[][] dArr) {
        setSubMatrix(dArr, 0, 0);
    }

    private double[][] copyOut() {
        int rowDimension = getRowDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, getColumnDimension());
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr2 = this.data[i5];
            System.arraycopy(dArr2, 0, dArr[i5], 0, dArr2.length);
        }
        return dArr;
    }

    public Array2DRowRealMatrix add(Array2DRowRealMatrix array2DRowRealMatrix) {
        MatrixUtils.checkAdditionCompatible(this, array2DRowRealMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr2 = this.data[i5];
            double[] dArr3 = array2DRowRealMatrix.data[i5];
            double[] dArr4 = dArr[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                dArr4[i6] = dArr2[i6] + dArr3[i6];
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        double[] dArr = this.data[i5];
        dArr[i6] = dArr[i6] + d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix copy() {
        return new Array2DRowRealMatrix(copyOut(), false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix createMatrix(int i5, int i6) {
        return new Array2DRowRealMatrix(i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        double[] dArr;
        double[][] dArr2 = this.data;
        if (dArr2 == null || (dArr = dArr2[0]) == null) {
            return 0;
        }
        return dArr.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        return copyOut();
    }

    public double[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i5, int i6) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        return this.data[i5][i6];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        double[][] dArr = this.data;
        if (dArr == null) {
            return 0;
        }
        return dArr.length;
    }

    public Array2DRowRealMatrix multiply(Array2DRowRealMatrix array2DRowRealMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, array2DRowRealMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = array2DRowRealMatrix.getColumnDimension();
        int columnDimension2 = getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, columnDimension);
        double[] dArr2 = new double[columnDimension2];
        double[][] dArr3 = array2DRowRealMatrix.data;
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension2; i6++) {
                dArr2[i6] = dArr3[i6][i5];
            }
            for (int i7 = 0; i7 < rowDimension; i7++) {
                double[] dArr4 = this.data[i7];
                double d = 0.0d;
                for (int i8 = 0; i8 < columnDimension2; i8++) {
                    d += dArr4[i8] * dArr2[i8];
                }
                dArr[i7][i5] = d;
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        double[] dArr = this.data[i5];
        dArr[i6] = dArr[i6] * d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new DimensionMismatchException(dArr.length, columnDimension);
        }
        double[] dArr2 = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr3 = this.data[i5];
            double d = 0.0d;
            for (int i6 = 0; i6 < columnDimension; i6++) {
                d += dArr3[i6] * dArr[i6];
            }
            dArr2[i5] = d;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] dArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (dArr.length != rowDimension) {
            throw new DimensionMismatchException(dArr.length, rowDimension);
        }
        double[] dArr2 = new double[columnDimension];
        for (int i5 = 0; i5 < columnDimension; i5++) {
            double d = 0.0d;
            for (int i6 = 0; i6 < rowDimension; i6++) {
                d += this.data[i6][i5] * dArr[i6];
            }
            dArr2[i5] = d;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        this.data[i5][i6] = d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setSubMatrix(double[][] dArr, int i5, int i6) {
        if (this.data != null) {
            super.setSubMatrix(dArr, i5, i6);
            return;
        }
        if (i5 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, Integer.valueOf(i5));
        }
        if (i6 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, Integer.valueOf(i6));
        }
        MathUtils.checkNotNull(dArr);
        if (dArr.length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length = dArr[0].length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length, length);
        int i7 = 0;
        while (true) {
            double[][] dArr2 = this.data;
            if (i7 >= dArr2.length) {
                return;
            }
            double[] dArr3 = dArr[i7];
            if (dArr3.length != length) {
                throw new DimensionMismatchException(dArr[i7].length, length);
            }
            System.arraycopy(dArr3, 0, dArr2[i7 + i5], i6, length);
            i7++;
        }
    }

    public Array2DRowRealMatrix subtract(Array2DRowRealMatrix array2DRowRealMatrix) {
        MatrixUtils.checkSubtractionCompatible(this, array2DRowRealMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr2 = this.data[i5];
            double[] dArr3 = array2DRowRealMatrix.data[i5];
            double[] dArr4 = dArr[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                dArr4[i6] = dArr2[i6] - dArr3[i6];
            }
        }
        return new Array2DRowRealMatrix(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                double[] dArr = this.data[i6];
                dArr[i5] = realMatrixChangingVisitor.visit(i6, i5, dArr[i5]);
            }
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr = this.data[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                dArr[i6] = realMatrixChangingVisitor.visit(i5, i6, dArr[i6]);
            }
        }
        return realMatrixChangingVisitor.end();
    }

    public Array2DRowRealMatrix(int i5, int i6) {
        super(i5, i6);
        this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, i6);
    }

    public Array2DRowRealMatrix(double[][] dArr) {
        copyIn(dArr);
    }

    public Array2DRowRealMatrix(double[][] dArr, boolean z6) {
        if (z6) {
            copyIn(dArr);
            return;
        }
        if (dArr != null) {
            int length = dArr.length;
            if (length != 0) {
                int length2 = dArr[0].length;
                if (length2 != 0) {
                    for (int i5 = 1; i5 < length; i5++) {
                        if (dArr[i5].length != length2) {
                            throw new DimensionMismatchException(dArr[i5].length, length2);
                        }
                    }
                    this.data = dArr;
                    return;
                }
                throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
            }
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                realMatrixPreservingVisitor.visit(i6, i5, this.data[i6][i5]);
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double[] dArr = this.data[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixPreservingVisitor.visit(i5, i6, dArr[i6]);
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                double[] dArr = this.data[i9];
                dArr[i7] = realMatrixChangingVisitor.visit(i9, i7, dArr[i7]);
            }
            i7++;
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            double[] dArr = this.data[i5];
            for (int i9 = i7; i9 <= i8; i9++) {
                dArr[i9] = realMatrixChangingVisitor.visit(i5, i9, dArr[i9]);
            }
            i5++;
        }
        return realMatrixChangingVisitor.end();
    }

    public Array2DRowRealMatrix(double[] dArr) {
        int length = dArr.length;
        this.data = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        for (int i5 = 0; i5 < length; i5++) {
            this.data[i5][0] = dArr[i5];
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                realMatrixPreservingVisitor.visit(i9, i7, this.data[i9][i7]);
            }
            i7++;
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            double[] dArr = this.data[i5];
            for (int i9 = i7; i9 <= i8; i9++) {
                realMatrixPreservingVisitor.visit(i5, i9, dArr[i9]);
            }
            i5++;
        }
        return realMatrixPreservingVisitor.end();
    }
}
