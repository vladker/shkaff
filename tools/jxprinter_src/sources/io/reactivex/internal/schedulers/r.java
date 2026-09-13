package io.reactivex.internal.schedulers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends io.reactivex.N {
    public static final u c;
    public static final u d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f5361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final RunnableC0976o f5362h;
    public final AtomicReference b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeUnit f5360f = TimeUnit.SECONDS;
    public static final long e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        q qVar = new q(new u("RxCachedThreadSchedulerShutdown"));
        f5361g = qVar;
        qVar.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        u uVar = new u("RxCachedThreadScheduler", iMax, false);
        c = uVar;
        d = new u("RxCachedWorkerPoolEvictor", iMax, false);
        RunnableC0976o runnableC0976o = new RunnableC0976o(0L, null, uVar);
        f5362h = runnableC0976o;
        runnableC0976o.c.dispose();
        ScheduledFuture scheduledFuture = runnableC0976o.e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = runnableC0976o.d;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public r(ThreadFactory threadFactory) {
        RunnableC0976o runnableC0976o = f5362h;
        AtomicReference atomicReference = new AtomicReference(runnableC0976o);
        this.b = atomicReference;
        RunnableC0976o runnableC0976o2 = new RunnableC0976o(e, f5360f, threadFactory);
        while (!atomicReference.compareAndSet(runnableC0976o, runnableC0976o2)) {
            if (atomicReference.get() != runnableC0976o) {
                runnableC0976o2.c.dispose();
                ScheduledFuture scheduledFuture = runnableC0976o2.e;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = runnableC0976o2.d;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    return;
                }
                return;
            }
        }
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new p((RunnableC0976o) this.b.get());
    }
}
