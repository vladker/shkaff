package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E4 extends AtomicReference implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = 8708641127342403073L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Number f4217a;
    public final long b;

    /* JADX WARN: Multi-variable type inference failed */
    public E4(long j6, G4 g6) {
        this.b = j6;
        this.f4217a = (Number) g6;
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.internal.operators.flowable.L4, java.lang.Number] */
    @Override // t5.c
    public final void onComplete() {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj != gVar) {
            lazySet(gVar);
            this.f4217a.b(this.b);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.internal.operators.flowable.G4, java.lang.Number] */
    @Override // t5.c
    public final void onError(Throwable th) {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj == gVar) {
            io.reactivex.plugins.a.onError(th);
        } else {
            lazySet(gVar);
            this.f4217a.a(this.b, th);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [io.reactivex.internal.operators.flowable.L4, java.lang.Number] */
    @Override // t5.c
    public final void onNext(Object obj) {
        t5.d dVar = (t5.d) get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar != gVar) {
            dVar.cancel();
            lazySet(gVar);
            this.f4217a.b(this.b);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
