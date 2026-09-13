package p007a4;

import E3.g;
import E3.q;
import E3.r;
import O3.p;

/* JADX INFO: renamed from: a4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0272e {
    public static final <T> V async(M m6, q qVar, P p6, p pVar) {
        return AbstractC0277g.async(m6, qVar, p6, pVar);
    }

    public static /* synthetic */ H0 b(M m6, q qVar, int i5, p pVar) {
        P p6 = P.c;
        if ((i5 & 1) != 0) {
            qVar = r.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            p6 = P.f943a;
        }
        return launch(m6, qVar, p6, pVar);
    }

    public static final <T> Object invoke(F f6, p pVar, g<? super T> gVar) {
        return AbstractC0277g.invoke(f6, pVar, gVar);
    }

    public static final H0 launch(M m6, q qVar, P p6, p pVar) {
        return AbstractC0277g.launch(m6, qVar, p6, pVar);
    }

    public static final <T> T runBlocking(q qVar, p pVar) {
        return (T) AbstractC0275f.runBlocking(qVar, pVar);
    }

    public static final <T> Object withContext(q qVar, p pVar, g<? super T> gVar) {
        return AbstractC0277g.withContext(qVar, pVar, gVar);
    }
}
