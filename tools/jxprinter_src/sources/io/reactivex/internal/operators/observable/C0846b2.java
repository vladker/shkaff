package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.b2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0846b2 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5152a;
    public final long b;

    public C0846b2(long j6, long j7) {
        this.f5152a = j6;
        this.b = j7;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        io.reactivex.I i6;
        long j6 = this.b;
        long j7 = this.f5152a;
        C0841a2 c0841a2 = new C0841a2(i5, j7, j6 + j7);
        i5.onSubscribe(c0841a2);
        if (c0841a2.d) {
            return;
        }
        long j8 = c0841a2.c;
        while (true) {
            long j9 = c0841a2.b;
            i6 = c0841a2.f5143a;
            if (j8 == j9 || c0841a2.get() != 0) {
                break;
            }
            i6.onNext(Long.valueOf(j8));
            j8++;
        }
        if (c0841a2.get() == 0) {
            c0841a2.lazySet(1);
            i6.onComplete();
        }
    }
}
