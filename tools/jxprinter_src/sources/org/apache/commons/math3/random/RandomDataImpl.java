package org.apache.commons.math3.random;

import java.io.Serializable;
import java.util.Collection;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class RandomDataImpl implements RandomData, Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private final RandomDataGenerator delegate;

    public RandomDataImpl() {
        this.delegate = new RandomDataGenerator();
    }

    @Deprecated
    public RandomDataGenerator getDelegate() {
        return this.delegate;
    }

    public double nextBeta(double d, double d6) {
        return this.delegate.nextBeta(d, d6);
    }

    public int nextBinomial(int i5, double d) {
        return this.delegate.nextBinomial(i5, d);
    }

    public double nextCauchy(double d, double d6) {
        return this.delegate.nextCauchy(d, d6);
    }

    public double nextChiSquare(double d) {
        return this.delegate.nextChiSquare(d);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextExponential(double d) {
        return this.delegate.nextExponential(d);
    }

    public double nextF(double d, double d6) {
        return this.delegate.nextF(d, d6);
    }

    public double nextGamma(double d, double d6) {
        return this.delegate.nextGamma(d, d6);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextGaussian(double d, double d6) {
        return this.delegate.nextGaussian(d, d6);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextHexString(int i5) {
        return this.delegate.nextHexString(i5);
    }

    public int nextHypergeometric(int i5, int i6, int i7) {
        return this.delegate.nextHypergeometric(i5, i6, i7);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextInt(int i5, int i6) {
        return this.delegate.nextInt(i5, i6);
    }

    @Deprecated
    public double nextInversionDeviate(RealDistribution realDistribution) {
        return realDistribution.inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextLong(long j6, long j7) {
        return this.delegate.nextLong(j6, j7);
    }

    public int nextPascal(int i5, double d) {
        return this.delegate.nextPascal(i5, d);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int[] nextPermutation(int i5, int i6) {
        return this.delegate.nextPermutation(i5, i6);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextPoisson(double d) {
        return this.delegate.nextPoisson(d);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public Object[] nextSample(Collection<?> collection, int i5) {
        return this.delegate.nextSample(collection, i5);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextSecureHexString(int i5) {
        return this.delegate.nextSecureHexString(i5);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextSecureInt(int i5, int i6) {
        return this.delegate.nextSecureInt(i5, i6);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextSecureLong(long j6, long j7) {
        return this.delegate.nextSecureLong(j6, j7);
    }

    public double nextT(double d) {
        return this.delegate.nextT(d);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double d, double d6) {
        return this.delegate.nextUniform(d, d6);
    }

    public double nextWeibull(double d, double d6) {
        return this.delegate.nextWeibull(d, d6);
    }

    public int nextZipf(int i5, double d) {
        return this.delegate.nextZipf(i5, d);
    }

    public void reSeed(long j6) {
        this.delegate.reSeed(j6);
    }

    public void reSeedSecure() {
        this.delegate.reSeedSecure();
    }

    public void setSecureAlgorithm(String str, String str2) {
        this.delegate.setSecureAlgorithm(str, str2);
    }

    @Deprecated
    public int nextInversionDeviate(IntegerDistribution integerDistribution) {
        return integerDistribution.inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double d, double d6, boolean z6) {
        return this.delegate.nextUniform(d, d6, z6);
    }

    public void reSeed() {
        this.delegate.reSeed();
    }

    public void reSeedSecure(long j6) {
        this.delegate.reSeedSecure(j6);
    }

    public RandomDataImpl(RandomGenerator randomGenerator) {
        this.delegate = new RandomDataGenerator(randomGenerator);
    }
}
