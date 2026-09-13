package org.apache.commons.math3.random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Well512a extends AbstractWell {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int f6907K = 512;

    /* JADX INFO: renamed from: M1, reason: collision with root package name */
    private static final int f6908M1 = 13;

    /* JADX INFO: renamed from: M2, reason: collision with root package name */
    private static final int f6909M2 = 9;

    /* JADX INFO: renamed from: M3, reason: collision with root package name */
    private static final int f6910M3 = 5;
    private static final long serialVersionUID = -6104179812103820574L;

    public Well512a() {
        super(512, 13, 9, 5);
    }

    @Override // org.apache.commons.math3.random.AbstractWell, org.apache.commons.math3.random.BitsStreamGenerator
    public int next(int i5) {
        int[] iArr = this.iRm1;
        int i6 = this.index;
        int i7 = iArr[i6];
        int[] iArr2 = this.f6883v;
        int i8 = iArr2[i6];
        int i9 = iArr2[this.i1[i6]];
        int i10 = iArr2[this.f6881i2[i6]];
        int i11 = iArr2[i7];
        int i12 = (i8 ^ (i8 << 16)) ^ (i9 ^ (i9 << 15));
        int i13 = (i10 >>> 11) ^ i10;
        int i14 = i12 ^ i13;
        int i15 = (((i12 ^ (i12 << 18)) ^ (i11 ^ (i11 << 2))) ^ (i13 << 28)) ^ (((i14 << 5) & (-633066204)) ^ i14);
        iArr2[i6] = i14;
        iArr2[i7] = i15;
        this.index = i7;
        return i15 >>> (32 - i5);
    }

    public Well512a(int i5) {
        super(512, 13, 9, 5, i5);
    }

    public Well512a(int[] iArr) {
        super(512, 13, 9, 5, iArr);
    }

    public Well512a(long j6) {
        super(512, 13, 9, 5, j6);
    }
}
