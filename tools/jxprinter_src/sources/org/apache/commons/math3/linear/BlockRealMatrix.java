package org.apache.commons.math3.linear;

import androidx.collection.a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BlockRealMatrix extends AbstractRealMatrix implements Serializable {
    public static final int BLOCK_SIZE = 52;
    private static final long serialVersionUID = 4991895511313664478L;
    private final int blockColumns;
    private final int blockRows;
    private final double[][] blocks;
    private final int columns;
    private final int rows;

    public BlockRealMatrix(int i5, int i6) {
        super(i5, i6);
        this.rows = i5;
        this.columns = i6;
        this.blockRows = (i5 + 51) / 52;
        this.blockColumns = (i6 + 51) / 52;
        this.blocks = createBlocksLayout(i5, i6);
    }

    private int blockHeight(int i5) {
        if (i5 == this.blockRows - 1) {
            return this.rows - (i5 * 52);
        }
        return 52;
    }

    private int blockWidth(int i5) {
        if (i5 == this.blockColumns - 1) {
            return this.columns - (i5 * 52);
        }
        return 52;
    }

    private void copyBlockPart(double[] dArr, int i5, int i6, int i7, int i8, int i9, double[] dArr2, int i10, int i11, int i12) {
        int i13 = i9 - i8;
        int i14 = (i6 * i5) + i8;
        int i15 = (i11 * i10) + i12;
        while (i6 < i7) {
            System.arraycopy(dArr, i14, dArr2, i15, i13);
            i14 += i5;
            i15 += i10;
            i6++;
        }
    }

    public static double[][] createBlocksLayout(int i5, int i6) {
        int i7 = (i5 + 51) / 52;
        int i8 = (i6 + 51) / 52;
        double[][] dArr = new double[i7 * i8][];
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            int i11 = i10 * 52;
            int iMin = FastMath.min(i11 + 52, i5) - i11;
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = i12 * 52;
                dArr[i9] = new double[(FastMath.min(i13 + 52, i6) - i13) * iMin];
                i9++;
            }
        }
        return dArr;
    }

    public static double[][] toBlocksLayout(double[][] dArr) {
        int length = dArr.length;
        int i5 = 0;
        int length2 = dArr[0].length;
        int i6 = (length + 51) / 52;
        int i7 = (length2 + 51) / 52;
        for (double[] dArr2 : dArr) {
            int length3 = dArr2.length;
            if (length3 != length2) {
                throw new DimensionMismatchException(length2, length3);
            }
        }
        double[][] dArr3 = new double[i6 * i7][];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            int i10 = i8 * 52;
            int iMin = FastMath.min(i10 + 52, length);
            int i11 = iMin - i10;
            int i12 = i5;
            while (i12 < i7) {
                int i13 = i12 * 52;
                int iMin2 = FastMath.min(i13 + 52, length2) - i13;
                double[] dArr4 = new double[i11 * iMin2];
                dArr3[i9] = dArr4;
                int i14 = i5;
                int i15 = i10;
                while (i15 < iMin) {
                    System.arraycopy(dArr[i15], i13, dArr4, i14, iMin2);
                    i14 += iMin2;
                    i15++;
                    length = length;
                }
                i9++;
                i12++;
                i5 = 0;
            }
            i8++;
            i5 = 0;
        }
        return dArr3;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        int i7 = i5 / 52;
        int i8 = i6 / 52;
        int iBlockWidth = (i6 - (i8 * 52)) + ((i5 - (i7 * 52)) * blockWidth(i8));
        double[] dArr = this.blocks[(i7 * this.blockColumns) + i8];
        dArr[iBlockWidth] = dArr[iBlockWidth] + d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] getColumn(int i5) {
        MatrixUtils.checkColumnIndex(this, i5);
        double[] dArr = new double[this.rows];
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            double[] dArr2 = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                dArr[i8] = dArr2[(i10 * iBlockWidth) + i7];
                i10++;
                i8++;
            }
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector getColumnVector(int i5) {
        MatrixUtils.checkColumnIndex(this, i5);
        double[] dArr = new double[this.rows];
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            double[] dArr2 = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                dArr[i8] = dArr2[(i10 * iBlockWidth) + i7];
                i10++;
                i8++;
            }
        }
        return new ArrayRealVector(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, getRowDimension(), getColumnDimension());
        int i5 = this.columns - ((this.blockColumns - 1) * 52);
        for (int i6 = 0; i6 < this.blockRows; i6++) {
            int i7 = i6 * 52;
            int iMin = FastMath.min(i7 + 52, this.rows);
            int i8 = 0;
            int i9 = 0;
            while (i7 < iMin) {
                double[] dArr2 = dArr[i7];
                int i10 = this.blockColumns * i6;
                int i11 = 0;
                int i12 = 0;
                while (i11 < this.blockColumns - 1) {
                    System.arraycopy(this.blocks[i10], i8, dArr2, i12, 52);
                    i12 += 52;
                    i11++;
                    i10++;
                }
                System.arraycopy(this.blocks[i10], i9, dArr2, i12, i5);
                i8 += 52;
                i9 += i5;
                i7++;
            }
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int i5, int i6) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        int i7 = i5 / 52;
        int i8 = i6 / 52;
        return this.blocks[(i7 * this.blockColumns) + i8][(i6 - (i8 * 52)) + ((i5 - (i7 * 52)) * blockWidth(i8))];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getFrobeniusNorm() {
        double d = 0.0d;
        int i5 = 0;
        while (true) {
            double[][] dArr = this.blocks;
            if (i5 >= dArr.length) {
                return FastMath.sqrt(d);
            }
            for (double d6 : dArr[i5]) {
                d += d6 * d6;
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getNorm() {
        double[] dArr = new double[52];
        double dMax = 0.0d;
        for (int i5 = 0; i5 < this.blockColumns; i5++) {
            int iBlockWidth = blockWidth(i5);
            Arrays.fill(dArr, 0, iBlockWidth, 0.0d);
            for (int i6 = 0; i6 < this.blockRows; i6++) {
                int iBlockHeight = blockHeight(i6);
                double[] dArr2 = this.blocks[(this.blockColumns * i6) + i5];
                for (int i7 = 0; i7 < iBlockWidth; i7++) {
                    double dAbs = 0.0d;
                    for (int i8 = 0; i8 < iBlockHeight; i8++) {
                        dAbs = FastMath.abs(dArr2[(i8 * iBlockWidth) + i7]) + dAbs;
                    }
                    dArr[i7] = dArr[i7] + dAbs;
                }
            }
            for (int i9 = 0; i9 < iBlockWidth; i9++) {
                dMax = FastMath.max(dMax, dArr[i9]);
            }
        }
        return dMax;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] getRow(int i5) {
        MatrixUtils.checkRowIndex(this, i5);
        double[] dArr = new double[this.columns];
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, dArr, i8, iBlockWidth);
            i8 += iBlockWidth;
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealVector getRowVector(int i5) {
        MatrixUtils.checkRowIndex(this, i5);
        double[] dArr = new double[this.columns];
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, dArr, i8, iBlockWidth);
            i8 += iBlockWidth;
        }
        return new ArrayRealVector(dArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        int i7 = i5 / 52;
        int i8 = i6 / 52;
        int iBlockWidth = (i6 - (i8 * 52)) + ((i5 - (i7 * 52)) * blockWidth(i8));
        double[] dArr = this.blocks[(i7 * this.blockColumns) + i8];
        dArr[iBlockWidth] = dArr[iBlockWidth] * d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        if (dArr.length != this.columns) {
            throw new DimensionMismatchException(dArr.length, this.columns);
        }
        double[] dArr2 = new double[this.rows];
        for (int i5 = 0; i5 < this.blockRows; i5++) {
            int i6 = i5 * 52;
            int iMin = FastMath.min(i6 + 52, this.rows);
            int i7 = 0;
            while (true) {
                int i8 = this.blockColumns;
                if (i7 < i8) {
                    double[] dArr3 = this.blocks[(i8 * i5) + i7];
                    int i9 = i7 * 52;
                    int iMin2 = FastMath.min(i9 + 52, this.columns);
                    int i10 = 0;
                    for (int i11 = i6; i11 < iMin; i11++) {
                        double dA = 0.0d;
                        int i12 = i9;
                        while (i12 < iMin2 - 3) {
                            dA = a.A(dArr3[i10 + 3], dArr[i12 + 3], (dArr3[i10 + 2] * dArr[i12 + 2]) + (dArr3[i10 + 1] * dArr[i12 + 1]) + (dArr3[i10] * dArr[i12]), dA);
                            i10 += 4;
                            i12 += 4;
                        }
                        while (i12 < iMin2) {
                            dA = (dArr3[i10] * dArr[i12]) + dA;
                            i12++;
                            i10++;
                        }
                        dArr2[i11] = dArr2[i11] + dA;
                    }
                    i7++;
                }
            }
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] dArr) {
        double[] dArr2;
        if (dArr.length != this.rows) {
            throw new DimensionMismatchException(dArr.length, this.rows);
        }
        double[] dArr3 = new double[this.columns];
        for (int i5 = 0; i5 < this.blockColumns; i5++) {
            int iBlockWidth = blockWidth(i5);
            int i6 = iBlockWidth + iBlockWidth;
            int i7 = i6 + iBlockWidth;
            int i8 = i7 + iBlockWidth;
            int i9 = i5 * 52;
            int iMin = FastMath.min(i9 + 52, this.columns);
            for (int i10 = 0; i10 < this.blockRows; i10++) {
                double[] dArr4 = this.blocks[(this.blockColumns * i10) + i5];
                int i11 = i10 * 52;
                int iMin2 = FastMath.min(i11 + 52, this.rows);
                int i12 = i9;
                while (i12 < iMin) {
                    int i13 = i12 - i9;
                    int i14 = i11;
                    double dA = 0.0d;
                    while (true) {
                        dArr2 = dArr3;
                        if (i14 >= iMin2 - 3) {
                            break;
                        }
                        dA = a.A(dArr4[i13 + i7], dArr[i14 + 3], (dArr4[i13 + i6] * dArr[i14 + 2]) + (dArr4[i13 + iBlockWidth] * dArr[i14 + 1]) + (dArr4[i13] * dArr[i14]), dA);
                        i13 += i8;
                        i14 += 4;
                        dArr3 = dArr2;
                    }
                    while (i14 < iMin2) {
                        dA = (dArr4[i13] * dArr[i14]) + dA;
                        i13 += iBlockWidth;
                        i14++;
                    }
                    dArr2[i12] = dArr2[i12] + dA;
                    i12++;
                    dArr3 = dArr2;
                }
            }
        }
        return dArr3;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
        int i5 = 0;
        while (true) {
            double[][] dArr = blockRealMatrix.blocks;
            if (i5 >= dArr.length) {
                return blockRealMatrix;
            }
            double[] dArr2 = dArr[i5];
            double[] dArr3 = this.blocks[i5];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = dArr3[i6] * d;
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumn(int i5, double[] dArr) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        if (dArr.length != rowDimension) {
            throw new MatrixDimensionMismatchException(dArr.length, 1, rowDimension, 1);
        }
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int iBlockWidth = blockWidth(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockRows; i9++) {
            int iBlockHeight = blockHeight(i9);
            double[] dArr2 = this.blocks[(this.blockColumns * i9) + i6];
            int i10 = 0;
            while (i10 < iBlockHeight) {
                dArr2[(i10 * iBlockWidth) + i7] = dArr[i8];
                i10++;
                i8++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumnMatrix(int i5, RealMatrix realMatrix) {
        try {
            setColumnMatrix(i5, (BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            super.setColumnMatrix(i5, realMatrix);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setColumnVector(int i5, RealVector realVector) {
        try {
            setColumn(i5, ((ArrayRealVector) realVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setColumnVector(i5, realVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        int i7 = i5 / 52;
        int i8 = i6 / 52;
        this.blocks[(i7 * this.blockColumns) + i8][(i6 - (i8 * 52)) + ((i5 - (i7 * 52)) * blockWidth(i8))] = d;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRow(int i5, double[] dArr) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new MatrixDimensionMismatchException(1, dArr.length, 1, columnDimension);
        }
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int i8 = 0;
        for (int i9 = 0; i9 < this.blockColumns; i9++) {
            int iBlockWidth = blockWidth(i9);
            System.arraycopy(dArr, i8, this.blocks[(this.blockColumns * i6) + i9], i7 * iBlockWidth, iBlockWidth);
            i8 += iBlockWidth;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRowMatrix(int i5, RealMatrix realMatrix) {
        try {
            setRowMatrix(i5, (BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            super.setRowMatrix(i5, realMatrix);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setRowVector(int i5, RealVector realVector) {
        try {
            setRow(i5, ((ArrayRealVector) realVector).getDataRef());
        } catch (ClassCastException unused) {
            super.setRowVector(i5, realVector);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setSubMatrix(double[][] dArr, int i5, int i6) {
        BlockRealMatrix blockRealMatrix = this;
        int i7 = i5;
        int i8 = i6;
        MathUtils.checkNotNull(dArr);
        int length = dArr[0].length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        int length2 = dArr.length + i7;
        int i9 = i8 + length;
        MatrixUtils.checkSubMatrixIndex(blockRealMatrix, i7, length2 - 1, i8, i9 - 1);
        for (double[] dArr2 : dArr) {
            if (dArr2.length != length) {
                throw new DimensionMismatchException(length, dArr2.length);
            }
        }
        int i10 = i7 / 52;
        int i11 = (length2 + 51) / 52;
        int i12 = i8 / 52;
        int i13 = (i9 + 51) / 52;
        while (i10 < i11) {
            int iBlockHeight = blockRealMatrix.blockHeight(i10);
            int i14 = i10 * 52;
            int iMax = FastMath.max(i7, i14);
            int iMin = FastMath.min(length2, iBlockHeight + i14);
            int i15 = i12;
            while (i15 < i13) {
                int iBlockWidth = blockRealMatrix.blockWidth(i15);
                int i16 = i15 * 52;
                int iMax2 = FastMath.max(i8, i16);
                int iMin2 = FastMath.min(i9, i16 + iBlockWidth) - iMax2;
                double[] dArr3 = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i10) + i15];
                int i17 = iMax;
                while (i17 < iMin) {
                    int i18 = i17;
                    System.arraycopy(dArr[i17 - i5], iMax2 - i6, dArr3, (iMax2 - i16) + ((i18 - i14) * iBlockWidth), iMin2);
                    i17 = i18 + 1;
                    i10 = i10;
                }
                i15++;
                blockRealMatrix = this;
                i8 = i6;
            }
            i10++;
            blockRealMatrix = this;
            i7 = i5;
            i8 = i6;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        realMatrixChangingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        int i7 = 0;
        for (int i8 = 0; i8 < this.blockRows; i8++) {
            int i9 = i8 * 52;
            int iMin = FastMath.min(i9 + 52, this.rows);
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int i11 = i10 * 52;
                int iMin2 = FastMath.min(i11 + 52, this.columns);
                double[] dArr = this.blocks[i7];
                int i12 = 0;
                for (int i13 = i9; i13 < iMin; i13++) {
                    for (int i14 = i11; i14 < iMin2; i14++) {
                        dArr[i12] = realMatrixChangingVisitor.visit(i13, i14, dArr[i12]);
                        i12++;
                    }
                }
                i7++;
            }
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        realMatrixChangingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        for (int i7 = 0; i7 < this.blockRows; i7++) {
            int i8 = i7 * 52;
            int iMin = FastMath.min(i8 + 52, this.rows);
            for (int i9 = i8; i9 < iMin; i9++) {
                for (int i10 = 0; i10 < this.blockColumns; i10++) {
                    int iBlockWidth = blockWidth(i10);
                    int i11 = i10 * 52;
                    int iMin2 = FastMath.min(i11 + 52, this.columns);
                    double[] dArr = this.blocks[(this.blockColumns * i7) + i10];
                    int i12 = (i9 - i8) * iBlockWidth;
                    while (i11 < iMin2) {
                        dArr[i12] = realMatrixChangingVisitor.visit(i9, i11, dArr[i12]);
                        i12++;
                        i11++;
                    }
                }
            }
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix add(RealMatrix realMatrix) {
        try {
            return add((BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            MatrixUtils.checkAdditionCompatible(this, realMatrix);
            BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
            int i5 = 0;
            for (int i6 = 0; i6 < blockRealMatrix.blockRows; i6++) {
                for (int i7 = 0; i7 < blockRealMatrix.blockColumns; i7++) {
                    double[] dArr = blockRealMatrix.blocks[i5];
                    double[] dArr2 = this.blocks[i5];
                    int i8 = i6 * 52;
                    int iMin = FastMath.min(i8 + 52, this.rows);
                    int i9 = i7 * 52;
                    int iMin2 = FastMath.min(i9 + 52, this.columns);
                    int i10 = 0;
                    while (i8 < iMin) {
                        for (int i11 = i9; i11 < iMin2; i11++) {
                            dArr[i10] = realMatrix.getEntry(i8, i11) + dArr2[i10];
                            i10++;
                        }
                        i8++;
                    }
                    i5++;
                }
            }
            return blockRealMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix copy() {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
        int i5 = 0;
        while (true) {
            double[][] dArr = this.blocks;
            if (i5 >= dArr.length) {
                return blockRealMatrix;
            }
            double[] dArr2 = dArr[i5];
            System.arraycopy(dArr2, 0, blockRealMatrix.blocks[i5], 0, dArr2.length);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix createMatrix(int i5, int i6) {
        return new BlockRealMatrix(i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getColumnMatrix(int i5) {
        MatrixUtils.checkColumnIndex(this, i5);
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, 1);
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        int iBlockWidth = blockWidth(i6);
        double[] dArr = blockRealMatrix.blocks[0];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockRows; i10++) {
            int iBlockHeight = blockHeight(i10);
            double[] dArr2 = this.blocks[(this.blockColumns * i10) + i6];
            int i11 = 0;
            while (i11 < iBlockHeight) {
                if (i8 >= dArr.length) {
                    i9++;
                    dArr = blockRealMatrix.blocks[i9];
                    i8 = 0;
                }
                dArr[i8] = dArr2[(i11 * iBlockWidth) + i7];
                i11++;
                i8++;
            }
        }
        return blockRealMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getRowMatrix(int i5) {
        MatrixUtils.checkRowIndex(this, i5);
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(1, this.columns);
        int i6 = i5 / 52;
        int i7 = i5 - (i6 * 52);
        double[] dArr = blockRealMatrix.blocks[0];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockColumns; i10++) {
            int iBlockWidth = blockWidth(i10);
            double[] dArr2 = this.blocks[(this.blockColumns * i6) + i10];
            int length = dArr.length - i8;
            if (iBlockWidth > length) {
                int i11 = i7 * iBlockWidth;
                System.arraycopy(dArr2, i11, dArr, i8, length);
                i9++;
                dArr = blockRealMatrix.blocks[i9];
                int i12 = iBlockWidth - length;
                System.arraycopy(dArr2, i11, dArr, 0, i12);
                i8 = i12;
            } else {
                System.arraycopy(dArr2, i7 * iBlockWidth, dArr, i8, iBlockWidth);
                i8 += iBlockWidth;
            }
        }
        return blockRealMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix getSubMatrix(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix((i6 - i5) + 1, (i8 - i7) + 1);
        int i12 = i5 % 52;
        int i13 = i7 / 52;
        int i14 = i7 % 52;
        int i15 = i5 / 52;
        for (int i16 = 0; i16 < blockRealMatrix.blockRows; i16++) {
            int iBlockHeight = blockRealMatrix.blockHeight(i16);
            int i17 = i13;
            int i18 = 0;
            while (i18 < blockRealMatrix.blockColumns) {
                int iBlockWidth = blockRealMatrix.blockWidth(i18);
                double[] dArr = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i16) + i18];
                int i19 = (this.blockColumns * i15) + i17;
                int i20 = i17;
                int iBlockWidth2 = this.blockWidth(i20);
                int i21 = iBlockHeight + i12;
                int i22 = i21 - 52;
                int i23 = iBlockWidth + i14;
                int i24 = i23 - 52;
                if (i22 <= 0) {
                    i9 = i18;
                    i10 = i20;
                    int i25 = i12;
                    if (i24 > 0) {
                        int iBlockWidth3 = this.blockWidth(i10 + 1);
                        i12 = i25;
                        this.copyBlockPart(this.blocks[i19], iBlockWidth2, i12, i21, i14, 52, dArr, iBlockWidth, 0, 0);
                        i11 = i14;
                        this.copyBlockPart(this.blocks[i19 + 1], iBlockWidth3, i12, i21, 0, i24, dArr, iBlockWidth, 0, iBlockWidth - i24);
                        i14 = i11;
                    } else {
                        i12 = i25;
                        this.copyBlockPart(this.blocks[i19], iBlockWidth2, i12, i21, i14, i23, dArr, iBlockWidth, 0, 0);
                    }
                } else if (i24 > 0) {
                    int iBlockWidth4 = this.blockWidth(i20 + 1);
                    i9 = i18;
                    i10 = i20;
                    this.copyBlockPart(this.blocks[i19], iBlockWidth2, i12, 52, i14, 52, dArr, iBlockWidth, 0, 0);
                    i11 = i14;
                    int i26 = iBlockWidth - i24;
                    this.copyBlockPart(this.blocks[i19 + 1], iBlockWidth4, i12, 52, 0, i24, dArr, iBlockWidth, 0, i26);
                    int i27 = iBlockHeight - i22;
                    this.copyBlockPart(this.blocks[i19 + this.blockColumns], iBlockWidth2, 0, i22, i11, 52, dArr, iBlockWidth, i27, 0);
                    this.copyBlockPart(this.blocks[i19 + this.blockColumns + 1], iBlockWidth4, 0, i22, 0, i24, dArr, iBlockWidth, i27, i26);
                    i12 = i12;
                    i14 = i11;
                } else {
                    i9 = i18;
                    i10 = i20;
                    this.copyBlockPart(this.blocks[i19], iBlockWidth2, i12, 52, i14, i23, dArr, iBlockWidth, 0, 0);
                    this.copyBlockPart(this.blocks[i19 + this.blockColumns], iBlockWidth2, 0, i22, i14, i23, dArr, iBlockWidth, iBlockHeight - i22, 0);
                    i12 = i12;
                }
                i17 = i10 + 1;
                i18 = i9 + 1;
                this = this;
            }
            i15++;
        }
        return blockRealMatrix;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix multiply(RealMatrix realMatrix) {
        BlockRealMatrix blockRealMatrix = this;
        try {
            return blockRealMatrix.multiply((BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
            BlockRealMatrix blockRealMatrix2 = new BlockRealMatrix(blockRealMatrix.rows, realMatrix.getColumnDimension());
            int i5 = 0;
            int i6 = 0;
            while (i5 < blockRealMatrix2.blockRows) {
                int i7 = i5 * 52;
                int iMin = FastMath.min(i7 + 52, blockRealMatrix.rows);
                int i8 = 0;
                while (i8 < blockRealMatrix2.blockColumns) {
                    int i9 = i8 * 52;
                    int iMin2 = FastMath.min(i9 + 52, realMatrix.getColumnDimension());
                    double[] dArr = blockRealMatrix2.blocks[i6];
                    int i10 = 0;
                    while (i10 < blockRealMatrix.blockColumns) {
                        int iBlockWidth = blockRealMatrix.blockWidth(i10);
                        double[] dArr2 = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i5) + i10];
                        int i11 = i10 * 52;
                        int i12 = i7;
                        int i13 = 0;
                        while (i12 < iMin) {
                            int i14 = (i12 - i7) * iBlockWidth;
                            int i15 = i14 + iBlockWidth;
                            BlockRealMatrix blockRealMatrix3 = blockRealMatrix2;
                            int i16 = i9;
                            while (i16 < iMin2) {
                                double entry = 0.0d;
                                int i17 = i12;
                                int i18 = i5;
                                int i19 = i11;
                                for (int i20 = i14; i20 < i15; i20++) {
                                    entry = (realMatrix.getEntry(i19, i16) * dArr2[i20]) + entry;
                                    i19++;
                                }
                                dArr[i13] = dArr[i13] + entry;
                                i13++;
                                i16++;
                                i12 = i17;
                                i5 = i18;
                            }
                            i12++;
                            blockRealMatrix2 = blockRealMatrix3;
                        }
                        i10++;
                        blockRealMatrix = this;
                    }
                    i6++;
                    i8++;
                    blockRealMatrix = this;
                }
                i5++;
                blockRealMatrix = this;
            }
            return blockRealMatrix2;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix scalarAdd(double d) {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
        int i5 = 0;
        while (true) {
            double[][] dArr = blockRealMatrix.blocks;
            if (i5 >= dArr.length) {
                return blockRealMatrix;
            }
            double[] dArr2 = dArr[i5];
            double[] dArr3 = this.blocks[i5];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = dArr3[i6] + d;
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix subtract(RealMatrix realMatrix) {
        try {
            return subtract((BlockRealMatrix) realMatrix);
        } catch (ClassCastException unused) {
            MatrixUtils.checkSubtractionCompatible(this, realMatrix);
            BlockRealMatrix blockRealMatrix = new BlockRealMatrix(this.rows, this.columns);
            int i5 = 0;
            for (int i6 = 0; i6 < blockRealMatrix.blockRows; i6++) {
                for (int i7 = 0; i7 < blockRealMatrix.blockColumns; i7++) {
                    double[] dArr = blockRealMatrix.blocks[i5];
                    double[] dArr2 = this.blocks[i5];
                    int i8 = i6 * 52;
                    int iMin = FastMath.min(i8 + 52, this.rows);
                    int i9 = i7 * 52;
                    int iMin2 = FastMath.min(i9 + 52, this.columns);
                    int i10 = 0;
                    while (i8 < iMin) {
                        for (int i11 = i9; i11 < iMin2; i11++) {
                            dArr[i10] = dArr2[i10] - realMatrix.getEntry(i8, i11);
                            i10++;
                        }
                        i8++;
                    }
                    i5++;
                }
            }
            return blockRealMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public BlockRealMatrix transpose() {
        BlockRealMatrix blockRealMatrix = new BlockRealMatrix(getColumnDimension(), getRowDimension());
        int i5 = 0;
        for (int i6 = 0; i6 < this.blockColumns; i6++) {
            for (int i7 = 0; i7 < this.blockRows; i7++) {
                double[] dArr = blockRealMatrix.blocks[i5];
                double[] dArr2 = this.blocks[(this.blockColumns * i7) + i6];
                int i8 = i6 * 52;
                int iMin = FastMath.min(i8 + 52, this.columns);
                int i9 = i7 * 52;
                int iMin2 = FastMath.min(i9 + 52, this.rows);
                int i10 = 0;
                for (int i11 = i8; i11 < iMin; i11++) {
                    int i12 = iMin - i8;
                    int i13 = i11 - i8;
                    for (int i14 = i9; i14 < iMin2; i14++) {
                        dArr[i10] = dArr2[i13];
                        i10++;
                        i13 += i12;
                    }
                }
                i5++;
            }
        }
        return blockRealMatrix;
    }

    public void setColumnMatrix(int i5, BlockRealMatrix blockRealMatrix) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        if (blockRealMatrix.getRowDimension() == rowDimension && blockRealMatrix.getColumnDimension() == 1) {
            int i6 = i5 / 52;
            int i7 = i5 - (i6 * 52);
            int iBlockWidth = blockWidth(i6);
            double[] dArr = blockRealMatrix.blocks[0];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.blockRows; i10++) {
                int iBlockHeight = blockHeight(i10);
                double[] dArr2 = this.blocks[(this.blockColumns * i10) + i6];
                int i11 = 0;
                while (i11 < iBlockHeight) {
                    if (i8 >= dArr.length) {
                        i9++;
                        dArr = blockRealMatrix.blocks[i9];
                        i8 = 0;
                    }
                    dArr2[(i11 * iBlockWidth) + i7] = dArr[i8];
                    i11++;
                    i8++;
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(blockRealMatrix.getRowDimension(), blockRealMatrix.getColumnDimension(), rowDimension, 1);
    }

    public void setRowMatrix(int i5, BlockRealMatrix blockRealMatrix) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        if (blockRealMatrix.getRowDimension() == 1 && blockRealMatrix.getColumnDimension() == columnDimension) {
            int i6 = i5 / 52;
            int i7 = i5 - (i6 * 52);
            double[] dArr = blockRealMatrix.blocks[0];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int iBlockWidth = blockWidth(i10);
                double[] dArr2 = this.blocks[(this.blockColumns * i6) + i10];
                int length = dArr.length - i8;
                if (iBlockWidth > length) {
                    int i11 = i7 * iBlockWidth;
                    System.arraycopy(dArr, i8, dArr2, i11, length);
                    i9++;
                    dArr = blockRealMatrix.blocks[i9];
                    int i12 = iBlockWidth - length;
                    System.arraycopy(dArr, 0, dArr2, i11, i12);
                    i8 = i12;
                } else {
                    System.arraycopy(dArr, i8, dArr2, i7 * iBlockWidth, iBlockWidth);
                    i8 += iBlockWidth;
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(blockRealMatrix.getRowDimension(), blockRealMatrix.getColumnDimension(), 1, columnDimension);
    }

    public BlockRealMatrix(double[][] dArr) {
        this(dArr.length, dArr[0].length, toBlocksLayout(dArr), false);
    }

    public BlockRealMatrix(int i5, int i6, double[][] dArr, boolean z6) {
        super(i5, i6);
        this.rows = i5;
        this.columns = i6;
        int i7 = (i5 + 51) / 52;
        this.blockRows = i7;
        int i8 = (i6 + 51) / 52;
        this.blockColumns = i8;
        if (z6) {
            this.blocks = new double[i7 * i8][];
        } else {
            this.blocks = dArr;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.blockRows; i10++) {
            int iBlockHeight = blockHeight(i10);
            int i11 = 0;
            while (i11 < this.blockColumns) {
                if (dArr[i9].length != blockWidth(i11) * iBlockHeight) {
                    throw new DimensionMismatchException(dArr[i9].length, iBlockHeight * blockWidth(i11));
                }
                if (z6) {
                    this.blocks[i9] = (double[]) dArr[i9].clone();
                }
                i11++;
                i9++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        realMatrixPreservingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        int i7 = 0;
        for (int i8 = 0; i8 < this.blockRows; i8++) {
            int i9 = i8 * 52;
            int iMin = FastMath.min(i9 + 52, this.rows);
            for (int i10 = 0; i10 < this.blockColumns; i10++) {
                int i11 = i10 * 52;
                int iMin2 = FastMath.min(i11 + 52, this.columns);
                double[] dArr = this.blocks[i7];
                int i12 = 0;
                for (int i13 = i9; i13 < iMin; i13++) {
                    for (int i14 = i11; i14 < iMin2; i14++) {
                        realMatrixPreservingVisitor.visit(i13, i14, dArr[i12]);
                        i12++;
                    }
                }
                i7++;
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int i5 = this.rows;
        int i6 = this.columns;
        realMatrixPreservingVisitor.start(i5, i6, 0, i5 - 1, 0, i6 - 1);
        for (int i7 = 0; i7 < this.blockRows; i7++) {
            int i8 = i7 * 52;
            int iMin = FastMath.min(i8 + 52, this.rows);
            for (int i9 = i8; i9 < iMin; i9++) {
                for (int i10 = 0; i10 < this.blockColumns; i10++) {
                    int iBlockWidth = blockWidth(i10);
                    int i11 = i10 * 52;
                    int iMin2 = FastMath.min(i11 + 52, this.columns);
                    double[] dArr = this.blocks[(this.blockColumns * i7) + i10];
                    int i12 = (i9 - i8) * iBlockWidth;
                    while (i11 < iMin2) {
                        realMatrixPreservingVisitor.visit(i9, i11, dArr[i12]);
                        i12++;
                        i11++;
                    }
                }
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    public BlockRealMatrix add(BlockRealMatrix blockRealMatrix) {
        MatrixUtils.checkAdditionCompatible(this, blockRealMatrix);
        BlockRealMatrix blockRealMatrix2 = new BlockRealMatrix(this.rows, this.columns);
        int i5 = 0;
        while (true) {
            double[][] dArr = blockRealMatrix2.blocks;
            if (i5 >= dArr.length) {
                return blockRealMatrix2;
            }
            double[] dArr2 = dArr[i5];
            double[] dArr3 = this.blocks[i5];
            double[] dArr4 = blockRealMatrix.blocks[i5];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = dArr3[i6] + dArr4[i6];
            }
            i5++;
        }
    }

    public BlockRealMatrix subtract(BlockRealMatrix blockRealMatrix) {
        MatrixUtils.checkSubtractionCompatible(this, blockRealMatrix);
        BlockRealMatrix blockRealMatrix2 = new BlockRealMatrix(this.rows, this.columns);
        int i5 = 0;
        while (true) {
            double[][] dArr = blockRealMatrix2.blocks;
            if (i5 >= dArr.length) {
                return blockRealMatrix2;
            }
            double[] dArr2 = dArr[i5];
            double[] dArr3 = this.blocks[i5];
            double[] dArr4 = blockRealMatrix.blocks[i5];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = dArr3[i6] - dArr4[i6];
            }
            i5++;
        }
    }

    public BlockRealMatrix multiply(BlockRealMatrix blockRealMatrix) {
        double[] dArr;
        BlockRealMatrix blockRealMatrix2 = this;
        BlockRealMatrix blockRealMatrix3 = blockRealMatrix;
        MatrixUtils.checkMultiplicationCompatible(this, blockRealMatrix);
        BlockRealMatrix blockRealMatrix4 = new BlockRealMatrix(blockRealMatrix2.rows, blockRealMatrix3.columns);
        int i5 = 0;
        int i6 = 0;
        while (i5 < blockRealMatrix4.blockRows) {
            int i7 = i5 * 52;
            int iMin = FastMath.min(i7 + 52, blockRealMatrix2.rows);
            int i8 = 0;
            while (i8 < blockRealMatrix4.blockColumns) {
                int iBlockWidth = blockRealMatrix4.blockWidth(i8);
                int i9 = iBlockWidth + iBlockWidth;
                int i10 = i9 + iBlockWidth;
                int i11 = i10 + iBlockWidth;
                double[] dArr2 = blockRealMatrix4.blocks[i6];
                int i12 = 0;
                while (i12 < blockRealMatrix2.blockColumns) {
                    int iBlockWidth2 = blockRealMatrix2.blockWidth(i12);
                    BlockRealMatrix blockRealMatrix5 = blockRealMatrix4;
                    double[] dArr3 = blockRealMatrix2.blocks[(blockRealMatrix2.blockColumns * i5) + i12];
                    double[] dArr4 = blockRealMatrix3.blocks[(blockRealMatrix3.blockColumns * i12) + i8];
                    int i13 = i7;
                    int i14 = 0;
                    while (i13 < iMin) {
                        int i15 = (i13 - i7) * iBlockWidth2;
                        double[] dArr5 = dArr4;
                        int i16 = i15 + iBlockWidth2;
                        int i17 = 0;
                        while (i17 < iBlockWidth) {
                            double dA = 0.0d;
                            int i18 = i17;
                            int i19 = i18;
                            int i20 = i15;
                            while (true) {
                                dArr = dArr3;
                                if (i20 >= i16 - 3) {
                                    break;
                                }
                                dA = a.A(dArr[i20 + 3], dArr5[i19 + i10], (dArr[i20 + 2] * dArr5[i19 + i9]) + (dArr[i20 + 1] * dArr5[i19 + iBlockWidth]) + (dArr[i20] * dArr5[i19]), dA);
                                i20 += 4;
                                i19 += i11;
                                dArr3 = dArr;
                            }
                            while (i20 < i16) {
                                dA = (dArr[i20] * dArr5[i19]) + dA;
                                i19 += iBlockWidth;
                                i20++;
                            }
                            dArr2[i14] = dArr2[i14] + dA;
                            i14++;
                            i17 = i18 + 1;
                            dArr3 = dArr;
                        }
                        i13++;
                        dArr4 = dArr5;
                    }
                    i12++;
                    blockRealMatrix2 = this;
                    blockRealMatrix3 = blockRealMatrix;
                    blockRealMatrix4 = blockRealMatrix5;
                }
                i6++;
                i8++;
                blockRealMatrix2 = this;
                blockRealMatrix3 = blockRealMatrix;
            }
            i5++;
            blockRealMatrix2 = this;
            blockRealMatrix3 = blockRealMatrix;
        }
        return blockRealMatrix4;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        BlockRealMatrix blockRealMatrix = this;
        MatrixUtils.checkSubMatrixIndex(blockRealMatrix, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(blockRealMatrix.rows, blockRealMatrix.columns, i5, i6, i7, i8);
        int i9 = i5 / 52;
        while (i9 < (i6 / 52) + 1) {
            int i10 = i9 * 52;
            int iMax = FastMath.max(i5, i10);
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 52, i6 + 1);
            int i12 = i7 / 52;
            while (i12 < (i8 / 52) + 1) {
                int iBlockWidth = blockRealMatrix.blockWidth(i12);
                int i13 = i12 * 52;
                int iMax2 = FastMath.max(i7, i13);
                int i14 = i12 + 1;
                int iMin2 = FastMath.min(i14 * 52, i8 + 1);
                double[] dArr = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i9) + i12];
                int i15 = iMax;
                while (i15 < iMin) {
                    int i16 = (((i15 - i10) * iBlockWidth) + iMax2) - i13;
                    int i17 = iMax2;
                    while (i17 < iMin2) {
                        dArr[i16] = realMatrixChangingVisitor.visit(i15, i17, dArr[i16]);
                        i16++;
                        i17++;
                        i9 = i9;
                        i10 = i10;
                        iMax = iMax;
                    }
                    i15++;
                    iMax = iMax;
                }
                blockRealMatrix = this;
                i12 = i14;
                iMax = iMax;
            }
            blockRealMatrix = this;
            i9 = i11;
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(this.rows, this.columns, i5, i6, i7, i8);
        int i9 = i5 / 52;
        while (i9 < (i6 / 52) + 1) {
            int i10 = i9 * 52;
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 52, i6 + 1);
            for (int iMax = FastMath.max(i5, i10); iMax < iMin; iMax++) {
                int i12 = i7 / 52;
                while (i12 < (i8 / 52) + 1) {
                    int iBlockWidth = blockWidth(i12);
                    int i13 = i12 * 52;
                    int iMax2 = FastMath.max(i7, i13);
                    int i14 = i12 + 1;
                    int iMin2 = FastMath.min(i14 * 52, i8 + 1);
                    double[] dArr = this.blocks[(this.blockColumns * i9) + i12];
                    int i15 = (((iMax - i10) * iBlockWidth) + iMax2) - i13;
                    while (iMax2 < iMin2) {
                        dArr[i15] = realMatrixChangingVisitor.visit(iMax, iMax2, dArr[i15]);
                        i15++;
                        iMax2++;
                    }
                    i12 = i14;
                }
            }
            i9 = i11;
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        BlockRealMatrix blockRealMatrix = this;
        MatrixUtils.checkSubMatrixIndex(blockRealMatrix, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(blockRealMatrix.rows, blockRealMatrix.columns, i5, i6, i7, i8);
        int i9 = i5 / 52;
        while (i9 < (i6 / 52) + 1) {
            int i10 = i9 * 52;
            int iMax = FastMath.max(i5, i10);
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 52, i6 + 1);
            int i12 = i7 / 52;
            while (i12 < (i8 / 52) + 1) {
                int iBlockWidth = blockRealMatrix.blockWidth(i12);
                int i13 = i12 * 52;
                int iMax2 = FastMath.max(i7, i13);
                int i14 = i12 + 1;
                int iMin2 = FastMath.min(i14 * 52, i8 + 1);
                double[] dArr = blockRealMatrix.blocks[(blockRealMatrix.blockColumns * i9) + i12];
                int i15 = iMax;
                while (i15 < iMin) {
                    int i16 = (((i15 - i10) * iBlockWidth) + iMax2) - i13;
                    int i17 = iMax2;
                    while (i17 < iMin2) {
                        realMatrixPreservingVisitor.visit(i15, i17, dArr[i16]);
                        i16++;
                        i17++;
                        i9 = i9;
                        i10 = i10;
                        iMax = iMax;
                    }
                    i15++;
                    iMax = iMax;
                }
                blockRealMatrix = this;
                i12 = i14;
                iMax = iMax;
            }
            blockRealMatrix = this;
            i9 = i11;
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(this.rows, this.columns, i5, i6, i7, i8);
        int i9 = i5 / 52;
        while (i9 < (i6 / 52) + 1) {
            int i10 = i9 * 52;
            int i11 = i9 + 1;
            int iMin = FastMath.min(i11 * 52, i6 + 1);
            for (int iMax = FastMath.max(i5, i10); iMax < iMin; iMax++) {
                int i12 = i7 / 52;
                while (i12 < (i8 / 52) + 1) {
                    int iBlockWidth = blockWidth(i12);
                    int i13 = i12 * 52;
                    int iMax2 = FastMath.max(i7, i13);
                    int i14 = i12 + 1;
                    int iMin2 = FastMath.min(i14 * 52, i8 + 1);
                    double[] dArr = this.blocks[(this.blockColumns * i9) + i12];
                    int i15 = (((iMax - i10) * iBlockWidth) + iMax2) - i13;
                    while (iMax2 < iMin2) {
                        realMatrixPreservingVisitor.visit(iMax, iMax2, dArr[i15]);
                        i15++;
                        iMax2++;
                    }
                    i12 = i14;
                }
            }
            i9 = i11;
        }
        return realMatrixPreservingVisitor.end();
    }
}
