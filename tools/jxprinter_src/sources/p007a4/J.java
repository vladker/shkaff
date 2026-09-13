package p007a4;

import E3.q;
import O3.p;
import java.lang.reflect.InvocationTargetException;
import p028e4.AbstractC0652f;
import p147z3.AbstractC1926f;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class J {
    public static final H CoroutineExceptionHandler(p pVar) {
        return new I(pVar, H.Key);
    }

    public static final void handleCoroutineException(q qVar, Throwable th) {
        try {
            H h6 = (H) qVar.get(H.Key);
            if (h6 != null) {
                h6.handleException(qVar, th);
            } else {
                AbstractC0652f.handleUncaughtCoroutineException(qVar, th);
            }
        } catch (Throwable th2) {
            AbstractC0652f.handleUncaughtCoroutineException(qVar, handlerException(th, th2));
        }
    }

    public static final Throwable handlerException(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC1926f.addSuppressed(runtimeException, th);
        return runtimeException;
    }
}
