package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends p107s4.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ s c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(s sVar, Object[] objArr, int i5, EnumC1358b enumC1358b) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.c = sVar;
        this.b = i5;
    }

    @Override // p107s4.b
    public final void a() {
        this.c.f6626j.getClass();
        synchronized (this.c) {
            this.c.f6641y.remove(Integer.valueOf(this.b));
        }
    }
}
