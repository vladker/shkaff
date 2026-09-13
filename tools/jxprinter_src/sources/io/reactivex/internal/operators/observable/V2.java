package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V2 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p033f3.a f5122a;
    public final W2 b;
    public final p112t3.e c;
    public p011b3.c d;

    public V2(p033f3.a aVar, W2 w6, p112t3.e eVar) {
        this.f5122a = aVar;
        this.b = w6;
        this.c = eVar;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.b.d = true;
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5122a.dispose();
        this.c.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.d.dispose();
        this.b.d = true;
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f5122a.a(1, cVar);
        }
    }
}
