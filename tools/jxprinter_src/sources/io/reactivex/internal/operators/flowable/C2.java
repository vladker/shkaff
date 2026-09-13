package io.reactivex.internal.operators.flowable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C2 extends p088p3.l {
    private static final long serialVersionUID = -3740826063558713822L;

    @Override // p088p3.l
    public final void b(Object obj) {
        io.reactivex.A a6 = (io.reactivex.A) obj;
        if (a6.f4169a instanceof p100r3.l) {
            io.reactivex.plugins.a.onError(a6.getError());
        }
    }

    @Override // t5.c
    public final void onComplete() {
        a(io.reactivex.A.createOnComplete());
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        a(io.reactivex.A.createOnError(th));
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d++;
        this.f7750a.onNext(io.reactivex.A.createOnNext(obj));
    }
}
