package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import p059k3.C1012b;
import p059k3.C1019e0;
import p059k3.C1044v;
import p059k3.C1045w;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0851c2 extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5161a;
    public final Object b;
    public final Object c;

    public /* synthetic */ C0851c2(Object obj, Object obj2, int i5) {
        this.f5161a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        int length;
        switch (this.f5161a) {
            case 0:
                ((io.reactivex.B) this.b).subscribe(new G(interfaceC0988v, (p027e3.c) this.c));
                break;
            case 1:
                p011b3.c cVar = p033f3.e.f3970a;
                io.reactivex.y[] yVarArr = (io.reactivex.y[]) this.b;
                if (yVarArr == null) {
                    yVarArr = new io.reactivex.y[8];
                    try {
                        length = 0;
                        for (io.reactivex.y yVar : (Iterable) this.c) {
                            if (yVar == null) {
                                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                interfaceC0988v.onSubscribe(cVar);
                                interfaceC0988v.onError(nullPointerException);
                            } else {
                                if (length == yVarArr.length) {
                                    io.reactivex.y[] yVarArr2 = new io.reactivex.y[(length >> 2) + length];
                                    System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                                    yVarArr = yVarArr2;
                                }
                                int i5 = length + 1;
                                yVarArr[length] = yVar;
                                length = i5;
                            }
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        interfaceC0988v.onSubscribe(cVar);
                        interfaceC0988v.onError(th);
                        return;
                    }
                } else {
                    length = yVarArr.length;
                }
                p011b3.b bVar = new p011b3.b();
                interfaceC0988v.onSubscribe(bVar);
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                for (int i6 = 0; i6 < length; i6++) {
                    io.reactivex.y yVar2 = yVarArr[i6];
                    if (!bVar.b) {
                        if (yVar2 == null) {
                            bVar.dispose();
                            Throwable nullPointerException2 = new NullPointerException("One of the MaybeSources is null");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                interfaceC0988v.onError(nullPointerException2);
                            } else {
                                io.reactivex.plugins.a.onError(nullPointerException2);
                            }
                        } else {
                            ((AbstractC0985s) yVar2).subscribe(new C1012b(interfaceC0988v, bVar, atomicBoolean));
                        }
                    }
                    break;
                }
                if (length == 0) {
                    interfaceC0988v.onComplete();
                }
                break;
            case 2:
                ((AbstractC0676c) this.c).subscribe(new C1045w(interfaceC0988v, (io.reactivex.y) this.b));
                break;
            case 3:
                ((AbstractC0985s) this.b).subscribe(new C1044v(1, interfaceC0988v, this));
                break;
            case 4:
                ((io.reactivex.O) this.b).subscribe(new p059k3.G(interfaceC0988v, (p027e3.q) this.c, 0));
                break;
            case 5:
                ((AbstractC0985s) this.b).subscribe(new p059k3.U(interfaceC0988v, (p027e3.o) this.c));
                break;
            case 6:
                io.reactivex.y[] yVarArr3 = (io.reactivex.y[]) this.b;
                int length2 = yVarArr3.length;
                if (length2 == 1) {
                    ((AbstractC0985s) yVarArr3[0]).subscribe(new C1019e0(0, new p059k3.K0(this), interfaceC0988v));
                } else {
                    p059k3.L0 l6 = new p059k3.L0(length2, (p027e3.o) this.c, interfaceC0988v);
                    interfaceC0988v.onSubscribe(l6);
                    for (int i7 = 0; i7 < length2 && !l6.e(); i7++) {
                        io.reactivex.y yVar3 = yVarArr3[i7];
                        if (yVar3 == null) {
                            NullPointerException nullPointerException3 = new NullPointerException("One of the sources is null");
                            if (l6.getAndSet(0) > 0) {
                                l6.a(i7);
                                l6.f5522a.onError(nullPointerException3);
                            } else {
                                io.reactivex.plugins.a.onError(nullPointerException3);
                            }
                        } else {
                            ((AbstractC0985s) yVar3).subscribe(l6.c[i7]);
                        }
                    }
                }
                break;
            default:
                p011b3.c cVar2 = p033f3.e.f3970a;
                io.reactivex.y[] yVarArr4 = new io.reactivex.y[8];
                try {
                    int i8 = 0;
                    for (io.reactivex.y yVar4 : (Iterable) this.b) {
                        if (yVar4 == null) {
                            Throwable nullPointerException4 = new NullPointerException("One of the sources is null");
                            interfaceC0988v.onSubscribe(cVar2);
                            interfaceC0988v.onError(nullPointerException4);
                        } else {
                            if (i8 == yVarArr4.length) {
                                yVarArr4 = (io.reactivex.y[]) Arrays.copyOf(yVarArr4, (i8 >> 2) + i8);
                            }
                            int i9 = i8 + 1;
                            yVarArr4[i8] = yVar4;
                            i8 = i9;
                        }
                        break;
                    }
                    if (i8 == 0) {
                        interfaceC0988v.onSubscribe(cVar2);
                        interfaceC0988v.onComplete();
                    } else if (i8 == 1) {
                        ((AbstractC0985s) yVarArr4[0]).subscribe(new C1019e0(0, new p059k3.N0(this), interfaceC0988v));
                    } else {
                        p059k3.L0 l7 = new p059k3.L0(i8, (p027e3.o) this.c, interfaceC0988v);
                        interfaceC0988v.onSubscribe(l7);
                        for (int i10 = 0; i10 < i8 && !l7.e(); i10++) {
                            ((AbstractC0985s) yVarArr4[i10]).subscribe(l7.c[i10]);
                        }
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    interfaceC0988v.onSubscribe(cVar2);
                    interfaceC0988v.onError(th2);
                }
                break;
        }
    }
}
