package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J1 extends AtomicInteger implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -4592979584110982903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4985a;
    public final AtomicReference b = new AtomicReference();
    public final I1 c = new I1(this);
    public final p100r3.c d = new p100r3.c();
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4986f;

    public J1(io.reactivex.I i5) {
        this.f4985a = i5;
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
        this.e = true;
        if (this.f4986f) {
            com.android.billingclient.api.v1.f(this.f4985a, this, this.d);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.b);
        com.android.billingclient.api.v1.h(this.f4985a, th, this, this.d);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        com.android.billingclient.api.v1.j(this.f4985a, obj, this, this.d);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.b, cVar);
    }
}
