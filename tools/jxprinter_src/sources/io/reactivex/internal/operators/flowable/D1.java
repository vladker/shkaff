package io.reactivex.internal.operators.flowable;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D1 extends C1 {
    private static final long serialVersionUID = -6022804456014692607L;
    public final p043h3.a d;

    public D1(p043h3.a aVar, Iterator it) {
        super(it);
        this.d = aVar;
    }

    @Override // io.reactivex.internal.operators.flowable.C1
    public final void a() {
        Iterator it = this.f4198a;
        p043h3.a aVar = this.d;
        while (!this.b) {
            try {
                Object next = it.next();
                if (this.b) {
                    return;
                }
                if (next == null) {
                    aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                }
                aVar.h(next);
                if (this.b) {
                    return;
                }
                try {
                    if (!it.hasNext()) {
                        if (this.b) {
                            return;
                        }
                        aVar.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    aVar.onError(th);
                    return;
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                aVar.onError(th2);
                return;
            }
        }
    }

    @Override // io.reactivex.internal.operators.flowable.C1
    public final void e(long j6) {
        Iterator it = this.f4198a;
        p043h3.a aVar = this.d;
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
                            aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                            return;
                        }
                        boolean zH = aVar.h(next);
                        if (this.b) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (this.b) {
                                    return;
                                }
                                aVar.onComplete();
                                return;
                            } else if (zH) {
                                j7++;
                            }
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            aVar.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        aVar.onError(th2);
                        return;
                    }
                }
            }
            j6 = addAndGet(-j7);
        } while (j6 != 0);
    }
}
