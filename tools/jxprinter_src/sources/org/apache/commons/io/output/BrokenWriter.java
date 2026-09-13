package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BrokenWriter extends Writer {
    private final IOException exception;

    public BrokenWriter(IOException iOException) {
        this.exception = iOException;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw this.exception;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        throw this.exception;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        throw this.exception;
    }

    public BrokenWriter() {
        this(new IOException("Broken writer"));
    }
}
