package io.reactivex;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L implements Runnable, io.reactivex.schedulers.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4172a;
    public long b;
    public long c;
    public long d;
    final Runnable decoratedRun;
    public final /* synthetic */ M e;
    final p033f3.h sd;

    public L(M m6, long j6, Runnable runnable, long j7, p033f3.h hVar, long j8) {
        this.e = m6;
        this.decoratedRun = runnable;
        this.sd = hVar;
        this.f4172a = j8;
        this.c = j7;
        this.d = j6;
    }

    @Override // io.reactivex.schedulers.a
    public final Runnable getWrappedRunnable() {
        return this.decoratedRun;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j6;
        this.decoratedRun.run();
        if (this.sd.e()) {
            return;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        M m6 = this.e;
        long jNow = m6.now(timeUnit);
        long j7 = N.f4173a;
        long j8 = jNow + j7;
        long j9 = this.c;
        long j10 = this.f4172a;
        if (j8 < j9 || jNow >= j9 + j10 + j7) {
            j6 = jNow + j10;
            long j11 = this.b + 1;
            this.b = j11;
            this.d = j6 - (j10 * j11);
        } else {
            long j12 = this.d;
            long j13 = this.b + 1;
            this.b = j13;
            j6 = (j13 * j10) + j12;
        }
        this.c = jNow;
        long j14 = j6 - jNow;
        p033f3.h hVar = this.sd;
        p011b3.c cVarSchedule = m6.schedule(this, j14, timeUnit);
        hVar.getClass();
        p033f3.d.c(hVar, cVarSchedule);
    }
}
