package io.reactivex.internal.schedulers;

import com.android.billingclient.api.L0;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0971j extends io.reactivex.M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5353a;
    public final Executor b;
    public volatile boolean d;
    public final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p011b3.b f5354f = new p011b3.b();
    public final p083o3.b c = new p083o3.b();

    public RunnableC0971j(Executor executor, boolean z6) {
        this.b = executor;
        this.f5353a = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f5354f.dispose();
        if (this.e.getAndIncrement() == 0) {
            this.c.clear();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p083o3.b bVar = this.c;
        int iAddAndGet = 1;
        while (!this.d) {
            while (true) {
                Runnable runnable = (Runnable) bVar.poll();
                if (runnable == null) {
                    break;
                }
                runnable.run();
                if (this.d) {
                    bVar.clear();
                    return;
                }
            }
            if (this.d) {
                bVar.clear();
                return;
            } else {
                iAddAndGet = this.e.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        bVar.clear();
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        p011b3.c runnableC0969h;
        p033f3.e eVar = p033f3.e.f3970a;
        if (this.d) {
            return eVar;
        }
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        if (this.f5353a) {
            runnableC0969h = new RunnableC0970i(runnableOnSchedule, this.f5354f);
            this.f5354f.add(runnableC0969h);
        } else {
            runnableC0969h = new RunnableC0969h(runnableOnSchedule);
        }
        this.c.offer(runnableC0969h);
        if (this.e.getAndIncrement() != 0) {
            return runnableC0969h;
        }
        try {
            this.b.execute(this);
            return runnableC0969h;
        } catch (RejectedExecutionException e) {
            this.d = true;
            this.c.clear();
            io.reactivex.plugins.a.onError(e);
            return eVar;
        }
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        p033f3.e eVar = p033f3.e.f3970a;
        if (j6 <= 0) {
            return schedule(runnable);
        }
        if (this.d) {
            return eVar;
        }
        p033f3.h hVar = new p033f3.h();
        p033f3.h hVar2 = new p033f3.h(hVar);
        x xVar = new x(new L0(this, hVar2, io.reactivex.plugins.a.onSchedule(runnable)), this.f5354f);
        this.f5354f.add(xVar);
        Executor executor = this.b;
        if (executor instanceof ScheduledExecutorService) {
            try {
                xVar.a(((ScheduledExecutorService) executor).schedule((Callable) xVar, j6, timeUnit));
            } catch (RejectedExecutionException e) {
                this.d = true;
                io.reactivex.plugins.a.onError(e);
                return eVar;
            }
        } else {
            xVar.a(new FutureC0967f(C0972k.c.scheduleDirect(xVar, j6, timeUnit)));
        }
        p033f3.d.c(hVar, xVar);
        return hVar2;
    }
}
