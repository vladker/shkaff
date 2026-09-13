package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W2 implements t5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f4490a;
    public final int b;

    public W2(AtomicReference atomicReference, int i5) {
        this.f4490a = atomicReference;
        this.b = i5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t5.b
    public final void subscribe(t5.c cVar) {
        Y2 y6;
        X2 x6 = new X2(cVar);
        cVar.onSubscribe(x6);
        loop0: while (true) {
            Y2 y7 = (Y2) this.f4490a.get();
            if (y7 == null || y7.e()) {
                Y2 y8 = new Y2(this.f4490a, this.b);
                AtomicReference atomicReference = this.f4490a;
                while (true) {
                    if (atomicReference.compareAndSet(y7, y8)) {
                        y6 = y8;
                    } else if (atomicReference.get() != y7) {
                    }
                }
            } else {
                y6 = y7;
            }
            AtomicReference atomicReference2 = y6.c;
            while (true) {
                X2[] x2Arr = (X2[]) atomicReference2.get();
                if (x2Arr == Y2.f4521j) {
                    break;
                }
                int length = x2Arr.length;
                X2[] x2Arr2 = new X2[length + 1];
                System.arraycopy(x2Arr, 0, x2Arr2, 0, length);
                x2Arr2[length] = x6;
                do {
                    if (atomicReference2.compareAndSet(x2Arr, x2Arr2)) {
                        break loop0;
                    }
                } while (atomicReference2.get() == x2Arr);
            }
        }
        if (x6.get() == Long.MIN_VALUE) {
            y6.c(x6);
        } else {
            x6.b = y6;
        }
        y6.b();
    }
}
