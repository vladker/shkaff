package org.apache.commons.math3.linear;

import java.util.ArrayList;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractFieldMatrix<T extends FieldElement<T>> implements FieldMatrix<T> {
    private final Field<T> field;

    public AbstractFieldMatrix() {
        this.field = null;
    }

    @Deprecated
    public static <T extends FieldElement<T>> T[][] buildArray(Field<T> field, int i5, int i6) {
        return (T[][]) ((FieldElement[][]) MathArrays.buildArray(field, i5, i6));
    }

    public static <T extends FieldElement<T>> Field<T> extractField(T[][] tArr) {
        if (tArr == null) {
            throw new NullArgumentException();
        }
        if (tArr.length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        T[] tArr2 = tArr[0];
        if (tArr2.length != 0) {
            return tArr2[0].getField();
        }
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> add(FieldMatrix<T> fieldMatrix) {
        checkAdditionCompatible(fieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixCreateMatrix.setEntry(i5, i6, (FieldElement) getEntry(i5, i6).add(fieldMatrix.getEntry(i5, i6)));
            }
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void addToEntry(int i5, int i6, T t6);

    public void checkAdditionCompatible(FieldMatrix<T> fieldMatrix) {
        if (getRowDimension() != fieldMatrix.getRowDimension() || getColumnDimension() != fieldMatrix.getColumnDimension()) {
            throw new MatrixDimensionMismatchException(fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension(), getRowDimension(), getColumnDimension());
        }
    }

    public void checkColumnIndex(int i5) {
        if (i5 < 0 || i5 >= getColumnDimension()) {
            throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(getColumnDimension() - 1));
        }
    }

    public void checkMultiplicationCompatible(FieldMatrix<T> fieldMatrix) {
        if (getColumnDimension() != fieldMatrix.getRowDimension()) {
            throw new DimensionMismatchException(fieldMatrix.getRowDimension(), getColumnDimension());
        }
    }

    public void checkRowIndex(int i5) {
        if (i5 < 0 || i5 >= getRowDimension()) {
            throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(getRowDimension() - 1));
        }
    }

    public void checkSubMatrixIndex(int i5, int i6, int i7, int i8) {
        checkRowIndex(i5);
        checkRowIndex(i6);
        if (i6 < i5) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        checkColumnIndex(i7);
        checkColumnIndex(i8);
        if (i8 < i7) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(i8), Integer.valueOf(i7), true);
        }
    }

    public void checkSubtractionCompatible(FieldMatrix<T> fieldMatrix) {
        if (getRowDimension() != fieldMatrix.getRowDimension() || getColumnDimension() != fieldMatrix.getColumnDimension()) {
            throw new MatrixDimensionMismatchException(fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension(), getRowDimension(), getColumnDimension());
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract FieldMatrix<T> copy();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void copySubMatrix(int i5, int i6, int i7, int i8, final T[][] tArr) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        int i9 = (i6 + 1) - i5;
        int i10 = (i8 + 1) - i7;
        if (tArr.length < i9 || tArr[0].length < i10) {
            throw new MatrixDimensionMismatchException(tArr.length, tArr[0].length, i9, i10);
        }
        walkInOptimizedOrder(new DefaultFieldMatrixPreservingVisitor<T>(this.field.getZero()) { // from class: org.apache.commons.math3.linear.AbstractFieldMatrix.2
            private int startColumn;
            private int startRow;

            @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
            public void start(int i11, int i12, int i13, int i14, int i15, int i16) {
                this.startRow = i13;
                this.startColumn = i15;
            }

            @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
            public void visit(int i11, int i12, T t6) {
                tArr[i11 - this.startRow][i12 - this.startColumn] = t6;
            }
        }, i5, i6, i7, i8);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract FieldMatrix<T> createMatrix(int i5, int i6);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldMatrix)) {
            return false;
        }
        FieldMatrix fieldMatrix = (FieldMatrix) obj;
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (fieldMatrix.getColumnDimension() != columnDimension || fieldMatrix.getRowDimension() != rowDimension) {
            return false;
        }
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                if (!getEntry(i5, i6).equals(fieldMatrix.getEntry(i5, i6))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] getColumn(int i5) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, rowDimension));
        for (int i6 = 0; i6 < rowDimension; i6++) {
            tArr[i6] = getEntry(i6, i5);
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getColumnMatrix(int i5) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, 1);
        for (int i6 = 0; i6 < rowDimension; i6++) {
            fieldMatrixCreateMatrix.setEntry(i6, 0, getEntry(i6, i5));
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getColumnVector(int i5) {
        return new ArrayFieldVector((Field) this.field, getColumn(i5), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[][] getData() {
        T[][] tArr = (T[][]) ((FieldElement[][]) MathArrays.buildArray(this.field, getRowDimension(), getColumnDimension()));
        for (int i5 = 0; i5 < tArr.length; i5++) {
            FieldElement[] fieldElementArr = tArr[i5];
            for (int i6 = 0; i6 < fieldElementArr.length; i6++) {
                fieldElementArr[i6] = getEntry(i5, i6);
            }
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract T getEntry(int i5, int i6);

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public Field<T> getField() {
        return this.field;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] getRow(int i5) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, columnDimension));
        for (int i6 = 0; i6 < columnDimension; i6++) {
            tArr[i6] = getEntry(i5, i6);
        }
        return tArr;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getRowMatrix(int i5) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(1, columnDimension);
        for (int i6 = 0; i6 < columnDimension; i6++) {
            fieldMatrixCreateMatrix.setEntry(0, i6, getEntry(i5, i6));
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> getRowVector(int i5) {
        return new ArrayFieldVector((Field) this.field, getRow(i5), false);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix((i6 - i5) + 1, (i8 - i7) + 1);
        for (int i9 = i5; i9 <= i6; i9++) {
            for (int i10 = i7; i10 <= i8; i10++) {
                fieldMatrixCreateMatrix.setEntry(i9 - i5, i10 - i7, getEntry(i9, i10));
            }
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T getTrace() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (rowDimension != columnDimension) {
            throw new NonSquareMatrixException(rowDimension, columnDimension);
        }
        T zero = this.field.getZero();
        for (int i5 = 0; i5 < rowDimension; i5++) {
            zero = (T) zero.add(getEntry(i5, i5));
        }
        return zero;
    }

    public int hashCode() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        int iHashCode = ((9999422 + rowDimension) * 31) + columnDimension;
        for (int i5 = 0; i5 < rowDimension; i5++) {
            int i6 = 0;
            while (i6 < columnDimension) {
                int i7 = i6 + 1;
                iHashCode = (iHashCode * 31) + (getEntry(i5, i6).hashCode() * ((i7 * 17) + ((i5 + 1) * 11)));
                i6 = i7;
            }
        }
        return iHashCode;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public boolean isSquare() {
        return getColumnDimension() == getRowDimension();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> fieldMatrix) {
        checkMultiplicationCompatible(fieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = fieldMatrix.getColumnDimension();
        int columnDimension2 = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                T zero = this.field.getZero();
                for (int i7 = 0; i7 < columnDimension2; i7++) {
                    zero = (FieldElement) zero.add(getEntry(i5, i7).multiply(fieldMatrix.getEntry(i7, i6)));
                }
                fieldMatrixCreateMatrix.setEntry(i5, i6, zero);
            }
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void multiplyEntry(int i5, int i6, T t6);

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] operate(T[] tArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (tArr.length != columnDimension) {
            throw new DimensionMismatchException(tArr.length, columnDimension);
        }
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, rowDimension));
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T zero = this.field.getZero();
            for (int i6 = 0; i6 < columnDimension; i6++) {
                zero = (T) zero.add(getEntry(i5, i6).multiply(tArr[i6]));
            }
            tArr2[i5] = zero;
        }
        return tArr2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> power(int i5) {
        if (i5 < 0) {
            throw new NotPositiveException(Integer.valueOf(i5));
        }
        if (!isSquare()) {
            throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
        }
        if (i5 == 0) {
            return MatrixUtils.createFieldIdentityMatrix(getField(), getRowDimension());
        }
        if (i5 == 1) {
            return copy();
        }
        char[] charArray = Integer.toBinaryString(i5 - 1).toCharArray();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (int i7 = 0; i7 < charArray.length; i7++) {
            if (charArray[i7] == '1') {
                arrayList.add(Integer.valueOf((charArray.length - i7) - 1));
            }
        }
        ArrayList arrayList2 = new ArrayList(charArray.length);
        arrayList2.add(0, copy());
        for (int i8 = 1; i8 < charArray.length; i8++) {
            FieldMatrix<T> fieldMatrix = (FieldMatrix) arrayList2.get(i8 - 1);
            arrayList2.add(i8, fieldMatrix.multiply(fieldMatrix));
        }
        FieldMatrix<T> fieldMatrixCopy = copy();
        int size = arrayList.size();
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            fieldMatrixCopy = fieldMatrixCopy.multiply((FieldMatrix) arrayList2.get(((Integer) obj).intValue()));
        }
        return fieldMatrixCopy;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> preMultiply(FieldMatrix<T> fieldMatrix) {
        return fieldMatrix.multiply(this);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarAdd(T t6) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixCreateMatrix.setEntry(i5, i6, (FieldElement) getEntry(i5, i6).add(t6));
            }
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> scalarMultiply(T t6) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixCreateMatrix.setEntry(i5, i6, (FieldElement) getEntry(i5, i6).multiply(t6));
            }
        }
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumn(int i5, T[] tArr) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        if (tArr.length != rowDimension) {
            throw new MatrixDimensionMismatchException(tArr.length, 1, rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, tArr[i6]);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumnMatrix(int i5, FieldMatrix<T> fieldMatrix) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        if (fieldMatrix.getRowDimension() != rowDimension || fieldMatrix.getColumnDimension() != 1) {
            throw new MatrixDimensionMismatchException(fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension(), rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, fieldMatrix.getEntry(i6, 0));
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setColumnVector(int i5, FieldVector<T> fieldVector) {
        checkColumnIndex(i5);
        int rowDimension = getRowDimension();
        if (fieldVector.getDimension() != rowDimension) {
            throw new MatrixDimensionMismatchException(fieldVector.getDimension(), 1, rowDimension, 1);
        }
        for (int i6 = 0; i6 < rowDimension; i6++) {
            setEntry(i6, i5, fieldVector.getEntry(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void setEntry(int i5, int i6, T t6);

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRow(int i5, T[] tArr) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        if (tArr.length != columnDimension) {
            throw new MatrixDimensionMismatchException(1, tArr.length, 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, tArr[i6]);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRowMatrix(int i5, FieldMatrix<T> fieldMatrix) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        if (fieldMatrix.getRowDimension() != 1 || fieldMatrix.getColumnDimension() != columnDimension) {
            throw new MatrixDimensionMismatchException(fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension(), 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, fieldMatrix.getEntry(0, i6));
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setRowVector(int i5, FieldVector<T> fieldVector) {
        checkRowIndex(i5);
        int columnDimension = getColumnDimension();
        if (fieldVector.getDimension() != columnDimension) {
            throw new MatrixDimensionMismatchException(1, fieldVector.getDimension(), 1, columnDimension);
        }
        for (int i6 = 0; i6 < columnDimension; i6++) {
            setEntry(i5, i6, fieldVector.getEntry(i6));
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void setSubMatrix(T[][] tArr, int i5, int i6) {
        if (tArr == null) {
            throw new NullArgumentException();
        }
        int length = tArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length2 = tArr[0].length;
        if (length2 == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        for (int i7 = 1; i7 < length; i7++) {
            if (tArr[i7].length != length2) {
                throw new DimensionMismatchException(length2, tArr[i7].length);
            }
        }
        checkRowIndex(i5);
        checkColumnIndex(i6);
        checkRowIndex((length + i5) - 1);
        checkColumnIndex((length2 + i6) - 1);
        for (int i8 = 0; i8 < length; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                setEntry(i5 + i8, i6 + i9, tArr[i8][i9]);
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> subtract(FieldMatrix<T> fieldMatrix) {
        checkSubtractionCompatible(fieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixCreateMatrix.setEntry(i5, i6, (FieldElement) getEntry(i5, i6).subtract(fieldMatrix.getEntry(i5, i6)));
            }
        }
        return fieldMatrixCreateMatrix;
    }

    public String toString() {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        StringBuffer stringBuffer = new StringBuffer();
        String name = getClass().getName();
        stringBuffer.append(name.substring(name.lastIndexOf(46) + 1));
        stringBuffer.append(VectorFormat.DEFAULT_PREFIX);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            if (i5 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(VectorFormat.DEFAULT_PREFIX);
            for (int i6 = 0; i6 < columnDimension; i6++) {
                if (i6 > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(getEntry(i5, i6));
            }
            stringBuffer.append(VectorFormat.DEFAULT_SUFFIX);
        }
        stringBuffer.append(VectorFormat.DEFAULT_SUFFIX);
        return stringBuffer.toString();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> transpose() {
        final FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(getColumnDimension(), getRowDimension());
        walkInOptimizedOrder(new DefaultFieldMatrixPreservingVisitor<T>(this.field.getZero()) { // from class: org.apache.commons.math3.linear.AbstractFieldMatrix.3
            @Override // org.apache.commons.math3.linear.DefaultFieldMatrixPreservingVisitor, org.apache.commons.math3.linear.FieldMatrixPreservingVisitor
            public void visit(int i5, int i6, T t6) {
                fieldMatrixCreateMatrix.setEntry(i6, i5, t6);
            }
        });
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                setEntry(i6, i5, fieldMatrixChangingVisitor.visit(i6, i5, getEntry(i6, i5)));
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        return (T) walkInRowOrder(fieldMatrixChangingVisitor);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                setEntry(i5, i6, fieldMatrixChangingVisitor.visit(i5, i6, getEntry(i5, i6)));
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Deprecated
    public static <T extends FieldElement<T>> T[] buildArray(Field<T> field, int i5) {
        return (T[]) ((FieldElement[]) MathArrays.buildArray(field, i5));
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T[] preMultiply(T[] tArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (tArr.length != rowDimension) {
            throw new DimensionMismatchException(tArr.length, rowDimension);
        }
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, columnDimension));
        for (int i5 = 0; i5 < columnDimension; i5++) {
            T zero = this.field.getZero();
            for (int i6 = 0; i6 < rowDimension; i6++) {
                zero = (T) zero.add(getEntry(i6, i5).multiply(tArr[i6]));
            }
            tArr2[i5] = zero;
        }
        return tArr2;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        return (T) walkInRowOrder(fieldMatrixPreservingVisitor);
    }

    public AbstractFieldMatrix(Field<T> field) {
        this.field = field;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        return (T) walkInRowOrder(fieldMatrixChangingVisitor, i5, i6, i7, i8);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> getSubMatrix(final int[] iArr, final int[] iArr2) {
        checkSubMatrixIndex(iArr, iArr2);
        FieldMatrix<T> fieldMatrixCreateMatrix = createMatrix(iArr.length, iArr2.length);
        fieldMatrixCreateMatrix.walkInOptimizedOrder(new DefaultFieldMatrixChangingVisitor<T>(this.field.getZero()) { // from class: org.apache.commons.math3.linear.AbstractFieldMatrix.1
            @Override // org.apache.commons.math3.linear.DefaultFieldMatrixChangingVisitor, org.apache.commons.math3.linear.FieldMatrixChangingVisitor
            public T visit(int i5, int i6, T t6) {
                return (T) AbstractFieldMatrix.this.getEntry(iArr[i5], iArr2[i6]);
            }
        });
        return fieldMatrixCreateMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        return (T) walkInRowOrder(fieldMatrixPreservingVisitor, i5, i6, i7, i8);
    }

    public AbstractFieldMatrix(Field<T> field, int i5, int i6) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(i5));
        }
        if (i6 > 0) {
            this.field = field;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(i6));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldMatrix
    public void copySubMatrix(int[] iArr, int[] iArr2, T[][] tArr) {
        checkSubMatrixIndex(iArr, iArr2);
        if (tArr.length >= iArr.length && tArr[0].length >= iArr2.length) {
            for (int i5 = 0; i5 < iArr.length; i5++) {
                FieldElement[] fieldElementArr = tArr[i5];
                for (int i6 = 0; i6 < iArr2.length; i6++) {
                    fieldElementArr[i6] = getEntry(iArr[i5], iArr2[i6]);
                }
            }
            return;
        }
        throw new MatrixDimensionMismatchException(tArr.length, tArr[0].length, iArr.length, iArr2.length);
    }

    public static <T extends FieldElement<T>> Field<T> extractField(T[] tArr) {
        if (tArr.length != 0) {
            return tArr[0].getField();
        }
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    public void checkSubMatrixIndex(int[] iArr, int[] iArr2) {
        if (iArr != null && iArr2 != null) {
            if (iArr.length != 0 && iArr2.length != 0) {
                for (int i5 : iArr) {
                    checkRowIndex(i5);
                }
                for (int i6 : iArr2) {
                    checkColumnIndex(i6);
                }
                return;
            }
            throw new NoDataException();
        }
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                fieldMatrixPreservingVisitor.visit(i6, i5, getEntry(i6, i5));
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixPreservingVisitor.visit(i5, i6, getEntry(i5, i6));
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> operate(FieldVector<T> fieldVector) {
        try {
            return new ArrayFieldVector((Field) this.field, operate(((ArrayFieldVector) fieldVector).getDataRef()), false);
        } catch (ClassCastException unused) {
            int rowDimension = getRowDimension();
            int columnDimension = getColumnDimension();
            if (fieldVector.getDimension() == columnDimension) {
                FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, rowDimension);
                for (int i5 = 0; i5 < rowDimension; i5++) {
                    T zero = this.field.getZero();
                    for (int i6 = 0; i6 < columnDimension; i6++) {
                        zero = (FieldElement) zero.add(getEntry(i5, i6).multiply(fieldVector.getEntry(i6)));
                    }
                    fieldElementArr[i5] = zero;
                }
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            throw new DimensionMismatchException(fieldVector.getDimension(), columnDimension);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldVector<T> preMultiply(FieldVector<T> fieldVector) {
        try {
            return new ArrayFieldVector((Field) this.field, preMultiply(((ArrayFieldVector) fieldVector).getDataRef()), false);
        } catch (ClassCastException unused) {
            int rowDimension = getRowDimension();
            int columnDimension = getColumnDimension();
            if (fieldVector.getDimension() == rowDimension) {
                FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, columnDimension);
                for (int i5 = 0; i5 < columnDimension; i5++) {
                    T zero = this.field.getZero();
                    for (int i6 = 0; i6 < rowDimension; i6++) {
                        zero = (FieldElement) zero.add(getEntry(i6, i5).multiply(fieldVector.getEntry(i6)));
                    }
                    fieldElementArr[i5] = zero;
                }
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            throw new DimensionMismatchException(fieldVector.getDimension(), rowDimension);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                setEntry(i9, i7, fieldMatrixChangingVisitor.visit(i9, i7, getEntry(i9, i7)));
            }
            i7++;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            for (int i9 = i7; i9 <= i8; i9++) {
                setEntry(i5, i9, fieldMatrixChangingVisitor.visit(i5, i9, getEntry(i5, i9)));
            }
            i5++;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                fieldMatrixPreservingVisitor.visit(i9, i7, getEntry(i9, i7));
            }
            i7++;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            for (int i9 = i7; i9 <= i8; i9++) {
                fieldMatrixPreservingVisitor.visit(i5, i9, getEntry(i5, i9));
            }
            i5++;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }
}
