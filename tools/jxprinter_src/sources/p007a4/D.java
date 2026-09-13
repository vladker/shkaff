package p007a4;

import E3.d;
import E3.g;
import E3.j;
import E3.q;
import E3.r;
import G3.e;
import O3.a;
import p028e4.L;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class D {
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";

    public static final q a(q qVar, q qVar2, boolean z6) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) qVar.fold(bool, new d(4))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) qVar2.fold(bool, new d(4))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return qVar.plus(qVar2);
        }
        r rVar = r.INSTANCE;
        q qVar3 = (q) qVar.fold(rVar, new d(5));
        Object objFold = qVar2;
        if (zBooleanValue2) {
            objFold = qVar2.fold(rVar, new d(6));
        }
        return qVar3.plus((q) objFold);
    }

    public static final String getCoroutineName(q qVar) {
        return null;
    }

    public static final q newCoroutineContext(M m6, q qVar) {
        q qVarA = a(m6.getCoroutineContext(), qVar, true);
        return (qVarA == C0276f0.getDefault() || qVarA.get(j.Key) != null) ? qVarA : qVarA.plus(C0276f0.getDefault());
    }

    public static final z1 undispatchedCompletion(e eVar) {
        while (!(eVar instanceof C0264b0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof z1) {
                return (z1) eVar;
            }
        }
        return null;
    }

    public static final z1 updateUndispatchedCompletion(g<?> gVar, q qVar, Object obj) {
        if (!(gVar instanceof e) || qVar.get(A1.INSTANCE) == null) {
            return null;
        }
        z1 z1VarUndispatchedCompletion = undispatchedCompletion((e) gVar);
        if (z1VarUndispatchedCompletion != null) {
            z1VarUndispatchedCompletion.saveThreadContext(qVar, obj);
        }
        return z1VarUndispatchedCompletion;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e A[DONT_GENERATE] */
    public static final <T> T withContinuationContext(g<?> gVar, Object obj, a aVar) {
        q context = gVar.getContext();
        Object objUpdateThreadContext = L.updateThreadContext(context, obj);
        z1 z1VarUpdateUndispatchedCompletion = objUpdateThreadContext != L.NO_THREAD_ELEMENTS ? updateUndispatchedCompletion(gVar, context, objUpdateThreadContext) : null;
        try {
            return (T) aVar.invoke();
        } finally {
            if (z1VarUpdateUndispatchedCompletion == null || z1VarUpdateUndispatchedCompletion.w()) {
                L.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public static final <T> T withCoroutineContext(q qVar, Object obj, a aVar) {
        Object objUpdateThreadContext = L.updateThreadContext(qVar, obj);
        try {
            return (T) aVar.invoke();
        } finally {
            L.restoreThreadContext(qVar, objUpdateThreadContext);
        }
    }

    public static final q newCoroutineContext(q qVar, q qVar2) {
        if (!((Boolean) qVar2.fold(Boolean.FALSE, new d(4))).booleanValue()) {
            return qVar.plus(qVar2);
        }
        return a(qVar, qVar2, false);
    }
}
