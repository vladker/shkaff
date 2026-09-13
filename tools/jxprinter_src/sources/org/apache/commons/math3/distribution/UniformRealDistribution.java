package org.apache.commons.math3.distribution;

import androidx.collection.a;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UniformRealDistribution extends AbstractRealDistribution {

    @Deprecated
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20120109;
    private final double lower;
    private final double upper;

    public UniformRealDistribution() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = this.lower;
        if (d <= d6) {
            return 0.0d;
        }
        double d7 = this.upper;
        if (d >= d7) {
            return 1.0d;
        }
        return (d - d6) / (d7 - d6);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double d6 = this.lower;
        if (d < d6) {
            return 0.0d;
        }
        double d7 = this.upper;
        if (d > d7) {
            return 0.0d;
        }
        return 1.0d / (d7 - d6);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return (this.lower + this.upper) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double d = this.upper - this.lower;
        return (d * d) / 12.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.lower;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.upper;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double d) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        double d6 = this.upper;
        double d7 = this.lower;
        return a.a(d6, d7, d, d7);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        double dNextDouble = this.random.nextDouble();
        return ((1.0d - dNextDouble) * this.lower) + (this.upper * dNextDouble);
    }

    public UniformRealDistribution(double d, double d6) {
        this(new Well19937c(), d, d6);
    }

    @Deprecated
    public UniformRealDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6);
    }

    @Deprecated
    public UniformRealDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        this(randomGenerator, d, d6);
    }

    public UniformRealDistribution(RandomGenerator randomGenerator, double d, double d6) {
        super(randomGenerator);
        if (d < d6) {
            this.lower = d;
            this.upper = d6;
            return;
        }
        throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(d), Double.valueOf(d6), false);
    }
}
