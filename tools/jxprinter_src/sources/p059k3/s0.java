package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.V;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p048i3.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 4603919676453758899L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f5580a;
    public final V b;

    public s0(S s6, V v6) {
        this.f5580a = s6;
        this.b = v6;
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
        ((O) this.b).subscribe(new t(this.f5580a, (Object) this, 3));
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5580a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5580a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5580a.onSuccess(obj);
    }
}
