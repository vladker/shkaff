package org.apache.commons.math3.random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Well44497b extends AbstractWell {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int f6903K = 44497;

    /* JADX INFO: renamed from: M1, reason: collision with root package name */
    private static final int f6904M1 = 23;

    /* JADX INFO: renamed from: M2, reason: collision with root package name */
    private static final int f6905M2 = 481;

    /* JADX INFO: renamed from: M3, reason: collision with root package name */
    private static final int f6906M3 = 229;
    private static final long serialVersionUID = 4032007538246675492L;

    public Well44497b() {
        super(f6903K, 23, 481, 229);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    public int next(int i5) {
        int[] iArr = this.iRm1;
        int i6 = this.index;
        int i7 = iArr[i6];
        int i8 = this.iRm2[i6];
        int[] iArr2 = this.f6883v;
        int i9 = iArr2[i6];
        int i10 = iArr2[this.i1[i6]];
        int i11 = iArr2[this.f6881i2[i6]];
        int i12 = iArr2[this.f6882i3[i6]];
        int i13 = (iArr2[i7] & (-32768)) ^ (iArr2[i8] & 32767);
        int i14 = (i9 ^ (i9 << 24)) ^ (i10 ^ (i10 >>> 30));
        int i15 = ((i11 << 10) ^ i11) ^ (i12 << 26);
        int i16 = i14 ^ i15;
        int i17 = ((i15 << 9) ^ (i15 >>> 23)) & (-67108865);
        if ((i15 & 131072) != 0) {
            i17 ^= -1221985044;
        }
        int i18 = (((i14 ^ (i14 >>> 20)) ^ i13) ^ i17) ^ i16;
        iArr2[i6] = i16;
        iArr2[i7] = i18;
        iArr2[i8] = iArr2[i8] & (-32768);
        this.index = i7;
        int i19 = ((i18 << 7) & (-1814227968)) ^ i18;
        return (i19 ^ ((i19 << 15) & (-99516416))) >>> (32 - i5);
    }

    public Well44497b(int i5) {
        super(f6903K, 23, 481, 229, i5);
    }

    public Well44497b(int[] iArr) {
        super(f6903K, 23, 481, 229, iArr);
    }

    public Well44497b(long j6) {
        super(f6903K, 23, 481, 229, j6);
    }
}
