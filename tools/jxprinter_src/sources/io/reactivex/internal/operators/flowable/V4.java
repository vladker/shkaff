package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class V4 extends AbstractC0683a {
    public final long c;
    public final long d;
    public final int e;

    public V4(AbstractC0979l abstractC0979l, long j6, long j7, int i5) {
        super(abstractC0979l);
        this.c = j6;
        this.d = j7;
        this.e = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        long j6 = this.d;
        long j7 = this.c;
        AbstractC0979l abstractC0979l = this.b;
        if (j6 == j7) {
            abstractC0979l.subscribe((InterfaceC0984q) new S4(cVar, j7, this.e));
            return;
        }
        if (j6 > j7) {
            abstractC0979l.subscribe((InterfaceC0984q) new U4(cVar, this.c, this.d, this.e));
        } else {
            abstractC0979l.subscribe((InterfaceC0984q) new T4(cVar, this.c, this.d, this.e));
        }
    }
}
