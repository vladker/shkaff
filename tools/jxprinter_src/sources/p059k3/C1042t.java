package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.internal.operators.flowable.C0799t2;
import t5.b;

/* JADX INFO: renamed from: k3.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1042t extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1042t(AbstractC0985s abstractC0985s, b bVar, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = bVar;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new r(interfaceC0988v, this.c));
                break;
            case 1:
                this.c.subscribe(new C0799t2(interfaceC0988v, this.f5536a));
                break;
            default:
                w0 w0Var = new w0(interfaceC0988v);
                interfaceC0988v.onSubscribe(w0Var);
                this.c.subscribe(w0Var.b);
                ((AbstractC0985s) this.f5536a).subscribe(w0Var);
                break;
        }
    }
}
