package org.apache.commons.math3.ode.nonstiff;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClassicalRungeKuttaIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = {0.5d, 0.5d, 1.0d};
    private static final double[][] STATIC_A = {new double[]{0.5d}, new double[]{0.0d, 0.5d}, new double[]{0.0d, 0.0d, 1.0d}};
    private static final double[] STATIC_B = {0.16666666666666666d, 0.3333333333333333d, 0.3333333333333333d, 0.16666666666666666d};

    public ClassicalRungeKuttaIntegrator(double d) {
        super("classical Runge-Kutta", STATIC_C, STATIC_A, STATIC_B, new ClassicalRungeKuttaStepInterpolator(), d);
    }
}
