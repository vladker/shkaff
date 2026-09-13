package p028e4;

import E3.q;
import java.util.Iterator;
import p007a4.H;
import p007a4.J;
import p147z3.AbstractC1926f;

/* JADX INFO: renamed from: e4.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0652f {
    public static final void handleUncaughtCoroutineException(q qVar, Throwable th) {
        Iterator<H> it = AbstractC0651e.getPlatformExceptionHandlers().iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(qVar, th);
            } catch (C0656j unused) {
                return;
            } catch (Throwable th2) {
                AbstractC0651e.propagateExceptionFinalResort(J.handlerException(th, th2));
            }
        }
        try {
            AbstractC1926f.addSuppressed(th, new C0653g(qVar));
        } catch (Throwable unused2) {
        }
        AbstractC0651e.propagateExceptionFinalResort(th);
    }
}
