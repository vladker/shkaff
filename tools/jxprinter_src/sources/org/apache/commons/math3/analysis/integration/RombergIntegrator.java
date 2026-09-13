package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RombergIntegrator extends BaseAbstractUnivariateIntegrator {
    public static final int ROMBERG_MAX_ITERATIONS_COUNT = 32;

    public RombergIntegrator(double d, double d6, int i5, int i6) {
        super(d, d6, i5, i6);
        if (i6 > 32) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 32, false);
        }
    }

    @Override // org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator
    public double doIntegrate() {
        double d;
        int maximalIterationCount = getMaximalIterationCount() + 1;
        double[] dArr = new double[maximalIterationCount];
        double[] dArr2 = new double[maximalIterationCount];
        TrapezoidIntegrator trapezoidIntegrator = new TrapezoidIntegrator();
        dArr2[0] = trapezoidIntegrator.stage(this, 0);
        incrementCount();
        double d6 = dArr2[0];
        while (true) {
            int iterations = getIterations();
            dArr[0] = trapezoidIntegrator.stage(this, iterations);
            incrementCount();
            for (int i5 = 1; i5 <= iterations; i5++) {
                int i6 = i5 - 1;
                double d7 = dArr[i6];
                dArr[i5] = ((d7 - dArr2[i6]) / ((1 << (i5 * 2)) - 1)) + d7;
            }
            d = dArr[iterations];
            if (iterations >= getMinimalIterationCount()) {
                double dAbs = FastMath.abs(d - d6);
                if (dAbs <= (FastMath.abs(d) + FastMath.abs(d6)) * getRelativeAccuracy() * 0.5d || dAbs <= getAbsoluteAccuracy()) {
                    break;
                }
            }
            double[] dArr3 = dArr;
            dArr = dArr2;
            dArr2 = dArr3;
            d6 = d;
        }
        return d;
    }

    public RombergIntegrator(int i5, int i6) {
        super(i5, i6);
        if (i6 > 32) {
            throw new NumberIsTooLargeException(Integer.valueOf(i6), 32, false);
        }
    }

    public RombergIntegrator() {
        super(3, 32);
    }
}
