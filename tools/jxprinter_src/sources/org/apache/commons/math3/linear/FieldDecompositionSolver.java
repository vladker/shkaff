package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FieldDecompositionSolver<T extends FieldElement<T>> {
    FieldMatrix<T> getInverse();

    boolean isNonSingular();

    FieldMatrix<T> solve(FieldMatrix<T> fieldMatrix);

    FieldVector<T> solve(FieldVector<T> fieldVector);
}
