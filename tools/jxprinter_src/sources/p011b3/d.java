package p011b3;

import java.util.concurrent.Future;
import p027e3.a;
import p033f3.e;
import p039g3.A;
import p039g3.z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static c disposed() {
        return e.f3970a;
    }

    public static c empty() {
        return fromRunnable(z.b);
    }

    public static c fromAction(a aVar) {
        A.b(aVar, "run is null");
        return new a(aVar);
    }

    public static c fromFuture(Future<?> future) {
        A.b(future, "future is null");
        return fromFuture(future, true);
    }

    public static c fromRunnable(Runnable runnable) {
        A.b(runnable, "run is null");
        return new g(runnable);
    }

    public static c fromSubscription(t5.d dVar) {
        A.b(dVar, "subscription is null");
        return new h(dVar);
    }

    public static c fromFuture(Future<?> future, boolean z6) {
        A.b(future, "future is null");
        return new e(future, z6);
    }
}
