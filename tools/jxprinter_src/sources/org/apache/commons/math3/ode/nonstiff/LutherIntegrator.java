package org.apache.commons.math3.ode.nonstiff;

import androidx.collection.a;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LutherIntegrator extends RungeKuttaIntegrator {

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final double f6861Q;
    private static final double[][] STATIC_A;
    private static final double[] STATIC_B;
    private static final double[] STATIC_C;

    static {
        double dSqrt = FastMath.sqrt(21.0d);
        f6861Q = dSqrt;
        STATIC_C = new double[]{1.0d, 0.5d, 0.6666666666666666d, (7.0d - dSqrt) / 14.0d, (7.0d + dSqrt) / 14.0d, 1.0d};
        STATIC_A = new double[][]{new double[]{1.0d}, new double[]{0.375d, 0.125d}, new double[]{0.2962962962962963d, 0.07407407407407407d, 0.2962962962962963d}, new double[]{a.D(dSqrt, 9.0d, -21.0d, 392.0d), a.D(dSqrt, 8.0d, -56.0d, 392.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 48.0d, 336.0d, 392.0d), a.D(dSqrt, 3.0d, -63.0d, 392.0d)}, new double[]{com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 255.0d, -1155.0d, 1960.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 40.0d, -280.0d, 1960.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 320.0d, 0.0d, 1960.0d), a.D(dSqrt, 363.0d, 63.0d, 1960.0d), a.D(dSqrt, 392.0d, 2352.0d, 1960.0d)}, new double[]{a.D(dSqrt, 105.0d, 330.0d, 180.0d), a.D(dSqrt, 0.0d, 120.0d, 180.0d), a.D(dSqrt, 280.0d, -200.0d, 180.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 189.0d, 126.0d, 180.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 126.0d, -686.0d, 180.0d), com.google.android.gms.auth.api.accounttransfer.a.a(dSqrt, 70.0d, 490.0d, 180.0d)}};
        STATIC_B = new double[]{0.05d, 0.0d, 0.35555555555555557d, 0.0d, 0.2722222222222222d, 0.2722222222222222d, 0.05d};
    }

    public LutherIntegrator(double d) {
        super("Luther", STATIC_C, STATIC_A, STATIC_B, new LutherStepInterpolator(), d);
    }
}
