package org.apache.commons.math3.distribution;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NakagamiDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20141003;
    private final double inverseAbsoluteAccuracy;
    private final double mu;
    private final double omega;

    public NakagamiDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = this.mu;
        return Gamma.regularizedGammaP(d6, ((d6 * d) * d) / this.omega);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        double d6 = this.mu;
        return FastMath.exp((((-this.mu) * d) * d) / this.omega) * FastMath.pow(d, (this.mu * 2.0d) - 1.0d) * ((FastMath.pow(d6, d6) * 2.0d) / (FastMath.pow(this.omega, this.mu) * Gamma.gamma(this.mu)));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return FastMath.sqrt(this.omega / this.mu) * (Gamma.gamma(this.mu + 0.5d) / Gamma.gamma(this.mu));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double dGamma = Gamma.gamma(this.mu + 0.5d) / Gamma.gamma(this.mu);
        return (1.0d - (((1.0d / this.mu) * dGamma) * dGamma)) * this.omega;
    }

    public double getScale() {
        return this.omega;
    }

    public double getShape() {
        return this.mu;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.inverseAbsoluteAccuracy;
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

    public NakagamiDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public NakagamiDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d < 0.5d) {
            throw new NumberIsTooSmallException(Double.valueOf(d), Double.valueOf(0.5d), true);
        }
        if (d6 > 0.0d) {
            this.mu = d;
            this.omega = d6;
            this.inverseAbsoluteAccuracy = d7;
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_SCALE, Double.valueOf(d6));
    }
}
