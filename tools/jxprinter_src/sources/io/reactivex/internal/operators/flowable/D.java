package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final Object d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ D(AbstractC0979l abstractC0979l, Object obj, Object obj2, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = obj;
        this.e = obj2;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C(new p135x3.c(cVar), (Callable) this.e, (Callable) this.d));
                break;
            case 1:
                this.b.subscribe((InterfaceC0984q) new C(new p135x3.c(cVar), (Callable) this.d, (t5.b) this.e));
                break;
            case 2:
                try {
                    Object objCall = ((Callable) this.d).call();
                    p039g3.A.b(objCall, "The initial value supplied is null");
                    this.b.subscribe((InterfaceC0984q) new L(cVar, objCall, (p027e3.b) this.e));
                } catch (Throwable th) {
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th);
                    return;
                }
                break;
            case 3:
                try {
                    Object objCall2 = ((Callable) this.d).call();
                    p039g3.A.b(objCall2, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.b.subscribe((InterfaceC0984q) new L0(cVar, (p027e3.o) this.e, (Collection) objCall2));
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th2);
                    return;
                }
                break;
            case 4:
                p027e3.d dVar = (p027e3.d) this.e;
                p027e3.o oVar = (p027e3.o) this.d;
                boolean z6 = cVar instanceof p043h3.a;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new N0(cVar, oVar, dVar));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new M0((p043h3.a) cVar, oVar, dVar));
                }
                break;
            case 5:
                try {
                    Object objCall3 = ((Callable) this.d).call();
                    p039g3.A.b(objCall3, "The seed supplied is null");
                    this.b.subscribe((InterfaceC0984q) new X3(AbstractC0979l.f5366a, (p027e3.c) this.e, objCall3, cVar));
                } catch (Throwable th3) {
                    p017c3.d.throwIfFatal(th3);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th3);
                    return;
                }
                break;
            case 6:
                this.b.subscribe((InterfaceC0984q) new D4(cVar, (TimeUnit) this.e, (io.reactivex.N) this.d));
                break;
            case 7:
                p135x3.c cVar2 = new p135x3.c(cVar);
                j5 j5Var = new j5(cVar2, (p027e3.c) this.d);
                cVar2.onSubscribe(j5Var);
                ((t5.b) this.e).subscribe(new S3(j5Var, 1));
                this.b.subscribe((InterfaceC0984q) j5Var);
                break;
            default:
                p094q3.d dVar2 = p094q3.d.f7843a;
                try {
                    Iterator it = ((Iterable) this.d).iterator();
                    p039g3.A.b(it, "The iterator returned by other is null");
                    try {
                        if (!it.hasNext()) {
                            cVar.onSubscribe(dVar2);
                            cVar.onComplete();
                        } else {
                            this.b.subscribe((InterfaceC0984q) new W3(cVar, it, (p027e3.c) this.e));
                        }
                    } catch (Throwable th4) {
                        p017c3.d.throwIfFatal(th4);
                        cVar.onSubscribe(dVar2);
                        cVar.onError(th4);
                        return;
                    }
                } catch (Throwable th5) {
                    p017c3.d.throwIfFatal(th5);
                    cVar.onSubscribe(dVar2);
                    cVar.onError(th5);
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ D(AbstractC0979l abstractC0979l, Object obj, Object obj2, int i5, boolean z6) {
        super(abstractC0979l);
        this.c = i5;
        this.e = obj;
        this.d = obj2;
    }
}
