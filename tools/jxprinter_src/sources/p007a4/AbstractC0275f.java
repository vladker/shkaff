package p007a4;

import E3.j;
import E3.q;
import E3.r;
import O3.p;

/* JADX INFO: renamed from: a4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0275f {
    public static final <T> T runBlocking(q qVar, p pVar) {
        AbstractC0288l0 abstractC0288l0CurrentOrNull$kotlinx_coroutines_core;
        q qVarNewCoroutineContext;
        Thread threadCurrentThread = Thread.currentThread();
        j jVar = (j) qVar.get(j.Key);
        if (jVar == null) {
            abstractC0288l0CurrentOrNull$kotlinx_coroutines_core = p1.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            qVarNewCoroutineContext = D.newCoroutineContext(C0315z0.INSTANCE, qVar.plus(abstractC0288l0CurrentOrNull$kotlinx_coroutines_core));
        } else {
            if (jVar instanceof AbstractC0288l0) {
            }
            abstractC0288l0CurrentOrNull$kotlinx_coroutines_core = p1.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            qVarNewCoroutineContext = D.newCoroutineContext(C0315z0.INSTANCE, qVar);
        }
        C0266c c0266c = new C0266c(qVarNewCoroutineContext, threadCurrentThread, abstractC0288l0CurrentOrNull$kotlinx_coroutines_core);
        c0266c.start(P.f943a, c0266c, pVar);
        return (T) c0266c.w();
    }

    public static /* synthetic */ Object runBlocking$default(q qVar, p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            qVar = r.INSTANCE;
        }
        return AbstractC0272e.runBlocking(qVar, pVar);
    }
}
