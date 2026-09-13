package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldVector<T extends FieldElement<T>> {
    FieldVector<T> add(FieldVector<T> fieldVector);

    FieldVector<T> append(T t6);

    FieldVector<T> append(FieldVector<T> fieldVector);

    FieldVector<T> copy();

    T dotProduct(FieldVector<T> fieldVector);

    FieldVector<T> ebeDivide(FieldVector<T> fieldVector);

    FieldVector<T> ebeMultiply(FieldVector<T> fieldVector);

    @Deprecated
    T[] getData();

    int getDimension();

    T getEntry(int i5);

    Field<T> getField();

    FieldVector<T> getSubVector(int i5, int i6);

    FieldVector<T> mapAdd(T t6);

    FieldVector<T> mapAddToSelf(T t6);

    FieldVector<T> mapDivide(T t6);

    FieldVector<T> mapDivideToSelf(T t6);

    FieldVector<T> mapInv();

    FieldVector<T> mapInvToSelf();

    FieldVector<T> mapMultiply(T t6);

    FieldVector<T> mapMultiplyToSelf(T t6);

    FieldVector<T> mapSubtract(T t6);

    FieldVector<T> mapSubtractToSelf(T t6);

    FieldMatrix<T> outerProduct(FieldVector<T> fieldVector);

    FieldVector<T> projection(FieldVector<T> fieldVector);

    void set(T t6);

    void setEntry(int i5, T t6);

    void setSubVector(int i5, FieldVector<T> fieldVector);

    FieldVector<T> subtract(FieldVector<T> fieldVector);

    T[] toArray();
}
