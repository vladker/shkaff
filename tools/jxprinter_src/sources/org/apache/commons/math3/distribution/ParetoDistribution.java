package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ParetoDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20130424;
    private final double scale;
    private final double shape;
    private final double solverAbsoluteAccuracy;

    public ParetoDistribution() {
        this(1.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = this.scale;
        if (d <= d6) {
            return 0.0d;
        }
        return 1.0d - FastMath.pow(d6 / d, this.shape);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double d6 = this.scale;
        if (d < d6) {
            return 0.0d;
        }
        return (FastMath.pow(d6, this.shape) / FastMath.pow(d, this.shape + 1.0d)) * this.shape;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double d = this.shape;
        if (d <= 1.0d) {
            return Double.POSITIVE_INFINITY;
        }
        return (this.scale * d) / (d - 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double d = this.shape;
        if (d <= 2.0d) {
            return Double.POSITIVE_INFINITY;
        }
        double d6 = d - 1.0d;
        double d7 = this.scale;
        return (((d7 * d7) * d) / (d6 * d6)) / (d - 2.0d);
    }

    public double getScale() {
        return this.scale;
    }

    public double getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
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
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double d) {
        double d6 = this.scale;
        if (d < d6) {
            return Double.NEGATIVE_INFINITY;
        }
        double dLog = FastMath.log(d6) * this.shape;
        double dLog2 = FastMath.log(d);
        double d7 = this.shape;
        return FastMath.log(d7) + (dLog - ((1.0d + d7) * dLog2));
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        return this.scale / FastMath.pow(this.random.nextDouble(), 1.0d / this.shape);
    }

    public ParetoDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    public ParetoDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double d, double d6) {
        return probability(d, d6);
    }

    public ParetoDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    public ParetoDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(d));
        }
        if (d6 > 0.0d) {
            this.scale = d;
            this.shape = d6;
            this.solverAbsoluteAccuracy = d7;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(d6));
    }
}
