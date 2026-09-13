package org.apache.commons.math3.distribution;

import androidx.collection.a;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GammaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9d;
    private static final long serialVersionUID = 20120524;
    private final double densityPrefactor1;
    private final double densityPrefactor2;
    private final double logDensityPrefactor1;
    private final double logDensityPrefactor2;
    private final double maxLogY;
    private final double minY;
    private final double scale;
    private final double shape;
    private final double shiftedShape;
    private final double solverAbsoluteAccuracy;

    public GammaDistribution(double d, double d6) {
        this(d, d6, 1.0E-9d);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d <= 0.0d) {
            return 0.0d;
        }
        return Gamma.regularizedGammaP(this.shape, d / this.scale);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double dExp;
        double dExp2;
        if (d < 0.0d) {
            return 0.0d;
        }
        double d6 = d / this.scale;
        if (d6 <= this.minY || FastMath.log(d6) >= this.maxLogY) {
            double d7 = this.shiftedShape;
            double d8 = (d6 - d7) / d7;
            double dLog1p = (((-d6) * 5.2421875d) / this.shiftedShape) + 4.7421875d + ((FastMath.log1p(d8) - d8) * this.shape);
            dExp = this.densityPrefactor2 / d;
            dExp2 = FastMath.exp(dLog1p);
        } else {
            dExp = FastMath.exp(-d6) * this.densityPrefactor1;
            dExp2 = FastMath.pow(d6, this.shape - 1.0d);
        }
        return dExp2 * dExp;
    }

    @Deprecated
    public double getAlpha() {
        return this.shape;
    }

    @Deprecated
    public double getBeta() {
        return this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.shape * this.scale;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double d = this.shape;
        double d6 = this.scale;
        return d * d6 * d6;
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
        if (d < 0.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        double d6 = d / this.scale;
        if (d6 > this.minY && FastMath.log(d6) < this.maxLogY) {
            double d7 = this.logDensityPrefactor1 - d6;
            return a.a(this.shape, 1.0d, FastMath.log(d6), d7);
        }
        double d8 = this.shiftedShape;
        double d9 = (d6 - d8) / d8;
        return (this.logDensityPrefactor2 - FastMath.log(d)) + (((-d6) * 5.2421875d) / this.shiftedShape) + 4.7421875d + ((FastMath.log1p(d9) - d9) * this.shape);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double sample() {
        double d = this.shape;
        if (d < 1.0d) {
            while (true) {
                double dNextDouble = this.random.nextDouble();
                double d6 = this.shape;
                double d7 = (d6 / 2.718281828459045d) + 1.0d;
                double d8 = dNextDouble * d7;
                if (d8 <= 1.0d) {
                    double dPow = FastMath.pow(d8, 1.0d / d6);
                    if (this.random.nextDouble() <= FastMath.exp(-dPow)) {
                        return this.scale * dPow;
                    }
                } else {
                    double dLog = FastMath.log((d7 - d8) / d6) * (-1.0d);
                    if (this.random.nextDouble() <= FastMath.pow(dLog, this.shape - 1.0d)) {
                        return this.scale * dLog;
                    }
                }
            }
        } else {
            double d9 = d - 0.3333333333333333d;
            double dSqrt = 1.0d / (FastMath.sqrt(d9) * 3.0d);
            while (true) {
                double dNextGaussian = this.random.nextGaussian();
                double d10 = (dSqrt * dNextGaussian) + 1.0d;
                double d11 = d10 * d10 * d10;
                if (d11 > 0.0d) {
                    double d12 = dNextGaussian * dNextGaussian;
                    double dNextDouble2 = this.random.nextDouble();
                    if (dNextDouble2 < 1.0d - ((0.0331d * d12) * d12)) {
                        return this.scale * d9 * d11;
                    }
                    if (FastMath.log(dNextDouble2) < ((FastMath.log(d11) + (1.0d - d11)) * d9) + (d12 * 0.5d)) {
                        return this.scale * d9 * d11;
                    }
                }
            }
        }
    }

    public GammaDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    public GammaDistribution(RandomGenerator randomGenerator, double d, double d6) {
        this(randomGenerator, d, d6, 1.0E-9d);
    }

    public GammaDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d <= 0.0d) {
            throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, Double.valueOf(d));
        }
        if (d6 > 0.0d) {
            this.shape = d;
            this.scale = d6;
            this.solverAbsoluteAccuracy = d7;
            double d8 = d + 4.7421875d;
            double d9 = d8 + 0.5d;
            this.shiftedShape = d9;
            double d10 = 2.718281828459045d / (6.283185307179586d * d9);
            double dSqrt = (FastMath.sqrt(d10) * d) / Gamma.lanczos(d);
            this.densityPrefactor2 = dSqrt;
            double dLog = ((FastMath.log(d10) * 0.5d) + FastMath.log(d)) - FastMath.log(Gamma.lanczos(d));
            this.logDensityPrefactor2 = dLog;
            this.densityPrefactor1 = FastMath.exp(d8) * FastMath.pow(d9, -d) * (dSqrt / d6);
            this.logDensityPrefactor1 = ((dLog - FastMath.log(d6)) - (FastMath.log(d9) * d)) + d + 4.7421875d;
            this.minY = d8 - FastMath.log(Double.MAX_VALUE);
            this.maxLogY = FastMath.log(Double.MAX_VALUE) / (d - 1.0d);
            return;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, Double.valueOf(d6));
    }
}
