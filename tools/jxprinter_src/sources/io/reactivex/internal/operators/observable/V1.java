package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V1 extends p106s3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.B f5121a;
    public final AtomicReference b;
    public final U1 c;

    public V1(U1 u6, io.reactivex.B b, AtomicReference atomicReference) {
        this.c = u6;
        this.f5121a = b;
        this.b = atomicReference;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        this.c.subscribe(i5);
    }

    @Override // p106s3.a
    public final void connect(p027e3.g gVar) {
        T1 t6;
        loop0: while (true) {
            AtomicReference atomicReference = this.b;
            t6 = (T1) atomicReference.get();
            if (t6 != null && !t6.e()) {
                break;
            }
            T1 t7 = new T1(atomicReference);
            do {
                if (atomicReference.compareAndSet(t6, t7)) {
                    t6 = t7;
                    break loop0;
                }
            } while (atomicReference.get() == t6);
        }
        AtomicBoolean atomicBoolean = t6.c;
        boolean z6 = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z6 = true;
        }
        try {
            gVar.accept(t6);
            if (z6) {
                this.f5121a.subscribe(t6);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }
}
