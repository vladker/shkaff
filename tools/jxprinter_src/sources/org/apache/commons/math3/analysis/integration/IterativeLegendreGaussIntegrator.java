package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.gauss.GaussIntegratorFactory;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class IterativeLegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private static final GaussIntegratorFactory FACTORY = new GaussIntegratorFactory();
    private final int numberOfPoints;

    public IterativeLegendreGaussIntegrator(int i5, double d, double d6, int i6, int i7) {
        super(d, d6, i6, i7);
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(i5));
        }
        this.numberOfPoints = i5;
    }

    private double stage(int i5) {
        UnivariateFunction univariateFunction = new UnivariateFunction() { // from class: org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator.1
            @Override // org.apache.commons.math3.analysis.UnivariateFunction
            public double value(double d) {
                return IterativeLegendreGaussIntegrator.this.computeObjectiveValue(d);
            }
        };
        double min = getMin();
        double max = (getMax() - min) / ((double) i5);
        double dIntegrate = 0.0d;
        for (int i6 = 0; i6 < i5; i6++) {
            double d = (((double) i6) * max) + min;
            dIntegrate += FACTORY.legendreHighPrecision(this.numberOfPoints, d, d + max).integrate(univariateFunction);
        }
        return dIntegrate;
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
            iMax = FastMath.max((int) (FastMath.min(4.0d, FastMath.pow(dAbs / dMax, 0.5d / ((double) this.numberOfPoints))) * ((double) iMax)), iMax + 1);
            incrementCount();
            dStage = dStage2;
        }
    }

    public IterativeLegendreGaussIntegrator(int i5, double d, double d6) {
        this(i5, d, d6, 3, Integer.MAX_VALUE);
    }

    public IterativeLegendreGaussIntegrator(int i5, int i6, int i7) {
        this(i5, 1.0E-6d, 1.0E-15d, i6, i7);
    }
}
