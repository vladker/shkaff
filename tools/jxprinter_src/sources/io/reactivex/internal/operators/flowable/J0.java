package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J0 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4298a;
    public final t5.c b;
    public final Object c;
    public t5.d d;
    public boolean e;

    public /* synthetic */ J0(t5.c cVar, Object obj, int i5) {
        this.f4298a = i5;
        this.b = cVar;
        this.c = obj;
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f4298a) {
            case 0:
                this.d.cancel();
                break;
            case 1:
                this.d.cancel();
                break;
            default:
                try {
                    ((p071m3.s) this.c).f6157i.run();
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    io.reactivex.plugins.a.onError(th);
                }
                this.d.cancel();
                break;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4298a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.b.onComplete();
                    break;
                }
                break;
            default:
                t5.c cVar = this.b;
                p071m3.s sVar = (p071m3.s) this.c;
                if (!this.e) {
                    this.e = true;
                    try {
                        sVar.e.run();
                        cVar.onComplete();
                        try {
                            sVar.f6154f.run();
                        } catch (Throwable th) {
                            p017c3.d.throwIfFatal(th);
                            io.reactivex.plugins.a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cVar.onError(th2);
                    }
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4298a) {
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
            default:
                p071m3.s sVar = (p071m3.s) this.c;
                if (this.e) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.e = true;
                    try {
                        sVar.d.accept(th);
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        th = new p017c3.c(th, th2);
                    }
                    this.b.onError(th);
                    try {
                        sVar.f6154f.run();
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        io.reactivex.plugins.a.onError(th3);
                    }
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4298a) {
            case 0:
                if (!this.e) {
                    try {
                        Object objApply = ((p027e3.o) this.c).apply(obj);
                        p039g3.A.b(objApply, "The selector returned a null Notification");
                        io.reactivex.A a6 = (io.reactivex.A) objApply;
                        Object obj2 = a6.f4169a;
                        if (obj2 instanceof p100r3.l) {
                            this.d.cancel();
                            onError(a6.getError());
                        } else if (obj2 != null) {
                            this.b.onNext(a6.getValue());
                        } else {
                            this.d.cancel();
                            onComplete();
                        }
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        this.d.cancel();
                        onError(th);
                        return;
                    }
                } else if (obj instanceof io.reactivex.A) {
                    io.reactivex.A a7 = (io.reactivex.A) obj;
                    if (a7.f4169a instanceof p100r3.l) {
                        io.reactivex.plugins.a.onError(a7.getError());
                    }
                }
                break;
            case 1:
                if (!this.e) {
                    try {
                        Object objApply2 = ((p027e3.o) this.c).apply(obj);
                        p039g3.A.b(objApply2, "The mapper returned a null value");
                        this.b.onNext(objApply2);
                    } catch (Throwable th2) {
                        p017c3.d.throwIfFatal(th2);
                        cancel();
                        onError(th2);
                        return;
                    }
                    break;
                }
                break;
            default:
                p071m3.s sVar = (p071m3.s) this.c;
                if (!this.e) {
                    try {
                        sVar.b.accept(obj);
                        this.b.onNext(obj);
                        try {
                            sVar.c.accept(obj);
                        } catch (Throwable th3) {
                            p017c3.d.throwIfFatal(th3);
                            onError(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        p017c3.d.throwIfFatal(th4);
                        onError(th4);
                    }
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4298a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            case 1:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                t5.c cVar = this.b;
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    try {
                        ((p071m3.s) this.c).f6155g.accept(dVar);
                        cVar.onSubscribe(this);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        dVar.cancel();
                        cVar.onSubscribe(p094q3.d.f7843a);
                        onError(th);
                    }
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        switch (this.f4298a) {
            case 0:
                this.d.request(j6);
                break;
            case 1:
                this.d.request(j6);
                break;
            default:
                try {
                    ((p071m3.s) this.c).f6156h.getClass();
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    io.reactivex.plugins.a.onError(th);
                }
                this.d.request(j6);
                break;
        }
    }
}
