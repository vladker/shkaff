package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SparseFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> {
    private final int columns;
    private final OpenIntToFieldHashMap<T> entries;
    private final int rows;

    public SparseFieldMatrix(Field<T> field) {
        super(field);
        this.rows = 0;
        this.columns = 0;
        this.entries = new OpenIntToFieldHashMap<>(field);
    }

    private int computeKey(int i5, int i6) {
        return (i5 * this.columns) + i6;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void addToEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int iComputeKey = computeKey(i5, i6);
        FieldElement fieldElement = (FieldElement) this.entries.get(iComputeKey).add(t6);
        if (getField().getZero().equals(fieldElement)) {
            this.entries.remove(iComputeKey);
        } else {
            this.entries.put(iComputeKey, fieldElement);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> copy() {
        return new SparseFieldMatrix((SparseFieldMatrix) this);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> createMatrix(int i5, int i6) {
        return new SparseFieldMatrix(getField(), i5, i6);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int i5, int i6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        return (T) this.entries.get(computeKey(i5, i6));
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void multiplyEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        int iComputeKey = computeKey(i5, i6);
        FieldElement fieldElement = (FieldElement) this.entries.get(iComputeKey).multiply(t6);
        if (getField().getZero().equals(fieldElement)) {
            this.entries.remove(iComputeKey);
        } else {
            this.entries.put(iComputeKey, fieldElement);
        }
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int i5, int i6, T t6) {
        checkRowIndex(i5);
        checkColumnIndex(i6);
        if (getField().getZero().equals(t6)) {
            this.entries.remove(computeKey(i5, i6));
        } else {
            this.entries.put(computeKey(i5, i6), t6);
        }
    }

    public SparseFieldMatrix(Field<T> field, int i5, int i6) {
        super(field, i5, i6);
        this.rows = i5;
        this.columns = i6;
        this.entries = new OpenIntToFieldHashMap<>(field);
    }

    public SparseFieldMatrix(SparseFieldMatrix<T> sparseFieldMatrix) {
        super(sparseFieldMatrix.getField(), sparseFieldMatrix.getRowDimension(), sparseFieldMatrix.getColumnDimension());
        this.rows = sparseFieldMatrix.getRowDimension();
        this.columns = sparseFieldMatrix.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap<>(sparseFieldMatrix.entries);
    }

    public SparseFieldMatrix(FieldMatrix<T> fieldMatrix) {
        super(fieldMatrix.getField(), fieldMatrix.getRowDimension(), fieldMatrix.getColumnDimension());
        this.rows = fieldMatrix.getRowDimension();
        this.columns = fieldMatrix.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap<>(getField());
        for (int i5 = 0; i5 < this.rows; i5++) {
            for (int i6 = 0; i6 < this.columns; i6++) {
                setEntry(i5, i6, fieldMatrix.getEntry(i5, i6));
            }
        }
    }
}
