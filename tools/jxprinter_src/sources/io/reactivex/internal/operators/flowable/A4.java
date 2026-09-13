package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A4 extends AtomicInteger implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -4945480365982832967L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4179a;
    public final AtomicLong b = new AtomicLong();
    public final AtomicReference c = new AtomicReference();
    public final C0837z4 e = new C0837z4(this);
    public final p100r3.c d = new p100r3.c();

    public A4(t5.c cVar) {
        this.f4179a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.c);
        p094q3.g.a(this.e);
    }

    @Override // t5.c
    public final void onComplete() {
        p094q3.g.a(this.e);
        com.android.billingclient.api.v1.g(this.f4179a, this, this.d);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p094q3.g.a(this.e);
        com.android.billingclient.api.v1.i(this.f4179a, th, this, this.d);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        com.android.billingclient.api.v1.k(this.f4179a, obj, this, this.d);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.c, this.b, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.c, this.b, j6);
    }
}
