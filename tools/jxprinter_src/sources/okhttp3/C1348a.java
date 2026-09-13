package okhttp3;

import A3.AbstractC0157z;
import androidx.webkit.ProxyConfig;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: renamed from: okhttp3.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1348a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1378y f6553a;
    public final InterfaceC1370p b;
    public final SocketFactory c;
    final C1355h certificatePinner;
    public final InterfaceC1349b d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f6554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f6555g;
    final HostnameVerifier hostnameVerifier;
    final Proxy proxy;
    final SSLSocketFactory sslSocketFactory;

    public C1348a(String str, int i5, InterfaceC1370p interfaceC1370p, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C1355h c1355h, InterfaceC1349b interfaceC1349b, Proxy proxy, List<I> list, List<C1366l> list2, ProxySelector proxySelector) {
        C1377x c1377x = new C1377x();
        String str2 = sSLSocketFactory != null ? ProxyConfig.MATCH_HTTPS : ProxyConfig.MATCH_HTTP;
        if (str2.equalsIgnoreCase(ProxyConfig.MATCH_HTTP)) {
            c1377x.scheme = ProxyConfig.MATCH_HTTP;
        } else {
            if (!str2.equalsIgnoreCase(ProxyConfig.MATCH_HTTPS)) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            c1377x.scheme = ProxyConfig.MATCH_HTTPS;
        }
        c1377x.b(str);
        if (i5 <= 0 || i5 > 65535) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "unexpected port: "));
        }
        c1377x.c = i5;
        this.f6553a = c1377x.a();
        if (interfaceC1370p == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = interfaceC1370p;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (interfaceC1349b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = interfaceC1349b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = p107s4.d.i(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f6554f = p107s4.d.i(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f6555g = proxySelector;
        this.proxy = proxy;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = c1355h;
    }

    public final boolean a(C1348a c1348a) {
        return this.b.equals(c1348a.b) && this.d.equals(c1348a.d) && this.e.equals(c1348a.e) && this.f6554f.equals(c1348a.f6554f) && this.f6555g.equals(c1348a.f6555g) && Objects.equals(this.proxy, c1348a.proxy) && Objects.equals(this.sslSocketFactory, c1348a.sslSocketFactory) && Objects.equals(this.hostnameVerifier, c1348a.hostnameVerifier) && Objects.equals(this.certificatePinner, c1348a.certificatePinner) && this.f6553a.e == c1348a.f6553a.e;
    }

    public C1355h certificatePinner() {
        return this.certificatePinner;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1348a)) {
            return false;
        }
        C1348a c1348a = (C1348a) obj;
        return this.f6553a.equals(c1348a.f6553a) && a(c1348a);
    }

    public final int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((Objects.hashCode(this.proxy) + ((this.f6555g.hashCode() + ((this.f6554f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.b.hashCode() + androidx.exifinterface.media.a.a(527, 31, this.f6553a.f6682g)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        C1378y c1378y = this.f6553a;
        sb.append(c1378y.d);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(c1378y.e);
        if (this.proxy != null) {
            sb.append(", proxy=");
            sb.append(this.proxy);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f6555g);
        }
        sb.append(VectorFormat.DEFAULT_SUFFIX);
        return sb.toString();
    }
}
