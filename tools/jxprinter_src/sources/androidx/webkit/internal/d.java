package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewNavigationBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1070a;
    public final /* synthetic */ WebViewNavigationBoundaryInterface b;

    public /* synthetic */ d(WebViewNavigationBoundaryInterface webViewNavigationBoundaryInterface, int i5) {
        this.f1070a = i5;
        this.b = webViewNavigationBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1070a) {
            case 0:
                return WebNavigationClientAdapter.lambda$onNavigationStarted$0(this.b);
            case 1:
                return WebNavigationClientAdapter.lambda$onNavigationRedirected$1(this.b);
            default:
                return WebNavigationClientAdapter.lambda$onNavigationCompleted$2(this.b);
        }
    }
}
