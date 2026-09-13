package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.Callable;
import p011b3.c;
import p011b3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y extends AbstractC0985s implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f5534a;

    public Y(Callable callable) {
        this.f5534a = callable;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        c cVarEmpty = d.empty();
        interfaceC0988v.onSubscribe(cVarEmpty);
        if (cVarEmpty.e()) {
            return;
        }
        try {
            Object objCall = this.f5534a.call();
            if (cVarEmpty.e()) {
                return;
            }
            if (objCall == null) {
                interfaceC0988v.onComplete();
            } else {
                interfaceC0988v.onSuccess(objCall);
            }
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            if (cVarEmpty.e()) {
                a.onError(th);
            } else {
                interfaceC0988v.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f5534a.call();
    }
}
