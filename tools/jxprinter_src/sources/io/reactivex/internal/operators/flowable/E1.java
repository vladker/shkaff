package io.reactivex.internal.operators.flowable;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E1 extends C1 {
    private static final long serialVersionUID = -6022804456014692607L;
    public final t5.c d;

    public E1(t5.c cVar, Iterator it) {
        super(it);
        this.d = cVar;
    }

    @Override // io.reactivex.internal.operators.flowable.C1
    public final void a() {
        Iterator it = this.f4198a;
        t5.c cVar = this.d;
        while (!this.b) {
            try {
                Object next = it.next();
                if (this.b) {
                    return;
                }
                if (next == null) {
                    cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                cVar.onNext(next);
                if (this.b) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (this.b) {
                            return;
                        }
                        cVar.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                cVar.onError(th2);
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.C1
    public final void e(long j6) {
        Iterator it = this.f4198a;
        t5.c cVar = this.d;
        do {
            long j7 = 0;
            while (true) {
                if (j7 == j6) {
                    j6 = get();
                    if (j7 == j6) {
                        break;
                    }
                } else {
                    if (this.b) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        if (this.b) {
                            return;
                        }
                        if (next == null) {
                            cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        cVar.onNext(next);
                        if (this.b) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (this.b) {
                                    return;
                                }
                                cVar.onComplete();
                                return;
                            }
                            j7++;
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            cVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cVar.onError(th2);
                        return;
                    }
                }
            }
            j6 = addAndGet(-j7);
        } while (j6 != 0);
    }
}
