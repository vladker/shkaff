package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E2 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -4592979584110982903L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4213a;
    public final AtomicReference b = new AtomicReference();
    public final D2 c = new D2(this);
    public final p100r3.c d = new p100r3.c();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4215g;

    public E2(t5.c cVar) {
        this.f4213a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.b);
        p033f3.d.a(this.c);
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4214f = true;
        if (this.f4215g) {
            com.android.billingclient.api.v1.g(this.f4213a, this, this.d);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p094q3.g.a(this.b);
        com.android.billingclient.api.v1.i(this.f4213a, th, this, this.d);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        com.android.billingclient.api.v1.k(this.f4213a, obj, this, this.d);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.b, this.e, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.b, this.e, j6);
    }
}
