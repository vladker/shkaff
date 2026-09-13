package com.appdev.standard.page.scene;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.hjq.permissions.E;
import com.hjq.permissions.F;
import com.hjq.permissions.G;
import com.hjq.permissions.H;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2835a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2836f;

    public /* synthetic */ g(WebViewClient webViewClient, WebView webView, int i5, String str, String str2, int i6) {
        this.f2835a = i6;
        this.c = webViewClient;
        this.d = webView;
        this.b = i5;
        this.e = str;
        this.f2836f = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2835a) {
            case 0:
                ((CloudSpaceFragment) this.c).lambda$startPrintLabel$12((P0) this.d, (TemplateConfigBean) this.e, this.b, (TemplatePageView) this.f2836f);
                break;
            case 1:
                G g6 = (G) this.c;
                Activity activity = (Activity) this.d;
                ArrayList arrayList = (ArrayList) this.e;
                H.launch(activity, arrayList, new E(), new F(g6, (List) this.f2836f, this.b, arrayList));
                break;
            case 2:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.c).lambda$onReceivedError$9((WebView) this.d, this.b, (String) this.e, (String) this.f2836f);
                break;
            default:
                ((WebViewClientProxyApi.WebViewClientImpl) this.c).lambda$onReceivedError$9((WebView) this.d, this.b, (String) this.e, (String) this.f2836f);
                break;
        }
    }

    public /* synthetic */ g(CloudSpaceFragment cloudSpaceFragment, P0 p1, TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) {
        this.f2835a = 0;
        this.c = cloudSpaceFragment;
        this.d = p1;
        this.e = templateConfigBean;
        this.b = i5;
        this.f2836f = templatePageView;
    }

    public /* synthetic */ g(G g6, Activity activity, ArrayList arrayList, List list, int i5) {
        this.f2835a = 1;
        this.c = g6;
        this.d = activity;
        this.e = arrayList;
        this.f2836f = list;
        this.b = i5;
    }
}
