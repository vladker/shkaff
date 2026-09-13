package org.apache.commons.math3.random;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractWell extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = -817701723016583596L;
    protected final int[] i1;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    protected final int[] f6881i2;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    protected final int[] f6882i3;
    protected final int[] iRm1;
    protected final int[] iRm2;
    protected int index;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected final int[] f6883v;

    public AbstractWell(int i5, int i6, int i7, int i8) {
        this(i5, i6, i7, i8, (int[]) null);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator
    public abstract int next(int i5);

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int i5) {
        setSeed(new int[]{i5});
    }

    public AbstractWell(int i5, int i6, int i7, int i8, int i9) {
        this(i5, i6, i7, i8, new int[]{i9});
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(int[] iArr) {
        if (iArr == null) {
            setSeed(System.currentTimeMillis() + ((long) System.identityHashCode(this)));
            return;
        }
        int[] iArr2 = this.f6883v;
        System.arraycopy(iArr, 0, iArr2, 0, FastMath.min(iArr.length, iArr2.length));
        if (iArr.length < this.f6883v.length) {
            int length = iArr.length;
            while (true) {
                int[] iArr3 = this.f6883v;
                if (length >= iArr3.length) {
                    break;
                }
                long j6 = iArr3[length - iArr.length];
                iArr3[length] = (int) ((((j6 ^ (j6 >> 30)) * 1812433253) + ((long) length)) & KeyboardMap.kValueMask);
                length++;
            }
        }
        this.index = 0;
        clear();
    }

    public AbstractWell(int i5, int i6, int i7, int i8, int[] iArr) {
        int i9 = (i5 + 31) / 32;
        this.f6883v = new int[i9];
        this.index = 0;
        this.iRm1 = new int[i9];
        this.iRm2 = new int[i9];
        this.i1 = new int[i9];
        this.f6881i2 = new int[i9];
        this.f6882i3 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = i10 + i9;
            this.iRm1[i10] = (i11 - 1) % i9;
            this.iRm2[i10] = (i11 - 2) % i9;
            this.i1[i10] = (i10 + i6) % i9;
            this.f6881i2[i10] = (i10 + i7) % i9;
            this.f6882i3[i10] = (i10 + i8) % i9;
        }
        setSeed(iArr);
    }

    @Override // org.apache.commons.math3.random.BitsStreamGenerator, org.apache.commons.math3.random.RandomGenerator
    public void setSeed(long j6) {
        setSeed(new int[]{(int) (j6 >>> 32), (int) (j6 & KeyboardMap.kValueMask)});
    }

    public AbstractWell(int i5, int i6, int i7, int i8, long j6) {
        this(i5, i6, i7, i8, new int[]{(int) (j6 >>> 32), (int) (j6 & KeyboardMap.kValueMask)});
    }
}
