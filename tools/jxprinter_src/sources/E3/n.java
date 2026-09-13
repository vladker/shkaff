package E3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n {
    public static <R> R fold(o oVar, R r6, O3.p operation) {
        E.f(operation, "operation");
        return (R) operation.invoke(r6, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E extends o> E get(o oVar, p key) {
        E.f(key, "key");
        if (E.a(oVar.getKey(), key)) {
            return oVar;
        }
        return null;
    }

    public static q minusKey(o oVar, p key) {
        E.f(key, "key");
        return E.a(oVar.getKey(), key) ? r.INSTANCE : oVar;
    }

    public static q plus(o oVar, q context) {
        E.f(context, "context");
        return m.plus(oVar, context);
    }
}
