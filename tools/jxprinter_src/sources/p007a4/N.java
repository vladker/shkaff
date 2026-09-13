package p007a4;

import E3.g;
import E3.q;
import F3.i;
import G3.h;
import O3.p;
import java.util.concurrent.CancellationException;
import p028e4.C0650d;
import p028e4.D;
import p034f4.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class N {
    public static final M CoroutineScope(q qVar) {
        if (qVar.get(H0.Key) == null) {
            qVar = qVar.plus(K0.m927Job((H0) null));
        }
        return new C0650d(qVar);
    }

    public static final M MainScope() {
        return new C0650d(n1.m930SupervisorJob((H0) null).plus(C0276f0.getMain()));
    }

    public static final void cancel(M m6, CancellationException cancellationException) {
        H0 h1 = (H0) m6.getCoroutineContext().get(H0.Key);
        if (h1 != null) {
            h1.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + m6).toString());
        }
    }

    public static final <R> Object coroutineScope(p pVar, g<? super R> gVar) {
        D d = new D(gVar.getContext(), gVar);
        Object objStartUndispatchedOrReturn = b.startUndispatchedOrReturn(d, d, pVar);
        if (objStartUndispatchedOrReturn == i.getCOROUTINE_SUSPENDED()) {
            h.probeCoroutineSuspended(gVar);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final Object currentCoroutineContext(g<? super q> gVar) {
        return gVar.getContext();
    }

    public static final void ensureActive(M m6) {
        K0.ensureActive(m6.getCoroutineContext());
    }

    public static final boolean isActive(M m6) {
        H0 h1 = (H0) m6.getCoroutineContext().get(H0.Key);
        if (h1 != null) {
            return h1.isActive();
        }
        return true;
    }

    public static final M plus(M m6, q qVar) {
        return new C0650d(m6.getCoroutineContext().plus(qVar));
    }

    public static final void cancel(M m6, String str, Throwable th) {
        cancel(m6, AbstractC0305u0.CancellationException(str, th));
    }
}
