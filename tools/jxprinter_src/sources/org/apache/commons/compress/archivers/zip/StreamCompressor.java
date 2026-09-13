package org.apache.commons.compress.archivers.zip;

import java.io.Closeable;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import org.apache.commons.compress.parallel.ScatterGatherBackingStore;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class StreamCompressor implements Closeable {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFLATER_BLOCK_SIZE = 8192;
    private final Deflater def;
    private long sourcePayloadLength;
    private long totalWrittenToOutputStream;
    private long writtenToOutputStreamForLastEntry;
    private final CRC32 crc = new CRC32();
    private final byte[] outputBuffer = new byte[4096];
    private final byte[] readerBuf = new byte[4096];

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class DataOutputCompressor extends StreamCompressor {
        private final DataOutput raf;

        public DataOutputCompressor(Deflater deflater, DataOutput dataOutput) {
            super(deflater);
            this.raf = dataOutput;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        public void writeOut(byte[] bArr, int i5, int i6) throws IOException {
            this.raf.write(bArr, i5, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class OutputStreamCompressor extends StreamCompressor {
        private final OutputStream os;

        public OutputStreamCompressor(Deflater deflater, OutputStream outputStream) {
            super(deflater);
            this.os = outputStream;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        public void writeOut(byte[] bArr, int i5, int i6) throws IOException {
            this.os.write(bArr, i5, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class ScatterGatherBackingStoreCompressor extends StreamCompressor {
        private final ScatterGatherBackingStore bs;

        public ScatterGatherBackingStoreCompressor(Deflater deflater, ScatterGatherBackingStore scatterGatherBackingStore) {
            super(deflater);
            this.bs = scatterGatherBackingStore;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        public void writeOut(byte[] bArr, int i5, int i6) {
            this.bs.writeOut(bArr, i5, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SeekableByteChannelCompressor extends StreamCompressor {
        private final SeekableByteChannel channel;

        public SeekableByteChannelCompressor(Deflater deflater, SeekableByteChannel seekableByteChannel) {
            super(deflater);
            this.channel = seekableByteChannel;
        }

        @Override // org.apache.commons.compress.archivers.zip.StreamCompressor
        public void writeOut(byte[] bArr, int i5, int i6) throws IOException {
            this.channel.write(ByteBuffer.wrap(bArr, i5, i6));
        }
    }

    public StreamCompressor(Deflater deflater) {
        this.def = deflater;
    }

    public static StreamCompressor create(OutputStream outputStream, Deflater deflater) {
        return new OutputStreamCompressor(deflater, outputStream);
    }

    private void deflateUntilInputIsNeeded() {
        while (!this.def.needsInput()) {
            deflate();
        }
    }

    private void writeDeflated(byte[] bArr, int i5, int i6) {
        if (i6 <= 0 || this.def.finished()) {
            return;
        }
        if (i6 <= 8192) {
            this.def.setInput(bArr, i5, i6);
            deflateUntilInputIsNeeded();
            return;
        }
        int i7 = i6 / 8192;
        for (int i8 = 0; i8 < i7; i8++) {
            this.def.setInput(bArr, (i8 * 8192) + i5, 8192);
            deflateUntilInputIsNeeded();
        }
        int i9 = i7 * 8192;
        if (i9 < i6) {
            this.def.setInput(bArr, i5 + i9, i6 - i9);
            deflateUntilInputIsNeeded();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.def.end();
    }

    public void deflate(InputStream inputStream, int i5) throws IOException {
        reset();
        while (true) {
            byte[] bArr = this.readerBuf;
            int i6 = inputStream.read(bArr, 0, bArr.length);
            if (i6 < 0) {
                break;
            } else {
                write(this.readerBuf, 0, i6, i5);
            }
        }
        if (i5 == 8) {
            flushDeflater();
        }
    }

    public void flushDeflater() {
        this.def.finish();
        while (!this.def.finished()) {
            deflate();
        }
    }

    public long getBytesRead() {
        return this.sourcePayloadLength;
    }

    public long getBytesWrittenForLastEntry() {
        return this.writtenToOutputStreamForLastEntry;
    }

    public long getCrc32() {
        return this.crc.getValue();
    }

    public long getTotalBytesWritten() {
        return this.totalWrittenToOutputStream;
    }

    public void reset() {
        this.crc.reset();
        this.def.reset();
        this.sourcePayloadLength = 0L;
        this.writtenToOutputStreamForLastEntry = 0L;
    }

    public long write(byte[] bArr, int i5, int i6, int i7) {
        long j6 = this.writtenToOutputStreamForLastEntry;
        this.crc.update(bArr, i5, i6);
        if (i7 == 8) {
            writeDeflated(bArr, i5, i6);
        } else {
            writeCounted(bArr, i5, i6);
        }
        this.sourcePayloadLength += (long) i6;
        return this.writtenToOutputStreamForLastEntry - j6;
    }

    public void writeCounted(byte[] bArr) {
        writeCounted(bArr, 0, bArr.length);
    }

    public abstract void writeOut(byte[] bArr, int i5, int i6);

    public static StreamCompressor create(OutputStream outputStream) {
        return create(outputStream, new Deflater(-1, true));
    }

    public void writeCounted(byte[] bArr, int i5, int i6) {
        writeOut(bArr, i5, i6);
        long j6 = i6;
        this.writtenToOutputStreamForLastEntry += j6;
        this.totalWrittenToOutputStream += j6;
    }

    public static StreamCompressor create(DataOutput dataOutput, Deflater deflater) {
        return new DataOutputCompressor(deflater, dataOutput);
    }

    public static StreamCompressor create(SeekableByteChannel seekableByteChannel, Deflater deflater) {
        return new SeekableByteChannelCompressor(deflater, seekableByteChannel);
    }

    public static StreamCompressor create(int i5, ScatterGatherBackingStore scatterGatherBackingStore) {
        return new ScatterGatherBackingStoreCompressor(new Deflater(i5, true), scatterGatherBackingStore);
    }

    public void deflate() {
        Deflater deflater = this.def;
        byte[] bArr = this.outputBuffer;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            writeCounted(this.outputBuffer, 0, iDeflate);
        }
    }

    public static StreamCompressor create(ScatterGatherBackingStore scatterGatherBackingStore) {
        return create(-1, scatterGatherBackingStore);
    }
}
