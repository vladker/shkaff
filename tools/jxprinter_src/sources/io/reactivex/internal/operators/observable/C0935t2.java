package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0935t2 implements io.reactivex.G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f5283a;
    public final InterfaceC0901m2 b;

    public C0935t2(AtomicReference atomicReference, InterfaceC0901m2 interfaceC0901m2) {
        this.f5283a = atomicReference;
        this.b = interfaceC0901m2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.G
    public final void subscribe(io.reactivex.I i5) {
        C0930s2 c0930s2;
        loop0: while (true) {
            c0930s2 = (C0930s2) this.f5283a.get();
            if (c0930s2 != null) {
                break;
            }
            C0930s2 c0930s3 = new C0930s2(this.b.call());
            AtomicReference atomicReference = this.f5283a;
            do {
                if (atomicReference.compareAndSet(null, c0930s3)) {
                    c0930s2 = c0930s3;
                    break loop0;
                }
            } while (atomicReference.get() == null);
        }
        C0911o2 c0911o2 = new C0911o2(c0930s2, i5);
        i5.onSubscribe(c0911o2);
        AtomicReference atomicReference2 = c0930s2.c;
        loop2: while (true) {
            C0911o2[] c0911o2Arr = (C0911o2[]) atomicReference2.get();
            if (c0911o2Arr == C0930s2.f5279f) {
                break;
            }
            int length = c0911o2Arr.length;
            C0911o2[] c0911o2Arr2 = new C0911o2[length + 1];
            System.arraycopy(c0911o2Arr, 0, c0911o2Arr2, 0, length);
            c0911o2Arr2[length] = c0911o2;
            do {
                if (atomicReference2.compareAndSet(c0911o2Arr, c0911o2Arr2)) {
                    break loop2;
                }
            } while (atomicReference2.get() == c0911o2Arr);
        }
        if (c0911o2.d) {
            c0930s2.a(c0911o2);
        } else {
            c0930s2.f5280a.e(c0911o2);
        }
    }
}
