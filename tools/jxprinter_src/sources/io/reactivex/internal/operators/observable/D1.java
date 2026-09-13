package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D1 extends io.reactivex.B implements p043h3.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4898a;

    public D1(Object obj) {
        this.f4898a = obj;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        L2 l6 = new L2(i5, this.f4898a);
        i5.onSubscribe(l6);
        l6.run();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f4898a;
    }
}
