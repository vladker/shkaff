package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X1 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 854110278590336484L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5130a;
    public p011b3.c b;

    public X1(io.reactivex.I i5) {
        this.f5130a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.dispose();
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.a(this);
        this.f5130a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this);
        this.f5130a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5130a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.b, cVar)) {
            this.b = cVar;
            this.f5130a.onSubscribe(this);
        }
    }
}
