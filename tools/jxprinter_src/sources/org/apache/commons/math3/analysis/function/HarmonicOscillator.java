package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HarmonicOscillator implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double amplitude;
    private final double omega;
    private final double phase;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parametric implements ParametricUnivariateFunction {
        private void validateParameters(double[] dArr) {
            if (dArr == null) {
                throw new NullArgumentException();
            }
            if (dArr.length != 3) {
                throw new DimensionMismatchException(dArr.length, 3);
            }
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            validateParameters(dArr);
            double d6 = dArr[0];
            double d7 = (dArr[1] * d) + dArr[2];
            double dValue = HarmonicOscillator.value(d7, 1.0d);
            double dSin = FastMath.sin(d7) * (-d6);
            return new double[]{dValue, d * dSin, dSin};
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            validateParameters(dArr);
            return HarmonicOscillator.value((d * dArr[1]) + dArr[2], dArr[0]);
        }
    }

    public HarmonicOscillator(double d, double d6, double d7) {
        this.amplitude = d;
        this.omega = d6;
        this.phase = d7;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return value((this.omega * d) + this.phase, this.amplitude);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double value(double d, double d6) {
        return FastMath.cos(d) * d6;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        double value = derivativeStructure.getValue();
        int order = derivativeStructure.getOrder() + 1;
        double[] dArr = new double[order];
        double d = (this.omega * value) + this.phase;
        dArr[0] = FastMath.cos(d) * this.amplitude;
        if (order > 1) {
            dArr[1] = FastMath.sin(d) * (-this.amplitude) * this.omega;
            double d6 = this.omega;
            double d7 = (-d6) * d6;
            for (int i5 = 2; i5 < order; i5++) {
                dArr[i5] = dArr[i5 - 2] * d7;
            }
        }
        return derivativeStructure.compose(dArr);
    }
}
