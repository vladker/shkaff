package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0889k0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5220a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f5221f;

    public C0889k0(io.reactivex.I i5, long j6, TimeUnit timeUnit, io.reactivex.M m6, boolean z6) {
        this.f5220a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
        this.e = z6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5221f.dispose();
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.d.schedule(new H2.c(this, 16), this.b, this.c);
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.d.schedule(new Q0.b(this, 15, th, false), this.e ? this.b : 0L, this.c);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.d.schedule(new Q0.b(this, 16, obj, false), this.b, this.c);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5221f, cVar)) {
            this.f5221f = cVar;
            this.f5220a.onSubscribe(this);
        }
    }
}
