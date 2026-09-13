package p007a4;

import E3.g;
import E3.i;
import E3.j;
import E3.q;
import G3.h;
import O3.p;
import kotlin.jvm.internal.E;
import p028e4.D;
import p028e4.L;
import p034f4.a;
import p034f4.b;

/* JADX INFO: renamed from: a4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0277g {
    public static final <T> V async(M m6, q qVar, P p6, p pVar) {
        q qVarNewCoroutineContext = D.newCoroutineContext(m6, qVar);
        p6.getClass();
        W z6 = p6 == P.b ? new Z0(qVarNewCoroutineContext, pVar) : new W(qVarNewCoroutineContext, true);
        z6.start(p6, z6, pVar);
        return z6;
    }

    public static final <T> Object invoke(F f6, p pVar, g<? super T> gVar) {
        return AbstractC0272e.withContext(f6, pVar, gVar);
    }

    public static final H0 launch(M m6, q qVar, P p6, p pVar) {
        q qVarNewCoroutineContext = D.newCoroutineContext(m6, qVar);
        p6.getClass();
        AbstractC0260a c0262a1 = p6 == P.b ? new C0262a1(qVarNewCoroutineContext, pVar) : new k1(qVarNewCoroutineContext, true);
        c0262a1.start(p6, c0262a1, pVar);
        return c0262a1;
    }

    public static final <T> Object withContext(q qVar, p pVar, g<? super T> gVar) throws Throwable {
        Object result$kotlinx_coroutines_core;
        q context = gVar.getContext();
        q qVarNewCoroutineContext = D.newCoroutineContext(context, qVar);
        K0.ensureActive(qVarNewCoroutineContext);
        if (qVarNewCoroutineContext == context) {
            D d = new D(qVarNewCoroutineContext, gVar);
            result$kotlinx_coroutines_core = b.startUndispatchedOrReturn(d, d, pVar);
        } else {
            i iVar = j.Key;
            if (E.a(qVarNewCoroutineContext.get(iVar), context.get(iVar))) {
                z1 z1Var = new z1(qVarNewCoroutineContext, gVar);
                q context2 = z1Var.getContext();
                Object objUpdateThreadContext = L.updateThreadContext(context2, null);
                try {
                    Object objStartUndispatchedOrReturn = b.startUndispatchedOrReturn(z1Var, z1Var, pVar);
                    L.restoreThreadContext(context2, objUpdateThreadContext);
                    result$kotlinx_coroutines_core = objStartUndispatchedOrReturn;
                } catch (Throwable th) {
                    L.restoreThreadContext(context2, objUpdateThreadContext);
                    throw th;
                }
            } else {
                C0264b0 c0264b0 = new C0264b0(qVarNewCoroutineContext, gVar);
                a.startCoroutineCancellable(pVar, c0264b0, c0264b0);
                result$kotlinx_coroutines_core = c0264b0.getResult$kotlinx_coroutines_core();
            }
        }
        if (result$kotlinx_coroutines_core == F3.i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return result$kotlinx_coroutines_core;
    }
}
