package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N3 extends AbstractC0683a {
    public final p027e3.q c;
    public final long d;

    public N3(AbstractC0979l abstractC0979l, long j6, p027e3.q qVar) {
        super(abstractC0979l);
        this.c = qVar;
        this.d = j6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        p094q3.f fVar = new p094q3.f(false);
        cVar.onSubscribe(fVar);
        new M3(cVar, this.d, this.c, fVar, this.b).a();
    }
}
