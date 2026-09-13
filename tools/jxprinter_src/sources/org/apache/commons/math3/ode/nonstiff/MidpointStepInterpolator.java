package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class MidpointStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public MidpointStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = 2.0d * d;
        double d8 = 1.0d - d7;
        if (this.previousState == null || d > 0.5d) {
            double d9 = d6 * d;
            double d10 = (d + 1.0d) * d6;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d11 = dArr2[0][i5];
                double d12 = dArr2[1][i5];
                dArr[i5] = ((d9 * d11) + this.currentState[i5]) - (d10 * d12);
                this.interpolatedDerivatives[i5] = (d12 * d7) + (d11 * d8);
                i5++;
            }
        } else {
            double d13 = d * d6;
            double d14 = d * d * this.f6865h;
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d15 = dArr4[0][i6];
                double d16 = dArr4[1][i6];
                dArr3[i6] = (d14 * d16) + (d13 * d15) + this.previousState[i6];
                this.interpolatedDerivatives[i6] = (d16 * d7) + (d15 * d8);
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new MidpointStepInterpolator(this);
    }

    public MidpointStepInterpolator(MidpointStepInterpolator midpointStepInterpolator) {
        super(midpointStepInterpolator);
    }
}
