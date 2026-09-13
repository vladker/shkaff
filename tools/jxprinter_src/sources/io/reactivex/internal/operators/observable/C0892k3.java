package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0892k3 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5227a;
    public final TimeUnit b;
    public final io.reactivex.N c;
    public long d;
    public p011b3.c e;

    public C0892k3(io.reactivex.I i5, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f5227a = i5;
        this.c = n6;
        this.b = timeUnit;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5227a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5227a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        io.reactivex.N n6 = this.c;
        TimeUnit timeUnit = this.b;
        long jNow = n6.now(timeUnit);
        long j6 = this.d;
        this.d = jNow;
        this.f5227a.onNext(new io.reactivex.schedulers.k(obj, jNow - j6, timeUnit));
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.d = this.c.now(this.b);
            this.f5227a.onSubscribe(this);
        }
    }
}
