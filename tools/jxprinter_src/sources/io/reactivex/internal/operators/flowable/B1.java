package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class B1 extends AbstractC0979l {
    public final /* synthetic */ int b = 1;
    public final long c;
    public final TimeUnit d;
    public final Object e;

    public B1(long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.c = j6;
        this.d = timeUnit;
        this.e = n6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                Future future = (Future) this.e;
                p094q3.c cVar2 = new p094q3.c(cVar);
                cVar.onSubscribe(cVar2);
                try {
                    TimeUnit timeUnit = this.d;
                    Object obj = timeUnit != null ? future.get(this.c, timeUnit) : future.get();
                    if (obj != null) {
                        cVar2.e(obj);
                    } else {
                        cVar.onError(new NullPointerException("The future returned null"));
                    }
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    if (cVar2.get() == 4) {
                        return;
                    }
                    cVar.onError(th);
                    return;
                }
                break;
            default:
                N4 n6 = new N4(cVar);
                cVar.onSubscribe(n6);
                p011b3.c cVarScheduleDirect = ((io.reactivex.N) this.e).scheduleDirect(n6, this.c, this.d);
                while (!n6.compareAndSet(null, cVarScheduleDirect)) {
                    if (n6.get() != null) {
                        if (n6.get() == p033f3.d.f3969a) {
                            cVarScheduleDirect.dispose();
                        }
                        break;
                    }
                }
                break;
        }
    }

    public B1(Future future, long j6, TimeUnit timeUnit) {
        this.e = future;
        this.c = j6;
        this.d = timeUnit;
    }
}
