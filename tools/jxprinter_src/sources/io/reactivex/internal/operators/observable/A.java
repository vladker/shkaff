package io.reactivex.internal.operators.observable;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends p048i3.s implements Runnable, p011b3.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable f4854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TimeUnit f4856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final io.reactivex.N f4857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p011b3.c f4858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Collection f4859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference f4860m;

    public A(p112t3.e eVar, Callable callable, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        super(eVar, new p083o3.b());
        this.f4860m = new AtomicReference();
        this.f4854g = callable;
        this.f4855h = j6;
        this.f4856i = timeUnit;
        this.f4857j = n6;
    }

    @Override // p048i3.s
    public final void b(io.reactivex.I i5, Object obj) {
        this.b.onNext((Collection) obj);
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.f4860m);
        this.f4858k.dispose();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4860m.get() == p033f3.d.f3969a;
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        Collection collection;
        synchronized (this) {
            collection = this.f4859l;
            this.f4859l = null;
        }
        if (collection != null) {
            this.c.offer(collection);
            this.e = true;
            if (c()) {
                com.bumptech.glide.f.c(this.c, this.b, null, this);
            }
        }
        p033f3.d.a(this.f4860m);
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onError(Throwable th) {
        synchronized (this) {
            this.f4859l = null;
        }
        this.b.onError(th);
        p033f3.d.a(this.f4860m);
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f4859l;
                if (collection == null) {
                    return;
                }
                collection.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p048i3.s, io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        if (p033f3.d.g(this.f4858k, cVar)) {
            this.f4858k = cVar;
            try {
                Object objCall = this.f4854g.call();
                p039g3.A.b(objCall, "The buffer supplied is null");
                this.f4859l = (Collection) objCall;
                this.b.onSubscribe(this);
                if (!this.d) {
                    io.reactivex.N n6 = this.f4857j;
                    long j6 = this.f4855h;
                    p011b3.c cVarSchedulePeriodicallyDirect = n6.schedulePeriodicallyDirect(this, j6, j6, this.f4856i);
                    AtomicReference atomicReference = this.f4860m;
                    while (!atomicReference.compareAndSet(null, cVarSchedulePeriodicallyDirect)) {
                        if (atomicReference.get() != null) {
                            cVarSchedulePeriodicallyDirect.dispose();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                dispose();
                p033f3.e.a(th, this.b);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Collection collection;
        try {
            Object objCall = this.f4854g.call();
            p039g3.A.b(objCall, "The bufferSupplier returned a null buffer");
            Collection collection2 = (Collection) objCall;
            synchronized (this) {
                try {
                    collection = this.f4859l;
                    if (collection != null) {
                        this.f4859l = collection2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (collection == null) {
                p033f3.d.a(this.f4860m);
            } else {
                f(collection, this);
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            this.b.onError(th2);
            dispose();
        }
    }
}
