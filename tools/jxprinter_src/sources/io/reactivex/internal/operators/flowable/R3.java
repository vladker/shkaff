package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class R3 extends AtomicReference implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = -3517602651313910099L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4422a;
    public final t5.b b;
    public final AtomicLong c = new AtomicLong();
    public final AtomicReference d = new AtomicReference();
    public t5.d e;

    public R3(p135x3.c cVar, t5.b bVar) {
        this.f4422a = cVar;
        this.b = bVar;
    }

    public abstract void a();

    public abstract void b();

    public final void c() {
        Object andSet = getAndSet(null);
        if (andSet != null) {
            AtomicLong atomicLong = this.c;
            long j6 = atomicLong.get();
            p135x3.c cVar = this.f4422a;
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
        p094q3.g.a(this.d);
        this.e.cancel();
    }

    public abstract void d();

    @Override // t5.c
    public final void onComplete() {
        p094q3.g.a(this.d);
        a();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p094q3.g.a(this.d);
        this.f4422a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        lazySet(obj);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.e, dVar)) {
            this.e = dVar;
            this.f4422a.onSubscribe(this);
            if (this.d.get() == null) {
                this.b.subscribe(new S3(this, 0));
                dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
            }
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this.c, j6);
        }
    }
}
