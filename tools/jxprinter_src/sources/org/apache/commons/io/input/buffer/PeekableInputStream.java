package org.apache.commons.io.input.buffer;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PeekableInputStream extends CircularBufferInputStream {
    public PeekableInputStream(InputStream inputStream, int i5) {
        super(inputStream, i5);
    }

    public boolean peek(byte[] bArr) {
        Objects.requireNonNull(bArr, "sourceBuffer");
        return peek(bArr, 0, bArr.length);
    }

    public PeekableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public boolean peek(byte[] bArr, int i5, int i6) throws IOException {
        Objects.requireNonNull(bArr, "sourceBuffer");
        if (bArr.length <= this.bufferSize) {
            if (this.buffer.getCurrentNumberOfBytes() < bArr.length) {
                fillBuffer();
            }
            return this.buffer.peek(bArr, i5, i6);
        }
        StringBuilder sb = new StringBuilder("Peek request size of ");
        sb.append(bArr.length);
        sb.append(" bytes exceeds buffer size of ");
        throw new IllegalArgumentException(AbstractC0157z.l(" bytes", this.bufferSize, sb));
    }
}
