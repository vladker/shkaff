package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H0 extends AtomicReference implements InterfaceC0988v, c, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5513a;
    public final N b;
    public c c;

    public H0(InterfaceC0988v interfaceC0988v, N n6) {
        this.f5513a = interfaceC0988v;
        this.b = n6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d dVar = d.f3969a;
        c cVar = (c) getAndSet(dVar);
        if (cVar != dVar) {
            this.c = cVar;
            this.b.scheduleDirect(this);
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5513a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5513a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5513a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5513a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.dispose();
    }
}
