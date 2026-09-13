package org.apache.commons.math3.analysis.integration;

import androidx.collection.a;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TrapezoidIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int TRAPEZOID_MAX_ITERATIONS_COUNT = 64;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private double f6737s;

    public TrapezoidIntegrator(double d, double d6, int i5, int i6) {
        super(d, d6, i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    public double doIntegrate() {
        double dStage;
        double dStage2 = stage(this, 0);
        incrementCount();
        while (true) {
            int iterations = getIterations();
            dStage = stage(this, iterations);
            if (iterations >= getMinimalIterationCount()) {
                double dAbs = FastMath.abs(dStage - dStage2);
                if (dAbs <= (FastMath.abs(dStage) + FastMath.abs(dStage2)) * getRelativeAccuracy() * 0.5d || dAbs <= getAbsoluteAccuracy()) {
                    break;
                }
            }
            incrementCount();
            dStage2 = dStage;
        }
        return dStage;
    }

    public double stage(BaseAbstractUnivariateIntegrator baseAbstractUnivariateIntegrator, int i5) {
        if (i5 == 0) {
            double max = baseAbstractUnivariateIntegrator.getMax();
            double min = baseAbstractUnivariateIntegrator.getMin();
            double dComputeObjectiveValue = (baseAbstractUnivariateIntegrator.computeObjectiveValue(max) + baseAbstractUnivariateIntegrator.computeObjectiveValue(min)) * (max - min) * 0.5d;
            this.f6737s = dComputeObjectiveValue;
            return dComputeObjectiveValue;
        }
        long j6 = 1 << (i5 - 1);
        double max2 = baseAbstractUnivariateIntegrator.getMax();
        double min2 = baseAbstractUnivariateIntegrator.getMin();
        double d = (max2 - min2) / j6;
        double d6 = (d * 0.5d) + min2;
        double dComputeObjectiveValue2 = 0.0d;
        for (long j7 = 0; j7 < j6; j7++) {
            dComputeObjectiveValue2 = baseAbstractUnivariateIntegrator.computeObjectiveValue(d6) + dComputeObjectiveValue2;
            d6 += d;
        }
        double dB = a.B(dComputeObjectiveValue2, d, this.f6737s, 0.5d);
        this.f6737s = dB;
        return dB;
    }

    public TrapezoidIntegrator(int i5, int i6) {
        super(i5, i6);
        if (i6 > 64) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 64, false);
        }
    }

    public TrapezoidIntegrator() {
        super(3, 64);
    }
}
