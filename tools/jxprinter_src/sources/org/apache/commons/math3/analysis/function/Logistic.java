package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Logistic implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f6732a;
    private final double b;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final double f6733k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final double f6734m;
    private final double oneOverN;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final double f6735q;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parametric implements ParametricUnivariateFunction {
        private void validateParameters(double[] dArr) {
            if (dArr == null) {
                throw new NullArgumentException();
            }
            if (dArr.length != 6) {
                throw new DimensionMismatchException(dArr.length, 6);
            }
            if (dArr[5] <= 0.0d) {
                throw new NotStrictlyPositiveException(Double.valueOf(dArr[5]));
            }
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            validateParameters(dArr);
            double d6 = dArr[2];
            double d7 = dArr[3];
            double d8 = dArr[1] - d;
            double d9 = 1.0d / dArr[5];
            double dExp = FastMath.exp(d6 * d8);
            double d10 = d7 * dExp;
            double d11 = d10 + 1.0d;
            double dPow = ((dArr[0] - dArr[4]) * d9) / FastMath.pow(d11, d9);
            double d12 = (-dPow) / d11;
            return new double[]{Logistic.value(d8, 1.0d, d6, d7, 0.0d, d9), d12 * d6 * d10, d10 * d12 * d8, d12 * dExp, Logistic.value(d8, 0.0d, d6, d7, 1.0d, d9), FastMath.log(d11) * dPow * d9};
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            validateParameters(dArr);
            return Logistic.value(dArr[1] - d, dArr[0], dArr[2], dArr[3], dArr[4], 1.0d / dArr[5]);
        }
    }

    public Logistic(double d, double d6, double d7, double d8, double d9, double d10) {
        if (d10 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d10));
        }
        this.f6733k = d;
        this.f6734m = d6;
        this.b = d7;
        this.f6735q = d8;
        this.f6732a = d9;
        this.oneOverN = 1.0d / d10;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return value(this.f6734m - d, this.f6733k, this.b, this.f6735q, this.f6732a, this.oneOverN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double value(double d, double d6, double d7, double d8, double d9, double d10) {
        return ((d6 - d9) / FastMath.pow((FastMath.exp(d7 * d) * d8) + 1.0d, d10)) + d9;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        return derivativeStructure.negate().add(this.f6734m).multiply(this.b).exp().multiply(this.f6735q).add(1.0d).pow(this.oneOverN).reciprocal().multiply(this.f6733k - this.f6732a).add(this.f6732a);
    }
}
