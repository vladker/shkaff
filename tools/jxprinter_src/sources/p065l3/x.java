package p065l3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = -3051469169682093892L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f5888a;

    public x(y yVar) {
        this.f5888a = yVar;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        y yVar = this.f5888a;
        yVar.f5895k = 0;
        yVar.a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        y yVar = this.f5888a;
        c cVar = yVar.c;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (yVar.f5890f != 3) {
            yVar.f5891g.dispose();
        }
        yVar.f5895k = 0;
        yVar.a();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        y yVar = this.f5888a;
        yVar.f5894j = obj;
        yVar.f5895k = 2;
        yVar.a();
    }
}
