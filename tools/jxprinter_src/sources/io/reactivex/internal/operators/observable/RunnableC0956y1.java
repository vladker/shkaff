package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0956y1 extends AtomicReference implements p011b3.c, Runnable {
    private static final long serialVersionUID = 346773832286157679L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5312a;
    public long b;

    public RunnableC0956y1(io.reactivex.I i5) {
        this.f5312a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p033f3.d.f3969a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() != p033f3.d.f3969a) {
            long j6 = this.b;
            this.b = 1 + j6;
            this.f5312a.onNext(Long.valueOf(j6));
        }
    }
}
