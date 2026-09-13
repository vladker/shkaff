package p071m3;

import p027e3.c;
import p027e3.q;
import p039g3.A;
import p043h3.a;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements a, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f6133a;
    public final c b;
    public d c;
    public boolean d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t5.c f6134f;

    public g(t5.c cVar, q qVar, c cVar2, int i5) {
        this.e = i5;
        this.f6133a = qVar;
        this.b = cVar2;
        this.f6134f = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        int iOrdinal;
        int iOrdinal2;
        switch (this.e) {
            case 0:
                if (this.d) {
                    return false;
                }
                long j6 = 0;
                do {
                    try {
                        return this.f6133a.test(obj) && ((a) this.f6134f).h(obj);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        try {
                            j6++;
                            Object objApply = this.b.apply(Long.valueOf(j6), th);
                            A.b(objApply, "The errorHandler returned a null item");
                            iOrdinal = ((p117u3.a) objApply).ordinal();
                            if (iOrdinal == 0) {
                                cancel();
                                onComplete();
                                return false;
                            }
                            if (iOrdinal == 2) {
                                return false;
                            }
                        } catch (Throwable th2) {
                            p017c3.d.throwIfFatal(th2);
                            cancel();
                            onError(new p017c3.c(th, th2));
                            return false;
                        }
                    }
                } while (iOrdinal == 3);
                cancel();
                onError(th);
                return false;
            default:
                if (this.d) {
                    return false;
                }
                long j7 = 0;
                do {
                    try {
                        if (!this.f6133a.test(obj)) {
                            return false;
                        }
                        this.f6134f.onNext(obj);
                        return true;
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        try {
                            j7++;
                            Object objApply2 = this.b.apply(Long.valueOf(j7), th3);
                            A.b(objApply2, "The errorHandler returned a null item");
                            iOrdinal2 = ((p117u3.a) objApply2).ordinal();
                            if (iOrdinal2 == 0) {
                                cancel();
                                onComplete();
                                return false;
                            }
                            if (iOrdinal2 == 2) {
                                return false;
                            }
                        } catch (Throwable th4) {
                            p017c3.d.throwIfFatal(th4);
                            cancel();
                            onError(new p017c3.c(th3, th4));
                            return false;
                        }
                    }
                } while (iOrdinal2 == 3);
                cancel();
                onError(th3);
                return false;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.e) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    ((a) this.f6134f).onComplete();
                }
                break;
            default:
                if (!this.d) {
                    this.d = true;
                    this.f6134f.onComplete();
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.e) {
            case 0:
                if (!this.d) {
                    this.d = true;
                    ((a) this.f6134f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.d) {
                    this.d = true;
                    this.f6134f.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj) || this.d) {
            return;
        }
        this.c.request(1L);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        switch (this.e) {
            case 0:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    ((a) this.f6134f).onSubscribe(this);
                }
                break;
            default:
                if (p094q3.g.g(this.c, dVar)) {
                    this.c = dVar;
                    this.f6134f.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
