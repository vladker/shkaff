package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PascalDistribution extends AbstractIntegerDistribution {
    private static final long serialVersionUID = 6751309484392813623L;
    private final double log1mProbabilityOfSuccess;
    private final double logProbabilityOfSuccess;
    private final int numberOfSuccesses;
    private final double probabilityOfSuccess;

    public PascalDistribution(int i5, double d) {
        this(new Well19937c(), i5, d);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double cumulativeProbability(int i5) {
        if (i5 < 0) {
            return 0.0d;
        }
        return Beta.regularizedBeta(this.probabilityOfSuccess, this.numberOfSuccesses, 1.0d + ((double) i5));
    }

    public int getNumberOfSuccesses() {
        return this.numberOfSuccesses;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalMean() {
        double probabilityOfSuccess = getProbabilityOfSuccess();
        return ((1.0d - probabilityOfSuccess) * ((double) getNumberOfSuccesses())) / probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double getNumericalVariance() {
        double probabilityOfSuccess = getProbabilityOfSuccess();
        return ((1.0d - probabilityOfSuccess) * ((double) getNumberOfSuccesses())) / (probabilityOfSuccess * probabilityOfSuccess);
    }

    public double getProbabilityOfSuccess() {
        return this.probabilityOfSuccess;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportLowerBound() {
        return 0;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public int getSupportUpperBound() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractIntegerDistribution
    public double logProbability(int i5) {
        if (i5 < 0) {
            return Double.NEGATIVE_INFINITY;
        }
        int i6 = this.numberOfSuccesses;
        return (this.log1mProbabilityOfSuccess * ((double) i5)) + (this.logProbabilityOfSuccess * ((double) this.numberOfSuccesses)) + CombinatoricsUtils.binomialCoefficientLog((i5 + i6) - 1, i6 - 1);
    }

    @Override // org.apache.commons.math3.distribution.IntegerDistribution
    public double probability(int i5) {
        if (i5 < 0) {
            return 0.0d;
        }
        int i6 = this.numberOfSuccesses;
        return FastMath.pow(1.0d - this.probabilityOfSuccess, i5) * FastMath.pow(this.probabilityOfSuccess, this.numberOfSuccesses) * CombinatoricsUtils.binomialCoefficientDouble((i5 + i6) - 1, i6 - 1);
    }

    public PascalDistribution(RandomGenerator randomGenerator, int i5, double d) {
        super(randomGenerator);
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SUCCESSES, Integer.valueOf(i5));
        }
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        this.numberOfSuccesses = i5;
        this.probabilityOfSuccess = d;
        this.logProbabilityOfSuccess = FastMath.log(d);
        this.log1mProbabilityOfSuccess = FastMath.log1p(-d);
    }
}
