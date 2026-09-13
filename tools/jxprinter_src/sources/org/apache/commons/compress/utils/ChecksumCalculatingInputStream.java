package org.apache.commons.compress.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ChecksumCalculatingInputStream extends InputStream {
    private final Checksum checksum;
    private final InputStream in;

    public ChecksumCalculatingInputStream(Checksum checksum, InputStream inputStream) {
        Objects.requireNonNull(checksum, "checksum");
        Objects.requireNonNull(inputStream, "in");
        this.checksum = checksum;
        this.in = inputStream;
    }

    public long getValue() {
        return this.checksum.getValue();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i5 = this.in.read();
        if (i5 >= 0) {
            this.checksum.update(i5);
        }
        return i5;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        return read() >= 0 ? 1L : 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        int i7 = this.in.read(bArr, i5, i6);
        if (i7 >= 0) {
            this.checksum.update(bArr, i5, i7);
        }
        return i7;
    }
}
