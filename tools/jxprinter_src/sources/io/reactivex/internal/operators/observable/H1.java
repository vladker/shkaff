package io.reactivex.internal.operators.observable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H1 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4955a;
    public final p027e3.o b;
    public final p027e3.o c;
    public final Callable d;
    public p011b3.c e;

    public H1(io.reactivex.I i5, p027e3.o oVar, p027e3.o oVar2, Callable callable) {
        this.f4955a = i5;
        this.b = oVar;
        this.c = oVar2;
        this.d = callable;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        io.reactivex.I i5 = this.f4955a;
        try {
            Object objCall = this.d.call();
            p039g3.A.b(objCall, "The onComplete ObservableSource returned is null");
            i5.onNext((io.reactivex.G) objCall);
            i5.onComplete();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            i5.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        io.reactivex.I i5 = this.f4955a;
        try {
            Object objApply = this.c.apply(th);
            p039g3.A.b(objApply, "The onError ObservableSource returned is null");
            i5.onNext((io.reactivex.G) objApply);
            i5.onComplete();
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            i5.onError(new p017c3.c(th, th2));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        io.reactivex.I i5 = this.f4955a;
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The onNext ObservableSource returned is null");
            i5.onNext((io.reactivex.G) objApply);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            i5.onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f4955a.onSubscribe(this);
        }
    }
}
