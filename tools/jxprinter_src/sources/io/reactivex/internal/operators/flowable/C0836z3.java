package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0836z3 extends AtomicLong implements t5.d, p011b3.c {
    private static final long serialVersionUID = -4453897557930727610L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F3 f4851a;
    public final t5.c b;
    public Serializable c;
    public final AtomicLong d = new AtomicLong();
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4852f;

    public C0836z3(F3 f6, t5.c cVar) {
        this.f4851a = f6;
        this.b = cVar;
    }

    public final void a(long j6) {
        long j7;
        long j8;
        do {
            j7 = get();
            if (j7 == Long.MIN_VALUE || j7 == LocationRequestCompat.PASSIVE_INTERVAL) {
                return;
            }
            j8 = j7 - j6;
            if (j8 < 0) {
                io.reactivex.plugins.a.onError(new IllegalStateException(androidx.collection.a.j(j8, "More produced than requested: ")));
                j8 = 0;
            }
        } while (!compareAndSet(j7, j8));
    }

    @Override // t5.d
    public final void cancel() {
        dispose();
    }

    @Override // p011b3.c
    public final void dispose() {
        if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
            F3 f6 = this.f4851a;
            f6.b(this);
            f6.a();
            this.c = null;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == Long.MIN_VALUE;
    }

    @Override // t5.d
    public final void request(long j6) {
        if (!p094q3.g.f(j6) || p122v2.a.b(this, j6) == Long.MIN_VALUE) {
            return;
        }
        p122v2.a.a(this.d, j6);
        F3 f6 = this.f4851a;
        f6.a();
        f6.f4234a.e(this);
    }
}
