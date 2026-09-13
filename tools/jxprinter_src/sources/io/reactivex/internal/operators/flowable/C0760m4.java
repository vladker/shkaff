package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.m4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0760m4 extends AtomicInteger implements p043h3.a, t5.d {
    private static final long serialVersionUID = -6270983465606289181L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4704a;
    public final AtomicReference b = new AtomicReference();
    public final AtomicLong c = new AtomicLong();
    public final C0754l4 d = new C0754l4(this);
    public final p100r3.c e = new p100r3.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4705f;

    public C0760m4(t5.c cVar) {
        this.f4704a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.b);
        p094q3.g.a(this.d);
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (!this.f4705f) {
            return false;
        }
        com.android.billingclient.api.v1.k(this.f4704a, obj, this, this.e);
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        p094q3.g.a(this.d);
        com.android.billingclient.api.v1.g(this.f4704a, this, this.e);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p094q3.g.a(this.d);
        com.android.billingclient.api.v1.i(this.f4704a, th, this, this.e);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj)) {
            return;
        }
        ((t5.d) this.b.get()).request(1L);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.b, this.c, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.b, this.c, j6);
    }
}
