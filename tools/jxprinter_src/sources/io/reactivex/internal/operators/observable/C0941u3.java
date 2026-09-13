package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0941u3 extends AtomicBoolean implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 1015244841293359600L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5288a;
    public final io.reactivex.N b;
    public p011b3.c c;

    public C0941u3(io.reactivex.I i5, io.reactivex.N n6) {
        this.f5288a = i5;
        this.b = n6;
    }

    @Override // p011b3.c
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.b.scheduleDirect(new H2.c(this, 17));
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (get()) {
            return;
        }
        this.f5288a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (get()) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f5288a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (get()) {
            return;
        }
        this.f5288a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5288a.onSubscribe(this);
        }
    }
}
