package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D4 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4212a;
    public final TimeUnit b;
    public final io.reactivex.N c;
    public t5.d d;
    public long e;

    public D4(t5.c cVar, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f4212a = cVar;
        this.c = n6;
        this.b = timeUnit;
    }

    @Override // t5.d
    public final void cancel() {
        this.d.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4212a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4212a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        io.reactivex.N n6 = this.c;
        TimeUnit timeUnit = this.b;
        long jNow = n6.now(timeUnit);
        long j6 = this.e;
        this.e = jNow;
        this.f4212a.onNext(new io.reactivex.schedulers.k(obj, jNow - j6, timeUnit));
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.d, dVar)) {
            this.e = this.c.now(this.b);
            this.d = dVar;
            this.f4212a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.d.request(j6);
    }
}
