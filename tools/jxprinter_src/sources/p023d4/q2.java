package p023d4;

import E3.q;
import O3.l;
import kotlinx.coroutines.flow.internal.E;
import p018c4.EnumC0368b;
import p028e4.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q2 {
    private static final H NONE = new H("NONE");
    private static final H PENDING = new H("PENDING");

    public static final <T> V1 MutableStateFlow(T t6) {
        if (t6 == null) {
            t6 = (T) E.NULL;
        }
        return new p2(t6);
    }

    public static final <T> InterfaceC0612o fuseStateFlow(n2 n2Var, q qVar, int i5, EnumC0368b enumC0368b) {
        return (((i5 < 0 || i5 >= 2) && i5 != -2) || enumC0368b != EnumC0368b.b) ? c2.fuseSharedFlow(n2Var, qVar, i5, enumC0368b) : n2Var;
    }

    public static final <T> T getAndUpdate(V1 v6, l lVar) {
        p2 p2Var;
        T t6;
        do {
            p2Var = (p2) v6;
            t6 = (T) p2Var.getValue();
        } while (!p2Var.c(t6, lVar.invoke(t6)));
        return t6;
    }

    public static final <T> void update(V1 v6, l lVar) {
        p2 p2Var;
        Object value;
        do {
            p2Var = (p2) v6;
            value = p2Var.getValue();
        } while (!p2Var.c(value, lVar.invoke(value)));
    }

    public static final <T> T updateAndGet(V1 v6, l lVar) {
        p2 p2Var;
        Object value;
        T t6;
        do {
            p2Var = (p2) v6;
            value = p2Var.getValue();
            t6 = (T) lVar.invoke(value);
        } while (!p2Var.c(value, t6));
        return t6;
    }
}
