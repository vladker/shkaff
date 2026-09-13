package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T1 implements io.reactivex.I, p011b3.c {
    public static final S1[] e = new S1[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final S1[] f5106f = new S1[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f5107a;
    public final AtomicReference d = new AtomicReference();
    public final AtomicReference b = new AtomicReference(e);
    public final AtomicBoolean c = new AtomicBoolean();

    public T1(AtomicReference atomicReference) {
        this.f5107a = atomicReference;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(S1 s6) {
        S1[] s1Arr;
        while (true) {
            AtomicReference atomicReference = this.b;
            S1[] s1Arr2 = (S1[]) atomicReference.get();
            int length = s1Arr2.length;
            if (length == 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    i5 = -1;
                    break;
                } else if (s1Arr2[i5].equals(s6)) {
                    break;
                } else {
                    i5++;
                }
            }
            if (i5 < 0) {
                return;
            }
            if (length == 1) {
                s1Arr = e;
            } else {
                S1[] s1Arr3 = new S1[length - 1];
                System.arraycopy(s1Arr2, 0, s1Arr3, 0, i5);
                System.arraycopy(s1Arr2, i5 + 1, s1Arr3, i5, (length - i5) - 1);
                s1Arr = s1Arr3;
            }
            while (!atomicReference.compareAndSet(s1Arr2, s1Arr)) {
                if (atomicReference.get() != s1Arr2) {
                }
            }
            return;
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2 = this.b;
        S1[] s1Arr = f5106f;
        if (((S1[]) atomicReference2.getAndSet(s1Arr)) != s1Arr) {
            do {
                atomicReference = this.f5107a;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            p033f3.d.a(this.d);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.get() == f5106f;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f5107a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        for (S1 s6 : (S1[]) this.b.getAndSet(f5106f)) {
            s6.f5102a.onComplete();
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        AtomicReference atomicReference;
        do {
            atomicReference = this.f5107a;
            if (atomicReference.compareAndSet(this, null)) {
                break;
            }
        } while (atomicReference.get() == this);
        S1[] s1Arr = (S1[]) this.b.getAndSet(f5106f);
        if (s1Arr.length == 0) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        for (S1 s6 : s1Arr) {
            s6.f5102a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        for (S1 s6 : (S1[]) this.b.get()) {
            s6.f5102a.onNext(obj);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.d, cVar);
    }
}
