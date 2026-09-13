package org.apache.commons.io.input.buffer;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CircularBufferInputStream extends InputStream {
    protected final CircularByteBuffer buffer;
    protected final int bufferSize;
    private boolean eof;
    protected final InputStream in;

    public CircularBufferInputStream(InputStream inputStream, int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid bufferSize: "));
        }
        Objects.requireNonNull(inputStream, "inputStream");
        this.in = inputStream;
        this.buffer = new CircularByteBuffer(i5);
        this.bufferSize = i5;
        this.eof = false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        this.eof = true;
        this.buffer.clear();
    }

    public void fillBuffer() throws IOException {
        if (this.eof) {
            return;
        }
        int space = this.buffer.getSpace();
        byte[] bArrByteArray = IOUtils.byteArray(space);
        while (space > 0) {
            int i5 = this.in.read(bArrByteArray, 0, space);
            if (i5 == -1) {
                this.eof = true;
                return;
            } else if (i5 > 0) {
                this.buffer.add(bArrByteArray, 0, i5);
                space -= i5;
            }
        }
    }

    public boolean haveBytes(int i5) throws IOException {
        if (this.buffer.getCurrentNumberOfBytes() < i5) {
            fillBuffer();
        }
        return this.buffer.hasBytes();
    }

    @Override // java.io.InputStream
    public int read() {
        if (haveBytes(1)) {
            return this.buffer.read() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        Objects.requireNonNull(bArr, "targetBuffer");
        if (i5 < 0) {
            throw new IllegalArgumentException("Offset must not be negative");
        }
        if (i6 >= 0) {
            if (!haveBytes(i6)) {
                return -1;
            }
            int iMin = Math.min(i6, this.buffer.getCurrentNumberOfBytes());
            for (int i7 = 0; i7 < iMin; i7++) {
                bArr[i5 + i7] = this.buffer.read();
            }
            return iMin;
        }
        throw new IllegalArgumentException("Length must not be negative");
    }

    public CircularBufferInputStream(InputStream inputStream) {
        this(inputStream, 8192);
    }
}
