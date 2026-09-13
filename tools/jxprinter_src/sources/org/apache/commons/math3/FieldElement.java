package org.apache.commons.math3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldElement<T> {
    T add(T t6);

    T divide(T t6);

    Field<T> getField();

    T multiply(int i5);

    T multiply(T t6);

    T negate();

    T reciprocal();

    T subtract(T t6);
}
