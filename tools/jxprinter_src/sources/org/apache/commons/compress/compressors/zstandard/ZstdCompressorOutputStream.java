package org.apache.commons.compress.compressors.zstandard;

import com.github.luben.zstd.ZstdOutputStream;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZstdCompressorOutputStream extends CompressorOutputStream {
    private final ZstdOutputStream encOS;

    public ZstdCompressorOutputStream(OutputStream outputStream, int i5, boolean z6, boolean z7) {
        ZstdOutputStream zstdOutputStream = new ZstdOutputStream(outputStream, i5);
        this.encOS = zstdOutputStream;
        zstdOutputStream.setCloseFrameOnFlush(z6);
        zstdOutputStream.setChecksum(z7);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.encOS.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.encOS.flush();
    }

    public String toString() {
        return this.encOS.toString();
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this.encOS.write(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.encOS.write(bArr, i5, i6);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream, int i5, boolean z6) {
        ZstdOutputStream zstdOutputStream = new ZstdOutputStream(outputStream, i5);
        this.encOS = zstdOutputStream;
        zstdOutputStream.setCloseFrameOnFlush(z6);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream, int i5) {
        this.encOS = new ZstdOutputStream(outputStream, i5);
    }

    public ZstdCompressorOutputStream(OutputStream outputStream) {
        this.encOS = new ZstdOutputStream(outputStream);
    }
}
