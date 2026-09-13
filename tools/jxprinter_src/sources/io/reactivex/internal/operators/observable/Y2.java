package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y2 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 8094547886072529208L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5134a;
    public final AtomicReference b = new AtomicReference();

    public Y2(io.reactivex.I i5) {
        this.f5134a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.b);
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5134a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5134a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5134a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.b, cVar);
    }
}
