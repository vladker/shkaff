package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0866f2 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p106s3.a f5186a;
    public final int b;
    public final long c;
    public final TimeUnit d;
    public final io.reactivex.N e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RunnableC0856d2 f5187f;

    public C0866f2(p106s3.a aVar, int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f5186a = aVar;
        this.b = i5;
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        RunnableC0856d2 runnableC0856d2;
        boolean z6;
        p033f3.h hVar;
        synchronized (this) {
            try {
                runnableC0856d2 = this.f5187f;
                if (runnableC0856d2 == null) {
                    runnableC0856d2 = new RunnableC0856d2(this);
                    this.f5187f = runnableC0856d2;
                }
                long j6 = runnableC0856d2.c;
                if (j6 == 0 && (hVar = runnableC0856d2.b) != null) {
                    p033f3.d.a(hVar);
                }
                long j7 = j6 + 1;
                runnableC0856d2.c = j7;
                if (runnableC0856d2.d || j7 != this.b) {
                    z6 = false;
                } else {
                    z6 = true;
                    runnableC0856d2.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5186a.subscribe(new C0861e2(i5, this, runnableC0856d2));
        if (z6) {
            this.f5186a.connect(runnableC0856d2);
        }
    }

    public final void e(RunnableC0856d2 runnableC0856d2) {
        synchronized (this) {
            try {
                RunnableC0856d2 runnableC0856d3 = this.f5187f;
                if (runnableC0856d3 != null && runnableC0856d3 == runnableC0856d2) {
                    this.f5187f = null;
                    p033f3.h hVar = runnableC0856d2.b;
                    if (hVar != null) {
                        p033f3.d.a(hVar);
                    }
                }
                long j6 = runnableC0856d2.c - 1;
                runnableC0856d2.c = j6;
                if (j6 == 0) {
                    io.reactivex.G g6 = this.f5186a;
                    if (g6 instanceof p011b3.c) {
                        ((p011b3.c) g6).dispose();
                    } else if (g6 instanceof p033f3.g) {
                        ((p033f3.g) g6).a((p011b3.c) runnableC0856d2.get());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(RunnableC0856d2 runnableC0856d2) {
        synchronized (this) {
            try {
                if (runnableC0856d2.c == 0 && runnableC0856d2 == this.f5187f) {
                    this.f5187f = null;
                    p011b3.c cVar = (p011b3.c) runnableC0856d2.get();
                    p033f3.d.a(runnableC0856d2);
                    io.reactivex.G g6 = this.f5186a;
                    if (g6 instanceof p011b3.c) {
                        ((p011b3.c) g6).dispose();
                    } else if (g6 instanceof p033f3.g) {
                        if (cVar == null) {
                            runnableC0856d2.e = true;
                        } else {
                            ((p033f3.g) g6).a(cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
