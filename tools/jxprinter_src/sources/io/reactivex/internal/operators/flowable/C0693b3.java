package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.b3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0693b3 extends AtomicLong implements t5.d {
    private static final long serialVersionUID = 8664815189257569791L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4571a;
    public final C0687a3 b;
    public long c;

    public C0693b3(t5.c cVar, C0687a3 c0687a3) {
        this.f4571a = cVar;
        this.b = c0687a3;
    }

    @Override // t5.d
    public final void cancel() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            C0687a3 c0687a3 = this.b;
            c0687a3.k(this);
            c0687a3.i();
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.b(this, j6);
            this.b.i();
        }
    }
}
