package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.y;
import p027e3.c;
import p027e3.o;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final Object c;
    public final Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J(AbstractC0985s abstractC0985s, Object obj, Object obj2, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = obj;
        this.d = obj2;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new I(interfaceC0988v, (o) this.c, (c) this.d));
                break;
            case 1:
                y0 y0Var = new y0(interfaceC0988v, (y) this.d);
                interfaceC0988v.onSubscribe(y0Var);
                ((AbstractC0985s) ((y) this.c)).subscribe(y0Var.b);
                ((AbstractC0985s) this.f5536a).subscribe(y0Var);
                break;
            default:
                B0 b1 = new B0(interfaceC0988v, (y) this.d);
                interfaceC0988v.onSubscribe(b1);
                ((b) this.c).subscribe(b1.b);
                ((AbstractC0985s) this.f5536a).subscribe(b1);
                break;
        }
    }
}
