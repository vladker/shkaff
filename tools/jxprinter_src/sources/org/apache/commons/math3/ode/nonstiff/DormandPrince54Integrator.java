package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DormandPrince54Integrator extends EmbeddedRungeKuttaIntegrator {

    /* JADX INFO: renamed from: E1, reason: collision with root package name */
    private static final double f6843E1 = 0.0012326388888888888d;

    /* JADX INFO: renamed from: E3, reason: collision with root package name */
    private static final double f6844E3 = -0.0042527702905061394d;

    /* JADX INFO: renamed from: E4, reason: collision with root package name */
    private static final double f6845E4 = 0.03697916666666667d;

    /* JADX INFO: renamed from: E5, reason: collision with root package name */
    private static final double f6846E5 = -0.05086379716981132d;
    private static final double E6 = 0.0419047619047619d;
    private static final double E7 = -0.025d;
    private static final String METHOD_NAME = "Dormand-Prince 5(4)";
    private static final double[] STATIC_C = {0.2d, 0.3d, 0.8d, 0.8888888888888888d, 1.0d, 1.0d};
    private static final double[][] STATIC_A = {new double[]{0.2d}, new double[]{0.075d, 0.225d}, new double[]{0.9777777777777777d, -3.7333333333333334d, 3.5555555555555554d}, new double[]{2.9525986892242035d, -11.595793324188385d, 9.822892851699436d, -0.2908093278463649d}, new double[]{2.8462752525252526d, -10.757575757575758d, 8.906422717743473d, 0.2784090909090909d, -0.2735313036020583d}, new double[]{0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d}};
    private static final double[] STATIC_B = {0.09114583333333333d, 0.0d, 0.44923629829290207d, 0.6510416666666666d, -0.322376179245283d, 0.13095238095238096d, 0.0d};

    public DormandPrince54Integrator(double d, double d6, double d7, double d8) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, (RungeKuttaStepInterpolator) new DormandPrince54StepInterpolator(), d, d6, d7, d8);
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
            double d9 = (dArr[6][i5] * E7) + (dArr[5][i5] * E6) + (dArr[4][i5] * f6846E5) + (dArr[3][i5] * f6845E4) + (dArr[2][i5] * f6844E3) + (dArr[0][i5] * f6843E1);
            double dMax = FastMath.max(FastMath.abs(dArr2[i5]), FastMath.abs(dArr3[i5]));
            double[] dArr4 = this.vecAbsoluteTolerance;
            if (dArr4 == null) {
                d6 = this.scalAbsoluteTolerance;
                d7 = this.scalRelativeTolerance;
            } else {
                d6 = dArr4[i5];
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

    public DormandPrince54Integrator(double d, double d6, double[] dArr, double[] dArr2) {
        super(METHOD_NAME, true, STATIC_C, STATIC_A, STATIC_B, (RungeKuttaStepInterpolator) new DormandPrince54StepInterpolator(), d, d6, dArr, dArr2);
    }
}
