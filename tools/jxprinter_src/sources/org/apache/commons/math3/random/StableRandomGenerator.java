package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StableRandomGenerator implements NormalizedRandomGenerator {
    private final double alpha;
    private final double beta;
    private final RandomGenerator generator;
    private final double zeta;

    public StableRandomGenerator(RandomGenerator randomGenerator, double d, double d6) {
        if (randomGenerator == null) {
            throw new NullArgumentException();
        }
        if (d <= 0.0d || d > 2.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, Double.valueOf(d), 0, 2);
        }
        if (d6 < -1.0d || d6 > 1.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, Double.valueOf(d6), -1, 1);
        }
        this.generator = randomGenerator;
        this.alpha = d;
        this.beta = d6;
        if (d >= 2.0d || d6 == 0.0d) {
            this.zeta = 0.0d;
        } else {
            this.zeta = FastMath.tan((d * 3.141592653589793d) / 2.0d) * d6;
        }
    }

    @Override // org.apache.commons.math3.random.NormalizedRandomGenerator
    public double nextNormalizedDouble() {
        double d = -FastMath.log(this.generator.nextDouble());
        double dNextDouble = (this.generator.nextDouble() - 0.5d) * 3.141592653589793d;
        double d6 = this.alpha;
        if (d6 == 2.0d) {
            return FastMath.sin(dNextDouble) * FastMath.sqrt(d * 2.0d);
        }
        if (this.beta == 0.0d) {
            if (d6 == 1.0d) {
                return FastMath.tan(dNextDouble);
            }
            return (FastMath.sin(this.alpha * dNextDouble) * FastMath.pow(FastMath.cos((1.0d - d6) * dNextDouble) * d, (1.0d / this.alpha) - 1.0d)) / FastMath.pow(FastMath.cos(dNextDouble), 1.0d / this.alpha);
        }
        double dCos = FastMath.cos(dNextDouble);
        if (FastMath.abs(this.alpha - 1.0d) <= 1.0E-8d) {
            double d7 = (this.beta * dNextDouble) + 1.5707963267948966d;
            double dTan = ((FastMath.tan(dNextDouble) * d7) - (FastMath.log(((d * 1.5707963267948966d) * dCos) / d7) * this.beta)) * 0.6366197723675814d;
            double d8 = this.alpha;
            if (d8 == 1.0d) {
                return dTan;
            }
            return (FastMath.tan((d8 * 3.141592653589793d) / 2.0d) * this.beta) + dTan;
        }
        double d9 = this.alpha * dNextDouble;
        double d10 = dNextDouble - d9;
        double dSin = ((FastMath.sin(d10) * this.zeta) + FastMath.cos(d10)) * (((FastMath.cos(d9) * this.zeta) + FastMath.sin(d9)) / dCos);
        double d11 = this.alpha;
        return dSin / FastMath.pow(d * dCos, (1.0d - d11) / d11);
    }
}
