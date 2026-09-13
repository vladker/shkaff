package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends AtomicReference implements InterfaceC0679f, c, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5415a;
    public final h b = new h();
    public final AbstractC0676c c;

    public J(AbstractC0676c abstractC0676c, InterfaceC0679f interfaceC0679f) {
        this.f5415a = interfaceC0679f;
        this.c = abstractC0676c;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        h hVar = this.b;
        hVar.getClass();
        d.a(hVar);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5415a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.f5415a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(this);
    }
}
