package org.apache.commons.math3.random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SynchronizedRandomGenerator implements RandomGenerator {
    private final RandomGenerator wrapped;

    public SynchronizedRandomGenerator(RandomGenerator randomGenerator) {
        this.wrapped = randomGenerator;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized boolean nextBoolean() {
        return this.wrapped.nextBoolean();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void nextBytes(byte[] bArr) {
        this.wrapped.nextBytes(bArr);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized double nextDouble() {
        return this.wrapped.nextDouble();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized float nextFloat() {
        return this.wrapped.nextFloat();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized double nextGaussian() {
        return this.wrapped.nextGaussian();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized int nextInt() {
        return this.wrapped.nextInt();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized long nextLong() {
        return this.wrapped.nextLong();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(int i5) {
        this.wrapped.setSeed(i5);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized int nextInt(int i5) {
        return this.wrapped.nextInt(i5);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(int[] iArr) {
        this.wrapped.setSeed(iArr);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public synchronized void setSeed(long j6) {
        this.wrapped.setSeed(j6);
    }
}
