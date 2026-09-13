package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0936t3 extends AtomicReference implements p011b3.c, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5284a;

    public RunnableC0936t3(io.reactivex.I i5) {
        this.f5284a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (e()) {
            return;
        }
        io.reactivex.I i5 = this.f5284a;
        i5.onNext(0L);
        lazySet(p033f3.e.f3970a);
        i5.onComplete();
    }
}
