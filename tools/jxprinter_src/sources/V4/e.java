package V4;

import com.google.common.net.HttpHeaders;
import java.net.CookieManager;
import java.net.Proxy;
import java.util.ArrayList;
import javax.net.ssl.SSLSocketFactory;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.jsoup.parser.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends d implements U4.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public E f773k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CookieManager f776n;
    private Proxy proxy;
    private SSLSocketFactory sslSocketFactory;
    private String body = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f772j = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f774l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f775m = c.c;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f777o = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f768f = CMAESOptimizer.DEFAULT_MAXITERATIONS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f769g = 2097152;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f770h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f771i = new ArrayList();

    static {
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
    }

    public e() {
        this.b = U4.c.GET;
        a(HttpHeaders.ACCEPT_ENCODING, "gzip");
        a(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36");
        this.f773k = E.a();
        this.f776n = new CookieManager();
    }

    @Override // U4.d
    public U4.d requestBody(String str) {
        this.body = str;
        return this;
    }

    @Override // U4.d
    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Override // U4.d
    public final Proxy proxy() {
        return this.proxy;
    }

    @Override // U4.d
    public final String requestBody() {
        return this.body;
    }

    @Override // U4.d
    public e proxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }
}
