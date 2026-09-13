package p048i3;

import io.reactivex.InterfaceC0679f;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.f;
import p027e3.a;
import p027e3.g;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends AtomicReference implements InterfaceC0679f, c, g {
    private static final long serialVersionUID = -4361286194466301354L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4051a;
    public final a b;

    public i(a aVar) {
        this.f4051a = this;
        this.b = aVar;
    }

    @Override // p027e3.g
    public void accept(Object obj) {
        io.reactivex.plugins.a.onError(new f((Throwable) obj));
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() == d.f3969a;
    }

    @Override // io.reactivex.InterfaceC0679f, io.reactivex.InterfaceC0988v
    public final void onComplete() {
        try {
            this.b.run();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            io.reactivex.plugins.a.onError(th);
        }
        lazySet(d.f3969a);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        try {
            this.f4051a.accept(th);
        } catch (Throwable th2) {
            p017c3.d.throwIfFatal(th2);
            io.reactivex.plugins.a.onError(th2);
        }
        lazySet(d.f3969a);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    public i(g gVar, a aVar) {
        this.f4051a = gVar;
        this.b = aVar;
    }
}
