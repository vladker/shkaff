package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U1 implements io.reactivex.G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f5117a;

    public U1(AtomicReference atomicReference) {
        this.f5117a = atomicReference;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.G
    public final void subscribe(io.reactivex.I i5) {
        T1 t6;
        S1 s6 = new S1(i5);
        i5.onSubscribe(s6);
        loop0: while (true) {
            AtomicReference atomicReference = this.f5117a;
            T1 t7 = (T1) atomicReference.get();
            if (t7 == null || t7.e()) {
                T1 t8 = new T1(atomicReference);
                while (true) {
                    if (atomicReference.compareAndSet(t7, t8)) {
                        t6 = t8;
                    } else if (atomicReference.get() != t7) {
                    }
                }
            } else {
                t6 = t7;
            }
            AtomicReference atomicReference2 = t6.b;
            while (true) {
                S1[] s1Arr = (S1[]) atomicReference2.get();
                if (s1Arr == T1.f5106f) {
                    break;
                }
                int length = s1Arr.length;
                S1[] s1Arr2 = new S1[length + 1];
                System.arraycopy(s1Arr, 0, s1Arr2, 0, length);
                s1Arr2[length] = s6;
                do {
                    if (atomicReference2.compareAndSet(s1Arr, s1Arr2)) {
                        break loop0;
                    }
                } while (atomicReference2.get() == s1Arr);
            }
        }
        if (s6.compareAndSet(null, t6)) {
            return;
        }
        t6.a(s6);
    }
}
