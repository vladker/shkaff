package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1348a f6549a;
    public final Proxy b;
    public final InetSocketAddress c;

    public X(C1348a c1348a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c1348a == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f6549a = c1348a;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean a() {
        return this.f6549a.sslSocketFactory != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X)) {
            return false;
        }
        X x6 = (X) obj;
        return x6.f6549a.equals(this.f6549a) && x6.b.equals(this.b) && x6.c.equals(this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + ((this.f6549a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.c + VectorFormat.DEFAULT_SUFFIX;
    }
}
