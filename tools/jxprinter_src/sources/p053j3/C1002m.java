package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.b;
import p017c3.d;
import p033f3.e;
import p039g3.A;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: j3.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1002m extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5445a;
    public final Iterable b;

    public /* synthetic */ C1002m(Iterable iterable, int i5) {
        this.f5445a = i5;
        this.b = iterable;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5445a) {
            case 0:
                try {
                    Iterator it = this.b.iterator();
                    A.b(it, "The iterator returned is null");
                    C1001l c1001l = new C1001l(interfaceC0679f, it);
                    interfaceC0679f.onSubscribe(c1001l.c);
                    c1001l.a();
                } catch (Throwable th) {
                    d.throwIfFatal(th);
                    interfaceC0679f.onSubscribe(e.f3970a);
                    interfaceC0679f.onError(th);
                    return;
                }
                break;
            case 1:
                b bVar = new b();
                interfaceC0679f.onSubscribe(bVar);
                try {
                    Iterator it2 = this.b.iterator();
                    A.b(it2, "The source iterator returned is null");
                    AtomicInteger atomicInteger = new AtomicInteger(1);
                    c cVar = new c();
                    while (!bVar.b) {
                        try {
                            if (it2.hasNext()) {
                                if (!bVar.b) {
                                    try {
                                        Object next = it2.next();
                                        A.b(next, "The iterator returned a null CompletableSource");
                                        InterfaceC0682i interfaceC0682i = (InterfaceC0682i) next;
                                        if (!bVar.b) {
                                            atomicInteger.getAndIncrement();
                                            ((AbstractC0676c) interfaceC0682i).subscribe(new C0990a(interfaceC0679f, bVar, cVar, atomicInteger));
                                        }
                                    } catch (Throwable th2) {
                                        d.throwIfFatal(th2);
                                        g.a(cVar, th2);
                                    }
                                }
                                break;
                            }
                        } catch (Throwable th3) {
                            d.throwIfFatal(th3);
                            g.a(cVar, th3);
                        }
                        if (atomicInteger.decrementAndGet() == 0) {
                            Throwable thB = g.b(cVar);
                            if (thB != null) {
                                interfaceC0679f.onError(thB);
                            } else {
                                interfaceC0679f.onComplete();
                            }
                        }
                    }
                } catch (Throwable th4) {
                    d.throwIfFatal(th4);
                    interfaceC0679f.onError(th4);
                    return;
                }
                break;
            default:
                b bVar2 = new b();
                interfaceC0679f.onSubscribe(bVar2);
                try {
                    Iterator it3 = this.b.iterator();
                    A.b(it3, "The source iterator returned is null");
                    AtomicInteger atomicInteger2 = new AtomicInteger(1);
                    E e = new E(interfaceC0679f, bVar2, atomicInteger2);
                    while (!bVar2.b) {
                        try {
                            if (!it3.hasNext()) {
                                e.onComplete();
                            } else if (!bVar2.b) {
                                try {
                                    Object next2 = it3.next();
                                    A.b(next2, "The iterator returned a null CompletableSource");
                                    InterfaceC0682i interfaceC0682i2 = (InterfaceC0682i) next2;
                                    if (!bVar2.b) {
                                        atomicInteger2.getAndIncrement();
                                        ((AbstractC0676c) interfaceC0682i2).subscribe(e);
                                    }
                                } catch (Throwable th5) {
                                    d.throwIfFatal(th5);
                                    bVar2.dispose();
                                    e.onError(th5);
                                    return;
                                }
                            }
                        } catch (Throwable th6) {
                            d.throwIfFatal(th6);
                            bVar2.dispose();
                            e.onError(th6);
                            return;
                        }
                    }
                } catch (Throwable th7) {
                    d.throwIfFatal(th7);
                    interfaceC0679f.onError(th7);
                }
                break;
        }
    }
}
