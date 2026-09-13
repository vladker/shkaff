package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0682i;
import io.reactivex.plugins.a;
import java.util.concurrent.Callable;
import p017c3.c;
import p017c3.d;
import p027e3.g;
import p027e3.o;
import p033f3.e;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f5425a;
    public final o b;
    public final g c;
    public final boolean d;

    public U(Callable callable, o oVar, g gVar, boolean z6) {
        this.f5425a = callable;
        this.b = oVar;
        this.c = gVar;
        this.d = z6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        e eVar = e.f3970a;
        boolean z6 = this.d;
        g gVar = this.c;
        try {
            Object objCall = this.f5425a.call();
            try {
                Object objApply = this.b.apply(objCall);
                A.b(objApply, "The completableFunction returned a null CompletableSource");
                ((AbstractC0676c) ((InterfaceC0682i) objApply)).subscribe(new T(interfaceC0679f, objCall, gVar, z6));
            } catch (Throwable th) {
                d.throwIfFatal(th);
                if (z6) {
                    try {
                        gVar.accept(objCall);
                    } catch (Throwable th2) {
                        d.throwIfFatal(th2);
                        c cVar = new c(th, th2);
                        interfaceC0679f.onSubscribe(eVar);
                        interfaceC0679f.onError(cVar);
                        return;
                    }
                }
                interfaceC0679f.onSubscribe(eVar);
                interfaceC0679f.onError(th);
                if (z6) {
                    return;
                }
                try {
                    gVar.accept(objCall);
                } catch (Throwable th3) {
                    d.throwIfFatal(th3);
                    a.onError(th3);
                }
            }
        } catch (Throwable th4) {
            d.throwIfFatal(th4);
            interfaceC0679f.onSubscribe(eVar);
            interfaceC0679f.onError(th4);
        }
    }
}
