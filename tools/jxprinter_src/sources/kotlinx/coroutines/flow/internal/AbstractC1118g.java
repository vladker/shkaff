package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.Y;
import p023d4.InterfaceC0612o;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1118g {
    public static final <T> AbstractC1117f asChannelFlow(InterfaceC0612o interfaceC0612o) {
        AbstractC1117f abstractC1117f = interfaceC0612o instanceof AbstractC1117f ? (AbstractC1117f) interfaceC0612o : null;
        if (abstractC1117f == null) {
            return new C1123l(interfaceC0612o, 0, null, 14, null);
        }
        return abstractC1117f;
    }

    public static final <T, V> Object withContextUndispatched(E3.q qVar, V v6, Object obj, O3.p pVar, E3.g<? super T> gVar) {
        Object objInvoke;
        Object objUpdateThreadContext = p028e4.L.updateThreadContext(qVar, obj);
        try {
            K k6 = new K(gVar, qVar);
            if (pVar instanceof G3.a) {
                Y.c(2, pVar);
                objInvoke = pVar.invoke(v6, k6);
            } else {
                objInvoke = F3.h.wrapWithContinuationImpl(pVar, v6, k6);
            }
            p028e4.L.restoreThreadContext(qVar, objUpdateThreadContext);
            if (objInvoke == F3.i.getCOROUTINE_SUSPENDED()) {
                G3.h.probeCoroutineSuspended(gVar);
            }
            return objInvoke;
        } catch (Throwable th) {
            p028e4.L.restoreThreadContext(qVar, objUpdateThreadContext);
            throw th;
        }
    }
}
