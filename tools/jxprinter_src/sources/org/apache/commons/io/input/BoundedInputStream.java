package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BoundedInputStream extends InputStream {
    private final InputStream in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream inputStream, long j6) {
        this.mark = -1L;
        this.propagateClose = true;
        this.max = j6;
        this.in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        long j6 = this.max;
        if (j6 < 0 || this.pos < j6) {
            return this.in.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.in.close();
        }
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        this.in.mark(i5);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j6 = this.max;
        if (j6 >= 0 && this.pos >= j6) {
            return -1;
        }
        int i5 = this.in.read();
        this.pos++;
        return i5;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.in.reset();
        this.pos = this.mark;
    }

    public void setPropagateClose(boolean z6) {
        this.propagateClose = z6;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        long j7 = this.max;
        if (j7 >= 0) {
            j6 = Math.min(j6, j7 - this.pos);
        }
        long jSkip = this.in.skip(j6);
        this.pos += jSkip;
        return jSkip;
    }

    public String toString() {
        return this.in.toString();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        long j6 = this.max;
        if (j6 >= 0 && this.pos >= j6) {
            return -1;
        }
        int i7 = this.in.read(bArr, i5, (int) (j6 >= 0 ? Math.min(i6, j6 - this.pos) : i6));
        if (i7 == -1) {
            return -1;
        }
        this.pos += (long) i7;
        return i7;
    }

    public BoundedInputStream(InputStream inputStream) {
        this(inputStream, -1L);
    }
}
