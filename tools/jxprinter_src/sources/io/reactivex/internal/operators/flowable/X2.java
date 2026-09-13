package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X2 extends AtomicLong implements t5.d {
    private static final long serialVersionUID = -4453897557930727610L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4508a;
    public volatile Y2 b;
    public long c;

    public X2(t5.c cVar) {
        this.f4508a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        Y2 y6;
        if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (y6 = this.b) == null) {
            return;
        }
        y6.c(this);
        y6.b();
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.b(this, j6);
            Y2 y6 = this.b;
            if (y6 != null) {
                y6.b();
            }
        }
    }
}
