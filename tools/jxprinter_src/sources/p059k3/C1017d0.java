package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p011b3.d;
import p043h3.h;

/* JADX INFO: renamed from: k3.d0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1017d0 extends AbstractC0985s implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5544a;

    public C1017d0(Object obj) {
        this.f5544a = obj;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        interfaceC0988v.onSubscribe(d.disposed());
        interfaceC0988v.onSuccess(this.f5544a);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f5544a;
    }
}
