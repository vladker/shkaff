package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HighamHall54Integrator extends EmbeddedRungeKuttaIntegrator {
    private static final String METHOD_NAME = "Higham-Hall 5(4)";
    private static final double[] STATIC_C = {0.2222222222222222d, 0.3333333333333333d, 0.5d, 0.6d, 1.0d, 1.0d};
    private static final double[][] STATIC_A = {new double[]{0.2222222222222222d}, new double[]{0.08333333333333333d, 0.25d}, new double[]{0.125d, 0.0d, 0.375d}, new double[]{0.182d, -0.27d, 0.624d, 0.064d}, new double[]{-0.55d, 1.35d, 2.4d, -7.2d, 5.0d}, new double[]{0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d}};
    private static final double[] STATIC_B = {0.08333333333333333d, 0.0d, 0.84375d, -1.3333333333333333d, 1.3020833333333333d, 0.10416666666666667d, 0.0d};
    private static final double[] STATIC_E = {-0.05d, 0.0d, 0.50625d, -1.2d, 0.78125d, 0.0625d, -0.1d};

    public HighamHall54Integrator(double d, double d6, double d7, double d8) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, (RungeKuttaStepInterpolator) new HighamHall54StepInterpolator(), d, d6, d7, d8);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public double estimateError(double[][] dArr, double[] dArr2, double[] dArr3, double d) {
        double d6;
        double d7;
        double d8 = 0.0d;
        int i5 = 0;
        while (true) {
            int i6 = this.mainSetDimension;
            if (i5 >= i6) {
                return FastMath.sqrt(d8 / ((double) i6));
            }
            double d9 = STATIC_E[0] * dArr[0][i5];
            int i7 = 1;
            while (true) {
                double[] dArr4 = STATIC_E;
                if (i7 >= dArr4.length) {
                    break;
                }
                d9 += dArr4[i7] * dArr[i7][i5];
                i7++;
            }
            double dMax = FastMath.max(FastMath.abs(dArr2[i5]), FastMath.abs(dArr3[i5]));
            double[] dArr5 = this.vecAbsoluteTolerance;
            if (dArr5 == null) {
                d6 = this.scalAbsoluteTolerance;
                d7 = this.scalRelativeTolerance;
            } else {
                d6 = dArr5[i5];
                d7 = this.vecRelativeTolerance[i5];
            }
            double d10 = (d9 * d) / ((d7 * dMax) + d6);
            d8 += d10 * d10;
            i5++;
        }
    }

    @Override // org.apache.commons.math3.ode.nonstiff.EmbeddedRungeKuttaIntegrator
    public int getOrder() {
        return 5;
    }

    public HighamHall54Integrator(double d, double d6, double[] dArr, double[] dArr2) {
        super(METHOD_NAME, false, STATIC_C, STATIC_A, STATIC_B, (RungeKuttaStepInterpolator) new HighamHall54StepInterpolator(), d, d6, dArr, dArr2);
    }
}
