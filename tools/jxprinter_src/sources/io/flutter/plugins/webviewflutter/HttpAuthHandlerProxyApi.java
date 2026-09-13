package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpAuthHandlerProxyApi extends PigeonApiHttpAuthHandler {
    public HttpAuthHandlerProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void cancel(@NonNull HttpAuthHandler httpAuthHandler) {
        httpAuthHandler.cancel();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public void proceed(@NonNull HttpAuthHandler httpAuthHandler, @NonNull String str, @NonNull String str2) {
        httpAuthHandler.proceed(str, str2);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler
    public boolean useHttpAuthUsernamePassword(@NonNull HttpAuthHandler httpAuthHandler) {
        return httpAuthHandler.useHttpAuthUsernamePassword();
    }
}
