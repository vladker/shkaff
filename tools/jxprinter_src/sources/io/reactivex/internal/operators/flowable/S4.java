package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S4 extends AtomicInteger implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = -2365647875069161133L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4429a;
    public final long b;
    public final AtomicBoolean c;
    public final int d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p123v3.d f4431g;

    public S4(t5.c cVar, long j6, int i5) {
        super(1);
        this.f4429a = cVar;
        this.b = j6;
        this.c = new AtomicBoolean();
        this.d = i5;
    }

    @Override // t5.d
    public final void cancel() {
        if (this.c.compareAndSet(false, true)) {
            run();
        }
    }

    @Override // t5.c
    public final void onComplete() {
        p123v3.d dVar = this.f4431g;
        if (dVar != null) {
            this.f4431g = null;
            dVar.onComplete();
        }
        this.f4429a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p123v3.d dVar = this.f4431g;
        if (dVar != null) {
            this.f4431g = null;
            dVar.onError(th);
        }
        this.f4429a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = this.e;
        p123v3.d dVarCreate = this.f4431g;
        if (j6 == 0) {
            getAndIncrement();
            dVarCreate = p123v3.d.create(this.d, this);
            this.f4431g = dVarCreate;
            this.f4429a.onNext(dVarCreate);
        }
        long j7 = j6 + 1;
        dVarCreate.onNext(obj);
        if (j7 != this.b) {
            this.e = j7;
            return;
        }
        this.e = 0L;
        this.f4431g = null;
        dVarCreate.onComplete();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4430f, dVar)) {
            this.f4430f = dVar;
            this.f4429a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            this.f4430f.request(p122v2.a.d(this.b, j6));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (decrementAndGet() == 0) {
            this.f4430f.cancel();
        }
    }
}
