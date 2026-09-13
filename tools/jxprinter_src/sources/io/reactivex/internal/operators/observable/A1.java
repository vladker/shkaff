package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A1 extends AtomicReference implements p011b3.c, Runnable {
    private static final long serialVersionUID = 1891866368734007884L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4863a;
    public final long b;
    public long c;

    public A1(io.reactivex.I i5, long j6, long j7) {
        this.f4863a = i5;
        this.c = j6;
        this.b = j7;
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
        if (e()) {
            return;
        }
        long j6 = this.c;
        Long lValueOf = Long.valueOf(j6);
        io.reactivex.I i5 = this.f4863a;
        i5.onNext(lValueOf);
        if (j6 != this.b) {
            this.c = j6 + 1;
        } else {
            p033f3.d.a(this);
            i5.onComplete();
        }
    }
}
