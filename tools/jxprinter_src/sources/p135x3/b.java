package p135x3;

import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import p094q3.g;
import t5.c;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements InterfaceC0984q, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8955a;
    public d b;
    public boolean c;

    public b(c cVar) {
        this.f8955a = cVar;
    }

    @Override // t5.d
    public final void cancel() {
        try {
            this.b.cancel();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            a.onError(th);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        d dVar = this.b;
        c cVar = this.f8955a;
        if (dVar != null) {
            try {
                cVar.onComplete();
                return;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                a.onError(th);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            cVar.onSubscribe(p094q3.d.f7843a);
            try {
                cVar.onError(nullPointerException);
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            a.onError(new p017c3.c(nullPointerException, th3));
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.c) {
            a.onError(th);
            return;
        }
        this.c = true;
        d dVar = this.b;
        c cVar = this.f8955a;
        if (dVar != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                cVar.onError(th);
                return;
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            cVar.onSubscribe(p094q3.d.f7843a);
            try {
                cVar.onError(new p017c3.c(th, nullPointerException));
            } catch (Throwable th3) {
                p017c3.d.throwIfFatal(th3);
                a.onError(new p017c3.c(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            p017c3.d.throwIfFatal(th4);
            a.onError(new p017c3.c(th, nullPointerException, th4));
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.c) {
            return;
        }
        d dVar = this.b;
        c cVar = this.f8955a;
        if (dVar == null) {
            this.c = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                cVar.onSubscribe(p094q3.d.f7843a);
                try {
                    cVar.onError(nullPointerException);
                    return;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    a.onError(new p017c3.c(nullPointerException, th));
                    return;
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(nullPointerException, th2));
                return;
            }
        }
        if (obj == null) {
            NullPointerException nullPointerException2 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.b.cancel();
                onError(nullPointerException2);
                return;
            } catch (Throwable th3) {
                p017c3.d.throwIfFatal(th3);
                onError(new p017c3.c(nullPointerException2, th3));
                return;
            }
        }
        try {
            cVar.onNext(obj);
        } catch (Throwable th4) {
            p017c3.d.throwIfFatal(th4);
            try {
                this.b.cancel();
                onError(th4);
            } catch (Throwable th5) {
                p017c3.d.throwIfFatal(th5);
                onError(new p017c3.c(th4, th5));
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.b, dVar)) {
            this.b = dVar;
            try {
                this.f8955a.onSubscribe(this);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                this.c = true;
                try {
                    dVar.cancel();
                    a.onError(th);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    a.onError(new p017c3.c(th, th2));
                }
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        try {
            this.b.request(j6);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            try {
                this.b.cancel();
                a.onError(th);
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(th, th2));
            }
        }
    }
}
