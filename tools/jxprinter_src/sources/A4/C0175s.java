package A4;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0175s implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f80a;
    public boolean b;
    private final AbstractC0177u fileHandle;

    public C0175s(AbstractC0177u fileHandle, long j6) {
        kotlin.jvm.internal.E.f(fileHandle, "fileHandle");
        this.fileHandle = fileHandle;
        this.f80a = j6;
    }

    @Override // A4.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        ReentrantLock lock = this.fileHandle.getLock();
        lock.lock();
        try {
            AbstractC0177u abstractC0177u = this.fileHandle;
            int i5 = abstractC0177u.c - 1;
            abstractC0177u.c = i5;
            if (i5 == 0 && abstractC0177u.b) {
                lock.unlock();
                this.fileHandle.protectedClose();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override // A4.f0, java.io.Flushable
    public final void flush() {
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.fileHandle.protectedFlush();
    }

    public final AbstractC0177u getFileHandle() {
        return this.fileHandle;
    }

    @Override // A4.f0
    public k0 timeout() {
        return k0.NONE;
    }

    @Override // A4.f0
    public void write(C0169l source, long j6) {
        kotlin.jvm.internal.E.f(source, "source");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        this.fileHandle.b(this.f80a, source, j6);
        this.f80a += j6;
    }
}
