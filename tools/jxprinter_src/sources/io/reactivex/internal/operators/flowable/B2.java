package io.reactivex.internal.operators.flowable;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B2 extends p088p3.l {
    private static final long serialVersionUID = 2757120512858778108L;
    public final p027e3.o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p027e3.o f4181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable f4182g;

    public B2(t5.c cVar, p027e3.o oVar, p027e3.o oVar2, Callable callable) {
        super(cVar);
        this.e = oVar;
        this.f4181f = oVar2;
        this.f4182g = callable;
    }

    @Override // t5.c
    public final void onComplete() {
        try {
            Object objCall = this.f4182g.call();
            p039g3.A.b(objCall, "The onComplete publisher returned is null");
            a(objCall);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f7750a.onError(th);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        try {
            Object objApply = this.f4181f.apply(th);
            p039g3.A.b(objApply, "The onError publisher returned is null");
            a(objApply);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f7750a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        t5.c cVar = this.f7750a;
        try {
            Object objApply = this.e.apply(obj);
            p039g3.A.b(objApply, "The onNext publisher returned is null");
            this.d++;
            cVar.onNext(objApply);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cVar.onError(th);
        }
    }
}
