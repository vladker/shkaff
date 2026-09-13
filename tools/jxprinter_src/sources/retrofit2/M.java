package retrofit2;

import A4.InterfaceC0171n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class M extends okhttp3.W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8102a;
    private final okhttp3.B contentType;

    public M(okhttp3.B b, long j6) {
        this.contentType = b;
        this.f8102a = j6;
    }

    @Override // okhttp3.W
    public final long c() {
        return this.f8102a;
    }

    @Override // okhttp3.W
    public final okhttp3.B contentType() {
        return this.contentType;
    }

    @Override // okhttp3.W
    public final InterfaceC0171n d() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
