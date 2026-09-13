package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class p extends p107s4.b {
    public final boolean b;
    public final int c;
    public final int d;
    public final /* synthetic */ s e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(s sVar, int i5, int i6) {
        super("OkHttp %s ping %08x%08x", sVar.d, Integer.valueOf(i5), Integer.valueOf(i6));
        this.e = sVar;
        this.b = true;
        this.c = i5;
        this.d = i6;
    }

    @Override // p107s4.b
    public final void a() {
        this.e.g(this.b, this.c, this.d);
    }
}
