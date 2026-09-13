package org.apache.commons.math3.random;

import androidx.collection.a;
import androidx.core.location.LocationRequestCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.CauchyDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.distribution.PascalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomDataGenerator implements RandomData, Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private RandomGenerator rand;
    private RandomGenerator secRand;

    public RandomDataGenerator() {
        this.rand = null;
        this.secRand = null;
    }

    private RandomGenerator getSecRan() {
        if (this.secRand == null) {
            RandomGenerator randomGeneratorCreateRandomGenerator = RandomGeneratorFactory.createRandomGenerator(new SecureRandom());
            this.secRand = randomGeneratorCreateRandomGenerator;
            randomGeneratorCreateRandomGenerator.setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
        }
        return this.secRand;
    }

    private void initRan() {
        this.rand = new Well19937c(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    public RandomGenerator getRandomGenerator() {
        if (this.rand == null) {
            initRan();
        }
        return this.rand;
    }

    public double nextBeta(double d, double d6) {
        return new BetaDistribution(getRandomGenerator(), d, d6, 1.0E-9d).sample();
    }

    public int nextBinomial(int i5, double d) {
        return new BinomialDistribution(getRandomGenerator(), i5, d).sample();
    }

    public double nextCauchy(double d, double d6) {
        return new CauchyDistribution(getRandomGenerator(), d, d6, 1.0E-9d).sample();
    }

    public double nextChiSquare(double d) {
        return new ChiSquaredDistribution(getRandomGenerator(), d, 1.0E-9d).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextExponential(double d) {
        return new ExponentialDistribution(getRandomGenerator(), d, 1.0E-9d).sample();
    }

    public double nextF(double d, double d6) {
        return new FDistribution(getRandomGenerator(), d, d6, 1.0E-9d).sample();
    }

    public double nextGamma(double d, double d6) {
        return new GammaDistribution(getRandomGenerator(), d, d6, 1.0E-9d).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextGaussian(double d, double d6) {
        if (d6 > 0.0d) {
            return (getRandomGenerator().nextGaussian() * d6) + d;
        }
        throw new NotStrictlyPositiveException(LocalizedFormats.STANDARD_DEVIATION, Double.valueOf(d6));
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextHexString(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(i5));
        }
        RandomGenerator randomGenerator = getRandomGenerator();
        StringBuilder sb = new StringBuilder();
        int i6 = (i5 / 2) + 1;
        byte[] bArr = new byte[i6];
        randomGenerator.nextBytes(bArr);
        for (int i7 = 0; i7 < i6; i7++) {
            String hexString = Integer.toHexString(bArr[i7] + UnsignedBytes.MAX_POWER_OF_TWO);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb.append(hexString);
        }
        return sb.toString().substring(0, i5);
    }

    public int nextHypergeometric(int i5, int i6, int i7) {
        return new HypergeometricDistribution(getRandomGenerator(), i5, i6, i7).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextInt(int i5, int i6) {
        return new UniformIntegerDistribution(getRandomGenerator(), i5, i6).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextLong(long j6, long j7) {
        if (j6 >= j7) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(j6), Long.valueOf(j7), false);
        }
        long j8 = (j7 - j6) + 1;
        if (j8 > 0) {
            return j6 + (j8 < 2147483647L ? getRandomGenerator().nextInt((int) j8) : nextLong(getRandomGenerator(), j8));
        }
        RandomGenerator randomGenerator = getRandomGenerator();
        while (true) {
            long jNextLong = randomGenerator.nextLong();
            if (jNextLong >= j6 && jNextLong <= j7) {
                return jNextLong;
            }
        }
    }

    public int nextPascal(int i5, double d) {
        return new PascalDistribution(getRandomGenerator(), i5, d).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int[] nextPermutation(int i5, int i6) {
        if (i6 > i5) {
            throw new NumberIsTooLargeException(LocalizedFormats.PERMUTATION_EXCEEDS_N, Integer.valueOf(i6), Integer.valueOf(i5), true);
        }
        if (i6 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.PERMUTATION_SIZE, Integer.valueOf(i6));
        }
        int[] iArrNatural = MathArrays.natural(i5);
        MathArrays.shuffle(iArrNatural, getRandomGenerator());
        return MathArrays.copyOf(iArrNatural, i6);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextPoisson(double d) {
        return new PoissonDistribution(getRandomGenerator(), d, 1.0E-12d, PoissonDistribution.DEFAULT_MAX_ITERATIONS).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public Object[] nextSample(Collection<?> collection, int i5) {
        int size = collection.size();
        if (i5 > size) {
            throw new NumberIsTooLargeException(LocalizedFormats.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE, Integer.valueOf(i5), Integer.valueOf(size), true);
        }
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_SAMPLES, Integer.valueOf(i5));
        }
        Object[] array = collection.toArray();
        int[] iArrNextPermutation = nextPermutation(size, i5);
        Object[] objArr = new Object[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            objArr[i6] = array[iArrNextPermutation[i6]];
        }
        return objArr;
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextSecureHexString(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(i5));
        }
        RandomGenerator secRan = getSecRan();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.reset();
            int i6 = i5 / 40;
            StringBuilder sb = new StringBuilder();
            int i7 = 1;
            while (true) {
                if (i7 >= i6 + 2) {
                    return sb.toString().substring(0, i5);
                }
                byte[] bArr = new byte[40];
                secRan.nextBytes(bArr);
                messageDigest.update(bArr);
                for (byte b : messageDigest.digest()) {
                    String hexString = Integer.toHexString(b + UnsignedBytes.MAX_POWER_OF_TWO);
                    if (hexString.length() == 1) {
                        hexString = "0".concat(hexString);
                    }
                    sb.append(hexString);
                }
                i7++;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new MathInternalError(e);
        }
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextSecureInt(int i5, int i6) {
        return new UniformIntegerDistribution(getSecRan(), i5, i6).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextSecureLong(long j6, long j7) {
        if (j6 >= j7) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Long.valueOf(j6), Long.valueOf(j7), false);
        }
        RandomGenerator secRan = getSecRan();
        long j8 = (j7 - j6) + 1;
        if (j8 > 0) {
            return j6 + (j8 < 2147483647L ? secRan.nextInt((int) j8) : nextLong(secRan, j8));
        }
        while (true) {
            long jNextLong = secRan.nextLong();
            if (jNextLong >= j6 && jNextLong <= j7) {
                return jNextLong;
            }
        }
    }

    public double nextT(double d) {
        return new TDistribution(getRandomGenerator(), d, 1.0E-9d).sample();
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double d, double d6) {
        return nextUniform(d, d6, false);
    }

    public double nextWeibull(double d, double d6) {
        return new WeibullDistribution(getRandomGenerator(), d, d6, 1.0E-9d).sample();
    }

    public int nextZipf(int i5, double d) {
        return new ZipfDistribution(getRandomGenerator(), i5, d).sample();
    }

    public void reSeed(long j6) {
        getRandomGenerator().setSeed(j6);
    }

    public void reSeedSecure() {
        getSecRan().setSeed(System.currentTimeMillis());
    }

    public void setSecureAlgorithm(String str, String str2) {
        this.secRand = RandomGeneratorFactory.createRandomGenerator(SecureRandom.getInstance(str, str2));
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double d, double d6, boolean z6) {
        if (d >= d6) {
            throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, Double.valueOf(d), Double.valueOf(d6), false);
        }
        if (Double.isInfinite(d)) {
            throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, Double.valueOf(d), new Object[0]);
        }
        if (Double.isInfinite(d6)) {
            throw new NotFiniteNumberException(LocalizedFormats.INFINITE_BOUND, Double.valueOf(d6), new Object[0]);
        }
        if (Double.isNaN(d) || Double.isNaN(d6)) {
            throw new NotANumberException();
        }
        RandomGenerator randomGenerator = getRandomGenerator();
        double dNextDouble = randomGenerator.nextDouble();
        while (!z6 && dNextDouble <= 0.0d) {
            dNextDouble = randomGenerator.nextDouble();
        }
        return a.a(1.0d, dNextDouble, d, dNextDouble * d6);
    }

    public void reSeed() {
        getRandomGenerator().setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    public void reSeedSecure(long j6) {
        getSecRan().setSeed(j6);
    }

    public RandomDataGenerator(RandomGenerator randomGenerator) {
        this.secRand = null;
        this.rand = randomGenerator;
    }

    private static long nextLong(RandomGenerator randomGenerator, long j6) {
        long j7;
        long j8;
        if (j6 > 0) {
            byte[] bArr = new byte[8];
            do {
                randomGenerator.nextBytes(bArr);
                long j9 = 0;
                for (int i5 = 0; i5 < 8; i5++) {
                    j9 = (j9 << 8) | (((long) bArr[i5]) & 255);
                }
                j7 = j9 & LocationRequestCompat.PASSIVE_INTERVAL;
                j8 = j7 % j6;
            } while ((j6 - 1) + (j7 - j8) < 0);
            return j8;
        }
        throw new NotStrictlyPositiveException(Long.valueOf(j6));
    }
}
