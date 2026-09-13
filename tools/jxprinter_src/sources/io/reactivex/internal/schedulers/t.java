package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class t extends io.reactivex.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f5363a;
    public volatile boolean b;

    public t(ThreadFactory threadFactory) {
        boolean z6 = A.f5334a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (A.f5334a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            A.d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.f5363a = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5363a.shutdownNow();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    public x scheduleActual(Runnable runnable, long j6, TimeUnit timeUnit, p033f3.c cVar) {
        x xVar = new x(io.reactivex.plugins.a.onSchedule(runnable), cVar);
        if (cVar != null && !cVar.add(xVar)) {
            return xVar;
        }
        ScheduledExecutorService scheduledExecutorService = this.f5363a;
        try {
            xVar.a(j6 <= 0 ? scheduledExecutorService.submit((Callable) xVar) : scheduledExecutorService.schedule((Callable) xVar, j6, timeUnit));
            return xVar;
        } catch (RejectedExecutionException e) {
            if (cVar != null) {
                cVar.remove(xVar);
            }
            io.reactivex.plugins.a.onError(e);
            return xVar;
        }
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        return this.b ? p033f3.e.f3970a : scheduleActual(runnable, j6, timeUnit, null);
    }
}
