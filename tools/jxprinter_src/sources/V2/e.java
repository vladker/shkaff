package V2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f744a;
    public transient long b;
    public transient int c;
    public transient long d;
    public transient long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int f746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f747h;

    public e(f fVar) {
        this.f747h = fVar;
    }

    @Override // V2.a
    public final boolean a(long[] jArr, long[] jArr2, int i5, int i6, int i7) {
        boolean z6 = true;
        for (int i8 = 0; i8 != i7; i8++) {
            long j6 = jArr[i8];
            if (j6 != 0) {
                f(i5 + i8, j6);
                z6 = false;
            }
        }
        return z6;
    }

    @Override // V2.a
    public final void b() {
        f fVar = this.f747h;
        fVar.d.getClass();
        fVar.d.getClass();
        c cVar = fVar.d;
        cVar.d = this.f745f;
        cVar.b = this.f746g;
        cVar.c = ((this.c + 1) * 64) - Long.numberOfLeadingZeros(this.d);
        int i5 = fVar.d.c;
        Long.numberOfTrailingZeros(this.b);
        c cVar2 = fVar.d;
        long j6 = this.e;
        cVar2.f742a = (int) (j6 ^ (j6 >> 32));
    }

    @Override // V2.a
    public final int c() {
        return 3;
    }

    @Override // V2.a
    public final boolean d(f fVar) {
        this.e = 1234L;
        this.f744a = -1;
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.f745f = 0;
        this.f746g = 0;
        return false;
    }

    @Override // V2.a
    public final boolean e(int i5, int i6, long[] jArr, long[] jArr2, long j6) {
        long j7 = jArr[i6];
        long j8 = j7 & j6;
        if (j8 != 0) {
            f(i5 + i6, j8);
        }
        return j7 == 0;
    }

    public final void f(int i5, long j6) {
        this.f745f++;
        this.e ^= ((long) (i5 + 1)) * j6;
        if (this.f744a < 0) {
            this.f744a = i5;
            this.b = j6;
        }
        this.c = i5;
        this.d = j6;
        this.f746g = Long.bitCount(j6) + this.f746g;
    }
}
