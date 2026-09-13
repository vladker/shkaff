package androidx.core.view.accessibility;

import android.os.Binder;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.contentcapture.ContentCaptureSession;
import android.webkit.WebViewRenderProcess;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ Binder e() {
        return new Binder("WINDOW_AREA_REAR_DISPLAY");
    }

    public static /* synthetic */ AccessibilityNodeInfo.TouchDelegateInfo h(Map map) {
        return new AccessibilityNodeInfo.TouchDelegateInfo(map);
    }

    public static /* bridge */ /* synthetic */ ContentCaptureSession j(Object obj) {
        return (ContentCaptureSession) obj;
    }

    public static /* bridge */ /* synthetic */ WebViewRenderProcess l(Object obj) {
        return (WebViewRenderProcess) obj;
    }
}
