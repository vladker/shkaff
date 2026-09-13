package org.apache.commons.math3.random;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MersenneTwister extends BitsStreamGenerator implements Serializable {

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int f6884M = 397;
    private static final int[] MAG01 = {0, -1727483681};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int f6885N = 624;
    private static final long serialVersionUID = 8661194735290153518L;
    private int[] mt;
    private int mti;

    public MersenneTwister() {
        this.mt = new int[f6885N];
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    public int next(int i5) {
        int i6;
        if (this.mti >= f6885N) {
            int i7 = this.mt[0];
            int i8 = 0;
            while (true) {
                i6 = 227;
                if (i8 >= 227) {
                    break;
                }
                int[] iArr = this.mt;
                int i9 = i8 + 1;
                int i10 = iArr[i9];
                int i11 = (i7 & Integer.MIN_VALUE) | (Integer.MAX_VALUE & i10);
                iArr[i8] = MAG01[i11 & 1] ^ (iArr[i8 + f6884M] ^ (i11 >>> 1));
                i8 = i9;
                i7 = i10;
            }
            while (i6 < 623) {
                int[] iArr2 = this.mt;
                int i12 = i6 + 1;
                int i13 = iArr2[i12];
                int i14 = (i7 & Integer.MIN_VALUE) | (i13 & Integer.MAX_VALUE);
                iArr2[i6] = MAG01[i14 & 1] ^ (iArr2[i6 - 227] ^ (i14 >>> 1));
                i6 = i12;
                i7 = i13;
            }
            int[] iArr3 = this.mt;
            int i15 = (i7 & Integer.MIN_VALUE) | (Integer.MAX_VALUE & iArr3[0]);
            iArr3[623] = MAG01[i15 & 1] ^ (iArr3[396] ^ (i15 >>> 1));
            this.mti = 0;
        }
        int[] iArr4 = this.mt;
        int i16 = this.mti;
        this.mti = i16 + 1;
        int i17 = iArr4[i16];
        int i18 = i17 ^ (i17 >>> 11);
        int i19 = i18 ^ ((i18 << 7) & (-1658038656));
        int i20 = i19 ^ ((i19 << 15) & (-272236544));
        return (i20 ^ (i20 >>> 18)) >>> (32 - i5);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int i5) {
        long j6 = i5;
        this.mt[0] = (int) j6;
        int i6 = 1;
        while (true) {
            this.mti = i6;
            int i7 = this.mti;
            if (i7 >= f6885N) {
                clear();
                return;
            } else {
                j6 = (((j6 ^ (j6 >> 30)) * 1812433253) + ((long) i7)) & KeyboardMap.kValueMask;
                this.mt[i7] = (int) j6;
                i6 = i7 + 1;
            }
        }
    }

    public MersenneTwister(int i5) {
        this.mt = new int[f6885N];
        setSeed(i5);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] iArr) {
        if (iArr == null) {
            setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
            return;
        }
        setSeed(19650218);
        int iMax = FastMath.max(f6885N, iArr.length);
        int i5 = 1;
        int i6 = 0;
        while (true) {
            if (iMax == 0) {
                break;
            }
            int[] iArr2 = this.mt;
            int i7 = iArr2[i5];
            long j6 = (((long) i7) & 2147483647L) | (i7 < 0 ? 2147483648L : 0L);
            int i8 = iArr2[i5 - 1];
            long j7 = (((long) i8) & 2147483647L) | (i8 < 0 ? 2147483648L : 0L);
            iArr2[i5] = (int) (((j6 ^ ((j7 ^ (j7 >> 30)) * 1664525)) + ((long) iArr[i6]) + ((long) i6)) & KeyboardMap.kValueMask);
            i5++;
            i6++;
            if (i5 >= f6885N) {
                iArr2[0] = iArr2[623];
                i5 = 1;
            }
            if (i6 >= iArr.length) {
                i6 = 0;
            }
            iMax--;
        }
        for (int i9 = 623; i9 != 0; i9--) {
            int[] iArr3 = this.mt;
            int i10 = iArr3[i5];
            long j8 = (i10 < 0 ? 2147483648L : 0L) | (((long) i10) & 2147483647L);
            int i11 = iArr3[i5 - 1];
            long j9 = (((long) i11) & 2147483647L) | (i11 < 0 ? 2147483648L : 0L);
            iArr3[i5] = (int) (((j8 ^ ((j9 ^ (j9 >> 30)) * 1566083941)) - ((long) i5)) & KeyboardMap.kValueMask);
            i5++;
            if (i5 >= f6885N) {
                iArr3[0] = iArr3[623];
                i5 = 1;
            }
        }
        this.mt[0] = Integer.MIN_VALUE;
        clear();
    }

    public MersenneTwister(int[] iArr) {
        this.mt = new int[f6885N];
        setSeed(iArr);
    }

    public MersenneTwister(long j6) {
        this.mt = new int[f6885N];
        setSeed(j6);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long j6) {
        setSeed(new int[]{(int) (j6 >>> 32), (int) (j6 & KeyboardMap.kValueMask)});
    }
}
