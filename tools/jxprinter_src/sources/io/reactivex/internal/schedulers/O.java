package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O extends io.reactivex.N {
    public static final O b = new O();

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new N();
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable) {
        io.reactivex.plugins.a.onSchedule(runnable).run();
        return p033f3.e.f3970a;
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j6);
            io.reactivex.plugins.a.onSchedule(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            io.reactivex.plugins.a.onError(e);
        }
        return p033f3.e.f3970a;
    }
}
