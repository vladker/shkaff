package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Erf;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LogNormalDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20120112;
    private final double logShapePlusHalfLog2Pi;
    private final double scale;
    private final double shape;
    private final double solverAbsoluteAccuracy;
    private static final double SQRT2PI = FastMath.sqrt(6.283185307179586d);
    private static final double SQRT2 = FastMath.sqrt(2.0d);

    public LogNormalDistribution() {
        this(0.0d, 1.0d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        double dLog = FastMath.log(d) - this.scale;
        double dAbs = FastMath.abs(dLog);
        double d6 = this.shape;
        if (dAbs > 40.0d * d6) {
            return dLog < 0.0d ? 0.0d : 1.0d;
        }
        return (Erf.erf(dLog / (d6 * SQRT2)) * 0.5d) + 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        double dLog = (FastMath.log(d) - this.scale) / this.shape;
        return FastMath.exp(((-0.5d) * dLog) * dLog) / ((this.shape * SQRT2PI) * d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        double d = this.shape;
        return FastMath.exp(((d * d) / 2.0d) + this.scale);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double d = this.shape;
        double d6 = d * d;
        return FastMath.exp((this.scale * 2.0d) + d6) * FastMath.expm1(d6);
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
        return 0.0d;
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
        if (d <= 0.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        double dLog = FastMath.log(d);
        double d6 = (dLog - this.scale) / this.shape;
        return (((-0.5d) * d6) * d6) - (this.logShapePlusHalfLog2Pi + dLog);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double probability(double d, double d6) {
        if (d > d6) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT, Double.valueOf(d), Double.valueOf(d6), true);
        }
        if (d <= 0.0d || d6 <= 0.0d) {
            return super.probability(d, d6);
        }
        double d7 = this.shape * SQRT2;
        return Erf.erf((FastMath.log(d) - this.scale) / d7, (FastMath.log(d6) - this.scale) / d7) * 0.5d;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        double dNextGaussian = this.random.nextGaussian();
        return FastMath.exp((this.shape * dNextGaussian) + this.scale);
    }

    public LogNormalDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    public LogNormalDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public LogNormalDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    @Deprecated
    public double cumulativeProbability(double d, double d6) {
        return probability(d, d6);
    }

    public LogNormalDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d6 > 0.0d) {
            this.scale = d;
            this.shape = d6;
            this.logShapePlusHalfLog2Pi = (FastMath.log(6.283185307179586d) * 0.5d) + FastMath.log(d6);
            this.solverAbsoluteAccuracy = d7;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(d6));
    }
}
