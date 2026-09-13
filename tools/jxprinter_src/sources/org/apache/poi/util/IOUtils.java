package org.apache.poi.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.CRC32;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int SKIP_BUFFER_SIZE = 2048;
    private static byte[] SKIP_BYTE_BUFFER;
    private static final Logger LOG = LogManager.getLogger((Class<?>) IOUtils.class);
    private static int BYTE_ARRAY_MAX_OVERRIDE = -1;
    private static int MAX_BYTE_ARRAY_INIT_SIZE = -1;

    private IOUtils() {
    }

    public static int calculateByteArrayInitLength(boolean z6, int i5, int i6) {
        int iMin = Math.min(i5, i6);
        if (!z6) {
            iMin = Math.min(4096, iMin);
        }
        int i7 = MAX_BYTE_ARRAY_INIT_SIZE;
        return (i7 <= 0 || iMin <= i7) ? iMin : i7;
    }

    public static long calculateChecksum(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, bArr.length);
        return crc32.getValue();
    }

    private static void checkByteSizeLimit(int i5) {
        int i6 = BYTE_ARRAY_MAX_OVERRIDE;
        if (i6 == -1 || i5 <= i6) {
            return;
        }
        throwRFE(i5, i6);
    }

    private static void checkLength(long j6, int i5) {
        int i6 = BYTE_ARRAY_MAX_OVERRIDE;
        if (i6 > 0) {
            if (j6 > i6) {
                throwRFE(j6, i6);
            }
        } else if (j6 > i5) {
            throwRFE(j6, i5);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e) {
            LOG.atError().withThrowable(e).log("Unable to close resource");
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream, -1L);
    }

    public static int getMaxByteArrayInitSize() {
        return MAX_BYTE_ARRAY_INIT_SIZE;
    }

    public static byte[] peekFirst8Bytes(InputStream inputStream) {
        return peekFirstNBytes(inputStream, 8);
    }

    public static byte[] peekFirstNBytes(InputStream inputStream, int i5) throws IOException {
        checkByteSizeLimit(i5);
        inputStream.mark(i5);
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(i5);
        copy(new BoundedInputStream(inputStream, i5), unsynchronizedByteArrayOutputStream);
        int size = unsynchronizedByteArrayOutputStream.size();
        if (size == 0) {
            throw new EmptyFileException();
        }
        if (size < i5) {
            unsynchronizedByteArrayOutputStream.write(new byte[i5 - size]);
        }
        byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
        if (inputStream instanceof PushbackInputStream) {
            ((PushbackInputStream) inputStream).unread(byteArray, 0, size);
            return byteArray;
        }
        inputStream.reset();
        return byteArray;
    }

    public static int readByte(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (i5 != -1) {
            return i5;
        }
        throw new EOFException();
    }

    public static int readFully(InputStream inputStream, byte[] bArr) {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static byte[] safelyAllocate(long j6, int i5) {
        safelyAllocateCheck(j6, i5);
        int i6 = (int) j6;
        checkByteSizeLimit(i6);
        return new byte[i6];
    }

    public static void safelyAllocateCheck(long j6, int i5) {
        if (j6 >= 0) {
            if (j6 > 2147483647L) {
                throw new RecordFormatException("Can't allocate an array > 2147483647");
            }
            checkLength(j6, i5);
        } else {
            throw new RecordFormatException("Can't allocate an array of length < 0, but had " + j6 + " and " + i5);
        }
    }

    public static byte[] safelyClone(byte[] bArr, int i5, int i6, int i7) {
        if (bArr == null) {
            return null;
        }
        if (i5 < 0 || i6 < 0 || i7 < 0) {
            StringBuilder sbS = androidx.collection.a.s("Invalid offset/length specified: offset: ", i5, i6, ", lenght: ", ", maxLength: ");
            sbS.append(i7);
            throw new RecordFormatException(sbS.toString());
        }
        int iMin = Math.min(bArr.length - i5, i6);
        safelyAllocateCheck(iMin, i7);
        return Arrays.copyOfRange(bArr, i5, iMin + i5);
    }

    public static void setByteArrayMaxOverride(int i5) {
        BYTE_ARRAY_MAX_OVERRIDE = i5;
    }

    public static void setMaxByteArrayInitSize(int i5) {
        MAX_BYTE_ARRAY_INIT_SIZE = i5;
    }

    public static long skipFully(InputStream inputStream, long j6) {
        if (j6 < 0) {
            throw new IllegalArgumentException(androidx.collection.a.j(j6, "Skip count must be non-negative, actual: "));
        }
        if (j6 == 0) {
            return 0L;
        }
        if (SKIP_BYTE_BUFFER == null) {
            SKIP_BYTE_BUFFER = new byte[2048];
        }
        long j7 = j6;
        while (j7 > 0) {
            long j8 = inputStream.read(SKIP_BYTE_BUFFER, 0, (int) Math.min(j7, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH));
            if (j8 < 0) {
                break;
            }
            j7 -= j8;
        }
        if (j6 == j7) {
            return -1L;
        }
        return j6 - j7;
    }

    private static void throwRFE(long j6, int i5) {
        throw new RecordFormatException(String.format(Locale.ROOT, "Tried to allocate an array of length %,d, but the maximum length for this record type is %,d.\nIf the file is not corrupt and not large, please open an issue on bugzilla to request \nincreasing the maximum allowable size for this record type.\nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", Long.valueOf(j6), Integer.valueOf(i5)));
    }

    private static void throwRecordTruncationException(int i5) {
        throw new RecordFormatException(String.format(Locale.ROOT, "Tried to read data but the maximum length for this record type is %,d.\nIf the file is not corrupt and not large, please open an issue on bugzilla to request \nincreasing the maximum allowable size for this record type.\nYou can set a higher override value with IOUtils.setByteArrayMaxOverride()", Integer.valueOf(i5)));
    }

    public static byte[] toByteArray(InputStream inputStream) {
        return toByteArray(inputStream, Integer.MAX_VALUE);
    }

    public static byte[] toByteArrayWithMaxLength(InputStream inputStream, int i5) {
        return toByteArray(inputStream, i5, i5, false, false);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, long j6) throws IOException {
        byte[] bArr = new byte[4096];
        int i5 = -1;
        long j7 = 0;
        while (true) {
            long jMin = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            if (j6 >= 0) {
                jMin = Math.min(j6 - j7, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            }
            int i6 = (int) jMin;
            if (i6 > 0) {
                int i7 = inputStream.read(bArr, 0, i6);
                if (i7 > 0) {
                    outputStream.write(bArr, 0, i7);
                    j7 += (long) i7;
                }
                i5 = i7;
            }
            if (i5 < 0 || (j6 != -1 && j7 >= j6)) {
                break;
            }
        }
        return j7;
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i5, int i6) throws IOException {
        int i7 = 0;
        do {
            int i8 = inputStream.read(bArr, i5 + i7, i6 - i7);
            if (i8 < 0) {
                if (i7 == 0) {
                    return -1;
                }
                return i7;
            }
            i7 += i8;
        } while (i7 != i6);
        return i7;
    }

    public static byte[] toByteArray(InputStream inputStream, int i5) {
        return toByteArray(inputStream, i5, Integer.MAX_VALUE);
    }

    public static int readFully(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer) throws IOException {
        int i5 = 0;
        do {
            int i6 = readableByteChannel.read(byteBuffer);
            if (i6 >= 0) {
                i5 += i6;
                if (i5 == byteBuffer.capacity()) {
                    break;
                }
            } else {
                if (i5 == 0) {
                    return -1;
                }
                return i5;
            }
        } while (byteBuffer.position() != byteBuffer.capacity());
        return i5;
    }

    public static byte[] toByteArray(InputStream inputStream, int i5, int i6) {
        return toByteArray(inputStream, i5, i6, true, i5 != Integer.MAX_VALUE);
    }

    public static long calculateChecksum(InputStream inputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        byte[] bArr = new byte[4096];
        while (true) {
            int i5 = inputStream.read(bArr);
            if (i5 == -1) {
                return crc32.getValue();
            }
            if (i5 > 0) {
                crc32.update(bArr, 0, i5);
            }
        }
    }

    private static byte[] toByteArray(InputStream inputStream, int i5, int i6, boolean z6, boolean z7) {
        int i7;
        if (i5 >= 0 && i6 >= 0) {
            int iMax = Math.max(i6, BYTE_ARRAY_MAX_OVERRIDE);
            if (i5 != Integer.MAX_VALUE || iMax != Integer.MAX_VALUE) {
                checkLength(i5, iMax);
            }
            int iMin = z7 ? Math.min(i5, iMax) : iMax;
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(calculateByteArrayInitLength(z7, i5, iMax));
            try {
                byte[] bArr = new byte[4096];
                int iMax2 = 0;
                do {
                    i7 = inputStream.read(bArr, 0, Math.min(4096, iMin - iMax2));
                    iMax2 += Math.max(i7, 0);
                    if (i7 > 0) {
                        unsynchronizedByteArrayOutputStream.write(bArr, 0, i7);
                    }
                    checkByteSizeLimit(iMax2);
                    if (iMax2 >= iMin) {
                        break;
                    }
                } while (i7 > -1);
                if (BYTE_ARRAY_MAX_OVERRIDE < 0 && i7 > -1 && !z7 && inputStream.read() >= 0) {
                    throwRecordTruncationException(iMax);
                }
                if (z6 && iMin != Integer.MAX_VALUE && iMax2 < iMin) {
                    throw new EOFException("unexpected EOF - expected len: " + iMin + " - actual len: " + iMax2);
                }
                byte[] byteArray = unsynchronizedByteArrayOutputStream.toByteArray();
                unsynchronizedByteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        throw new RecordFormatException("Can't allocate an array of length < 0");
    }

    public static long copy(InputStream inputStream, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            throw new RuntimeException(androidx.collection.a.k(parentFile, "Can't create destination directory: "));
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            long jCopy = copy(inputStream, fileOutputStream);
            fileOutputStream.close();
            return jCopy;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static byte[] toByteArray(ByteBuffer byteBuffer, int i5) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        checkByteSizeLimit(i5);
        byte[] bArr = new byte[i5];
        byteBuffer.get(bArr);
        return bArr;
    }
}
