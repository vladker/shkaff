package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0780q0 extends AbstractC0774p0 {
    private static final long serialVersionUID = 2427151001689639875L;
    public final p083o3.d c;
    public Throwable d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f4733f;

    public C0780q0(t5.c cVar, int i5) {
        super(cVar);
        this.c = new p083o3.d(i5);
        this.f4733f = new AtomicInteger();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0
    public final void c() {
        this.e = true;
        f();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0
    public final void d() {
        f();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0
    public final void e() {
        if (this.f4733f.getAndIncrement() == 0) {
            this.c.clear();
        }
    }

    public final void f() {
        if (this.f4733f.getAndIncrement() != 0) {
            return;
        }
        t5.c cVar = this.f4725a;
        p083o3.d dVar = this.c;
        int iAddAndGet = 1;
        do {
            long j6 = get();
            long j7 = 0;
            while (j7 != j6) {
                if (this.b.e()) {
                    dVar.clear();
                    return;
                }
                boolean z6 = this.e;
                Object objPoll = dVar.poll();
                boolean z7 = objPoll == null;
                if (z6 && z7) {
                    Throwable th = this.d;
                    if (th != null) {
                        b(th);
                        return;
                    } else {
                        a();
                        return;
                    }
                }
                if (z7) {
                    break;
                }
                cVar.onNext(objPoll);
                j7++;
            }
            if (j7 == j6) {
                if (this.b.e()) {
                    dVar.clear();
                    return;
                }
                boolean z8 = this.e;
                boolean zIsEmpty = dVar.isEmpty();
                if (z8 && zIsEmpty) {
                    Throwable th2 = this.d;
                    if (th2 != null) {
                        b(th2);
                        return;
                    } else {
                        a();
                        return;
                    }
                }
            }
            if (j7 != 0) {
                p122v2.a.e(this, j7);
            }
            iAddAndGet = this.f4733f.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0, io.reactivex.InterfaceC0981n, io.reactivex.InterfaceC0978k
    public final void onNext(Object obj) {
        if (this.e || this.b.e()) {
            return;
        }
        if (obj == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.c.offer(obj);
            f();
        }
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0774p0, io.reactivex.InterfaceC0981n
    public final boolean tryOnError(Throwable th) {
        if (this.e || this.b.e()) {
            return false;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.d = th;
        this.e = true;
        f();
        return true;
    }
}
