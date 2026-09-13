package p048i3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.g;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends AtomicReference implements S, c {
    private static final long serialVersionUID = -7012088219455310787L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4052a;
    public final g b;

    public j(g gVar, g gVar2) {
        this.f4052a = gVar;
        this.b = gVar2;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == d.f3969a;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        lazySet(d.f3969a);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        lazySet(d.f3969a);
        try {
            this.f4052a.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            a.onError(th);
        }
    }
}
