package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p027e3.o;

/* JADX INFO: renamed from: k3.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1037n0 extends AbstractC1010a {
    public final o b;
    public final boolean c;

    public C1037n0(AbstractC0985s abstractC0985s, o oVar, boolean z6) {
        super(abstractC0985s);
        this.b = oVar;
        this.c = z6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        ((AbstractC0985s) this.f5536a).subscribe(new C1035m0(interfaceC0988v, this.b, this.c));
    }
}
