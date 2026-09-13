package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W0 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4488a;
    public final p027e3.g b;
    public final p027e3.p c;
    public final p027e3.a d;
    public t5.d e;

    public W0(t5.c cVar, p027e3.g gVar, p027e3.p pVar, p027e3.a aVar) {
        this.f4488a = cVar;
        this.b = gVar;
        this.d = aVar;
        this.c = pVar;
    }

    @Override // t5.d
    public final void cancel() {
        t5.d dVar = this.e;
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar != gVar) {
            this.e = gVar;
            try {
                this.d.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
            dVar.cancel();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.e != p094q3.g.f7849a) {
            this.f4488a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.e != p094q3.g.f7849a) {
            this.f4488a.onError(th);
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4488a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        t5.c cVar = this.f4488a;
        try {
            this.b.accept(dVar);
            if (p094q3.g.g(this.e, dVar)) {
                this.e = dVar;
                cVar.onSubscribe(this);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            dVar.cancel();
            this.e = p094q3.g.f7849a;
            p094q3.d.e(th, cVar);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        try {
            this.c.getClass();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
        this.e.request(j6);
    }
}
