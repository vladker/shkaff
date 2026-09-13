package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A1 extends AbstractC0979l implements Callable {
    public final Callable b;

    public A1(Callable callable) {
        this.b = callable;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        p094q3.c cVar2 = new p094q3.c(cVar);
        cVar.onSubscribe(cVar2);
        try {
            Object objCall = this.b.call();
            p039g3.A.b(objCall, "The callable returned a null value");
            cVar2.e(objCall);
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            if (cVar2.get() == 4) {
                io.reactivex.plugins.a.onError(th);
            } else {
                cVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        Object objCall = this.b.call();
        p039g3.A.b(objCall, "The callable returned a null value");
        return objCall;
    }
}
