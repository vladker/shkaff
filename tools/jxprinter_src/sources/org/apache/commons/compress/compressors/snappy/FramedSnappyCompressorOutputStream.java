package org.apache.commons.compress.compressors.snappy;

import io.flutter.embedding.android.KeyboardMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FramedSnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int MAX_COMPRESSED_BUFFER_SIZE = 65536;
    private final byte[] buffer;
    private final PureJavaCrc32C checksum;
    private final ByteUtils.ByteConsumer consumer;
    private int currentIndex;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    public FramedSnappyCompressorOutputStream(OutputStream outputStream) {
        this(outputStream, SnappyCompressorOutputStream.createParameterBuilder(32768).build());
    }

    private void flushBuffer() throws IOException {
        this.out.write(0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        SnappyCompressorOutputStream snappyCompressorOutputStream = new SnappyCompressorOutputStream(byteArrayOutputStream, this.currentIndex, this.params);
        try {
            snappyCompressorOutputStream.write(this.buffer, 0, this.currentIndex);
            snappyCompressorOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            writeLittleEndian(3, ((long) byteArray.length) + 4);
            writeCrc();
            this.out.write(byteArray);
            this.currentIndex = 0;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    snappyCompressorOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static long mask(long j6) {
        return (((j6 << 17) | (j6 >> 15)) + 2726488792L) & KeyboardMap.kValueMask;
    }

    private void writeCrc() {
        this.checksum.update(this.buffer, 0, this.currentIndex);
        writeLittleEndian(4, mask(this.checksum.getValue()));
        this.checksum.reset();
    }

    private void writeLittleEndian(int i5, long j6) {
        ByteUtils.toLittleEndian(this.consumer, j6, i5);
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
        if (this.currentIndex > 0) {
            flushBuffer();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (this.currentIndex + i6 > 65536) {
            flushBuffer();
            while (i6 > 65536) {
                System.arraycopy(bArr, i5, this.buffer, 0, 65536);
                i5 += 65536;
                i6 -= 65536;
                this.currentIndex = 65536;
                flushBuffer();
            }
        }
        System.arraycopy(bArr, i5, this.buffer, this.currentIndex, i6);
        this.currentIndex += i6;
    }

    public FramedSnappyCompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.checksum = new PureJavaCrc32C();
        this.oneByte = new byte[1];
        this.buffer = new byte[65536];
        this.out = outputStream;
        this.params = parameters;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        outputStream.write(FramedSnappyCompressorInputStream.SZ_SIGNATURE);
    }
}
