package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC0975n implements Callable, p011b3.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FutureTask f5355f = new FutureTask(p039g3.z.b, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5356a;
    public final ExecutorService d;
    public Thread e;
    public final AtomicReference c = new AtomicReference();
    public final AtomicReference b = new AtomicReference();

    public CallableC0975n(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.f5356a = runnable;
        this.d = scheduledExecutorService;
    }

    public final void a(Future future) {
        while (true) {
            AtomicReference atomicReference = this.c;
            Future future2 = (Future) atomicReference.get();
            if (future2 == f5355f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            } else {
                while (!atomicReference.compareAndSet(future2, future)) {
                    if (atomicReference.get() != future2) {
                    }
                }
                return;
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        AtomicReference atomicReference = this.c;
        FutureTask futureTask = f5355f;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.e != Thread.currentThread());
        }
        Future future2 = (Future) this.b.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.e != Thread.currentThread());
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == f5355f;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        this.e = Thread.currentThread();
        try {
            this.f5356a.run();
            Future futureSubmit = this.d.submit(this);
            AtomicReference atomicReference = this.b;
            loop0: while (true) {
                Future future = (Future) atomicReference.get();
                if (future == f5355f) {
                    futureSubmit.cancel(this.e != Thread.currentThread());
                    break;
                }
                do {
                    if (atomicReference.compareAndSet(future, futureSubmit)) {
                        break loop0;
                    }
                } while (atomicReference.get() == future);
            }
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            io.reactivex.plugins.a.onError(th);
        }
        return null;
    }
}
