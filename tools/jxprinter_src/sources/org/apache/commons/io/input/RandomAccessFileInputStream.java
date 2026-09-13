package org.apache.commons.io.input;

import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RandomAccessFileInputStream extends InputStream {
    private final boolean closeOnClose;
    private final RandomAccessFile randomAccessFile;

    public RandomAccessFileInputStream(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, false);
    }

    private void seek(long j6) throws IOException {
        this.randomAccessFile.seek(j6);
    }

    @Override // java.io.InputStream
    public int available() {
        long jAvailableLong = availableLong();
        if (jAvailableLong > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jAvailableLong;
    }

    public long availableLong() {
        return this.randomAccessFile.length() - this.randomAccessFile.getFilePointer();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.closeOnClose) {
            this.randomAccessFile.close();
        }
    }

    public RandomAccessFile getRandomAccessFile() {
        return this.randomAccessFile;
    }

    public boolean isCloseOnClose() {
        return this.closeOnClose;
    }

    @Override // java.io.InputStream
    public int read() {
        return this.randomAccessFile.read();
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        if (j6 <= 0) {
            return 0L;
        }
        long filePointer = this.randomAccessFile.getFilePointer();
        long length = this.randomAccessFile.length();
        if (filePointer >= length) {
            return 0L;
        }
        long j7 = j6 + filePointer;
        if (j7 > length) {
            j7 = length - 1;
        }
        if (j7 > 0) {
            seek(j7);
        }
        return this.randomAccessFile.getFilePointer() - filePointer;
    }

    public RandomAccessFileInputStream(RandomAccessFile randomAccessFile, boolean z6) {
        Objects.requireNonNull(randomAccessFile, Constants.FILE);
        this.randomAccessFile = randomAccessFile;
        this.closeOnClose = z6;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.randomAccessFile.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        return this.randomAccessFile.read(bArr, i5, i6);
    }
}
