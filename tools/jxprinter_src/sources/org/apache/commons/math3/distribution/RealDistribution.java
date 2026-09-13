package org.apache.commons.math3.distribution;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface RealDistribution {
    double cumulativeProbability(double d);

    @Deprecated
    double cumulativeProbability(double d, double d6);

    double density(double d);

    double getNumericalMean();

    double getNumericalVariance();

    double getSupportLowerBound();

    double getSupportUpperBound();

    double inverseCumulativeProbability(double d);

    boolean isSupportConnected();

    @Deprecated
    boolean isSupportLowerBoundInclusive();

    @Deprecated
    boolean isSupportUpperBoundInclusive();

    double probability(double d);

    void reseedRandomGenerator(long j6);

    double sample();

    double[] sample(int i5);
}
