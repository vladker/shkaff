package okhttp3;

import A4.C0169l;
import A4.InterfaceC0171n;
import A4.h0;
import java.io.Closeable;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class T implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f6544a;
    public final I b;
    final W body;
    public final int c;
    private volatile C1351d cacheControl;
    final T cacheResponse;
    public final String d;
    public final C1376w e;
    final t4.e exchange;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f6545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6546g;
    final C1374u handshake;
    final T networkResponse;
    final T priorResponse;

    public T(S s6) {
        this.f6544a = s6.request;
        this.b = s6.protocol;
        this.c = s6.f6543a;
        this.d = s6.b;
        this.handshake = s6.handshake;
        C1375v c1375v = s6.c;
        c1375v.getClass();
        this.e = new C1376w(c1375v);
        this.body = s6.body;
        this.networkResponse = s6.networkResponse;
        this.cacheResponse = s6.cacheResponse;
        this.priorResponse = s6.priorResponse;
        this.f6545f = s6.d;
        this.f6546g = s6.e;
        this.exchange = s6.exchange;
    }

    public final boolean a() {
        int i5 = this.c;
        return i5 >= 200 && i5 < 300;
    }

    public final S b() {
        S s6 = new S();
        s6.request = this.f6544a;
        s6.protocol = this.b;
        s6.f6543a = this.c;
        s6.b = this.d;
        s6.handshake = this.handshake;
        s6.c = this.e.d();
        s6.body = this.body;
        s6.networkResponse = this.networkResponse;
        s6.cacheResponse = this.cacheResponse;
        s6.priorResponse = this.priorResponse;
        s6.d = this.f6545f;
        s6.e = this.f6546g;
        s6.exchange = this.exchange;
        return s6;
    }

    public W body() {
        return this.body;
    }

    public T cacheResponse() {
        return this.cacheResponse;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        W w6 = this.body;
        if (w6 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        w6.close();
    }

    public C1374u handshake() {
        return this.handshake;
    }

    public String header(String str) {
        return header(str, null);
    }

    public T networkResponse() {
        return this.networkResponse;
    }

    public W peekBody(long j6) throws EOFException {
        InterfaceC0171n interfaceC0171nPeek = this.body.d().peek();
        C0169l c0169l = new C0169l();
        interfaceC0171nPeek.request(j6);
        c0169l.write((h0) interfaceC0171nPeek, Math.min(j6, interfaceC0171nPeek.getBuffer().size()));
        return W.create(this.body.contentType(), c0169l.size(), c0169l);
    }

    public T priorResponse() {
        return this.priorResponse;
    }

    public final String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.f6544a.f6539a + '}';
    }

    public C1376w trailers() {
        t4.e eVar = this.exchange;
        if (eVar != null) {
            return eVar.trailers();
        }
        throw new IllegalStateException("trailers not available");
    }

    public String header(String str, String str2) {
        String str3 = this.e.get(str);
        return str3 != null ? str3 : str2;
    }
}
