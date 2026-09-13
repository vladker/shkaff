package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class E0 extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final Callable c;

    public /* synthetic */ E0(Callable callable, int i5) {
        this.b = i5;
        this.c = callable;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                try {
                    Object objCall = this.c.call();
                    p039g3.A.b(objCall, "The publisher supplied is null");
                    ((t5.b) objCall).subscribe(cVar);
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onSubscribe(p094q3.d.f7843a);
                    cVar.onError(th);
                }
                break;
            default:
                try {
                    Object objCall2 = this.c.call();
                    p039g3.A.b(objCall2, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
                    th = (Throwable) objCall2;
                } catch (Throwable th2) {
                    th = th2;
                    p017c3.d.throwIfFatal(th);
                }
                cVar.onSubscribe(p094q3.d.f7843a);
                cVar.onError(th);
                break;
        }
    }
}
