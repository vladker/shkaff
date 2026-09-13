package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private long treeSizes;
    private long uncompressedCount;

    public ExplodingInputStream(int i5, int i6, InputStream inputStream) {
        if (i5 != 4096 && i5 != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        }
        if (i6 != 2 && i6 != 3) {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
        this.dictionarySize = i5;
        this.numberOfTrees = i6;
        this.minimumMatchLength = i6;
        this.in = inputStream;
    }

    private void fillBuffer() throws IOException {
        init();
        int iNextBit = this.bits.nextBit();
        if (iNextBit == -1) {
            return;
        }
        if (iNextBit == 1) {
            BinaryTree binaryTree = this.literalTree;
            int iNextByte = binaryTree != null ? binaryTree.read(this.bits) : this.bits.nextByte();
            if (iNextByte == -1) {
                return;
            }
            this.buffer.put(iNextByte);
            return;
        }
        int i5 = this.dictionarySize == 4096 ? 6 : 7;
        int iNextBits = (int) this.bits.nextBits(i5);
        int i6 = this.distanceTree.read(this.bits);
        if (i6 != -1 || iNextBits > 0) {
            int i7 = (i6 << i5) | iNextBits;
            int i8 = this.lengthTree.read(this.bits);
            if (i8 == 63) {
                long jNextBits = this.bits.nextBits(8);
                if (jNextBits == -1) {
                    return;
                } else {
                    i8 = (int) (((long) i8) + jNextBits);
                }
            }
            this.buffer.copy(i7 + 1, i8 + this.minimumMatchLength);
        }
    }

    private void init() throws IOException {
        if (this.bits == null) {
            CountingInputStream countingInputStream = new CountingInputStream(new CloseShieldFilterInputStream(this.in));
            try {
                if (this.numberOfTrees == 3) {
                    this.literalTree = BinaryTree.decode(countingInputStream, 256);
                }
                this.lengthTree = BinaryTree.decode(countingInputStream, 64);
                this.distanceTree = BinaryTree.decode(countingInputStream, 64);
                this.treeSizes += countingInputStream.getBytesRead();
                countingInputStream.close();
                this.bits = new BitStream(this.in);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        countingInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.buffer.available()) {
            try {
                fillBuffer();
            } catch (IllegalArgumentException e) {
                throw new IOException("bad IMPLODE stream", e);
            }
        }
        int i5 = this.buffer.get();
        if (i5 > -1) {
            this.uncompressedCount++;
        }
        return i5;
    }
}
