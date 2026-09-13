package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = -2223459372976438024L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5577a;
    public final y b;

    public q0(InterfaceC0988v interfaceC0988v, y yVar) {
        this.f5577a = interfaceC0988v;
        this.b = yVar;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        c cVar = (c) get();
        if (cVar == d.f3969a || !compareAndSet(cVar, null)) {
            return;
        }
        ((AbstractC0985s) this.b).subscribe(new C1044v(this.f5577a, this, 3));
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5577a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5577a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5577a.onSuccess(obj);
    }
}
