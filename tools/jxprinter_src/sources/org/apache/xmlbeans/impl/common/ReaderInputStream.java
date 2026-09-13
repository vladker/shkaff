package org.apache.xmlbeans.impl.common;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ReaderInputStream extends PushedInputStream {
    public static final int defaultBufferSize = 2048;
    private final char[] buf;
    private final Reader reader;
    private final Writer writer;

    public ReaderInputStream(Reader reader, String str) {
        this(reader, str, 2048);
    }

    @Override // org.apache.xmlbeans.impl.common.PushedInputStream
    public void fill(int i5) throws IOException {
        do {
            int i6 = this.reader.read(this.buf);
            if (i6 < 0) {
                return;
            }
            this.writer.write(this.buf, 0, i6);
            this.writer.flush();
        } while (available() <= 0);
    }

    public ReaderInputStream(Reader reader, String str, int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("Buffer size <= 0");
        }
        this.reader = reader;
        this.writer = new OutputStreamWriter(getOutputStream(), str);
        this.buf = new char[i5];
    }
}
