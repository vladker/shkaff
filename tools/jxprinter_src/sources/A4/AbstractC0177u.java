package A4;

import java.io.Closeable;
import java.io.EOFException;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: A4.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractC0177u implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f82a;
    public boolean b;
    public int c;
    private final ReentrantLock lock = n0.newLock();

    public AbstractC0177u(boolean z6) {
        this.f82a = z6;
    }

    public static /* synthetic */ f0 sink$default(AbstractC0177u abstractC0177u, long j6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i5 & 1) != 0) {
            j6 = 0;
        }
        return abstractC0177u.sink(j6);
    }

    public static /* synthetic */ h0 source$default(AbstractC0177u abstractC0177u, long j6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i5 & 1) != 0) {
            j6 = 0;
        }
        return abstractC0177u.source(j6);
    }

    public final long a(long j6, C0169l c0169l, long j7) {
        if (j7 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j7, "byteCount < 0: ").toString());
        }
        long j8 = j7 + j6;
        long j9 = j6;
        while (j9 < j8) {
            c0 c0VarWritableSegment$okio = c0169l.writableSegment$okio(1);
            byte[] bArr = c0VarWritableSegment$okio.data;
            int i5 = c0VarWritableSegment$okio.limit;
            int iProtectedRead = protectedRead(j9, bArr, i5, (int) Math.min(j8 - j9, 8192 - i5));
            if (iProtectedRead == -1) {
                if (c0VarWritableSegment$okio.pos == c0VarWritableSegment$okio.limit) {
                    c0169l.head = c0VarWritableSegment$okio.pop();
                    d0.recycle(c0VarWritableSegment$okio);
                }
                if (j6 != j9) {
                    break;
                }
                return -1L;
            }
            c0VarWritableSegment$okio.limit += iProtectedRead;
            long j10 = iProtectedRead;
            j9 += j10;
            c0169l.f76a = c0169l.size() + j10;
        }
        return j9 - j6;
    }

    public final f0 appendingSink() {
        return sink(size());
    }

    public final void b(long j6, C0169l c0169l, long j7) {
        AbstractC0159b.a(c0169l.size(), 0L, j7);
        long j8 = j6 + j7;
        long j9 = j6;
        while (j9 < j8) {
            c0 c0Var = c0169l.head;
            kotlin.jvm.internal.E.c(c0Var);
            int iMin = (int) Math.min(j8 - j9, c0Var.limit - c0Var.pos);
            protectedWrite(j9, c0Var.data, c0Var.pos, iMin);
            c0Var.pos += iMin;
            long j10 = iMin;
            j9 += j10;
            c0169l.f76a = c0169l.size() - j10;
            if (c0Var.pos == c0Var.limit) {
                c0169l.head = c0Var.pop();
                d0.recycle(c0Var);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                reentrantLock.unlock();
                return;
            }
            this.b = true;
            if (this.c != 0) {
                reentrantLock.unlock();
            } else {
                reentrantLock.unlock();
                protectedClose();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void flush() {
        if (!this.f82a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            protectedFlush();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long position(h0 source) {
        long size;
        kotlin.jvm.internal.E.f(source, "source");
        if (source instanceof a0) {
            a0 a0Var = (a0) source;
            size = a0Var.bufferField.size();
            source = a0Var.source;
        } else {
            size = 0;
        }
        if (source instanceof C0176t) {
            C0176t c0176t = (C0176t) source;
            if (c0176t.getFileHandle() == this) {
                if (c0176t.b) {
                    throw new IllegalStateException("closed");
                }
                return c0176t.f81a - size;
            }
        }
        throw new IllegalArgumentException("source was not created by this FileHandle");
    }

    public abstract void protectedClose();

    public abstract void protectedFlush();

    public abstract int protectedRead(long j6, byte[] bArr, int i5, int i6);

    public abstract void protectedResize(long j6);

    public abstract long protectedSize();

    public abstract void protectedWrite(long j6, byte[] bArr, int i5, int i6);

    public final int read(long j6, byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            return protectedRead(j6, array, i5, i6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void reposition(h0 source, long j6) throws EOFException {
        kotlin.jvm.internal.E.f(source, "source");
        if (!(source instanceof a0)) {
            if (source instanceof C0176t) {
                C0176t c0176t = (C0176t) source;
                if (c0176t.getFileHandle() == this) {
                    if (c0176t.b) {
                        throw new IllegalStateException("closed");
                    }
                    c0176t.f81a = j6;
                    return;
                }
            }
            throw new IllegalArgumentException("source was not created by this FileHandle");
        }
        a0 a0Var = (a0) source;
        h0 h0Var = a0Var.source;
        if (h0Var instanceof C0176t) {
            C0176t c0176t2 = (C0176t) h0Var;
            if (c0176t2.getFileHandle() == this) {
                if (c0176t2.b) {
                    throw new IllegalStateException("closed");
                }
                long size = a0Var.bufferField.size();
                long j7 = j6 - (c0176t2.f81a - size);
                if (0 <= j7 && j7 < size) {
                    a0Var.skip(j7);
                    return;
                } else {
                    a0Var.bufferField.a();
                    c0176t2.f81a = j6;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("source was not created by this FileHandle");
    }

    public final void resize(long j6) {
        if (!this.f82a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            protectedResize(j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final f0 sink(long j6) {
        if (!this.f82a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            this.c++;
            reentrantLock.unlock();
            return new C0175s(this, j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            return protectedSize();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final h0 source(long j6) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            this.c++;
            reentrantLock.unlock();
            return new C0176t(this, j6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long j6, byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        if (!this.f82a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            protectedWrite(j6, array, i5, i6);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long read(long j6, C0169l sink, long j7) {
        kotlin.jvm.internal.E.f(sink, "sink");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.b) {
                reentrantLock.unlock();
                return a(j6, sink, j7);
            }
            throw new IllegalStateException("closed");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void write(long j6, C0169l source, long j7) {
        kotlin.jvm.internal.E.f(source, "source");
        if (this.f82a) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (!this.b) {
                    reentrantLock.unlock();
                    b(j6, source, j7);
                    return;
                }
                throw new IllegalStateException("closed");
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        throw new IllegalStateException("file handle is read-only");
    }

    public final long position(f0 sink) {
        long size;
        kotlin.jvm.internal.E.f(sink, "sink");
        if (sink instanceof Y) {
            Y y6 = (Y) sink;
            size = y6.bufferField.size();
            sink = y6.sink;
        } else {
            size = 0;
        }
        if (sink instanceof C0175s) {
            C0175s c0175s = (C0175s) sink;
            if (c0175s.getFileHandle() == this) {
                if (!c0175s.b) {
                    return c0175s.f80a + size;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }

    public final void reposition(f0 sink, long j6) {
        kotlin.jvm.internal.E.f(sink, "sink");
        if (sink instanceof Y) {
            Y y6 = (Y) sink;
            f0 f0Var = y6.sink;
            if (f0Var instanceof C0175s) {
                C0175s c0175s = (C0175s) f0Var;
                if (c0175s.getFileHandle() == this) {
                    if (!c0175s.b) {
                        y6.emit();
                        c0175s.f80a = j6;
                        return;
                    }
                    throw new IllegalStateException("closed");
                }
            }
            throw new IllegalArgumentException("sink was not created by this FileHandle");
        }
        if (sink instanceof C0175s) {
            C0175s c0175s2 = (C0175s) sink;
            if (c0175s2.getFileHandle() == this) {
                if (!c0175s2.b) {
                    c0175s2.f80a = j6;
                    return;
                }
                throw new IllegalStateException("closed");
            }
        }
        throw new IllegalArgumentException("sink was not created by this FileHandle");
    }
}
