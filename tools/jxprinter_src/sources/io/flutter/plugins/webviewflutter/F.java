package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class F implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4137a;
    public final /* synthetic */ WebViewClientProxyApi.WebViewClientImpl b;
    public final /* synthetic */ WebView c;
    public final /* synthetic */ String d;

    public /* synthetic */ F(WebViewClientProxyApi.WebViewClientImpl webViewClientImpl, WebView webView, String str, int i5) {
        this.f4137a = i5;
        this.b = webViewClientImpl;
        this.c = webView;
        this.d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4137a) {
            case 0:
                this.b.lambda$onPageFinished$3(this.c, this.d);
                break;
            case 1:
                this.b.lambda$onPageCommitVisible$23(this.c, this.d);
                break;
            case 2:
                this.b.lambda$onPageStarted$1(this.c, this.d);
                break;
            case 3:
                this.b.lambda$shouldOverrideUrlLoading$13(this.c, this.d);
                break;
            default:
                this.b.lambda$onLoadResource$21(this.c, this.d);
                break;
        }
    }
}
