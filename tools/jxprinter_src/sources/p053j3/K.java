package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = 5176264485428790318L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L f5416a;

    public K(L l6) {
        this.f5416a = l6;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        L l6 = this.f5416a;
        if (l6.c.compareAndSet(false, true)) {
            d.a(l6);
            l6.f5417a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        L l6 = this.f5416a;
        if (!l6.c.compareAndSet(false, true)) {
            a.onError(th);
        } else {
            d.a(l6);
            l6.f5417a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
