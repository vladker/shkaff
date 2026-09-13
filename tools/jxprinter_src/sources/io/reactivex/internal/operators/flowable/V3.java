package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class V3 extends AtomicReference implements InterfaceC0984q, t5.d, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4483a;
    public final long b;
    public final TimeUnit c;
    public final io.reactivex.N d;
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p033f3.h f4484f = new p033f3.h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t5.d f4485g;

    public V3(p135x3.c cVar, long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.f4483a = cVar;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    public abstract void a();

    public final void b() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            AtomicLong atomicLong = this.e;
            long j6 = atomicLong.get();
            p135x3.c cVar = this.f4483a;
            if (j6 != 0) {
                cVar.onNext(andSet);
                p122v2.a.e(atomicLong, 1L);
            } else {
                cancel();
                cVar.onError(new p017c3.e("Couldn't emit value due to lack of requests!"));
            }
        }
    }

    @Override // t5.d
    public final void cancel() {
        p033f3.d.a(this.f4484f);
        this.f4485g.cancel();
    }

    @Override // t5.c
    public final void onComplete() {
        p033f3.d.a(this.f4484f);
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p033f3.d.a(this.f4484f);
        this.f4483a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.f4485g, dVar)) {
            this.f4485g = dVar;
            this.f4483a.onSubscribe(this);
            long j6 = this.b;
            p011b3.c cVarSchedulePeriodicallyDirect = this.d.schedulePeriodicallyDirect(this, j6, j6, this.c);
            p033f3.h hVar = this.f4484f;
            hVar.getClass();
            p033f3.d.c(hVar, cVarSchedulePeriodicallyDirect);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.e, j6);
        }
    }

    public void run() {
        b();
    }
}
