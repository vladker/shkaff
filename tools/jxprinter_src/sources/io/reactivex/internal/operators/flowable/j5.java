package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j5 extends AtomicReference implements p043h3.a, t5.d {
    private static final long serialVersionUID = -312246233408980075L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4685a;
    public final p027e3.c b;
    public final AtomicReference c = new AtomicReference();
    public final AtomicLong d = new AtomicLong();
    public final AtomicReference e = new AtomicReference();

    public j5(p135x3.c cVar, p027e3.c cVar2) {
        this.f4685a = cVar;
        this.b = cVar2;
    }

    @Override // t5.d
    public final void cancel() {
        p094q3.g.a(this.c);
        p094q3.g.a(this.e);
    }

    @Override // p043h3.a
    public final boolean h(Object obj) {
        p135x3.c cVar = this.f4685a;
        Object obj2 = get();
        if (obj2 != null) {
            try {
                Object objApply = this.b.apply(obj, obj2);
                p039g3.A.b(objApply, "The combiner returned a null value");
                cVar.onNext(objApply);
                return true;
            } catch (Throwable th) {
                p017c3.d.throwIfFatal(th);
                cancel();
                cVar.onError(th);
            }
        }
        return false;
    }

    @Override // t5.c
    public final void onComplete() {
        p094q3.g.a(this.e);
        this.f4685a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p094q3.g.a(this.e);
        this.f4685a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (h(obj)) {
            return;
        }
        ((t5.d) this.c.get()).request(1L);
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.c(this.c, this.d, dVar);
    }

    @Override // t5.d
    public final void request(long j6) {
        p094q3.g.b(this.c, this.d, j6);
    }
}
