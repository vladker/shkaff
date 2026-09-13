package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class R0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5096a;
    public final io.reactivex.I b;
    public final p027e3.o c;
    public p011b3.c d;

    public /* synthetic */ R0(io.reactivex.I i5, p027e3.o oVar, int i6) {
        this.f5096a = i6;
        this.b = i5;
        this.c = oVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5096a) {
            case 0:
                this.d.dispose();
                this.d = p033f3.d.f3969a;
                break;
            default:
                this.d.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5096a) {
            case 0:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5096a) {
            case 0:
                p011b3.c cVar = this.d;
                p033f3.d dVar = p033f3.d.f3969a;
                if (cVar != dVar) {
                    this.d = dVar;
                    this.b.onComplete();
                    break;
                }
                break;
            default:
                this.b.onComplete();
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5096a) {
            case 0:
                p011b3.c cVar = this.d;
                p033f3.d dVar = p033f3.d.f3969a;
                if (cVar != dVar) {
                    this.d = dVar;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                io.reactivex.I i5 = this.b;
                try {
                    Object objApply = this.c.apply(th);
                    if (objApply != null) {
                        i5.onNext(objApply);
                        i5.onComplete();
                    } else {
                        NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                        nullPointerException.initCause(th);
                        i5.onError(nullPointerException);
                    }
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    i5.onError(new p017c3.c(th, th2));
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5096a) {
            case 0:
                if (this.d != p033f3.d.f3969a) {
                    try {
                        for (Object obj2 : (Iterable) this.c.apply(obj)) {
                            try {
                                try {
                                    p039g3.A.b(obj2, "The iterator returned a null value");
                                    this.b.onNext(obj2);
                                } catch (Throwable th) {
                                    p017c3.d.throwIfFatal(th);
                                    this.d.dispose();
                                    onError(th);
                                    return;
                                }
                            } catch (Throwable th2) {
                                p017c3.d.throwIfFatal(th2);
                                this.d.dispose();
                                onError(th2);
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.d.dispose();
                        onError(th3);
                        return;
                    }
                    break;
                }
                break;
            default:
                this.b.onNext(obj);
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5096a) {
            case 0:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }
}
