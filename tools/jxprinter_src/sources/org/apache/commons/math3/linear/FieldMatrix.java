package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldMatrix<T extends FieldElement<T>> extends AnyMatrix {
    FieldMatrix<T> add(FieldMatrix<T> fieldMatrix);

    void addToEntry(int i5, int i6, T t6);

    FieldMatrix<T> copy();

    void copySubMatrix(int i5, int i6, int i7, int i8, T[][] tArr);

    void copySubMatrix(int[] iArr, int[] iArr2, T[][] tArr);

    FieldMatrix<T> createMatrix(int i5, int i6);

    T[] getColumn(int i5);

    FieldMatrix<T> getColumnMatrix(int i5);

    FieldVector<T> getColumnVector(int i5);

    T[][] getData();

    T getEntry(int i5, int i6);

    Field<T> getField();

    T[] getRow(int i5);

    FieldMatrix<T> getRowMatrix(int i5);

    FieldVector<T> getRowVector(int i5);

    FieldMatrix<T> getSubMatrix(int i5, int i6, int i7, int i8);

    FieldMatrix<T> getSubMatrix(int[] iArr, int[] iArr2);

    T getTrace();

    FieldMatrix<T> multiply(FieldMatrix<T> fieldMatrix);

    void multiplyEntry(int i5, int i6, T t6);

    FieldVector<T> operate(FieldVector<T> fieldVector);

    T[] operate(T[] tArr);

    FieldMatrix<T> power(int i5);

    FieldMatrix<T> preMultiply(FieldMatrix<T> fieldMatrix);

    FieldVector<T> preMultiply(FieldVector<T> fieldVector);

    T[] preMultiply(T[] tArr);

    FieldMatrix<T> scalarAdd(T t6);

    FieldMatrix<T> scalarMultiply(T t6);

    void setColumn(int i5, T[] tArr);

    void setColumnMatrix(int i5, FieldMatrix<T> fieldMatrix);

    void setColumnVector(int i5, FieldVector<T> fieldVector);

    void setEntry(int i5, int i6, T t6);

    void setRow(int i5, T[] tArr);

    void setRowMatrix(int i5, FieldMatrix<T> fieldMatrix);

    void setRowVector(int i5, FieldVector<T> fieldVector);

    void setSubMatrix(T[][] tArr, int i5, int i6);

    FieldMatrix<T> subtract(FieldMatrix<T> fieldMatrix);

    FieldMatrix<T> transpose();

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor);

    T walkInColumnOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor);

    T walkInColumnOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8);

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor);

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor);

    T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8);

    T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor);

    T walkInRowOrder(FieldMatrixChangingVisitor<T> fieldMatrixChangingVisitor, int i5, int i6, int i7, int i8);

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor);

    T walkInRowOrder(FieldMatrixPreservingVisitor<T> fieldMatrixPreservingVisitor, int i5, int i6, int i7, int i8);
}
