package p048i3;

import io.reactivex.InterfaceC0679f;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.f;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AtomicReference implements InterfaceC0679f, c {
    private static final long serialVersionUID = -7545121636549663526L;

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
        lazySet(d.f3969a);
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onError(Throwable th) {
        lazySet(d.f3969a);
        a.onError(new f(th));
    }

    @Override // io.reactivex.InterfaceC0679f
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }
}
