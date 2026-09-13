package p077n3;

import io.reactivex.N;
import io.reactivex.S;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I extends AtomicReference implements S, c, Runnable {
    private static final long serialVersionUID = 3528003840217436037L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6268a;
    public final N b;
    public Object c;
    public Throwable d;

    public I(S s6, N n6) {
        this.f6268a = s6;
        this.b = n6;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        this.d = th;
        d.c(this, this.b.scheduleDirect(this));
    }

    @Override // io.reactivex.S
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f6268a.onSubscribe(this);
        }
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        this.c = obj;
        d.c(this, this.b.scheduleDirect(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.d;
        S s6 = this.f6268a;
        if (th != null) {
            s6.onError(th);
        } else {
            s6.onSuccess(this.c);
        }
    }
}
