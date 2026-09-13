package com.appdev.standard.page.printerlabel.util;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.appdev.standard.model.TemplateConfigBean;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.metadata.EventMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2762a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(int i5, Object obj, Object obj2, Object obj3, boolean z6) {
        this.f2762a = i5;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
        this.b = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2762a) {
            case 0:
                DataCreateUtil.lambda$create$9((Bitmap[]) this.c, (TemplateConfigBean) this.d, this.b, (DataCreateUtil.CreateBitmapEventListener) this.e);
                break;
            case 1:
                ((SessionReportingCoordinator) this.c).lambda$persistEvent$0((CrashlyticsReport.Session.Event) this.d, (EventMetadata) this.e, this.b);
                break;
            case 2:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.c).lambda$doUpdateVisitedHistory$15((WebView) this.d, (String) this.e, this.b);
                break;
            default:
                ((WebViewClientProxyApi.WebViewClientImpl) this.c).lambda$doUpdateVisitedHistory$15((WebView) this.d, (String) this.e, this.b);
                break;
        }
    }

    public /* synthetic */ c(Bitmap[] bitmapArr, TemplateConfigBean templateConfigBean, boolean z6, DataCreateUtil.CreateBitmapEventListener createBitmapEventListener) {
        this.f2762a = 0;
        this.c = bitmapArr;
        this.d = templateConfigBean;
        this.b = z6;
        this.e = createBitmapEventListener;
    }
}
