package p059k3;

import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import p027e3.o;
import p065l3.u;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class M extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final AbstractC0985s c;
    public final o d;

    public /* synthetic */ M(AbstractC0985s abstractC0985s, o oVar, int i5) {
        this.b = i5;
        this.c = abstractC0985s;
        this.d = oVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        switch (this.b) {
            case 0:
                this.c.subscribe(new L(cVar, this.d));
                break;
            default:
                this.c.subscribe(new u(cVar, this.d));
                break;
        }
    }
}
