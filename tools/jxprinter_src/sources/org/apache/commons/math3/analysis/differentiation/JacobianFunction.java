package org.apache.commons.math3.analysis.differentiation;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class JacobianFunction implements MultivariateMatrixFunction {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MultivariateDifferentiableVectorFunction f6731f;

    public JacobianFunction(MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction) {
        this.f6731f = multivariateDifferentiableVectorFunction;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
    public double[][] value(double[] dArr) {
        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            derivativeStructureArr[i5] = new DerivativeStructure(dArr.length, 1, i5, dArr[i5]);
        }
        DerivativeStructure[] derivativeStructureArrValue = this.f6731f.value(derivativeStructureArr);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, derivativeStructureArrValue.length, dArr.length);
        int[] iArr = new int[dArr.length];
        for (int i6 = 0; i6 < derivativeStructureArrValue.length; i6++) {
            for (int i7 = 0; i7 < dArr.length; i7++) {
                iArr[i7] = 1;
                dArr2[i6][i7] = derivativeStructureArrValue[i6].getPartialDerivative(iArr);
                iArr[i7] = 0;
            }
        }
        return dArr2;
    }
}
