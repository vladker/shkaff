package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.m3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0902m3 extends AtomicReference implements io.reactivex.I, p011b3.c, InterfaceC0912o3 {
    private static final long serialVersionUID = -7508389464265974549L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.I f5236a;
    public final p027e3.o b;
    public final p033f3.h c = new p033f3.h();
    public final AtomicLong d = new AtomicLong();
    public final AtomicReference e = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public io.reactivex.G f5237f;

    public C0902m3(p027e3.o oVar, io.reactivex.G g6, io.reactivex.I i5) {
        this.f5236a = i5;
        this.b = oVar;
        this.f5237f = g6;
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0912o3
    public final void a(long j6, Throwable th) {
        if (!this.d.compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            p033f3.d.a(this);
            this.f5236a.onError(th);
        }
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0926r3
    public final void b(long j6) {
        if (this.d.compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p033f3.d.a(this.e);
            io.reactivex.G g6 = this.f5237f;
            this.f5237f = null;
            g6.subscribe(new W1(this.f5236a, this, 1));
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        p033f3.d.a(this.e);
        p033f3.d.a(this);
        p033f3.h hVar = this.c;
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((p011b3.c) get());
    }

    @Override // io.reactivex.I
    public final void onComplete() {
        if (this.d.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.c;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f5236a.onComplete();
            hVar.getClass();
            p033f3.d.a(hVar);
        }
    }

    @Override // io.reactivex.I
    public final void onError(Throwable th) {
        if (this.d.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.c;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f5236a.onError(th);
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // io.reactivex.I
    public final void onNext(Object obj) {
        AtomicLong atomicLong = this.d;
        long j6 = atomicLong.get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = 1 + j6;
            if (atomicLong.compareAndSet(j6, j7)) {
                p033f3.h hVar = this.c;
                p011b3.c cVar = (p011b3.c) hVar.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                io.reactivex.I i5 = this.f5236a;
                i5.onNext(obj);
                try {
                    Object objApply = this.b.apply(obj);
                    p039g3.A.b(objApply, "The itemTimeoutIndicator returned a null ObservableSource.");
                    io.reactivex.G g6 = (io.reactivex.G) objApply;
                    C0897l3 c0897l3 = new C0897l3(j7, this);
                    if (p033f3.d.c(hVar, c0897l3)) {
                        g6.subscribe(c0897l3);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    ((p011b3.c) this.e.get()).dispose();
                    atomicLong.getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                    i5.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.I
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this.e, cVar);
    }
}
