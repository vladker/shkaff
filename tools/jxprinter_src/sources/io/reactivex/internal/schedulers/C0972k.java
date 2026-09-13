package io.reactivex.internal.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0972k extends io.reactivex.N {
    public static final io.reactivex.N c = io.reactivex.schedulers.j.single();
    public final boolean b;
    final Executor executor;

    public C0972k(Executor executor, boolean z6) {
        this.executor = executor;
        this.b = z6;
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new RunnableC0971j(this.executor, this.b);
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable) {
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        try {
            if (this.executor instanceof ExecutorService) {
                w wVar = new w(runnableOnSchedule);
                wVar.a(((ExecutorService) this.executor).submit(wVar));
                return wVar;
            }
            if (this.b) {
                RunnableC0970i runnableC0970i = new RunnableC0970i(runnableOnSchedule, null);
                this.executor.execute(runnableC0970i);
                return runnableC0970i;
            }
            RunnableC0969h runnableC0969h = new RunnableC0969h(runnableOnSchedule);
            this.executor.execute(runnableC0969h);
            return runnableC0969h;
        } catch (RejectedExecutionException e) {
            io.reactivex.plugins.a.onError(e);
            return p033f3.e.f3970a;
        }
    }

    @Override // io.reactivex.N
    public p011b3.c schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        if (!(this.executor instanceof ScheduledExecutorService)) {
            return super.schedulePeriodicallyDirect(runnable, j6, j7, timeUnit);
        }
        try {
            v vVar = new v(io.reactivex.plugins.a.onSchedule(runnable));
            vVar.a(((ScheduledExecutorService) this.executor).scheduleAtFixedRate(vVar, j6, j7, timeUnit));
            return vVar;
        } catch (RejectedExecutionException e) {
            io.reactivex.plugins.a.onError(e);
            return p033f3.e.f3970a;
        }
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        if (this.executor instanceof ScheduledExecutorService) {
            try {
                w wVar = new w(runnableOnSchedule);
                wVar.a(((ScheduledExecutorService) this.executor).schedule(wVar, j6, timeUnit));
                return wVar;
            } catch (RejectedExecutionException e) {
                io.reactivex.plugins.a.onError(e);
                return p033f3.e.f3970a;
            }
        }
        RunnableC0968g runnableC0968g = new RunnableC0968g(runnableOnSchedule);
        p011b3.c cVarScheduleDirect = c.scheduleDirect(new Q0.b(this, 19, runnableC0968g, false), j6, timeUnit);
        p033f3.h hVar = runnableC0968g.f5350a;
        hVar.getClass();
        p033f3.d.c(hVar, cVarScheduleDirect);
        return runnableC0968g;
    }
}
