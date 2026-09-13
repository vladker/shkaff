package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class GillStepInterpolator extends RungeKuttaStepInterpolator {
    private static final double ONE_MINUS_INV_SQRT_2 = 1.0d - FastMath.sqrt(0.5d);
    private static final double ONE_PLUS_INV_SQRT_2 = FastMath.sqrt(0.5d) + 1.0d;
    private static final long serialVersionUID = 20111120;

    public GillStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = d * 2.0d;
        double d8 = d7 * d7;
        double dA = a.a(d7, 3.0d, d, 1.0d);
        double d9 = (1.0d - d) * d7;
        double d10 = ONE_MINUS_INV_SQRT_2;
        double d11 = d9 * d10;
        double d12 = ONE_PLUS_INV_SQRT_2;
        double d13 = d9 * d12;
        double d14 = (d7 - 1.0d) * d;
        if (this.previousState == null || d > 0.5d) {
            double d15 = d6 / 6.0d;
            double d16 = ((d7 + 2.0d) - d8) * d15;
            double d17 = ((1.0d - (5.0d * d)) + d8) * d15;
            double d18 = d10 * d16;
            double d19 = d16 * d12;
            double d20 = (d + 1.0d + d8) * d15;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d21 = dArr2[0][i5];
                double d22 = dArr2[1][i5];
                double d23 = dArr2[2][i5];
                double d24 = dArr2[3][i5];
                dArr[i5] = (((this.currentState[i5] - (d17 * d21)) - (d18 * d22)) - (d19 * d23)) - (d20 * d24);
                double d25 = d24 * d14;
                this.interpolatedDerivatives[i5] = d25 + (d23 * d13) + (d22 * d11) + (d21 * dA);
                i5++;
            }
        } else {
            double d26 = (this.f6865h * d) / 6.0d;
            double d27 = ((d * 6.0d) - d8) * d26;
            double d28 = ((6.0d - (9.0d * d)) + d8) * d26;
            double d29 = d27 * d10;
            double d30 = d27 * d12;
            double dB = a.B(d, -3.0d, d8, d26);
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d31 = dArr4[0][i6];
                double d32 = dArr4[1][i6];
                double d33 = dArr4[2][i6];
                double d34 = dArr4[3][i6];
                dArr3[i6] = (dB * d34) + (d30 * d33) + (d29 * d32) + (d28 * d31) + this.previousState[i6];
                double d35 = d34 * d14;
                this.interpolatedDerivatives[i6] = d35 + (d33 * d13) + (d32 * d11) + (d31 * dA);
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new GillStepInterpolator(this);
    }

    public GillStepInterpolator(GillStepInterpolator gillStepInterpolator) {
        super(gillStepInterpolator);
    }
}
