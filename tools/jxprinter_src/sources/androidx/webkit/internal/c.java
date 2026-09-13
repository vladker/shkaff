package androidx.webkit.internal;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewPageBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1069a;
    public final /* synthetic */ WebViewPageBoundaryInterface b;

    public /* synthetic */ c(WebViewPageBoundaryInterface webViewPageBoundaryInterface, int i5) {
        this.f1069a = i5;
        this.b = webViewPageBoundaryInterface;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1069a) {
            case 0:
                return WebNavigationClientAdapter.lambda$onFirstContentfulPaint$6(this.b);
            case 1:
                return WebNavigationClientAdapter.lambda$onPageDeleted$3(this.b);
            case 2:
                return WebNavigationClientAdapter.lambda$onPageLoadEventFired$4(this.b);
            default:
                return WebNavigationClientAdapter.lambda$onPageDOMContentLoadedEventFired$5(this.b);
        }
    }
}
