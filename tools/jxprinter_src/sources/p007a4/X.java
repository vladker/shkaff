package p007a4;

import E3.g;
import E3.q;
import F3.h;
import F3.i;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class X {
    public static Object delay(Y y6, long j6, g<? super Q> gVar) {
        if (j6 <= 0) {
            return Q.INSTANCE;
        }
        C0289m c0289m = new C0289m(h.intercepted(gVar), 1);
        c0289m.initCancellability();
        y6.mo1036scheduleResumeAfterDelay(j6, c0289m);
        Object result = c0289m.getResult();
        if (result == i.getCOROUTINE_SUSPENDED()) {
            G3.h.probeCoroutineSuspended(gVar);
        }
        return result == i.getCOROUTINE_SUSPENDED() ? result : Q.INSTANCE;
    }

    public static InterfaceC0280h0 invokeOnTimeout(Y y6, long j6, Runnable runnable, q qVar) {
        return U.getDefaultDelay().invokeOnTimeout(j6, runnable, qVar);
    }
}
