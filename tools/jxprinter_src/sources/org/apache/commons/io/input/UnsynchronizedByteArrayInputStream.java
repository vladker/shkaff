package org.apache.commons.io.input;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class UnsynchronizedByteArrayInputStream extends InputStream {
    public static final int END_OF_STREAM = -1;
    private final byte[] data;
    private final int eod;
    private int markedOffset;
    private int offset;

    public UnsynchronizedByteArrayInputStream(byte[] bArr) {
        Objects.requireNonNull(bArr, "data");
        this.data = bArr;
        this.offset = 0;
        this.eod = bArr.length;
        this.markedOffset = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        int i5 = this.offset;
        int i6 = this.eod;
        if (i5 < i6) {
            return i6 - i5;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void mark(int i5) {
        this.markedOffset = this.offset;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        int i5 = this.offset;
        if (i5 >= this.eod) {
            return -1;
        }
        byte[] bArr = this.data;
        this.offset = i5 + 1;
        return bArr[i5] & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.offset = this.markedOffset;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException("Skipping backward is not supported");
        }
        int i5 = this.eod;
        int i6 = this.offset;
        long j7 = i5 - i6;
        if (j6 >= j7) {
            j6 = j7;
        }
        this.offset = (int) (((long) i6) + j6);
        return j6;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        Objects.requireNonNull(bArr, "dest");
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        Objects.requireNonNull(bArr, "dest");
        if (i5 >= 0 && i6 >= 0 && i5 + i6 <= bArr.length) {
            int i7 = this.offset;
            int i8 = this.eod;
            if (i7 >= i8) {
                return -1;
            }
            int i9 = i8 - i7;
            if (i6 >= i9) {
                i6 = i9;
            }
            if (i6 <= 0) {
                return 0;
            }
            System.arraycopy(this.data, i7, bArr, i5, i6);
            this.offset += i6;
            return i6;
        }
        throw new IndexOutOfBoundsException();
    }

    public UnsynchronizedByteArrayInputStream(byte[] bArr, int i5) {
        Objects.requireNonNull(bArr, "data");
        if (i5 >= 0) {
            this.data = bArr;
            int iMin = Math.min(i5, bArr.length > 0 ? bArr.length : i5);
            this.offset = iMin;
            this.eod = bArr.length;
            this.markedOffset = iMin;
            return;
        }
        throw new IllegalArgumentException("offset cannot be negative");
    }

    public UnsynchronizedByteArrayInputStream(byte[] bArr, int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        }
        if (i6 >= 0) {
            Objects.requireNonNull(bArr, "data");
            this.data = bArr;
            int iMin = Math.min(i5, bArr.length > 0 ? bArr.length : i5);
            this.offset = iMin;
            this.eod = Math.min(iMin + i6, bArr.length);
            this.markedOffset = this.offset;
            return;
        }
        throw new IllegalArgumentException("length cannot be negative");
    }
}
