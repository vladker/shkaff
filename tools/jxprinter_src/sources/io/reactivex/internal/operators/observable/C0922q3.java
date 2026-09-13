package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.internal.operators.flowable.RunnableC0778p4;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0922q3 extends AtomicLong implements io.reactivex.I, p011b3.c, InterfaceC0926r3 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5262a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final p033f3.h e = new p033f3.h();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5263f = new AtomicReference();

    public C0922q3(io.reactivex.I i5, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f5262a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0926r3
    public final void b(long j6) {
        if (compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p033f3.d.a(this.f5263f);
            this.f5262a.onError(new TimeoutException(p100r3.g.c(this.b, this.c)));
            this.d.dispose();
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.f5263f);
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.f5263f.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.e;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f5262a.onComplete();
            this.d.dispose();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.e;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f5262a.onError(th);
        this.d.dispose();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        long j6 = get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = 1 + j6;
            if (compareAndSet(j6, j7)) {
                p033f3.h hVar = this.e;
                ((p011b3.c) hVar.get()).dispose();
                this.f5262a.onNext(obj);
                p011b3.c cVarSchedule = this.d.schedule(new RunnableC0778p4(j7, this), this.b, this.c);
                hVar.getClass();
                p033f3.d.c(hVar, cVarSchedule);
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.f5263f, cVar);
    }
}
