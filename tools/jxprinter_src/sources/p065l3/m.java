package p065l3;

import io.reactivex.AbstractC0676c;
import io.reactivex.AbstractC0979l;
import io.reactivex.B;
import io.reactivex.InterfaceC0679f;
import io.reactivex.InterfaceC0984q;
import p027e3.o;
import p067m.h;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5860a;
    public final o b;
    public final boolean c;
    public final Object d;

    public /* synthetic */ m(Object obj, o oVar, boolean z6, int i5) {
        this.f5860a = i5;
        this.d = obj;
        this.b = oVar;
        this.c = z6;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        switch (this.f5860a) {
            case 0:
                ((AbstractC0979l) this.d).subscribe((InterfaceC0984q) new l(interfaceC0679f, this.b, this.c));
                break;
            default:
                B b = (B) this.d;
                o oVar = this.b;
                if (!h.c(b, oVar, interfaceC0679f)) {
                    b.subscribe(new D(interfaceC0679f, oVar, this.c));
                }
                break;
        }
    }
}
