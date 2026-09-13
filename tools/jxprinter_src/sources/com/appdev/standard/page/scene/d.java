package com.appdev.standard.page.scene;

import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import com.appdev.standard.model.PrintTaskBean;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2831a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2832f;

    public /* synthetic */ d(Object obj, ViewGroup viewGroup, Object obj2, Serializable serializable, Object obj3, int i5) {
        this.f2831a = i5;
        this.b = obj;
        this.c = viewGroup;
        this.d = obj2;
        this.e = serializable;
        this.f2832f = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2831a) {
            case 0:
                ((CloudSpaceFragment) this.b).lambda$preShowLabel$6((TemplatePageView) this.c, (Handler) this.d, (TemplateConfigBean) this.e, (PrintTaskBean) this.f2832f);
                break;
            case 1:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.b).lambda$onReceivedHttpAuthRequest$17((WebView) this.c, (HttpAuthHandler) this.d, (String) this.e, (String) this.f2832f);
                break;
            case 2:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.b).lambda$onReceivedLoginRequest$27((WebView) this.c, (String) this.d, (String) this.e, (String) this.f2832f);
                break;
            case 3:
                ((WebViewClientProxyApi.WebViewClientImpl) this.b).lambda$onReceivedLoginRequest$27((WebView) this.c, (String) this.d, (String) this.e, (String) this.f2832f);
                break;
            default:
                ((WebViewClientProxyApi.WebViewClientImpl) this.b).lambda$onReceivedHttpAuthRequest$17((WebView) this.c, (HttpAuthHandler) this.d, (String) this.e, (String) this.f2832f);
                break;
        }
    }
}
