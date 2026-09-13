package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ThreeEighthesStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public ThreeEighthesStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = d * 0.75d;
        double d8 = d * 4.0d;
        double dA = a.a(d8, 5.0d, d7, 1.0d);
        double d9 = (5.0d - (6.0d * d)) * d7;
        double d10 = ((d * 2.0d) - 1.0d) * d7;
        if (this.previousState == null || d > 0.5d) {
            double d11 = d6 / 8.0d;
            double d12 = d8 * d;
            double dB = a.B(d12, 2.0d, 1.0d - (7.0d * d), d11);
            double d13 = d11 * 3.0d;
            double d14 = d + 1.0d;
            double d15 = (d14 - d12) * d13;
            double d16 = d13 * d14;
            double d17 = (d14 + d12) * d11;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d18 = dArr2[0][i5];
                double d19 = dArr2[1][i5];
                double d20 = dArr2[2][i5];
                double d21 = dArr2[3][i5];
                dArr[i5] = (((this.currentState[i5] - (dB * d18)) - (d15 * d19)) - (d16 * d20)) - (d17 * d21);
                this.interpolatedDerivatives[i5] = (d21 * d10) + (d7 * d20) + (d19 * d9) + (dA * d18);
                i5++;
            }
        } else {
            double d22 = (this.f6865h * d) / 8.0d;
            double d23 = d8 * d;
            double dB2 = a.B(d23, 2.0d, 8.0d - (15.0d * d), d22);
            double d24 = d22 * 3.0d;
            double d25 = ((5.0d * d) - d23) * d24;
            double d26 = d24 * d;
            double dB3 = a.B(d, -3.0d, d23, d22);
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d27 = dArr4[0][i6];
                double d28 = dArr4[1][i6];
                double d29 = dArr4[2][i6];
                double d30 = dArr4[3][i6];
                dArr3[i6] = (dB3 * d30) + (d26 * d29) + (d25 * d28) + (dB2 * d27) + this.previousState[i6];
                this.interpolatedDerivatives[i6] = (d30 * d10) + (d7 * d29) + (d28 * d9) + (dA * d27);
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new ThreeEighthesStepInterpolator(this);
    }

    public ThreeEighthesStepInterpolator(ThreeEighthesStepInterpolator threeEighthesStepInterpolator) {
        super(threeEighthesStepInterpolator);
    }
}
