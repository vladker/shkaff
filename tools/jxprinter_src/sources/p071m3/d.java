package p071m3;

import p027e3.c;
import p027e3.g;
import p027e3.o;
import p039g3.A;
import p043h3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements a, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6129a;
    public final Object b;
    public final c c;
    public t5.d d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t5.c f6130f;

    public /* synthetic */ d(int i5, c cVar, Object obj, t5.c cVar2) {
        this.f6129a = i5;
        this.f6130f = cVar2;
        this.b = obj;
        this.c = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        switch (this.f6129a) {
            case 0:
                this.d.cancel();
                break;
            case 1:
                this.d.cancel();
                break;
            case 2:
                this.d.cancel();
                break;
            default:
                this.d.cancel();
                break;
        }
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        int iOrdinal;
        int iOrdinal2;
        int iOrdinal3;
        int iOrdinal4;
        switch (this.f6129a) {
            case 0:
                if (this.e) {
                    return false;
                }
                long j6 = 0;
                do {
                    try {
                        ((g) this.b).accept(obj);
                        return ((a) this.f6130f).h(obj);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        try {
                            j6++;
                            Object objApply = this.c.apply(Long.valueOf(j6), th);
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
            case 1:
                if (this.e) {
                    return false;
                }
                long j7 = 0;
                do {
                    try {
                        ((g) this.b).accept(obj);
                        this.f6130f.onNext(obj);
                        return true;
                    } catch (Throwable th3) {
                        p017c3.d.throwIfFatal(th3);
                        try {
                            j7++;
                            Object objApply2 = this.c.apply(Long.valueOf(j7), th3);
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
            case 2:
                if (this.e) {
                    return false;
                }
                long j8 = 0;
                do {
                    try {
                        Object objApply3 = ((o) this.b).apply(obj);
                        A.b(objApply3, "The mapper returned a null value");
                        return ((a) this.f6130f).h(objApply3);
                    } catch (Throwable th5) {
                        p017c3.d.throwIfFatal(th5);
                        try {
                            j8++;
                            Object objApply4 = this.c.apply(Long.valueOf(j8), th5);
                            A.b(objApply4, "The errorHandler returned a null item");
                            iOrdinal3 = ((p117u3.a) objApply4).ordinal();
                            if (iOrdinal3 == 0) {
                                cancel();
                                onComplete();
                                return false;
                            }
                            if (iOrdinal3 == 2) {
                                return false;
                            }
                        } catch (Throwable th6) {
                            p017c3.d.throwIfFatal(th6);
                            cancel();
                            onError(new p017c3.c(th5, th6));
                            return false;
                        }
                    }
                } while (iOrdinal3 == 3);
                cancel();
                onError(th5);
                return false;
            default:
                if (this.e) {
                    return false;
                }
                long j9 = 0;
                do {
                    try {
                        Object objApply5 = ((o) this.b).apply(obj);
                        A.b(objApply5, "The mapper returned a null value");
                        this.f6130f.onNext(objApply5);
                        return true;
                    } catch (Throwable th7) {
                        p017c3.d.throwIfFatal(th7);
                        try {
                            j9++;
                            Object objApply6 = this.c.apply(Long.valueOf(j9), th7);
                            A.b(objApply6, "The errorHandler returned a null item");
                            iOrdinal4 = ((p117u3.a) objApply6).ordinal();
                            if (iOrdinal4 == 0) {
                                cancel();
                                onComplete();
                                return false;
                            }
                            if (iOrdinal4 == 2) {
                                return false;
                            }
                        } catch (Throwable th8) {
                            p017c3.d.throwIfFatal(th8);
                            cancel();
                            onError(new p017c3.c(th7, th8));
                            return false;
                        }
                    }
                } while (iOrdinal4 == 3);
                cancel();
                onError(th7);
                return false;
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f6129a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((a) this.f6130f).onComplete();
                    break;
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.f6130f.onComplete();
                    break;
                }
                break;
            case 2:
                if (!this.e) {
                    this.e = true;
                    ((a) this.f6130f).onComplete();
                    break;
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.f6130f.onComplete();
                    break;
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f6129a) {
            case 0:
                if (!this.e) {
                    this.e = true;
                    ((a) this.f6130f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 1:
                if (!this.e) {
                    this.e = true;
                    this.f6130f.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            case 2:
                if (!this.e) {
                    this.e = true;
                    ((a) this.f6130f).onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
            default:
                if (!this.e) {
                    this.e = true;
                    this.f6130f.onError(th);
                } else {
                    io.reactivex.plugins.a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f6129a) {
            case 0:
                if (!h(obj) && !this.e) {
                    this.d.request(1L);
                    break;
                }
                break;
            case 1:
                if (!h(obj)) {
                    this.d.request(1L);
                }
                break;
            case 2:
                if (!h(obj) && !this.e) {
                    this.d.request(1L);
                    break;
                }
                break;
            default:
                if (!h(obj) && !this.e) {
                    this.d.request(1L);
                    break;
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f6129a) {
            case 0:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    ((a) this.f6130f).onSubscribe(this);
                }
                break;
            case 1:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.f6130f.onSubscribe(this);
                }
                break;
            case 2:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    ((a) this.f6130f).onSubscribe(this);
                }
                break;
            default:
                if (p094q3.g.g(this.d, dVar)) {
                    this.d = dVar;
                    this.f6130f.onSubscribe(this);
                }
                break;
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        switch (this.f6129a) {
            case 0:
                this.d.request(j6);
                break;
            case 1:
                this.d.request(j6);
                break;
            case 2:
                this.d.request(j6);
                break;
            default:
                this.d.request(j6);
                break;
        }
    }
}
