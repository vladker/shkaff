package okhttp3;

import com.library.base.util.http.TrustAllManager;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class G {
    AbstractC1350c cache;
    p142y4.c certificateChainCleaner;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f6493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1368n f6494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SocketFactory f6495i;
    okhttp3.internal.cache.e internalCache;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HostnameVerifier f6496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1355h f6497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final F4.e f6498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final F4.e f6499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final S4.h f6500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final F4.e f6501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f6502p;
    Proxy proxy;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f6503q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6504r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6505s;
    SSLSocketFactory sslSocketFactory;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6506t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f6507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6509w;
    public final ArrayList d = new ArrayList();
    public final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1369o f6491a = new C1369o();
    public final List b = H.f6511z;
    public final List c = H.f6510A;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F4.e f6492f = new F4.e(24);

    public G() {
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f6493g = proxySelector;
        if (proxySelector == null) {
            this.f6493g = new p136x4.a();
        }
        this.f6494h = C1368n.f6669a;
        this.f6495i = SocketFactory.getDefault();
        this.f6496j = p142y4.d.f9043a;
        this.f6497k = C1355h.b;
        F4.e eVar = InterfaceC1349b.f6556f0;
        this.f6498l = eVar;
        this.f6499m = eVar;
        this.f6500n = new S4.h(14);
        this.f6501o = InterfaceC1370p.f6671g0;
        this.f6502p = true;
        this.f6503q = true;
        this.f6504r = true;
        this.f6505s = 0;
        this.f6506t = 10000;
        this.f6507u = 10000;
        this.f6508v = 10000;
        this.f6509w = 0;
    }

    public final void a(A a6) {
        this.d.add(a6);
    }

    public final void b(SSLSocketFactory sSLSocketFactory, TrustAllManager trustAllManager) {
        if (sSLSocketFactory == null) {
            throw new NullPointerException("sslSocketFactory == null");
        }
        this.sslSocketFactory = sSLSocketFactory;
        this.certificateChainCleaner = p130w4.i.f8835a.c(trustAllManager);
    }

    @IgnoreJRERequirement
    public G callTimeout(Duration duration) {
        this.f6505s = p107s4.d.b(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    @IgnoreJRERequirement
    public G connectTimeout(Duration duration) {
        this.f6506t = p107s4.d.b(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    @IgnoreJRERequirement
    public G pingInterval(Duration duration) {
        this.f6509w = p107s4.d.b(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    public G proxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    @IgnoreJRERequirement
    public G readTimeout(Duration duration) {
        this.f6507u = p107s4.d.b(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    @IgnoreJRERequirement
    public G writeTimeout(Duration duration) {
        this.f6508v = p107s4.d.b(duration.toMillis(), TimeUnit.MILLISECONDS);
        return this;
    }

    public G cache(AbstractC1350c abstractC1350c) {
        return this;
    }
}
