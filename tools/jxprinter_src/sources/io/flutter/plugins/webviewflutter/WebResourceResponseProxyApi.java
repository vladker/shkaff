package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebResourceResponseProxyApi extends PigeonApiWebResourceResponse {
    public WebResourceResponseProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceResponse
    public long statusCode(@NonNull WebResourceResponse webResourceResponse) {
        return webResourceResponse.getStatusCode();
    }
}
