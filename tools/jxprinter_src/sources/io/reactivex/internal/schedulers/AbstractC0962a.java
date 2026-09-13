package io.reactivex.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.schedulers.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0962a extends AtomicReference implements p011b3.c, io.reactivex.schedulers.a {
    public static final FutureTask c;
    public static final FutureTask d;
    private static final long serialVersionUID = 1811839108042568751L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5345a;
    public Thread b;

    static {
        p039g3.i iVar = p039g3.z.b;
        c = new FutureTask(iVar, null);
        d = new FutureTask(iVar, null);
    }

    public AbstractC0962a(Runnable runnable) {
        this.f5345a = runnable;
    }

    public final void a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == c) {
                return;
            }
            if (future2 == d) {
                future.cancel(this.b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // p011b3.c
    public final void dispose() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == c || future == (futureTask = d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.b != Thread.currentThread());
    }

    @Override // p011b3.c
    public final boolean e() {
        Future future = (Future) get();
        return future == c || future == d;
    }

    @Override // io.reactivex.schedulers.a
    public final Runnable getWrappedRunnable() {
        return this.f5345a;
    }
}
