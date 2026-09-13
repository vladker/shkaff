package J0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f348a;
    public S4.h b;

    public g(int i5) {
        this.f348a = new f(i5);
    }

    @Override // J0.e
    public final d a(p126w0.a aVar, boolean z6) {
        if (aVar == p126w0.a.e || !z6) {
            return b.b;
        }
        if (this.b == null) {
            this.b = new S4.h(this.f348a, 3);
        }
        return this.b;
    }
}
