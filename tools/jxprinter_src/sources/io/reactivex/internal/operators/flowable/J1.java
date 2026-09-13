package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J1 extends AbstractC0979l {
    public final Callable b;
    public final p027e3.c c;
    public final p027e3.g d;

    public J1(Callable callable, p027e3.c cVar, p027e3.g gVar) {
        this.b = callable;
        this.c = cVar;
        this.d = gVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        try {
            cVar.onSubscribe(new I1(cVar, this.c, this.d, this.b.call()));
        } catch (Throwable th) {
            p017c3.d.throwIfFatal(th);
            cVar.onSubscribe(p094q3.d.f7843a);
            cVar.onError(th);
        }
    }
}
