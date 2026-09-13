package p065l3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p033f3.d;
import p100r3.c;
import p100r3.g;

/* JADX INFO: renamed from: l3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1152c extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = 5638352172918776687L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1153d f5820a;

    public C1152c(C1153d c1153d) {
        this.f5820a = c1153d;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        C1153d c1153d = this.f5820a;
        c1153d.f5825i = false;
        c1153d.a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        C1153d c1153d = this.f5820a;
        c cVar = c1153d.d;
        cVar.getClass();
        if (!g.a(cVar, th)) {
            a.onError(th);
            return;
        }
        if (c1153d.c != 1) {
            c1153d.f5825i = false;
            c1153d.a();
            return;
        }
        c1153d.f5824h.cancel();
        c cVar2 = c1153d.d;
        cVar2.getClass();
        Throwable thB = g.b(cVar2);
        if (thB != g.f7961a) {
            c1153d.f5821a.onError(thB);
        }
        if (c1153d.getAndIncrement() == 0) {
            c1153d.f5823g.clear();
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(p011b3.c cVar) {
        d.c(this, cVar);
    }
}
