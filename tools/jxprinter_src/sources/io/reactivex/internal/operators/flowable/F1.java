package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.Iterator;
import p059k3.C1026i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F1 extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final Iterable c;

    public /* synthetic */ F1(Iterable iterable, int i5) {
        this.b = i5;
        this.c = iterable;
    }

    public static void g(t5.c cVar, Iterator it) {
        p094q3.d dVar = p094q3.d.f7843a;
        try {
            if (!it.hasNext()) {
                cVar.onSubscribe(dVar);
                cVar.onComplete();
            } else if (cVar instanceof p043h3.a) {
                cVar.onSubscribe(new D1((p043h3.a) cVar, it));
            } else {
                cVar.onSubscribe(new E1(cVar, it));
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cVar.onSubscribe(dVar);
            cVar.onError(th);
        }
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                try {
                    g(cVar, this.c.iterator());
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th);
                }
                break;
            default:
                try {
                    Iterator it = this.c.iterator();
                    p039g3.A.b(it, "The sources Iterable returned a null Iterator");
                    C1026i c1026i = new C1026i(cVar, it);
                    cVar.onSubscribe(c1026i);
                    c1026i.a();
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th2);
                    return;
                }
                break;
        }
    }
}
