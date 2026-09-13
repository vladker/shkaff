package org.apache.commons.compress.compressors.snappy;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FramedSnappyCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final int COMPRESSED_CHUNK_TYPE = 0;
    static final long MASK_OFFSET = 2726488792L;
    private static final int MAX_SKIPPABLE_TYPE = 253;
    private static final int MAX_UNSKIPPABLE_TYPE = 127;
    private static final int MIN_UNSKIPPABLE_TYPE = 2;
    private static final int PADDING_CHUNK_TYPE = 254;
    private static final int STREAM_IDENTIFIER_TYPE = 255;
    static final byte[] SZ_SIGNATURE = {-1, 6, 0, 0, 115, 78, 97, 80, 112, 89};
    private static final int UNCOMPRESSED_CHUNK_TYPE = 1;
    private final int blockSize;
    private final PureJavaCrc32C checksum;
    private final CountingInputStream countingStream;
    private SnappyCompressorInputStream currentCompressedChunk;
    private final FramedSnappyDialect dialect;
    private boolean endReached;
    private long expectedChecksum;
    private boolean inUncompressedChunk;
    private final PushbackInputStream inputStream;
    private final byte[] oneByte;
    private final ByteUtils.ByteSupplier supplier;
    private int uncompressedBytesRemaining;
    private long unreadBytes;

    public FramedSnappyCompressorInputStream(InputStream inputStream) {
        this(inputStream, FramedSnappyDialect.STANDARD);
    }

    public static boolean matches(byte[] bArr, int i5) {
        byte[] bArr2 = SZ_SIGNATURE;
        if (i5 < bArr2.length) {
            return false;
        }
        if (bArr.length > bArr2.length) {
            byte[] bArr3 = new byte[bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr2.length);
            bArr = bArr3;
        }
        return Arrays.equals(bArr, bArr2);
    }

    private long readCrc() throws IOException {
        byte[] bArr = new byte[4];
        int fully = IOUtils.readFully(this.inputStream, bArr);
        count(fully);
        if (fully == 4) {
            return ByteUtils.fromLittleEndian(bArr);
        }
        throw new IOException("Premature end of stream");
    }

    private void readNextBlock() throws IOException {
        verifyLastChecksumAndReset();
        this.inUncompressedChunk = false;
        int oneByte = readOneByte();
        if (oneByte == -1) {
            this.endReached = true;
            return;
        }
        if (oneByte == 255) {
            this.inputStream.unread(oneByte);
            this.unreadBytes++;
            pushedBackBytes(1L);
            readStreamIdentifier();
            readNextBlock();
            return;
        }
        if (oneByte == 254 || (oneByte > 127 && oneByte <= 253)) {
            skipBlock();
            readNextBlock();
            return;
        }
        if (oneByte >= 2 && oneByte <= 127) {
            StringBuilder sbT = AbstractC0157z.t(oneByte, "Unskippable chunk with type ", " (hex ");
            sbT.append(Integer.toHexString(oneByte));
            sbT.append(") detected.");
            throw new IOException(sbT.toString());
        }
        if (oneByte == 1) {
            this.inUncompressedChunk = true;
            int size = readSize() - 4;
            this.uncompressedBytesRemaining = size;
            if (size < 0) {
                throw new IOException("Found illegal chunk with negative size");
            }
            this.expectedChecksum = unmask(readCrc());
            return;
        }
        if (oneByte != 0) {
            throw new IOException(a.i(oneByte, "Unknown chunk type ", " detected."));
        }
        boolean zUsesChecksumWithCompressedChunks = this.dialect.usesChecksumWithCompressedChunks();
        long size2 = ((long) readSize()) - (zUsesChecksumWithCompressedChunks ? 4L : 0L);
        if (size2 < 0) {
            throw new IOException("Found illegal chunk with negative size");
        }
        if (zUsesChecksumWithCompressedChunks) {
            this.expectedChecksum = unmask(readCrc());
        } else {
            this.expectedChecksum = -1L;
        }
        SnappyCompressorInputStream snappyCompressorInputStream = new SnappyCompressorInputStream(new BoundedInputStream(this.inputStream, size2), this.blockSize);
        this.currentCompressedChunk = snappyCompressorInputStream;
        count(snappyCompressorInputStream.getBytesRead());
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046  */
    private int readOnce(byte[] bArr, int i5, int i6) throws IOException {
        int i7;
        int i8 = -1;
        if (!this.inUncompressedChunk) {
            SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
            if (snappyCompressorInputStream != null) {
                long bytesRead = snappyCompressorInputStream.getBytesRead();
                i7 = this.currentCompressedChunk.read(bArr, i5, i6);
                if (i7 == -1) {
                    this.currentCompressedChunk.close();
                    this.currentCompressedChunk = null;
                } else {
                    count(this.currentCompressedChunk.getBytesRead() - bytesRead);
                }
            }
            if (i8 > 0) {
                this.checksum.update(bArr, i5, i8);
            }
            return i8;
        }
        int iMin = Math.min(this.uncompressedBytesRemaining, i6);
        if (iMin == 0) {
            return -1;
        }
        i7 = this.inputStream.read(bArr, i5, iMin);
        if (i7 != -1) {
            this.uncompressedBytesRemaining -= i7;
            count(i7);
        }
        i8 = i7;
        if (i8 > 0) {
            this.checksum.update(bArr, i5, i8);
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int readOneByte() throws IOException {
        int i5 = this.inputStream.read();
        if (i5 == -1) {
            return -1;
        }
        count(1);
        return i5 & 255;
    }

    private int readSize() {
        return (int) ByteUtils.fromLittleEndian(this.supplier, 3);
    }

    private void readStreamIdentifier() throws IOException {
        byte[] bArr = new byte[10];
        int fully = IOUtils.readFully(this.inputStream, bArr);
        count(fully);
        if (10 != fully || !matches(bArr, 10)) {
            throw new IOException("Not a framed Snappy stream");
        }
    }

    private void skipBlock() throws IOException {
        int size = readSize();
        if (size < 0) {
            throw new IOException("Found illegal chunk with negative size");
        }
        long j6 = size;
        long jSkip = IOUtils.skip(this.inputStream, j6);
        count(jSkip);
        if (jSkip != j6) {
            throw new IOException("Premature end of stream");
        }
    }

    public static long unmask(long j6) {
        long j7 = (j6 - MASK_OFFSET) & KeyboardMap.kValueMask;
        return ((j7 << 15) | (j7 >> 17)) & KeyboardMap.kValueMask;
    }

    private void verifyLastChecksumAndReset() throws IOException {
        long j6 = this.expectedChecksum;
        if (j6 >= 0 && j6 != this.checksum.getValue()) {
            throw new IOException("Checksum verification failed");
        }
        this.expectedChecksum = -1L;
        this.checksum.reset();
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.inUncompressedChunk) {
            return Math.min(this.uncompressedBytesRemaining, this.inputStream.available());
        }
        SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
        if (snappyCompressorInputStream != null) {
            return snappyCompressorInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            SnappyCompressorInputStream snappyCompressorInputStream = this.currentCompressedChunk;
            if (snappyCompressorInputStream != null) {
                snappyCompressorInputStream.close();
                this.currentCompressedChunk = null;
            }
        } finally {
            this.inputStream.close();
        }
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead() - this.unreadBytes;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.oneByte, 0, 1) == -1) {
            return -1;
        }
        return this.oneByte[0] & UnsignedBytes.MAX_VALUE;
    }

    public FramedSnappyCompressorInputStream(InputStream inputStream, FramedSnappyDialect framedSnappyDialect) {
        this(inputStream, 32768, framedSnappyDialect);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        int once = readOnce(bArr, i5, i6);
        if (once != -1) {
            return once;
        }
        readNextBlock();
        if (this.endReached) {
            return -1;
        }
        return readOnce(bArr, i5, i6);
    }

    public FramedSnappyCompressorInputStream(InputStream inputStream, int i5, FramedSnappyDialect framedSnappyDialect) throws IOException {
        this.oneByte = new byte[1];
        this.expectedChecksum = -1L;
        this.checksum = new PureJavaCrc32C();
        this.supplier = new Y2.a(this, 25);
        if (i5 > 0) {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            this.countingStream = countingInputStream;
            this.inputStream = new PushbackInputStream(countingInputStream, 1);
            this.blockSize = i5;
            this.dialect = framedSnappyDialect;
            if (framedSnappyDialect.hasStreamIdentifier()) {
                readStreamIdentifier();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("blockSize must be bigger than 0");
    }
}
