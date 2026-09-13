package io.reactivex.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0976o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5357a;
    public final ConcurrentLinkedQueue b;
    public final p011b3.b c;
    public final ScheduledExecutorService d;
    public final ScheduledFuture e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ThreadFactory f5358f;

    public RunnableC0976o(long j6, TimeUnit timeUnit, ThreadFactory threadFactory) {
        RunnableC0976o runnableC0976o;
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        long nanos = timeUnit != null ? timeUnit.toNanos(j6) : 0L;
        this.f5357a = nanos;
        this.b = new ConcurrentLinkedQueue();
        this.c = new p011b3.b();
        this.f5358f = threadFactory;
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, r.d);
            runnableC0976o = this;
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(runnableC0976o, nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            runnableC0976o = this;
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        runnableC0976o.d = scheduledExecutorServiceNewScheduledThreadPool;
        runnableC0976o.e = scheduledFutureScheduleWithFixedDelay;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue<q> concurrentLinkedQueue = this.b;
        if (concurrentLinkedQueue.isEmpty()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        for (q qVar : concurrentLinkedQueue) {
            if (qVar.c > jNanoTime) {
                return;
            }
            if (concurrentLinkedQueue.remove(qVar)) {
                this.c.remove(qVar);
            }
        }
    }
}
