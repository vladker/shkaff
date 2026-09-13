package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.j3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0741j3 extends AbstractC0729h3 {
    private static final long serialVersionUID = 2587302975077663557L;
    public final t5.c d;

    public C0741j3(t5.c cVar, long j6, long j7) {
        super(j6, j7);
        this.d = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0729h3
    public final void a() {
        long j6 = this.f4654a;
        t5.c cVar = this.d;
        for (long j7 = this.b; j7 != j6; j7++) {
            if (this.c) {
                return;
            }
            cVar.onNext(Long.valueOf(j7));
        }
        if (this.c) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0729h3
    public final void e(long j6) {
        long j7 = this.f4654a;
        long j8 = this.b;
        t5.c cVar = this.d;
        do {
            long j9 = 0;
            while (true) {
                if (j9 == j6 || j8 == j7) {
                    if (j8 == j7) {
                        if (this.c) {
                            return;
                        }
                        cVar.onComplete();
                        return;
                    } else {
                        j6 = get();
                        if (j9 == j6) {
                            break;
                        }
                    }
                } else {
                    if (this.c) {
                        return;
                    }
                    cVar.onNext(Long.valueOf(j8));
                    j9++;
                    j8++;
                }
            }
            this.b = j8;
            j6 = addAndGet(-j9);
        } while (j6 != 0);
    }
}
