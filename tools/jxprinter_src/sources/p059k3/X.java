package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.Callable;
import p011b3.c;
import p011b3.d;
import p027e3.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X extends AbstractC0985s implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5533a;

    public X(a aVar) {
        this.f5533a = aVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        c cVarEmpty = d.empty();
        interfaceC0988v.onSubscribe(cVarEmpty);
        if (cVarEmpty.e()) {
            return;
        }
        try {
            this.f5533a.run();
            if (cVarEmpty.e()) {
                return;
            }
            interfaceC0988v.onComplete();
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            if (cVarEmpty.e()) {
                io.reactivex.plugins.a.onError(th);
            } else {
                interfaceC0988v.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        this.f5533a.run();
        return null;
    }
}
