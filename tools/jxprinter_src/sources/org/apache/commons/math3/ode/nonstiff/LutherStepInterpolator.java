package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class LutherStepInterpolator extends RungeKuttaStepInterpolator {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final double f6862Q = FastMath.sqrt(21.0d);
    private static final long serialVersionUID = 20140416;

    public LutherStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        double d7 = 21.0d * d;
        double d8 = (((((((-47.0d) + d7) * d) + 36.0d) * d) - 10.8d) * d) + 1.0d;
        double d9 = 112.0d * d;
        double d10 = ((((((-202.66666666666666d) + d9) * d) + 106.66666666666667d) * d) - 13.866666666666667d) * d;
        double d11 = (-567.0d) * d;
        double d12 = ((((((d11 / 5.0d) + 194.4d) * d) - 97.2d) * d) + 12.96d) * d;
        double d13 = f6862Q;
        double D6 = (((((((((-49.0d) - (d13 * 49.0d)) * d) / 5.0d) + a.D(d13, 287.0d, 392.0d, 15.0d)) * d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 357.0d, -637.0d, 30.0d)) * d) + a.D(d13, 343.0d, 833.0d, 150.0d)) * d;
        double dA = (((((((((d13 * 49.0d) - 49.0d) * d) / 5.0d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 287.0d, 392.0d, 15.0d)) * d) + a.D(d13, 357.0d, -637.0d, 30.0d)) * d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 343.0d, 833.0d, 150.0d)) * d;
        double d14 = ((((3.0d * d) - 3.0d) * d) + 0.6d) * d;
        if (this.previousState == null || d > 0.5d) {
            double d15 = (((((((((-21.0d) * d) / 5.0d) + 7.55d) * d) - 4.45d) * d) + 0.95d) * d) - 0.05d;
            double d16 = (((((((((-112.0d) * d) / 5.0d) + 28.266666666666666d) * d) - 7.288888888888889d) * d) - 0.35555555555555557d) * d) - 0.35555555555555557d;
            double d17 = (((((567.0d * d) / 25.0d) - 25.92d) * d) + 6.48d) * d * d;
            double dA2 = ((((((((((d13 * 49.0d) + 49.0d) * d) / 25.0d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 847.0d, -1372.0d, 300.0d)) * d) + a.D(d13, 1029.0d, 2254.0d, 900.0d)) * d) - 0.2722222222222222d) * d) - 0.2722222222222222d;
            double D7 = (((((((((49.0d - (d13 * 49.0d)) * d) / 25.0d) + a.D(d13, 847.0d, -1372.0d, 300.0d)) * d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 1029.0d, 2254.0d, 900.0d)) * d) - 0.2722222222222222d) * d) - 0.2722222222222222d;
            double d18 = ((((((-0.75d) * d) + 0.25d) * d) - 0.05d) * d) - 0.05d;
            int i5 = 0;
            while (true) {
                double[] dArr = this.interpolatedState;
                double d19 = d18;
                if (i5 >= dArr.length) {
                    return;
                }
                double[][] dArr2 = this.yDotK;
                double d20 = dArr2[0][i5];
                double d21 = dArr2[1][i5];
                double d22 = dArr2[2][i5];
                double d23 = dArr2[3][i5];
                double d24 = dArr2[4][i5];
                double d25 = dArr2[5][i5];
                double d26 = dArr2[6][i5];
                double d27 = d21 * 0.0d;
                dArr[i5] = (((d19 * d26) + (D7 * d25) + (dA2 * d24) + (d17 * d23) + (d16 * d22) + (d15 * d20) + d27) * d6) + this.currentState[i5];
                double d28 = d24 * D6;
                double d29 = d25 * dA;
                double d30 = d26 * d14;
                this.interpolatedDerivatives[i5] = d30 + d29 + d28 + (d23 * d12) + (d22 * d10) + (d20 * d8) + d27;
                i5++;
                d18 = d19;
            }
        } else {
            double d31 = (((((((d7 / 5.0d) - 11.75d) * d) + 12.0d) * d) - 5.4d) * d) + 1.0d;
            double d32 = ((((((d9 / 5.0d) - 50.666666666666664d) * d) + 35.55555555555556d) * d) - 6.933333333333334d) * d;
            double d33 = ((((((d11 / 25.0d) + 48.6d) * d) - 32.4d) * d) + 6.48d) * d;
            double D8 = (((((((((-49.0d) - (d13 * 49.0d)) * d) / 25.0d) + a.D(d13, 287.0d, 392.0d, 60.0d)) * d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 357.0d, -637.0d, 90.0d)) * d) + a.D(d13, 343.0d, 833.0d, 300.0d)) * d;
            double dA3 = (((((((((d13 * 49.0d) - 49.0d) * d) / 25.0d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 287.0d, 392.0d, 60.0d)) * d) + a.D(d13, 357.0d, -637.0d, 90.0d)) * d) + com.google.android.gms.auth.api.accounttransfer.a.a(d13, 343.0d, 833.0d, 300.0d)) * d;
            double d34 = ((((0.75d * d) - 1.0d) * d) + 0.3d) * d;
            int i6 = 0;
            while (true) {
                double[] dArr3 = this.interpolatedState;
                double d35 = d31;
                if (i6 >= dArr3.length) {
                    return;
                }
                double[][] dArr4 = this.yDotK;
                double d36 = dArr4[0][i6];
                double d37 = dArr4[1][i6];
                double d38 = dArr4[2][i6];
                double d39 = dArr4[3][i6];
                double d40 = dArr4[4][i6];
                double d41 = dArr4[5][i6];
                double d42 = dArr4[6][i6];
                double d43 = d37 * 0.0d;
                dArr3[i6] = (((d34 * d42) + (dA3 * d41) + (D8 * d40) + (d33 * d39) + (d32 * d38) + (d35 * d36) + d43) * this.f6865h * d) + this.previousState[i6];
                double d44 = d40 * D6;
                double d45 = d41 * dA;
                double d46 = d42 * d14;
                this.interpolatedDerivatives[i6] = d46 + d45 + d44 + (d39 * d12) + (d38 * d10) + (d36 * d8) + d43;
                i6++;
                d31 = d35;
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new LutherStepInterpolator(this);
    }

    public LutherStepInterpolator(LutherStepInterpolator lutherStepInterpolator) {
        super(lutherStepInterpolator);
    }
}
