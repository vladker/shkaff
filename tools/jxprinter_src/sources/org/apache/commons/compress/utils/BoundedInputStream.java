package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BoundedInputStream extends InputStream {
    private long bytesRemaining;
    private final InputStream in;

    public BoundedInputStream(InputStream inputStream, long j6) {
        this.in = inputStream;
        this.bytesRemaining = j6;
    }

    public long getBytesRemaining() {
        return this.bytesRemaining;
    }

    @Override // java.io.InputStream
    public int read() {
        long j6 = this.bytesRemaining;
        if (j6 <= 0) {
            return -1;
        }
        this.bytesRemaining = j6 - 1;
        return this.in.read();
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        long jSkip = this.in.skip(Math.min(this.bytesRemaining, j6));
        this.bytesRemaining -= jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        long j6 = this.bytesRemaining;
        if (j6 == 0) {
            return -1;
        }
        if (i6 > j6) {
            i6 = (int) j6;
        }
        int i7 = this.in.read(bArr, i5, i6);
        if (i7 >= 0) {
            this.bytesRemaining -= (long) i7;
        }
        return i7;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
