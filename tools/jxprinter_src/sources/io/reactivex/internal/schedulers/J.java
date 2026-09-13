package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends io.reactivex.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f5341a;
    public final p011b3.b b = new p011b3.b();
    public volatile boolean c;

    public J(ScheduledExecutorService scheduledExecutorService) {
        this.f5341a = scheduledExecutorService;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        p033f3.e eVar = p033f3.e.f3970a;
        if (this.c) {
            return eVar;
        }
        x xVar = new x(io.reactivex.plugins.a.onSchedule(runnable), this.b);
        this.b.add(xVar);
        try {
            xVar.a(j6 <= 0 ? this.f5341a.submit((Callable) xVar) : this.f5341a.schedule((Callable) xVar, j6, timeUnit));
            return xVar;
        } catch (RejectedExecutionException e) {
            dispose();
            io.reactivex.plugins.a.onError(e);
            return eVar;
        }
    }
}
