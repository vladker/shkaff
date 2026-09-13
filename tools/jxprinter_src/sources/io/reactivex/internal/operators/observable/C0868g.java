package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0868g implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5190a;
    public final io.reactivex.I b;
    public final p027e3.q c;
    public p011b3.c d;
    public boolean e;

    public /* synthetic */ C0868g(io.reactivex.I i5, p027e3.q qVar, int i6) {
        this.f5190a = i6;
        this.b = i5;
        this.c = qVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5190a) {
            case 0:
                this.d.dispose();
                break;
            case 1:
                this.d.dispose();
                break;
            case 2:
                this.d.dispose();
                break;
            case 3:
                this.d.dispose();
                break;
            default:
                this.d.dispose();
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5190a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        switch (this.f5190a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    Boolean bool = Boolean.TRUE;
                    io.reactivex.I i5 = this.b;
                    i5.onNext(bool);
                    i5.onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    Boolean bool2 = Boolean.FALSE;
                    io.reactivex.I i6 = this.b;
                    i6.onNext(bool2);
                    i6.onComplete();
                }
                break;
            case 2:
                this.b.onComplete();
                break;
            case 3:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        switch (this.f5190a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.b.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 2:
                this.b.onError(th);
                break;
            case 3:
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
        switch (this.f5190a) {
            case 0:
                if (!this.e) {
                    try {
                        if (!this.c.test(obj)) {
                            this.e = true;
                            this.d.dispose();
                            Boolean bool = Boolean.FALSE;
                            io.reactivex.I i5 = this.b;
                            i5.onNext(bool);
                            i5.onComplete();
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
            case 1:
                if (!this.e) {
                    try {
                        if (this.c.test(obj)) {
                            this.e = true;
                            this.d.dispose();
                            Boolean bool2 = Boolean.TRUE;
                            io.reactivex.I i6 = this.b;
                            i6.onNext(bool2);
                            i6.onComplete();
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        this.d.dispose();
                        onError(th2);
                        return;
                    }
                    break;
                }
                break;
            case 2:
                boolean z6 = this.e;
                io.reactivex.I i7 = this.b;
                if (z6) {
                    i7.onNext(obj);
                } else {
                    try {
                        if (!this.c.test(obj)) {
                            this.e = true;
                            i7.onNext(obj);
                        }
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        this.d.dispose();
                        i7.onError(th3);
                        return;
                    }
                }
                break;
            case 3:
                if (!this.e) {
                    io.reactivex.I i8 = this.b;
                    i8.onNext(obj);
                    try {
                        if (this.c.test(obj)) {
                            this.e = true;
                            this.d.dispose();
                            i8.onComplete();
                        }
                    } catch (Throwable th4) {
                        p017c3.d.throwIfFatal(th4);
                        this.d.dispose();
                        onError(th4);
                        return;
                    }
                }
                break;
            default:
                if (!this.e) {
                    try {
                        boolean zTest = this.c.test(obj);
                        io.reactivex.I i9 = this.b;
                        if (!zTest) {
                            this.e = true;
                            this.d.dispose();
                            i9.onComplete();
                        } else {
                            i9.onNext(obj);
                        }
                    } catch (Throwable th5) {
                        p017c3.d.throwIfFatal(th5);
                        this.d.dispose();
                        onError(th5);
                    }
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        switch (this.f5190a) {
            case 0:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 1:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 2:
                if (p033f3.d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 3:
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
