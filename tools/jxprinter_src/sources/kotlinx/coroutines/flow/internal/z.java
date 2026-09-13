package kotlinx.coroutines.flow.internal;

import p023d4.C0623s;
import p023d4.InterfaceC0612o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z {
    public static final <R> Object flowScope(O3.p pVar, E3.g<? super R> gVar) {
        y yVar = new y(gVar.getContext(), gVar);
        Object objStartUndispatchedOrReturn = p034f4.b.startUndispatchedOrReturn(yVar, yVar, pVar);
        if (objStartUndispatchedOrReturn == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final <R> InterfaceC0612o scopedFlow(O3.q qVar) {
        return new C0623s(qVar, 10);
    }
}
