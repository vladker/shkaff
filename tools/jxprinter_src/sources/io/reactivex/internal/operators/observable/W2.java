package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W2 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5127a;
    public final p033f3.a b;
    public p011b3.c c;
    public volatile boolean d;
    public boolean e;

    public W2(p112t3.e eVar, p033f3.a aVar) {
        this.f5127a = eVar;
        this.b = aVar;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.b.dispose();
        this.f5127a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.b.dispose();
        this.f5127a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.e) {
            this.f5127a.onNext(obj);
        } else if (this.d) {
            this.e = true;
            this.f5127a.onNext(obj);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            this.b.a(0, cVar);
        }
    }
}
