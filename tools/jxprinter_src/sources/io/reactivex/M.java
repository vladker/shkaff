package io.reactivex;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M implements p011b3.c {
    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public p011b3.c schedule(Runnable runnable) {
        return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public abstract p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit);

    public p011b3.c schedulePeriodically(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        p033f3.h hVar = new p033f3.h();
        p033f3.h hVar2 = new p033f3.h(hVar);
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        long nanos = timeUnit.toNanos(j7);
        long jNow = now(TimeUnit.NANOSECONDS);
        p011b3.c cVarSchedule = schedule(new L(this, timeUnit.toNanos(j6) + jNow, runnableOnSchedule, jNow, hVar2, nanos), j6, timeUnit);
        if (cVarSchedule == p033f3.e.f3970a) {
            return cVarSchedule;
        }
        p033f3.d.c(hVar, cVarSchedule);
        return hVar2;
    }
}
