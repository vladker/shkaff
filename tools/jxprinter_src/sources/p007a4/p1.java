package p007a4;

import p028e4.H;
import p028e4.M;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 {
    public static final p1 INSTANCE = new p1();
    private static final ThreadLocal<AbstractC0288l0> ref = M.commonThreadLocal(new H("ThreadLocalEventLoop"));

    public static void a() {
        ref.set(null);
    }

    public final AbstractC0288l0 currentOrNull$kotlinx_coroutines_core() {
        return ref.get();
    }

    public final AbstractC0288l0 getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal<AbstractC0288l0> threadLocal = ref;
        AbstractC0288l0 abstractC0288l0 = threadLocal.get();
        if (abstractC0288l0 != null) {
            return abstractC0288l0;
        }
        AbstractC0288l0 abstractC0288l0CreateEventLoop = AbstractC0301s0.createEventLoop();
        threadLocal.set(abstractC0288l0CreateEventLoop);
        return abstractC0288l0CreateEventLoop;
    }

    public final void setEventLoop$kotlinx_coroutines_core(AbstractC0288l0 abstractC0288l0) {
        ref.set(abstractC0288l0);
    }
}
