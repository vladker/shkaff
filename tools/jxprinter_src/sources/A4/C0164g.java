package A4;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class C0164g extends k0 {
    public static final C0160c Companion = new C0160c();
    private static final Condition condition;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f71f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f72g;
    private static C0164g head;
    private static final ReentrantLock lock;
    public boolean d;
    public long e;
    private C0164g next;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.E.e(conditionNewCondition, "lock.newCondition()");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f71f = millis;
        f72g = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void j() {
        long j6 = this.c;
        boolean z6 = this.f75a;
        if (j6 != 0 || z6) {
            C0160c c0160c = Companion;
            c0160c.getClass();
            ReentrantLock lock2 = c0160c.getLock();
            lock2.lock();
            try {
                if (this.d) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.d = true;
                if (head == null) {
                    head = new C0164g();
                    C0161d c0161d = new C0161d("Okio Watchdog");
                    c0161d.setDaemon(true);
                    c0161d.start();
                }
                long jNanoTime = System.nanoTime();
                if (j6 != 0 && z6) {
                    this.e = Math.min(j6, a() - jNanoTime) + jNanoTime;
                } else if (j6 != 0) {
                    this.e = j6 + jNanoTime;
                } else {
                    if (!z6) {
                        throw new AssertionError();
                    }
                    this.e = a();
                }
                long j7 = this.e - jNanoTime;
                C0164g c0164g = head;
                kotlin.jvm.internal.E.c(c0164g);
                while (true) {
                    C0164g c0164g2 = c0164g.next;
                    if (c0164g2 == null) {
                        break;
                    }
                    kotlin.jvm.internal.E.c(c0164g2);
                    if (j7 < c0164g2.e - jNanoTime) {
                        break;
                    }
                    c0164g = c0164g.next;
                    kotlin.jvm.internal.E.c(c0164g);
                }
                this.next = c0164g.next;
                c0164g.next = this;
                if (c0164g == head) {
                    Companion.getCondition().signal();
                }
                lock2.unlock();
            } catch (Throwable th) {
                lock2.unlock();
                throw th;
            }
        }
    }

    public final boolean k() {
        C0160c c0160c = Companion;
        c0160c.getClass();
        ReentrantLock lock2 = c0160c.getLock();
        lock2.lock();
        try {
            if (!this.d) {
                return false;
            }
            this.d = false;
            C0164g c0164g = head;
            while (c0164g != null) {
                C0164g c0164g2 = c0164g.next;
                if (c0164g2 == this) {
                    c0164g.next = this.next;
                    this.next = null;
                    return false;
                }
                c0164g = c0164g2;
            }
            return true;
        } finally {
            lock2.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final f0 sink(f0 sink) {
        kotlin.jvm.internal.E.f(sink, "sink");
        return new C0162e(this, sink);
    }

    public final h0 source(h0 source) {
        kotlin.jvm.internal.E.f(source, "source");
        return new C0163f(this, source);
    }

    public final <T> T withTimeout(O3.a block) throws IOException {
        kotlin.jvm.internal.E.f(block, "block");
        j();
        try {
            try {
                T t6 = (T) block.invoke();
                if (k()) {
                    throw access$newTimeoutException(null);
                }
                return t6;
            } catch (IOException e) {
                if (k()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            k();
            throw th;
        }
    }

    public void l() {
    }
}
