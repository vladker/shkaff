package org.apache.commons.math3.random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Well19937c extends AbstractWell {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final int f6895K = 19937;

    /* JADX INFO: renamed from: M1, reason: collision with root package name */
    private static final int f6896M1 = 70;

    /* JADX INFO: renamed from: M2, reason: collision with root package name */
    private static final int f6897M2 = 179;

    /* JADX INFO: renamed from: M3, reason: collision with root package name */
    private static final int f6898M3 = 449;
    private static final long serialVersionUID = -7203498180754925124L;

    public Well19937c() {
        super(f6895K, 70, 179, 449);
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
        int i13 = (i9 ^ (i9 << 25)) ^ (i10 ^ (i10 >>> 27));
        int i14 = (i11 >>> 9) ^ ((i12 >>> 1) ^ i12);
        int i15 = i13 ^ i14;
        int i16 = (((i13 ^ (i13 << 9)) ^ ((iArr2[i7] & Integer.MIN_VALUE) ^ (Integer.MAX_VALUE & iArr2[i8]))) ^ (i14 ^ (i14 << 21))) ^ ((i15 >>> 21) ^ i15);
        iArr2[i6] = i15;
        iArr2[i7] = i16;
        iArr2[i8] = iArr2[i8] & Integer.MIN_VALUE;
        this.index = i7;
        int i17 = ((i16 << 7) & (-462547200)) ^ i16;
        return (i17 ^ ((i17 << 15) & (-1685684224))) >>> (32 - i5);
    }

    public Well19937c(int i5) {
        super(f6895K, 70, 179, 449, i5);
    }

    public Well19937c(int[] iArr) {
        super(f6895K, 70, 179, 449, iArr);
    }

    public Well19937c(long j6) {
        super(f6895K, 70, 179, 449, j6);
    }
}
