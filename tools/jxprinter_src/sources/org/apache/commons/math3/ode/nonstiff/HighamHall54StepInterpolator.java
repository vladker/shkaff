package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class HighamHall54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public HighamHall54StepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = ((((16.0d - (10.0d * d)) * d) - 7.5d) * d) + 1.0d;
        double d8 = ((((67.5d * d) - 91.125d) * d) + 28.6875d) * d;
        double d9 = (((152.0d - (120.0d * d)) * d) - 44.0d) * d;
        double d10 = ((((62.5d * d) - 78.125d) * d) + 23.4375d) * d;
        double d11 = 5.0d * d;
        double d12 = ((d * 2.0d) - 1.0d) * (d11 / 8.0d);
        if (this.previousState == null || d > 0.5d) {
            double d13 = d * d;
            double d14 = this.f6865h;
            double d15 = ((((((((((-5.0d) * d) / 2.0d) + 5.333333333333333d) * d) - 3.75d) * d) + 1.0d) * d) - 0.08333333333333333d) * d14;
            double d16 = (((((((135.0d * d) / 8.0d) - 30.375d) * d) + 14.34375d) * d13) - 0.84375d) * d14;
            double d17 = (((((((-30.0d) * d) + 50.666666666666664d) * d) - 22.0d) * d13) + 1.3333333333333333d) * d14;
            double d18 = (((((((125.0d * d) / 8.0d) - 26.041666666666668d) * d) + 11.71875d) * d13) - 1.3020833333333333d) * d14;
            double d19 = ((((d11 / 12.0d) - 0.3125d) * d13) - 0.10416666666666667d) * d14;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d20 = dArr2[0][i5];
                double d21 = dArr2[2][i5];
                double d22 = dArr2[3][i5];
                double d23 = dArr2[4][i5];
                double d24 = dArr2[5][i5];
                dArr[i5] = (d19 * d24) + (d18 * d23) + (d17 * d22) + (d16 * d21) + (d15 * d20) + this.currentState[i5];
                double d25 = d23 * d10;
                double d26 = d24 * d12;
                this.interpolatedDerivatives[i5] = d26 + d25 + (d22 * d9) + (d21 * d8) + (d20 * d7);
                i5++;
            }
        } else {
            double d27 = this.f6865h * d;
            double d28 = (((((5.333333333333333d - (2.5d * d)) * d) - 3.75d) * d) + 1.0d) * d27;
            double d29 = (((((135.0d * d) / 8.0d) - 30.375d) * d) + 14.34375d) * d * d27;
            double d30 = (((((-30.0d) * d) + 50.666666666666664d) * d) - 22.0d) * d * d27;
            double d31 = (((((125.0d * d) / 8.0d) - 26.041666666666668d) * d) + 11.71875d) * d * d27;
            double d32 = ((d11 / 12.0d) - 0.3125d) * d * d27;
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d33 = dArr4[0][i6];
                double d34 = dArr4[2][i6];
                double d35 = dArr4[3][i6];
                double d36 = dArr4[4][i6];
                double d37 = dArr4[5][i6];
                dArr3[i6] = (d32 * d37) + (d31 * d36) + (d30 * d35) + (d29 * d34) + (d28 * d33) + this.previousState[i6];
                double d38 = d36 * d10;
                double d39 = d37 * d12;
                this.interpolatedDerivatives[i6] = d39 + d38 + (d35 * d9) + (d34 * d8) + (d33 * d7);
                i6++;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new HighamHall54StepInterpolator(this);
    }

    public HighamHall54StepInterpolator(HighamHall54StepInterpolator highamHall54StepInterpolator) {
        super(highamHall54StepInterpolator);
    }
}
