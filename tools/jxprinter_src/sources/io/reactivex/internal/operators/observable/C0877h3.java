package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0877h3 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 1418547743690811973L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5200a;
    public final AtomicReference b = new AtomicReference();
    public final C0872g3 c = new C0872g3(this);
    public final p100r3.c d = new p100r3.c();

    public C0877h3(io.reactivex.I i5) {
        this.f5200a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.b);
        p033f3.d.a(this.c);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.b.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.a(this.c);
        com.android.billingclient.api.v1.f(this.f5200a, this, this.d);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.c);
        com.android.billingclient.api.v1.h(this.f5200a, th, this, this.d);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        com.android.billingclient.api.v1.j(this.f5200a, obj, this, this.d);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.b, cVar);
    }
}
