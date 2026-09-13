package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.b;
import p011b3.c;
import p033f3.d;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = 251330541679988317L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f5403a;

    public A(B b) {
        this.f5403a = b;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        B b = this.f5403a;
        InterfaceC0679f interfaceC0679f = b.f5404a;
        b.e.delete(this);
        if (b.decrementAndGet() != 0) {
            if (b.b != Integer.MAX_VALUE) {
                b.f5405f.request(1L);
            }
        } else {
            Throwable th = (Throwable) b.d.get();
            if (th != null) {
                interfaceC0679f.onError(th);
            } else {
                interfaceC0679f.onComplete();
            }
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        B b = this.f5403a;
        InterfaceC0679f interfaceC0679f = b.f5404a;
        p100r3.c cVar = b.d;
        b bVar = b.e;
        bVar.delete(this);
        if (!b.c) {
            b.f5405f.cancel();
            bVar.dispose();
            cVar.getClass();
            if (!g.a(cVar, th)) {
                a.onError(th);
                return;
            } else {
                if (b.getAndSet(0) > 0) {
                    interfaceC0679f.onError(g.b(cVar));
                    return;
                }
                return;
            }
        }
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
        } else if (b.decrementAndGet() == 0) {
            interfaceC0679f.onError(g.b(cVar));
        } else if (b.b != Integer.MAX_VALUE) {
            b.f5405f.request(1L);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
