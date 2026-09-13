package kotlinx.coroutines.flow.internal;

import p023d4.InterfaceC0612o;
import p023d4.InterfaceC0615p;
import p023d4.O1;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final <R, T> Object combineInternal(InterfaceC0615p interfaceC0615p, InterfaceC0612o[] interfaceC0612oArr, O3.a aVar, O3.q qVar, E3.g<? super Q> gVar) {
        Object objFlowScope = z.flowScope(new s(interfaceC0615p, interfaceC0612oArr, aVar, qVar, null), gVar);
        return objFlowScope == F3.i.getCOROUTINE_SUSPENDED() ? objFlowScope : Q.INSTANCE;
    }

    public static final <T1, T2, R> InterfaceC0612o zipImpl(InterfaceC0612o interfaceC0612o, InterfaceC0612o interfaceC0612o2, O3.q qVar) {
        return new O1(interfaceC0612o2, interfaceC0612o, qVar, 1);
    }
}
