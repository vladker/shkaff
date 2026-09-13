package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
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
public final class Y extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f6282a;
    public final o b;
    public final g c;
    public final boolean d;

    public Y(Callable callable, o oVar, g gVar, boolean z6) {
        this.f6282a = callable;
        this.b = oVar;
        this.c = gVar;
        this.d = z6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        g gVar = this.c;
        boolean z6 = this.d;
        try {
            Object objCall = this.f6282a.call();
            try {
                Object objApply = this.b.apply(objCall);
                A.b(objApply, "The singleFunction returned a null SingleSource");
                ((O) ((V) objApply)).subscribe(new X(s6, objCall, z6, gVar));
            } catch (Throwable th) {
                th = th;
                d.throwIfFatal(th);
                if (z6) {
                    try {
                        gVar.accept(objCall);
                    } catch (Throwable th2) {
                        d.throwIfFatal(th2);
                        th = new c(th, th2);
                    }
                }
                e.f(th, s6);
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
            e.f(th4, s6);
        }
    }
}
