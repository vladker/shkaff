package io.reactivex;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f4173a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract M createWorker();

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public p011b3.c scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public p011b3.c schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        M mCreateWorker = createWorker();
        K k6 = new K(io.reactivex.plugins.a.onSchedule(runnable), mCreateWorker);
        p011b3.c cVarSchedulePeriodically = mCreateWorker.schedulePeriodically(k6, j6, j7, timeUnit);
        return cVarSchedulePeriodically == p033f3.e.f3970a ? cVarSchedulePeriodically : k6;
    }

    public <S extends N & p011b3.c> S when(p027e3.o oVar) {
        return new io.reactivex.internal.schedulers.I(oVar, this);
    }

    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        M mCreateWorker = createWorker();
        J j7 = new J(io.reactivex.plugins.a.onSchedule(runnable), mCreateWorker);
        mCreateWorker.schedule(j7, j6, timeUnit);
        return j7;
    }
}
