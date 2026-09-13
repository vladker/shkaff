package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0767o implements t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4715a;
    public final C0773p[] b;
    public final AtomicInteger c = new AtomicInteger();

    public C0767o(t5.c cVar, int i5) {
        this.f4715a = cVar;
        this.b = new C0773p[i5];
    }

    public final boolean a(int i5) {
        AtomicInteger atomicInteger = this.c;
        int i6 = 0;
        if (atomicInteger.get() != 0 || !atomicInteger.compareAndSet(0, i5)) {
            return false;
        }
        C0773p[] c0773pArr = this.b;
        int length = c0773pArr.length;
        while (i6 < length) {
            int i7 = i6 + 1;
            if (i7 != i5) {
                C0773p c0773p = c0773pArr[i6];
                c0773p.getClass();
                p094q3.g.a(c0773p);
            }
            i6 = i7;
        }
        return true;
    }

    @Override // t5.d
    public final void cancel() {
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger.get() != -1) {
            atomicInteger.lazySet(-1);
            for (C0773p c0773p : this.b) {
                c0773p.getClass();
                p094q3.g.a(c0773p);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            int i5 = this.c.get();
            C0773p[] c0773pArr = this.b;
            if (i5 > 0) {
                c0773pArr[i5 - 1].request(j6);
                return;
            }
            if (i5 == 0) {
                for (C0773p c0773p : c0773pArr) {
                    c0773p.request(j6);
                }
            }
        }
    }
}
