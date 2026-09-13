package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public XZCompressorInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i6 = 0; i6 < XZ.HEADER_MAGIC.length; i6++) {
            if (bArr[i6] != XZ.HEADER_MAGIC[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            int i5 = this.in.read();
            int i6 = -1;
            if (i5 != -1) {
                i6 = 1;
            }
            count(i6);
            return i5;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws org.apache.commons.compress.MemoryLimitException {
        try {
            return IOUtils.skip(this.in, j6);
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z6) {
        this(inputStream, z6, -1);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z6, int i5) {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (z6) {
            this.in = new XZInputStream(countingInputStream, i5);
        } else {
            this.in = new SingleXZInputStream(countingInputStream, i5);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        try {
            int i7 = this.in.read(bArr, i5, i6);
            count(i7);
            return i7;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException(e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }
}
