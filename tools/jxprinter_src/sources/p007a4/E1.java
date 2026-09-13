package p007a4;

import E3.g;
import E3.q;
import F3.h;
import F3.i;
import p028e4.AbstractC0655i;
import p028e4.C0654h;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class E1 {
    public static final Object yield(g<? super Q> gVar) {
        Object coroutine_suspended;
        q context = gVar.getContext();
        K0.ensureActive(context);
        g gVarIntercepted = h.intercepted(gVar);
        C0654h c0654h = gVarIntercepted instanceof C0654h ? (C0654h) gVarIntercepted : null;
        if (c0654h == null) {
            coroutine_suspended = Q.INSTANCE;
        } else {
            if (c0654h.dispatcher.isDispatchNeeded(context)) {
                c0654h.dispatchYield$kotlinx_coroutines_core(context, Q.INSTANCE);
            } else {
                D1 d1 = new D1(D1.Key);
                q qVarPlus = context.plus(d1);
                Q q6 = Q.INSTANCE;
                c0654h.dispatchYield$kotlinx_coroutines_core(qVarPlus, q6);
                coroutine_suspended = (!d1.dispatcherWasUnconfined || AbstractC0655i.yieldUndispatched(c0654h)) ? i.getCOROUTINE_SUSPENDED() : q6;
            }
            coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return coroutine_suspended == i.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Q.INSTANCE;
    }
}
