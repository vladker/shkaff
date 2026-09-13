package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final o c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ W(y yVar, o oVar, int i5) {
        super(yVar);
        this.b = i5;
        this.c = oVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new V(interfaceC0988v, this.c));
                break;
            case 1:
                ((AbstractC0985s) this.f5536a).subscribe(new C1019e0(0, this.c, interfaceC0988v));
                break;
            default:
                ((AbstractC0985s) this.f5536a).subscribe(new C1019e0(1, this.c, interfaceC0988v));
                break;
        }
    }
}
