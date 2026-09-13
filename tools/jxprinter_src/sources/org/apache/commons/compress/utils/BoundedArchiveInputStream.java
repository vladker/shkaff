package org.apache.commons.compress.utils;

import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BoundedArchiveInputStream extends InputStream {
    private final long end;
    private long loc;
    private ByteBuffer singleByteBuffer;

    public BoundedArchiveInputStream(long j6, long j7) {
        long j8 = j6 + j7;
        this.end = j8;
        if (j8 >= j6) {
            this.loc = j6;
        } else {
            StringBuilder sbT = a.t("Invalid length of stream at offset=", j6, ", length=");
            sbT.append(j7);
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        try {
            if (this.loc >= this.end) {
                return -1;
            }
            ByteBuffer byteBuffer = this.singleByteBuffer;
            if (byteBuffer == null) {
                this.singleByteBuffer = ByteBuffer.allocate(1);
            } else {
                byteBuffer.rewind();
            }
            if (read(this.loc, this.singleByteBuffer) < 1) {
                return -1;
            }
            this.loc++;
            return this.singleByteBuffer.get() & UnsignedBytes.MAX_VALUE;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract int read(long j6, ByteBuffer byteBuffer);

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i5, int i6) {
        long j6 = this.loc;
        long j7 = this.end;
        if (j6 >= j7) {
            return -1;
        }
        long jMin = Math.min(i6, j7 - j6);
        if (jMin <= 0) {
            return 0;
        }
        if (i5 >= 0 && i5 <= bArr.length && jMin <= bArr.length - i5) {
            int i7 = read(this.loc, ByteBuffer.wrap(bArr, i5, (int) jMin));
            if (i7 > 0) {
                this.loc += (long) i7;
            }
            return i7;
        }
        throw new IndexOutOfBoundsException("offset or len are out of bounds");
    }
}
