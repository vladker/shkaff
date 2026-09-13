package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y0 extends AbstractC0683a {
    public final long c;
    public final Object d;
    public final boolean e;

    public Y0(AbstractC0979l abstractC0979l, long j6, Object obj, boolean z6) {
        super(abstractC0979l);
        this.c = j6;
        this.d = obj;
        this.e = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        this.b.subscribe((InterfaceC0984q) new X0(cVar, this.c, this.d, this.e));
    }
}
