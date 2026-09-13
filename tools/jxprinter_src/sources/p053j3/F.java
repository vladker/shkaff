package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends AtomicReference implements InterfaceC0679f, c, Runnable {
    private static final long serialVersionUID = 8571289934935992137L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5409a;
    public final N b;
    public Throwable c;

    public F(InterfaceC0679f interfaceC0679f, N n6) {
        this.f5409a = interfaceC0679f;
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

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        d.c(this, this.b.scheduleDirect(this));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        this.c = th;
        d.c(this, this.b.scheduleDirect(this));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.f(this, cVar)) {
            this.f5409a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.c;
        InterfaceC0679f interfaceC0679f = this.f5409a;
        if (th == null) {
            interfaceC0679f.onComplete();
        } else {
            this.c = null;
            interfaceC0679f.onError(th);
        }
    }
}
