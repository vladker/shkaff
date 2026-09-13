package io.reactivex.internal.operators.flowable;

import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F0 implements InterfaceC0984q, t5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4229a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.M d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t5.d f4230f;

    public F0(t5.c cVar, long j6, TimeUnit timeUnit, io.reactivex.M m6, boolean z6) {
        this.f4229a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = m6;
        this.e = z6;
    }

    @Override // t5.d
    public final void cancel() {
        this.f4230f.cancel();
        this.d.dispose();
    }

    @Override // t5.c
    public final void onComplete() {
        this.d.schedule(new H2.c(this, 14), this.b, this.c);
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.d.schedule(new Q0.b(this, 12, th, false), this.e ? this.b : 0L, this.c);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d.schedule(new Q0.b(this, 13, obj, false), this.b, this.c);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4230f, dVar)) {
            this.f4230f = dVar;
            this.f4229a.onSubscribe(this);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        this.f4230f.request(j6);
    }
}
