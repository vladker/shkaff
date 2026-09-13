package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Beta;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = -5852615386664158222L;
    private final double degreesOfFreedom;
    private final double factor;
    private final double solverAbsoluteAccuracy;

    public TDistribution(double d) {
        this(d, 1.0E-9d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d == 0.0d) {
            return 0.5d;
        }
        double d6 = this.degreesOfFreedom;
        double dRegularizedBeta = Beta.regularizedBeta(d6 / ((d * d) + d6), d6 * 0.5d, 0.5d);
        return d < 0.0d ? dRegularizedBeta * 0.5d : 1.0d - (dRegularizedBeta * 0.5d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        return FastMath.exp(logDensity(d));
    }

    public double getDegreesOfFreedom() {
        return this.degreesOfFreedom;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return getDegreesOfFreedom() > 1.0d ? 0.0d : Double.NaN;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double degreesOfFreedom = getDegreesOfFreedom();
        if (degreesOfFreedom > 2.0d) {
            return degreesOfFreedom / (degreesOfFreedom - 2.0d);
        }
        return (degreesOfFreedom <= 1.0d || degreesOfFreedom > 2.0d) ? Double.NaN : Double.POSITIVE_INFINITY;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return Double.NEGATIVE_INFINITY;
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
        return false;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return false;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double logDensity(double d) {
        double d6 = this.degreesOfFreedom;
        return this.factor - (FastMath.log(((d * d) / d6) + 1.0d) * ((d6 + 1.0d) / 2.0d));
    }

    public TDistribution(double d, double d6) {
        this(new Well19937c(), d, d6);
    }

    public TDistribution(RandomGenerator randomGenerator, double d) {
        this(randomGenerator, d, 1.0E-9d);
    }

    public TDistribution(RandomGenerator randomGenerator, double d, double d6) {
        super(randomGenerator);
        if (d > 0.0d) {
            this.degreesOfFreedom = d;
            this.solverAbsoluteAccuracy = d6;
            this.factor = (Gamma.logGamma((1.0d + d) / 2.0d) - ((FastMath.log(d) + FastMath.log(3.141592653589793d)) * 0.5d)) - Gamma.logGamma(d / 2.0d);
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.DEGREES_OF_FREEDOM, Double.valueOf(d));
    }
}
