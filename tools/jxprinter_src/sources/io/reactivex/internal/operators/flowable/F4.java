package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F4 extends p094q3.f implements InterfaceC0984q, G4 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t5.c f4237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p027e3.o f4238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p033f3.h f4239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference f4240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicLong f4241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t5.b f4242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f4243o;

    public F4(p027e3.o oVar, t5.b bVar, t5.c cVar) {
        super(true);
        this.f4237i = cVar;
        this.f4238j = oVar;
        this.f4239k = new p033f3.h();
        this.f4240l = new AtomicReference();
        this.f4242n = bVar;
        this.f4241m = new AtomicLong();
    }

    @Override // io.reactivex.internal.operators.flowable.G4
    public final void a(long j6, Throwable th) {
        if (!this.f4241m.compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            p094q3.g.a(this.f4240l);
            this.f4237i.onError(th);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.L4
    public final void b(long j6) {
        if (this.f4241m.compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p094q3.g.a(this.f4240l);
            t5.b bVar = this.f4242n;
            this.f4242n = null;
            long j7 = this.f4243o;
            if (j7 != 0) {
                d(j7);
            }
            bVar.subscribe(new I4(this.f4237i, this));
        }
    }

    @Override // p094q3.f, t5.d
    public final void cancel() {
        super.cancel();
        p033f3.h hVar = this.f4239k;
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4241m.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.f4239k;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f4237i.onComplete();
            hVar.getClass();
            p033f3.d.a(hVar);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4241m.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.f4239k;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f4237i.onError(th);
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f4241m;
        long j6 = atomicLong.get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = j6 + 1;
            if (atomicLong.compareAndSet(j6, j7)) {
                p033f3.h hVar = this.f4239k;
                p011b3.c cVar = (p011b3.c) hVar.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                this.f4243o++;
                t5.c cVar2 = this.f4237i;
                cVar2.onNext(obj);
                try {
                    Object objApply = this.f4238j.apply(obj);
                    p039g3.A.b(objApply, "The itemTimeoutIndicator returned a null Publisher.");
                    t5.b bVar = (t5.b) objApply;
                    E4 e6 = new E4(j7, this);
                    if (p033f3.d.c(hVar, e6)) {
                        bVar.subscribe(e6);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    ((t5.d) this.f4240l.get()).cancel();
                    atomicLong.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                    cVar2.onError(th);
                }
            }
        }
    }

    @Override // p094q3.f, io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.f4240l, dVar)) {
            e(dVar);
        }
    }
}
