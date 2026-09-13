package p059k3;

import io.reactivex.InterfaceC0988v;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p033f3.d;

/* JADX INFO: renamed from: k3.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1043u extends AtomicReference implements InterfaceC0988v {
    private static final long serialVersionUID = 706635022205076709L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5582a;

    public C1043u(InterfaceC0988v interfaceC0988v) {
        this.f5582a = interfaceC0988v;
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        this.f5582a.onComplete();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        this.f5582a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        d.f(this, cVar);
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        this.f5582a.onSuccess(obj);
    }
}
