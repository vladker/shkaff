package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.f3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0717f3 extends AbstractC0705d3 {
    private static final long serialVersionUID = 2587302975077663557L;
    public final t5.c d;

    public C0717f3(t5.c cVar, int i5, int i6) {
        super(i5, i6);
        this.d = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0705d3
    public final void a() {
        int i5 = this.f4593a;
        t5.c cVar = this.d;
        for (int i6 = this.b; i6 != i5; i6++) {
            if (this.c) {
                return;
            }
            cVar.onNext(Integer.valueOf(i6));
        }
        if (this.c) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0705d3
    public final void e(long j6) {
        int i5 = this.f4593a;
        int i6 = this.b;
        t5.c cVar = this.d;
        do {
            long j7 = 0;
            while (true) {
                if (j7 == j6 || i6 == i5) {
                    if (i6 == i5) {
                        if (this.c) {
                            return;
                        }
                        cVar.onComplete();
                        return;
                    } else {
                        j6 = get();
                        if (j7 == j6) {
                            break;
                        }
                    }
                } else {
                    if (this.c) {
                        return;
                    }
                    cVar.onNext(Integer.valueOf(i6));
                    j7++;
                    i6++;
                }
            }
            this.b = i6;
            j6 = addAndGet(-j7);
        } while (j6 != 0);
    }
}
