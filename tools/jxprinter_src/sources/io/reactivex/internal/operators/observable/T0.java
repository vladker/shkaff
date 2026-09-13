package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0985s;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T0 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5105a;
    public final Object b;

    public /* synthetic */ T0(Object obj, int i5) {
        this.f5105a = i5;
        this.b = obj;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5105a) {
            case 0:
                Object[] objArr = (Object[]) this.b;
                S0 s6 = new S0(i5, objArr);
                i5.onSubscribe(s6);
                if (!s6.d) {
                    int length = objArr.length;
                    for (int i6 = 0; i6 < length && !s6.e; i6++) {
                        Object obj = objArr[i6];
                        if (obj == null) {
                            s6.f5101a.onError(new NullPointerException(androidx.collection.a.i(i6, "The ", "th element is null")));
                        } else {
                            s6.f5101a.onNext(obj);
                        }
                        break;
                    }
                    if (!s6.e) {
                        s6.f5101a.onComplete();
                    }
                    break;
                }
                break;
            case 1:
                p011b3.c cVar = p033f3.e.f3970a;
                try {
                    Iterator it = ((Iterable) this.b).iterator();
                    try {
                        if (it.hasNext()) {
                            W0 w6 = new W0(i5, it);
                            i5.onSubscribe(w6);
                            if (!w6.d) {
                                while (!w6.c) {
                                    try {
                                        Object next = w6.b.next();
                                        p039g3.A.b(next, "The iterator returned a null value");
                                        w6.f5124a.onNext(next);
                                        if (w6.c) {
                                            break;
                                        } else {
                                            try {
                                                if (!w6.b.hasNext()) {
                                                    if (!w6.c) {
                                                        w6.f5124a.onComplete();
                                                    }
                                                    break;
                                                }
                                            } catch (Throwable th) {
                                                p017c3.d.throwIfFatal(th);
                                                w6.f5124a.onError(th);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        p017c3.d.throwIfFatal(th2);
                                        w6.f5124a.onError(th2);
                                        return;
                                    }
                                }
                            }
                        } else {
                            i5.onSubscribe(cVar);
                            i5.onComplete();
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        i5.onSubscribe(cVar);
                        i5.onError(th3);
                        return;
                    }
                } catch (Throwable th4) {
                    p017c3.d.throwIfFatal(th4);
                    i5.onSubscribe(cVar);
                    i5.onError(th4);
                    return;
                }
                break;
            case 2:
                ((t5.b) this.b).subscribe(new io.reactivex.internal.operators.flowable.V1(i5, 2));
                break;
            case 3:
                ((io.reactivex.G) this.b).subscribe(i5);
                break;
            case 4:
                ((AbstractC0676c) this.b).subscribe(new p053j3.S(i5));
                break;
            case 5:
                ((AbstractC0985s) this.b).subscribe(new p059k3.F0(i5));
                break;
            default:
                ((io.reactivex.O) ((io.reactivex.V) this.b)).subscribe(new p077n3.V(i5));
                break;
        }
    }
}
