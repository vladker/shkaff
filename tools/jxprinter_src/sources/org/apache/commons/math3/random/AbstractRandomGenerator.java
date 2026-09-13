package org.apache.commons.math3.random;

import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractRandomGenerator implements RandomGenerator {
    private double cachedNormalDeviate = Double.NaN;

    public void clear() {
        this.cachedNormalDeviate = Double.NaN;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        return nextDouble() <= 0.5d;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] bArr) {
        int i5 = 0;
        while (i5 < bArr.length) {
            int iNextInt = nextInt();
            int i6 = 0;
            while (i6 < 3) {
                if (i6 > 0) {
                    iNextInt >>= 8;
                }
                int i7 = i5 + 1;
                bArr[i5] = (byte) iNextInt;
                if (i7 == bArr.length) {
                    return;
                }
                i6++;
                i5 = i7;
            }
        }
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract double nextDouble();

    @Override // org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return (float) nextDouble();
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        if (!Double.isNaN(this.cachedNormalDeviate)) {
            double d = this.cachedNormalDeviate;
            this.cachedNormalDeviate = Double.NaN;
            return d;
        }
        double d6 = 0.0d;
        double dNextDouble = 0.0d;
        double dSqrt = 1.0d;
        while (dSqrt >= 1.0d) {
            double dNextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            dNextDouble = (nextDouble() * 2.0d) - 1.0d;
            d6 = dNextDouble2;
            dSqrt = (dNextDouble2 * dNextDouble2) + (dNextDouble * dNextDouble);
        }
        if (dSqrt != 0.0d) {
            dSqrt = FastMath.sqrt((FastMath.log(dSqrt) * (-2.0d)) / dSqrt);
        }
        this.cachedNormalDeviate = dNextDouble * dSqrt;
        return d6 * dSqrt;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return (int) (((nextDouble() * 2.0d) - 1.0d) * 2.147483647E9d);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return (long) (((nextDouble() * 2.0d) - 1.0d) * 9.223372036854776E18d);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int i5) {
        setSeed(i5);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(long j6);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int i5) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        int iNextDouble = (int) (nextDouble() * ((double) i5));
        return iNextDouble < i5 ? iNextDouble : i5 - 1;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] iArr) {
        long j6 = 0;
        for (int i5 : iArr) {
            j6 = (j6 * 4294967291L) + ((long) i5);
        }
        setSeed(j6);
    }
}
