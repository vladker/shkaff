package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0888k implements p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5219a;
    public final C0893l[] b;
    public final AtomicInteger c = new AtomicInteger();

    public C0888k(io.reactivex.I i5, int i6) {
        this.f5219a = i5;
        this.b = new C0893l[i6];
    }

    public final boolean a(int i5) {
        AtomicInteger atomicInteger = this.c;
        int i6 = atomicInteger.get();
        int i7 = 0;
        if (i6 != 0) {
            return i6 == i5;
        }
        if (!atomicInteger.compareAndSet(0, i5)) {
            return false;
        }
        C0893l[] c0893lArr = this.b;
        int length = c0893lArr.length;
        while (i7 < length) {
            int i8 = i7 + 1;
            if (i8 != i5) {
                C0893l c0893l = c0893lArr[i7];
                c0893l.getClass();
                p033f3.d.a(c0893l);
            }
            i7 = i8;
        }
        return true;
    }

    @Override // p011b3.c
    public final void dispose() {
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() != -1) {
            atomicInteger.lazySet(-1);
            for (C0893l c0893l : this.b) {
                c0893l.getClass();
                p033f3.d.a(c0893l);
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == -1;
    }
}
