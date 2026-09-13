package org.apache.commons.math3.distribution;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface IntegerDistribution {
    double cumulativeProbability(int i5);

    double cumulativeProbability(int i5, int i6);

    double getNumericalMean();

    double getNumericalVariance();

    int getSupportLowerBound();

    int getSupportUpperBound();

    int inverseCumulativeProbability(double d);

    boolean isSupportConnected();

    double probability(int i5);

    void reseedRandomGenerator(long j6);

    int sample();

    int[] sample(int i5);
}
