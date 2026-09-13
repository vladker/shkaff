package org.apache.commons.math3.linear;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RealMatrixChangingVisitor {
    double end();

    void start(int i5, int i6, int i7, int i8, int i9, int i10);

    double visit(int i5, int i6, double d);
}
