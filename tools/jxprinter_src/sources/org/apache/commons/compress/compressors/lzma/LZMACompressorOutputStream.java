package org.apache.commons.compress.compressors.lzma;

import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LZMACompressorOutputStream extends CompressorOutputStream {
    private final LZMAOutputStream out;

    public LZMACompressorOutputStream(OutputStream outputStream) {
        this.out = new LZMAOutputStream(outputStream, new LZMA2Options(), -1L);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    public void finish() {
        this.out.finish();
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this.out.write(i5);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.out.write(bArr, i5, i6);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
