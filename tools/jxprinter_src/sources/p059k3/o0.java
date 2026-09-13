package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import p027e3.a;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends AbstractC1010a {
    public final g b;
    public final g c;
    public final g d;
    public final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f5572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f5573g;

    public o0(AbstractC0985s abstractC0985s, g gVar, g gVar2, g gVar3, a aVar, a aVar2, a aVar3) {
        super(abstractC0985s);
        this.b = gVar;
        this.c = gVar2;
        this.d = gVar3;
        this.e = aVar;
        this.f5572f = aVar2;
        this.f5573g = aVar3;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        ((AbstractC0985s) this.f5536a).subscribe(new r(3, interfaceC0988v, this));
    }
}
