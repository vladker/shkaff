package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class EulerStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public EulerStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        if (this.previousState == null || d > 0.5d) {
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    double[] dArr2 = this.yDotK[0];
                    double[] dArr3 = this.interpolatedDerivatives;
                    System.arraycopy(dArr2, 0, dArr3, 0, dArr3.length);
                    return;
                }
                dArr[i5] = this.currentState[i5] - (this.yDotK[0][i5] * d6);
                i5++;
            }
        } else {
            int i6 = 0;
            while (true) {
                double[] dArr4 = this.interpolatedState;
                if (i6 >= dArr4.length) {
                    double[] dArr5 = this.yDotK[0];
                    double[] dArr6 = this.interpolatedDerivatives;
                    System.arraycopy(dArr5, 0, dArr6, 0, dArr6.length);
                    return;
                } else {
                    dArr4[i6] = (this.f6865h * d * this.yDotK[0][i6]) + this.previousState[i6];
                    i6++;
                }
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new EulerStepInterpolator(this);
    }

    public EulerStepInterpolator(EulerStepInterpolator eulerStepInterpolator) {
        super(eulerStepInterpolator);
    }
}
