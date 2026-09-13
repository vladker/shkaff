package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.o2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0770o2 extends AbstractC0979l {
    public final io.reactivex.N b;
    public final long c;
    public final long d;
    public final TimeUnit e;

    public C0770o2(long j6, long j7, TimeUnit timeUnit, io.reactivex.N n6) {
        this.c = j6;
        this.d = j7;
        this.e = timeUnit;
        this.b = n6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        RunnableC0764n2 runnableC0764n2 = new RunnableC0764n2(cVar);
        cVar.onSubscribe(runnableC0764n2);
        io.reactivex.N n6 = this.b;
        boolean z6 = n6 instanceof io.reactivex.internal.schedulers.O;
        TimeUnit timeUnit = this.e;
        AtomicReference atomicReference = runnableC0764n2.c;
        if (!z6) {
            p033f3.d.f(atomicReference, n6.schedulePeriodicallyDirect(runnableC0764n2, this.c, this.d, timeUnit));
            return;
        }
        io.reactivex.M mCreateWorker = n6.createWorker();
        p033f3.d.f(atomicReference, mCreateWorker);
        mCreateWorker.schedulePeriodically(runnableC0764n2, this.c, this.d, timeUnit);
    }
}
