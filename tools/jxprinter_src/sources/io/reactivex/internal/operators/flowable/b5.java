package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b5 extends AbstractC0683a {
    public final t5.b c;
    public final p027e3.o d;
    public final int e;

    public b5(AbstractC0979l abstractC0979l, t5.b bVar, p027e3.o oVar, int i5) {
        super(abstractC0979l);
        this.c = bVar;
        this.d = oVar;
        this.e = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new Z4(new p135x3.c(cVar), this.c, this.d, this.e));
    }
}
