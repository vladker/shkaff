package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = 8571289934935992137L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5576a = new h();
    public final InterfaceC0988v b;

    public p0(InterfaceC0988v interfaceC0988v) {
        this.b = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        h hVar = this.f5576a;
        hVar.getClass();
        d.a(hVar);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.b.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.b.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.b.onSuccess(obj);
    }
}
