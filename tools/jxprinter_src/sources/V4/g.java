package V4;

import com.google.common.net.HttpHeaders;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.jsoup.nodes.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class g implements U4.f {
    public static final Charset b = Charset.forName("UTF-8");
    public static final Charset c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f783a;
    private U4.e res;

    public g() {
        this.f783a = new e();
    }

    public static URL a(URL url) {
        URL urlB = b(url);
        try {
            return new URL(new URI(urlB.toExternalForm().replace(" ", "%20")).toASCIIString());
        } catch (MalformedURLException | URISyntaxException unused) {
            return urlB;
        }
    }

    public static URL b(URL url) {
        String host = url.getHost();
        String[] strArr = W4.b.f830a;
        h.notNull(host);
        for (int i5 = 0; i5 < host.length(); i5++) {
            if (host.charAt(i5) > 127) {
                try {
                    return new URL(url.getProtocol(), IDN.toASCII(url.getHost()), url.getPort(), url.getFile());
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }
        return url;
    }

    public final g c() {
        h.notNull("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36", "User agent must not be null");
        e eVar = this.f783a;
        eVar.getClass();
        h.notEmpty(HttpHeaders.USER_AGENT, "Header name must not be empty");
        eVar.d(HttpHeaders.USER_AGENT);
        eVar.a(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        return this;
    }

    @Override // U4.f
    public final U4.b data(String str) {
        h.notEmpty(str, "Data key must not be empty");
        Iterator it = this.f783a.f771i.iterator();
        if (it.hasNext()) {
            throw AbstractC1125a.g(it);
        }
        return null;
    }

    @Override // U4.f
    public U4.e execute() {
        f fVarExecute = f.execute(this.f783a);
        this.res = fVarExecute;
        return fVarExecute;
    }

    @Override // U4.f
    public i get() {
        e eVar = this.f783a;
        eVar.getClass();
        U4.c cVar = U4.c.GET;
        h.notNull(cVar, "Method must not be null");
        eVar.b = cVar;
        execute();
        h.notNull(this.res);
        return this.res.parse();
    }

    @Override // U4.f
    public i post() {
        e eVar = this.f783a;
        eVar.getClass();
        U4.c cVar = U4.c.POST;
        h.notNull(cVar, "Method must not be null");
        eVar.b = cVar;
        execute();
        h.notNull(this.res);
        return this.res.parse();
    }

    @Override // U4.f
    public U4.f proxy(Proxy proxy) {
        this.f783a.proxy(proxy);
        return this;
    }

    public g(e eVar, f fVar) {
        this.f783a = eVar;
        this.res = fVar;
    }
}
