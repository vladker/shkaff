package p007a4;

import E3.g;
import F3.i;
import G3.h;
import O3.p;
import p034f4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n1 {
    /* JADX INFO: renamed from: SupervisorJob, reason: collision with other method in class */
    public static final InterfaceC0310x m930SupervisorJob(H0 h1) {
        return new m1(h1);
    }

    public static final <R> Object supervisorScope(p pVar, g<? super R> gVar) throws Throwable {
        l1 l1Var = new l1(gVar.getContext(), gVar);
        Object objStartUndispatchedOrReturn = b.startUndispatchedOrReturn(l1Var, l1Var, pVar);
        if (objStartUndispatchedOrReturn == i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return objStartUndispatchedOrReturn;
    }
}
