package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class H2 extends AtomicReference implements io.reactivex.I, p011b3.c, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f4956a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p011b3.c f4957f;

    public H2(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f4956a = eVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    public abstract void a();

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.e);
        this.f4957f.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4957f.e();
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        p033f3.d.a(this.e);
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        p033f3.d.a(this.e);
        this.f4956a.onError(th);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f4957f, cVar)) {
            this.f4957f = cVar;
            this.f4956a.onSubscribe(this);
            long j6 = this.b;
            p033f3.d.c(this.e, this.d.schedulePeriodicallyDirect(this, j6, j6, this.c));
        }
    }
}
