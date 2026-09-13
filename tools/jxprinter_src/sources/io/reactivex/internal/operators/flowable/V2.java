package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V2 extends p088p3.l {
    private static final long serialVersionUID = -3740826063558713822L;
    public final p027e3.o e;

    public V2(t5.c cVar, p027e3.o oVar) {
        super(cVar);
        this.e = oVar;
    }

    @Override // t5.c
    public final void onComplete() {
        this.f7750a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        try {
            Object objApply = this.e.apply(th);
            p039g3.A.b(objApply, "The valueSupplier returned a null value");
            a(objApply);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.f7750a.onError(new p017c3.c(th, th2));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d++;
        this.f7750a.onNext(obj);
    }
}
