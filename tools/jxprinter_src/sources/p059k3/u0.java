package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = -2187421758664251153L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5583a;
    public final t0 b = new t0(this);

    public u0(InterfaceC0988v interfaceC0988v) {
        this.f5583a = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        d.a(this.b);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        d.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5583a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        d.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5583a.onError(th);
        } else {
            a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        d.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5583a.onSuccess(obj);
        }
    }
}
