package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M2 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5030a = 0;
    public final io.reactivex.I b;
    public final p027e3.c c;
    public Object d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5031f;

    public M2(io.reactivex.I i5, p027e3.c cVar) {
        this.b = i5;
        this.c = cVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5030a) {
            case 0:
                this.e.dispose();
                break;
            default:
                this.e.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5030a) {
            case 0:
                break;
        }
        return this.e.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5030a) {
            case 0:
                if (!this.f5031f) {
                    this.f5031f = true;
                    this.b.onComplete();
                    break;
                }
                break;
            default:
                if (!this.f5031f) {
                    this.f5031f = true;
                    this.b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5030a) {
            case 0:
                if (!this.f5031f) {
                    this.f5031f = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.f5031f) {
                    this.f5031f = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5030a) {
            case 0:
                if (!this.f5031f) {
                    Object obj2 = this.d;
                    io.reactivex.I i5 = this.b;
                    if (obj2 == null) {
                        this.d = obj;
                        i5.onNext(obj);
                    } else {
                        try {
                            Object objApply = this.c.apply(obj2, obj);
                            p039g3.A.b(objApply, "The value returned by the accumulator is null");
                            this.d = objApply;
                            i5.onNext(objApply);
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            this.e.dispose();
                            onError(th);
                            return;
                        }
                    }
                    break;
                }
                break;
            default:
                if (!this.f5031f) {
                    try {
                        Object objApply2 = this.c.apply(this.d, obj);
                        p039g3.A.b(objApply2, "The accumulator returned a null value");
                        this.d = objApply2;
                        this.b.onNext(objApply2);
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.e.dispose();
                        onError(th2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5030a) {
            case 0:
                if (p033f3.d.g(this.e, cVar)) {
                    this.e = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (p033f3.d.g(this.e, cVar)) {
                    this.e = cVar;
                    io.reactivex.I i5 = this.b;
                    i5.onSubscribe(this);
                    i5.onNext(this.d);
                }
                break;
        }
    }

    public M2(io.reactivex.I i5, p027e3.c cVar, Object obj) {
        this.b = i5;
        this.c = cVar;
        this.d = obj;
    }
}
