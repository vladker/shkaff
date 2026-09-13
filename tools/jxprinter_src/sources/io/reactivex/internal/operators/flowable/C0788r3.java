package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.r3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0788r3 extends AbstractC0979l {
    public final p022d3.a b;
    public final int c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.reactivex.N f4758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RunnableC0777p3 f4759g;

    public C0788r3(p022d3.a aVar, int i5, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.b = aVar;
        this.c = i5;
        this.d = j6;
        this.e = timeUnit;
        this.f4758f = n6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        RunnableC0777p3 runnableC0777p3;
        boolean z6;
        p033f3.h hVar;
        synchronized (this) {
            try {
                runnableC0777p3 = this.f4759g;
                if (runnableC0777p3 == null) {
                    runnableC0777p3 = new RunnableC0777p3(this);
                    this.f4759g = runnableC0777p3;
                }
                long j6 = runnableC0777p3.c;
                if (j6 == 0 && (hVar = runnableC0777p3.b) != null) {
                    p033f3.d.a(hVar);
                }
                long j7 = j6 + 1;
                runnableC0777p3.c = j7;
                if (runnableC0777p3.d || j7 != this.c) {
                    z6 = false;
                } else {
                    z6 = true;
                    runnableC0777p3.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.b.subscribe((InterfaceC0984q) new C0783q3(cVar, this, runnableC0777p3));
        if (z6) {
            this.b.connect(runnableC0777p3);
        }
    }

    public final void g(RunnableC0777p3 runnableC0777p3) {
        synchronized (this) {
            try {
                RunnableC0777p3 runnableC0777p4 = this.f4759g;
                if (runnableC0777p4 != null && runnableC0777p4 == runnableC0777p3) {
                    this.f4759g = null;
                    p033f3.h hVar = runnableC0777p3.b;
                    if (hVar != null) {
                        p033f3.d.a(hVar);
                    }
                }
                long j6 = runnableC0777p3.c - 1;
                runnableC0777p3.c = j6;
                if (j6 == 0) {
                    t5.b bVar = this.b;
                    if (bVar instanceof p011b3.c) {
                        ((p011b3.c) bVar).dispose();
                    } else if (bVar instanceof p033f3.g) {
                        ((p033f3.g) bVar).a((p011b3.c) runnableC0777p3.get());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(RunnableC0777p3 runnableC0777p3) {
        synchronized (this) {
            try {
                if (runnableC0777p3.c == 0 && runnableC0777p3 == this.f4759g) {
                    this.f4759g = null;
                    p011b3.c cVar = (p011b3.c) runnableC0777p3.get();
                    p033f3.d.a(runnableC0777p3);
                    t5.b bVar = this.b;
                    if (bVar instanceof p011b3.c) {
                        ((p011b3.c) bVar).dispose();
                    } else if (bVar instanceof p033f3.g) {
                        if (cVar == null) {
                            runnableC0777p3.e = true;
                        } else {
                            ((p033f3.g) bVar).a(cVar);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
