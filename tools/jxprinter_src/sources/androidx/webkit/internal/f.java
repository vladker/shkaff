package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1072a;
    public final /* synthetic */ WebViewRenderProcessClient b;
    public final /* synthetic */ WebView c;
    public final /* synthetic */ WebViewRenderProcess d;

    public /* synthetic */ f(WebViewRenderProcessClient webViewRenderProcessClient, WebView webView, WebViewRenderProcessImpl webViewRenderProcessImpl, int i5) {
        this.f1072a = i5;
        this.b = webViewRenderProcessClient;
        this.c = webView;
        this.d = webViewRenderProcessImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1072a) {
            case 0:
                this.b.onRenderProcessResponsive(this.c, this.d);
                break;
            default:
                this.b.onRenderProcessUnresponsive(this.c, this.d);
                break;
        }
    }
}
