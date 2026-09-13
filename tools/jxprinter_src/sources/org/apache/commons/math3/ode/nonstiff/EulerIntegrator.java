package org.apache.commons.math3.ode.nonstiff;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EulerIntegrator extends RungeKuttaIntegrator {
    private static final double[] STATIC_C = new double[0];
    private static final double[][] STATIC_A = new double[0][];
    private static final double[] STATIC_B = {1.0d};

    public EulerIntegrator(double d) {
        super("Euler", STATIC_C, STATIC_A, STATIC_B, new EulerStepInterpolator(), d);
    }
}
