package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebResourceRequestProxyApi extends PigeonApiWebResourceRequest {
    public WebResourceRequestProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @NonNull
    public boolean hasGesture(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.hasGesture();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @NonNull
    public boolean isForMainFrame(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @Nullable
    public Boolean isRedirect(@NonNull WebResourceRequest webResourceRequest) {
        if (getPigeonRegistrar().sdkIsAtLeast(24)) {
            return Boolean.valueOf(webResourceRequest.isRedirect());
        }
        return null;
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @NonNull
    public String method(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.getMethod();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @Nullable
    public Map<String, String> requestHeaders(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.getRequestHeaders() == null ? Collections.EMPTY_MAP : webResourceRequest.getRequestHeaders();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @NonNull
    public String url(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceRequest
    @NonNull
    public ProxyApiRegistrar getPigeonRegistrar() {
        return (ProxyApiRegistrar) super.getPigeonRegistrar();
    }
}
