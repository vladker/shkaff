package io.flutter.plugins.webviewflutter;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.webkit.WebResourceErrorCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebResourceErrorCompatProxyApi extends PigeonApiWebResourceErrorCompat {
    public WebResourceErrorCompatProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    @NonNull
    @SuppressLint({"RequiresFeature"})
    public String description(@NonNull WebResourceErrorCompat webResourceErrorCompat) {
        return webResourceErrorCompat.getDescription().toString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebResourceErrorCompat
    @SuppressLint({"RequiresFeature"})
    public long errorCode(@NonNull WebResourceErrorCompat webResourceErrorCompat) {
        return webResourceErrorCompat.getErrorCode();
    }
}
