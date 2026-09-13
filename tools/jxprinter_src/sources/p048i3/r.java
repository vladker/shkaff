package p048i3;

import io.reactivex.I;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p027e3.a;
import p027e3.g;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends AtomicReference implements I, c {
    private static final long serialVersionUID = -7251123623727029452L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4059a;
    public final g b;
    public final a c;
    public final g d;

    public r(g gVar, g gVar2, a aVar, g gVar3) {
        this.f4059a = gVar;
        this.b = gVar2;
        this.c = aVar;
        this.d = gVar3;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (e()) {
            return;
        }
        lazySet(d.f3969a);
        try {
            this.c.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (e()) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        lazySet(d.f3969a);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (e()) {
            return;
        }
        try {
            this.f4059a.accept(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            ((c) get()).dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cVar.dispose();
                onError(th);
            }
        }
    }
}
