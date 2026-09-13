package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M extends AtomicReference implements S, c {
    private static final long serialVersionUID = -622603812305745221L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6272a;
    public final N b = new N(this);

    public M(S s6) {
        this.f6272a = s6;
    }

    public final void a(Throwable th) {
        c cVar;
        c cVar2 = (c) get();
        d dVar = d.f3969a;
        if (cVar2 == dVar || (cVar = (c) getAndSet(dVar)) == dVar) {
            a.onError(th);
            return;
        }
        if (cVar != null) {
            cVar.dispose();
        }
        this.f6272a.onError(th);
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
        N n6 = this.b;
        n6.getClass();
        g.a(n6);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        N n6 = this.b;
        n6.getClass();
        g.a(n6);
        c cVar = (c) get();
        d dVar = d.f3969a;
        if (cVar == dVar || ((c) getAndSet(dVar)) == dVar) {
            a.onError(th);
        } else {
            this.f6272a.onError(th);
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        N n6 = this.b;
        n6.getClass();
        g.a(n6);
        d dVar = d.f3969a;
        if (((c) getAndSet(dVar)) != dVar) {
            this.f6272a.onSuccess(obj);
        }
    }
}
