package p077n3;

import io.reactivex.AbstractC0979l;
import io.reactivex.O;
import p027e3.o;
import t5.c;

/* JADX INFO: renamed from: n3.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1270y extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final O c;
    public final o d;

    public /* synthetic */ C1270y(O o6, o oVar, int i5) {
        this.b = i5;
        this.c = o6;
        this.d = oVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        switch (this.b) {
            case 0:
                this.c.subscribe(new C1269x(cVar, this.d));
                break;
            default:
                this.c.subscribe(new B(cVar, this.d));
                break;
        }
    }
}
