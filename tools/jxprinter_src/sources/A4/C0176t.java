package A4;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C0176t implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f81a;
    public boolean b;
    private final AbstractC0177u fileHandle;

    public C0176t(AbstractC0177u fileHandle, long j6) {
        kotlin.jvm.internal.E.f(fileHandle, "fileHandle");
        this.fileHandle = fileHandle;
        this.f81a = j6;
    }

    @Override // A4.h0, java.io.Closeable, java.lang.AutoCloseable
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

    public final AbstractC0177u getFileHandle() {
        return this.fileHandle;
    }

    @Override // A4.h0
    public long read(C0169l sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (this.b) {
            throw new IllegalStateException("closed");
        }
        long jA = this.fileHandle.a(this.f81a, sink, j6);
        if (jA != -1) {
            this.f81a += jA;
        }
        return jA;
    }

    @Override // A4.h0
    public k0 timeout() {
        return k0.NONE;
    }
}
