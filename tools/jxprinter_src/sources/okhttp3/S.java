package okhttp3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class S {
    public String b;
    W body;
    T cacheResponse;
    public long d;
    public long e;
    t4.e exchange;
    C1374u handshake;
    T networkResponse;
    T priorResponse;
    I protocol;
    M request;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6543a = -1;
    public C1375v c = new C1375v();

    public static void b(String str, T t6) {
        if (t6.body != null) {
            throw new IllegalArgumentException(str.concat(".body != null"));
        }
        if (t6.networkResponse != null) {
            throw new IllegalArgumentException(str.concat(".networkResponse != null"));
        }
        if (t6.cacheResponse != null) {
            throw new IllegalArgumentException(str.concat(".cacheResponse != null"));
        }
        if (t6.priorResponse != null) {
            throw new IllegalArgumentException(str.concat(".priorResponse != null"));
        }
    }

    public final T a() {
        if (this.request == null) {
            throw new IllegalStateException("request == null");
        }
        if (this.protocol == null) {
            throw new IllegalStateException("protocol == null");
        }
        if (this.f6543a >= 0) {
            if (this.b != null) {
                return new T(this);
            }
            throw new IllegalStateException("message == null");
        }
        throw new IllegalStateException("code < 0: " + this.f6543a);
    }

    public S body(W w6) {
        this.body = w6;
        return this;
    }

    public final void c(I i5) {
        this.protocol = i5;
    }

    public S cacheResponse(T t6) {
        if (t6 != null) {
            b("cacheResponse", t6);
        }
        this.cacheResponse = t6;
        return this;
    }

    public final void d(M m6) {
        this.request = m6;
    }

    public S handshake(C1374u c1374u) {
        this.handshake = c1374u;
        return this;
    }

    public S networkResponse(T t6) {
        if (t6 != null) {
            b("networkResponse", t6);
        }
        this.networkResponse = t6;
        return this;
    }

    public S priorResponse(T t6) {
        if (t6 != null && t6.body != null) {
            throw new IllegalArgumentException("priorResponse.body != null");
        }
        this.priorResponse = t6;
        return this;
    }
}
