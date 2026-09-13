package V2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f743a;
    public boolean b;

    @Override // V2.a
    public final boolean a(long[] jArr, long[] jArr2, int i5, int i6, int i7) {
        switch (this.f743a) {
            case 0:
                boolean z6 = true;
                while (i6 != i7) {
                    long j6 = jArr[i6];
                    boolean z7 = false;
                    this.b &= j6 == jArr2[i6];
                    if (j6 == 0) {
                        z7 = true;
                    }
                    z6 &= z7;
                    i6++;
                }
                return z6;
            default:
                boolean z8 = true;
                while (i6 != i7) {
                    long j7 = jArr[i6];
                    boolean z9 = false;
                    this.b |= (jArr2[i6] & j7) != 0;
                    if (j7 == 0) {
                        z9 = true;
                    }
                    z8 &= z9;
                    i6++;
                }
                return z8;
        }
    }

    @Override // V2.a
    public final int c() {
        switch (this.f743a) {
            case 0:
                return 1;
            default:
                return 3;
        }
    }

    @Override // V2.a
    public final boolean d(f fVar) {
        switch (this.f743a) {
            case 0:
                fVar.getClass();
                this.b = true;
                break;
            default:
                fVar.getClass();
                this.b = false;
                break;
        }
        return false;
    }

    @Override // V2.a
    public final boolean e(int i5, int i6, long[] jArr, long[] jArr2, long j6) {
        switch (this.f743a) {
            case 0:
                long j7 = jArr[i6];
                this.b &= (j7 & j6) == (jArr2[i6] & j6);
                return j7 == 0;
            default:
                long j8 = jArr[i6];
                this.b |= ((jArr2[i6] & j8) & j6) != 0;
                return j8 == 0;
        }
    }
}
