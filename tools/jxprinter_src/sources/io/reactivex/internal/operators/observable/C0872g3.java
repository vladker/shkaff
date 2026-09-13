package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0872g3 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = -8693423678067375039L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0877h3 f5194a;

    public C0872g3(C0877h3 c0877h3) {
        this.f5194a = c0877h3;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        C0877h3 c0877h3 = this.f5194a;
        p033f3.d.a(c0877h3.b);
        com.android.billingclient.api.v1.f(c0877h3.f5200a, c0877h3, c0877h3.d);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        C0877h3 c0877h3 = this.f5194a;
        p033f3.d.a(c0877h3.b);
        com.android.billingclient.api.v1.h(c0877h3.f5200a, th, c0877h3, c0877h3.d);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        p033f3.d.a(this);
        C0877h3 c0877h3 = this.f5194a;
        p033f3.d.a(c0877h3.b);
        com.android.billingclient.api.v1.f(c0877h3.f5200a, c0877h3, c0877h3.d);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }
}
