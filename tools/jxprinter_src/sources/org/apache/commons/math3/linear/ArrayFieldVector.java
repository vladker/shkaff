package org.apache.commons.math3.linear;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArrayFieldVector<T extends FieldElement<T>> implements FieldVector<T>, Serializable {
    private static final long serialVersionUID = 7648186910365927050L;
    private T[] data;
    private final Field<T> field;

    public ArrayFieldVector(Field<T> field) {
        this(field, 0);
    }

    private void checkIndex(int i5) {
        if (i5 < 0 || i5 >= getDimension()) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i5), 0, Integer.valueOf(getDimension() - 1));
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

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> add(FieldVector<T> fieldVector) {
        try {
            return add((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            checkVectorDimensions(fieldVector);
            FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
                }
                fieldElementArr[i5] = (FieldElement) tArr[i5].add(fieldVector.getEntry(i5));
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(FieldVector<T> fieldVector) {
        try {
            return append((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            return new ArrayFieldVector((ArrayFieldVector) this, new ArrayFieldVector(fieldVector));
        }
    }

    public void checkVectorDimensions(FieldVector<T> fieldVector) {
        checkVectorDimensions(fieldVector.getDimension());
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> copy() {
        return new ArrayFieldVector((ArrayFieldVector) this, true);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> fieldVector) {
        try {
            return (T) dotProduct((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            checkVectorDimensions(fieldVector);
            T zero = this.field.getZero();
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return zero;
                }
                zero = (T) zero.add(tArr[i5].multiply(fieldVector.getEntry(i5)));
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeDivide(FieldVector<T> fieldVector) {
        try {
            return ebeDivide((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            checkVectorDimensions(fieldVector);
            FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
                }
                try {
                    fieldElementArr[i5] = (FieldElement) tArr[i5].divide(fieldVector.getEntry(i5));
                    i5++;
                } catch (MathArithmeticException unused2) {
                    throw new MathArithmeticException(LocalizedFormats.INDEX, Integer.valueOf(i5));
                }
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> ebeMultiply(FieldVector<T> fieldVector) {
        try {
            return ebeMultiply((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            checkVectorDimensions(fieldVector);
            FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
                }
                fieldElementArr[i5] = (FieldElement) tArr[i5].multiply(fieldVector.getEntry(i5));
                i5++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            FieldVector fieldVector = (FieldVector) obj;
            if (this.data.length != fieldVector.getDimension()) {
                return false;
            }
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return true;
                }
                if (!tArr[i5].equals(fieldVector.getEntry(i5))) {
                    return false;
                }
                i5++;
            }
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] getData() {
        return (T[]) ((FieldElement[]) this.data.clone());
    }

    public T[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int i5) {
        return this.data[i5];
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
        ArrayFieldVector arrayFieldVector = new ArrayFieldVector(this.field, i6);
        try {
            System.arraycopy(this.data, i5, arrayFieldVector.data, 0, i6);
            return arrayFieldVector;
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
            checkIndex((i5 + i6) - 1);
            return arrayFieldVector;
        }
    }

    public int hashCode() {
        int iHashCode = 3542;
        for (T t6 : this.data) {
            iHashCode ^= t6.hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAdd(T t6) {
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            fieldElementArr[i5] = (FieldElement) tArr[i5].add(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T t6) {
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = this.data;
            if (i5 >= fieldElementArr.length) {
                return this;
            }
            fieldElementArr[i5] = (FieldElement) fieldElementArr[i5].add(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivide(T t6) {
        MathUtils.checkNotNull(t6);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            fieldElementArr[i5] = (FieldElement) tArr[i5].divide(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T t6) {
        MathUtils.checkNotNull(t6);
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = this.data;
            if (i5 >= fieldElementArr.length) {
                return this;
            }
            fieldElementArr[i5] = (FieldElement) fieldElementArr[i5].divide(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInv() {
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        T one = this.field.getOne();
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            try {
                fieldElementArr[i5] = (FieldElement) one.divide(tArr[i5]);
                i5++;
            } catch (MathArithmeticException unused) {
                throw new MathArithmeticException(LocalizedFormats.INDEX, Integer.valueOf(i5));
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        T one = this.field.getOne();
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return this;
            }
            try {
                tArr[i5] = (FieldElement) one.divide(tArr[i5]);
                i5++;
            } catch (MathArithmeticException unused) {
                throw new MathArithmeticException(LocalizedFormats.INDEX, Integer.valueOf(i5));
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T t6) {
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            fieldElementArr[i5] = (FieldElement) tArr[i5].multiply(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T t6) {
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = this.data;
            if (i5 >= fieldElementArr.length) {
                return this;
            }
            fieldElementArr[i5] = (FieldElement) fieldElementArr[i5].multiply(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtract(T t6) {
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
            }
            fieldElementArr[i5] = (FieldElement) tArr[i5].subtract(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T t6) {
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = this.data;
            if (i5 >= fieldElementArr.length) {
                return this;
            }
            fieldElementArr[i5] = (FieldElement) fieldElementArr[i5].subtract(t6);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldMatrix<T> outerProduct(FieldVector<T> fieldVector) {
        try {
            return outerProduct((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            int length = this.data.length;
            int dimension = fieldVector.getDimension();
            Array2DRowFieldMatrix array2DRowFieldMatrix = new Array2DRowFieldMatrix(this.field, length, dimension);
            for (int i5 = 0; i5 < length; i5++) {
                for (int i6 = 0; i6 < dimension; i6++) {
                    array2DRowFieldMatrix.setEntry(i5, i6, (FieldElement) this.data[i5].multiply(fieldVector.getEntry(i6)));
                }
            }
            return array2DRowFieldMatrix;
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> projection(FieldVector<T> fieldVector) {
        return fieldVector.mapMultiply((FieldElement) dotProduct(fieldVector).divide(fieldVector.dotProduct(fieldVector)));
    }

    public void set(int i5, ArrayFieldVector<T> arrayFieldVector) {
        try {
            T[] tArr = arrayFieldVector.data;
            System.arraycopy(tArr, 0, this.data, i5, tArr.length);
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
            checkIndex((i5 + arrayFieldVector.data.length) - 1);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int i5, T t6) {
        try {
            this.data[i5] = t6;
        } catch (IndexOutOfBoundsException unused) {
            checkIndex(i5);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setSubVector(int i5, FieldVector<T> fieldVector) {
        try {
            try {
                set(i5, (ArrayFieldVector) fieldVector);
            } catch (ClassCastException unused) {
                for (int i6 = i5; i6 < fieldVector.getDimension() + i5; i6++) {
                    ((T[]) this.data)[i6] = fieldVector.getEntry(i6 - i5);
                }
            }
        } catch (IndexOutOfBoundsException unused2) {
            checkIndex(i5);
            checkIndex((fieldVector.getDimension() + i5) - 1);
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> subtract(FieldVector<T> fieldVector) {
        try {
            return subtract((ArrayFieldVector) fieldVector);
        } catch (ClassCastException unused) {
            checkVectorDimensions(fieldVector);
            FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
            int i5 = 0;
            while (true) {
                T[] tArr = this.data;
                if (i5 >= tArr.length) {
                    return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
                }
                fieldElementArr[i5] = (FieldElement) tArr[i5].subtract(fieldVector.getEntry(i5));
                i5++;
            }
        }
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        return (T[]) ((FieldElement[]) this.data.clone());
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

    public ArrayFieldVector(Field<T> field, int i5) {
        this.field = field;
        this.data = (T[]) ((FieldElement[]) MathArrays.buildArray(field, i5));
    }

    public void checkVectorDimensions(int i5) {
        if (this.data.length != i5) {
            throw new DimensionMismatchException(this.data.length, i5);
        }
    }

    public ArrayFieldVector<T> projection(ArrayFieldVector<T> arrayFieldVector) {
        return (ArrayFieldVector) arrayFieldVector.mapMultiply((FieldElement) dotProduct((ArrayFieldVector) arrayFieldVector).divide(arrayFieldVector.dotProduct((ArrayFieldVector) arrayFieldVector)));
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> fieldVectorPreservingVisitor, int i5, int i6) {
        return (T) walkInDefaultOrder(fieldVectorPreservingVisitor, i5, i6);
    }

    public ArrayFieldVector<T> append(ArrayFieldVector<T> arrayFieldVector) {
        return new ArrayFieldVector<>((ArrayFieldVector) this, (ArrayFieldVector) arrayFieldVector);
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor) {
        return (T) walkInDefaultOrder(fieldVectorChangingVisitor);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> append(T t6) {
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length + 1);
        T[] tArr = this.data;
        System.arraycopy(tArr, 0, fieldElementArr, 0, tArr.length);
        fieldElementArr[this.data.length] = t6;
        return new ArrayFieldVector((Field) this.field, fieldElementArr, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void set(T t6) {
        Arrays.fill(this.data, t6);
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor, int i5, int i6) {
        return (T) walkInDefaultOrder(fieldVectorChangingVisitor, i5, i6);
    }

    public ArrayFieldVector(int i5, T t6) {
        this(t6.getField(), i5);
        Arrays.fill(this.data, t6);
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

    public T dotProduct(ArrayFieldVector<T> arrayFieldVector) {
        checkVectorDimensions(arrayFieldVector.data.length);
        T zero = this.field.getZero();
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 >= tArr.length) {
                return zero;
            }
            zero = (T) zero.add(tArr[i5].multiply(arrayFieldVector.data[i5]));
            i5++;
        }
    }

    public FieldMatrix<T> outerProduct(ArrayFieldVector<T> arrayFieldVector) {
        int length = this.data.length;
        int length2 = arrayFieldVector.data.length;
        Array2DRowFieldMatrix array2DRowFieldMatrix = new Array2DRowFieldMatrix(this.field, length, length2);
        for (int i5 = 0; i5 < length; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                array2DRowFieldMatrix.setEntry(i5, i6, (FieldElement) this.data[i5].multiply(arrayFieldVector.data[i6]));
            }
        }
        return array2DRowFieldMatrix;
    }

    public ArrayFieldVector(T[] tArr) {
        MathUtils.checkNotNull(tArr);
        try {
            this.field = tArr[0].getField();
            this.data = (T[]) ((FieldElement[]) tArr.clone());
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
    }

    public ArrayFieldVector<T> add(ArrayFieldVector<T> arrayFieldVector) {
        checkVectorDimensions(arrayFieldVector.data.length);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 < tArr.length) {
                fieldElementArr[i5] = (FieldElement) tArr[i5].add(arrayFieldVector.data[i5]);
                i5++;
            } else {
                return new ArrayFieldVector<>((Field) this.field, fieldElementArr, false);
            }
        }
    }

    public ArrayFieldVector<T> ebeMultiply(ArrayFieldVector<T> arrayFieldVector) {
        checkVectorDimensions(arrayFieldVector.data.length);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 < tArr.length) {
                fieldElementArr[i5] = (FieldElement) tArr[i5].multiply(arrayFieldVector.data[i5]);
                i5++;
            } else {
                return new ArrayFieldVector<>((Field) this.field, fieldElementArr, false);
            }
        }
    }

    public ArrayFieldVector<T> subtract(ArrayFieldVector<T> arrayFieldVector) {
        checkVectorDimensions(arrayFieldVector.data.length);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 < tArr.length) {
                fieldElementArr[i5] = (FieldElement) tArr[i5].subtract(arrayFieldVector.data[i5]);
                i5++;
            } else {
                return new ArrayFieldVector<>((Field) this.field, fieldElementArr, false);
            }
        }
    }

    public ArrayFieldVector<T> ebeDivide(ArrayFieldVector<T> arrayFieldVector) {
        checkVectorDimensions(arrayFieldVector.data.length);
        FieldElement[] fieldElementArr = (FieldElement[]) MathArrays.buildArray(this.field, this.data.length);
        int i5 = 0;
        while (true) {
            T[] tArr = this.data;
            if (i5 < tArr.length) {
                try {
                    fieldElementArr[i5] = (FieldElement) tArr[i5].divide(arrayFieldVector.data[i5]);
                    i5++;
                } catch (MathArithmeticException unused) {
                    throw new MathArithmeticException(LocalizedFormats.INDEX, Integer.valueOf(i5));
                }
            } else {
                return new ArrayFieldVector<>((Field) this.field, fieldElementArr, false);
            }
        }
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> fieldVectorChangingVisitor) {
        int dimension = getDimension();
        fieldVectorChangingVisitor.start(dimension, 0, dimension - 1);
        for (int i5 = 0; i5 < dimension; i5++) {
            setEntry(i5, fieldVectorChangingVisitor.visit(i5, getEntry(i5)));
        }
        return (T) fieldVectorChangingVisitor.end();
    }

    public ArrayFieldVector(Field<T> field, T[] tArr) {
        MathUtils.checkNotNull(tArr);
        this.field = field;
        this.data = (T[]) ((FieldElement[]) tArr.clone());
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

    public ArrayFieldVector(T[] tArr, boolean z6) {
        MathUtils.checkNotNull(tArr);
        if (tArr.length != 0) {
            this.field = tArr[0].getField();
            this.data = z6 ? (T[]) ((FieldElement[]) tArr.clone()) : tArr;
            return;
        }
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> field, T[] tArr, boolean z6) {
        MathUtils.checkNotNull(tArr);
        this.field = field;
        this.data = z6 ? (T[]) ((FieldElement[]) tArr.clone()) : tArr;
    }

    public ArrayFieldVector(T[] tArr, int i5, int i6) {
        MathUtils.checkNotNull(tArr);
        int i7 = i5 + i6;
        if (tArr.length >= i7) {
            Field<T> field = tArr[0].getField();
            this.field = field;
            T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(field, i6));
            this.data = tArr2;
            System.arraycopy(tArr, i5, tArr2, 0, i6);
            return;
        }
        throw new NumberIsTooLargeException(Integer.valueOf(i7), Integer.valueOf(tArr.length), true);
    }

    public ArrayFieldVector(Field<T> field, T[] tArr, int i5, int i6) {
        MathUtils.checkNotNull(tArr);
        int i7 = i5 + i6;
        if (tArr.length >= i7) {
            this.field = field;
            T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(field, i6));
            this.data = tArr2;
            System.arraycopy(tArr, i5, tArr2, 0, i6);
            return;
        }
        throw new NumberIsTooLargeException(Integer.valueOf(i7), Integer.valueOf(tArr.length), true);
    }

    public ArrayFieldVector(FieldVector<T> fieldVector) {
        MathUtils.checkNotNull(fieldVector);
        Field<T> field = fieldVector.getField();
        this.field = field;
        this.data = (T[]) ((FieldElement[]) MathArrays.buildArray(field, fieldVector.getDimension()));
        int i5 = 0;
        while (true) {
            FieldElement[] fieldElementArr = (T[]) this.data;
            if (i5 >= fieldElementArr.length) {
                return;
            }
            fieldElementArr[i5] = fieldVector.getEntry(i5);
            i5++;
        }
    }

    public ArrayFieldVector(ArrayFieldVector<T> arrayFieldVector) {
        MathUtils.checkNotNull(arrayFieldVector);
        this.field = arrayFieldVector.getField();
        this.data = (T[]) ((FieldElement[]) arrayFieldVector.data.clone());
    }

    public ArrayFieldVector(ArrayFieldVector<T> arrayFieldVector, boolean z6) {
        MathUtils.checkNotNull(arrayFieldVector);
        this.field = arrayFieldVector.getField();
        T[] tArr = arrayFieldVector.data;
        this.data = z6 ? (T[]) ((FieldElement[]) tArr.clone()) : tArr;
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> arrayFieldVector, ArrayFieldVector<T> arrayFieldVector2) {
        this((FieldVector) arrayFieldVector, (FieldVector) arrayFieldVector2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> fieldVector, FieldVector<T> fieldVector2) {
        MathUtils.checkNotNull(fieldVector);
        MathUtils.checkNotNull(fieldVector2);
        Field<T> field = fieldVector.getField();
        this.field = field;
        Object[] objArr = fieldVector instanceof ArrayFieldVector ? ((ArrayFieldVector) fieldVector).data : (T[]) fieldVector.toArray();
        Object[] objArr2 = fieldVector2 instanceof ArrayFieldVector ? ((ArrayFieldVector) fieldVector2).data : (T[]) fieldVector2.toArray();
        T[] tArr = (T[]) ((FieldElement[]) MathArrays.buildArray(field, objArr.length + objArr2.length));
        this.data = tArr;
        System.arraycopy(objArr, 0, tArr, 0, objArr.length);
        System.arraycopy(objArr2, 0, this.data, objArr.length, objArr2.length);
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> arrayFieldVector, T[] tArr) {
        this((FieldVector) arrayFieldVector, (FieldElement[]) tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> fieldVector, T[] tArr) {
        MathUtils.checkNotNull(fieldVector);
        MathUtils.checkNotNull(tArr);
        Field<T> field = fieldVector.getField();
        this.field = field;
        Object[] objArr = fieldVector instanceof ArrayFieldVector ? ((ArrayFieldVector) fieldVector).data : (T[]) fieldVector.toArray();
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(field, objArr.length + tArr.length));
        this.data = tArr2;
        System.arraycopy(objArr, 0, tArr2, 0, objArr.length);
        System.arraycopy(tArr, 0, this.data, objArr.length, tArr.length);
    }

    @Deprecated
    public ArrayFieldVector(T[] tArr, ArrayFieldVector<T> arrayFieldVector) {
        this((FieldElement[]) tArr, (FieldVector) arrayFieldVector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(T[] tArr, FieldVector<T> fieldVector) {
        MathUtils.checkNotNull(tArr);
        MathUtils.checkNotNull(fieldVector);
        Field<T> field = fieldVector.getField();
        this.field = field;
        Object[] objArr = fieldVector instanceof ArrayFieldVector ? ((ArrayFieldVector) fieldVector).data : (T[]) fieldVector.toArray();
        T[] tArr2 = (T[]) ((FieldElement[]) MathArrays.buildArray(field, tArr.length + objArr.length));
        this.data = tArr2;
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        System.arraycopy(objArr, 0, this.data, tArr.length, objArr.length);
    }

    public ArrayFieldVector(T[] tArr, T[] tArr2) {
        MathUtils.checkNotNull(tArr);
        MathUtils.checkNotNull(tArr2);
        if (tArr.length + tArr2.length != 0) {
            T[] tArr3 = (T[]) ((FieldElement[]) MathArrays.buildArray(tArr[0].getField(), tArr.length + tArr2.length));
            this.data = tArr3;
            System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
            System.arraycopy(tArr2, 0, this.data, tArr.length, tArr2.length);
            this.field = this.data[0].getField();
            return;
        }
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(Field<T> field, T[] tArr, T[] tArr2) {
        MathUtils.checkNotNull(tArr);
        MathUtils.checkNotNull(tArr2);
        if (tArr.length + tArr2.length != 0) {
            T[] tArr3 = (T[]) ((FieldElement[]) MathArrays.buildArray(field, tArr.length + tArr2.length));
            this.data = tArr3;
            System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
            System.arraycopy(tArr2, 0, this.data, tArr.length, tArr2.length);
            this.field = field;
            return;
        }
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }
}
