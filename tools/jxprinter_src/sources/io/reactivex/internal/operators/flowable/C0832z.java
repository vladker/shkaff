package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0832z extends AtomicReference implements InterfaceC0984q, p011b3.c {
    private static final long serialVersionUID = -8498650778633225126L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0826y f4847a;
    public final long b;

    public C0832z(C0826y c0826y, long j6) {
        this.f4847a = c0826y;
        this.b = j6;
    }

    @Override // p011b3.c
    public final void dispose() {
        p094q3.g.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == p094q3.g.f7849a;
    }

    @Override // t5.c
    public final void onComplete() {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj != gVar) {
            lazySet(gVar);
            this.f4847a.a(this, this.b);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        Object obj = get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (obj == gVar) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        lazySet(gVar);
        C0826y c0826y = this.f4847a;
        p094q3.g.a(c0826y.f4834g);
        c0826y.e.delete(this);
        c0826y.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        t5.d dVar = (t5.d) get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar != gVar) {
            lazySet(gVar);
            dVar.cancel();
            this.f4847a.a(this, this.b);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        p094q3.g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
