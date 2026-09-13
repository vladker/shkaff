package org.apache.commons.compress.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class IOUtils {
    private static final int COPY_BUF_SIZE = 8024;
    public static final LinkOption[] EMPTY_LINK_OPTIONS = new LinkOption[0];
    private static final byte[] SKIP_BUF = new byte[4096];
    private static final int SKIP_BUF_SIZE = 4096;

    private IOUtils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, COPY_BUF_SIZE);
    }

    public static long copyRange(InputStream inputStream, long j6, OutputStream outputStream) {
        return copyRange(inputStream, j6, outputStream, COPY_BUF_SIZE);
    }

    public static int read(File file, byte[] bArr) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
        try {
            int fully = readFully(inputStreamNewInputStream, bArr, 0, bArr.length);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return fully;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static int readFully(InputStream inputStream, byte[] bArr) {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static byte[] readRange(InputStream inputStream, int i5) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyRange(inputStream, i5, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long skip(InputStream inputStream, long j6) throws IOException {
        int fully;
        long j7 = j6;
        while (j7 > 0) {
            long jSkip = inputStream.skip(j7);
            if (jSkip == 0) {
                break;
            }
            j7 -= jSkip;
        }
        while (j7 > 0 && (fully = readFully(inputStream, SKIP_BUF, 0, (int) Math.min(j7, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM))) >= 1) {
            j7 -= (long) fully;
        }
        return j6 - j7;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i5) throws IOException {
        if (i5 < 1) {
            throw new IllegalArgumentException("buffersize must be bigger than 0");
        }
        byte[] bArr = new byte[i5];
        long j6 = 0;
        while (true) {
            int i6 = inputStream.read(bArr);
            if (-1 == i6) {
                return j6;
            }
            outputStream.write(bArr, 0, i6);
            j6 += (long) i6;
        }
    }

    public static long copyRange(InputStream inputStream, long j6, OutputStream outputStream, int i5) throws IOException {
        int i6;
        if (i5 < 1) {
            throw new IllegalArgumentException("buffersize must be bigger than 0");
        }
        int iMin = (int) Math.min(i5, j6);
        byte[] bArr = new byte[iMin];
        long j7 = 0;
        while (j7 < j6 && -1 != (i6 = inputStream.read(bArr, 0, (int) Math.min(j6 - j7, iMin)))) {
            outputStream.write(bArr, 0, i6);
            j7 += (long) i6;
        }
        return j7;
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i5, int i6) throws IOException {
        int i7;
        if (i6 < 0 || i5 < 0 || (i7 = i6 + i5) > bArr.length || i7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i8 = 0;
        while (i8 != i6) {
            int i9 = inputStream.read(bArr, i5 + i8, i6 - i8);
            if (i9 == -1) {
                break;
            }
            i8 += i9;
        }
        return i8;
    }

    public static byte[] readRange(ReadableByteChannel readableByteChannel, int i5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.min(i5, COPY_BUF_SIZE));
        int i6 = 0;
        while (i6 < i5) {
            int i7 = readableByteChannel.read(byteBufferAllocate);
            if (i7 <= 0) {
                break;
            }
            byteArrayOutputStream.write(byteBufferAllocate.array(), 0, i7);
            byteBufferAllocate.rewind();
            i6 += i7;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int iRemaining = byteBuffer.remaining();
        int i5 = 0;
        while (i5 < iRemaining) {
            int i6 = readableByteChannel.read(byteBuffer);
            if (i6 <= 0) {
                break;
            } else {
                i5 += i6;
            }
        }
        if (i5 < iRemaining) {
            throw new EOFException();
        }
    }

    public static void copy(File file, OutputStream outputStream) throws IOException {
        Files.copy(file.toPath(), outputStream);
    }
}
