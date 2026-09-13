package p007a4;

import E3.q;
import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: a4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0266c extends AbstractC0260a {
    private final Thread blockedThread;
    private final AbstractC0288l0 eventLoop;

    public C0266c(q qVar, Thread thread, AbstractC0288l0 abstractC0288l0) {
        super(qVar, true, true);
        this.blockedThread = thread;
        this.eventLoop = abstractC0288l0;
    }

    @Override // p007a4.X0
    public void afterCompletion(Object obj) {
        if (E.a(Thread.currentThread(), this.blockedThread)) {
            return;
        }
        LockSupport.unpark(this.blockedThread);
    }

    public final Object w() throws Throwable {
        AbstractC0288l0 abstractC0288l0 = this.eventLoop;
        if (abstractC0288l0 != null) {
            int i5 = AbstractC0288l0.c;
            abstractC0288l0.d(false);
        }
        while (!Thread.interrupted()) {
            try {
                AbstractC0288l0 abstractC0288l1 = this.eventLoop;
                long jG = abstractC0288l1 != null ? abstractC0288l1.g() : LocationRequestCompat.PASSIVE_INTERVAL;
                if (!(getState$kotlinx_coroutines_core() instanceof B0)) {
                    AbstractC0288l0 abstractC0288l2 = this.eventLoop;
                    if (abstractC0288l2 != null) {
                        int i6 = AbstractC0288l0.c;
                        abstractC0288l2.a(false);
                    }
                    Object objUnboxState = Y0.unboxState(getState$kotlinx_coroutines_core());
                    C0314z c0314z = objUnboxState instanceof C0314z ? (C0314z) objUnboxState : null;
                    if (c0314z == null) {
                        return objUnboxState;
                    }
                    throw c0314z.cause;
                }
                LockSupport.parkNanos(this, jG);
            } catch (Throwable th) {
                AbstractC0288l0 abstractC0288l3 = this.eventLoop;
                if (abstractC0288l3 != null) {
                    int i7 = AbstractC0288l0.c;
                    abstractC0288l3.a(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cancelCoroutine(interruptedException);
        throw interruptedException;
    }
}
