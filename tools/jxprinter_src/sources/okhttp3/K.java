package okhttp3;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class K implements InterfaceC1353f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f6537a;
    public t4.o b;
    public final M c;
    public boolean d;

    public K(H h6, M m6) {
        this.f6537a = h6;
        this.c = m6;
    }

    public static K a(H h6, M m6) {
        K k6 = new K(h6, m6);
        k6.b = new t4.o(h6, k6);
        return k6;
    }

    public Object clone() {
        return a(this.f6537a, this.c);
    }

    @Override // okhttp3.InterfaceC1353f
    public T execute() {
        synchronized (this) {
            if (this.d) {
                throw new IllegalStateException("Already Executed");
            }
            this.d = true;
        }
        this.b.e.j();
        this.b.b();
        try {
            C1369o c1369o = this.f6537a.f6512a;
            synchronized (c1369o) {
                c1369o.c.add(this);
            }
            T responseWithInterceptorChain = getResponseWithInterceptorChain();
            C1369o c1369o2 = this.f6537a.f6512a;
            c1369o2.b(c1369o2.c, this);
            return responseWithInterceptorChain;
        } catch (Throwable th) {
            C1369o c1369o3 = this.f6537a.f6512a;
            c1369o3.b(c1369o3.c, this);
            throw th;
        }
    }

    public T getResponseWithInterceptorChain() {
        ArrayList arrayList = new ArrayList();
        H h6 = this.f6537a;
        arrayList.addAll(h6.d);
        arrayList.add(new p118u4.h(h6));
        arrayList.add(new p118u4.a(h6.f6515h));
        h6.internalCache();
        arrayList.add(new okhttp3.internal.cache.b(null));
        arrayList.add(new t4.a());
        arrayList.addAll(h6.e);
        arrayList.add(new p118u4.b());
        try {
            try {
                T tProceed = new p118u4.f(arrayList, this.b, null, 0, this.c, this, h6.f6529v, h6.f6530w, h6.f6531x).proceed(this.c);
                if (this.b.f()) {
                    p107s4.d.c(tProceed);
                    throw new IOException("Canceled");
                }
                this.b.noMoreExchanges(null);
                return tProceed;
            } catch (IOException e) {
                throw this.b.noMoreExchanges(e);
            }
        } catch (Throwable th) {
            if (0 == 0) {
                this.b.noMoreExchanges(null);
            }
            throw th;
        }
    }
}
