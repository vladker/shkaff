package org.apache.commons.math3.analysis.function;

import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Sinc implements UnivariateDifferentiableFunction, DifferentiableUnivariateFunction {
    private static final double SHORTCUT = 0.006d;
    private final boolean normalized;

    public Sinc() {
        this(false);
    }

    @Override // org.apache.commons.math3.analysis.DifferentiableUnivariateFunction
    @Deprecated
    public UnivariateFunction derivative() {
        return FunctionUtils.toDifferentiableUnivariateFunction(this).derivative();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double d) {
        double dSin;
        if (this.normalized) {
            d *= 3.141592653589793d;
        }
        if (FastMath.abs(d) <= SHORTCUT) {
            double d6 = d * d;
            double d7 = (d6 - 20.0d) * d6;
            d = 120.0d;
            dSin = d7 + 120.0d;
        } else {
            dSin = FastMath.sin(d);
        }
        return dSin / d;
    }

    public Sinc(boolean z6) {
        this.normalized = z6;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction
    public DerivativeStructure value(DerivativeStructure derivativeStructure) {
        double[] dArr;
        double d;
        int i5;
        double d6;
        double d7;
        double[] dArr2;
        double d8 = 1.0d;
        double value = derivativeStructure.getValue() * (this.normalized ? 3.141592653589793d : 1.0d);
        double d9 = value * value;
        int i6 = 1;
        int order = derivativeStructure.getOrder() + 1;
        double[] dArr3 = new double[order];
        int i7 = 0;
        if (FastMath.abs(value) <= SHORTCUT) {
            while (i7 < order) {
                int i8 = i7 / 2;
                if ((i7 & 1) == 0) {
                    d7 = d8;
                    dArr2 = dArr3;
                    dArr2[i7] = ((d8 / ((double) (i7 + 1))) - (((d7 / ((double) ((i7 * 2) + 6))) - (d9 / ((double) ((i7 * 24) + 120)))) * d9)) * ((double) ((i8 & 1) == 0 ? i6 : -1));
                } else {
                    d7 = d8;
                    dArr2 = dArr3;
                    dArr2[i7] = ((d7 / ((double) (i7 + 2))) - (((d7 / ((double) ((i7 * 6) + 24))) - (d9 / ((double) ((i7 * 120) + 720)))) * d9)) * ((i8 & 1) == 0 ? -value : value);
                }
                i7++;
                d8 = d7;
                dArr3 = dArr2;
                i6 = 1;
            }
            dArr = dArr3;
            d = 3.141592653589793d;
        } else {
            dArr = dArr3;
            d = 3.141592653589793d;
            double d10 = 1.0d / value;
            double dCos = FastMath.cos(value);
            double dSin = FastMath.sin(value);
            dArr[0] = d10 * dSin;
            double[] dArr4 = new double[order];
            dArr4[0] = 1.0d;
            double d11 = d10;
            int i9 = 1;
            while (i9 < order) {
                double d12 = 0.0d;
                if ((i9 & 1) == 0) {
                    dArr4[i9] = 0.0d;
                    i5 = i9;
                    d6 = 0.0d;
                } else {
                    i5 = i9 - 1;
                    d6 = dArr4[i5];
                    dArr4[i9] = d6;
                }
                int i10 = i7;
                while (i5 > 1) {
                    double d13 = dCos;
                    int i11 = i5 - 1;
                    double d14 = (((double) (i5 - i9)) * dArr4[i5]) - dArr4[i11];
                    dArr4[i5] = d14;
                    d12 = (d12 * d9) + d14;
                    double d15 = (((double) (i11 - i9)) * dArr4[i11]) + dArr4[i5 - 2];
                    dArr4[i11] = d15;
                    d6 = (d6 * d9) + d15;
                    i5 -= 2;
                    dCos = d13;
                }
                double d16 = dCos;
                double d17 = ((double) (-i9)) * dArr4[i10];
                dArr4[i10] = d17;
                d11 *= d10;
                dArr[i9] = ((d6 * value * d16) + (((d12 * d9) + d17) * dSin)) * d11;
                i9++;
                i7 = i10;
                dCos = d16;
            }
        }
        if (this.normalized) {
            double d18 = d;
            for (int i12 = 1; i12 < order; i12++) {
                dArr[i12] = dArr[i12] * d18;
                d18 *= d;
            }
        }
        return derivativeStructure.compose(dArr);
    }
}
