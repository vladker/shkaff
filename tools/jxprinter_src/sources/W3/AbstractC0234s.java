package W3;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: W3.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0234s {
    public abstract Object yield(Object obj, E3.g<? super p147z3.Q> gVar);

    public final Object yieldAll(Iterable<Object> iterable, E3.g<? super p147z3.Q> gVar) {
        Object objYieldAll;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objYieldAll = yieldAll(iterable.iterator(), gVar)) == F3.i.getCOROUTINE_SUSPENDED()) ? objYieldAll : p147z3.Q.INSTANCE;
    }

    public abstract Object yieldAll(Iterator<Object> it, E3.g<? super p147z3.Q> gVar);

    public final Object yieldAll(InterfaceC0233q interfaceC0233q, E3.g<? super p147z3.Q> gVar) {
        Object objYieldAll = yieldAll(interfaceC0233q.iterator(), gVar);
        return objYieldAll == F3.i.getCOROUTINE_SUSPENDED() ? objYieldAll : p147z3.Q.INSTANCE;
    }
}
