package U4;

import java.net.Proxy;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface d extends a {
    @Override // U4.a
    /* synthetic */ String cookie(String str);

    @Override // U4.a
    /* synthetic */ String header(String str);

    d proxy(Proxy proxy);

    Proxy proxy();

    d requestBody(String str);

    String requestBody();

    SSLSocketFactory sslSocketFactory();
}
