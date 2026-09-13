package io.reactivex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K implements p011b3.c, Runnable, io.reactivex.schedulers.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f4171a;
    final Runnable run;
    final M worker;

    public K(Runnable runnable, M m6) {
        this.run = runnable;
        this.worker = m6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f4171a = true;
        this.worker.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4171a;
    }

    @Override // io.reactivex.schedulers.a
    public final Runnable getWrappedRunnable() {
        return this.run;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4171a) {
            return;
        }
        try {
            this.run.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.worker.dispose();
            throw p100r3.g.d(th);
        }
    }
}
