package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p011b3.c;
import p011b3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z extends AbstractC0985s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5535a = 1;
    public final long b;
    public final TimeUnit c;
    public final Object d;

    public Z(long j6, TimeUnit timeUnit, N n6) {
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.f5535a) {
            case 0:
                Future future = (Future) this.d;
                c cVarEmpty = d.empty();
                interfaceC0988v.onSubscribe(cVarEmpty);
                if (!cVarEmpty.e()) {
                    try {
                        long j6 = this.b;
                        Object obj = j6 <= 0 ? future.get() : future.get(j6, this.c);
                        if (!cVarEmpty.e()) {
                            if (obj != null) {
                                interfaceC0988v.onSuccess(obj);
                            } else {
                                interfaceC0988v.onComplete();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (th instanceof ExecutionException) {
                            th = th.getCause();
                        }
                        p017c3.d.throwIfFatal(th);
                        if (cVarEmpty.e()) {
                            return;
                        }
                        interfaceC0988v.onError(th);
                        return;
                    }
                }
                break;
            default:
                D0 d1 = new D0(interfaceC0988v);
                interfaceC0988v.onSubscribe(d1);
                p033f3.d.c(d1, ((N) this.d).scheduleDirect(d1, this.b, this.c));
                break;
        }
    }

    public Z(Future future, long j6, TimeUnit timeUnit) {
        this.d = future;
        this.b = j6;
        this.c = timeUnit;
    }
}
