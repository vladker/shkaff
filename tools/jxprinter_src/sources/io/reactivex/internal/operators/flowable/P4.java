package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P4 extends AtomicBoolean implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 1015244841293359600L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4415a;
    public final io.reactivex.N b;
    public t5.d c;

    public P4(t5.c cVar, io.reactivex.N n6) {
        this.f4415a = cVar;
        this.b = n6;
    }

    @Override // t5.d
    public final void cancel() {
        if (compareAndSet(false, true)) {
            this.b.scheduleDirect(new H2.c(this, 15));
        }
    }

    @Override // t5.c
    public final void onComplete() {
        if (get()) {
            return;
        }
        this.f4415a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (get()) {
            io.reactivex.plugins.a.onError(th);
        } else {
            this.f4415a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (get()) {
            return;
        }
        this.f4415a.onNext(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4415a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.c.request(j6);
    }
}
