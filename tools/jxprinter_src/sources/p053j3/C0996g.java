package p053j3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: j3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0996g extends AtomicReference implements InterfaceC0679f {
    private static final long serialVersionUID = -5454794857847146511L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0997h f5433a;

    public C0996g(C0997h c0997h) {
        this.f5433a = c0997h;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        C0997h c0997h = this.f5433a;
        c0997h.f5440k = false;
        c0997h.a();
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        C0997h c0997h = this.f5433a;
        if (!c0997h.e.compareAndSet(false, true)) {
            a.onError(th);
        } else {
            c0997h.f5438i.cancel();
            c0997h.f5434a.onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.c(this, cVar);
    }
}
