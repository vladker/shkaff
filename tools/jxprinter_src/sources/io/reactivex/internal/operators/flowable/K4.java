package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K4 extends AtomicLong implements InterfaceC0984q, t5.d, L4 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4329a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final p033f3.h e = new p033f3.h();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f4330f = new AtomicReference();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f4331g = new AtomicLong();

    public K4(t5.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f4329a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
    }

    @Override // io.reactivex.internal.operators.flowable.L4
    public final void b(long j6) {
        if (compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p094q3.g.a(this.f4330f);
            this.f4329a.onError(new TimeoutException(p100r3.g.c(this.b, this.c)));
            this.d.dispose();
        }
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.f4330f);
        this.d.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.e;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f4329a.onComplete();
            this.d.dispose();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.e;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f4329a.onError(th);
        this.d.dispose();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = 1 + j6;
            if (compareAndSet(j6, j7)) {
                p033f3.h hVar = this.e;
                ((p011b3.c) hVar.get()).dispose();
                this.f4329a.onNext(obj);
                p011b3.c cVarSchedule = this.d.schedule(new RunnableC0778p4(j7, (L4) this), this.b, this.c);
                hVar.getClass();
                p033f3.d.c(hVar, cVarSchedule);
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.f4330f, this.f4331g, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.f4330f, this.f4331g, j6);
    }
}
