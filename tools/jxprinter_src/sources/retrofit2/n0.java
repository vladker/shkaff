package retrofit2;

import A4.InterfaceC0170m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class n0 extends okhttp3.Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.Q f8131a;
    public final okhttp3.B b;

    public n0(okhttp3.Q q6, okhttp3.B b) {
        this.f8131a = q6;
        this.b = b;
    }

    @Override // okhttp3.Q
    public long contentLength() {
        return this.f8131a.contentLength();
    }

    @Override // okhttp3.Q
    public final okhttp3.B contentType() {
        return this.b;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) {
        this.f8131a.writeTo(interfaceC0170m);
    }
}
