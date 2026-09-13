package p077n3;

import io.reactivex.N;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W extends AtomicReference implements S, c, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6280a;
    public final N b;
    public c c;

    public W(S s6, N n6) {
        this.f6280a = s6;
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

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6280a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6280a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6280a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.dispose();
    }
}
