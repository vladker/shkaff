package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = -7449079488798789337L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5035a;
    public final O b;

    public N(p112t3.e eVar, O o6) {
        this.f5035a = eVar;
        this.b = o6;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        O o6 = this.b;
        o6.f5050g = false;
        o6.a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.b.dispose();
        this.f5035a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5035a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.c(this, cVar);
    }
}
