package p065l3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = 5638352172918776687L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f5880a;

    public v(w wVar) {
        this.f5880a = wVar;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        w wVar = this.f5880a;
        wVar.f5885i = false;
        wVar.a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        w wVar = this.f5880a;
        c cVar = wVar.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (wVar.c != 1) {
            wVar.f5885i = false;
            wVar.a();
            return;
        }
        wVar.f5887k = true;
        wVar.f5884h.dispose();
        c cVar2 = wVar.d;
        cVar2.getClass();
        Throwable thB = g.b(cVar2);
        if (thB != g.f7961a) {
            wVar.f5881a.onError(thB);
        }
        if (wVar.getAndIncrement() == 0) {
            wVar.f5883g.clear();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }
}
