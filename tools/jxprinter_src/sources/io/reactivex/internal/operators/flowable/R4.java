package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R4 extends AbstractC0979l {
    public final Callable b;
    public final p027e3.o c;
    public final p027e3.g d;
    public final boolean e;

    public R4(Callable callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        this.b = callable;
        this.c = oVar;
        this.d = gVar;
        this.e = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        p094q3.d dVar = p094q3.d.f7843a;
        p027e3.g gVar = this.d;
        try {
            Object objCall = this.b.call();
            try {
                Object objApply = this.c.apply(objCall);
                p039g3.A.b(objApply, "The sourceSupplier returned a null Publisher");
                ((t5.b) objApply).subscribe(new Q4(cVar, objCall, gVar, this.e));
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                try {
                    gVar.accept(objCall);
                    cVar.onSubscribe(dVar);
                    cVar.onError(th);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    p017c3.c cVar2 = new p017c3.c(th, th2);
                    cVar.onSubscribe(dVar);
                    cVar.onError(cVar2);
                }
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            cVar.onSubscribe(dVar);
            cVar.onError(th3);
        }
    }
}
