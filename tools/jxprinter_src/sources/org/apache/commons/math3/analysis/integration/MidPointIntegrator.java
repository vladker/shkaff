package org.apache.commons.math3.analysis.integration;

import androidx.collection.a;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MidPointIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int MIDPOINT_MAX_ITERATIONS_COUNT = 64;

    public MidPointIntegrator(double d, double d6, int i5, int i6) {
        super(d, d6, i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    private double stage(int i5, double d, double d6, double d7) {
        long j6 = 1 << (i5 - 1);
        double d8 = d7 / j6;
        double d9 = (d8 * 0.5d) + d6;
        double dComputeObjectiveValue = 0.0d;
        for (long j7 = 0; j7 < j6; j7++) {
            dComputeObjectiveValue += computeObjectiveValue(d9);
            d9 += d8;
        }
        return a.B(dComputeObjectiveValue, d8, d, 0.5d);
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    public double doIntegrate() {
        double dStage;
        double min = getMin();
        double max = getMax() - min;
        MidPointIntegrator midPointIntegrator = this;
        double dComputeObjectiveValue = midPointIntegrator.computeObjectiveValue((max * 0.5d) + min) * max;
        while (true) {
            midPointIntegrator.incrementCount();
            double d = dComputeObjectiveValue;
            int iterations = getIterations();
            dStage = stage(iterations, d, min, max);
            if (iterations >= getMinimalIterationCount()) {
                double dAbs = FastMath.abs(dStage - d);
                if (dAbs <= (FastMath.abs(dStage) + FastMath.abs(d)) * getRelativeAccuracy() * 0.5d || dAbs <= getAbsoluteAccuracy()) {
                    break;
                }
            }
            midPointIntegrator = this;
            dComputeObjectiveValue = dStage;
        }
        return dStage;
    }

    public MidPointIntegrator(int i5, int i6) {
        super(i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    public MidPointIntegrator() {
        super(3, 64);
    }
}
