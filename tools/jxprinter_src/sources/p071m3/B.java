package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = 6751017204873808094L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f6120a;
    public final int b;

    public B(C c, int i5) {
        this.f6120a = c;
        this.b = i5;
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        C c = this.f6120a;
        AtomicReference atomicReference = c.f6125i;
        while (!atomicReference.compareAndSet(null, th)) {
            if (atomicReference.get() != null) {
                if (th != atomicReference.get()) {
                    a.onError(th);
                    return;
                }
                return;
            }
        }
        c.b();
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        int i5 = this.b;
        C c = this.f6120a;
        c.c[i5] = (List) obj;
        if (c.f6124h.decrementAndGet() == 0) {
            c.b();
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // t5.c
    public final void onComplete() {
    }
}
