package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ClassicalRungeKuttaStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public ClassicalRungeKuttaStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = 1.0d - d;
        double d8 = d * 2.0d;
        double d9 = 1.0d - d8;
        double d10 = d7 * d9;
        double d11 = d8 * d7;
        double d12 = d9 * (-d);
        if (this.previousState == null || d > 0.5d) {
            double d13 = d * 4.0d;
            double d14 = d6 / 6.0d;
            double d15 = -d13;
            double d16 = (((d15 + 5.0d) * d) - 1.0d) * d14;
            double d17 = (((d13 - 2.0d) * d) - 2.0d) * d14;
            double d18 = (((d15 - 1.0d) * d) - 1.0d) * d14;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d19 = dArr2[0][i5];
                double d20 = dArr2[1][i5] + dArr2[2][i5];
                double d21 = dArr2[3][i5];
                dArr[i5] = (d18 * d21) + (d17 * d20) + (d16 * d19) + this.currentState[i5];
                this.interpolatedDerivatives[i5] = (d21 * d12) + (d20 * d11) + (d19 * d10);
                i5++;
            }
        } else {
            double d22 = d * 4.0d * d;
            double d23 = (this.f6865h * d) / 6.0d;
            double d24 = ((6.0d - (9.0d * d)) + d22) * d23;
            double d25 = ((d * 6.0d) - d22) * d23;
            double dB = a.B(d, -3.0d, d22, d23);
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d26 = dArr4[0][i6];
                double d27 = dArr4[1][i6] + dArr4[2][i6];
                double d28 = dArr4[3][i6];
                dArr3[i6] = (dB * d28) + (d25 * d27) + (d24 * d26) + this.previousState[i6];
                this.interpolatedDerivatives[i6] = (d28 * d12) + (d27 * d11) + (d26 * d10);
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new ClassicalRungeKuttaStepInterpolator(this);
    }

    public ClassicalRungeKuttaStepInterpolator(ClassicalRungeKuttaStepInterpolator classicalRungeKuttaStepInterpolator) {
        super(classicalRungeKuttaStepInterpolator);
    }
}
