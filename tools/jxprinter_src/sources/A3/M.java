package A3;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class M extends L {
    public static final <T> void forEach(Iterator<? extends T> it, O3.l operation) {
        kotlin.jvm.internal.E.f(it, "<this>");
        kotlin.jvm.internal.E.f(operation, "operation");
        while (it.hasNext()) {
            operation.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Iterator<T> iterator(Iterator<? extends T> it) {
        kotlin.jvm.internal.E.f(it, "<this>");
        return it;
    }

    public static final <T> Iterator<C0133b0> withIndex(Iterator<? extends T> it) {
        kotlin.jvm.internal.E.f(it, "<this>");
        return new d0(it);
    }
}
