package org.apache.commons.math3.analysis.differentiation;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GradientFunction implements MultivariateVectorFunction {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MultivariateDifferentiableFunction f6730f;

    public GradientFunction(MultivariateDifferentiableFunction multivariateDifferentiableFunction) {
        this.f6730f = multivariateDifferentiableFunction;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
    public double[] value(double[] dArr) {
        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            derivativeStructureArr[i5] = new DerivativeStructure(dArr.length, 1, i5, dArr[i5]);
        }
        DerivativeStructure derivativeStructureValue = this.f6730f.value(derivativeStructureArr);
        double[] dArr2 = new double[dArr.length];
        int[] iArr = new int[dArr.length];
        for (int i6 = 0; i6 < dArr.length; i6++) {
            iArr[i6] = 1;
            dArr2[i6] = derivativeStructureValue.getPartialDerivative(iArr);
            iArr[i6] = 0;
        }
        return dArr2;
    }
}
