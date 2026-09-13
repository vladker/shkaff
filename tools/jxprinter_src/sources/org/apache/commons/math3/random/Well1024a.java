package org.apache.commons.math3.random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Well1024a extends AbstractWell {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int f6887K = 1024;

    /* JADX INFO: renamed from: M1, reason: collision with root package name */
    private static final int f6888M1 = 3;

    /* JADX INFO: renamed from: M2, reason: collision with root package name */
    private static final int f6889M2 = 24;

    /* JADX INFO: renamed from: M3, reason: collision with root package name */
    private static final int f6890M3 = 10;
    private static final long serialVersionUID = 5680173464174485492L;

    public Well1024a() {
        super(1024, 3, 24, 10);
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
        int i11 = iArr2[this.f6882i3[i6]];
        int i12 = iArr2[i7];
        int i13 = i8 ^ (i9 ^ (i9 >>> 8));
        int i14 = ((i10 << 19) ^ i10) ^ ((i11 << 14) ^ i11);
        int i15 = i13 ^ i14;
        int i16 = ((i13 ^ (i13 << 7)) ^ ((i12 << 11) ^ i12)) ^ (i14 ^ (i14 << 13));
        iArr2[i6] = i15;
        iArr2[i7] = i16;
        this.index = i7;
        return i16 >>> (32 - i5);
    }

    public Well1024a(int i5) {
        super(1024, 3, 24, 10, i5);
    }

    public Well1024a(int[] iArr) {
        super(1024, 3, 24, 10, iArr);
    }

    public Well1024a(long j6) {
        super(1024, 3, 24, 10, j6);
    }
}
