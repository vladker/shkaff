package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.Callable;
import p011b3.c;
import p011b3.d;

/* JADX INFO: renamed from: k3.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC1011a0 extends AbstractC0985s implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f5537a;

    public CallableC1011a0(Runnable runnable) {
        this.f5537a = runnable;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        c cVarEmpty = d.empty();
        interfaceC0988v.onSubscribe(cVarEmpty);
        if (cVarEmpty.e()) {
            return;
        }
        try {
            this.f5537a.run();
            if (cVarEmpty.e()) {
                return;
            }
            interfaceC0988v.onComplete();
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
        this.f5537a.run();
        return null;
    }
}
