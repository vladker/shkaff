package p077n3;

import io.reactivex.O;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class L extends AtomicReference implements S, c, Runnable {
    private static final long serialVersionUID = 7000911171163930287L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6271a;
    public final h b = new h();
    public final O c;

    public L(O o6, S s6) {
        this.f6271a = s6;
        this.c = o6;
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

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.f6271a.onError(th);
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.f6271a.onSuccess(obj);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.subscribe(this);
    }
}
