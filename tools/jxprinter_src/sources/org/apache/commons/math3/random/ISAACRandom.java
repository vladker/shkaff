package org.apache.commons.math3.random;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ISAACRandom extends BitsStreamGenerator implements Serializable {
    private static final int GLD_RATIO = -1640531527;
    private static final int H_SIZE = 128;
    private static final int MASK = 1020;
    private static final int SIZE = 256;
    private static final int SIZE_L = 8;
    private static final long serialVersionUID = 7288197941165002400L;
    private final int[] arr;
    private int count;
    private int isaacA;
    private int isaacB;
    private int isaacC;
    private int isaacI;
    private int isaacJ;
    private int isaacX;
    private final int[] mem;
    private final int[] rsl;

    public ISAACRandom() {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
    }

    private void initState() {
        this.isaacA = 0;
        this.isaacB = 0;
        this.isaacC = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.arr;
            if (i5 >= iArr.length) {
                break;
            }
            iArr[i5] = GLD_RATIO;
            i5++;
        }
        for (int i6 = 0; i6 < 4; i6++) {
            shuffle();
        }
        for (int i7 = 0; i7 < 256; i7 += 8) {
            int[] iArr2 = this.arr;
            int i8 = iArr2[0];
            int[] iArr3 = this.rsl;
            iArr2[0] = i8 + iArr3[i7];
            iArr2[1] = iArr2[1] + iArr3[i7 + 1];
            iArr2[2] = iArr2[2] + iArr3[i7 + 2];
            iArr2[3] = iArr2[3] + iArr3[i7 + 3];
            iArr2[4] = iArr2[4] + iArr3[i7 + 4];
            iArr2[5] = iArr2[5] + iArr3[i7 + 5];
            iArr2[6] = iArr2[6] + iArr3[i7 + 6];
            iArr2[7] = iArr2[7] + iArr3[i7 + 7];
            shuffle();
            setState(i7);
        }
        for (int i9 = 0; i9 < 256; i9 += 8) {
            int[] iArr4 = this.arr;
            int i10 = iArr4[0];
            int[] iArr5 = this.mem;
            iArr4[0] = i10 + iArr5[i9];
            iArr4[1] = iArr4[1] + iArr5[i9 + 1];
            iArr4[2] = iArr4[2] + iArr5[i9 + 2];
            iArr4[3] = iArr4[3] + iArr5[i9 + 3];
            iArr4[4] = iArr4[4] + iArr5[i9 + 4];
            iArr4[5] = iArr4[5] + iArr5[i9 + 5];
            iArr4[6] = iArr4[6] + iArr5[i9 + 6];
            iArr4[7] = iArr4[7] + iArr5[i9 + 7];
            shuffle();
            setState(i9);
        }
        isaac();
        this.count = 255;
        clear();
    }

    private void isaac() {
        this.isaacI = 0;
        this.isaacJ = 128;
        int i5 = this.isaacB;
        int i6 = this.isaacC + 1;
        this.isaacC = i6;
        this.isaacB = i5 + i6;
        while (this.isaacI < 128) {
            isaac2();
        }
        this.isaacJ = 0;
        while (this.isaacJ < 128) {
            isaac2();
        }
    }

    private void isaac2() {
        int[] iArr = this.mem;
        this.isaacX = iArr[this.isaacI];
        int i5 = this.isaacA;
        int i6 = i5 ^ (i5 << 13);
        this.isaacA = i6;
        int i7 = this.isaacJ;
        this.isaacJ = i7 + 1;
        this.isaacA = i6 + iArr[i7];
        isaac3();
        int[] iArr2 = this.mem;
        this.isaacX = iArr2[this.isaacI];
        int i8 = this.isaacA;
        int i9 = i8 ^ (i8 >>> 6);
        this.isaacA = i9;
        int i10 = this.isaacJ;
        this.isaacJ = i10 + 1;
        this.isaacA = i9 + iArr2[i10];
        isaac3();
        int[] iArr3 = this.mem;
        this.isaacX = iArr3[this.isaacI];
        int i11 = this.isaacA;
        int i12 = i11 ^ (i11 << 2);
        this.isaacA = i12;
        int i13 = this.isaacJ;
        this.isaacJ = i13 + 1;
        this.isaacA = i12 + iArr3[i13];
        isaac3();
        int[] iArr4 = this.mem;
        this.isaacX = iArr4[this.isaacI];
        int i14 = this.isaacA;
        int i15 = i14 ^ (i14 >>> 16);
        this.isaacA = i15;
        int i16 = this.isaacJ;
        this.isaacJ = i16 + 1;
        this.isaacA = i15 + iArr4[i16];
        isaac3();
    }

    private void isaac3() {
        int[] iArr = this.mem;
        int i5 = this.isaacI;
        int i6 = this.isaacX;
        int i7 = iArr[(i6 & 1020) >> 2] + this.isaacA + this.isaacB;
        iArr[i5] = i7;
        int i8 = iArr[((i7 >> 8) & 1020) >> 2] + i6;
        this.isaacB = i8;
        int[] iArr2 = this.rsl;
        this.isaacI = i5 + 1;
        iArr2[i5] = i8;
    }

    private void setState(int i5) {
        int[] iArr = this.mem;
        int[] iArr2 = this.arr;
        iArr[i5] = iArr2[0];
        iArr[i5 + 1] = iArr2[1];
        iArr[i5 + 2] = iArr2[2];
        iArr[i5 + 3] = iArr2[3];
        iArr[i5 + 4] = iArr2[4];
        iArr[i5 + 5] = iArr2[5];
        iArr[i5 + 6] = iArr2[6];
        iArr[i5 + 7] = iArr2[7];
    }

    private void shuffle() {
        int[] iArr = this.arr;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = i5 ^ (i6 << 11);
        iArr[0] = i7;
        int i8 = iArr[3] + i7;
        iArr[3] = i8;
        int i9 = iArr[2];
        int i10 = i6 + i9;
        iArr[1] = i10;
        int i11 = i10 ^ (i9 >>> 2);
        iArr[1] = i11;
        int i12 = iArr[4] + i11;
        iArr[4] = i12;
        int i13 = i9 + i8;
        iArr[2] = i13;
        int i14 = i13 ^ (i8 << 8);
        iArr[2] = i14;
        int i15 = iArr[5] + i14;
        iArr[5] = i15;
        int i16 = i8 + i12;
        iArr[3] = i16;
        int i17 = i16 ^ (i12 >>> 16);
        iArr[3] = i17;
        int i18 = iArr[6] + i17;
        iArr[6] = i18;
        int i19 = i12 + i15;
        iArr[4] = i19;
        int i20 = (i15 << 10) ^ i19;
        iArr[4] = i20;
        int i21 = iArr[7] + i20;
        iArr[7] = i21;
        int i22 = i15 + i18;
        iArr[5] = i22;
        int i23 = (i18 >>> 4) ^ i22;
        iArr[5] = i23;
        int i24 = i7 + i23;
        iArr[0] = i24;
        int i25 = i18 + i21;
        iArr[6] = i25;
        int i26 = (i21 << 8) ^ i25;
        iArr[6] = i26;
        int i27 = i11 + i26;
        iArr[1] = i27;
        int i28 = i21 + i24;
        iArr[7] = i28;
        int i29 = (i24 >>> 9) ^ i28;
        iArr[7] = i29;
        iArr[2] = i14 + i29;
        iArr[0] = i24 + i27;
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    public int next(int i5) {
        if (this.count < 0) {
            isaac();
            this.count = 255;
        }
        int[] iArr = this.rsl;
        int i6 = this.count;
        this.count = i6 - 1;
        return iArr[i6] >>> (32 - i5);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int i5) {
        setSeed(new int[]{i5});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long j6) {
        setSeed(new int[]{(int) (j6 >>> 32), (int) (j6 & KeyboardMap.kValueMask)});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] iArr) {
        if (iArr == null) {
            setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
            return;
        }
        int length = iArr.length;
        int[] iArr2 = this.rsl;
        int length2 = iArr2.length;
        System.arraycopy(iArr, 0, iArr2, 0, FastMath.min(length, length2));
        if (length < length2) {
            for (int i5 = length; i5 < length2; i5++) {
                int[] iArr3 = this.rsl;
                long j6 = iArr3[i5 - length];
                iArr3[i5] = (int) ((((j6 ^ (j6 >> 30)) * 1812433253) + ((long) i5)) & KeyboardMap.kValueMask);
            }
        }
        initState();
    }

    public ISAACRandom(long j6) {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(j6);
    }

    public ISAACRandom(int[] iArr) {
        this.rsl = new int[256];
        this.mem = new int[256];
        this.arr = new int[8];
        setSeed(iArr);
    }
}
