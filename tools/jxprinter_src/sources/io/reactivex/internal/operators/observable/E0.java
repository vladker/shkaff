package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E0 extends AtomicReference implements io.reactivex.I {
    private static final long serialVersionUID = -4606175640614850599L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4911a;
    public final F0 b;
    public volatile boolean c;
    public volatile p043h3.j d;
    public int e;

    public E0(F0 f1, long j6) {
        this.f4911a = j6;
        this.b = f1;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.c = true;
        this.b.c();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.b.f4930h;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        F0 f1 = this.b;
        if (!f1.c) {
            f1.b();
        }
        this.c = true;
        this.b.c();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.e != 0) {
            this.b.c();
            return;
        }
        F0 f1 = this.b;
        if (f1.get() == 0 && f1.compareAndSet(0, 1)) {
            f1.f4927a.onNext(obj);
            if (f1.decrementAndGet() == 0) {
                return;
            }
        } else {
            p043h3.j dVar = this.d;
            if (dVar == null) {
                dVar = new p083o3.d(f1.e);
                this.d = dVar;
            }
            dVar.offer(obj);
            if (f1.getAndIncrement() != 0) {
                return;
            }
        }
        f1.d();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.f(this, cVar) && (cVar instanceof p043h3.e)) {
            p043h3.e eVar = (p043h3.e) cVar;
            int iC = eVar.c(7);
            if (iC == 1) {
                this.e = iC;
                this.d = eVar;
                this.c = true;
                this.b.c();
                return;
            }
            if (iC == 2) {
                this.e = iC;
                this.d = eVar;
            }
        }
    }
}
