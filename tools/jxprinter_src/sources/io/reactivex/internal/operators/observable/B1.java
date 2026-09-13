package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B1 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.N f4874a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeUnit f4875f;

    public B1(long j6, long j7, long j8, long j9, TimeUnit timeUnit, io.reactivex.N n6) {
        this.d = j8;
        this.e = j9;
        this.f4875f = timeUnit;
        this.f4874a = n6;
        this.b = j6;
        this.c = j7;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        A1 a6 = new A1(i5, this.b, this.c);
        i5.onSubscribe(a6);
        io.reactivex.N n6 = this.f4874a;
        boolean z6 = n6 instanceof io.reactivex.internal.schedulers.O;
        TimeUnit timeUnit = this.f4875f;
        if (!z6) {
            p033f3.d.f(a6, n6.schedulePeriodicallyDirect(a6, this.d, this.e, timeUnit));
            return;
        }
        io.reactivex.M mCreateWorker = n6.createWorker();
        p033f3.d.f(a6, mCreateWorker);
        mCreateWorker.schedulePeriodically(a6, this.d, this.e, timeUnit);
    }
}
