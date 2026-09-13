package io.reactivex.internal.operators.observable;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V0 extends io.reactivex.B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5120a = 1;
    public final long b;
    public final TimeUnit c;
    public final Object d;

    public V0(long j6, TimeUnit timeUnit, io.reactivex.N n6) {
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.f5120a) {
            case 0:
                Future future = (Future) this.d;
                p048i3.k kVar = new p048i3.k(i5);
                i5.onSubscribe(kVar);
                if (!kVar.e()) {
                    try {
                        TimeUnit timeUnit = this.c;
                        Object obj = timeUnit != null ? future.get(this.b, timeUnit) : future.get();
                        p039g3.A.b(obj, "Future returned null");
                        kVar.a(obj);
                    } catch (Throwable th) {
                        p017c3.d.throwIfFatal(th);
                        if (kVar.e()) {
                            return;
                        }
                        i5.onError(th);
                        return;
                    }
                }
                break;
            default:
                RunnableC0936t3 runnableC0936t3 = new RunnableC0936t3(i5);
                i5.onSubscribe(runnableC0936t3);
                p011b3.c cVarScheduleDirect = ((io.reactivex.N) this.d).scheduleDirect(runnableC0936t3, this.b, this.c);
                while (!runnableC0936t3.compareAndSet(null, cVarScheduleDirect)) {
                    if (runnableC0936t3.get() != null) {
                        if (runnableC0936t3.get() == p033f3.d.f3969a) {
                            cVarScheduleDirect.dispose();
                        }
                        break;
                    }
                }
                break;
        }
    }

    public V0(Future future, long j6, TimeUnit timeUnit) {
        this.d = future;
        this.b = j6;
        this.c = timeUnit;
    }
}
