package io.reactivex.internal.operators.flowable;

import A3.AbstractC0157z;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.n2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0764n2 extends AtomicLong implements t5.d, Runnable {
    private static final long serialVersionUID = -2809475196591179431L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4713a;
    public long b;
    public final AtomicReference c = new AtomicReference();

    public RunnableC0764n2(t5.c cVar) {
        this.f4713a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        p033f3.d.a(this.c);
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.c;
        if (atomicReference.get() != p033f3.d.f3969a) {
            long j6 = get();
            t5.c cVar = this.f4713a;
            if (j6 == 0) {
                cVar.onError(new p017c3.e(AbstractC0157z.r(new StringBuilder("Can't deliver value "), this.b, " due to lack of requests")));
                p033f3.d.a(atomicReference);
            } else {
                long j7 = this.b;
                this.b = j7 + 1;
                cVar.onNext(Long.valueOf(j7));
                p122v2.a.e(this, 1L);
            }
        }
    }
}
