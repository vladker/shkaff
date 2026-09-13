package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W extends AtomicReference implements io.reactivex.I, io.reactivex.S, p011b3.c {
    private static final long serialVersionUID = -1953724749712440952L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5123a;
    public io.reactivex.V b;
    public boolean c;

    public W(io.reactivex.I i5, io.reactivex.V v6) {
        this.f5123a = i5;
        this.b = v6;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.c = true;
        p033f3.d.c(this, null);
        io.reactivex.V v6 = this.b;
        this.b = null;
        ((io.reactivex.O) v6).subscribe(this);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5123a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5123a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (!p033f3.d.f(this, cVar) || this.c) {
            return;
        }
        this.f5123a.onSubscribe(this);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        io.reactivex.I i5 = this.f5123a;
        i5.onNext(obj);
        i5.onComplete();
    }
}
