package io.reactivex.internal.operators.flowable;

import A3.AbstractC0157z;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.p2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0776p2 extends AtomicLong implements t5.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4727a;
    public final long b;
    public long c;
    public final AtomicReference d = new AtomicReference();

    public RunnableC0776p2(t5.c cVar, long j6, long j7) {
        this.f4727a = cVar;
        this.c = j6;
        this.b = j7;
    }

    @Override // t5.d
    public final void cancel() {
        p033f3.d.a(this.d);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.d;
        Object obj = atomicReference.get();
        p033f3.d dVar = p033f3.d.f3969a;
        if (obj != dVar) {
            long j6 = get();
            t5.c cVar = this.f4727a;
            if (j6 == 0) {
                cVar.onError(new p017c3.e(AbstractC0157z.r(new StringBuilder("Can't deliver value "), this.c, " due to lack of requests")));
                p033f3.d.a(atomicReference);
                return;
            }
            long j7 = this.c;
            cVar.onNext(Long.valueOf(j7));
            if (j7 == this.b) {
                if (atomicReference.get() != dVar) {
                    cVar.onComplete();
                }
                p033f3.d.a(atomicReference);
            } else {
                this.c = j7 + 1;
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    decrementAndGet();
                }
            }
        }
    }
}
