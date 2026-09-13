package retrofit2;

import A4.InterfaceC0171n;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class L extends okhttp3.W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.W f8101a;
    public final InterfaceC0171n b;
    IOException thrownException;

    public L(okhttp3.W w6) {
        this.f8101a = w6;
        this.b = A4.N.buffer(new K(this, w6.d()));
    }

    @Override // okhttp3.W
    public final long c() {
        return this.f8101a.c();
    }

    @Override // okhttp3.W, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f8101a.close();
    }

    @Override // okhttp3.W
    public final okhttp3.B contentType() {
        return this.f8101a.contentType();
    }

    @Override // okhttp3.W
    public final InterfaceC0171n d() {
        return this.b;
    }

    public void throwIfCaught() throws IOException {
        IOException iOException = this.thrownException;
        if (iOException != null) {
            throw iOException;
        }
    }
}
