package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class K2 extends AtomicReference implements io.reactivex.I, p011b3.c {
    private static final long serialVersionUID = -3517602651313910099L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5000a;
    public final io.reactivex.G b;
    public final AtomicReference c = new AtomicReference();
    public p011b3.c d;

    public K2(p112t3.e eVar, io.reactivex.G g6) {
        this.f5000a = eVar;
        this.b = g6;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.c);
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.a(this.c);
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.c);
        this.f5000a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.d, cVar)) {
            this.d = cVar;
            this.f5000a.onSubscribe(this);
            if (this.c.get() == null) {
                this.b.subscribe(new C0899m0(this, 1));
            }
        }
    }
}
