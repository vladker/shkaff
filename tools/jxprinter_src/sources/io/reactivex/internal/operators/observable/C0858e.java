package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0858e extends p112t3.b {
    public volatile Object b;

    @Override // io.reactivex.I
    public final void onComplete() {
        this.b = p100r3.n.f7968a;
    }

    @Override // p112t3.b, io.reactivex.I
    public final void onError(Throwable th) {
        this.b = new p100r3.l(th);
    }

    @Override // p112t3.b, io.reactivex.I
    public final void onNext(Object obj) {
        this.b = obj;
    }
}
