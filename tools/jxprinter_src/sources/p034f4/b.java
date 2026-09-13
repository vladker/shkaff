package p034f4;

import E3.g;
import E3.q;
import F3.i;
import G3.a;
import G3.h;
import O3.p;
import kotlin.jvm.internal.Y;
import p007a4.C0314z;
import p007a4.Y0;
import p007a4.u1;
import p028e4.D;
import p028e4.L;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static final <R, T> void startCoroutineUndispatched(p pVar, R r6, g<? super T> gVar) {
        Object objInvoke;
        g gVarProbeCoroutineCreated = h.probeCoroutineCreated(gVar);
        try {
            q context = gVarProbeCoroutineCreated.getContext();
            Object objUpdateThreadContext = L.updateThreadContext(context, null);
            try {
                h.probeCoroutineResumed(gVarProbeCoroutineCreated);
                if (pVar instanceof a) {
                    Y.c(2, pVar);
                    objInvoke = pVar.invoke(r6, gVarProbeCoroutineCreated);
                } else {
                    objInvoke = F3.h.wrapWithContinuationImpl(pVar, r6, gVarProbeCoroutineCreated);
                }
                L.restoreThreadContext(context, objUpdateThreadContext);
                if (objInvoke != i.getCOROUTINE_SUSPENDED()) {
                    gVarProbeCoroutineCreated.resumeWith(u.m1361constructorimpl(objInvoke));
                }
            } catch (Throwable th) {
                L.restoreThreadContext(context, objUpdateThreadContext);
                throw th;
            }
        } catch (Throwable th2) {
            gVarProbeCoroutineCreated.resumeWith(u.m1361constructorimpl(v.createFailure(th2)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(D d, R r6, p pVar) throws Throwable {
        Object c0314z;
        try {
            if (pVar instanceof a) {
                Y.c(2, pVar);
                c0314z = pVar.invoke(r6, d);
            } else {
                c0314z = F3.h.wrapWithContinuationImpl(pVar, r6, d);
            }
        } catch (Throwable th) {
            c0314z = new C0314z(th, false);
        }
        if (c0314z == i.getCOROUTINE_SUSPENDED()) {
            return i.getCOROUTINE_SUSPENDED();
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = d.makeCompletingOnce$kotlinx_coroutines_core(c0314z);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == Y0.COMPLETING_WAITING_CHILDREN) {
            return i.getCOROUTINE_SUSPENDED();
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof C0314z) {
            throw ((C0314z) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return Y0.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(D d, R r6, p pVar) throws Throwable {
        Object c0314z;
        try {
            if (pVar instanceof a) {
                Y.c(2, pVar);
                c0314z = pVar.invoke(r6, d);
            } else {
                c0314z = F3.h.wrapWithContinuationImpl(pVar, r6, d);
            }
        } catch (Throwable th) {
            c0314z = new C0314z(th, false);
        }
        if (c0314z == i.getCOROUTINE_SUSPENDED()) {
            return i.getCOROUTINE_SUSPENDED();
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = d.makeCompletingOnce$kotlinx_coroutines_core(c0314z);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == Y0.COMPLETING_WAITING_CHILDREN) {
            return i.getCOROUTINE_SUSPENDED();
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof C0314z) {
            Throwable th2 = ((C0314z) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
            if (!(th2 instanceof u1) || ((u1) th2).coroutine != d) {
                throw th2;
            }
            if (c0314z instanceof C0314z) {
                throw ((C0314z) c0314z).cause;
            }
        } else {
            c0314z = Y0.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return c0314z;
    }
}
