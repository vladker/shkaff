package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = -8296689127439125014L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4199a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReference f4200f = new AtomicReference();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicLong f4201g = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t5.d f4202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f4203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f4204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f4205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f4206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4207m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4208n;

    public C4(t5.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6, boolean z6) {
        this.f4199a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
        this.e = z6;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f4200f;
        AtomicLong atomicLong = this.f4201g;
        t5.c cVar = this.f4199a;
        int iAddAndGet = 1;
        while (!this.f4205k) {
            boolean z6 = this.f4203i;
            if (z6 && this.f4204j != null) {
                atomicReference.lazySet(null);
                cVar.onError(this.f4204j);
                this.d.dispose();
                return;
            }
            boolean z7 = atomicReference.get() == null;
            if (z6) {
                if (z7 || !this.e) {
                    atomicReference.lazySet(null);
                    cVar.onComplete();
                } else {
                    Object andSet = atomicReference.getAndSet(null);
                    long j6 = this.f4207m;
                    if (j6 != atomicLong.get()) {
                        this.f4207m = j6 + 1;
                        cVar.onNext(andSet);
                        cVar.onComplete();
                    } else {
                        cVar.onError(new p017c3.e("Could not emit final value due to lack of requests"));
                    }
                }
                this.d.dispose();
                return;
            }
            if (z7) {
                if (this.f4206l) {
                    this.f4208n = false;
                    this.f4206l = false;
                }
            } else if (!this.f4208n || this.f4206l) {
                Object andSet2 = atomicReference.getAndSet(null);
                long j7 = this.f4207m;
                if (j7 == atomicLong.get()) {
                    this.f4202h.cancel();
                    cVar.onError(new p017c3.e("Could not emit value due to lack of requests"));
                    this.d.dispose();
                    return;
                } else {
                    cVar.onNext(andSet2);
                    this.f4207m = j7 + 1;
                    this.f4206l = false;
                    this.f4208n = true;
                    this.d.schedule(this, this.b, this.c);
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        atomicReference.lazySet(null);
    }

    @Override // t5.d
    public final void cancel() {
        this.f4205k = true;
        this.f4202h.cancel();
        this.d.dispose();
        if (getAndIncrement() == 0) {
            this.f4200f.lazySet(null);
        }
    }

    @Override // t5.c
    public final void onComplete() {
        this.f4203i = true;
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f4204j = th;
        this.f4203i = true;
        a();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.f4200f.set(obj);
        a();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4202h, dVar)) {
            this.f4202h = dVar;
            this.f4199a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.f4201g, j6);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4206l = true;
        a();
    }
}
