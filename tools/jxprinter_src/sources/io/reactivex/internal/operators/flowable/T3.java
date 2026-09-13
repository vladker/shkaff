package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T3 extends V3 {
    private static final long serialVersionUID = -7139995637533111443L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f4447h;

    public T3(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        super(cVar, j6, timeUnit, n6);
        this.f4447h = new AtomicInteger(1);
    }

    @Override // io.reactivex.internal.operators.flowable.V3
    public final void a() {
        b();
        if (this.f4447h.decrementAndGet() == 0) {
            this.f4483a.onComplete();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.V3, java.lang.Runnable
    public final void run() {
        AtomicInteger atomicInteger = this.f4447h;
        if (atomicInteger.incrementAndGet() == 2) {
            b();
            if (atomicInteger.decrementAndGet() == 0) {
                this.f4483a.onComplete();
            }
        }
    }
}
