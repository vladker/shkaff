package V2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f741a;

    public /* synthetic */ b(int i5) {
        this.f741a = i5;
    }

    @Override // V2.a
    public final boolean a(long[] jArr, long[] jArr2, int i5, int i6, int i7) {
        switch (this.f741a) {
            case 0:
                boolean z6 = true;
                while (i6 != i7) {
                    long j6 = jArr[i6] & (~jArr2[i6]);
                    jArr[i6] = j6;
                    z6 &= j6 == 0;
                    i6++;
                }
                return z6;
            case 1:
                boolean z7 = true;
                while (i6 != i7) {
                    long j7 = jArr[i6] & jArr2[i6];
                    jArr[i6] = j7;
                    z7 &= j7 == 0;
                    i6++;
                }
                return z7;
            case 2:
                if (i6 == 0 && i7 == 32) {
                    return true;
                }
                while (i6 != i7) {
                    jArr[i6] = 0;
                    i6++;
                }
                return true;
            case 3:
                boolean z8 = true;
                while (i6 != i7) {
                    long j8 = jArr2[i6];
                    jArr[i6] = j8;
                    z8 &= j8 == 0;
                    i6++;
                }
                return z8;
            case 4:
                boolean z9 = true;
                while (i6 != i7) {
                    long j9 = ~jArr[i6];
                    jArr[i6] = j9;
                    z9 &= j9 == 0;
                    i6++;
                }
                return z9;
            case 5:
                boolean z10 = true;
                while (i6 != i7) {
                    long j10 = jArr[i6] | jArr2[i6];
                    jArr[i6] = j10;
                    z10 &= j10 == 0;
                    i6++;
                }
                return z10;
            case 6:
                break;
            default:
                boolean z11 = true;
                while (i6 != i7) {
                    long j11 = jArr[i6] ^ jArr2[i6];
                    jArr[i6] = j11;
                    z11 &= j11 == 0;
                    i6++;
                }
                return z11;
        }
        while (i6 != i7) {
            jArr[i6] = -1;
            i6++;
        }
        return false;
    }

    @Override // V2.a
    public final int c() {
        switch (this.f741a) {
            case 0:
                return 11;
            case 1:
                return 7;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 0;
            case 5:
                return 9;
            case 6:
                return 0;
            default:
                return 9;
        }
    }

    @Override // V2.a
    public final boolean d(f fVar) {
        switch (this.f741a) {
            case 0:
                fVar.getClass();
                break;
            case 1:
                fVar.getClass();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                fVar.getClass();
                break;
            case 6:
                break;
            default:
                fVar.getClass();
                break;
        }
        return true;
    }

    @Override // V2.a
    public final boolean e(int i5, int i6, long[] jArr, long[] jArr2, long j6) {
        switch (this.f741a) {
            case 0:
                long j7 = (~(jArr2[i6] & j6)) & jArr[i6];
                jArr[i6] = j7;
                return j7 == 0;
            case 1:
                long j8 = ((~j6) | jArr2[i6]) & jArr[i6];
                jArr[i6] = j8;
                return j8 == 0;
            case 2:
                long j9 = (~j6) & jArr[i6];
                jArr[i6] = j9;
                return j9 == 0;
            case 3:
                long j10 = jArr2[i6] & j6;
                jArr[i6] = j10;
                return j10 == 0;
            case 4:
                long j11 = jArr[i6] ^ j6;
                jArr[i6] = j11;
                return j11 == 0;
            case 5:
                long j12 = (jArr2[i6] & j6) | jArr[i6];
                jArr[i6] = j12;
                return j12 == 0;
            case 6:
                jArr[i6] = jArr[i6] | j6;
                return false;
            default:
                long j13 = (jArr2[i6] & j6) ^ jArr[i6];
                jArr[i6] = j13;
                return j13 == 0;
        }
    }
}
