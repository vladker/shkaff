package org.apache.commons.math3.random;

import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomAdaptor extends Random implements RandomGenerator {
    private static final long serialVersionUID = 2306581345647615033L;
    private final RandomGenerator randomGenerator;

    private RandomAdaptor() {
        this.randomGenerator = null;
    }

    public static Random createAdaptor(RandomGenerator randomGenerator) {
        return new RandomAdaptor(randomGenerator);
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        return this.randomGenerator.nextBoolean();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] bArr) {
        this.randomGenerator.nextBytes(bArr);
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public double nextDouble() {
        return this.randomGenerator.nextDouble();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return this.randomGenerator.nextFloat();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        return this.randomGenerator.nextGaussian();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return this.randomGenerator.nextInt();
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return this.randomGenerator.nextLong();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int i5) {
        RandomGenerator randomGenerator = this.randomGenerator;
        if (randomGenerator != null) {
            randomGenerator.setSeed(i5);
        }
    }

    public RandomAdaptor(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int i5) {
        return this.randomGenerator.nextInt(i5);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] iArr) {
        RandomGenerator randomGenerator = this.randomGenerator;
        if (randomGenerator != null) {
            randomGenerator.setSeed(iArr);
        }
    }

    @Override // java.util.Random, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long j6) {
        RandomGenerator randomGenerator = this.randomGenerator;
        if (randomGenerator != null) {
            randomGenerator.setSeed(j6);
        }
    }
}
