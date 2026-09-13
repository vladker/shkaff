package E3;

import kotlin.jvm.internal.E;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    private static final <T> g<T> Continuation(q context, O3.l resumeWith) {
        E.f(context, "context");
        E.f(resumeWith, "resumeWith");
        return new k(context, resumeWith);
    }

    public static final <T> g<Q> createCoroutine(O3.l lVar, g<? super T> completion) {
        E.f(lVar, "<this>");
        E.f(completion, "completion");
        return new t(F3.h.intercepted(F3.h.createCoroutineUnintercepted(lVar, completion)), F3.i.getCOROUTINE_SUSPENDED());
    }

    private static final <T> void resume(g<? super T> gVar, T t6) {
        E.f(gVar, "<this>");
        gVar.resumeWith(u.m1361constructorimpl(t6));
    }

    private static final <T> void resumeWithException(g<? super T> gVar, Throwable exception) {
        E.f(gVar, "<this>");
        E.f(exception, "exception");
        gVar.resumeWith(u.m1361constructorimpl(v.createFailure(exception)));
    }

    public static final <T> void startCoroutine(O3.l lVar, g<? super T> completion) {
        E.f(lVar, "<this>");
        E.f(completion, "completion");
        F3.h.intercepted(F3.h.createCoroutineUnintercepted(lVar, completion)).resumeWith(u.m1361constructorimpl(Q.INSTANCE));
    }

    private static final <T> Object suspendCoroutine(O3.l lVar, g<? super T> gVar) {
        t tVar = new t(F3.h.intercepted(gVar));
        lVar.invoke(tVar);
        Object orThrow = tVar.getOrThrow();
        if (orThrow == F3.i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return orThrow;
    }

    public static final <R, T> g<Q> createCoroutine(O3.p pVar, R r6, g<? super T> completion) {
        E.f(pVar, "<this>");
        E.f(completion, "completion");
        return new t(F3.h.intercepted(F3.h.createCoroutineUnintercepted(pVar, r6, completion)), F3.i.getCOROUTINE_SUSPENDED());
    }

    public static final <R, T> void startCoroutine(O3.p pVar, R r6, g<? super T> completion) {
        E.f(pVar, "<this>");
        E.f(completion, "completion");
        F3.h.intercepted(F3.h.createCoroutineUnintercepted(pVar, r6, completion)).resumeWith(u.m1361constructorimpl(Q.INSTANCE));
    }

    public static /* synthetic */ void getCoroutineContext$annotations() {
    }
}
