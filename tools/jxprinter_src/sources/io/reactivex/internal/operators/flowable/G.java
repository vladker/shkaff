package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G extends p088p3.k implements t5.d, Runnable, p011b3.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Callable f4244h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TimeUnit f4246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final io.reactivex.N f4247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public t5.d f4248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Collection f4249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicReference f4250n;

    public G(p135x3.c cVar, Callable callable, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        super(cVar, new p083o3.b());
        this.f4250n = new AtomicReference();
        this.f4244h = callable;
        this.f4245i = j6;
        this.f4246j = timeUnit;
        this.f4247k = n6;
    }

    @Override // t5.d
    public final void cancel() {
        this.e = true;
        this.f4248l.cancel();
        p033f3.d.a(this.f4250n);
    }

    @Override // p011b3.c
    public final void dispose() {
        cancel();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.f4250n.get() == p033f3.d.f3969a;
    }

    @Override // p088p3.k
    public final boolean o(Object obj, t5.c cVar) {
        this.c.onNext((Collection) obj);
        return true;
    }

    @Override // t5.c
    public final void onComplete() {
        p033f3.d.a(this.f4250n);
        synchronized (this) {
            try {
                Collection collection = this.f4249m;
                if (collection == null) {
                    return;
                }
                this.f4249m = null;
                this.d.offer(collection);
                this.f7748f = true;
                if (p()) {
                    com.bumptech.glide.f.d(this.d, this.c, null, this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p033f3.d.a(this.f4250n);
        synchronized (this) {
            this.f4249m = null;
        }
        this.c.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        synchronized (this) {
            try {
                Collection collection = this.f4249m;
                if (collection != null) {
                    collection.add(obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4248l, dVar)) {
            this.f4248l = dVar;
            try {
                Object objCall = this.f4244h.call();
                p039g3.A.b(objCall, "The supplied buffer is null");
                this.f4249m = (Collection) objCall;
                this.c.onSubscribe(this);
                if (!this.e) {
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                    io.reactivex.N n6 = this.f4247k;
                    long j6 = this.f4245i;
                    p011b3.c cVarSchedulePeriodicallyDirect = n6.schedulePeriodicallyDirect(this, j6, j6, this.f4246j);
                    AtomicReference atomicReference = this.f4250n;
                    while (!atomicReference.compareAndSet(null, cVarSchedulePeriodicallyDirect)) {
                        if (atomicReference.get() != null) {
                            cVarSchedulePeriodicallyDirect.dispose();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                p094q3.d.e(th, this.c);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Object objCall = this.f4244h.call();
            p039g3.A.b(objCall, "The supplied buffer is null");
            Collection collection = (Collection) objCall;
            synchronized (this) {
                try {
                    Collection collection2 = this.f4249m;
                    if (collection2 == null) {
                        return;
                    }
                    this.f4249m = collection;
                    r(collection2, this);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            cancel();
            this.c.onError(th2);
        }
    }
}
