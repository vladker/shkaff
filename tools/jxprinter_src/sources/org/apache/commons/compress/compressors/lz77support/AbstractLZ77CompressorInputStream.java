package org.apache.commons.compress.compressors.lz77support;

import Y2.a;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractLZ77CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private int backReferenceOffset;
    private final byte[] buf;
    private long bytesRemaining;
    private final CountingInputStream in;
    private int readIndex;
    private int size;
    private final int windowSize;
    private int writeIndex;
    private final byte[] oneByte = new byte[1];
    protected final ByteUtils.ByteSupplier supplier = new a(this, 24);

    public AbstractLZ77CompressorInputStream(InputStream inputStream, int i5) {
        this.in = new CountingInputStream(inputStream);
        if (i5 <= 0) {
            throw new IllegalArgumentException("windowSize must be bigger than 0");
        }
        this.windowSize = i5;
        this.buf = new byte[i5 * 3];
        this.readIndex = 0;
        this.writeIndex = 0;
        this.bytesRemaining = 0L;
    }

    private int readFromBuffer(byte[] bArr, int i5, int i6) {
        int iMin = Math.min(i6, available());
        if (iMin > 0) {
            System.arraycopy(this.buf, this.readIndex, bArr, i5, iMin);
            int i7 = this.readIndex + iMin;
            this.readIndex = i7;
            if (i7 > this.windowSize * 2) {
                slideBuffer();
            }
        }
        this.size += iMin;
        return iMin;
    }

    private void slideBuffer() {
        byte[] bArr = this.buf;
        int i5 = this.windowSize;
        System.arraycopy(bArr, i5, bArr, 0, i5 * 2);
        int i6 = this.writeIndex;
        int i7 = this.windowSize;
        this.writeIndex = i6 - i7;
        this.readIndex -= i7;
    }

    private void tryToCopy(int i5) {
        int iMin = Math.min((int) Math.min(i5, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (iMin != 0) {
            int i6 = this.backReferenceOffset;
            if (i6 == 1) {
                byte[] bArr = this.buf;
                int i7 = this.writeIndex;
                Arrays.fill(bArr, i7, i7 + iMin, bArr[i7 - 1]);
                this.writeIndex += iMin;
            } else if (iMin < i6) {
                byte[] bArr2 = this.buf;
                int i8 = this.writeIndex;
                System.arraycopy(bArr2, i8 - i6, bArr2, i8, iMin);
                this.writeIndex += iMin;
            } else {
                int i9 = iMin / i6;
                for (int i10 = 0; i10 < i9; i10++) {
                    byte[] bArr3 = this.buf;
                    int i11 = this.writeIndex;
                    int i12 = this.backReferenceOffset;
                    System.arraycopy(bArr3, i11 - i12, bArr3, i11, i12);
                    this.writeIndex += this.backReferenceOffset;
                }
                int i13 = this.backReferenceOffset;
                int i14 = iMin - (i9 * i13);
                if (i14 > 0) {
                    byte[] bArr4 = this.buf;
                    int i15 = this.writeIndex;
                    System.arraycopy(bArr4, i15 - i13, bArr4, i15, i14);
                    this.writeIndex += i14;
                }
            }
        }
        this.bytesRemaining -= (long) iMin;
    }

    private void tryToReadLiteral(int i5) throws IOException {
        int iMin = Math.min((int) Math.min(i5, this.bytesRemaining), this.buf.length - this.writeIndex);
        int fully = iMin > 0 ? IOUtils.readFully(this.in, this.buf, this.writeIndex, iMin) : 0;
        count(fully);
        if (iMin != fully) {
            throw new IOException("Premature end of stream reading literal");
        }
        this.writeIndex += iMin;
        this.bytesRemaining -= (long) iMin;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.writeIndex - this.readIndex;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasMoreDataInBlock() {
        return this.bytesRemaining > 0;
    }

    public void prefill(byte[] bArr) {
        if (this.writeIndex != 0) {
            throw new IllegalStateException("The stream has already been read from, can't prefill anymore");
        }
        int iMin = Math.min(this.windowSize, bArr.length);
        System.arraycopy(bArr, bArr.length - iMin, this.buf, 0, iMin);
        this.writeIndex += iMin;
        this.readIndex += iMin;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & UnsignedBytes.MAX_VALUE;
    }

    public final int readBackReference(byte[] bArr, int i5, int i6) {
        int iAvailable = available();
        if (i6 > iAvailable) {
            tryToCopy(i6 - iAvailable);
        }
        return readFromBuffer(bArr, i5, i6);
    }

    public final int readLiteral(byte[] bArr, int i5, int i6) throws IOException {
        int iAvailable = available();
        if (i6 > iAvailable) {
            tryToReadLiteral(i6 - iAvailable);
        }
        return readFromBuffer(bArr, i5, i6);
    }

    public final int readOneByte() throws IOException {
        int i5 = this.in.read();
        if (i5 == -1) {
            return -1;
        }
        count(1);
        return i5 & 255;
    }

    public final void startBackReference(int i5, long j6) {
        if (i5 <= 0 || i5 > this.writeIndex) {
            throw new IllegalArgumentException("offset must be bigger than 0 but not bigger than the number of bytes available for back-references");
        }
        if (j6 < 0) {
            throw new IllegalArgumentException("length must not be negative");
        }
        this.backReferenceOffset = i5;
        this.bytesRemaining = j6;
    }

    public final void startLiteral(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("length must not be negative");
        }
        this.bytesRemaining = j6;
    }
}
