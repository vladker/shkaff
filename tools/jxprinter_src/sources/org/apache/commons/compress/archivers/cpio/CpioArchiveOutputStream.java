package org.apache.commons.compress.archivers.cpio;

import A3.AbstractC0157z;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CpioArchiveOutputStream extends ArchiveOutputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private final short entryFormat;
    private boolean finished;
    private final HashMap<String, CpioArchiveEntry> names;
    private long nextArtificalDeviceAndInode;
    private final OutputStream out;
    private long written;
    private final ZipEncoding zipEncoding;

    public CpioArchiveOutputStream(OutputStream outputStream, short s6) {
        this(outputStream, s6, 512, "US-ASCII");
    }

    private byte[] encode(String str) {
        ByteBuffer byteBufferEncode = this.zipEncoding.encode(str);
        return Arrays.copyOfRange(byteBufferEncode.array(), byteBufferEncode.arrayOffset(), byteBufferEncode.arrayOffset() + (byteBufferEncode.limit() - byteBufferEncode.position()));
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
    }

    private void pad(int i5) throws IOException {
        if (i5 > 0) {
            this.out.write(new byte[i5]);
            count(i5);
        }
    }

    private void writeAsciiLong(long j6, int i5, int i6) throws IOException {
        String strSubstring;
        StringBuilder sb = new StringBuilder();
        if (i6 == 16) {
            sb.append(Long.toHexString(j6));
        } else if (i6 == 8) {
            sb.append(Long.toOctalString(j6));
        } else {
            sb.append(Long.toString(j6));
        }
        if (sb.length() <= i5) {
            int length = i5 - sb.length();
            for (int i7 = 0; i7 < length; i7++) {
                sb.insert(0, "0");
            }
            strSubstring = sb.toString();
        } else {
            strSubstring = sb.substring(sb.length() - i5);
        }
        byte[] asciiBytes = ArchiveUtils.toAsciiBytes(strSubstring);
        this.out.write(asciiBytes);
        count(asciiBytes.length);
    }

    private void writeBinaryLong(long j6, int i5, boolean z6) throws IOException {
        byte[] bArrLong2byteArray = CpioUtil.long2byteArray(j6, i5, z6);
        this.out.write(bArrLong2byteArray);
        count(bArrLong2byteArray.length);
    }

    private void writeCString(byte[] bArr) throws IOException {
        this.out.write(bArr);
        this.out.write(0);
        count(bArr.length + 1);
    }

    private void writeHeader(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        short format = cpioArchiveEntry.getFormat();
        if (format == 1) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW));
            count(6);
            writeNewEntry(cpioArchiveEntry);
            return;
        }
        if (format == 2) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW_CRC));
            count(6);
            writeNewEntry(cpioArchiveEntry);
        } else if (format == 4) {
            this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_OLD_ASCII));
            count(6);
            writeOldAsciiEntry(cpioArchiveEntry);
        } else if (format == 8) {
            writeBinaryLong(29127L, 2, true);
            writeOldBinaryEntry(cpioArchiveEntry, true);
        } else {
            throw new IOException("Unknown format " + ((int) cpioArchiveEntry.getFormat()));
        }
    }

    private void writeNewEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long deviceMin = cpioArchiveEntry.getDeviceMin();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            deviceMin = 0;
        } else if (inode == 0 && deviceMin == 0) {
            inode = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = inode + 1;
            deviceMin = inode >> 32;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (4294967296L * deviceMin) + inode) + 1;
        }
        writeAsciiLong(inode, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getMode(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getUID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getGID(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getTime(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getSize(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getDeviceMaj(), 8, 16);
        writeAsciiLong(deviceMin, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMaj(), 8, 16);
        writeAsciiLong(cpioArchiveEntry.getRemoteDeviceMin(), 8, 16);
        byte[] bArrEncode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) bArrEncode.length) + 1, 8, 16);
        writeAsciiLong(cpioArchiveEntry.getChksum(), 8, 16);
        writeCString(bArrEncode);
        pad(cpioArchiveEntry.getHeaderPadCount(bArrEncode.length));
    }

    private void writeOldAsciiEntry(CpioArchiveEntry cpioArchiveEntry) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j6 = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j6 + 1;
            device = 262143 & (j6 >> 18);
            inode = j6 & 262143;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (PlaybackStateCompat.ACTION_SET_REPEAT_MODE * device) + inode) + 1;
        }
        writeAsciiLong(device, 6, 8);
        writeAsciiLong(inode, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getMode(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getUID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getGID(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getNumberOfLinks(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getRemoteDevice(), 6, 8);
        writeAsciiLong(cpioArchiveEntry.getTime(), 11, 8);
        byte[] bArrEncode = encode(cpioArchiveEntry.getName());
        writeAsciiLong(((long) bArrEncode.length) + 1, 6, 8);
        writeAsciiLong(cpioArchiveEntry.getSize(), 11, 8);
        writeCString(bArrEncode);
    }

    private void writeOldBinaryEntry(CpioArchiveEntry cpioArchiveEntry, boolean z6) throws IOException {
        long inode = cpioArchiveEntry.getInode();
        long device = cpioArchiveEntry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(cpioArchiveEntry.getName())) {
            inode = 0;
            device = 0;
        } else if (inode == 0 && device == 0) {
            long j6 = this.nextArtificalDeviceAndInode;
            this.nextArtificalDeviceAndInode = j6 + 1;
            device = 65535 & (j6 >> 16);
            inode = j6 & 65535;
        } else {
            this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH * device) + inode) + 1;
        }
        writeBinaryLong(device, 2, z6);
        writeBinaryLong(inode, 2, z6);
        writeBinaryLong(cpioArchiveEntry.getMode(), 2, z6);
        writeBinaryLong(cpioArchiveEntry.getUID(), 2, z6);
        writeBinaryLong(cpioArchiveEntry.getGID(), 2, z6);
        writeBinaryLong(cpioArchiveEntry.getNumberOfLinks(), 2, z6);
        writeBinaryLong(cpioArchiveEntry.getRemoteDevice(), 2, z6);
        writeBinaryLong(cpioArchiveEntry.getTime(), 4, z6);
        byte[] bArrEncode = encode(cpioArchiveEntry.getName());
        writeBinaryLong(((long) bArrEncode.length) + 1, 2, z6);
        writeBinaryLong(cpioArchiveEntry.getSize(), 4, z6);
        writeCString(bArrEncode);
        pad(cpioArchiveEntry.getHeaderPadCount(bArrEncode.length));
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (!this.finished) {
                finish();
            }
        } finally {
            if (!this.closed) {
                this.out.close();
                this.closed = true;
            }
        }
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        ensureOpen();
        CpioArchiveEntry cpioArchiveEntry = this.entry;
        if (cpioArchiveEntry == null) {
            throw new IOException("Trying to close non-existent entry");
        }
        if (cpioArchiveEntry.getSize() != this.written) {
            StringBuilder sb = new StringBuilder("Invalid entry size (expected ");
            sb.append(this.entry.getSize());
            sb.append(" but got ");
            throw new IOException(AbstractC0157z.r(sb, this.written, " bytes)"));
        }
        pad(this.entry.getDataPadCount());
        if (this.entry.getFormat() == 2 && this.crc != this.entry.getChksum()) {
            throw new IOException("CRC Error");
        }
        this.entry = null;
        this.crc = 0L;
        this.written = 0L;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        return new CpioArchiveEntry(file, str);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        ensureOpen();
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        if (this.entry != null) {
            throw new IOException("This archive contains unclosed entries.");
        }
        CpioArchiveEntry cpioArchiveEntry = new CpioArchiveEntry(this.entryFormat);
        this.entry = cpioArchiveEntry;
        cpioArchiveEntry.setName(CpioConstants.CPIO_TRAILER);
        this.entry.setNumberOfLinks(1L);
        writeHeader(this.entry);
        closeArchiveEntry();
        long bytesWritten = getBytesWritten();
        int i5 = this.blockSize;
        int i6 = (int) (bytesWritten % ((long) i5));
        if (i6 != 0) {
            pad(i5 - i6);
        }
        this.finished = true;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        CpioArchiveEntry cpioArchiveEntry = (CpioArchiveEntry) archiveEntry;
        ensureOpen();
        if (this.entry != null) {
            closeArchiveEntry();
        }
        if (cpioArchiveEntry.getTime() == -1) {
            cpioArchiveEntry.setTime(System.currentTimeMillis() / 1000);
        }
        short format = cpioArchiveEntry.getFormat();
        if (format != this.entryFormat) {
            StringBuilder sbT = AbstractC0157z.t(format, "Header format: ", " does not match existing format: ");
            sbT.append((int) this.entryFormat);
            throw new IOException(sbT.toString());
        }
        if (this.names.put(cpioArchiveEntry.getName(), cpioArchiveEntry) != null) {
            throw new IOException("Duplicate entry: " + cpioArchiveEntry.getName());
        }
        writeHeader(cpioArchiveEntry);
        this.entry = cpioArchiveEntry;
        this.written = 0L;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        ensureOpen();
        if (i5 < 0 || i6 < 0 || i5 > bArr.length - i6) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return;
        }
        CpioArchiveEntry cpioArchiveEntry = this.entry;
        if (cpioArchiveEntry == null) {
            throw new IOException("No current CPIO entry");
        }
        long j6 = i6;
        if (this.written + j6 > cpioArchiveEntry.getSize()) {
            throw new IOException("Attempt to write past end of STORED entry");
        }
        this.out.write(bArr, i5, i6);
        this.written += j6;
        if (this.entry.getFormat() == 2) {
            for (int i7 = 0; i7 < i6; i7++) {
                this.crc = (this.crc + ((long) (bArr[i7] & UnsignedBytes.MAX_VALUE))) & KeyboardMap.kValueMask;
            }
        }
        count(i6);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s6, int i5) {
        this(outputStream, s6, i5, "US-ASCII");
    }

    public CpioArchiveOutputStream(OutputStream outputStream, short s6, int i5, String str) {
        this.names = new HashMap<>();
        this.nextArtificalDeviceAndInode = 1L;
        this.out = outputStream;
        if (s6 != 1 && s6 != 2 && s6 != 4 && s6 != 8) {
            throw new IllegalArgumentException(AbstractC0157z.k(s6, "Unknown format: "));
        }
        this.entryFormat = s6;
        this.blockSize = i5;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (!this.finished) {
            return new CpioArchiveEntry(path, str, linkOptionArr);
        }
        throw new IOException("Stream has already been finished");
    }

    public CpioArchiveOutputStream(OutputStream outputStream) {
        this(outputStream, (short) 1);
    }

    public CpioArchiveOutputStream(OutputStream outputStream, String str) {
        this(outputStream, (short) 1, 512, str);
    }
}
