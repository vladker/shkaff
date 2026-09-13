package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U3 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -8612022020200669122L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5119a;
    public final AtomicReference b = new AtomicReference();

    public U3(io.reactivex.I i5) {
        this.f5119a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.b);
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        dispose();
        this.f5119a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        dispose();
        this.f5119a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5119a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this.b, cVar)) {
            this.f5119a.onSubscribe(this);
        }
    }
}
