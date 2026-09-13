package p023d4;

import E3.g;
import java.util.List;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface U1 extends Z1, InterfaceC0615p {
    boolean b(Object obj);

    @Override // p023d4.Z1, p023d4.InterfaceC0612o
    /* synthetic */ Object collect(InterfaceC0615p interfaceC0615p, g gVar);

    @Override // p023d4.InterfaceC0615p
    Object emit(Object obj, g<? super Q> gVar);

    @Override // p023d4.Z1
    /* synthetic */ List getReplayCache();

    n2 getSubscriptionCount();

    void resetReplayCache();
}
