package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FramedLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final byte[] END_MARK = new byte[4];
    private final byte[] blockData;
    private final byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private int collectedBlockDependencyBytes;
    private final XXHash32 contentHash;
    private int currentIndex;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum BlockSize {
        K64(65536, 4),
        K256(262144, 5),
        M1(1048576, 6),
        M4(4194304, 7);

        private final int index;
        private final int size;

        BlockSize(int i5, int i6) {
            this.size = i5;
            this.index = i6;
        }

        public int getIndex() {
            return this.index;
        }

        public int getSize() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Parameters {
        public static final Parameters DEFAULT = new Parameters(BlockSize.M4, true, false, false);
        private final BlockSize blockSize;
        private final org.apache.commons.compress.compressors.lz77support.Parameters lz77params;
        private final boolean withBlockChecksum;
        private final boolean withBlockDependency;
        private final boolean withContentChecksum;

        public Parameters(BlockSize blockSize) {
            this(blockSize, true, false, false);
        }

        public String toString() {
            return "LZ4 Parameters with BlockSize " + this.blockSize + ", withContentChecksum " + this.withContentChecksum + ", withBlockChecksum " + this.withBlockChecksum + ", withBlockDependency " + this.withBlockDependency;
        }

        public Parameters(BlockSize blockSize, org.apache.commons.compress.compressors.lz77support.Parameters parameters) {
            this(blockSize, true, false, false, parameters);
        }

        public Parameters(BlockSize blockSize, boolean z6, boolean z7, boolean z8) {
            this(blockSize, z6, z7, z8, BlockLZ4CompressorOutputStream.createParameterBuilder().build());
        }

        public Parameters(BlockSize blockSize, boolean z6, boolean z7, boolean z8, org.apache.commons.compress.compressors.lz77support.Parameters parameters) {
            this.blockSize = blockSize;
            this.withContentChecksum = z6;
            this.withBlockChecksum = z7;
            this.withBlockDependency = z8;
            this.lz77params = parameters;
        }
    }

    public FramedLZ4CompressorOutputStream(OutputStream outputStream) {
        this(outputStream, Parameters.DEFAULT);
    }

    private void appendToBlockDependencyBuffer(byte[] bArr, int i5, int i6) {
        int iMin = Math.min(i6, this.blockDependencyBuffer.length);
        if (iMin > 0) {
            byte[] bArr2 = this.blockDependencyBuffer;
            int length = bArr2.length - iMin;
            if (length > 0) {
                System.arraycopy(bArr2, iMin, bArr2, 0, length);
            }
            System.arraycopy(bArr, i5, this.blockDependencyBuffer, length, iMin);
            this.collectedBlockDependencyBytes = Math.min(this.collectedBlockDependencyBytes + iMin, this.blockDependencyBuffer.length);
        }
    }

    private void flushBlock() throws IOException {
        boolean z6 = this.params.withBlockDependency;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BlockLZ4CompressorOutputStream blockLZ4CompressorOutputStream = new BlockLZ4CompressorOutputStream(byteArrayOutputStream, this.params.lz77params);
        if (z6) {
            try {
                byte[] bArr = this.blockDependencyBuffer;
                int length = bArr.length;
                int i5 = this.collectedBlockDependencyBytes;
                blockLZ4CompressorOutputStream.prefill(bArr, length - i5, i5);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        blockLZ4CompressorOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        blockLZ4CompressorOutputStream.write(this.blockData, 0, this.currentIndex);
        blockLZ4CompressorOutputStream.close();
        if (z6) {
            appendToBlockDependencyBuffer(this.blockData, 0, this.currentIndex);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length2 = byteArray.length;
        int i6 = this.currentIndex;
        if (length2 > i6) {
            ByteUtils.toLittleEndian(this.out, Integer.MIN_VALUE | i6, 4);
            this.out.write(this.blockData, 0, this.currentIndex);
            if (this.params.withBlockChecksum) {
                this.blockHash.update(this.blockData, 0, this.currentIndex);
            }
        } else {
            ByteUtils.toLittleEndian(this.out, byteArray.length, 4);
            this.out.write(byteArray);
            if (this.params.withBlockChecksum) {
                this.blockHash.update(byteArray, 0, byteArray.length);
            }
        }
        if (this.params.withBlockChecksum) {
            ByteUtils.toLittleEndian(this.out, this.blockHash.getValue(), 4);
            this.blockHash.reset();
        }
        this.currentIndex = 0;
    }

    private void writeFrameDescriptor() throws IOException {
        int i5 = !this.params.withBlockDependency ? 96 : 64;
        if (this.params.withContentChecksum) {
            i5 |= 4;
        }
        if (this.params.withBlockChecksum) {
            i5 |= 16;
        }
        this.out.write(i5);
        this.contentHash.update(i5);
        int index = (this.params.blockSize.getIndex() << 4) & 112;
        this.out.write(index);
        this.contentHash.update(index);
        this.out.write((int) ((this.contentHash.getValue() >> 8) & 255));
        this.contentHash.reset();
    }

    private void writeTrailer() throws IOException {
        this.out.write(END_MARK);
        if (this.params.withContentChecksum) {
            ByteUtils.toLittleEndian(this.out, this.contentHash.getValue(), 4);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.out.close();
        }
    }

    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        if (this.currentIndex > 0) {
            flushBlock();
        }
        writeTrailer();
        this.finished = true;
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr);
    }

    public FramedLZ4CompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.contentHash = new XXHash32();
        this.params = parameters;
        this.blockData = new byte[parameters.blockSize.getSize()];
        this.out = outputStream;
        this.blockHash = parameters.withBlockChecksum ? new XXHash32() : null;
        outputStream.write(FramedLZ4CompressorInputStream.LZ4_SIGNATURE);
        writeFrameDescriptor();
        this.blockDependencyBuffer = parameters.withBlockDependency ? new byte[65536] : null;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (this.params.withContentChecksum) {
            this.contentHash.update(bArr, i5, i6);
        }
        int length = this.blockData.length;
        if (this.currentIndex + i6 > length) {
            flushBlock();
            while (i6 > length) {
                System.arraycopy(bArr, i5, this.blockData, 0, length);
                i5 += length;
                i6 -= length;
                this.currentIndex = length;
                flushBlock();
            }
        }
        System.arraycopy(bArr, i5, this.blockData, this.currentIndex, i6);
        this.currentIndex += i6;
    }
}
