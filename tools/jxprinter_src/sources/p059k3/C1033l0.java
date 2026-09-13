package p059k3;

import Q0.b;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import p011b3.c;
import p033f3.d;
import p033f3.h;

/* JADX INFO: renamed from: k3.l0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1033l0 extends AbstractC1010a {
    public final /* synthetic */ int b;
    public final N c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1033l0(AbstractC0985s abstractC0985s, N n6, int i5) {
        super(abstractC0985s);
        this.b = i5;
        this.c = n6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        switch (this.b) {
            case 0:
                ((AbstractC0985s) this.f5536a).subscribe(new RunnableC1031k0(interfaceC0988v, this.c));
                break;
            case 1:
                p0 p0Var = new p0(interfaceC0988v);
                interfaceC0988v.onSubscribe(p0Var);
                c cVarScheduleDirect = this.c.scheduleDirect(new b(p0Var, this.f5536a, 22));
                h hVar = p0Var.f5576a;
                hVar.getClass();
                d.c(hVar, cVarScheduleDirect);
                break;
            default:
                ((AbstractC0985s) this.f5536a).subscribe(new H0(interfaceC0988v, this.c));
                break;
        }
    }
}
