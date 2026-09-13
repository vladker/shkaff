package org.apache.commons.math3.ode;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldSecondaryEquations<T extends RealFieldElement<T>> {
    T[] computeDerivatives(T t6, T[] tArr, T[] tArr2, T[] tArr3);

    int getDimension();

    void init(T t6, T[] tArr, T[] tArr2, T t7);
}
