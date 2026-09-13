package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.l2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0896l2 extends AtomicReference implements InterfaceC0925r2 {
    private static final long serialVersionUID = 2346567790059478686L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0916p2 f5231a;
    public int b;

    public AbstractC0896l2() {
        C0916p2 c0916p2 = new C0916p2(null);
        this.f5231a = c0916p2;
        set(c0916p2);
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void a(Object obj) {
        C0916p2 c0916p2 = new C0916p2(b(obj));
        this.f5231a.set(c0916p2);
        this.f5231a = c0916p2;
        this.b++;
        f();
    }

    public C0916p2 c() {
        return (C0916p2) get();
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void complete() {
        C0916p2 c0916p2 = new C0916p2(b(p100r3.n.f7968a));
        this.f5231a.set(c0916p2);
        this.f5231a = c0916p2;
        this.b++;
        g();
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void e(C0911o2 c0911o2) {
        if (c0911o2.getAndIncrement() != 0) {
            return;
        }
        int iAddAndGet = 1;
        do {
            C0916p2 c0916p2C = (C0916p2) c0911o2.c;
            if (c0916p2C == null) {
                c0916p2C = c();
                c0911o2.c = c0916p2C;
            }
            while (true) {
                if (c0911o2.d) {
                    c0911o2.c = null;
                    return;
                }
                C0916p2 c0916p2 = (C0916p2) c0916p2C.get();
                if (c0916p2 != null) {
                    Object objD = d(c0916p2.f5253a);
                    io.reactivex.I i5 = c0911o2.b;
                    if (objD == p100r3.n.f7968a) {
                        i5.onComplete();
                    } else if (objD instanceof p100r3.l) {
                        i5.onError(((p100r3.l) objD).f7966a);
                    } else {
                        i5.onNext(objD);
                        c0916p2C = c0916p2;
                    }
                    c0911o2.c = null;
                    return;
                }
            }
            c0911o2.c = c0916p2C;
            iAddAndGet = c0911o2.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0925r2
    public final void error(Throwable th) {
        C0916p2 c0916p2 = new C0916p2(b(new p100r3.l(th)));
        this.f5231a.set(c0916p2);
        this.f5231a = c0916p2;
        this.b++;
        g();
    }

    public abstract void f();

    public void g() {
        C0916p2 c0916p2 = (C0916p2) get();
        if (c0916p2.f5253a != null) {
            C0916p2 c0916p3 = new C0916p2(null);
            c0916p3.lazySet(c0916p2.get());
            set(c0916p3);
        }
    }

    public Object b(Object obj) {
        return obj;
    }

    public Object d(Object obj) {
        return obj;
    }
}
