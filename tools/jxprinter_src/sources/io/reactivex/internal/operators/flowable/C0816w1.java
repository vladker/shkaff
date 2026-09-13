package io.reactivex.internal.operators.flowable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.w1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0816w1 extends AbstractC0828y1 {
    private static final long serialVersionUID = 2587302975077663557L;
    public final p043h3.a d;

    public C0816w1(p043h3.a aVar, Object[] objArr) {
        super(objArr);
        this.d = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0828y1
    public final void a() {
        Object[] objArr = this.f4843a;
        int length = objArr.length;
        p043h3.a aVar = this.d;
        for (int i5 = this.b; i5 != length; i5++) {
            if (this.c) {
                return;
            }
            Object obj = objArr[i5];
            if (obj == null) {
                aVar.onError(new NullPointerException("array element is null"));
                return;
            }
            aVar.h(obj);
        }
        if (this.c) {
            return;
        }
        aVar.onComplete();
    }

    @Override // io.reactivex.internal.operators.flowable.AbstractC0828y1
    public final void e(long j6) {
        Object[] objArr = this.f4843a;
        int length = objArr.length;
        int i5 = this.b;
        p043h3.a aVar = this.d;
        do {
            long j7 = 0;
            while (true) {
                if (j7 == j6 || i5 == length) {
                    if (i5 == length) {
                        if (this.c) {
                            return;
                        }
                        aVar.onComplete();
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
                        aVar.onError(new NullPointerException("array element is null"));
                        return;
                    } else {
                        if (aVar.h(obj)) {
                            j7++;
                        }
                        i5++;
                    }
                }
            }
            this.b = i5;
            j6 = addAndGet(-j7);
        } while (j6 != 0);
    }
}
