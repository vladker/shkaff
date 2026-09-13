package io.reactivex.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends io.reactivex.N {
    public static final u c;
    public static final ScheduledExecutorService d;
    public final AtomicReference b;

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        d = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        c = new u("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public K(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.b = atomicReference;
        boolean z6 = A.f5334a;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (A.f5334a && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            A.d.put((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool, scheduledExecutorServiceNewScheduledThreadPool);
        }
        atomicReference.lazySet(scheduledExecutorServiceNewScheduledThreadPool);
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new J((ScheduledExecutorService) this.b.get());
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        w wVar = new w(io.reactivex.plugins.a.onSchedule(runnable));
        AtomicReference atomicReference = this.b;
        try {
            wVar.a(j6 <= 0 ? ((ScheduledExecutorService) atomicReference.get()).submit(wVar) : ((ScheduledExecutorService) atomicReference.get()).schedule(wVar, j6, timeUnit));
            return wVar;
        } catch (RejectedExecutionException e) {
            io.reactivex.plugins.a.onError(e);
            return p033f3.e.f3970a;
        }
    }

    @Override // io.reactivex.N
    public p011b3.c schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        p033f3.e eVar = p033f3.e.f3970a;
        AtomicReference atomicReference = this.b;
        if (j7 > 0) {
            v vVar = new v(runnableOnSchedule);
            try {
                vVar.a(((ScheduledExecutorService) atomicReference.get()).scheduleAtFixedRate(vVar, j6, j7, timeUnit));
                return vVar;
            } catch (RejectedExecutionException e) {
                io.reactivex.plugins.a.onError(e);
                return eVar;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) atomicReference.get();
        CallableC0975n callableC0975n = new CallableC0975n(runnableOnSchedule, scheduledExecutorService);
        try {
            callableC0975n.a(j6 <= 0 ? scheduledExecutorService.submit(callableC0975n) : scheduledExecutorService.schedule(callableC0975n, j6, timeUnit));
            return callableC0975n;
        } catch (RejectedExecutionException e6) {
            io.reactivex.plugins.a.onError(e6);
            return eVar;
        }
    }
}
