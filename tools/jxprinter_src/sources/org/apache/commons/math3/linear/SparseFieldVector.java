package org.apache.commons.math3.linear;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SparseFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7841233292190413362L;
    private final OpenIntToFieldHashMap<T> entries;
    private final Field<T> field;
    private final int virtualSize;

    public SparseFieldVector(Field<T> field) {
        this(field, 0);
    }

    private void checkIndex(int i5) {
        if (i5 < 0 || i5 >= getDimension()) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(getDimension() - 1));
        }
    }

    private void checkIndices(int i5, int i6) {
        int dimension = getDimension();
        if (i5 < 0 || i5 >= dimension) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(dimension - 1));
        }
        if (i6 < 0 || i6 >= dimension) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i6), 0, Integer.valueOf(dimension - 1));
        }
        if (i6 < i5) {
            throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(i6), Integer.valueOf(i5), false);
        }
    }

    private OpenIntToFieldHashMap<T> getEntries() {
        return this.entries;
    }

    public FieldVector<T> add(SparseFieldVector<T> sparseFieldVector) {
        checkVectorDimensions(sparseFieldVector.getDimension());
        SparseFieldVector sparseFieldVector2 = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator it = sparseFieldVector.getEntries().iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            FieldElement fieldElementValue = it.value();
            if (this.entries.containsKey(iKey)) {
                sparseFieldVector2.setEntry(iKey, (FieldElement) this.entries.get(iKey).add(fieldElementValue));
            } else {
                sparseFieldVector2.setEntry(iKey, fieldElementValue);
            }
        }
        return sparseFieldVector2;
    }

    public FieldVector<T> append(SparseFieldVector<T> sparseFieldVector) {
        SparseFieldVector sparseFieldVector2 = new SparseFieldVector(this, sparseFieldVector.getDimension());
        OpenIntToFieldHashMap<T>.Iterator it = sparseFieldVector.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            sparseFieldVector2.setEntry(it.key() + this.virtualSize, it.value());
        }
        return sparseFieldVector2;
    }

    public void checkVectorDimensions(int i5) {
        if (getDimension() != i5) {
            throw new DimensionMismatchException(getDimension(), i5);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> copy() {
        return new SparseFieldVector(this);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> fieldVector) {
        checkVectorDimensions(fieldVector.getDimension());
        T zero = this.field.getZero();
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            zero = (T) zero.add(fieldVector.getEntry(it.key()).multiply(it.value()));
        }
        return zero;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> fieldVector) {
        checkVectorDimensions(fieldVector.getDimension());
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator it = sparseFieldVector.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            sparseFieldVector.setEntry(it.key(), (FieldElement) it.value().divide(fieldVector.getEntry(it.key())));
        }
        return sparseFieldVector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> fieldVector) {
        checkVectorDimensions(fieldVector.getDimension());
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator it = sparseFieldVector.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            sparseFieldVector.setEntry(it.key(), (FieldElement) it.value().multiply(fieldVector.getEntry(it.key())));
        }
        return sparseFieldVector;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SparseFieldVector)) {
            return false;
        }
        SparseFieldVector sparseFieldVector = (SparseFieldVector) obj;
        Field<T> field = this.field;
        if (field == null) {
            if (sparseFieldVector.field != null) {
                return false;
            }
        } else if (!field.equals(sparseFieldVector.field)) {
            return false;
        }
        if (this.virtualSize != sparseFieldVector.virtualSize) {
            return false;
        }
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            if (!sparseFieldVector.getEntry(it.key()).equals(it.value())) {
                return false;
            }
        }
        OpenIntToFieldHashMap<T>.Iterator it2 = sparseFieldVector.getEntries().iterator();
        while (it2.hasNext()) {
            it2.advance();
            if (!it2.value().equals(getEntry(it2.key()))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    @Deprecated
    public T[] getData() {
        return (T[]) toArray();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.virtualSize;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int i5) {
        checkIndex(i5);
        return (T) this.entries.get(i5);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> getSubVector(int i5, int i6) {
        if (i6 < 0) {
            throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(i6));
        }
        checkIndex(i5);
        int i7 = i5 + i6;
        checkIndex(i7 - 1);
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this.field, i6);
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            if (iKey >= i5 && iKey < i7) {
                sparseFieldVector.setEntry(iKey - i5, it.value());
            }
        }
        return sparseFieldVector;
    }

    public int hashCode() {
        Field<T> field = this.field;
        int iHashCode = (((field == null ? 0 : field.hashCode()) + 31) * 31) + this.virtualSize;
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            iHashCode = (iHashCode * 31) + it.value().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAdd(T t6) {
        return copy().mapAddToSelf(t6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T t6) {
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            setEntry(i5, (FieldElement) getEntry(i5).add(t6));
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivide(T t6) {
        return copy().mapDivideToSelf(t6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T t6) {
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            this.entries.put(it.key(), (FieldElement) it.value().divide(t6));
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInv() {
        return copy().mapInvToSelf();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            setEntry(i5, (FieldElement) this.field.getOne().divide(getEntry(i5)));
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T t6) {
        return copy().mapMultiplyToSelf(t6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T t6) {
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            this.entries.put(it.key(), (FieldElement) it.value().multiply(t6));
        }
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtract(T t6) {
        return copy().mapSubtractToSelf(t6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T t6) {
        return mapAddToSelf((FieldElement) this.field.getZero().subtract(t6));
    }

    public FieldMatrix<T> outerProduct(SparseFieldVector<T> sparseFieldVector) {
        SparseFieldMatrix sparseFieldMatrix = new SparseFieldMatrix(this.field, this.virtualSize, sparseFieldVector.getDimension());
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            OpenIntToFieldHashMap<T>.Iterator it2 = sparseFieldVector.entries.iterator();
            while (it2.hasNext()) {
                it2.advance();
                sparseFieldMatrix.setEntry(it.key(), it2.key(), (FieldElement) it.value().multiply(it2.value()));
            }
        }
        return sparseFieldMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> fieldVector) {
        checkVectorDimensions(fieldVector.getDimension());
        return fieldVector.mapMultiply((FieldElement) dotProduct(fieldVector).divide(fieldVector.dotProduct(fieldVector)));
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void set(T t6) {
        MathUtils.checkNotNull(t6);
        for (int i5 = 0; i5 < this.virtualSize; i5++) {
            setEntry(i5, t6);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int i5, T t6) {
        MathUtils.checkNotNull(t6);
        checkIndex(i5);
        this.entries.put(i5, t6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setSubVector(int i5, FieldVector<T> fieldVector) {
        checkIndex(i5);
        checkIndex((fieldVector.getDimension() + i5) - 1);
        int dimension = fieldVector.getDimension();
        for (int i6 = 0; i6 < dimension; i6++) {
            setEntry(i6 + i5, fieldVector.getEntry(i6));
        }
    }

    public SparseFieldVector<T> subtract(SparseFieldVector<T> sparseFieldVector) {
        checkVectorDimensions(sparseFieldVector.getDimension());
        SparseFieldVector<T> sparseFieldVector2 = (SparseFieldVector) copy();
        OpenIntToFieldHashMap<T>.Iterator it = sparseFieldVector.getEntries().iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            if (this.entries.containsKey(iKey)) {
                sparseFieldVector2.setEntry(iKey, (FieldElement) this.entries.get(iKey).subtract(it.value()));
            } else {
                sparseFieldVector2.setEntry(iKey, (FieldElement) this.field.getZero().subtract(it.value()));
            }
        }
        return sparseFieldVector2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(this.field, this.virtualSize));
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            tArr[it.key()] = it.value();
        }
        return tArr;
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> fieldVectorPreservingVisitor) {
        int dimension = getDimension();
        fieldVectorPreservingVisitor.start(dimension, 0, dimension - 1);
        for (int i5 = 0; i5 < dimension; i5++) {
            fieldVectorPreservingVisitor.visit(i5, getEntry(i5));
        }
        return (T) fieldVectorPreservingVisitor.end();
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> fieldVectorPreservingVisitor) {
        return (T) walkInDefaultOrder(fieldVectorPreservingVisitor);
    }

    public SparseFieldVector(Field<T> field, int i5) {
        this.field = field;
        this.virtualSize = i5;
        this.entries = new OpenIntToFieldHashMap<>(field);
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> fieldVectorPreservingVisitor, int i5, int i6) {
        return (T) walkInDefaultOrder(fieldVectorPreservingVisitor, i5, i6);
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor) {
        return (T) walkInDefaultOrder(fieldVectorChangingVisitor);
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor, int i5, int i6) {
        return (T) walkInDefaultOrder(fieldVectorChangingVisitor, i5, i6);
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> fieldVectorPreservingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        fieldVectorPreservingVisitor.start(getDimension(), i5, i6);
        while (i5 <= i6) {
            fieldVectorPreservingVisitor.visit(i5, getEntry(i5));
            i5++;
        }
        return (T) fieldVectorPreservingVisitor.end();
    }

    public SparseFieldVector(SparseFieldVector<T> sparseFieldVector, int i5) {
        this.field = sparseFieldVector.field;
        this.virtualSize = sparseFieldVector.getDimension() + i5;
        this.entries = new OpenIntToFieldHashMap<>(sparseFieldVector.entries);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> fieldVector) {
        if (fieldVector instanceof SparseFieldVector) {
            return append((SparseFieldVector) fieldVector);
        }
        int dimension = fieldVector.getDimension();
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this, dimension);
        for (int i5 = 0; i5 < dimension; i5++) {
            sparseFieldVector.setEntry(this.virtualSize + i5, fieldVector.getEntry(i5));
        }
        return sparseFieldVector;
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor) {
        int dimension = getDimension();
        fieldVectorChangingVisitor.start(dimension, 0, dimension - 1);
        for (int i5 = 0; i5 < dimension; i5++) {
            setEntry(i5, fieldVectorChangingVisitor.visit(i5, getEntry(i5)));
        }
        return (T) fieldVectorChangingVisitor.end();
    }

    public SparseFieldVector(Field<T> field, int i5, int i6) {
        this.field = field;
        this.virtualSize = i5;
        this.entries = new OpenIntToFieldHashMap<>(field, i6);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> fieldVector) {
        if (fieldVector instanceof SparseFieldVector) {
            return outerProduct((SparseFieldVector) fieldVector);
        }
        int dimension = fieldVector.getDimension();
        SparseFieldMatrix sparseFieldMatrix = new SparseFieldMatrix(this.field, this.virtualSize, dimension);
        OpenIntToFieldHashMap<T>.Iterator it = this.entries.iterator();
        while (it.hasNext()) {
            it.advance();
            int iKey = it.key();
            FieldElement fieldElementValue = it.value();
            for (int i5 = 0; i5 < dimension; i5++) {
                sparseFieldMatrix.setEntry(iKey, i5, (FieldElement) fieldElementValue.multiply(fieldVector.getEntry(i5)));
            }
        }
        return sparseFieldMatrix;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> fieldVector) {
        if (fieldVector instanceof SparseFieldVector) {
            return subtract((SparseFieldVector) fieldVector);
        }
        int dimension = fieldVector.getDimension();
        checkVectorDimensions(dimension);
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this);
        for (int i5 = 0; i5 < dimension; i5++) {
            if (this.entries.containsKey(i5)) {
                sparseFieldVector.setEntry(i5, (FieldElement) this.entries.get(i5).subtract(fieldVector.getEntry(i5)));
            } else {
                sparseFieldVector.setEntry(i5, (FieldElement) this.field.getZero().subtract(fieldVector.getEntry(i5)));
            }
        }
        return sparseFieldVector;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> fieldVector) {
        if (fieldVector instanceof SparseFieldVector) {
            return add((SparseFieldVector) fieldVector);
        }
        int dimension = fieldVector.getDimension();
        checkVectorDimensions(dimension);
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this.field, getDimension());
        for (int i5 = 0; i5 < dimension; i5++) {
            sparseFieldVector.setEntry(i5, (FieldElement) fieldVector.getEntry(i5).add(getEntry(i5)));
        }
        return sparseFieldVector;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(T t6) {
        MathUtils.checkNotNull(t6);
        SparseFieldVector sparseFieldVector = new SparseFieldVector(this, 1);
        sparseFieldVector.setEntry(this.virtualSize, t6);
        return sparseFieldVector;
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor, int i5, int i6) {
        checkIndices(i5, i6);
        fieldVectorChangingVisitor.start(getDimension(), i5, i6);
        while (i5 <= i6) {
            setEntry(i5, fieldVectorChangingVisitor.visit(i5, getEntry(i5)));
            i5++;
        }
        return (T) fieldVectorChangingVisitor.end();
    }

    public SparseFieldVector(Field<T> field, T[] tArr) {
        MathUtils.checkNotNull(tArr);
        this.field = field;
        this.virtualSize = tArr.length;
        this.entries = new OpenIntToFieldHashMap<>(field);
        for (int i5 = 0; i5 < tArr.length; i5++) {
            this.entries.put(i5, tArr[i5]);
        }
    }

    public SparseFieldVector(SparseFieldVector<T> sparseFieldVector) {
        this.field = sparseFieldVector.field;
        this.virtualSize = sparseFieldVector.getDimension();
        this.entries = new OpenIntToFieldHashMap<>(sparseFieldVector.getEntries());
    }
}
