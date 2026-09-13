package io.reactivex.internal.schedulers;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0966e extends io.reactivex.N implements z {
    public static final C0964c c;
    public static final u d;
    public static final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0965d f5348f;
    public final AtomicReference b;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        e = iAvailableProcessors;
        C0965d c0965d = new C0965d(new u("RxComputationShutdown"));
        f5348f = c0965d;
        c0965d.dispose();
        u uVar = new u("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        d = uVar;
        C0964c c0964c = new C0964c(uVar, 0);
        c = c0964c;
        for (C0965d c0965d2 : c0964c.b) {
            c0965d2.dispose();
        }
    }

    public C0966e(ThreadFactory threadFactory) {
        C0964c c0964c = c;
        AtomicReference atomicReference = new AtomicReference(c0964c);
        this.b = atomicReference;
        C0964c c0964c2 = new C0964c(threadFactory, e);
        while (!atomicReference.compareAndSet(c0964c, c0964c2)) {
            if (atomicReference.get() != c0964c) {
                for (C0965d c0965d : c0964c2.b) {
                    c0965d.dispose();
                }
                return;
            }
        }
    }

    @Override // io.reactivex.N
    public io.reactivex.M createWorker() {
        return new C0963b(((C0964c) this.b.get()).a());
    }

    @Override // io.reactivex.internal.schedulers.z
    public final void createWorkers(int i5, y yVar) {
        p039g3.A.c(i5, "number > 0 required");
        ((C0964c) this.b.get()).createWorkers(i5, yVar);
    }

    @Override // io.reactivex.N
    public p011b3.c scheduleDirect(Runnable runnable, long j6, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = ((C0964c) this.b.get()).a().f5363a;
        w wVar = new w(io.reactivex.plugins.a.onSchedule(runnable));
        try {
            wVar.a(j6 <= 0 ? scheduledExecutorService.submit(wVar) : scheduledExecutorService.schedule(wVar, j6, timeUnit));
            return wVar;
        } catch (RejectedExecutionException e6) {
            io.reactivex.plugins.a.onError(e6);
            return p033f3.e.f3970a;
        }
    }

    @Override // io.reactivex.N
    public p011b3.c schedulePeriodicallyDirect(Runnable runnable, long j6, long j7, TimeUnit timeUnit) {
        C0965d c0965dA = ((C0964c) this.b.get()).a();
        ScheduledExecutorService scheduledExecutorService = c0965dA.f5363a;
        Runnable runnableOnSchedule = io.reactivex.plugins.a.onSchedule(runnable);
        if (j7 <= 0) {
            CallableC0975n callableC0975n = new CallableC0975n(runnableOnSchedule, scheduledExecutorService);
            try {
                callableC0975n.a(j6 <= 0 ? scheduledExecutorService.submit(callableC0975n) : scheduledExecutorService.schedule(callableC0975n, j6, timeUnit));
                return callableC0975n;
            } catch (RejectedExecutionException e6) {
                io.reactivex.plugins.a.onError(e6);
            }
        } else {
            v vVar = new v(runnableOnSchedule);
            try {
                vVar.a(c0965dA.f5363a.scheduleAtFixedRate(vVar, j6, j7, timeUnit));
                return vVar;
            } catch (RejectedExecutionException e7) {
                io.reactivex.plugins.a.onError(e7);
            }
        }
        return p033f3.e.f3970a;
    }
}
