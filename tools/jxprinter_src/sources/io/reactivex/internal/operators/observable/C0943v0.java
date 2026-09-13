package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0943v0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5289a;
    public final p027e3.g b;
    public final p027e3.g c;
    public final p027e3.a d;
    public final p027e3.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5291g;

    public C0943v0(io.reactivex.I i5, p027e3.g gVar, p027e3.g gVar2, p027e3.a aVar, p027e3.a aVar2) {
        this.f5289a = i5;
        this.b = gVar;
        this.c = gVar2;
        this.d = aVar;
        this.e = aVar2;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5290f.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5290f.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5291g) {
            return;
        }
        try {
            this.d.run();
            this.f5291g = true;
            this.f5289a.onComplete();
            try {
                this.e.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            onError(th2);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5291g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f5291g = true;
        try {
            this.c.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            th = new p017c3.c(th, th2);
        }
        this.f5289a.onError(th);
        try {
            this.e.run();
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            io.reactivex.plugins.a.onError(th3);
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5291g) {
            return;
        }
        try {
            this.b.accept(obj);
            this.f5289a.onNext(obj);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f5290f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5290f, cVar)) {
            this.f5290f = cVar;
            this.f5289a.onSubscribe(this);
        }
    }
}
