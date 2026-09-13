package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class w3 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f5305a;
    public final p027e3.o b;
    public final p027e3.g c;
    public final boolean d;

    public w3(Callable callable, p027e3.o oVar, p027e3.g gVar, boolean z6) {
        this.f5305a = callable;
        this.b = oVar;
        this.c = gVar;
        this.d = z6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        p033f3.e eVar = p033f3.e.f3970a;
        p027e3.g gVar = this.c;
        try {
            Object objCall = this.f5305a.call();
            try {
                Object objApply = this.b.apply(objCall);
                p039g3.A.b(objApply, "The sourceSupplier returned a null ObservableSource");
                ((io.reactivex.G) objApply).subscribe(new v3(i5, objCall, gVar, this.d));
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                try {
                    gVar.accept(objCall);
                    i5.onSubscribe(eVar);
                    i5.onError(th);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    p017c3.c cVar = new p017c3.c(th, th2);
                    i5.onSubscribe(eVar);
                    i5.onError(cVar);
                }
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            i5.onSubscribe(eVar);
            i5.onError(th3);
        }
    }
}
