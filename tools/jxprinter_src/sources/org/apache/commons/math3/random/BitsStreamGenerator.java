package org.apache.commons.math3.random;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BitsStreamGenerator implements RandomGenerator, Serializable {
    private static final long serialVersionUID = 20130104;
    private double nextGaussian = Double.NaN;

    private void nextBytesFill(byte[] bArr, int i5, int i6) {
        int i7 = (2147483644 & i6) + i5;
        int i8 = i5;
        while (i8 < i7) {
            int next = next(32);
            bArr[i8] = (byte) next;
            bArr[i8 + 1] = (byte) (next >>> 8);
            int i9 = i8 + 3;
            bArr[i8 + 2] = (byte) (next >>> 16);
            i8 += 4;
            bArr[i9] = (byte) (next >>> 24);
        }
        int i10 = i5 + i6;
        if (i8 >= i10) {
            return;
        }
        int next2 = next(32);
        while (true) {
            int i11 = i8 + 1;
            bArr[i8] = (byte) next2;
            if (i11 >= i10) {
                return;
            }
            next2 >>>= 8;
            i8 = i11;
        }
    }

    public void clear() {
        this.nextGaussian = Double.NaN;
    }

    public abstract int next(int i5);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public boolean nextBoolean() {
        return next(1) != 0;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public void nextBytes(byte[] bArr) {
        nextBytesFill(bArr, 0, bArr.length);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextDouble() {
        return ((((long) next(26)) << 26) | ((long) next(26))) * 2.220446049250313E-16d;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public float nextFloat() {
        return next(23) * 1.1920929E-7f;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public double nextGaussian() {
        if (!Double.isNaN(this.nextGaussian)) {
            double d = this.nextGaussian;
            this.nextGaussian = Double.NaN;
            return d;
        }
        double dNextDouble = nextDouble() * 6.283185307179586d;
        double dSqrt = FastMath.sqrt(FastMath.log(nextDouble()) * (-2.0d));
        double dCos = FastMath.cos(dNextDouble) * dSqrt;
        this.nextGaussian = FastMath.sin(dNextDouble) * dSqrt;
        return dCos;
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt() {
        return next(32);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public long nextLong() {
        return (((long) next(32)) << 32) | (((long) next(32)) & KeyboardMap.kValueMask);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(int i5);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(long j6);

    @Override // org.apache.commons.math3.random.RandomGenerator
    public abstract void setSeed(int[] iArr);

    public void nextBytes(byte[] bArr, int i5, int i6) {
        if (i5 < 0 || i5 >= bArr.length) {
            throw new OutOfRangeException(Integer.valueOf(i5), 0, Integer.valueOf(bArr.length));
        }
        if (i6 < 0 || i6 > bArr.length - i5) {
            throw new OutOfRangeException(Integer.valueOf(i6), 0, Integer.valueOf(bArr.length - i5));
        }
        nextBytesFill(bArr, i5, i6);
    }

    @Override // org.apache.commons.math3.random.RandomGenerator
    public int nextInt(int i5) {
        int next;
        int i6;
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        if (((-i5) & i5) == i5) {
            return (int) ((((long) i5) * ((long) next(31))) >> 31);
        }
        do {
            next = next(31);
            i6 = next % i5;
        } while ((i5 - 1) + (next - i6) < 0);
        return i6;
    }

    public long nextLong(long j6) {
        long next;
        long j7;
        if (j6 <= 0) {
            throw new NotStrictlyPositiveException(Long.valueOf(j6));
        }
        do {
            next = (((long) next(31)) << 32) | (((long) next(32)) & KeyboardMap.kValueMask);
            j7 = next % j6;
        } while ((j6 - 1) + (next - j7) < 0);
        return j7;
    }
}
