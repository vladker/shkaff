package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Logit implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double hi;
    private final double lo;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parametric implements ParametricUnivariateFunction {
        private void validateParameters(double[] dArr) {
            if (dArr == null) {
                throw new NullArgumentException();
            }
            if (dArr.length != 2) {
                throw new DimensionMismatchException(dArr.length, 2);
            }
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            validateParameters(dArr);
            return new double[]{1.0d / (dArr[0] - d), 1.0d / (dArr[1] - d)};
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            validateParameters(dArr);
            return Logit.value(d, dArr[0], dArr[1]);
        }
    }

    public Logit() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return value(d, this.lo, this.hi);
    }

    public Logit(double d, double d6) {
        this.lo = d;
        this.hi = d6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double value(double d, double d6, double d7) {
        if (d < d6 || d > d7) {
            throw new OutOfRangeException(Double.valueOf(d), Double.valueOf(d6), Double.valueOf(d7));
        }
        return FastMath.log((d - d6) / (d7 - d));
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        double value = derivativeStructure.getValue();
        if (value >= this.lo && value <= this.hi) {
            int order = derivativeStructure.getOrder() + 1;
            double[] dArr = new double[order];
            double dLog = FastMath.log((value - this.lo) / (this.hi - value));
            dArr[0] = dLog;
            if (Double.isInfinite(dLog)) {
                if (order > 1) {
                    dArr[1] = Double.POSITIVE_INFINITY;
                }
                for (int i5 = 2; i5 < order; i5++) {
                    dArr[i5] = dArr[i5 - 2];
                }
            } else {
                double d = 1.0d / (value - this.lo);
                double d6 = 1.0d / (this.hi - value);
                double d7 = d;
                double d8 = d6;
                for (int i6 = 1; i6 < order; i6++) {
                    dArr[i6] = d7 + d8;
                    d7 *= ((double) (-i6)) * d;
                    d8 *= ((double) i6) * d6;
                }
            }
            return derivativeStructure.compose(dArr);
        }
        throw new OutOfRangeException(Double.valueOf(value), Double.valueOf(this.lo), Double.valueOf(this.hi));
    }
}
