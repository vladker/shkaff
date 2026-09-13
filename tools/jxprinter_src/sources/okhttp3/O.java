package okhttp3;

import A4.InterfaceC0170m;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class O extends Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f6541a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ int d;

    public O(B b, byte[] bArr, int i5, int i6) {
        this.f6541a = b;
        this.b = i5;
        this.c = bArr;
        this.d = i6;
    }

    @Override // okhttp3.Q
    public final long contentLength() {
        return this.b;
    }

    @Override // okhttp3.Q
    public B contentType() {
        return this.f6541a;
    }

    @Override // okhttp3.Q
    public void writeTo(InterfaceC0170m interfaceC0170m) {
        interfaceC0170m.write(this.c, this.d, this.b);
    }
}
