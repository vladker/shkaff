package p023d4;

import E3.g;
import F3.i;
import kotlinx.coroutines.flow.internal.w;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class N1 implements InterfaceC0612o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3817a;
    public final /* synthetic */ InterfaceC0612o[] b;

    public /* synthetic */ N1(InterfaceC0612o[] interfaceC0612oArr, int i5) {
        this.f3817a = i5;
        this.b = interfaceC0612oArr;
    }

    @Override // p023d4.InterfaceC0612o
    public final Object collect(InterfaceC0615p interfaceC0615p, g gVar) {
        switch (this.f3817a) {
            case 0:
                Object objCombineInternal = w.combineInternal(interfaceC0615p, this.b, S1.f3830a, new M1(3, null, 0), gVar);
                return objCombineInternal == i.getCOROUTINE_SUSPENDED() ? objCombineInternal : Q.INSTANCE;
            default:
                Object objCombineInternal2 = w.combineInternal(interfaceC0615p, this.b, S1.f3830a, new M1(3, null, 1), gVar);
                return objCombineInternal2 == i.getCOROUTINE_SUSPENDED() ? objCombineInternal2 : Q.INSTANCE;
        }
    }
}
