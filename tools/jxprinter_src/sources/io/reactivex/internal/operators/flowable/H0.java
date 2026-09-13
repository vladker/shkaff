package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -3892798459447644106L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I0 f4272a;

    public H0(I0 i1) {
        this.f4272a = i1;
    }

    @Override // t5.c
    public final void onComplete() {
        if (((t5.d) get()) != p094q3.g.f7849a) {
            I0 i1 = this.f4272a;
            i1.b.subscribe((t5.c) i1);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (((t5.d) get()) != p094q3.g.f7849a) {
            this.f4272a.f4281a.onError(th);
        } else {
            io.reactivex.plugins.a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        t5.d dVar = (t5.d) get();
        p094q3.g gVar = p094q3.g.f7849a;
        if (dVar != gVar) {
            lazySet(gVar);
            dVar.cancel();
            I0 i1 = this.f4272a;
            i1.b.subscribe((t5.c) i1);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        if (p094q3.g.e(this, dVar)) {
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
