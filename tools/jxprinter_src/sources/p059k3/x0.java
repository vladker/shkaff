package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 8663801314800248617L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5589a;

    public x0(InterfaceC0988v interfaceC0988v) {
        this.f5589a = interfaceC0988v;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5589a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5589a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5589a.onSuccess(obj);
    }
}
