package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -1266041316834525931L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u0 f5581a;

    public t0(u0 u0Var) {
        this.f5581a = u0Var;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        u0 u0Var = this.f5581a;
        u0Var.getClass();
        if (d.a(u0Var)) {
            u0Var.f5583a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        u0 u0Var = this.f5581a;
        u0Var.getClass();
        if (d.a(u0Var)) {
            u0Var.f5583a.onError(th);
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
        u0 u0Var = this.f5581a;
        u0Var.getClass();
        if (d.a(u0Var)) {
            u0Var.f5583a.onComplete();
        }
    }
}
