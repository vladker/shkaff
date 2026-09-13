package p028e4;

import E3.g;
import X3.W;
import p002a.a;
import p002a.b;
import p147z3.u;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class G {
    private static final StackTraceElement ARTIFICIAL_FRAME = new a().coroutineBoundary();
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    static {
        Object objM1361constructorimpl;
        Object objM1361constructorimpl2;
        try {
            objM1361constructorimpl = u.m1361constructorimpl(G3.a.class.getCanonicalName());
        } catch (Throwable th) {
            objM1361constructorimpl = u.m1361constructorimpl(v.createFailure(th));
        }
        if (u.m1362exceptionOrNullimpl(objM1361constructorimpl) != null) {
            objM1361constructorimpl = baseContinuationImplClass;
        }
        try {
            objM1361constructorimpl2 = u.m1361constructorimpl(G.class.getCanonicalName());
        } catch (Throwable th2) {
            objM1361constructorimpl2 = u.m1361constructorimpl(v.createFailure(th2));
        }
        if (u.m1362exceptionOrNullimpl(objM1361constructorimpl2) != null) {
            objM1361constructorimpl2 = stackTraceRecoveryClass;
        }
    }

    public static final void initCause(Throwable th, Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        return W.startsWith(stackTraceElement.getClassName(), b.getARTIFICIAL_FRAME_PACKAGE_NAME(), false);
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        return e;
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e6 = (E) e.getCause();
        if (e6 != null && e6.getClass().equals(e.getClass())) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (isArtificial(stackTraceElement)) {
                    return e6;
                }
            }
        }
        return e;
    }

    public static final <E extends Throwable> E recoverStackTrace(E e, g<?> gVar) {
        return e;
    }

    public static final <E extends Throwable> E unwrap(E e) {
        return e;
    }

    public static final Object recoverAndThrow(Throwable th, g<?> gVar) throws Throwable {
        throw th;
    }
}
