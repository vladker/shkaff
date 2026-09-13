package p028e4;

import E3.q;
import O3.l;
import androidx.collection.a;
import p007a4.J;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class A {
    public static final <E> void callUndeliveredElement(l lVar, E e, q qVar) {
        Q qCallUndeliveredElementCatchingException = callUndeliveredElementCatchingException(lVar, e, null);
        if (qCallUndeliveredElementCatchingException != null) {
            J.handleCoroutineException(qVar, qCallUndeliveredElementCatchingException);
        }
    }

    public static final <E> Q callUndeliveredElementCatchingException(l lVar, E e, Q q6) {
        try {
            lVar.invoke(e);
            return q6;
        } catch (Throwable th) {
            if (q6 == null || q6.getCause() == th) {
                return new Q(a.l(e, "Exception in undelivered element handler for "), th);
            }
            AbstractC1926f.addSuppressed(q6, th);
            return q6;
        }
    }
}
