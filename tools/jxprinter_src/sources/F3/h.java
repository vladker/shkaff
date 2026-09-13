package F3;

import E3.q;
import E3.r;
import O3.l;
import O3.p;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.Y;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final G3.a a(E3.g gVar) {
        q context = gVar.getContext();
        if (context == r.INSTANCE) {
            E.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            return new f(gVar);
        }
        E.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        return new g(gVar, context);
    }

    private static final <T> E3.g<Q> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(E3.g<? super T> gVar, l lVar) {
        q context = gVar.getContext();
        return context == r.INSTANCE ? new b(0, gVar, lVar) : new c(gVar, context, lVar, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> E3.g<Q> createCoroutineUnintercepted(l lVar, E3.g<? super T> completion) {
        E.f(lVar, "<this>");
        E.f(completion, "completion");
        E3.g<?> gVarProbeCoroutineCreated = G3.h.probeCoroutineCreated(completion);
        if (lVar instanceof G3.a) {
            return ((G3.a) lVar).create(gVarProbeCoroutineCreated);
        }
        q context = gVarProbeCoroutineCreated.getContext();
        return context == r.INSTANCE ? new b(1, gVarProbeCoroutineCreated, lVar) : new c(gVarProbeCoroutineCreated, context, lVar, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> E3.g<T> intercepted(E3.g<? super T> gVar) {
        E3.g<T> gVar2;
        E.f(gVar, "<this>");
        G3.d dVar = gVar instanceof G3.d ? (G3.d) gVar : null;
        return (dVar == null || (gVar2 = (E3.g<T>) dVar.intercepted()) == null) ? gVar : gVar2;
    }

    private static final <T> Object startCoroutineUninterceptedOrReturn(l lVar, E3.g<? super T> completion) {
        E.f(lVar, "<this>");
        E.f(completion, "completion");
        if (!(lVar instanceof G3.a)) {
            return wrapWithContinuationImpl(lVar, completion);
        }
        Y.c(1, lVar);
        return lVar.invoke(completion);
    }

    public static final <T> Object wrapWithContinuationImpl(l lVar, E3.g<? super T> completion) {
        E.f(lVar, "<this>");
        E.f(completion, "completion");
        G3.a aVarA = a(G3.h.probeCoroutineCreated(completion));
        Y.c(1, lVar);
        return lVar.invoke(aVarA);
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(p pVar, R r6, E3.g<? super T> completion) {
        E.f(pVar, "<this>");
        E.f(completion, "completion");
        if (!(pVar instanceof G3.a)) {
            return wrapWithContinuationImpl(pVar, r6, completion);
        }
        Y.c(2, pVar);
        return pVar.invoke(r6, completion);
    }

    public static <R, T> Object wrapWithContinuationImpl(p pVar, R r6, E3.g<? super T> completion) {
        E.f(pVar, "<this>");
        E.f(completion, "completion");
        G3.a aVarA = a(G3.h.probeCoroutineCreated(completion));
        Y.c(2, pVar);
        return pVar.invoke(r6, aVarA);
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(O3.q qVar, R r6, P p6, E3.g<? super T> completion) {
        E.f(qVar, "<this>");
        E.f(completion, "completion");
        if (!(qVar instanceof G3.a)) {
            return wrapWithContinuationImpl(qVar, r6, p6, completion);
        }
        Y.c(3, qVar);
        return qVar.invoke(r6, p6, completion);
    }

    public static <R, P, T> Object wrapWithContinuationImpl(O3.q qVar, R r6, P p6, E3.g<? super T> completion) {
        E.f(qVar, "<this>");
        E.f(completion, "completion");
        G3.a aVarA = a(G3.h.probeCoroutineCreated(completion));
        Y.c(3, qVar);
        return qVar.invoke(r6, p6, aVarA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R, T> E3.g<Q> createCoroutineUnintercepted(p pVar, R r6, E3.g<? super T> completion) {
        E.f(pVar, "<this>");
        E.f(completion, "completion");
        E3.g<?> gVarProbeCoroutineCreated = G3.h.probeCoroutineCreated(completion);
        if (pVar instanceof G3.a) {
            return ((G3.a) pVar).create(r6, gVarProbeCoroutineCreated);
        }
        q context = gVarProbeCoroutineCreated.getContext();
        if (context == r.INSTANCE) {
            return new d(pVar, r6, gVarProbeCoroutineCreated);
        }
        return new e(gVarProbeCoroutineCreated, context, pVar, r6);
    }
}
