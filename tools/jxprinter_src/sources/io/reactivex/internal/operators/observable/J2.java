package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J2 extends K2 {
    private static final long serialVersionUID = -3029755663834015785L;

    @Override // io.reactivex.internal.operators.observable.K2
    public final void a() {
        this.f5000a.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.K2
    public final void b() {
        this.f5000a.onComplete();
    }

    @Override // io.reactivex.internal.operators.observable.K2
    public final void c() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            this.f5000a.onNext(andSet);
        }
    }
}
