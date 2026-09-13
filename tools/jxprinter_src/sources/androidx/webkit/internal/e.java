package androidx.webkit.internal;

import android.webkit.ValueCallback;
import androidx.webkit.PrerenderOperationCallback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1071a;
    public final /* synthetic */ PrerenderOperationCallback b;

    public /* synthetic */ e(PrerenderOperationCallback prerenderOperationCallback, int i5) {
        this.f1071a = i5;
        this.b = prerenderOperationCallback;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.f1071a) {
            case 0:
                this.b.onPrerenderActivated();
                break;
            case 1:
                WebViewProviderAdapter.lambda$prerenderUrlAsync$3(this.b, (Throwable) obj);
                break;
            case 2:
                this.b.onPrerenderActivated();
                break;
            default:
                WebViewProviderAdapter.lambda$prerenderUrlAsync$1(this.b, (Throwable) obj);
                break;
        }
    }
}
