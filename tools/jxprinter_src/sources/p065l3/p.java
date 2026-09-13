package p065l3;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import io.reactivex.internal.operators.flowable.P3;
import io.reactivex.internal.operators.flowable.Q3;
import p027e3.o;
import t5.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final AbstractC0979l c;
    public final Object d;
    public final boolean e;

    public /* synthetic */ p(AbstractC0979l abstractC0979l, Object obj, boolean z6, int i5) {
        this.b = i5;
        this.c = abstractC0979l;
        this.d = obj;
        this.e = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        switch (this.b) {
            case 0:
                this.c.subscribe((InterfaceC0984q) new o(cVar, (o) this.d, this.e));
                break;
            case 1:
                this.c.subscribe((InterfaceC0984q) new r(cVar, (o) this.d, this.e));
                break;
            default:
                b bVar = (b) this.d;
                p135x3.c cVar2 = new p135x3.c(cVar);
                boolean z6 = this.e;
                AbstractC0979l abstractC0979l = this.c;
                if (!z6) {
                    abstractC0979l.subscribe((c) new Q3(cVar2, bVar));
                } else {
                    abstractC0979l.subscribe((c) new P3(cVar2, bVar));
                }
                break;
        }
    }
}
