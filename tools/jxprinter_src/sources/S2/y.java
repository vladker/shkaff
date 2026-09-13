package S2;

import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p023d4.V1;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0612o f665a;
    public final /* synthetic */ int b;

    public y(V1 v6, int i5) {
        this.f665a = v6;
        this.b = i5;
    }

    @Override // p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, E3.g gVar) {
        Object objCollect = this.f665a.collect(new x(interfaceC0615p, this.b), gVar);
        return objCollect == F3.i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }
}
