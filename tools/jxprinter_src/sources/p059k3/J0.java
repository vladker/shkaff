package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.Callable;
import p017c3.c;
import p017c3.d;
import p027e3.g;
import p027e3.o;
import p033f3.e;
import p039g3.A;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J0 extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f5516a;
    public final o b;
    public final g c;
    public final boolean d;

    public J0(Callable callable, o oVar, g gVar, boolean z6) {
        this.f5516a = callable;
        this.b = oVar;
        this.c = gVar;
        this.d = z6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        e eVar = e.f3970a;
        boolean z6 = this.d;
        g gVar = this.c;
        try {
            Object objCall = this.f5516a.call();
            try {
                Object objApply = this.b.apply(objCall);
                A.b(objApply, "The sourceSupplier returned a null MaybeSource");
                ((AbstractC0985s) ((y) objApply)).subscribe(new I0(interfaceC0988v, objCall, gVar, z6));
            } catch (Throwable th) {
                d.throwIfFatal(th);
                if (z6) {
                    try {
                        gVar.accept(objCall);
                    } catch (Throwable th2) {
                        d.throwIfFatal(th2);
                        c cVar = new c(th, th2);
                        interfaceC0988v.onSubscribe(eVar);
                        interfaceC0988v.onError(cVar);
                        return;
                    }
                }
                interfaceC0988v.onSubscribe(eVar);
                interfaceC0988v.onError(th);
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
            interfaceC0988v.onSubscribe(eVar);
            interfaceC0988v.onError(th4);
        }
    }
}
