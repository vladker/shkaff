package org.apache.commons.math3.linear;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractRealMatrix extends RealLinearOperator implements RealMatrix {
    private static final RealMatrixFormat DEFAULT_FORMAT;

    static {
        RealMatrixFormat realMatrixFormat = RealMatrixFormat.getInstance(Locale.US);
        DEFAULT_FORMAT = realMatrixFormat;
        realMatrixFormat.getFormat().setMinimumFractionDigits(1);
    }

    public AbstractRealMatrix() {
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix add(RealMatrix realMatrix) {
        MatrixUtils.checkAdditionCompatible(this, realMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixCreateMatrix.setEntry(i5, i6, realMatrix.getEntry(i5, i6) + getEntry(i5, i6));
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void addToEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        setEntry(i5, i6, getEntry(i5, i6) + d);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract RealMatrix copy();

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void copySubMatrix(int i5, int i6, int i7, int i8, final double[][] dArr) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        int i9 = (i6 + 1) - i5;
        int i10 = (i8 + 1) - i7;
        if (dArr.length < i9 || dArr[0].length < i10) {
            throw new MatrixDimensionMismatchException(dArr.length, dArr[0].length, i9, i10);
        }
        for (int i11 = 1; i11 < i9; i11++) {
            if (dArr[i11].length < i10) {
                throw new MatrixDimensionMismatchException(dArr.length, dArr[i11].length, i9, i10);
            }
        }
        walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.4
            private int startColumn;
            private int startRow;

            @Override // org.apache.commons.math3.linear.DefaultRealMatrixPreservingVisitor, org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void start(int i12, int i13, int i14, int i15, int i16, int i17) {
                this.startRow = i14;
                this.startColumn = i16;
            }

            @Override // org.apache.commons.math3.linear.DefaultRealMatrixPreservingVisitor, org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i12, int i13, double d) {
                dArr[i12 - this.startRow][i13 - this.startColumn] = d;
            }
        }, i5, i6, i7, i8);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract RealMatrix createMatrix(int i5, int i6);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RealMatrix)) {
            return false;
        }
        RealMatrix realMatrix = (RealMatrix) obj;
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (realMatrix.getColumnDimension() != columnDimension || realMatrix.getRowDimension() != rowDimension) {
            return false;
        }
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                if (getEntry(i5, i6) != realMatrix.getEntry(i5, i6)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[] getColumn(int i5) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        double[] dArr = new double[rowDimension];
        for (int i6 = 0; i6 < rowDimension; i6++) {
            dArr[i6] = getEntry(i6, i5);
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix getColumnMatrix(int i5) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, 1);
        for (int i6 = 0; i6 < rowDimension; i6++) {
            realMatrixCreateMatrix.setEntry(i6, 0, getEntry(i6, i5));
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealVector getColumnVector(int i5) {
        return new ArrayRealVector(getColumn(i5), false);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, getRowDimension(), getColumnDimension());
        for (int i5 = 0; i5 < dArr.length; i5++) {
            double[] dArr2 = dArr[i5];
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = getEntry(i5, i6);
            }
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract double getEntry(int i5, int i6);

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double getFrobeniusNorm() {
        return walkInOptimizedOrder(new RealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.2
            private double sum;

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public double end() {
                return FastMath.sqrt(this.sum);
            }

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
                this.sum = 0.0d;
            }

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i5, int i6, double d) {
                this.sum = (d * d) + this.sum;
            }
        });
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double getNorm() {
        return walkInColumnOrder(new RealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.1
            private double columnSum;
            private double endRow;
            private double maxColSum;

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public double end() {
                return this.maxColSum;
            }

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
                this.endRow = i8;
                this.columnSum = 0.0d;
                this.maxColSum = 0.0d;
            }

            @Override // org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i5, int i6, double d) {
                double dAbs = FastMath.abs(d) + this.columnSum;
                this.columnSum = dAbs;
                if (i5 == this.endRow) {
                    this.maxColSum = FastMath.max(this.maxColSum, dAbs);
                    this.columnSum = 0.0d;
                }
            }
        });
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[] getRow(int i5) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        double[] dArr = new double[columnDimension];
        for (int i6 = 0; i6 < columnDimension; i6++) {
            dArr[i6] = getEntry(i5, i6);
        }
        return dArr;
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix getRowMatrix(int i5) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(1, columnDimension);
        for (int i6 = 0; i6 < columnDimension; i6++) {
            realMatrixCreateMatrix.setEntry(0, i6, getEntry(i5, i6));
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealVector getRowVector(int i5) {
        return new ArrayRealVector(getRow(i5), false);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix getSubMatrix(int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        RealMatrix realMatrixCreateMatrix = createMatrix((i6 - i5) + 1, (i8 - i7) + 1);
        for (int i9 = i5; i9 <= i6; i9++) {
            for (int i10 = i7; i10 <= i8; i10++) {
                realMatrixCreateMatrix.setEntry(i9 - i5, i10 - i7, getEntry(i9, i10));
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double getTrace() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (rowDimension != columnDimension) {
            throw new NonSquareMatrixException(rowDimension, columnDimension);
        }
        double entry = 0.0d;
        for (int i5 = 0; i5 < rowDimension; i5++) {
            entry += getEntry(i5, i5);
        }
        return entry;
    }

    public int hashCode() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        int iHash = ((217 + rowDimension) * 31) + columnDimension;
        for (int i5 = 0; i5 < rowDimension; i5++) {
            int i6 = 0;
            while (i6 < columnDimension) {
                int i7 = i6 + 1;
                iHash = (iHash * 31) + (MathUtils.hash(getEntry(i5, i6)) * ((i7 * 17) + ((i5 + 1) * 11)));
                i6 = i7;
            }
        }
        return iHash;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public boolean isSquare() {
        return getColumnDimension() == getRowDimension();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix realMatrix) {
        MatrixUtils.checkMultiplicationCompatible(this, realMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = realMatrix.getColumnDimension();
        int columnDimension2 = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                double entry = 0.0d;
                for (int i7 = 0; i7 < columnDimension2; i7++) {
                    entry += realMatrix.getEntry(i7, i6) * getEntry(i5, i7);
                }
                realMatrixCreateMatrix.setEntry(i5, i6, entry);
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void multiplyEntry(int i5, int i6, double d) {
        MatrixUtils.checkMatrixIndex(this, i5, i6);
        setEntry(i5, i6, getEntry(i5, i6) * d);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[] operate(double[] dArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new DimensionMismatchException(dArr.length, columnDimension);
        }
        double[] dArr2 = new double[rowDimension];
        for (int i5 = 0; i5 < rowDimension; i5++) {
            double entry = 0.0d;
            for (int i6 = 0; i6 < columnDimension; i6++) {
                entry += getEntry(i5, i6) * dArr[i6];
            }
            dArr2[i5] = entry;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix power(int i5) {
        if (i5 < 0) {
            throw new NotPositiveException(LocalizedFormats.NOT_POSITIVE_EXPONENT, Integer.valueOf(i5));
        }
        if (!isSquare()) {
            throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
        }
        if (i5 == 0) {
            return MatrixUtils.createRealIdentityMatrix(getRowDimension());
        }
        if (i5 == 1) {
            return copy();
        }
        char[] charArray = Integer.toBinaryString(i5 - 1).toCharArray();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int i7 = -1;
        for (int i8 = 0; i8 < charArray.length; i8++) {
            if (charArray[i8] == '1') {
                int length = (charArray.length - i8) - 1;
                arrayList.add(Integer.valueOf(length));
                if (i7 == -1) {
                    i7 = length;
                }
            }
        }
        RealMatrix[] realMatrixArr = new RealMatrix[i7 + 1];
        realMatrixArr[0] = copy();
        for (int i9 = 1; i9 <= i7; i9++) {
            RealMatrix realMatrix = realMatrixArr[i9 - 1];
            realMatrixArr[i9] = realMatrix.multiply(realMatrix);
        }
        RealMatrix realMatrixCopy = copy();
        int size = arrayList.size();
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            realMatrixCopy = realMatrixCopy.multiply(realMatrixArr[((Integer) obj).intValue()]);
        }
        return realMatrixCopy;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix preMultiply(RealMatrix realMatrix) {
        return realMatrix.multiply(this);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarAdd(double d) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixCreateMatrix.setEntry(i5, i6, getEntry(i5, i6) + d);
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix scalarMultiply(double d) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixCreateMatrix.setEntry(i5, i6, getEntry(i5, i6) * d);
            }
        }
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setColumn(int i5, double[] dArr) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        if (dArr.length != rowDimension) {
            throw new MatrixDimensionMismatchException(dArr.length, 1, rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, dArr[i6]);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setColumnMatrix(int i5, RealMatrix realMatrix) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        if (realMatrix.getRowDimension() != rowDimension || realMatrix.getColumnDimension() != 1) {
            throw new MatrixDimensionMismatchException(realMatrix.getRowDimension(), realMatrix.getColumnDimension(), rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, realMatrix.getEntry(i6, 0));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setColumnVector(int i5, RealVector realVector) {
        MatrixUtils.checkColumnIndex(this, i5);
        int rowDimension = getRowDimension();
        if (realVector.getDimension() != rowDimension) {
            throw new MatrixDimensionMismatchException(realVector.getDimension(), 1, rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, realVector.getEntry(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract void setEntry(int i5, int i6, double d);

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setRow(int i5, double[] dArr) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        if (dArr.length != columnDimension) {
            throw new MatrixDimensionMismatchException(1, dArr.length, 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, dArr[i6]);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setRowMatrix(int i5, RealMatrix realMatrix) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        if (realMatrix.getRowDimension() != 1 || realMatrix.getColumnDimension() != columnDimension) {
            throw new MatrixDimensionMismatchException(realMatrix.getRowDimension(), realMatrix.getColumnDimension(), 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, realMatrix.getEntry(0, i6));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setRowVector(int i5, RealVector realVector) {
        MatrixUtils.checkRowIndex(this, i5);
        int columnDimension = getColumnDimension();
        if (realVector.getDimension() != columnDimension) {
            throw new MatrixDimensionMismatchException(1, realVector.getDimension(), 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, realVector.getEntry(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void setSubMatrix(double[][] dArr, int i5, int i6) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length2 = dArr[0].length;
        if (length2 == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        for (int i7 = 1; i7 < length; i7++) {
            if (dArr[i7].length != length2) {
                throw new DimensionMismatchException(length2, dArr[i7].length);
            }
        }
        MatrixUtils.checkRowIndex(this, i5);
        MatrixUtils.checkColumnIndex(this, i6);
        MatrixUtils.checkRowIndex(this, (length + i5) - 1);
        MatrixUtils.checkColumnIndex(this, (length2 + i6) - 1);
        for (int i8 = 0; i8 < length; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                setEntry(i5 + i8, i6 + i9, dArr[i8][i9]);
            }
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix subtract(RealMatrix realMatrix) {
        MatrixUtils.checkSubtractionCompatible(this, realMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        RealMatrix realMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixCreateMatrix.setEntry(i5, i6, getEntry(i5, i6) - realMatrix.getEntry(i5, i6));
            }
        }
        return realMatrixCreateMatrix;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String name = getClass().getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(DEFAULT_FORMAT.format(this));
        return sb.toString();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix transpose() {
        final RealMatrix realMatrixCreateMatrix = createMatrix(getColumnDimension(), getRowDimension());
        walkInOptimizedOrder(new DefaultRealMatrixPreservingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.5
            @Override // org.apache.commons.math3.linear.DefaultRealMatrixPreservingVisitor, org.apache.commons.math3.linear.RealMatrixPreservingVisitor
            public void visit(int i5, int i6, double d) {
                realMatrixCreateMatrix.setEntry(i6, i5, d);
            }
        });
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                setEntry(i6, i5, realMatrixChangingVisitor.visit(i6, i5, getEntry(i6, i5)));
            }
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        return walkInRowOrder(realMatrixChangingVisitor);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                setEntry(i5, i6, realMatrixChangingVisitor.visit(i5, i6, getEntry(i5, i6)));
            }
        }
        return realMatrixChangingVisitor.end();
    }

    public AbstractRealMatrix(int i5, int i6) {
        if (i5 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        if (i6 < 1) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[] preMultiply(double[] dArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (dArr.length != rowDimension) {
            throw new DimensionMismatchException(dArr.length, rowDimension);
        }
        double[] dArr2 = new double[columnDimension];
        for (int i5 = 0; i5 < columnDimension; i5++) {
            double entry = 0.0d;
            for (int i6 = 0; i6 < rowDimension; i6++) {
                entry += getEntry(i6, i5) * dArr[i6];
            }
            dArr2[i5] = entry;
        }
        return dArr2;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        return walkInRowOrder(realMatrixPreservingVisitor);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        return walkInRowOrder(realMatrixChangingVisitor, i5, i6, i7, i8);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix getSubMatrix(final int[] iArr, final int[] iArr2) {
        MatrixUtils.checkSubMatrixIndex(this, iArr, iArr2);
        RealMatrix realMatrixCreateMatrix = createMatrix(iArr.length, iArr2.length);
        realMatrixCreateMatrix.walkInOptimizedOrder(new DefaultRealMatrixChangingVisitor() { // from class: org.apache.commons.math3.linear.AbstractRealMatrix.3
            @Override // org.apache.commons.math3.linear.DefaultRealMatrixChangingVisitor, org.apache.commons.math3.linear.RealMatrixChangingVisitor
            public double visit(int i5, int i6, double d) {
                return AbstractRealMatrix.this.getEntry(iArr[i5], iArr2[i6]);
            }
        });
        return realMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        return walkInRowOrder(realMatrixPreservingVisitor, i5, i6, i7, i8);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void copySubMatrix(int[] iArr, int[] iArr2, double[][] dArr) {
        MatrixUtils.checkSubMatrixIndex(this, iArr, iArr2);
        int length = iArr2.length;
        if (dArr.length >= iArr.length && dArr[0].length >= length) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                double[] dArr2 = dArr[i5];
                if (dArr2.length >= length) {
                    for (int i6 = 0; i6 < iArr2.length; i6++) {
                        dArr2[i6] = getEntry(iArr[i5], iArr2[i6]);
                    }
                } else {
                    throw new MatrixDimensionMismatchException(dArr.length, dArr2.length, iArr.length, iArr2.length);
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(dArr.length, dArr[0].length, iArr.length, iArr2.length);
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.RealMatrix
    public RealVector operate(RealVector realVector) {
        try {
            return new ArrayRealVector(operate(((ArrayRealVector) realVector).getDataRef()), false);
        } catch (ClassCastException unused) {
            int rowDimension = getRowDimension();
            int columnDimension = getColumnDimension();
            if (realVector.getDimension() == columnDimension) {
                double[] dArr = new double[rowDimension];
                for (int i5 = 0; i5 < rowDimension; i5++) {
                    double entry = 0.0d;
                    for (int i6 = 0; i6 < columnDimension; i6++) {
                        entry += realVector.getEntry(i6) * getEntry(i5, i6);
                    }
                    dArr[i5] = entry;
                }
                return new ArrayRealVector(dArr, false);
            }
            throw new DimensionMismatchException(realVector.getDimension(), columnDimension);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                realMatrixPreservingVisitor.visit(i6, i5, getEntry(i6, i5));
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        realMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                realMatrixPreservingVisitor.visit(i5, i6, getEntry(i5, i6));
            }
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealVector preMultiply(RealVector realVector) {
        try {
            return new ArrayRealVector(preMultiply(((ArrayRealVector) realVector).getDataRef()), false);
        } catch (ClassCastException unused) {
            int rowDimension = getRowDimension();
            int columnDimension = getColumnDimension();
            if (realVector.getDimension() == rowDimension) {
                double[] dArr = new double[columnDimension];
                for (int i5 = 0; i5 < columnDimension; i5++) {
                    double entry = 0.0d;
                    for (int i6 = 0; i6 < rowDimension; i6++) {
                        entry += realVector.getEntry(i6) * getEntry(i6, i5);
                    }
                    dArr[i5] = entry;
                }
                return new ArrayRealVector(dArr, false);
            }
            throw new DimensionMismatchException(realVector.getDimension(), rowDimension);
        }
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                setEntry(i9, i7, realMatrixChangingVisitor.visit(i9, i7, getEntry(i9, i7)));
            }
            i7++;
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor realMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            for (int i9 = i7; i9 <= i8; i9++) {
                setEntry(i5, i9, realMatrixChangingVisitor.visit(i5, i9, getEntry(i5, i9)));
            }
            i5++;
        }
        return realMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                realMatrixPreservingVisitor.visit(i9, i7, getEntry(i9, i7));
            }
            i7++;
        }
        return realMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor realMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        MatrixUtils.checkSubMatrixIndex(this, i5, i6, i7, i8);
        realMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            for (int i9 = i7; i9 <= i8; i9++) {
                realMatrixPreservingVisitor.visit(i5, i9, getEntry(i5, i9));
            }
            i5++;
        }
        return realMatrixPreservingVisitor.end();
    }
}
