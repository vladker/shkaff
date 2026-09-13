package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class T0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ T0(AbstractC0979l abstractC0979l, Object obj, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = obj;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                p027e3.a aVar = (p027e3.a) this.d;
                boolean z6 = cVar instanceof p043h3.a;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new S0(cVar, aVar));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new R0((p043h3.a) cVar, aVar));
                }
                break;
            case 1:
                p094q3.f fVar = new p094q3.f(false);
                cVar.onSubscribe(fVar);
                new C0800t3(cVar, (p027e3.e) this.d, fVar, this.b).a();
                break;
            case 2:
                p094q3.f fVar2 = new p094q3.f(false);
                cVar.onSubscribe(fVar2);
                new L3(cVar, (p027e3.d) this.d, fVar2, this.b).a();
                break;
            case 3:
                try {
                    Object objCall = ((Callable) this.d).call();
                    p039g3.A.b(objCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    Collection collection = (Collection) objCall;
                    O4 o6 = new O4(cVar);
                    o6.b = collection;
                    this.b.subscribe((InterfaceC0984q) o6);
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th);
                    return;
                }
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new P4(cVar, (io.reactivex.N) this.d));
                break;
        }
    }
}
