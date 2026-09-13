package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ServiceWorkerClientCompat {
    @WorkerThread
    public abstract WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest);
}
