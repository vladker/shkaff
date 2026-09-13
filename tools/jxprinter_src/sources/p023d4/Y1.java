package p023d4;

import E3.g;
import F3.i;
import O3.p;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Y1 extends AbstractC0573b {
    private final p block;

    public Y1(p pVar) {
        this.block = pVar;
    }

    @Override // p023d4.AbstractC0573b
    public Object collectSafely(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        Object objInvoke = this.block.invoke(interfaceC0615p, gVar);
        return objInvoke == i.getCOROUTINE_SUSPENDED() ? objInvoke : Q.INSTANCE;
    }
}
