package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0938u0 extends p048i3.b implements io.reactivex.I {
    private static final long serialVersionUID = 4109457741734051389L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5285a;
    public final p027e3.a b;
    public p011b3.c c;
    public p043h3.e d;
    public boolean e;

    public C0938u0(io.reactivex.I i5, p027e3.a aVar) {
        this.f5285a = i5;
        this.b = aVar;
    }

    public final void a() {
        if (compareAndSet(0, 1)) {
            try {
                this.b.run();
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                io.reactivex.plugins.a.onError(th);
            }
        }
    }

    @Override // p043h3.f
    public final int c(int i5) {
        p043h3.e eVar = this.d;
        if (eVar == null || (i5 & 4) != 0) {
            return 0;
        }
        int iC = eVar.c(i5);
        if (iC != 0) {
            this.e = iC == 1;
        }
        return iC;
    }

    @Override // p043h3.j
    public final void clear() {
        this.d.clear();
    }

    @Override // p011b3.c
    public final void dispose() {
        this.c.dispose();
        a();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.c.e();
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5285a.onComplete();
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5285a.onError(th);
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5285a.onNext(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.c, cVar)) {
            this.c = cVar;
            if (cVar instanceof p043h3.e) {
                this.d = (p043h3.e) cVar;
            }
            this.f5285a.onSubscribe(this);
        }
    }

    @Override // p048i3.b, p043h3.e, p043h3.f, p043h3.j
    public Object poll() {
        Object objPoll = this.d.poll();
        if (objPoll == null && this.e) {
            a();
        }
        return objPoll;
    }
}
