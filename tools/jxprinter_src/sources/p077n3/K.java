package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.o;
import p033f3.d;
import p039g3.A;
import p048i3.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends AtomicReference implements S, c {
    private static final long serialVersionUID = -5314538511045349925L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6270a;
    public final o b;

    public K(S s6, o oVar) {
        this.f6270a = s6;
        this.b = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        S s6 = this.f6270a;
        try {
            Object objApply = this.b.apply(th);
            A.b(objApply, "The nextFunction returned a null SingleSource.");
            ((O) ((V) objApply)).subscribe(new t((Object) this, (Object) s6, 0));
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            s6.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6270a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6270a.onSuccess(obj);
    }
}
