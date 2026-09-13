package p028e4;

import E3.d;
import E3.q;
import O3.p;
import kotlin.jvm.internal.E;
import p007a4.o1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class L {
    public static final H NO_THREAD_ELEMENTS = new H("NO_THREAD_ELEMENTS");
    private static final p countAll = new d(9);
    private static final p findOne = new d(10);
    private static final p updateState = new d(11);

    public static final void restoreThreadContext(q qVar, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof P) {
            ((P) obj).restore(qVar);
            return;
        }
        Object objFold = qVar.fold(null, findOne);
        E.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((p007a4.L) ((o1) objFold)).a(qVar, obj);
    }

    public static final Object threadContextElements(q qVar) {
        Object objFold = qVar.fold(0, countAll);
        E.c(objFold);
        return objFold;
    }

    public static final Object updateThreadContext(q qVar, Object obj) {
        if (obj == null) {
            obj = threadContextElements(qVar);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return qVar.fold(new P(qVar, ((Number) obj).intValue()), updateState);
        }
        E.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((p007a4.L) ((o1) obj)).c(qVar);
    }
}
