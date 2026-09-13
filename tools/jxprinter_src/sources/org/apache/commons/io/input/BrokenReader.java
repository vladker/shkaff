package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BrokenReader extends Reader {
    private final IOException exception;

    public BrokenReader(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw this.exception;
    }

    @Override // java.io.Reader
    public void mark(int i5) throws IOException {
        throw this.exception;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        throw this.exception;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        throw this.exception;
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        throw this.exception;
    }

    @Override // java.io.Reader
    public long skip(long j6) throws IOException {
        throw this.exception;
    }

    public BrokenReader() {
        this(new IOException("Broken reader"));
    }
}
