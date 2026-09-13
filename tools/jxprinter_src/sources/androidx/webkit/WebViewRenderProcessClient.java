package androidx.webkit;

import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewRenderProcessClient {
    public abstract void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess);

    public abstract void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess);
}
