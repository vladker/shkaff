package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J4 extends p094q3.f implements InterfaceC0984q, L4 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t5.c f4300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TimeUnit f4302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final io.reactivex.M f4303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final p033f3.h f4304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference f4305n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicLong f4306o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f4307p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t5.b f4308q;

    public J4(t5.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6, t5.b bVar) {
        super(true);
        this.f4300i = cVar;
        this.f4301j = j6;
        this.f4302k = timeUnit;
        this.f4303l = m6;
        this.f4308q = bVar;
        this.f4304m = new p033f3.h();
        this.f4305n = new AtomicReference();
        this.f4306o = new AtomicLong();
    }

    @Override // io.reactivex.internal.operators.flowable.L4
    public final void b(long j6) {
        if (this.f4306o.compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p094q3.g.a(this.f4305n);
            long j7 = this.f4307p;
            if (j7 != 0) {
                d(j7);
            }
            t5.b bVar = this.f4308q;
            this.f4308q = null;
            bVar.subscribe(new I4(this.f4300i, this));
            this.f4303l.dispose();
        }
    }

    @Override // p094q3.f, t5.d
    public final void cancel() {
        super.cancel();
        this.f4303l.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4306o.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.f4304m;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f4300i.onComplete();
            this.f4303l.dispose();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.f4306o.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.f4304m;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f4300i.onError(th);
        this.f4303l.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.f4306o;
        long j6 = atomicLong.get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = j6 + 1;
            if (atomicLong.compareAndSet(j6, j7)) {
                p033f3.h hVar = this.f4304m;
                ((p011b3.c) hVar.get()).dispose();
                this.f4307p++;
                this.f4300i.onNext(obj);
                p011b3.c cVarSchedule = this.f4303l.schedule(new RunnableC0778p4(j7, (L4) this), this.f4301j, this.f4302k);
                hVar.getClass();
                p033f3.d.c(hVar, cVarSchedule);
            }
        }
    }

    @Override // p094q3.f, io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this.f4305n, dVar)) {
            e(dVar);
        }
    }
}
