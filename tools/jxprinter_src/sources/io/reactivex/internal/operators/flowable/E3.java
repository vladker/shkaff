package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E3 implements t5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f4216a;
    public final Callable b;

    public E3(AtomicReference atomicReference, Callable callable) {
        this.f4216a = atomicReference;
        this.b = callable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t5.b
    public final void subscribe(t5.c cVar) {
        F3 f6;
        loop0: while (true) {
            AtomicReference atomicReference = this.f4216a;
            f6 = (F3) atomicReference.get();
            if (f6 != null) {
                break;
            }
            try {
                F3 f7 = new F3((C3) this.b.call());
                do {
                    if (atomicReference.compareAndSet(null, f7)) {
                        f6 = f7;
                        break loop0;
                    }
                } while (atomicReference.get() == null);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                p094q3.d.e(th, cVar);
                return;
            }
        }
        C0836z3 c0836z3 = new C0836z3(f6, cVar);
        cVar.onSubscribe(c0836z3);
        AtomicReference atomicReference2 = f6.c;
        loop2: while (true) {
            C0836z3[] c0836z3Arr = (C0836z3[]) atomicReference2.get();
            if (c0836z3Arr == F3.f4233i) {
                break;
            }
            int length = c0836z3Arr.length;
            C0836z3[] c0836z3Arr2 = new C0836z3[length + 1];
            System.arraycopy(c0836z3Arr, 0, c0836z3Arr2, 0, length);
            c0836z3Arr2[length] = c0836z3;
            do {
                if (atomicReference2.compareAndSet(c0836z3Arr, c0836z3Arr2)) {
                    break loop2;
                }
            } while (atomicReference2.get() == c0836z3Arr);
        }
        if (c0836z3.e()) {
            f6.b(c0836z3);
        } else {
            f6.a();
            f6.f4234a.e(c0836z3);
        }
    }
}
