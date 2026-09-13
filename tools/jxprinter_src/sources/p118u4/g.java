package p118u4;

import A4.InterfaceC0171n;
import okhttp3.B;
import okhttp3.W;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class g extends W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8742a;
    public final InterfaceC0171n b;
    private final String contentTypeString;

    public g(String str, long j6, InterfaceC0171n interfaceC0171n) {
        this.contentTypeString = str;
        this.f8742a = j6;
        this.b = interfaceC0171n;
    }

    @Override // okhttp3.W
    public final long c() {
        return this.f8742a;
    }

    @Override // okhttp3.W
    public final B contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return B.parse(str);
        }
        return null;
    }

    @Override // okhttp3.W
    public final InterfaceC0171n d() {
        return this.b;
    }
}
