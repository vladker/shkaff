package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class D extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -3031974433025990931L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C f5507a;
    public Object b;

    public D(C c) {
        this.f5507a = c;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5507a.a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        C c = this.f5507a;
        if (c.getAndSet(0) <= 0) {
            a.onError(th);
            return;
        }
        D d = c.b;
        if (this == d) {
            D d6 = c.c;
            d6.getClass();
            d.a(d6);
        } else {
            d.getClass();
            d.a(d);
        }
        c.f5505a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.b = obj;
        this.f5507a.a();
    }
}
