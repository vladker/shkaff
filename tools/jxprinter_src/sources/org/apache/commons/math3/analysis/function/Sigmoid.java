package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
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
public class Sigmoid implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
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
            double dExp = 1.0d / (FastMath.exp(-d) + 1.0d);
            return new double[]{1.0d - dExp, dExp};
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            validateParameters(dArr);
            return Sigmoid.value(d, dArr[0], dArr[1]);
        }
    }

    public Sigmoid() {
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

    public Sigmoid(double d, double d6) {
        this.lo = d;
        this.hi = d6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double value(double d, double d6, double d7) {
        return ((d7 - d6) / (FastMath.exp(-d) + 1.0d)) + d6;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        char c;
        int i5 = 1;
        int order = derivativeStructure.getOrder() + 1;
        double[] dArr = new double[order];
        double dExp = FastMath.exp(-derivativeStructure.getValue());
        char c6 = 0;
        if (Double.isInfinite(dExp)) {
            dArr[0] = this.lo;
            Arrays.fill(dArr, 1, order, 0.0d);
        } else {
            double[] dArr2 = new double[order];
            double d = 1.0d;
            double d6 = 1.0d / (dExp + 1.0d);
            double d7 = this.hi - this.lo;
            int i6 = 0;
            while (i6 < order) {
                dArr2[i6] = d;
                int i7 = i6;
                double d8 = 0.0d;
                while (i7 >= 0) {
                    d8 = (d8 * dExp) + dArr2[i7];
                    if (i7 > i5) {
                        int i8 = i7 - 1;
                        c = c6;
                        dArr2[i8] = (((double) ((i6 - i7) + 2)) * dArr2[i7 - 2]) - (((double) i8) * dArr2[i8]);
                    } else {
                        c = c6;
                        dArr2[c] = 0.0d;
                    }
                    i7--;
                    c6 = c;
                    dExp = dExp;
                    i5 = 1;
                }
                d7 *= d6;
                dArr[i6] = d8 * d7;
                i6++;
                i5 = 1;
                d = 1.0d;
            }
            char c7 = c6;
            dArr[c7] = dArr[c7] + this.lo;
        }
        return derivativeStructure.compose(dArr);
    }
}
