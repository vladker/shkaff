package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K3 extends p022d3.a implements p033f3.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p039g3.t f4328f = new p039g3.t(1);
    public final AbstractC0979l b;
    public final AtomicReference c;
    public final Callable d;
    public final E3 e;

    public K3(E3 e6, AbstractC0979l abstractC0979l, AtomicReference atomicReference, Callable callable) {
        this.e = e6;
        this.b = abstractC0979l;
        this.c = atomicReference;
        this.d = callable;
    }

    public static p022d3.a g(AbstractC0979l abstractC0979l, Callable callable) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.plugins.a.onAssembly((p022d3.a) new K3(new E3(atomicReference, callable), abstractC0979l, atomicReference, callable));
    }

    @Override // p033f3.g
    public final void a(p011b3.c cVar) {
        AtomicReference atomicReference;
        F3 f6 = (F3) cVar;
        do {
            atomicReference = this.c;
            if (atomicReference.compareAndSet(f6, null)) {
                return;
            }
        } while (atomicReference.get() == f6);
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.e.subscribe(cVar);
    }

    @Override // p022d3.a
    public final void connect(p027e3.g gVar) {
        F3 f6;
        loop0: while (true) {
            AtomicReference atomicReference = this.c;
            f6 = (F3) atomicReference.get();
            if (f6 != null && !f6.e()) {
                break;
            }
            try {
                F3 f7 = new F3((C3) this.d.call());
                do {
                    if (atomicReference.compareAndSet(f6, f7)) {
                        f6 = f7;
                        break loop0;
                    }
                } while (atomicReference.get() == f6);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                throw p100r3.g.d(th);
            }
        }
        AtomicBoolean atomicBoolean = f6.d;
        boolean z6 = !atomicBoolean.get() && atomicBoolean.compareAndSet(false, true);
        try {
            gVar.accept(f6);
            if (z6) {
                this.b.subscribe((InterfaceC0984q) f6);
            }
        } catch (Throwable th2) {
            if (z6) {
                atomicBoolean.compareAndSet(true, false);
            }
            p017c3.d.throwIfFatal(th2);
            throw p100r3.g.d(th2);
        }
    }
}
