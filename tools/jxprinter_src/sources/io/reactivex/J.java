package io.reactivex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J implements p011b3.c, Runnable, io.reactivex.schedulers.a {
    final Runnable decoratedRun;
    Thread runner;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final M f4170w;

    public J(Runnable runnable, M m6) {
        this.decoratedRun = runnable;
        this.f4170w = m6;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.runner == Thread.currentThread()) {
            M m6 = this.f4170w;
            if (m6 instanceof io.reactivex.internal.schedulers.t) {
                io.reactivex.internal.schedulers.t tVar = (io.reactivex.internal.schedulers.t) m6;
                if (tVar.b) {
                    return;
                }
                tVar.b = true;
                tVar.f5363a.shutdown();
                return;
            }
        }
        this.f4170w.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4170w.e();
    }

    @Override // io.reactivex.schedulers.a
    public final Runnable getWrappedRunnable() {
        return this.decoratedRun;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.runner = Thread.currentThread();
        try {
            this.decoratedRun.run();
        } finally {
            dispose();
            this.runner = null;
        }
    }
}
