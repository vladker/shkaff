package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.i3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0882i3 extends AtomicReference implements io.reactivex.I, p011b3.c, Runnable {
    private static final long serialVersionUID = 786994795061867455L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p112t3.e f5204a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public p011b3.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5206g;

    public RunnableC0882i3(p112t3.e eVar, long j6, TimeUnit timeUnit, io.reactivex.M m6) {
        this.f5204a = eVar;
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
        if (this.f5206g) {
            return;
        }
        this.f5206g = true;
        this.f5204a.onComplete();
        this.d.dispose();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.f5206g) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        this.f5206g = true;
        this.f5204a.onError(th);
        this.d.dispose();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        if (this.f5205f || this.f5206g) {
            return;
        }
        this.f5205f = true;
        this.f5204a.onNext(obj);
        p011b3.c cVar = (p011b3.c) get();
        if (cVar != null) {
            cVar.dispose();
        }
        p033f3.d.c(this, this.d.schedule(this, this.b, this.c));
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.e, cVar)) {
            this.e = cVar;
            this.f5204a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5205f = false;
    }
}
