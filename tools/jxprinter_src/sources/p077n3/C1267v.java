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

/* JADX INFO: renamed from: n3.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1267v extends AtomicReference implements S, c {
    private static final long serialVersionUID = 3258103020495908596L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6310a;
    public final o b;

    public C1267v(S s6, o oVar) {
        this.f6310a = s6;
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
        this.f6310a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6310a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        S s6 = this.f6310a;
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The single returned by the mapper is null");
            V v6 = (V) objApply;
            if (e()) {
                return;
            }
            ((O) v6).subscribe(new t((Object) this, (Object) s6, 9));
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            s6.onError(th);
        }
    }
}
