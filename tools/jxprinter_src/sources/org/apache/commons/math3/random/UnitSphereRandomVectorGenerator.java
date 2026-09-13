package org.apache.commons.math3.random;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnitSphereRandomVectorGenerator implements RandomVectorGenerator {
    private final int dimension;
    private final RandomGenerator rand;

    public UnitSphereRandomVectorGenerator(int i5, RandomGenerator randomGenerator) {
        this.dimension = i5;
        this.rand = randomGenerator;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] dArr = new double[this.dimension];
        double d = 0.0d;
        for (int i5 = 0; i5 < this.dimension; i5++) {
            double dNextGaussian = this.rand.nextGaussian();
            dArr[i5] = dNextGaussian;
            d += dNextGaussian * dNextGaussian;
        }
        double dSqrt = 1.0d / FastMath.sqrt(d);
        for (int i6 = 0; i6 < this.dimension; i6++) {
            dArr[i6] = dArr[i6] * dSqrt;
        }
        return dArr;
    }

    public UnitSphereRandomVectorGenerator(int i5) {
        this(i5, new MersenneTwister());
    }
}
