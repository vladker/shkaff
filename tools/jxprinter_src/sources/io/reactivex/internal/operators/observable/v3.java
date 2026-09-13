package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v3 extends AtomicBoolean implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = 5904473792286235046L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5294a;
    public final Object b;
    public final p027e3.g c;
    public final boolean d;
    public p011b3.c e;

    public v3(io.reactivex.I i5, Object obj, p027e3.g gVar, boolean z6) {
        this.f5294a = i5;
        this.b = obj;
        this.c = gVar;
        this.d = z6;
    }

    public final void a() {
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        a();
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return get();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        boolean z6 = this.d;
        io.reactivex.I i5 = this.f5294a;
        if (!z6) {
            i5.onComplete();
            this.e.dispose();
            a();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                i5.onError(th);
                return;
            }
        }
        this.e.dispose();
        i5.onComplete();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        boolean z6 = this.d;
        io.reactivex.I i5 = this.f5294a;
        if (!z6) {
            i5.onError(th);
            this.e.dispose();
            a();
            return;
        }
        if (compareAndSet(false, true)) {
            try {
                this.c.accept(this.b);
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                th = new p017c3.c(th, th2);
            }
        }
        this.e.dispose();
        i5.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5294a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5294a.onSubscribe(this);
        }
    }
}
