package org.apache.commons.io.output;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ClosedWriter extends Writer {
    public static final ClosedWriter CLOSED_WRITER = new ClosedWriter();

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        throw new IOException("flush() failed: stream is closed");
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        StringBuilder sb = new StringBuilder("write(");
        sb.append(new String(cArr));
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        throw new IOException(AbstractC0157z.l(") failed: stream is closed", i6, sb));
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
