package p071m3;

import p027e3.o;
import p039g3.A;
import p043h3.a;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6152a;
    public final o b;
    public d c;
    public boolean d;

    public r(a aVar, o oVar) {
        this.f6152a = aVar;
        this.b = oVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        if (this.d) {
            return false;
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null value");
            return this.f6152a.h(objApply);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cancel();
            onError(th);
            return false;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.f6152a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.d = true;
            this.f6152a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        try {
            Object objApply = this.b.apply(obj);
            A.b(objApply, "The mapper returned a null value");
            this.f6152a.onNext(objApply);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.c, dVar)) {
            this.c = dVar;
            this.f6152a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
