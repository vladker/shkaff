package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final double SQRT2 = FastMath.sqrt(2.0d);
    private static final long serialVersionUID = 8589540077390120676L;
    private final double logStandardDeviationPlusHalfLog2Pi;
    private final double mean;
    private final double solverAbsoluteAccuracy;
    private final double standardDeviation;

    public NormalDistribution() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = d - this.mean;
        double dAbs = FastMath.abs(d6);
        double d7 = this.standardDeviation;
        if (dAbs > 40.0d * d7) {
            return d6 < 0.0d ? 0.0d : 1.0d;
        }
        return Erf.erfc((-d6) / (d7 * SQRT2)) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        return FastMath.exp(logDensity(d));
    }

    public double getMean() {
        return this.mean;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return getMean();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double standardDeviation = getStandardDeviation();
        return standardDeviation * standardDeviation;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    public double getStandardDeviation() {
        return this.standardDeviation;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double d) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        return (Erf.erfInv((d * 2.0d) - 1.0d) * this.standardDeviation * SQRT2) + this.mean;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double d) {
        double d6 = (d - this.mean) / this.standardDeviation;
        return (((-0.5d) * d6) * d6) - this.logStandardDeviationPlusHalfLog2Pi;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double probability(double d, double d6) {
        if (d > d6) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(d), Double.valueOf(d6), true);
        }
        double d7 = this.standardDeviation * SQRT2;
        double d8 = this.mean;
        return Erf.erf((d - d8) / d7, (d6 - d8) / d7) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return (this.random.nextGaussian() * this.standardDeviation) + this.mean;
    }

    public NormalDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    public NormalDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public NormalDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double d, double d6) {
        return probability(d, d6);
    }

    public NormalDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d6 > 0.0d) {
            this.mean = d;
            this.standardDeviation = d6;
            this.logStandardDeviationPlusHalfLog2Pi = (FastMath.log(6.283185307179586d) * 0.5d) + FastMath.log(d6);
            this.solverAbsoluteAccuracy = d7;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, Double.valueOf(d6));
    }
}
