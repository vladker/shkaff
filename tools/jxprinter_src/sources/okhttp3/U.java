package okhttp3;

import A4.InterfaceC0171n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class U extends W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f6547a;
    public final /* synthetic */ long b;
    public final /* synthetic */ InterfaceC0171n c;

    public U(B b, long j6, InterfaceC0171n interfaceC0171n) {
        this.f6547a = b;
        this.b = j6;
        this.c = interfaceC0171n;
    }

    @Override // okhttp3.W
    public final long c() {
        return this.b;
    }

    @Override // okhttp3.W
    public B contentType() {
        return this.f6547a;
    }

    @Override // okhttp3.W
    public final InterfaceC0171n d() {
        return this.c;
    }
}
