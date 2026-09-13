package A4;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0161d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f67a = 2;

    public /* synthetic */ C0161d(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        switch (this.f67a) {
            case 0:
                break;
            case 1:
            default:
                super.run();
                return;
            case 2:
                Process.setThreadPriority(9);
                super.run();
                return;
        }
        while (true) {
            try {
                C0160c c0160c = C0164g.Companion;
                ReentrantLock lock = c0160c.getLock();
                lock.lock();
                try {
                    C0164g c0164gAwaitTimeout$okio = c0160c.awaitTimeout$okio();
                    if (c0164gAwaitTimeout$okio == C0164g.head) {
                        C0164g.head = null;
                        lock.unlock();
                        return;
                    } else {
                        lock.unlock();
                        if (c0164gAwaitTimeout$okio != null) {
                            c0164gAwaitTimeout$okio.l();
                        }
                    }
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
            }
        }
    }

    public /* synthetic */ C0161d(String str) {
        super(str);
    }

    public /* synthetic */ C0161d(String str, Runnable runnable) {
        super(runnable, str);
    }
}
