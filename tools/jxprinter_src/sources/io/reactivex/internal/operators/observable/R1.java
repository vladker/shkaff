package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R1 implements io.reactivex.I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5097a;
    public final p027e3.o b;
    public final boolean c;
    public final p033f3.h d = new p033f3.h();
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5098f;

    public R1(io.reactivex.I i5, p027e3.o oVar, boolean z6) {
        this.f5097a = i5;
        this.b = oVar;
        this.c = z6;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5098f) {
            return;
        }
        this.f5098f = true;
        this.e = true;
        this.f5097a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        boolean z6 = this.e;
        io.reactivex.I i5 = this.f5097a;
        if (z6) {
            if (this.f5098f) {
                io.reactivex.plugins.a.onError(th);
                return;
            } else {
                i5.onError(th);
                return;
            }
        }
        this.e = true;
        if (this.c && !(th instanceof Exception)) {
            i5.onError(th);
            return;
        }
        try {
            io.reactivex.G g6 = (io.reactivex.G) this.b.apply(th);
            if (g6 != null) {
                g6.subscribe(this);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Observable is null");
            nullPointerException.initCause(th);
            i5.onError(nullPointerException);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            i5.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5098f) {
            return;
        }
        this.f5097a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.h hVar = this.d;
        hVar.getClass();
        p033f3.d.c(hVar, cVar);
    }
}
