package org.apache.commons.compress.compressors.brotli;

import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.brotli.dec.BrotliInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BrotliCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final BrotliInputStream decIS;

    public BrotliCompressorInputStream(InputStream inputStream) {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.decIS = new BrotliInputStream(countingInputStream);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.decIS.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.decIS.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
        this.decIS.mark(i5);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.decIS.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.decIS.read(bArr);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.decIS.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return IOUtils.skip(this.decIS, j6);
    }

    public String toString() {
        return this.decIS.toString();
    }

    @Override // java.io.InputStream
    public int read() {
        int i5 = this.decIS.read();
        count(i5 == -1 ? 0 : 1);
        return i5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        int i7 = this.decIS.read(bArr, i5, i6);
        count(i7);
        return i7;
    }
}
