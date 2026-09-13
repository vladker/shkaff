package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.e2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0861e2 extends AtomicBoolean implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -7419642935409022375L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5178a;
    public final C0866f2 b;
    public final RunnableC0856d2 c;
    public p011b3.c d;

    public C0861e2(io.reactivex.I i5, C0866f2 c0866f2, RunnableC0856d2 runnableC0856d2) {
        this.f5178a = i5;
        this.b = c0866f2;
        this.c = runnableC0856d2;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.dispose();
        if (compareAndSet(false, true)) {
            C0866f2 c0866f2 = this.b;
            RunnableC0856d2 runnableC0856d2 = this.c;
            synchronized (c0866f2) {
                try {
                    RunnableC0856d2 runnableC0856d3 = c0866f2.f5187f;
                    if (runnableC0856d3 != null && runnableC0856d3 == runnableC0856d2) {
                        long j6 = runnableC0856d2.c - 1;
                        runnableC0856d2.c = j6;
                        if (j6 == 0 && runnableC0856d2.d) {
                            if (c0866f2.c == 0) {
                                c0866f2.f(runnableC0856d2);
                                return;
                            }
                            p033f3.h hVar = new p033f3.h();
                            runnableC0856d2.b = hVar;
                            p033f3.d.c(hVar, c0866f2.e.scheduleDirect(runnableC0856d2, c0866f2.c, c0866f2.d));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (compareAndSet(false, true)) {
            this.b.e(this.c);
            this.f5178a.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (!compareAndSet(false, true)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.b.e(this.c);
            this.f5178a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5178a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f5178a.onSubscribe(this);
        }
    }
}
