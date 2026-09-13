package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0833z0 extends AtomicLong implements InterfaceC0984q, t5.d {
    private static final long serialVersionUID = 6725975399620862591L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p135x3.c f4848a;
    public final p027e3.o b;
    public t5.d c;
    public final AtomicReference d = new AtomicReference();
    public volatile long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4849f;

    public C0833z0(p135x3.c cVar, p027e3.o oVar) {
        this.f4848a = cVar;
        this.b = oVar;
    }

    @Override // t5.d
    public final void cancel() {
        this.c.cancel();
        p033f3.d.a(this.d);
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.f4849f) {
            return;
        }
        this.f4849f = true;
        AtomicReference atomicReference = this.d;
        p011b3.c cVar = (p011b3.c) atomicReference.get();
        if (p033f3.d.b(cVar)) {
            return;
        }
        ((C0827y0) cVar).a();
        p033f3.d.a(atomicReference);
        this.f4848a.onComplete();
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        p033f3.d.a(this.d);
        this.f4848a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.f4849f) {
            return;
        }
        long j6 = this.e + 1;
        this.e = j6;
        p011b3.c cVar = (p011b3.c) this.d.get();
        if (cVar != null) {
            cVar.dispose();
        }
        try {
            Object objApply = this.b.apply(obj);
            p039g3.A.b(objApply, "The publisher supplied is null");
            t5.b bVar = (t5.b) objApply;
            C0827y0 c0827y0 = new C0827y0(this, j6, obj);
            AtomicReference atomicReference = this.d;
            while (!atomicReference.compareAndSet(cVar, c0827y0)) {
                if (atomicReference.get() != cVar) {
                    return;
                }
            }
            bVar.subscribe(c0827y0);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cancel();
            this.f4848a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.g(this.c, dVar)) {
            this.c = dVar;
            this.f4848a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // t5.d
    public final void request(long j6) {
        if (p094q3.g.f(j6)) {
            p122v2.a.a(this, j6);
        }
    }
}
