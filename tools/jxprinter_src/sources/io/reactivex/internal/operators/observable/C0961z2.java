package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0961z2 extends p106s3.a implements p033f3.g {
    public static final C0953x2 e = new C0953x2(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5333a;
    public final AtomicReference b;
    public final InterfaceC0901m2 c;
    public final C0935t2 d;

    public C0961z2(C0935t2 c0935t2, io.reactivex.B b, AtomicReference atomicReference, InterfaceC0901m2 interfaceC0901m2) {
        this.d = c0935t2;
        this.f5333a = b;
        this.b = atomicReference;
        this.c = interfaceC0901m2;
    }

    public static p106s3.a e(io.reactivex.B b, InterfaceC0901m2 interfaceC0901m2) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.plugins.a.onAssembly((p106s3.a) new C0961z2(new C0935t2(atomicReference, interfaceC0901m2), b, atomicReference, interfaceC0901m2));
    }

    public static io.reactivex.B f(p027e3.o oVar, Callable callable) {
        return io.reactivex.plugins.a.onAssembly(new C0898m(callable, oVar, 2));
    }

    @Override // p033f3.g
    public final void a(p011b3.c cVar) {
        AtomicReference atomicReference;
        C0930s2 c0930s2 = (C0930s2) cVar;
        do {
            atomicReference = this.b;
            if (atomicReference.compareAndSet(c0930s2, null)) {
                return;
            }
        } while (atomicReference.get() == c0930s2);
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.d.subscribe(i5);
    }

    @Override // p106s3.a
    public final void connect(p027e3.g gVar) {
        C0930s2 c0930s2;
        loop0: while (true) {
            AtomicReference atomicReference = this.b;
            c0930s2 = (C0930s2) atomicReference.get();
            if (c0930s2 != null && !c0930s2.e()) {
                break;
            }
            C0930s2 c0930s3 = new C0930s2(this.c.call());
            do {
                if (atomicReference.compareAndSet(c0930s2, c0930s3)) {
                    c0930s2 = c0930s3;
                    break loop0;
                }
            } while (atomicReference.get() == c0930s2);
        }
        AtomicBoolean atomicBoolean = c0930s2.d;
        boolean z6 = !atomicBoolean.get() && atomicBoolean.compareAndSet(false, true);
        try {
            gVar.accept(c0930s2);
            if (z6) {
                this.f5333a.subscribe(c0930s2);
            }
        } catch (Throwable th) {
            if (z6) {
                atomicBoolean.compareAndSet(true, false);
            }
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }
}
