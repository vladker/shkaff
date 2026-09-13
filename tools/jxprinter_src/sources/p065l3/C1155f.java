package p065l3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: l3.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1155f extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -3051469169682093892L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1156g f5830a;

    public C1155f(C1156g c1156g) {
        this.f5830a = c1156g;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        C1156g c1156g = this.f5830a;
        c1156g.f5841o = 0;
        c1156g.a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        C1156g c1156g = this.f5830a;
        c cVar = c1156g.e;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (c1156g.f5834h != 3) {
            c1156g.f5835i.cancel();
        }
        c1156g.f5841o = 0;
        c1156g.a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        C1156g c1156g = this.f5830a;
        c1156g.f5840n = obj;
        c1156g.f5841o = 2;
        c1156g.a();
    }
}
