package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0869g0 extends AtomicReference implements Runnable, p011b3.c {
    private static final long serialVersionUID = 6812032969491025141L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5191a;
    public final long b;
    public final C0874h0 c;
    public final AtomicBoolean d = new AtomicBoolean();

    public RunnableC0869g0(Object obj, long j6, C0874h0 c0874h0) {
        this.f5191a = obj;
        this.b = j6;
        this.c = c0874h0;
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
        if (this.d.compareAndSet(false, true)) {
            C0874h0 c0874h0 = this.c;
            long j6 = this.b;
            Object obj = this.f5191a;
            if (j6 == c0874h0.f5197g) {
                c0874h0.f5195a.onNext(obj);
                p033f3.d.a(this);
            }
        }
    }
}
