package p112t3;

import io.reactivex.I;
import io.reactivex.plugins.a;
import p011b3.c;
import p033f3.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements I, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f8661a;
    public c b;
    public boolean c;

    public d(I i5) {
        this.f8661a = i5;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.b.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.b.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        c cVar = this.b;
        I i5 = this.f8661a;
        if (cVar != null) {
            try {
                i5.onComplete();
                return;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                a.onError(th);
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            i5.onSubscribe(e.f3970a);
            try {
                i5.onError(nullPointerException);
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(nullPointerException, th2));
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            a.onError(new p017c3.c(nullPointerException, th3));
        }
    }

    @Override // io.reactivex.I
    public void onError(Throwable th) {
        if (this.c) {
            a.onError(th);
            return;
        }
        this.c = true;
        c cVar = this.b;
        I i5 = this.f8661a;
        if (cVar != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                i5.onError(th);
                return;
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                a.onError(new p017c3.c(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            i5.onSubscribe(e.f3970a);
            try {
                i5.onError(new p017c3.c(th, nullPointerException));
            } catch (Throwable th3) {
                p017c3.d.throwIfFatal(th3);
                a.onError(new p017c3.c(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            p017c3.d.throwIfFatal(th4);
            a.onError(new p017c3.c(th, nullPointerException, th4));
        }
    }

    @Override // io.reactivex.I
    public void onNext(Object obj) {
        if (this.c) {
            return;
        }
        c cVar = this.b;
        I i5 = this.f8661a;
        if (cVar == null) {
            this.c = true;
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                i5.onSubscribe(e.f3970a);
                try {
                    i5.onError(nullPointerException);
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
                this.b.dispose();
                onError(nullPointerException2);
                return;
            } catch (Throwable th3) {
                p017c3.d.throwIfFatal(th3);
                onError(new p017c3.c(nullPointerException2, th3));
                return;
            }
        }
        try {
            i5.onNext(obj);
        } catch (Throwable th4) {
            p017c3.d.throwIfFatal(th4);
            try {
                this.b.dispose();
                onError(th4);
            } catch (Throwable th5) {
                p017c3.d.throwIfFatal(th5);
                onError(new p017c3.c(th4, th5));
            }
        }
    }

    @Override // io.reactivex.I
    public void onSubscribe(c cVar) {
        if (p033f3.d.g(this.b, cVar)) {
            this.b = cVar;
            try {
                this.f8661a.onSubscribe(this);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                this.c = true;
                try {
                    cVar.dispose();
                    a.onError(th);
                } catch (Throwable th2) {
                    p017c3.d.throwIfFatal(th2);
                    a.onError(new p017c3.c(th, th2));
                }
            }
        }
    }
}
