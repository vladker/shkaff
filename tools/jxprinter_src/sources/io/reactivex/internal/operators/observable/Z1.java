package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z1 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5140a;
    public final long b;

    public Z1(int i5, int i6) {
        this.f5140a = i5;
        this.b = ((long) i5) + ((long) i6);
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        io.reactivex.I i6;
        Y1 y6 = new Y1(i5, this.f5140a, this.b);
        i5.onSubscribe(y6);
        if (y6.d) {
            return;
        }
        long j6 = y6.c;
        while (true) {
            long j7 = y6.b;
            i6 = y6.f5133a;
            if (j6 == j7 || y6.get() != 0) {
                break;
            }
            i6.onNext(Integer.valueOf((int) j6));
            j6++;
        }
        if (y6.get() == 0) {
            y6.lazySet(1);
            i6.onComplete();
        }
    }
}
