package p023d4;

import E3.g;
import F3.i;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class W0 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3837a;
    public final /* synthetic */ InterfaceC0612o b;

    public /* synthetic */ W0(InterfaceC0612o interfaceC0612o, int i5) {
        this.f3837a = i5;
        this.b = interfaceC0612o;
    }

    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) {
        switch (this.f3837a) {
            case 0:
                Object objCollect = this.b.collect(new C0588g(interfaceC0615p, 1), gVar);
                return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
            case 1:
                Object objCollect2 = this.b.collect(new C0588g(interfaceC0615p, 2), gVar);
                return objCollect2 == i.getCOROUTINE_SUSPENDED() ? objCollect2 : Q.INSTANCE;
            default:
                Object objCollect3 = this.b.collect(new S(interfaceC0615p, new kotlin.jvm.internal.Q(), 3), gVar);
                return objCollect3 == i.getCOROUTINE_SUSPENDED() ? objCollect3 : Q.INSTANCE;
        }
    }
}
