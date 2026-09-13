package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N3 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -312246233408980075L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5047a;
    public final p027e3.c b;
    public final AtomicReference c = new AtomicReference();
    public final AtomicReference d = new AtomicReference();

    public N3(p112t3.e eVar, p027e3.c cVar) {
        this.f5047a = eVar;
        this.b = cVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.c);
        p033f3.d.a(this.d);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) this.c.get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.a(this.d);
        this.f5047a.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.d);
        this.f5047a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        p112t3.e eVar = this.f5047a;
        Object obj2 = get();
        if (obj2 != null) {
            try {
                Object objApply = this.b.apply(obj, obj2);
                p039g3.A.b(objApply, "The combiner returned a null value");
                eVar.onNext(objApply);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                dispose();
                eVar.onError(th);
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.c, cVar);
    }
}
