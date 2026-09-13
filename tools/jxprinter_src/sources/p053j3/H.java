package p053j3;

import io.reactivex.AbstractC0676c;
import io.reactivex.InterfaceC0679f;
import p027e3.a;
import p027e3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends AbstractC0676c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0676c f5411a;
    public final g b;
    public final g c;
    public final a d;
    public final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f5412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f5413g;

    public H(AbstractC0676c abstractC0676c, g gVar, g gVar2, a aVar, a aVar2, a aVar3, a aVar4) {
        this.f5411a = abstractC0676c;
        this.b = gVar;
        this.c = gVar2;
        this.d = aVar;
        this.e = aVar2;
        this.f5412f = aVar3;
        this.f5413g = aVar4;
    }

    @Override // io.reactivex.AbstractC0676c
    public final void d(InterfaceC0679f interfaceC0679f) {
        this.f5411a.subscribe(new G(this, interfaceC0679f));
    }
}
