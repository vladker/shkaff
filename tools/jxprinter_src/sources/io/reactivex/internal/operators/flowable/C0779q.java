package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p065l3.C1151b;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0779q extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final Object c;
    public final Object d;

    public /* synthetic */ C0779q(Object obj, Object obj2, int i5) {
        this.b = i5;
        this.c = obj;
        this.d = obj2;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        int length;
        switch (this.b) {
            case 0:
                t5.b[] bVarArr = (t5.b[]) this.c;
                t5.d dVar = p094q3.d.f7843a;
                if (bVarArr == null) {
                    bVarArr = new t5.b[8];
                    try {
                        length = 0;
                        for (t5.b bVar : (Iterable) this.d) {
                            if (bVar == null) {
                                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                cVar.onSubscribe(dVar);
                                cVar.onError(nullPointerException);
                            } else {
                                if (length == bVarArr.length) {
                                    t5.b[] bVarArr2 = new t5.b[(length >> 2) + length];
                                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                                    bVarArr = bVarArr2;
                                }
                                int i5 = length + 1;
                                bVarArr[length] = bVar;
                                length = i5;
                            }
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        cVar.onSubscribe(dVar);
                        cVar.onError(th);
                        return;
                    }
                } else {
                    length = bVarArr.length;
                }
                if (length == 0) {
                    cVar.onSubscribe(dVar);
                    cVar.onComplete();
                    break;
                } else if (length == 1) {
                    bVarArr[0].subscribe(cVar);
                    break;
                } else {
                    C0767o c0767o = new C0767o(cVar, length);
                    C0773p[] c0773pArr = c0767o.b;
                    int length2 = c0773pArr.length;
                    int i6 = 0;
                    while (true) {
                        t5.c cVar2 = c0767o.f4715a;
                        if (i6 < length2) {
                            int i7 = i6 + 1;
                            c0773pArr[i6] = new C0773p(c0767o, i7, cVar2);
                            i6 = i7;
                        } else {
                            AtomicInteger atomicInteger = c0767o.c;
                            atomicInteger.lazySet(0);
                            cVar2.onSubscribe(c0767o);
                            for (int i8 = 0; i8 < length2 && atomicInteger.get() == 0; i8++) {
                                bVarArr[i8].subscribe(c0773pArr[i8]);
                            }
                        }
                    }
                }
                break;
            case 1:
                I0 i1 = new I0((AbstractC0979l) this.c, cVar);
                cVar.onSubscribe(i1);
                ((t5.b) this.d).subscribe(i1.c);
                break;
            case 2:
                ((t5.b) this.c).subscribe(new A2(cVar, (C0686a2) this.d));
                break;
            case 3:
                t5.d dVar2 = p094q3.d.f7843a;
                try {
                    Object objCall = ((Callable) this.c).call();
                    p039g3.A.b(objCall, "The connectableFactory returned null");
                    p022d3.a aVar = (p022d3.a) objCall;
                    try {
                        Object objApply = ((p027e3.o) this.d).apply(aVar);
                        p039g3.A.b(objApply, "The selector returned a null Publisher");
                        t5.b bVar2 = (t5.b) objApply;
                        p088p3.n nVar = new p088p3.n(cVar);
                        bVar2.subscribe(nVar);
                        aVar.connect(new A3(nVar));
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cVar.onSubscribe(dVar2);
                        cVar.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    cVar.onSubscribe(dVar2);
                    cVar.onError(th3);
                    return;
                }
                break;
            case 4:
                t5.d dVar3 = p094q3.d.f7843a;
                try {
                    Object objApply2 = ((p027e3.o) this.d).apply(this.c);
                    p039g3.A.b(objApply2, "The mapper returned a null Publisher");
                    t5.b bVar3 = (t5.b) objApply2;
                    if (!(bVar3 instanceof Callable)) {
                        bVar3.subscribe(cVar);
                    } else {
                        try {
                            Object objCall2 = ((Callable) bVar3).call();
                            if (objCall2 == null) {
                                cVar.onSubscribe(dVar3);
                                cVar.onComplete();
                            } else {
                                cVar.onSubscribe(new p094q3.e(objCall2, cVar));
                            }
                        } catch (Throwable th4) {
                            p017c3.d.throwIfFatal(th4);
                            cVar.onSubscribe(dVar3);
                            cVar.onError(th4);
                            return;
                        }
                    }
                } catch (Throwable th5) {
                    cVar.onSubscribe(dVar3);
                    cVar.onError(th5);
                    return;
                }
                break;
            case 5:
                ((AbstractC0676c) this.c).subscribe(new C1151b(cVar, (t5.b) this.d));
                break;
            case 6:
                p117u3.b bVar4 = (p117u3.b) this.c;
                p071m3.v vVar = new p071m3.v(cVar, bVar4.a(), (p027e3.c) this.d);
                cVar.onSubscribe(vVar);
                bVar4.subscribe(vVar.c);
                break;
            default:
                p117u3.b bVar5 = (p117u3.b) this.c;
                p071m3.C c = new p071m3.C(cVar, bVar5.a(), (Comparator) this.d);
                cVar.onSubscribe(c);
                bVar5.subscribe(c.b);
                break;
        }
    }
}
