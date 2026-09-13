package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4135a;
    public final /* synthetic */ WebView b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ WebViewClient e;

    public /* synthetic */ D(WebViewClient webViewClient, WebView webView, float f6, float f7, int i5) {
        this.f4135a = i5;
        this.e = webViewClient;
        this.b = webView;
        this.c = f6;
        this.d = f7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4135a) {
            case 0:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.e).lambda$onScaleChanged$31(this.b, this.c, this.d);
                break;
            default:
                ((WebViewClientProxyApi.WebViewClientImpl) this.e).lambda$onScaleChanged$31(this.b, this.c, this.d);
                break;
        }
    }
}
