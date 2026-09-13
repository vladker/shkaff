package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LevyDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20130314;
    private final double c;
    private final double halfC;
    private final double mu;

    public LevyDistribution(double d, double d6) {
        this(new Well19937c(), d, d6);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = this.mu;
        if (d < d6) {
            return Double.NaN;
        }
        return Erf.erfc(FastMath.sqrt(this.halfC / (d - d6)));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double d6 = this.mu;
        if (d < d6) {
            return Double.NaN;
        }
        double d7 = d - d6;
        double d8 = this.halfC / d7;
        return (FastMath.exp(-d8) * FastMath.sqrt(d8 / 3.141592653589793d)) / d7;
    }

    public double getLocation() {
        return this.mu;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return Double.POSITIVE_INFINITY;
    }

    public double getScale() {
        return this.c;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.mu;
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
        double dErfcInv = Erf.erfcInv(d);
        return (this.halfC / (dErfcInv * dErfcInv)) + this.mu;
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
        double d6 = this.mu;
        if (d < d6) {
            return Double.NaN;
        }
        double d7 = d - d6;
        double d8 = this.halfC / d7;
        return ((FastMath.log(d8 / 3.141592653589793d) * 0.5d) - d8) - FastMath.log(d7);
    }

    public LevyDistribution(RandomGenerator randomGenerator, double d, double d6) {
        super(randomGenerator);
        this.mu = d;
        this.c = d6;
        this.halfC = d6 * 0.5d;
    }
}
