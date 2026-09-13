package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0682i;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p077n3.C1247a;
import p077n3.C1254h;
import p077n3.C1255i;
import p077n3.C1258l;
import p077n3.C1266u;
import p077n3.C1267v;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.w2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0817w2 extends io.reactivex.O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4816a;
    public final Object b;
    public final Object c;

    public /* synthetic */ C0817w2(Object obj, Object obj2, int i5) {
        this.f4816a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(io.reactivex.S s6) {
        int length;
        switch (this.f4816a) {
            case 0:
                ((AbstractC0979l) this.c).subscribe((t5.c) new C0811v2(s6, this.b));
                break;
            case 1:
                ((io.reactivex.B) this.c).subscribe(new p048i3.l(s6, this.b));
                break;
            case 2:
                ((io.reactivex.G) this.c).subscribe(new io.reactivex.internal.operators.observable.G(s6, this.b));
                break;
            case 3:
                ((AbstractC0985s) this.c).subscribe(new p059k3.T(s6, (p027e3.o) this.b));
                break;
            case 4:
                ((AbstractC0985s) this.c).subscribe(new p059k3.s0(s6, (io.reactivex.V) this.b));
                break;
            case 5:
                io.reactivex.V[] vArr = (io.reactivex.V[]) this.c;
                if (vArr == null) {
                    vArr = new io.reactivex.V[8];
                    try {
                        length = 0;
                        for (io.reactivex.V v6 : (Iterable) this.b) {
                            if (v6 == null) {
                                p033f3.e.f(new NullPointerException("One of the sources is null"), s6);
                            } else {
                                if (length == vArr.length) {
                                    io.reactivex.V[] vArr2 = new io.reactivex.V[(length >> 2) + length];
                                    System.arraycopy(vArr, 0, vArr2, 0, length);
                                    vArr = vArr2;
                                }
                                int i5 = length + 1;
                                vArr[length] = v6;
                                length = i5;
                            }
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        p033f3.e.f(th, s6);
                        return;
                    }
                } else {
                    length = vArr.length;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                p011b3.b bVar = new p011b3.b();
                s6.onSubscribe(bVar);
                for (int i6 = 0; i6 < length; i6++) {
                    io.reactivex.V v7 = vArr[i6];
                    if (!bVar.b) {
                        if (v7 == null) {
                            bVar.dispose();
                            Throwable nullPointerException = new NullPointerException("One of the sources is null");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                s6.onError(nullPointerException);
                            } else {
                                io.reactivex.plugins.a.onError(nullPointerException);
                            }
                        } else {
                            ((io.reactivex.O) v7).subscribe(new C1247a(s6, bVar, atomicBoolean));
                        }
                    }
                    break;
                }
                break;
            case 6:
                ((AbstractC0676c) ((InterfaceC0682i) this.b)).subscribe(new C1254h(s6, (io.reactivex.V) this.c));
                break;
            case 7:
                ((io.reactivex.G) this.b).subscribe(new C1255i((io.reactivex.O) this.c, s6));
                break;
            case 8:
                ((io.reactivex.O) ((io.reactivex.V) this.b)).subscribe(new C1258l((io.reactivex.O) this.c, s6));
                break;
            case 9:
                ((io.reactivex.O) this.c).subscribe(new p048i3.t(this, s6, 6));
                break;
            case 10:
                AtomicInteger atomicInteger = new AtomicInteger();
                Object[] objArr = {null, null};
                p011b3.b bVar2 = new p011b3.b();
                s6.onSubscribe(bVar2);
                ((io.reactivex.O) ((io.reactivex.V) this.c)).subscribe(new C1266u(0, bVar2, objArr, s6, atomicInteger));
                ((io.reactivex.O) ((io.reactivex.V) this.b)).subscribe(new C1266u(1, bVar2, objArr, s6, atomicInteger));
                break;
            case 11:
                ((io.reactivex.O) ((io.reactivex.V) this.c)).subscribe(new C1267v(s6, (p027e3.o) this.b));
                break;
            case 12:
                io.reactivex.V[] vArr3 = (io.reactivex.V[]) this.c;
                int length2 = vArr3.length;
                if (length2 == 1) {
                    ((io.reactivex.O) vArr3[0]).subscribe(new p048i3.t(s6, (Object) new p077n3.Z(this), 10));
                } else {
                    p077n3.a0 a0Var = new p077n3.a0(s6, length2, (p027e3.o) this.b);
                    s6.onSubscribe(a0Var);
                    for (int i7 = 0; i7 < length2 && !a0Var.e(); i7++) {
                        io.reactivex.V v8 = vArr3[i7];
                        if (v8 == null) {
                            a0Var.a(new NullPointerException("One of the sources is null"), i7);
                        } else {
                            ((io.reactivex.O) v8).subscribe(a0Var.c[i7]);
                        }
                    }
                }
                break;
            default:
                io.reactivex.V[] vArr4 = new io.reactivex.V[8];
                try {
                    int i8 = 0;
                    for (io.reactivex.V v9 : (Iterable) this.c) {
                        if (v9 == null) {
                            p033f3.e.f(new NullPointerException("One of the sources is null"), s6);
                        } else {
                            if (i8 == vArr4.length) {
                                vArr4 = (io.reactivex.V[]) Arrays.copyOf(vArr4, (i8 >> 2) + i8);
                            }
                            int i9 = i8 + 1;
                            vArr4[i8] = v9;
                            i8 = i9;
                        }
                        break;
                    }
                    if (i8 == 0) {
                        p033f3.e.f(new NoSuchElementException(), s6);
                    } else if (i8 == 1) {
                        ((io.reactivex.O) vArr4[0]).subscribe(new p048i3.t(s6, (Object) new p077n3.c0(this), 10));
                    } else {
                        p077n3.a0 a0Var2 = new p077n3.a0(s6, i8, (p027e3.o) this.b);
                        s6.onSubscribe(a0Var2);
                        for (int i10 = 0; i10 < i8 && !a0Var2.e(); i10++) {
                            ((io.reactivex.O) vArr4[i10]).subscribe(a0Var2.c[i10]);
                        }
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    p033f3.e.f(th2, s6);
                }
                break;
        }
    }
}
