package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z2 extends p022d3.a {
    public final AbstractC0979l b;
    public final AtomicReference c;
    public final int d;
    public final W2 e;

    public Z2(W2 w6, AbstractC0979l abstractC0979l, AtomicReference atomicReference, int i5) {
        this.e = w6;
        this.b = abstractC0979l;
        this.c = atomicReference;
        this.d = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.e.subscribe(cVar);
    }

    @Override // p022d3.a
    public final void connect(p027e3.g gVar) {
        Y2 y6;
        loop0: while (true) {
            AtomicReference atomicReference = this.c;
            y6 = (Y2) atomicReference.get();
            if (y6 != null && !y6.e()) {
                break;
            }
            Y2 y7 = new Y2(atomicReference, this.d);
            do {
                if (atomicReference.compareAndSet(y6, y7)) {
                    y6 = y7;
                    break loop0;
                }
            } while (atomicReference.get() == y6);
        }
        AtomicBoolean atomicBoolean = y6.d;
        boolean z6 = false;
        if (!atomicBoolean.get() && atomicBoolean.compareAndSet(false, true)) {
            z6 = true;
        }
        try {
            gVar.accept(y6);
            if (z6) {
                this.b.subscribe((InterfaceC0984q) y6);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            throw p100r3.g.d(th);
        }
    }
}
