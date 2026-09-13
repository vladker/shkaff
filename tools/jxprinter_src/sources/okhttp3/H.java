package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class H implements Cloneable, InterfaceC1352e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1369o f6512a;
    public final List b;
    public final List c;
    final AbstractC1350c cache;
    public final List d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F4.e f6513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f6514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C1368n f6515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SocketFactory f6516i;
    final okhttp3.internal.cache.e internalCache;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SSLSocketFactory f6517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p142y4.c f6518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HostnameVerifier f6519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C1355h f6520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final F4.e f6521n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final F4.e f6522o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final S4.h f6523p;
    final Proxy proxy;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final F4.e f6524q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f6525r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f6526s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f6527t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f6528u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f6529v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f6530w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f6531x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f6532y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List f6511z = p107s4.d.immutableList(I.HTTP_2, I.HTTP_1_1);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final List f6510A = p107s4.d.immutableList(C1366l.c, C1366l.d);

    static {
        p107s4.a.f8232a = new F();
    }

    public H() {
        this(new G());
    }

    public AbstractC1350c cache() {
        return null;
    }

    public okhttp3.internal.cache.e internalCache() {
        return null;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public H(G g6) {
        boolean z6;
        this.f6512a = g6.f6491a;
        this.proxy = g6.proxy;
        this.b = g6.b;
        List list = g6.c;
        this.c = list;
        this.d = p107s4.d.i(g6.d);
        this.e = p107s4.d.i(g6.e);
        this.f6513f = g6.f6492f;
        this.f6514g = g6.f6493g;
        this.f6515h = g6.f6494h;
        this.f6516i = g6.f6495i;
        Iterator it = list.iterator();
        loop0: while (true) {
            z6 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else {
                    z6 = (z6 || ((C1366l) it.next()).f6659a) ? true : z6;
                }
            }
        }
        SSLSocketFactory sSLSocketFactory = g6.sslSocketFactory;
        if (sSLSocketFactory == null && z6) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        try {
                            p130w4.i iVar = p130w4.i.f8835a;
                            SSLContext sSLContextG = iVar.g();
                            sSLContextG.init(null, new TrustManager[]{x509TrustManager}, null);
                            this.f6517j = sSLContextG.getSocketFactory();
                            this.f6518k = iVar.c(x509TrustManager);
                        } catch (GeneralSecurityException e) {
                            throw new AssertionError("No System TLS", e);
                        }
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e6) {
                throw new AssertionError("No System TLS", e6);
            }
        }
        this.f6517j = sSLSocketFactory;
        this.f6518k = g6.certificateChainCleaner;
        SSLSocketFactory sSLSocketFactory2 = this.f6517j;
        if (sSLSocketFactory2 != null) {
            p130w4.i.f8835a.f(sSLSocketFactory2);
        }
        this.f6519l = g6.f6496j;
        this.f6520m = g6.f6497k.withCertificateChainCleaner(this.f6518k);
        this.f6521n = g6.f6498l;
        this.f6522o = g6.f6499m;
        this.f6523p = g6.f6500n;
        this.f6524q = g6.f6501o;
        this.f6525r = g6.f6502p;
        this.f6526s = g6.f6503q;
        this.f6527t = g6.f6504r;
        this.f6528u = g6.f6505s;
        this.f6529v = g6.f6506t;
        this.f6530w = g6.f6507u;
        this.f6531x = g6.f6508v;
        this.f6532y = g6.f6509w;
        if (this.d.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.d);
        }
        if (this.e.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.e);
        }
    }
}
