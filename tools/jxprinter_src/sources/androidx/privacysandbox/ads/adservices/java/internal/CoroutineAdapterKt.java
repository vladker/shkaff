package androidx.privacysandbox.ads.adservices.java.internal;

import F4.f;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.E;
import p007a4.V;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineAdapterKt {
    public static final <T> ListenableFuture<T> asListenableFuture(V v6, Object obj) {
        E.f(v6, "<this>");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new f(v6, obj, 3));
        E.e(future, "getFuture { completer ->…      }\n        tag\n    }");
        return future;
    }

    public static /* synthetic */ ListenableFuture asListenableFuture$default(V v6, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(v6, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(V this_asListenableFuture, Object obj, CallbackToFutureAdapter.Completer completer) {
        E.f(this_asListenableFuture, "$this_asListenableFuture");
        E.f(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new CoroutineAdapterKt$asListenableFuture$1$1(completer, this_asListenableFuture));
        return obj;
    }
}
