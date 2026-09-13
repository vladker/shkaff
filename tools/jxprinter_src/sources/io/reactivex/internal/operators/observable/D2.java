package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D2 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = 3254781284376480842L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E2 f4899a;

    public D2(E2 e6) {
        this.f4899a = e6;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        E2 e6 = this.f4899a;
        p033f3.d.a(e6.f4914f);
        com.android.billingclient.api.v1.f(e6.f4913a, e6, e6.c);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        E2 e6 = this.f4899a;
        p033f3.d.a(e6.f4914f);
        com.android.billingclient.api.v1.h(e6.f4913a, th, e6, e6.c);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f4899a.a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
