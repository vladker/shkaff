package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E extends AtomicInteger implements p011b3.c {
    private static final long serialVersionUID = 6770240836423125754L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4909a;
    public final F b;
    public L0.j c;
    public int d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f4910f;

    public E(io.reactivex.I i5, F f6) {
        this.f4909a = i5;
        this.b = f6;
        this.c = f6.f4920f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p011b3.c
    public final void dispose() {
        E[] eArr;
        if (this.f4910f) {
            return;
        }
        this.f4910f = true;
        AtomicReference atomicReference = this.b.d;
        while (true) {
            E[] eArr2 = (E[]) atomicReference.get();
            int length = eArr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (eArr2[i5] == this) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                eArr = F.f4918k;
            } else {
                E[] eArr3 = new E[length - 1];
                System.arraycopy(eArr2, 0, eArr3, 0, i5);
                System.arraycopy(eArr2, i5 + 1, eArr3, i5, (length - i5) - 1);
                eArr = eArr3;
            }
            while (!atomicReference.compareAndSet(eArr2, eArr)) {
                if (atomicReference.get() != eArr2) {
                }
            }
            return;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4910f;
    }
}
