package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U4 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = -8792836352386833856L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4465a;
    public final long b;
    public final long c;
    public final AtomicBoolean d;
    public final AtomicBoolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t5.d f4468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p123v3.d f4469i;

    public U4(t5.c cVar, long j6, long j7, int i5) {
        super(1);
        this.f4465a = cVar;
        this.b = j6;
        this.c = j7;
        this.d = new AtomicBoolean();
        this.e = new AtomicBoolean();
        this.f4466f = i5;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.d.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        p123v3.d dVar = this.f4469i;
        if (dVar != null) {
            this.f4469i = null;
            dVar.onComplete();
        }
        this.f4465a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p123v3.d dVar = this.f4469i;
        if (dVar != null) {
            this.f4469i = null;
            dVar.onError(th);
        }
        this.f4465a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = this.f4467g;
        p123v3.d dVarCreate = this.f4469i;
        if (j6 == 0) {
            getAndIncrement();
            dVarCreate = p123v3.d.create(this.f4466f, this);
            this.f4469i = dVarCreate;
            this.f4465a.onNext(dVarCreate);
        }
        long j7 = j6 + 1;
        if (dVarCreate != null) {
            dVarCreate.onNext(obj);
        }
        if (j7 == this.b) {
            this.f4469i = null;
            dVarCreate.onComplete();
        }
        if (j7 == this.c) {
            this.f4467g = 0L;
        } else {
            this.f4467g = j7;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4468h, dVar)) {
            this.f4468h = dVar;
            this.f4465a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            AtomicBoolean atomicBoolean = this.e;
            boolean z6 = atomicBoolean.get();
            long j7 = this.c;
            if (z6 || !atomicBoolean.compareAndSet(false, true)) {
                this.f4468h.request(p122v2.a.d(j7, j6));
            } else {
                long j8 = this.b;
                this.f4468h.request(p122v2.a.c(p122v2.a.d(j8, j6), p122v2.a.d(j7 - j8, j6 - 1)));
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f4468h.cancel();
        }
    }
}
