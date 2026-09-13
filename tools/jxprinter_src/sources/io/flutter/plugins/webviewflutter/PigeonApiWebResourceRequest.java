package io.flutter.plugins.webviewflutter;

import A3.I;
import android.webkit.WebResourceRequest;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiWebResourceRequest {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public PigeonApiWebResourceRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.E.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(O3.l lVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            com.google.android.gms.auth.api.accounttransfer.a.o(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str), lVar);
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            AbstractC1125a.q(Q.INSTANCE, lVar);
            return;
        }
        Object obj2 = list.get(0);
        kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
        com.google.android.gms.auth.api.accounttransfer.a.o(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2)), lVar);
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract boolean hasGesture(WebResourceRequest webResourceRequest);

    public abstract boolean isForMainFrame(WebResourceRequest webResourceRequest);

    public abstract Boolean isRedirect(WebResourceRequest webResourceRequest);

    public abstract String method(WebResourceRequest webResourceRequest);

    public final void pigeon_newInstance(WebResourceRequest pigeon_instanceArg, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
            return;
        }
        if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            AbstractC1125a.q(Q.INSTANCE, callback);
            return;
        }
        long jAddHostCreatedInstance = getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg);
        String strUrl = url(pigeon_instanceArg);
        boolean zIsForMainFrame = isForMainFrame(pigeon_instanceArg);
        Boolean boolIsRedirect = isRedirect(pigeon_instanceArg);
        boolean zHasGesture = hasGesture(pigeon_instanceArg);
        new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(I.listOf(Long.valueOf(jAddHostCreatedInstance), strUrl, Boolean.valueOf(zIsForMainFrame), boolIsRedirect, Boolean.valueOf(zHasGesture), method(pigeon_instanceArg), requestHeaders(pigeon_instanceArg)), new u(3, callback));
    }

    public abstract Map<String, String> requestHeaders(WebResourceRequest webResourceRequest);

    public abstract String url(WebResourceRequest webResourceRequest);
}
