package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = 2620149119579502636L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5002a;
    public final M b;

    public L(io.reactivex.I i5, M m6) {
        this.f5002a = i5;
        this.b = m6;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        M m6 = this.b;
        m6.f5024i = false;
        m6.a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        M m6 = this.b;
        p100r3.c cVar = m6.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        if (!m6.f5021f) {
            m6.f5023h.dispose();
        }
        m6.f5024i = false;
        m6.a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5002a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.c(this, cVar);
    }
}
