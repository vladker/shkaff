package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ChunkedWriter extends FilterWriter {
    private static final int DEFAULT_CHUNK_SIZE = 4096;
    private final int chunkSize;

    public ChunkedWriter(Writer writer, int i5) {
        super(writer);
        if (i5 <= 0) {
            throw new IllegalArgumentException();
        }
        this.chunkSize = i5;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i5, int i6) throws IOException {
        while (i6 > 0) {
            int iMin = Math.min(i6, this.chunkSize);
            ((FilterWriter) this).out.write(cArr, i5, iMin);
            i6 -= iMin;
            i5 += iMin;
        }
    }

    public ChunkedWriter(Writer writer) {
        this(writer, 4096);
    }
}
