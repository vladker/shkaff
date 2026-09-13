package io.reactivex.internal.operators.observable;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0682i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I0 extends p048i3.b implements io.reactivex.I {
    private static final long serialVersionUID = 8443155186132538303L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f4960a;
    public final p027e3.o c;
    public final boolean d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f4961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f4962g;
    public final p100r3.c b = new p100r3.c();
    public final p011b3.b e = new p011b3.b();

    public I0(io.reactivex.I i5, p027e3.o oVar, boolean z6) {
        this.f4960a = i5;
        this.c = oVar;
        this.d = z6;
        lazySet(1);
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f4962g = true;
        this.f4961f.dispose();
        this.e.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4961f.e();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            p100r3.c cVar = this.b;
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            io.reactivex.I i5 = this.f4960a;
            if (thB != null) {
                i5.onError(thB);
            } else {
                i5.onComplete();
            }
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p100r3.c cVar = this.b;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        boolean z6 = this.d;
        io.reactivex.I i5 = this.f4960a;
        if (z6) {
            if (decrementAndGet() == 0) {
                cVar.getClass();
                i5.onError(p100r3.g.b(cVar));
                return;
            }
            return;
        }
        dispose();
        if (getAndSet(0) > 0) {
            cVar.getClass();
            i5.onError(p100r3.g.b(cVar));
        }
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        try {
            Object objApply = this.c.apply(obj);
            p039g3.A.b(objApply, "The mapper returned a null CompletableSource");
            InterfaceC0682i interfaceC0682i = (InterfaceC0682i) objApply;
            getAndIncrement();
            H0 h1 = new H0(this);
            if (this.f4962g || !this.e.add(h1)) {
                return;
            }
            ((AbstractC0676c) interfaceC0682i).subscribe(h1);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            this.f4961f.dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f4961f, cVar)) {
            this.f4961f = cVar;
            this.f4960a.onSubscribe(this);
        }
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        return null;
    }

    @Override // p043h3.j
    public final void clear() {
    }
}
