package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0878i implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5201a;
    public final io.reactivex.S b;
    public final p027e3.q c;
    public p011b3.c d;
    public boolean e;

    public /* synthetic */ C0878i(io.reactivex.S s6, p027e3.q qVar, int i5) {
        this.f5201a = i5;
        this.b = s6;
        this.c = qVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5201a) {
            case 0:
                this.d.dispose();
                break;
            default:
                this.d.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5201a) {
            case 0:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5201a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onSuccess(Boolean.TRUE);
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onSuccess(Boolean.FALSE);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5201a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        switch (this.f5201a) {
            case 0:
                if (!this.e) {
                    try {
                        if (!this.c.test(obj)) {
                            this.e = true;
                            this.d.dispose();
                            this.b.onSuccess(Boolean.FALSE);
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.d.dispose();
                        onError(th);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!this.e) {
                    try {
                        if (this.c.test(obj)) {
                            this.e = true;
                            this.d.dispose();
                            this.b.onSuccess(Boolean.TRUE);
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.d.dispose();
                        onError(th2);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5201a) {
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
