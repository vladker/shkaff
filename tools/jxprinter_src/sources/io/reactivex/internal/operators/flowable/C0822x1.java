package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.x1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0822x1 extends AbstractC0828y1 {
    private static final long serialVersionUID = 2587302975077663557L;
    public final t5.c d;

    public C0822x1(t5.c cVar, Object[] objArr) {
        super(objArr);
        this.d = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0828y1
    public final void a() {
        Object[] objArr = this.f4843a;
        int length = objArr.length;
        t5.c cVar = this.d;
        for (int i5 = this.b; i5 != length; i5++) {
            if (this.c) {
                return;
            }
            Object obj = objArr[i5];
            if (obj == null) {
                cVar.onError(new NullPointerException("array element is null"));
                return;
            }
            cVar.onNext(obj);
        }
        if (this.c) {
            return;
        }
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0828y1
    public final void e(long j6) {
        Object[] objArr = this.f4843a;
        int length = objArr.length;
        int i5 = this.b;
        t5.c cVar = this.d;
        do {
            long j7 = 0;
            while (true) {
                if (j7 == j6 || i5 == length) {
                    if (i5 == length) {
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
                    Object obj = objArr[i5];
                    if (obj == null) {
                        cVar.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        cVar.onNext(obj);
                        j7++;
                        i5++;
                    }
                }
            }
            this.b = i5;
            j6 = addAndGet(-j7);
        } while (j6 != 0);
    }
}
