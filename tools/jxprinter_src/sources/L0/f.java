package L0;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends InputStream {

    @GuardedBy("POOL")
    private static final Queue<f> POOL = s.createQueue(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f402a;
    public IOException b;

    @NonNull
    public static f obtain(@NonNull InputStream inputStream) {
        f fVarPoll;
        Queue<f> queue = POOL;
        synchronized (queue) {
            fVarPoll = queue.poll();
        }
        if (fVarPoll == null) {
            fVarPoll = new f();
        }
        fVarPoll.setInputStream(inputStream);
        return fVarPoll;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f402a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f402a.close();
    }

    @Nullable
    public IOException getException() {
        return this.b;
    }

    @Override // java.io.InputStream
    public final void mark(int i5) {
        this.f402a.mark(i5);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f402a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f402a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public final void release() {
        this.b = null;
        this.f402a = null;
        Queue<f> queue = POOL;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f402a.reset();
    }

    public void setInputStream(@NonNull InputStream inputStream) {
        this.f402a = inputStream;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        try {
            return this.f402a.skip(j6);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f402a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        try {
            return this.f402a.read(bArr, i5, i6);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
