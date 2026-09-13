package org.apache.commons.math3.distribution;

import com.google.android.gms.auth.api.accounttransfer.a;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TriangularDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20120112;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f6765a;
    private final double b;
    private final double c;
    private final double solverAbsoluteAccuracy;

    public TriangularDistribution(double d, double d6, double d7) {
        this(new Well19937c(), d, d6, d7);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        double d6 = this.f6765a;
        if (d < d6) {
            return 0.0d;
        }
        if (d6 <= d) {
            double d7 = this.c;
            if (d < d7) {
                return ((d - d6) * (d - d6)) / ((d7 - d6) * (this.b - d6));
            }
        }
        double d8 = this.c;
        if (d == d8) {
            return (d8 - d6) / (this.b - d6);
        }
        if (d8 >= d) {
            return 1.0d;
        }
        double d9 = this.b;
        if (d > d9) {
            return 1.0d;
        }
        return 1.0d - (((d9 - d) * (d9 - d)) / ((d9 - d8) * (d9 - d6)));
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        double d6 = this.f6765a;
        if (d < d6) {
            return 0.0d;
        }
        if (d6 <= d) {
            double d7 = this.c;
            if (d < d7) {
                return ((d - d6) * 2.0d) / ((d7 - d6) * (this.b - d6));
            }
        }
        double d8 = this.c;
        if (d == d8) {
            return 2.0d / (this.b - d6);
        }
        if (d8 < d) {
            double d9 = this.b;
            if (d <= d9) {
                return ((d9 - d) * 2.0d) / ((d9 - d8) * (d9 - d6));
            }
        }
        return 0.0d;
    }

    public double getMode() {
        return this.c;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return ((this.f6765a + this.b) + this.c) / 3.0d;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        double d = this.f6765a;
        double d6 = this.b;
        double d7 = (d6 * d6) + (d * d);
        double d8 = this.c;
        return a.a(d6, d8, (((d8 * d8) + d7) - (d * d6)) - (d * d8), 18.0d);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution
    public double getSolverAbsoluteAccuracy() {
        return this.solverAbsoluteAccuracy;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.f6765a;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.b;
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double d) {
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d == 0.0d) {
            return this.f6765a;
        }
        if (d == 1.0d) {
            return this.b;
        }
        double d6 = this.c;
        double d7 = this.f6765a;
        double d8 = this.b;
        if (d < (d6 - d7) / (d8 - d7)) {
            return FastMath.sqrt((d6 - d7) * (d8 - d7) * d) + d7;
        }
        return d8 - FastMath.sqrt((d8 - d6) * ((d8 - d7) * (1.0d - d)));
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

    public TriangularDistribution(RandomGenerator randomGenerator, double d, double d6, double d7) {
        super(randomGenerator);
        if (d >= d7) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(d), Double.valueOf(d7), false);
        }
        if (d6 < d) {
            throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, Double.valueOf(d6), Double.valueOf(d), true);
        }
        if (d6 > d7) {
            throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_TOO_LARGE, Double.valueOf(d6), Double.valueOf(d7), true);
        }
        this.f6765a = d;
        this.c = d6;
        this.b = d7;
        this.solverAbsoluteAccuracy = FastMath.max(FastMath.ulp(d), FastMath.ulp(d7));
    }
}
