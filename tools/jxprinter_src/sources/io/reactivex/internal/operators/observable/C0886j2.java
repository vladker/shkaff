package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0886j2 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = 3254781284376480842L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0891k2 f5210a;

    public C0886j2(C0891k2 c0891k2) {
        this.f5210a = c0891k2;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        C0891k2 c0891k2 = this.f5210a;
        p033f3.d.a(c0891k2.f5224f);
        com.android.billingclient.api.v1.f(c0891k2.f5223a, c0891k2, c0891k2.c);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        C0891k2 c0891k2 = this.f5210a;
        p033f3.d.a(c0891k2.f5224f);
        com.android.billingclient.api.v1.h(c0891k2.f5223a, th, c0891k2, c0891k2.c);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5210a.a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
