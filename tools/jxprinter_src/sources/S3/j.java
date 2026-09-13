package S3;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends f implements Serializable {
    private static final i Companion = new i();
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f667a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f668f;

    public j(int i5, int i6) {
        int i7 = ~i5;
        this.f667a = i5;
        this.b = i6;
        this.c = 0;
        this.d = 0;
        this.e = i7;
        this.f668f = (i5 << 10) ^ (i6 >>> 4);
        if ((i5 | i6 | i7) == 0) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.");
        }
        for (int i8 = 0; i8 < 64; i8++) {
            c();
        }
    }

    @Override // S3.f
    public final int b(int i5) {
        return ((-i5) >> 31) & (c() >>> (32 - i5));
    }

    @Override // S3.f
    public final int c() {
        int i5 = this.f667a;
        int i6 = i5 ^ (i5 >>> 2);
        this.f667a = this.b;
        this.b = this.c;
        this.c = this.d;
        int i7 = this.e;
        this.d = i7;
        int i8 = ((i6 ^ (i6 << 1)) ^ i7) ^ (i7 << 4);
        this.e = i8;
        int i9 = this.f668f + 362437;
        this.f668f = i9;
        return i8 + i9;
    }
}
