package org.apache.commons.math3.distribution;

import java.lang.reflect.Array;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMultivariateRealDistribution implements MultivariateRealDistribution {
    private final int dimension;
    protected final RandomGenerator random;

    public AbstractMultivariateRealDistribution(RandomGenerator randomGenerator, int i5) {
        this.random = randomGenerator;
        this.dimension = i5;
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public int getDimension() {
        return this.dimension;
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public void reseedRandomGenerator(long j6) {
        this.random.setSeed(j6);
    }

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public abstract double[] sample();

    @Override // org.apache.commons.math3.distribution.MultivariateRealDistribution
    public double[][] sample(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i5, this.dimension);
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = sample();
        }
        return dArr;
    }
}
