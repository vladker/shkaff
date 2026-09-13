package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0874h0 implements io.reactivex.I, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5195a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RunnableC0869g0 f5196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f5197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5198h;

    public C0874h0(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f5195a = eVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e.dispose();
        this.d.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.f5198h) {
            return;
        }
        this.f5198h = true;
        RunnableC0869g0 runnableC0869g0 = this.f5196f;
        if (runnableC0869g0 != null) {
            p033f3.d.a(runnableC0869g0);
        }
        if (runnableC0869g0 != null) {
            runnableC0869g0.run();
        }
        this.f5195a.onComplete();
        this.d.dispose();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5198h) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        RunnableC0869g0 runnableC0869g0 = this.f5196f;
        if (runnableC0869g0 != null) {
            p033f3.d.a(runnableC0869g0);
        }
        this.f5198h = true;
        this.f5195a.onError(th);
        this.d.dispose();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5198h) {
            return;
        }
        long j6 = this.f5197g + 1;
        this.f5197g = j6;
        RunnableC0869g0 runnableC0869g0 = this.f5196f;
        if (runnableC0869g0 != null) {
            p033f3.d.a(runnableC0869g0);
        }
        RunnableC0869g0 runnableC0869g1 = new RunnableC0869g0(obj, j6, this);
        this.f5196f = runnableC0869g1;
        p033f3.d.c(runnableC0869g1, this.d.schedule(runnableC0869g1, this.b, this.c));
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5195a.onSubscribe(this);
        }
    }
}
