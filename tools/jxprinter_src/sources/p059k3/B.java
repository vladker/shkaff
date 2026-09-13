package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p033f3.e;
import p043h3.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B extends AbstractC0985s implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B f5503a = new B();

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        interfaceC0988v.onSubscribe(e.f3970a);
        interfaceC0988v.onComplete();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return null;
    }
}
