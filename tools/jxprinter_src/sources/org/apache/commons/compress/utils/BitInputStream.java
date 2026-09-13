package org.apache.commons.compress.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BitInputStream implements Closeable {
    private static final long[] MASKS = new long[64];
    private static final int MAXIMUM_CACHE_SIZE = 63;
    private long bitsCached;
    private int bitsCachedSize;
    private final ByteOrder byteOrder;
    private final CountingInputStream in;

    static {
        for (int i5 = 1; i5 <= 63; i5++) {
            long[] jArr = MASKS;
            jArr[i5] = (jArr[i5 - 1] << 1) + 1;
        }
    }

    public BitInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.in = new CountingInputStream(inputStream);
        this.byteOrder = byteOrder;
    }

    private boolean ensureCache(int i5) {
        while (true) {
            int i6 = this.bitsCachedSize;
            if (i6 >= i5 || i6 >= 57) {
                return false;
            }
            long j6 = this.in.read();
            if (j6 < 0) {
                return true;
            }
            if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.bitsCached = (j6 << this.bitsCachedSize) | this.bitsCached;
            } else {
                this.bitsCached = j6 | (this.bitsCached << 8);
            }
            this.bitsCachedSize += 8;
        }
    }

    private long processBitsGreater57(int i5) {
        long j6;
        int i6 = i5 - this.bitsCachedSize;
        int i7 = 8 - i6;
        long j7 = this.in.read();
        if (j7 < 0) {
            return j7;
        }
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            long[] jArr = MASKS;
            this.bitsCached = ((jArr[i6] & j7) << this.bitsCachedSize) | this.bitsCached;
            j6 = (j7 >>> i6) & jArr[i7];
        } else {
            long j8 = this.bitsCached << i6;
            this.bitsCached = j8;
            long[] jArr2 = MASKS;
            this.bitsCached = j8 | ((j7 >>> i7) & jArr2[i6]);
            j6 = j7 & jArr2[i7];
        }
        long j9 = this.bitsCached & MASKS[i5];
        this.bitsCached = j6;
        this.bitsCachedSize = i7;
        return j9;
    }

    private long readCachedBits(int i5) {
        long j6;
        if (this.byteOrder == ByteOrder.LITTLE_ENDIAN) {
            long j7 = this.bitsCached;
            j6 = j7 & MASKS[i5];
            this.bitsCached = j7 >>> i5;
        } else {
            j6 = (this.bitsCached >> (this.bitsCachedSize - i5)) & MASKS[i5];
        }
        this.bitsCachedSize -= i5;
        return j6;
    }

    public void alignWithByteBoundary() {
        int i5 = this.bitsCachedSize % 8;
        if (i5 > 0) {
            readCachedBits(i5);
        }
    }

    public long bitsAvailable() {
        return (((long) this.in.available()) * 8) + ((long) this.bitsCachedSize);
    }

    public int bitsCached() {
        return this.bitsCachedSize;
    }

    public void clearBitCache() {
        this.bitsCached = 0L;
        this.bitsCachedSize = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public long getBytesRead() {
        return this.in.getBytesRead();
    }

    public long readBits(int i5) throws IOException {
        if (i5 < 0 || i5 > 63) {
            throw new IOException("count must not be negative or greater than 63");
        }
        if (ensureCache(i5)) {
            return -1L;
        }
        return this.bitsCachedSize < i5 ? processBitsGreater57(i5) : readCachedBits(i5);
    }
}
