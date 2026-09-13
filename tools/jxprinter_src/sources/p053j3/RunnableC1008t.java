package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.N;
import io.reactivex.plugins.a;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: j3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC1008t implements InterfaceC0679f, c, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0679f f5453a;
    public final N b;
    public c c;
    public volatile boolean d;

    public RunnableC1008t(InterfaceC0679f interfaceC0679f, N n6) {
        this.f5453a = interfaceC0679f;
        this.b = n6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d = true;
        this.b.scheduleDirect(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.d;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.f5453a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        if (this.d) {
            a.onError(th);
        } else {
            this.f5453a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        if (d.g(this.c, cVar)) {
            this.c = cVar;
            this.f5453a.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.dispose();
        this.c = d.f3969a;
    }
}
