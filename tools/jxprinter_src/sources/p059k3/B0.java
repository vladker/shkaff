package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B0 extends AtomicReference implements InterfaceC0988v, c {
    private static final long serialVersionUID = -5955289211445418871L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5504a;
    public final C0 b = new C0(this);
    public final y c;
    public final A0 d;

    public B0(InterfaceC0988v interfaceC0988v, y yVar) {
        this.f5504a = interfaceC0988v;
        this.c = yVar;
        this.d = yVar != null ? new A0(interfaceC0988v) : null;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        g.a(this.b);
        A0 a6 = this.d;
        if (a6 != null) {
            d.a(a6);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        g.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5504a.onComplete();
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        g.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5504a.onError(th);
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
        g.a(this.b);
        d dVar = d.f3969a;
        if (getAndSet(dVar) != dVar) {
            this.f5504a.onSuccess(obj);
        }
    }
}
