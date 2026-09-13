package p077n3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 5170026210238877381L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final M f6273a;

    public N(M m6) {
        this.f6273a = m6;
    }

    @Override // t5.c
    public final void onComplete() {
        Object obj = get();
        g gVar = g.f7849a;
        if (obj != gVar) {
            lazySet(gVar);
            this.f6273a.a(new CancellationException());
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        this.f6273a.a(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (g.a(this)) {
            this.f6273a.a(new CancellationException());
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
