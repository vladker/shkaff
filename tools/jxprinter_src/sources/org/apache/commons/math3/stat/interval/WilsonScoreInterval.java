package org.apache.commons.math3.stat.interval;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WilsonScoreInterval implements BinomialConfidenceInterval {
    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int i5, int i6, double d) {
        IntervalUtils.checkParameters(i5, i6, d);
        double dInverseCumulativeProbability = new NormalDistribution().inverseCumulativeProbability(1.0d - ((1.0d - d) / 2.0d));
        double dPow = FastMath.pow(dInverseCumulativeProbability, 2);
        double d6 = i5;
        double d7 = ((double) i6) / d6;
        double d8 = 1.0d / d6;
        double d9 = 1.0d / ((d8 * dPow) + 1.0d);
        double d10 = ((1.0d / ((double) (i5 * 2))) * dPow) + d7;
        double dSqrt = FastMath.sqrt(((1.0d / (FastMath.pow(d6, 2) * 4.0d)) * dPow) + ((1.0d - d7) * d8 * d7)) * dInverseCumulativeProbability;
        return new ConfidenceInterval((d10 - dSqrt) * d9, (d10 + dSqrt) * d9, d);
    }
}
