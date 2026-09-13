package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H4 extends AtomicLong implements InterfaceC0984q, t5.d, G4 {
    private static final long serialVersionUID = 3764492702657003550L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t5.c f4276a;
    public final p027e3.o b;
    public final p033f3.h c = new p033f3.h();
    public final AtomicReference d = new AtomicReference();
    public final AtomicLong e = new AtomicLong();

    public H4(t5.c cVar, p027e3.o oVar) {
        this.f4276a = cVar;
        this.b = oVar;
    }

    @Override // io.reactivex.internal.operators.flowable.G4
    public final void a(long j6, Throwable th) {
        if (!compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            io.reactivex.plugins.a.onError(th);
        } else {
            p094q3.g.a(this.d);
            this.f4276a.onError(th);
        }
    }

    @Override // io.reactivex.internal.operators.flowable.L4
    public final void b(long j6) {
        if (compareAndSet(j6, LocationRequestCompat.PASSIVE_INTERVAL)) {
            p094q3.g.a(this.d);
            this.f4276a.onError(new TimeoutException());
        }
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.d);
        p033f3.h hVar = this.c;
        hVar.getClass();
        p033f3.d.a(hVar);
    }

    @Override // t5.c
    public final void onComplete() {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            p033f3.h hVar = this.c;
            hVar.getClass();
            p033f3.d.a(hVar);
            this.f4276a.onComplete();
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (getAndSet(LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p033f3.h hVar = this.c;
        hVar.getClass();
        p033f3.d.a(hVar);
        this.f4276a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        long j6 = get();
        if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j7 = 1 + j6;
            if (compareAndSet(j6, j7)) {
                p033f3.h hVar = this.c;
                p011b3.c cVar = (p011b3.c) hVar.get();
                if (cVar != null) {
                    cVar.dispose();
                }
                t5.c cVar2 = this.f4276a;
                cVar2.onNext(obj);
                try {
                    Object objApply = this.b.apply(obj);
                    p039g3.A.b(objApply, "The itemTimeoutIndicator returned a null Publisher.");
                    t5.b bVar = (t5.b) objApply;
                    E4 e6 = new E4(j7, this);
                    if (p033f3.d.c(hVar, e6)) {
                        bVar.subscribe(e6);
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    ((t5.d) this.d.get()).cancel();
                    getAndSet(LocationRequestCompat.PASSIVE_INTERVAL);
                    cVar2.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.d, this.e, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.d, this.e, j6);
    }
}
