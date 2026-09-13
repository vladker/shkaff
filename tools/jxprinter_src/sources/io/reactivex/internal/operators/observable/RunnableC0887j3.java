package io.reactivex.internal.operators.observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC0887j3 extends AtomicInteger implements io.reactivex.I, p011b3.c, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5211a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f5212f = new AtomicReference();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p011b3.c f5213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f5214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Throwable f5215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f5217k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5218l;

    public RunnableC0887j3(io.reactivex.I i5, long j6, TimeUnit timeUnit, io.reactivex.M m6, boolean z6) {
        this.f5211a = i5;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
        this.e = z6;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f5212f;
        io.reactivex.I i5 = this.f5211a;
        int iAddAndGet = 1;
        while (!this.f5216j) {
            boolean z6 = this.f5214h;
            if (z6 && this.f5215i != null) {
                atomicReference.lazySet(null);
                i5.onError(this.f5215i);
                this.d.dispose();
                return;
            }
            boolean z7 = atomicReference.get() == null;
            if (z6) {
                Object andSet = atomicReference.getAndSet(null);
                if (!z7 && this.e) {
                    i5.onNext(andSet);
                }
                i5.onComplete();
                this.d.dispose();
                return;
            }
            if (z7) {
                if (this.f5217k) {
                    this.f5218l = false;
                    this.f5217k = false;
                }
            } else if (!this.f5218l || this.f5217k) {
                i5.onNext(atomicReference.getAndSet(null));
                this.f5217k = false;
                this.f5218l = true;
                this.d.schedule(this, this.b, this.c);
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // p011b3.c
    public final void dispose() {
        this.f5216j = true;
        this.f5213g.dispose();
        this.d.dispose();
        if (getAndIncrement() == 0) {
            this.f5212f.lazySet(null);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f5216j;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        this.f5214h = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        this.f5215i = th;
        this.f5214h = true;
        a();
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        this.f5212f.set(obj);
        a();
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f5213g, cVar)) {
            this.f5213g = cVar;
            this.f5211a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5217k = true;
        a();
    }
}
