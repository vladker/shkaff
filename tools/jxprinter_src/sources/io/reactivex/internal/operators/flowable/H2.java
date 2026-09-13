package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H2 extends AtomicReference implements io.reactivex.S {
    private static final long serialVersionUID = -2935427570954647017L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I2 f4273a;

    public H2(I2 i5) {
        this.f4273a = i5;
    }

    @Override // io.reactivex.S
    public final void onError(Throwable th) {
        I2 i5 = this.f4273a;
        p100r3.c cVar = i5.d;
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
            return;
        }
        p094q3.g.a(i5.b);
        if (i5.getAndIncrement() == 0) {
            i5.a();
        }
    }

    @Override // io.reactivex.S
    public final void onSubscribe(p011b3.c cVar) {
        p033f3.d.f(this, cVar);
    }

    @Override // io.reactivex.S
    public final void onSuccess(Object obj) {
        I2 i5 = this.f4273a;
        if (i5.compareAndSet(0, 1)) {
            long j6 = i5.f4293m;
            if (i5.e.get() != j6) {
                i5.f4293m = j6 + 1;
                i5.f4285a.onNext(obj);
                i5.f4292l = 2;
            } else {
                i5.f4289i = obj;
                i5.f4292l = 1;
                if (i5.decrementAndGet() == 0) {
                    return;
                }
            }
        } else {
            i5.f4289i = obj;
            i5.f4292l = 1;
            if (i5.getAndIncrement() != 0) {
                return;
            }
        }
        i5.a();
    }
}
