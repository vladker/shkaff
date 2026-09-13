package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0803u0 extends AbstractC0774p0 {
    private static final long serialVersionUID = 3776720187248809713L;

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0, io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        long j6;
        if (this.b.e()) {
            return;
        }
        if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.f4725a.onNext(obj);
        do {
            j6 = get();
            if (j6 == 0) {
                return;
            }
        } while (!compareAndSet(j6, j6 - 1));
    }
}
