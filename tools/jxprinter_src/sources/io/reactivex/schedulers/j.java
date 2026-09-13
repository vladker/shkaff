package io.reactivex.schedulers;

import io.reactivex.N;
import io.reactivex.internal.schedulers.C0972k;
import io.reactivex.internal.schedulers.O;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    static final N SINGLE = io.reactivex.plugins.a.initSingleScheduler(new i());
    static final N COMPUTATION = io.reactivex.plugins.a.initComputationScheduler(new c());
    static final N IO = io.reactivex.plugins.a.initIoScheduler(new d());
    static final N TRAMPOLINE = O.b;
    static final N NEW_THREAD = io.reactivex.plugins.a.initNewThreadScheduler(new g());

    public static N computation() {
        return io.reactivex.plugins.a.onComputationScheduler(COMPUTATION);
    }

    public static N from(Executor executor) {
        return new C0972k(executor, false);
    }

    public static N io() {
        return io.reactivex.plugins.a.onIoScheduler(IO);
    }

    public static N newThread() {
        return io.reactivex.plugins.a.onNewThreadScheduler(NEW_THREAD);
    }

    public static N single() {
        return io.reactivex.plugins.a.onSingleScheduler(SINGLE);
    }

    public static N trampoline() {
        return TRAMPOLINE;
    }

    public static N from(Executor executor, boolean z6) {
        return new C0972k(executor, z6);
    }
}
