package E3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static <R> R fold(j jVar, R r6, O3.p operation) {
        E.f(operation, "operation");
        return (R) n.fold(jVar, r6, operation);
    }

    public static <E extends o> E get(j jVar, p key) {
        E e;
        E.f(key, "key");
        if (!(key instanceof b)) {
            if (j.Key != key) {
                return null;
            }
            E.d(jVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
            return jVar;
        }
        b bVar = (b) key;
        if (!bVar.isSubKey$kotlin_stdlib(jVar.getKey()) || (e = (E) bVar.tryCast$kotlin_stdlib(jVar)) == null) {
            return null;
        }
        return e;
    }

    public static q minusKey(j jVar, p key) {
        E.f(key, "key");
        if (!(key instanceof b)) {
            return j.Key == key ? r.INSTANCE : jVar;
        }
        b bVar = (b) key;
        return (!bVar.isSubKey$kotlin_stdlib(jVar.getKey()) || bVar.tryCast$kotlin_stdlib(jVar) == null) ? jVar : r.INSTANCE;
    }

    public static q plus(j jVar, q context) {
        E.f(context, "context");
        return n.plus(jVar, context);
    }

    public static void releaseInterceptedContinuation(j jVar, g<?> continuation) {
        E.f(continuation, "continuation");
    }
}
