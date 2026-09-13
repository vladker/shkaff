package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private final double[] abscissas;
    private final double[] weights;
    private static final double[] ABSCISSAS_2 = {(-1.0d) / FastMath.sqrt(3.0d), 1.0d / FastMath.sqrt(3.0d)};
    private static final double[] WEIGHTS_2 = {1.0d, 1.0d};
    private static final double[] ABSCISSAS_3 = {-FastMath.sqrt(0.6d), 0.0d, FastMath.sqrt(0.6d)};
    private static final double[] WEIGHTS_3 = {0.5555555555555556d, 0.8888888888888888d, 0.5555555555555556d};
    private static final double[] ABSCISSAS_4 = {-FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d), -FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt((15.0d - (FastMath.sqrt(30.0d) * 2.0d)) / 35.0d), FastMath.sqrt(((FastMath.sqrt(30.0d) * 2.0d) + 15.0d) / 35.0d)};
    private static final double[] WEIGHTS_4 = {(90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, ((FastMath.sqrt(30.0d) * 5.0d) + 90.0d) / 180.0d, (90.0d - (FastMath.sqrt(30.0d) * 5.0d)) / 180.0d};
    private static final double[] ABSCISSAS_5 = {-FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d), -FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), 0.0d, FastMath.sqrt((35.0d - (FastMath.sqrt(70.0d) * 2.0d)) / 63.0d), FastMath.sqrt(((FastMath.sqrt(70.0d) * 2.0d) + 35.0d) / 63.0d)};
    private static final double[] WEIGHTS_5 = {(322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, 0.5688888888888889d, ((FastMath.sqrt(70.0d) * 13.0d) + 322.0d) / 900.0d, (322.0d - (FastMath.sqrt(70.0d) * 13.0d)) / 900.0d};

    public LegendreGaussIntegrator(int i5, double d, double d6, int i6, int i7) {
        super(d, d6, i6, i7);
        if (i5 == 2) {
            this.abscissas = ABSCISSAS_2;
            this.weights = WEIGHTS_2;
            return;
        }
        if (i5 == 3) {
            this.abscissas = ABSCISSAS_3;
            this.weights = WEIGHTS_3;
        } else if (i5 == 4) {
            this.abscissas = ABSCISSAS_4;
            this.weights = WEIGHTS_4;
        } else {
            if (i5 != 5) {
                throw new MathIllegalArgumentException(LocalizedFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, Integer.valueOf(i5), 2, 5);
            }
            this.abscissas = ABSCISSAS_5;
            this.weights = WEIGHTS_5;
        }
    }

    private double stage(int i5) {
        double max = (getMax() - getMin()) / ((double) i5);
        double d = max / 2.0d;
        double min = getMin() + d;
        double dComputeObjectiveValue = 0.0d;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            while (true) {
                double[] dArr = this.abscissas;
                if (i7 < dArr.length) {
                    dComputeObjectiveValue += computeObjectiveValue((dArr[i7] * d) + min) * this.weights[i7];
                    i7++;
                }
            }
            min += max;
        }
        return d * dComputeObjectiveValue;
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    public double doIntegrate() {
        double dStage = stage(1);
        int iMax = 2;
        while (true) {
            double dStage2 = stage(iMax);
            double dAbs = FastMath.abs(dStage2 - dStage);
            double dMax = FastMath.max(getAbsoluteAccuracy(), (FastMath.abs(dStage2) + FastMath.abs(dStage)) * getRelativeAccuracy() * 0.5d);
            if (getIterations() + 1 >= getMinimalIterationCount() && dAbs <= dMax) {
                return dStage2;
            }
            iMax = FastMath.max((int) (FastMath.min(4.0d, FastMath.pow(dAbs / dMax, 0.5d / ((double) this.abscissas.length))) * ((double) iMax)), iMax + 1);
            incrementCount();
            dStage = dStage2;
        }
    }

    public LegendreGaussIntegrator(int i5, double d, double d6) {
        this(i5, d, d6, 3, Integer.MAX_VALUE);
    }

    public LegendreGaussIntegrator(int i5, int i6, int i7) {
        this(i5, 1.0E-6d, 1.0E-15d, i6, i7);
    }
}
