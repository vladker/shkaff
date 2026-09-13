package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = -5955289211445418871L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5590a;
    public final z0 b = new z0(this);
    public final y c;
    public final x0 d;

    public y0(InterfaceC0988v interfaceC0988v, y yVar) {
        this.f5590a = interfaceC0988v;
        this.c = yVar;
        this.d = yVar != null ? new x0(interfaceC0988v) : null;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        d.a(this.b);
        x0 x0Var = this.d;
        if (x0Var != null) {
            d.a(x0Var);
        }
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
            this.f5590a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        d.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5590a.onError(th);
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
            this.f5590a.onSuccess(obj);
        }
    }
}
