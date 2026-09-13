package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.FDistribution;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClopperPearsonInterval implements BinomialConfidenceInterval {
    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int i5, int i6, double d) {
        double d6;
        double d7;
        IntervalUtils.checkParameters(i5, i6, d);
        int i7 = i5 - i6;
        int i8 = i7 + 1;
        double d8 = 1.0d - ((1.0d - d) / 2.0d);
        double dInverseCumulativeProbability = new FDistribution(i8 * 2, i6 * 2).inverseCumulativeProbability(d8);
        if (i6 > 0) {
            double d9 = i6;
            d6 = d9 / ((((double) i8) * dInverseCumulativeProbability) + d9);
        } else {
            d6 = 0.0d;
        }
        int i9 = i6 + 1;
        double dInverseCumulativeProbability2 = new FDistribution(i9 * 2, i7 * 2).inverseCumulativeProbability(d8);
        if (i6 > 0) {
            double d10 = ((double) i9) * dInverseCumulativeProbability2;
            d7 = d10 / (((double) i7) + d10);
        } else {
            d7 = 0.0d;
        }
        return new ConfidenceInterval(d6, d7, d);
    }
}
