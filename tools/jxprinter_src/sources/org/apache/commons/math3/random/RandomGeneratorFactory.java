package org.apache.commons.math3.random;

import java.util.Random;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomGeneratorFactory {
    private RandomGeneratorFactory() {
    }

    public static long convertToLong(int[] iArr) {
        long j6 = 0;
        for (int i5 : iArr) {
            j6 = (j6 * 4294967291L) + ((long) i5);
        }
        return j6;
    }

    public static RandomGenerator createRandomGenerator(final Random random) {
        return new RandomGenerator() { // from class: org.apache.commons.math3.random.RandomGeneratorFactory.1
            @Override // org.apache.commons.math3.random.RandomGenerator
            public boolean nextBoolean() {
                return random.nextBoolean();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public void nextBytes(byte[] bArr) {
                random.nextBytes(bArr);
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public double nextDouble() {
                return random.nextDouble();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public float nextFloat() {
                return random.nextFloat();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public double nextGaussian() {
                return random.nextGaussian();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public int nextInt() {
                return random.nextInt();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public long nextLong() {
                return random.nextLong();
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public void setSeed(int i5) {
                random.setSeed(i5);
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public int nextInt(int i5) {
                if (i5 > 0) {
                    return random.nextInt(i5);
                }
                throw new NotStrictlyPositiveException(Integer.valueOf(i5));
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public void setSeed(int[] iArr) {
                random.setSeed(RandomGeneratorFactory.convertToLong(iArr));
            }

            @Override // org.apache.commons.math3.random.RandomGenerator
            public void setSeed(long j6) {
                random.setSeed(j6);
            }
        };
    }
}
