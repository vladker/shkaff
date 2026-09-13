package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultFieldMatrixChangingVisitor<T extends FieldElement<T>> implements FieldMatrixChangingVisitor<T> {
    private final T zero;

    public DefaultFieldMatrixChangingVisitor(T t6) {
        this.zero = t6;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public T end() {
        return this.zero;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public T visit(int i5, int i6, T t6) {
        return t6;
    }

    @Override // org.apache.commons.math3.linear.FieldMatrixChangingVisitor
    public void start(int i5, int i6, int i7, int i8, int i9, int i10) {
    }
}
