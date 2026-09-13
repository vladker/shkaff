package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.FieldExpandableODE;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.MultistepFieldIntegrator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdamsFieldIntegrator<T extends RealFieldElement<T>> extends MultistepFieldIntegrator<T> {
    private final AdamsNordsieckFieldTransformer<T> transformer;

    public AdamsFieldIntegrator(Field<T> field, String str, int i5, int i6, double d, double d6, double d7, double d8) {
        super(field, str, i5, i6, d, d6, d7, d8);
        this.transformer = AdamsNordsieckFieldTransformer.getInstance(field, i5);
    }

    @Override // org.apache.commons.math3.ode.MultistepFieldIntegrator
    public Array2DRowFieldMatrix<T> initializeHighOrderDerivatives(T t6, T[] tArr, T[][] tArr2, T[][] tArr3) {
        return this.transformer.initializeHighOrderDerivatives(t6, tArr, tArr2, tArr3);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderFieldIntegrator
    public abstract FieldODEStateAndDerivative<T> integrate(FieldExpandableODE<T> fieldExpandableODE, FieldODEState<T> fieldODEState, T t6);

    public Array2DRowFieldMatrix<T> updateHighOrderDerivativesPhase1(Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        return this.transformer.updateHighOrderDerivativesPhase1(array2DRowFieldMatrix);
    }

    public void updateHighOrderDerivativesPhase2(T[] tArr, T[] tArr2, Array2DRowFieldMatrix<T> array2DRowFieldMatrix) {
        this.transformer.updateHighOrderDerivativesPhase2(tArr, tArr2, array2DRowFieldMatrix);
    }

    public AdamsFieldIntegrator(Field<T> field, String str, int i5, int i6, double d, double d6, double[] dArr, double[] dArr2) {
        super(field, str, i5, i6, d, d6, dArr, dArr2);
        this.transformer = AdamsNordsieckFieldTransformer.getInstance(field, i5);
    }
}
