package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.MultistepIntegrator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdamsIntegrator extends MultistepIntegrator {
    private final AdamsNordsieckTransformer transformer;

    public AdamsIntegrator(String str, int i5, int i6, double d, double d6, double d7, double d8) {
        super(str, i5, i6, d, d6, d7, d8);
        this.transformer = AdamsNordsieckTransformer.getInstance(i5);
    }

    @Override // org.apache.commons.math3.ode.MultistepIntegrator
    public Array2DRowRealMatrix initializeHighOrderDerivatives(double d, double[] dArr, double[][] dArr2, double[][] dArr3) {
        return this.transformer.initializeHighOrderDerivatives(d, dArr, dArr2, dArr3);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.AdaptiveStepsizeIntegrator, org.apache.commons.math3.ode.AbstractIntegrator
    public abstract void integrate(ExpandableStatefulODE expandableStatefulODE, double d);

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(Array2DRowRealMatrix array2DRowRealMatrix) {
        return this.transformer.updateHighOrderDerivativesPhase1(array2DRowRealMatrix);
    }

    public void updateHighOrderDerivativesPhase2(double[] dArr, double[] dArr2, Array2DRowRealMatrix array2DRowRealMatrix) {
        this.transformer.updateHighOrderDerivativesPhase2(dArr, dArr2, array2DRowRealMatrix);
    }

    public AdamsIntegrator(String str, int i5, int i6, double d, double d6, double[] dArr, double[] dArr2) {
        super(str, i5, i6, d, d6, dArr, dArr2);
        this.transformer = AdamsNordsieckTransformer.getInstance(i5);
    }
}
