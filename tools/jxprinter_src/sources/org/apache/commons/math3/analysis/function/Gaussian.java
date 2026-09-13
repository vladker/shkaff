package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
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
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Gaussian implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private final double i2s2;
    private final double is;
    private final double mean;
    private final double norm;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parametric implements ParametricUnivariateFunction {
        private void validateParameters(double[] dArr) {
            if (dArr == null) {
                throw new NullArgumentException();
            }
            if (dArr.length != 3) {
                throw new DimensionMismatchException(dArr.length, 3);
            }
            if (dArr[2] <= 0.0d) {
                throw new NotStrictlyPositiveException(Double.valueOf(dArr[2]));
            }
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            validateParameters(dArr);
            double d6 = dArr[0];
            double d7 = d - dArr[1];
            double d8 = dArr[2];
            double d9 = 1.0d / ((d8 * 2.0d) * d8);
            double dValue = Gaussian.value(d7, 1.0d, d9);
            double d10 = d6 * dValue * 2.0d * d9 * d7;
            return new double[]{dValue, d10, (d7 * d10) / d8};
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            validateParameters(dArr);
            double d6 = d - dArr[1];
            double d7 = dArr[2];
            return Gaussian.value(d6, dArr[0], 1.0d / ((2.0d * d7) * d7));
        }
    }

    public Gaussian(double d, double d6, double d7) {
        if (d7 <= 0.0d) {
            throw new NotStrictlyPositiveException(Double.valueOf(d7));
        }
        this.norm = d;
        this.mean = d6;
        double d8 = 1.0d / d7;
        this.is = d8;
        this.i2s2 = 0.5d * d8 * d8;
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        return value(d - this.mean, this.norm, this.i2s2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double value(double d, double d6, double d7) {
        return FastMath.exp((-d) * d * d7) * d6;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        double d;
        int i5;
        double value = (derivativeStructure.getValue() - this.mean) * this.is;
        int i6 = 1;
        int order = derivativeStructure.getOrder() + 1;
        double[] dArr = new double[order];
        double[] dArr2 = new double[order];
        char c = 0;
        dArr2[0] = 1.0d;
        double d6 = value * value;
        double dExp = FastMath.exp((-0.5d) * d6) * this.norm;
        double d7 = 0.0d;
        if (dExp <= Precision.SAFE_MIN) {
            Arrays.fill(dArr, 0.0d);
        } else {
            dArr[0] = dExp;
            int i7 = 1;
            while (i7 < order) {
                char c6 = c;
                int i8 = i7;
                dArr2[i8] = -dArr2[i7 - 1];
                double d8 = d7;
                int i9 = i8;
                while (i9 >= 0) {
                    d8 = (d8 * d6) + dArr2[i9];
                    if (i9 > 2) {
                        int i10 = i9 - 1;
                        d = value;
                        i5 = i6;
                        dArr2[i9 - 2] = (((double) i10) * dArr2[i10]) - dArr2[i9 - 3];
                    } else {
                        d = value;
                        i5 = i6;
                        if (i9 == 2) {
                            dArr2[c6] = dArr2[i5];
                        }
                    }
                    i9 -= 2;
                    i6 = i5;
                    value = d;
                }
                double d9 = value;
                int i11 = i6;
                if ((i8 & 1) == i11) {
                    d8 *= d9;
                }
                dExp *= this.is;
                dArr[i8] = d8 * dExp;
                i7 = i8 + 1;
                i6 = i11;
                c = c6;
                value = d9;
                d7 = 0.0d;
            }
        }
        return derivativeStructure.compose(dArr);
    }

    public Gaussian(double d, double d6) {
        this(1.0d / (FastMath.sqrt(6.283185307179586d) * d6), d, d6);
    }

    public Gaussian() {
        this(0.0d, 1.0d);
    }
}
