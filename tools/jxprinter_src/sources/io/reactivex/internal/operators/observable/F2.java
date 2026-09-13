package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F2 extends H2 {
    private static final long serialVersionUID = -7139995637533111443L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f4940g;

    public F2(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        super(eVar, j6, timeUnit, n6);
        this.f4940g = new AtomicInteger(1);
    }

    @Override // io.reactivex.internal.operators.observable.H2
    public final void a() {
        Object andSet = getAndSet(null);
        p112t3.e eVar = this.f4956a;
        if (andSet != null) {
            eVar.onNext(andSet);
        }
        if (this.f4940g.decrementAndGet() == 0) {
            eVar.onComplete();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = this.f4940g;
        if (atomicInteger.incrementAndGet() == 2) {
            Object andSet = getAndSet(null);
            p112t3.e eVar = this.f4956a;
            if (andSet != null) {
                eVar.onNext(andSet);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                eVar.onComplete();
            }
        }
    }
}
