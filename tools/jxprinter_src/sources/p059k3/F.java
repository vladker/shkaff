package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p027e3.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class F extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final q c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ F(AbstractC0985s abstractC0985s, q qVar, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = qVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new E(interfaceC0988v, this.c, 0));
                break;
            default:
                ((AbstractC0985s) this.f5536a).subscribe(new E(interfaceC0988v, this.c, 1));
                break;
        }
    }
}
