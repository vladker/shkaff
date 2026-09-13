package W3;

import android.webkit.JsPromptResult;
import io.flutter.plugins.webviewflutter.ResultCompat;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class G implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f797a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ G(Object obj, Object obj2, int i5) {
        this.f797a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f797a) {
            case 0:
                kotlin.jvm.internal.P p6 = (kotlin.jvm.internal.P) this.b;
                boolean z6 = true;
                if (!p6.f5686a && kotlin.jvm.internal.E.a(obj, this.c)) {
                    p6.f5686a = true;
                    z6 = false;
                }
                return Boolean.valueOf(z6);
            case 1:
                return p012b4.c.c((p012b4.c) this.b, (Q0.b) this.c);
            case 2:
                ((p049i4.g) this.b).unlock(((p049i4.c) this.c).owner);
                return p147z3.Q.INSTANCE;
            default:
                return ((WebChromeClientProxyApi.WebChromeClientImpl) this.b).lambda$onJsPrompt$10((JsPromptResult) this.c, (ResultCompat) obj);
        }
    }
}
