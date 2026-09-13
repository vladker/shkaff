package A4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class k0 {
    public static final j0 Companion = new j0();
    public static final k0 NONE = new i0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f75a;
    public long b;
    public long c;

    public long a() {
        if (this.f75a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public final void awaitSignal(Condition condition) throws InterruptedIOException {
        kotlin.jvm.internal.E.f(condition, "condition");
        try {
            boolean zB = b();
            long jC = c();
            long jNanoTime = 0;
            if (!zB && jC == 0) {
                condition.await();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zB && jC != 0) {
                jC = Math.min(jC, a() - jNanoTime2);
            } else if (zB) {
                jC = a() - jNanoTime2;
            }
            if (jC > 0) {
                condition.await(jC, TimeUnit.NANOSECONDS);
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jC) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public boolean b() {
        return this.f75a;
    }

    public long c() {
        return this.c;
    }

    public k0 clearDeadline() {
        this.f75a = false;
        return this;
    }

    public k0 clearTimeout() {
        this.c = 0L;
        return this;
    }

    public final k0 deadline(long j6, TimeUnit unit) {
        kotlin.jvm.internal.E.f(unit, "unit");
        if (j6 <= 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "duration <= 0: ").toString());
        }
        return deadlineNanoTime(unit.toNanos(j6) + System.nanoTime());
    }

    public k0 deadlineNanoTime(long j6) {
        this.f75a = true;
        this.b = j6;
        return this;
    }

    public final <T> T intersectWith(k0 other, O3.a block) {
        kotlin.jvm.internal.E.f(other, "other");
        kotlin.jvm.internal.E.f(block, "block");
        long jC = c();
        j0 j0Var = Companion;
        long jC2 = other.c();
        long jC3 = c();
        j0Var.getClass();
        if (jC2 == 0 || (jC3 != 0 && jC2 >= jC3)) {
            jC2 = jC3;
        }
        timeout(jC2, TimeUnit.NANOSECONDS);
        if (!b()) {
            if (other.b()) {
                deadlineNanoTime(other.a());
            }
            try {
                return (T) block.invoke();
            } finally {
                timeout(jC, TimeUnit.NANOSECONDS);
                if (other.b()) {
                    clearDeadline();
                }
            }
        }
        long jA = a();
        if (other.b()) {
            deadlineNanoTime(Math.min(a(), other.a()));
        }
        try {
            return (T) block.invoke();
        } finally {
            timeout(jC, TimeUnit.NANOSECONDS);
            if (other.b()) {
                deadlineNanoTime(jA);
            }
        }
    }

    public void throwIfReached() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f75a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public k0 timeout(long j6, TimeUnit unit) {
        kotlin.jvm.internal.E.f(unit, "unit");
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "timeout < 0: ").toString());
        }
        this.c = unit.toNanos(j6);
        return this;
    }

    public final void waitUntilNotified(Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.E.f(monitor, "monitor");
        try {
            boolean zB = b();
            long jC = c();
            long jNanoTime = 0;
            if (!zB && jC == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zB && jC != 0) {
                jC = Math.min(jC, a() - jNanoTime2);
            } else if (zB) {
                jC = a() - jNanoTime2;
            }
            if (jC > 0) {
                long j6 = jC / 1000000;
                monitor.wait(j6, (int) (jC - (1000000 * j6)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jC) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
