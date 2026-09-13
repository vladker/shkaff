package p023d4;

import E3.g;
import F3.i;
import p147z3.Q;

/* JADX INFO: renamed from: d4.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0591h implements InterfaceC0582e {
    private final InterfaceC0612o flow;

    public C0591h(InterfaceC0612o interfaceC0612o) {
        this.flow = interfaceC0612o;
    }

    @Override // p023d4.InterfaceC0582e, p023d4.InterfaceC0612o
    public Object collect(InterfaceC0615p interfaceC0615p, g<? super Q> gVar) {
        Object objCollect = this.flow.collect(new C0588g(interfaceC0615p, 0), gVar);
        return objCollect == i.getCOROUTINE_SUSPENDED() ? objCollect : Q.INSTANCE;
    }
}
