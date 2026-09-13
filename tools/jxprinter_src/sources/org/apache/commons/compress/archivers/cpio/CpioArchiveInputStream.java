package org.apache.commons.compress.archivers.cpio;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CpioArchiveInputStream extends ArchiveInputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private long entryBytesRead;
    private boolean entryEOF;
    private final byte[] fourBytesBuf;
    private final InputStream in;
    private final byte[] sixBytesBuf;
    private final byte[] tmpbuf;
    private final byte[] twoBytesBuf;
    private final ZipEncoding zipEncoding;

    public CpioArchiveInputStream(InputStream inputStream) {
        this(inputStream, 512, "US-ASCII");
    }

    private void closeEntry() {
        while (skip(2147483647L) == 2147483647L) {
        }
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < 6) {
            return false;
        }
        byte b = bArr[0];
        if (b == 113 && (bArr[1] & UnsignedBytes.MAX_VALUE) == 199) {
            return true;
        }
        byte b6 = bArr[1];
        if (b6 == 113 && (b & UnsignedBytes.MAX_VALUE) == 199) {
            return true;
        }
        if (b != 48 || b6 != 55 || bArr[2] != 48 || bArr[3] != 55 || bArr[4] != 48) {
            return false;
        }
        byte b7 = bArr[5];
        return b7 == 49 || b7 == 50 || b7 == 55;
    }

    private long readAsciiLong(int i5, int i6) {
        return Long.parseLong(ArchiveUtils.toAsciiString(readRange(i5)), i6);
    }

    private long readBinaryLong(int i5, boolean z6) {
        return CpioUtil.byteArray2long(readRange(i5), z6);
    }

    private String readCString(int i5) throws EOFException {
        byte[] range = readRange(i5 - 1);
        if (this.in.read() != -1) {
            return this.zipEncoding.decode(range);
        }
        throw new EOFException();
    }

    private final int readFully(byte[] bArr, int i5, int i6) throws IOException {
        int fully = IOUtils.readFully(this.in, bArr, i5, i6);
        count(fully);
        if (fully >= i6) {
            return fully;
        }
        throw new EOFException();
    }

    private CpioArchiveEntry readNewEntry(boolean z6) throws IOException {
        CpioArchiveEntry cpioArchiveEntry = z6 ? new CpioArchiveEntry((short) 2) : new CpioArchiveEntry((short) 1);
        cpioArchiveEntry.setInode(readAsciiLong(8, 16));
        long asciiLong = readAsciiLong(8, 16);
        if (CpioUtil.fileType(asciiLong) != 0) {
            cpioArchiveEntry.setMode(asciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(8, 16));
        cpioArchiveEntry.setGID(readAsciiLong(8, 16));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(8, 16));
        cpioArchiveEntry.setTime(readAsciiLong(8, 16));
        cpioArchiveEntry.setSize(readAsciiLong(8, 16));
        if (cpioArchiveEntry.getSize() < 0) {
            throw new IOException("Found illegal entry with negative length");
        }
        cpioArchiveEntry.setDeviceMaj(readAsciiLong(8, 16));
        cpioArchiveEntry.setDeviceMin(readAsciiLong(8, 16));
        cpioArchiveEntry.setRemoteDeviceMaj(readAsciiLong(8, 16));
        cpioArchiveEntry.setRemoteDeviceMin(readAsciiLong(8, 16));
        long asciiLong2 = readAsciiLong(8, 16);
        if (asciiLong2 < 0) {
            throw new IOException("Found illegal entry with negative name length");
        }
        cpioArchiveEntry.setChksum(readAsciiLong(8, 16));
        String cString = readCString((int) asciiLong2);
        cpioArchiveEntry.setName(cString);
        if (CpioUtil.fileType(asciiLong) != 0 || cString.equals(CpioConstants.CPIO_TRAILER)) {
            skip(cpioArchiveEntry.getHeaderPadCount(asciiLong2 - 1));
            return cpioArchiveEntry;
        }
        throw new IOException("Mode 0 only allowed in the trailer. Found entry name: " + ArchiveUtils.sanitize(cString) + " Occurred at byte: " + getBytesRead());
    }

    private CpioArchiveEntry readOldAsciiEntry() throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry((short) 4);
        cpioArchiveEntry.setDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setInode(readAsciiLong(6, 8));
        long asciiLong = readAsciiLong(6, 8);
        if (CpioUtil.fileType(asciiLong) != 0) {
            cpioArchiveEntry.setMode(asciiLong);
        }
        cpioArchiveEntry.setUID(readAsciiLong(6, 8));
        cpioArchiveEntry.setGID(readAsciiLong(6, 8));
        cpioArchiveEntry.setNumberOfLinks(readAsciiLong(6, 8));
        cpioArchiveEntry.setRemoteDevice(readAsciiLong(6, 8));
        cpioArchiveEntry.setTime(readAsciiLong(11, 8));
        long asciiLong2 = readAsciiLong(6, 8);
        if (asciiLong2 < 0) {
            throw new IOException("Found illegal entry with negative name length");
        }
        cpioArchiveEntry.setSize(readAsciiLong(11, 8));
        if (cpioArchiveEntry.getSize() < 0) {
            throw new IOException("Found illegal entry with negative length");
        }
        String cString = readCString((int) asciiLong2);
        cpioArchiveEntry.setName(cString);
        if (CpioUtil.fileType(asciiLong) != 0 || cString.equals(CpioConstants.CPIO_TRAILER)) {
            return cpioArchiveEntry;
        }
        throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(cString) + " Occurred at byte: " + getBytesRead());
    }

    private CpioArchiveEntry readOldBinaryEntry(boolean z6) throws IOException {
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry((short) 8);
        cpioArchiveEntry.setDevice(readBinaryLong(2, z6));
        cpioArchiveEntry.setInode(readBinaryLong(2, z6));
        long binaryLong = readBinaryLong(2, z6);
        if (CpioUtil.fileType(binaryLong) != 0) {
            cpioArchiveEntry.setMode(binaryLong);
        }
        cpioArchiveEntry.setUID(readBinaryLong(2, z6));
        cpioArchiveEntry.setGID(readBinaryLong(2, z6));
        cpioArchiveEntry.setNumberOfLinks(readBinaryLong(2, z6));
        cpioArchiveEntry.setRemoteDevice(readBinaryLong(2, z6));
        cpioArchiveEntry.setTime(readBinaryLong(4, z6));
        long binaryLong2 = readBinaryLong(2, z6);
        if (binaryLong2 < 0) {
            throw new IOException("Found illegal entry with negative name length");
        }
        cpioArchiveEntry.setSize(readBinaryLong(4, z6));
        if (cpioArchiveEntry.getSize() < 0) {
            throw new IOException("Found illegal entry with negative length");
        }
        String cString = readCString((int) binaryLong2);
        cpioArchiveEntry.setName(cString);
        if (CpioUtil.fileType(binaryLong) != 0 || cString.equals(CpioConstants.CPIO_TRAILER)) {
            skip(cpioArchiveEntry.getHeaderPadCount(binaryLong2 - 1));
            return cpioArchiveEntry;
        }
        throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(cString) + "Occurred at byte: " + getBytesRead());
    }

    private final byte[] readRange(int i5) throws EOFException {
        byte[] range = IOUtils.readRange(this.in, i5);
        count(range.length);
        if (range.length >= i5) {
            return range;
        }
        throw new EOFException();
    }

    private void skip(int i5) throws IOException {
        if (i5 > 0) {
            readFully(this.fourBytesBuf, 0, i5);
        }
    }

    private void skipRemainderOfLastBlock() throws IOException {
        long bytesRead = getBytesRead();
        int i5 = this.blockSize;
        long j6 = bytesRead % ((long) i5);
        long j7 = j6 == 0 ? 0L : ((long) i5) - j6;
        while (j7 > 0) {
            long jSkip = skip(((long) this.blockSize) - j6);
            if (jSkip <= 0) {
                return;
            } else {
                j7 -= jSkip;
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        return this.entryEOF ? 0 : 1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.in.close();
        this.closed = true;
    }

    public CpioArchiveEntry getNextCPIOEntry() throws IOException {
        ensureOpen();
        if (this.entry != null) {
            closeEntry();
        }
        byte[] bArr = this.twoBytesBuf;
        readFully(bArr, 0, bArr.length);
        if (CpioUtil.byteArray2long(this.twoBytesBuf, false) == 29127) {
            this.entry = readOldBinaryEntry(false);
        } else if (CpioUtil.byteArray2long(this.twoBytesBuf, true) == 29127) {
            this.entry = readOldBinaryEntry(true);
        } else {
            byte[] bArr2 = this.twoBytesBuf;
            System.arraycopy(bArr2, 0, this.sixBytesBuf, 0, bArr2.length);
            readFully(this.sixBytesBuf, this.twoBytesBuf.length, this.fourBytesBuf.length);
            String asciiString = ArchiveUtils.toAsciiString(this.sixBytesBuf);
            asciiString.getClass();
            switch (asciiString) {
                case "070701":
                    this.entry = readNewEntry(false);
                    break;
                case "070702":
                    this.entry = readNewEntry(true);
                    break;
                case "070707":
                    this.entry = readOldAsciiEntry();
                    break;
                default:
                    StringBuilder sbY = AbstractC0157z.y("Unknown magic [", asciiString, "]. Occurred at byte: ");
                    sbY.append(getBytesRead());
                    throw new IOException(sbY.toString());
            }
        }
        this.entryBytesRead = 0L;
        this.entryEOF = false;
        this.crc = 0L;
        if (!this.entry.getName().equals(CpioConstants.CPIO_TRAILER)) {
            return this.entry;
        }
        this.entryEOF = true;
        skipRemainderOfLastBlock();
        return null;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() {
        return getNextCPIOEntry();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        ensureOpen();
        if (i5 < 0 || i6 < 0 || i5 > bArr.length - i6) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return 0;
        }
        CpioArchiveEntry cpioArchiveEntry = this.entry;
        if (cpioArchiveEntry == null || this.entryEOF) {
            return -1;
        }
        if (this.entryBytesRead == cpioArchiveEntry.getSize()) {
            skip(this.entry.getDataPadCount());
            this.entryEOF = true;
            if (this.entry.getFormat() != 2 || this.crc == this.entry.getChksum()) {
                return -1;
            }
            throw new IOException("CRC Error. Occurred at byte: " + getBytesRead());
        }
        int iMin = (int) Math.min(i6, this.entry.getSize() - this.entryBytesRead);
        if (iMin < 0) {
            return -1;
        }
        int fully = readFully(bArr, i5, iMin);
        if (this.entry.getFormat() == 2) {
            for (int i7 = 0; i7 < fully; i7++) {
                this.crc = (this.crc + ((long) (bArr[i7] & UnsignedBytes.MAX_VALUE))) & KeyboardMap.kValueMask;
            }
        }
        if (fully > 0) {
            this.entryBytesRead += (long) fully;
        }
        return fully;
    }

    public CpioArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, 512, str);
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        if (j6 < 0) {
            throw new IllegalArgumentException("Negative skip length");
        }
        ensureOpen();
        int iMin = (int) Math.min(j6, 2147483647L);
        int i5 = 0;
        while (i5 < iMin) {
            int length = iMin - i5;
            byte[] bArr = this.tmpbuf;
            if (length > bArr.length) {
                length = bArr.length;
            }
            int i6 = read(bArr, 0, length);
            if (i6 == -1) {
                this.entryEOF = true;
                break;
            }
            i5 += i6;
        }
        return i5;
    }

    public CpioArchiveInputStream(InputStream inputStream, int i5) {
        this(inputStream, i5, "US-ASCII");
    }

    public CpioArchiveInputStream(InputStream inputStream, int i5, String str) {
        this.tmpbuf = new byte[4096];
        this.twoBytesBuf = new byte[2];
        this.fourBytesBuf = new byte[4];
        this.sixBytesBuf = new byte[6];
        this.in = inputStream;
        if (i5 > 0) {
            this.blockSize = i5;
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            return;
        }
        throw new IllegalArgumentException("blockSize must be bigger than 0");
    }
}
