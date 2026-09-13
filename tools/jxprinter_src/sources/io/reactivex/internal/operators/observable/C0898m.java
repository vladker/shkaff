package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p065l3.C1150a;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0898m extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5233a;
    public final Object b;
    public final Object c;

    public /* synthetic */ C0898m(Object obj, Object obj2, int i5) {
        this.f5233a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        int length;
        switch (this.f5233a) {
            case 0:
                io.reactivex.G[] gArr = (io.reactivex.G[]) this.b;
                p011b3.c cVar = p033f3.e.f3970a;
                if (gArr == null) {
                    gArr = new io.reactivex.B[8];
                    try {
                        length = 0;
                        for (io.reactivex.G g6 : (Iterable) this.c) {
                            if (g6 == null) {
                                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                i5.onSubscribe(cVar);
                                i5.onError(nullPointerException);
                            } else {
                                if (length == gArr.length) {
                                    io.reactivex.G[] gArr2 = new io.reactivex.G[(length >> 2) + length];
                                    System.arraycopy(gArr, 0, gArr2, 0, length);
                                    gArr = gArr2;
                                }
                                int i6 = length + 1;
                                gArr[length] = g6;
                                length = i6;
                            }
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        i5.onSubscribe(cVar);
                        i5.onError(th);
                        return;
                    }
                } else {
                    length = gArr.length;
                }
                if (length == 0) {
                    i5.onSubscribe(cVar);
                    i5.onComplete();
                    break;
                } else if (length == 1) {
                    gArr[0].subscribe(i5);
                    break;
                } else {
                    C0888k c0888k = new C0888k(i5, length);
                    C0893l[] c0893lArr = c0888k.b;
                    int length2 = c0893lArr.length;
                    int i7 = 0;
                    while (true) {
                        io.reactivex.I i8 = c0888k.f5219a;
                        if (i7 < length2) {
                            int i9 = i7 + 1;
                            c0893lArr[i7] = new C0893l(c0888k, i9, i8);
                            i7 = i9;
                        } else {
                            AtomicInteger atomicInteger = c0888k.c;
                            atomicInteger.lazySet(0);
                            i8.onSubscribe(c0888k);
                            for (int i10 = 0; i10 < length2 && atomicInteger.get() == 0; i10++) {
                                gArr[i10].subscribe(c0893lArr[i10]);
                            }
                        }
                    }
                }
                break;
            case 1:
                p033f3.h hVar = new p033f3.h();
                i5.onSubscribe(hVar);
                ((io.reactivex.G) this.c).subscribe(new C0904n0(this, hVar, i5));
                break;
            case 2:
                try {
                    Object objCall = ((Callable) this.b).call();
                    p039g3.A.b(objCall, "The connectableFactory returned a null ConnectableObservable");
                    p106s3.a aVar = (p106s3.a) objCall;
                    Object objApply = ((p027e3.o) this.c).apply(aVar);
                    p039g3.A.b(objApply, "The selector returned a null ObservableSource");
                    io.reactivex.G g7 = (io.reactivex.G) objApply;
                    U3 u6 = new U3(i5);
                    g7.subscribe(u6);
                    aVar.connect(new C0906n2(u6));
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onSubscribe(p033f3.e.f3970a);
                    i5.onError(th2);
                    return;
                }
                break;
            case 3:
                p011b3.c cVar2 = p033f3.e.f3970a;
                try {
                    Object objApply2 = ((p027e3.o) this.c).apply(this.b);
                    p039g3.A.b(objApply2, "The mapper returned a null ObservableSource");
                    io.reactivex.G g8 = (io.reactivex.G) objApply2;
                    if (!(g8 instanceof Callable)) {
                        g8.subscribe(i5);
                    } else {
                        try {
                            Object objCall2 = ((Callable) g8).call();
                            if (objCall2 == null) {
                                i5.onSubscribe(cVar2);
                                i5.onComplete();
                            } else {
                                L2 l6 = new L2(i5, objCall2);
                                i5.onSubscribe(l6);
                                l6.run();
                            }
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            i5.onSubscribe(cVar2);
                            i5.onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    i5.onSubscribe(cVar2);
                    i5.onError(th4);
                    return;
                }
                break;
            default:
                C1150a c1150a = new C1150a(i5, (io.reactivex.G) this.c);
                i5.onSubscribe(c1150a);
                ((AbstractC0676c) this.b).subscribe(c1150a);
                break;
        }
    }
}
