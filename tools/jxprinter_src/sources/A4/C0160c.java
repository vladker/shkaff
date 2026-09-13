package A4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0160c {
    public final C0164g awaitTimeout$okio() throws InterruptedException {
        C0164g c0164g = C0164g.head;
        kotlin.jvm.internal.E.c(c0164g);
        C0164g c0164g2 = c0164g.next;
        if (c0164g2 == null) {
            long jNanoTime = System.nanoTime();
            getCondition().await(C0164g.f71f, TimeUnit.MILLISECONDS);
            C0164g c0164g3 = C0164g.head;
            kotlin.jvm.internal.E.c(c0164g3);
            if (c0164g3.next != null || System.nanoTime() - jNanoTime < C0164g.f72g) {
                return null;
            }
            return C0164g.head;
        }
        long jNanoTime2 = c0164g2.e - System.nanoTime();
        if (jNanoTime2 > 0) {
            getCondition().await(jNanoTime2, TimeUnit.NANOSECONDS);
            return null;
        }
        C0164g c0164g4 = C0164g.head;
        kotlin.jvm.internal.E.c(c0164g4);
        c0164g4.next = c0164g2.next;
        c0164g2.next = null;
        return c0164g2;
    }

    public final Condition getCondition() {
        return C0164g.condition;
    }

    public final ReentrantLock getLock() {
        return C0164g.lock;
    }
}
