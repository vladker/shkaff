package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0782q2 extends AbstractC0979l {
    public final io.reactivex.N b;
    public final long c;
    public final long d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeUnit f4742g;

    public C0782q2(long j6, long j7, long j8, long j9, TimeUnit timeUnit, io.reactivex.N n6) {
        this.e = j8;
        this.f4741f = j9;
        this.f4742g = timeUnit;
        this.b = n6;
        this.c = j6;
        this.d = j7;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        RunnableC0776p2 runnableC0776p2 = new RunnableC0776p2(cVar, this.c, this.d);
        cVar.onSubscribe(runnableC0776p2);
        io.reactivex.N n6 = this.b;
        boolean z6 = n6 instanceof io.reactivex.internal.schedulers.O;
        TimeUnit timeUnit = this.f4742g;
        AtomicReference atomicReference = runnableC0776p2.d;
        if (!z6) {
            p033f3.d.f(atomicReference, n6.schedulePeriodicallyDirect(runnableC0776p2, this.e, this.f4741f, timeUnit));
            return;
        }
        io.reactivex.M mCreateWorker = n6.createWorker();
        p033f3.d.f(atomicReference, mCreateWorker);
        mCreateWorker.schedulePeriodically(runnableC0776p2, this.e, this.f4741f, timeUnit);
    }
}
