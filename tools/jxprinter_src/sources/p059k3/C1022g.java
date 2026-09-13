package p059k3;

import io.reactivex.AbstractC0979l;
import io.reactivex.AbstractC0985s;
import io.reactivex.y;
import t5.c;

/* JADX INFO: renamed from: k3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1022g extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final y[] c;

    public /* synthetic */ C1022g(y[] yVarArr, int i5) {
        this.b = i5;
        this.c = yVarArr;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        switch (this.b) {
            case 0:
                C1020f c1020f = new C1020f(cVar, this.c);
                cVar.onSubscribe(c1020f);
                c1020f.a();
                break;
            case 1:
                C1024h c1024h = new C1024h(cVar, this.c);
                cVar.onSubscribe(c1024h);
                c1024h.a();
                break;
            default:
                y[] yVarArr = this.c;
                int length = yVarArr.length;
                C1023g0 c1023g0 = new C1023g0(cVar, length, length <= AbstractC0979l.f5366a ? new C1025h0(length) : new C1021f0());
                cVar.onSubscribe(c1023g0);
                p100r3.c cVar2 = c1023g0.e;
                for (y yVar : yVarArr) {
                    if (!c1023g0.f5553g && cVar2.get() == null) {
                        ((AbstractC0985s) yVar).subscribe(c1023g0);
                    }
                }
                break;
        }
    }
}
