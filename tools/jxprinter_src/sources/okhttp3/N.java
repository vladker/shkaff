package okhttp3;

import A4.C0173p;
import A4.InterfaceC0170m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class N extends Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f6540a;
    public final /* synthetic */ C0173p b;

    public N(B b, C0173p c0173p) {
        this.f6540a = b;
        this.b = c0173p;
    }

    @Override // okhttp3.Q
    public long contentLength() {
        return this.b.size();
    }

    @Override // okhttp3.Q
    public B contentType() {
        return this.f6540a;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) {
        interfaceC0170m.write(this.b);
    }
}
