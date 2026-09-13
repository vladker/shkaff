package org.apache.commons.math3.random;

import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UncorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;
    private final double[] mean;
    private final double[] standardDeviation;

    public UncorrelatedRandomVectorGenerator(double[] dArr, double[] dArr2, NormalizedRandomGenerator normalizedRandomGenerator) {
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        this.mean = (double[]) dArr.clone();
        this.standardDeviation = (double[]) dArr2.clone();
        this.generator = normalizedRandomGenerator;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        int length = this.mean.length;
        double[] dArr = new double[length];
        for (int i5 = 0; i5 < length; i5++) {
            dArr[i5] = (this.generator.nextNormalizedDouble() * this.standardDeviation[i5]) + this.mean[i5];
        }
        return dArr;
    }

    public UncorrelatedRandomVectorGenerator(int i5, NormalizedRandomGenerator normalizedRandomGenerator) {
        this.mean = new double[i5];
        double[] dArr = new double[i5];
        this.standardDeviation = dArr;
        Arrays.fill(dArr, 1.0d);
        this.generator = normalizedRandomGenerator;
    }
}
