package S3;

import A3.AbstractC0157z;
import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final e Default = new e();
    private static final f defaultRandom = I3.c.IMPLEMENTATIONS.defaultPlatformRandom();

    public abstract int b(int i5);

    public abstract int c();

    public int d(int i5) {
        return e(0, i5);
    }

    public int e(int i5, int i6) {
        int iC;
        int i7;
        int iB;
        if (i6 <= i5) {
            throw new IllegalArgumentException(g.boundsErrorMessage(Integer.valueOf(i5), Integer.valueOf(i6)).toString());
        }
        int i8 = i6 - i5;
        if (i8 > 0 || i8 == Integer.MIN_VALUE) {
            if (((-i8) & i8) == i8) {
                iB = b(31 - Integer.numberOfLeadingZeros(i8));
            } else {
                do {
                    iC = c() >>> 1;
                    i7 = iC % i8;
                } while ((i8 - 1) + (iC - i7) < 0);
                iB = i7;
            }
            return i5 + iB;
        }
        while (true) {
            int iC2 = c();
            if (i5 <= iC2 && iC2 < i6) {
                return iC2;
            }
        }
    }

    public long f() {
        return (((long) c()) << 32) + ((long) c());
    }

    public long g(long j6, long j7) {
        long jF;
        long j8;
        long jB;
        int iC;
        if (j7 <= j6) {
            throw new IllegalArgumentException(g.boundsErrorMessage(Long.valueOf(j6), Long.valueOf(j7)).toString());
        }
        long j9 = j7 - j6;
        if (j9 > 0) {
            if (((-j9) & j9) == j9) {
                int i5 = (int) j9;
                int i6 = (int) (j9 >>> 32);
                if (i5 != 0) {
                    iC = b(31 - Integer.numberOfLeadingZeros(i5));
                } else if (i6 == 1) {
                    iC = c();
                } else {
                    jB = (((long) b(31 - Integer.numberOfLeadingZeros(i6))) << 32) + (((long) c()) & KeyboardMap.kValueMask);
                }
                jB = ((long) iC) & KeyboardMap.kValueMask;
            } else {
                do {
                    jF = f() >>> 1;
                    j8 = jF % j9;
                } while ((j9 - 1) + (jF - j8) < 0);
                jB = j8;
            }
            return j6 + jB;
        }
        while (true) {
            long jF2 = f();
            if (j6 <= jF2 && jF2 < j7) {
                return jF2;
            }
        }
    }

    public byte[] nextBytes(byte[] array, int i5, int i6) {
        E.f(array, "array");
        if (i5 < 0 || i5 > array.length || i6 < 0 || i6 > array.length) {
            throw new IllegalArgumentException(AbstractC0157z.p(androidx.collection.a.s("fromIndex (", i5, i6, ") or toIndex (", ") are out of range: 0.."), array.length, '.').toString());
        }
        if (i5 > i6) {
            throw new IllegalArgumentException(androidx.collection.a.m("fromIndex (", i5, i6, ") must be not greater than toIndex (", ").").toString());
        }
        int i7 = (i6 - i5) / 4;
        for (int i8 = 0; i8 < i7; i8++) {
            int iC = c();
            array[i5] = (byte) iC;
            array[i5 + 1] = (byte) (iC >>> 8);
            array[i5 + 2] = (byte) (iC >>> 16);
            array[i5 + 3] = (byte) (iC >>> 24);
            i5 += 4;
        }
        int i9 = i6 - i5;
        int iB = b(i9 * 8);
        for (int i10 = 0; i10 < i9; i10++) {
            array[i5 + i10] = (byte) (iB >>> (i10 * 8));
        }
        return array;
    }

    public byte[] nextBytes(byte[] array) {
        E.f(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int i5) {
        return nextBytes(new byte[i5]);
    }
}
