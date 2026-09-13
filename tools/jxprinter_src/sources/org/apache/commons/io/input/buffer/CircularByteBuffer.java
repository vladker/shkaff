package org.apache.commons.io.input.buffer;

import A3.AbstractC0157z;
import androidx.exifinterface.media.a;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CircularByteBuffer {
    private final byte[] buffer;
    private int currentNumberOfBytes;
    private int endOffset;
    private int startOffset;

    public CircularByteBuffer(int i5) {
        this.buffer = IOUtils.byteArray(i5);
        this.startOffset = 0;
        this.endOffset = 0;
        this.currentNumberOfBytes = 0;
    }

    public void add(byte b) {
        int i5 = this.currentNumberOfBytes;
        byte[] bArr = this.buffer;
        if (i5 >= bArr.length) {
            throw new IllegalStateException("No space available");
        }
        int i6 = this.endOffset;
        bArr[i6] = b;
        this.currentNumberOfBytes = i5 + 1;
        int i7 = i6 + 1;
        this.endOffset = i7;
        if (i7 == bArr.length) {
            this.endOffset = 0;
        }
    }

    public void clear() {
        this.startOffset = 0;
        this.endOffset = 0;
        this.currentNumberOfBytes = 0;
    }

    public int getCurrentNumberOfBytes() {
        return this.currentNumberOfBytes;
    }

    public int getSpace() {
        return this.buffer.length - this.currentNumberOfBytes;
    }

    public boolean hasBytes() {
        return this.currentNumberOfBytes > 0;
    }

    public boolean hasSpace() {
        return this.currentNumberOfBytes < this.buffer.length;
    }

    public boolean peek(byte[] bArr, int i5, int i6) {
        Objects.requireNonNull(bArr, "Buffer");
        if (i5 < 0 || i5 >= bArr.length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid offset: "));
        }
        if (i6 < 0 || i6 > this.buffer.length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Invalid length: "));
        }
        if (i6 < this.currentNumberOfBytes) {
            return false;
        }
        int i7 = this.startOffset;
        for (int i8 = 0; i8 < i6; i8++) {
            byte[] bArr2 = this.buffer;
            if (bArr2[i7] != bArr[i8 + i5]) {
                return false;
            }
            i7++;
            if (i7 == bArr2.length) {
                i7 = 0;
            }
        }
        return true;
    }

    public byte read() {
        int i5 = this.currentNumberOfBytes;
        if (i5 <= 0) {
            throw new IllegalStateException("No bytes available.");
        }
        byte[] bArr = this.buffer;
        int i6 = this.startOffset;
        byte b = bArr[i6];
        this.currentNumberOfBytes = i5 - 1;
        int i7 = i6 + 1;
        this.startOffset = i7;
        if (i7 == bArr.length) {
            this.startOffset = 0;
        }
        return b;
    }

    public boolean hasSpace(int i5) {
        return this.currentNumberOfBytes + i5 <= this.buffer.length;
    }

    public CircularByteBuffer() {
        this(8192);
    }

    public void add(byte[] bArr, int i5, int i6) {
        Objects.requireNonNull(bArr, "Buffer");
        if (i5 < 0 || i5 >= bArr.length) {
            throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid offset: "));
        }
        if (i6 >= 0) {
            if (this.currentNumberOfBytes + i6 <= this.buffer.length) {
                for (int i7 = 0; i7 < i6; i7++) {
                    byte[] bArr2 = this.buffer;
                    int i8 = this.endOffset;
                    bArr2[i8] = bArr[i5 + i7];
                    int i9 = i8 + 1;
                    this.endOffset = i9;
                    if (i9 == bArr2.length) {
                        this.endOffset = 0;
                    }
                }
                this.currentNumberOfBytes += i6;
                return;
            }
            throw new IllegalStateException("No space available");
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i6, "Invalid length: "));
    }

    public void read(byte[] bArr, int i5, int i6) {
        Objects.requireNonNull(bArr, "targetBuffer");
        if (i5 >= 0 && i5 < bArr.length) {
            if (i6 >= 0 && i6 <= this.buffer.length) {
                int i7 = i5 + i6;
                if (i7 <= bArr.length) {
                    if (this.currentNumberOfBytes < i6) {
                        throw new IllegalStateException(a.i("in the buffer, not ", this.currentNumberOfBytes, i6, new StringBuilder("Currently, there are only ")));
                    }
                    int i8 = 0;
                    while (i8 < i6) {
                        int i9 = i5 + 1;
                        byte[] bArr2 = this.buffer;
                        int i10 = this.startOffset;
                        bArr[i5] = bArr2[i10];
                        this.currentNumberOfBytes--;
                        int i11 = i10 + 1;
                        this.startOffset = i11;
                        if (i11 == bArr2.length) {
                            this.startOffset = 0;
                        }
                        i8++;
                        i5 = i9;
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder("The supplied byte array contains only ");
                sb.append(bArr.length);
                sb.append(" bytes, but offset, and length would require ");
                sb.append(i7 - 1);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Invalid length: "));
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid offset: "));
    }
}
