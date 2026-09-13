package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0960z1 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.N f5332a;
    public final long b;
    public final long c;
    public final TimeUnit d;

    public C0960z1(long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6) {
        this.b = j6;
        this.c = j7;
        this.d = timeUnit;
        this.f5332a = n6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        RunnableC0956y1 runnableC0956y1 = new RunnableC0956y1(i5);
        i5.onSubscribe(runnableC0956y1);
        io.reactivex.N n6 = this.f5332a;
        boolean z6 = n6 instanceof io.reactivex.internal.schedulers.O;
        TimeUnit timeUnit = this.d;
        if (!z6) {
            p033f3.d.f(runnableC0956y1, n6.schedulePeriodicallyDirect(runnableC0956y1, this.b, this.c, timeUnit));
            return;
        }
        io.reactivex.M mCreateWorker = n6.createWorker();
        p033f3.d.f(runnableC0956y1, mCreateWorker);
        mCreateWorker.schedulePeriodically(runnableC0956y1, this.b, this.c, timeUnit);
    }
}
