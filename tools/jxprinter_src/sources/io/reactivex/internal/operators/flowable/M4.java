package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M4 extends AbstractC0683a {
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t5.b f4361f;

    public M4(AbstractC0979l abstractC0979l, long j6, TimeUnit timeUnit, io.reactivex.N n6, t5.b bVar) {
        super(abstractC0979l);
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
        this.f4361f = bVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        t5.b bVar = this.f4361f;
        AbstractC0979l abstractC0979l = this.b;
        io.reactivex.N n6 = this.e;
        if (bVar == null) {
            K4 k6 = new K4(cVar, this.c, this.d, n6.createWorker());
            cVar.onSubscribe(k6);
            p011b3.c cVarSchedule = k6.d.schedule(new RunnableC0778p4(0L, (L4) k6), k6.b, k6.c);
            p033f3.h hVar = k6.e;
            hVar.getClass();
            p033f3.d.c(hVar, cVarSchedule);
            abstractC0979l.subscribe((InterfaceC0984q) k6);
            return;
        }
        J4 j6 = new J4(cVar, this.c, this.d, n6.createWorker(), this.f4361f);
        cVar.onSubscribe(j6);
        p011b3.c cVarSchedule2 = j6.f4303l.schedule(new RunnableC0778p4(0L, (L4) j6), j6.f4301j, j6.f4302k);
        p033f3.h hVar2 = j6.f4304m;
        hVar2.getClass();
        p033f3.d.c(hVar2, cVarSchedule2);
        abstractC0979l.subscribe((InterfaceC0984q) j6);
    }
}
