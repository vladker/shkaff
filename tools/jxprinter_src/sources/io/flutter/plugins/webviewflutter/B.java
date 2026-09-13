package io.flutter.plugins.webviewflutter;

import android.webkit.JsResult;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class B implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4133a;
    public final /* synthetic */ WebChromeClientProxyApi.WebChromeClientImpl b;
    public final /* synthetic */ JsResult c;

    public /* synthetic */ B(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, JsResult jsResult, int i5) {
        this.f4133a = i5;
        this.b = webChromeClientImpl;
        this.c = jsResult;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f4133a) {
            case 0:
                return this.b.lambda$onJsConfirm$9(this.c, (ResultCompat) obj);
            default:
                return this.b.lambda$onJsAlert$8(this.c, (ResultCompat) obj);
        }
    }
}
