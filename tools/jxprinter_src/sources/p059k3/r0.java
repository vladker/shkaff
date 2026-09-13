package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final y c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(AbstractC0985s abstractC0985s, y yVar, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = yVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new q0(interfaceC0988v, this.c));
                break;
            default:
                u0 u0Var = new u0(interfaceC0988v);
                interfaceC0988v.onSubscribe(u0Var);
                ((AbstractC0985s) this.c).subscribe(u0Var.b);
                ((AbstractC0985s) this.f5536a).subscribe(u0Var);
                break;
        }
    }
}
