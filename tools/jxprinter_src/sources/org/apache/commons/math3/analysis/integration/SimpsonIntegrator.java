package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpsonIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int SIMPSON_MAX_ITERATIONS_COUNT = 64;

    public SimpsonIntegrator(double d, double d6, int i5, int i6) {
        super(d, d6, i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    public double doIntegrate() {
        double d;
        TrapezoidIntegrator trapezoidIntegrator = new TrapezoidIntegrator();
        if (getMinimalIterationCount() == 1) {
            return ((trapezoidIntegrator.stage(this, 1) * 4.0d) - trapezoidIntegrator.stage(this, 0)) / 3.0d;
        }
        double dStage = trapezoidIntegrator.stage(this, 0);
        double d6 = 0.0d;
        while (true) {
            double dStage2 = trapezoidIntegrator.stage(this, getIterations());
            incrementCount();
            d = ((dStage2 * 4.0d) - dStage) / 3.0d;
            if (getIterations() >= getMinimalIterationCount()) {
                double dAbs = FastMath.abs(d - d6);
                if (dAbs <= (FastMath.abs(d) + FastMath.abs(d6)) * getRelativeAccuracy() * 0.5d || dAbs <= getAbsoluteAccuracy()) {
                    break;
                }
            }
            d6 = d;
            dStage = dStage2;
        }
        return d;
    }

    public SimpsonIntegrator(int i5, int i6) {
        super(i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    public SimpsonIntegrator() {
        super(3, 64);
    }
}
