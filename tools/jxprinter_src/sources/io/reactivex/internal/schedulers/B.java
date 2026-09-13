package io.reactivex.internal.schedulers;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.concurrent.atomic.AtomicBoolean;
import p053j3.C0990a;
import p053j3.C0991b;
import p077n3.C1268w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5335a;
    public final Object b;
    public final Object c;

    public /* synthetic */ B(Object obj, Object obj2, int i5) {
        this.f5335a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        H h6;
        int length;
        switch (this.f5335a) {
            case 0:
                G g6 = (G) this.b;
                interfaceC0679f.onSubscribe(g6);
                io.reactivex.M m6 = ((C) this.c).f5336a;
                p011b3.c cVar = (p011b3.c) g6.get();
                if (cVar != I.f5340f && cVar == (h6 = I.e)) {
                    p011b3.c cVarA = g6.a(m6, interfaceC0679f);
                    if (!g6.compareAndSet(h6, cVarA)) {
                        cVarA.dispose();
                    }
                }
                break;
            case 1:
                p011b3.c cVar2 = p033f3.e.f3970a;
                InterfaceC0682i[] interfaceC0682iArr = (InterfaceC0682i[]) this.b;
                if (interfaceC0682iArr == null) {
                    interfaceC0682iArr = new InterfaceC0682i[8];
                    try {
                        length = 0;
                        for (InterfaceC0682i interfaceC0682i : (Iterable) this.c) {
                            if (interfaceC0682i == null) {
                                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                interfaceC0679f.onSubscribe(cVar2);
                                interfaceC0679f.onError(nullPointerException);
                            } else {
                                if (length == interfaceC0682iArr.length) {
                                    InterfaceC0682i[] interfaceC0682iArr2 = new InterfaceC0682i[(length >> 2) + length];
                                    System.arraycopy(interfaceC0682iArr, 0, interfaceC0682iArr2, 0, length);
                                    interfaceC0682iArr = interfaceC0682iArr2;
                                }
                                int i5 = length + 1;
                                interfaceC0682iArr[length] = interfaceC0682i;
                                length = i5;
                            }
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        interfaceC0679f.onSubscribe(cVar2);
                        interfaceC0679f.onError(th);
                        return;
                    }
                } else {
                    length = interfaceC0682iArr.length;
                }
                p011b3.b bVar = new p011b3.b();
                interfaceC0679f.onSubscribe(bVar);
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                for (int i6 = 0; i6 < length; i6++) {
                    InterfaceC0682i interfaceC0682i2 = interfaceC0682iArr[i6];
                    if (!bVar.b) {
                        if (interfaceC0682i2 == null) {
                            Throwable nullPointerException2 = new NullPointerException("One of the sources is null");
                            if (atomicBoolean.compareAndSet(false, true)) {
                                bVar.dispose();
                                interfaceC0679f.onError(nullPointerException2);
                            } else {
                                io.reactivex.plugins.a.onError(nullPointerException2);
                            }
                        } else {
                            ((AbstractC0676c) interfaceC0682i2).subscribe(new C0990a(bVar, interfaceC0679f, atomicBoolean));
                        }
                    }
                    break;
                }
                if (length == 0) {
                    interfaceC0679f.onComplete();
                }
                break;
            case 2:
                ((AbstractC0676c) this.b).subscribe(new p053j3.v(interfaceC0679f, (p027e3.a) this.c));
                break;
            case 3:
                ((AbstractC0676c) this.b).subscribe(new C0991b(this, interfaceC0679f, 1));
                break;
            case 4:
                ((AbstractC0676c) this.b).subscribe(new C0991b(this, interfaceC0679f, 2));
                break;
            case 5:
                p053j3.I i7 = new p053j3.I(interfaceC0679f, (p027e3.o) this.c);
                interfaceC0679f.onSubscribe(i7);
                ((AbstractC0676c) this.b).subscribe(i7);
                break;
            case 6:
                p059k3.K k6 = new p059k3.K(interfaceC0679f, (p027e3.o) this.c);
                interfaceC0679f.onSubscribe(k6);
                ((AbstractC0985s) this.b).subscribe(k6);
                break;
            default:
                C1268w c1268w = new C1268w(interfaceC0679f, (p027e3.o) this.c);
                interfaceC0679f.onSubscribe(c1268w);
                ((io.reactivex.O) this.b).subscribe(c1268w);
                break;
        }
    }

    public B(C c, G g6) {
        this.f5335a = 0;
        this.c = c;
        this.b = g6;
    }
}
