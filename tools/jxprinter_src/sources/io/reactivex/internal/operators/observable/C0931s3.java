package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.flowable.RunnableC0778p4;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0931s3 extends AbstractC0838a {
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final io.reactivex.G e;

    public C0931s3(io.reactivex.B b, long j6, TimeUnit timeUnit, io.reactivex.N n6, io.reactivex.G g6) {
        super(b);
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = g6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        io.reactivex.G g6 = this.e;
        io.reactivex.G g7 = this.f5141a;
        io.reactivex.N n6 = this.d;
        if (g6 == null) {
            C0922q3 c0922q3 = new C0922q3(i5, this.b, this.c, n6.createWorker());
            i5.onSubscribe(c0922q3);
            p011b3.c cVarSchedule = c0922q3.d.schedule(new RunnableC0778p4(0L, c0922q3), c0922q3.b, c0922q3.c);
            p033f3.h hVar = c0922q3.e;
            hVar.getClass();
            p033f3.d.c(hVar, cVarSchedule);
            g7.subscribe(c0922q3);
            return;
        }
        C0917p3 c0917p3 = new C0917p3(i5, this.b, this.c, n6.createWorker(), this.e);
        i5.onSubscribe(c0917p3);
        p011b3.c cVarSchedule2 = c0917p3.d.schedule(new RunnableC0778p4(0L, c0917p3), c0917p3.b, c0917p3.c);
        p033f3.h hVar2 = c0917p3.e;
        hVar2.getClass();
        p033f3.d.c(hVar2, cVarSchedule2);
        g7.subscribe(c0917p3);
    }
}
