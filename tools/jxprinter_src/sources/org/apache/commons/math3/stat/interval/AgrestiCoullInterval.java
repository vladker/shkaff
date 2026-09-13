package org.apache.commons.math3.stat.interval;

import androidx.collection.a;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgrestiCoullInterval implements BinomialConfidenceInterval {
    @Override // org.apache.commons.math3.stat.interval.BinomialConfidenceInterval
    public ConfidenceInterval createInterval(int i5, int i6, double d) {
        IntervalUtils.checkParameters(i5, i6, d);
        double dInverseCumulativeProbability = new NormalDistribution().inverseCumulativeProbability(1.0d - ((1.0d - d) / 2.0d));
        double dPow = FastMath.pow(dInverseCumulativeProbability, 2);
        double d6 = 1.0d / (((double) i5) + dPow);
        double dB = a.B(dPow, 0.5d, i6, d6);
        double dSqrt = FastMath.sqrt((1.0d - dB) * d6 * dB) * dInverseCumulativeProbability;
        return new ConfidenceInterval(dB - dSqrt, dB + dSqrt, d);
    }
}
