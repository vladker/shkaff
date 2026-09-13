package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Array2DRowFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    private static final long serialVersionUID = 7260756672015356458L;
    private T[][] data;

    public Array2DRowFieldMatrix(Field<T> field) {
        super(field);
    }

    private void copyIn(T[][] tArr) {
        setSubMatrix(tArr, 0, 0);
    }

    private T[][] copyOut() {
        int rowDimension = getRowDimension();
        T[][] tArr = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), rowDimension, getColumnDimension()));
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr2 = this.data[i5];
            System.arraycopy(tArr2, 0, tArr[i5], 0, tArr2.length);
        }
        return tArr;
    }

    public Array2DRowFieldMatrix<T> add(Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        checkAdditionCompatible(array2DRowFieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldElement[][] fieldElementArr = (FieldElement[][]) MathArrays.buildArray(getField(), rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr = this.data[i5];
            T[] tArr2 = array2DRowFieldMatrix.data[i5];
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].add(tArr2[i6]);
            }
        }
        return new Array2DRowFieldMatrix<>((Field) getField(), fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void addToEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        FieldElement[] fieldElementArr = this.data[i5];
        fieldElementArr[i6] = (FieldElement) fieldElementArr[i6].add(t6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        return new Array2DRowFieldMatrix((Field) getField(), copyOut(), false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int i5, int i6) {
        return new Array2DRowFieldMatrix(getField(), i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        T[] tArr;
        T[][] tArr2 = this.data;
        if (tArr2 == null || (tArr = tArr2[0]) == null) {
            return 0;
        }
        return tArr.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[][] getData() {
        return (T[][]) copyOut();
    }

    public T[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int i5, int i6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        return this.data[i5][i6];
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        T[][] tArr = this.data;
        if (tArr == null) {
            return 0;
        }
        return tArr.length;
    }

    public Array2DRowFieldMatrix<T> multiply(Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        checkMultiplicationCompatible(array2DRowFieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = array2DRowFieldMatrix.getColumnDimension();
        int columnDimension2 = getColumnDimension();
        FieldElement[][] fieldElementArr = (FieldElement[][]) MathArrays.buildArray(getField(), rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr = this.data[i5];
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                T zero = getField().getZero();
                for (int i7 = 0; i7 < columnDimension2; i7++) {
                    zero = (FieldElement) zero.add(tArr[i7].multiply(array2DRowFieldMatrix.data[i7][i6]));
                }
                fieldElementArr2[i6] = zero;
            }
        }
        return new Array2DRowFieldMatrix<>((Field) getField(), fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void multiplyEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        FieldElement[] fieldElementArr = this.data[i5];
        fieldElementArr[i6] = (FieldElement) fieldElementArr[i6].multiply(t6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] operate(T[] tArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (tArr.length != columnDimension) {
            throw new DimensionMismatchException(tArr.length, columnDimension);
        }
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), rowDimension));
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr3 = this.data[i5];
            T zero = getField().getZero();
            for (int i6 = 0; i6 < columnDimension; i6++) {
                zero = (T) zero.add(tArr3[i6].multiply(tArr[i6]));
            }
            tArr2[i5] = zero;
        }
        return tArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T[] preMultiply(T[] tArr) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        if (tArr.length != rowDimension) {
            throw new DimensionMismatchException(tArr.length, rowDimension);
        }
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(getField(), columnDimension));
        for (int i5 = 0; i5 < columnDimension; i5++) {
            T zero = getField().getZero();
            for (int i6 = 0; i6 < rowDimension; i6++) {
                zero = (T) zero.add(this.data[i6][i5].multiply(tArr[i6]));
            }
            tArr2[i5] = zero;
        }
        return tArr2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        this.data[i5][i6] = t6;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setSubMatrix(T[][] tArr, int i5, int i6) {
        if (this.data != null) {
            super.setSubMatrix(tArr, i5, i6);
            return;
        }
        if (i5 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, Integer.valueOf(i5));
        }
        if (i6 > 0) {
            throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, Integer.valueOf(i6));
        }
        if (tArr.length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
        }
        int length = tArr[0].length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        this.data = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), tArr.length, length));
        int i7 = 0;
        while (true) {
            T[][] tArr2 = this.data;
            if (i7 >= tArr2.length) {
                return;
            }
            T[] tArr3 = tArr[i7];
            if (tArr3.length != length) {
                throw new DimensionMismatchException(length, tArr[i7].length);
            }
            System.arraycopy(tArr3, 0, tArr2[i7 + i5], i6, length);
            i7++;
        }
    }

    public Array2DRowFieldMatrix<T> subtract(Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        checkSubtractionCompatible(array2DRowFieldMatrix);
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        FieldElement[][] fieldElementArr = (FieldElement[][]) MathArrays.buildArray(getField(), rowDimension, columnDimension);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr = this.data[i5];
            T[] tArr2 = array2DRowFieldMatrix.data[i5];
            FieldElement[] fieldElementArr2 = fieldElementArr[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldElementArr2[i6] = (FieldElement) tArr[i6].subtract(tArr2[i6]);
            }
        }
        return new Array2DRowFieldMatrix<>((Field) getField(), fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                Object[] objArr = this.data[i6];
                objArr[i5] = fieldMatrixChangingVisitor.visit(i6, i5, objArr[i5]);
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixChangingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            Object[] objArr = this.data[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                objArr[i6] = fieldMatrixChangingVisitor.visit(i5, i6, objArr[i6]);
            }
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    public Array2DRowFieldMatrix(Field<T> field, int i5, int i6) {
        super(field, i5, i6);
        this.data = (T[][]) ((FieldElement[][]) MathArrays.buildArray(field, i5, i6));
    }

    public Array2DRowFieldMatrix(T[][] tArr) {
        this(AbstractFieldMatrix.extractField(tArr), tArr);
    }

    public Array2DRowFieldMatrix(Field<T> field, T[][] tArr) {
        super(field);
        copyIn(tArr);
    }

    public Array2DRowFieldMatrix(T[][] tArr, boolean z6) {
        this(AbstractFieldMatrix.extractField(tArr), tArr, z6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            for (int i6 = 0; i6 < rowDimension; i6++) {
                fieldMatrixPreservingVisitor.visit(i6, i5, this.data[i6][i5]);
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor) {
        int rowDimension = getRowDimension();
        int columnDimension = getColumnDimension();
        fieldMatrixPreservingVisitor.start(rowDimension, columnDimension, 0, rowDimension - 1, 0, columnDimension - 1);
        for (int i5 = 0; i5 < rowDimension; i5++) {
            T[] tArr = this.data[i5];
            for (int i6 = 0; i6 < columnDimension; i6++) {
                fieldMatrixPreservingVisitor.visit(i5, i6, tArr[i6]);
            }
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    public Array2DRowFieldMatrix(Field<T> field, T[][] tArr, boolean z6) {
        super(field);
        if (z6) {
            copyIn(tArr);
            return;
        }
        MathUtils.checkNotNull(tArr);
        int length = tArr.length;
        if (length != 0) {
            int length2 = tArr[0].length;
            if (length2 != 0) {
                for (int i5 = 1; i5 < length; i5++) {
                    if (tArr[i5].length != length2) {
                        throw new DimensionMismatchException(length2, tArr[i5].length);
                    }
                }
                this.data = tArr;
                return;
            }
            throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
        }
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                Object[] objArr = this.data[i9];
                objArr[i7] = fieldMatrixChangingVisitor.visit(i9, i7, objArr[i7]);
            }
            i7++;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixChangingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            Object[] objArr = this.data[i5];
            for (int i9 = i7; i9 <= i8; i9++) {
                objArr[i9] = fieldMatrixChangingVisitor.visit(i5, i9, objArr[i9]);
            }
            i5++;
        }
        return (T) fieldMatrixChangingVisitor.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i7 <= i8) {
            for (int i9 = i5; i9 <= i6; i9++) {
                fieldMatrixPreservingVisitor.visit(i9, i7, this.data[i9][i7]);
            }
            i7++;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    public Array2DRowFieldMatrix(T[] tArr) {
        this(AbstractFieldMatrix.extractField(tArr), tArr);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8) {
        checkSubMatrixIndex(i5, i6, i7, i8);
        fieldMatrixPreservingVisitor.start(getRowDimension(), getColumnDimension(), i5, i6, i7, i8);
        while (i5 <= i6) {
            T[] tArr = this.data[i5];
            for (int i9 = i7; i9 <= i8; i9++) {
                fieldMatrixPreservingVisitor.visit(i5, i9, tArr[i9]);
            }
            i5++;
        }
        return (T) fieldMatrixPreservingVisitor.end();
    }

    public Array2DRowFieldMatrix(Field<T> field, T[] tArr) {
        super(field);
        int length = tArr.length;
        this.data = (T[][]) ((FieldElement[][]) MathArrays.buildArray(getField(), length, 1));
        for (int i5 = 0; i5 < length; i5++) {
            this.data[i5][0] = tArr[i5];
        }
    }
}
