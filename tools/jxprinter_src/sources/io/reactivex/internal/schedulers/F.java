package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends io.reactivex.M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f5339a = new AtomicBoolean();
    public final p123v3.a b;
    public final io.reactivex.M c;

    public F(p123v3.a aVar, io.reactivex.M m6) {
        this.b = aVar;
        this.c = m6;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (this.f5339a.compareAndSet(false, true)) {
            this.b.onComplete();
            this.c.dispose();
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5339a.get();
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable, long j6, TimeUnit timeUnit) {
        D d = new D(runnable, j6, timeUnit);
        this.b.onNext(d);
        return d;
    }

    @Override // io.reactivex.M
    public p011b3.c schedule(Runnable runnable) {
        E e = new E(runnable);
        this.b.onNext(e);
        return e;
    }
}
