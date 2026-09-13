package p147z3;

import O3.a;
import O3.l;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static final Object createFailure(Throwable exception) {
        E.f(exception, "exception");
        return new u.a(exception);
    }

    private static final <R, T> R fold(Object obj, l onSuccess, l onFailure) {
        E.f(onSuccess, "onSuccess");
        E.f(onFailure, "onFailure");
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? (R) onSuccess.invoke(obj) : (R) onFailure.invoke(thM1362exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrDefault(Object obj, R r6) {
        return obj instanceof u.a ? r6 : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R, T extends R> R getOrElse(Object obj, l onFailure) {
        E.f(onFailure, "onFailure");
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? obj : (R) onFailure.invoke(thM1362exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> T getOrThrow(Object obj) throws Throwable {
        throwOnFailure(obj);
        return obj;
    }

    private static final <R, T> Object map(Object obj, l transform) {
        E.f(transform, "transform");
        return !(obj instanceof u.a) ? u.m1361constructorimpl(transform.invoke(obj)) : u.m1361constructorimpl(obj);
    }

    private static final <R, T> Object mapCatching(Object obj, l transform) {
        E.f(transform, "transform");
        if (obj instanceof u.a) {
            return u.m1361constructorimpl(obj);
        }
        try {
            return u.m1361constructorimpl(transform.invoke(obj));
        } catch (Throwable th) {
            return u.m1361constructorimpl(createFailure(th));
        }
    }

    private static final <T> Object onFailure(Object obj, l action) {
        E.f(action, "action");
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        if (thM1362exceptionOrNullimpl != null) {
            action.invoke(thM1362exceptionOrNullimpl);
        }
        return obj;
    }

    private static final <T> Object onSuccess(Object obj, l action) {
        E.f(action, "action");
        if (!(obj instanceof u.a)) {
            action.invoke(obj);
        }
        return obj;
    }

    private static final <R, T extends R> Object recover(Object obj, l transform) {
        E.f(transform, "transform");
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        return thM1362exceptionOrNullimpl == null ? obj : u.m1361constructorimpl(transform.invoke(thM1362exceptionOrNullimpl));
    }

    private static final <R, T extends R> Object recoverCatching(Object obj, l transform) {
        E.f(transform, "transform");
        Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(obj);
        if (thM1362exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            return u.m1361constructorimpl(transform.invoke(thM1362exceptionOrNullimpl));
        } catch (Throwable th) {
            return u.m1361constructorimpl(createFailure(th));
        }
    }

    private static final <R> Object runCatching(a block) {
        E.f(block, "block");
        try {
            return u.m1361constructorimpl(block.invoke());
        } catch (Throwable th) {
            return u.m1361constructorimpl(createFailure(th));
        }
    }

    public static final void throwOnFailure(Object obj) throws Throwable {
        if (obj instanceof u.a) {
            throw ((u.a) obj).exception;
        }
    }

    private static final <T, R> Object runCatching(T t6, l block) {
        E.f(block, "block");
        try {
            return u.m1361constructorimpl(block.invoke(t6));
        } catch (Throwable th) {
            return u.m1361constructorimpl(createFailure(th));
        }
    }
}
