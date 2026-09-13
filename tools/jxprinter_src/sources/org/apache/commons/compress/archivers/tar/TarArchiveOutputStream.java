package org.apache.commons.compress.archivers.tar;

import A3.AbstractC0157z;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.CountingOutputStream;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarArchiveOutputStream extends ArchiveOutputStream {
    private static final ZipEncoding ASCII = ZipEncodingHelper.getZipEncoding("ASCII");
    public static final int BIGNUMBER_ERROR = 0;
    public static final int BIGNUMBER_POSIX = 2;
    public static final int BIGNUMBER_STAR = 1;
    private static final int BLOCK_SIZE_UNSPECIFIED = -511;
    public static final int LONGFILE_ERROR = 0;
    public static final int LONGFILE_GNU = 2;
    public static final int LONGFILE_POSIX = 3;
    public static final int LONGFILE_TRUNCATE = 1;
    private static final int RECORD_SIZE = 512;
    private boolean addPaxHeadersForNonAsciiNames;
    private int bigNumberMode;
    private boolean closed;
    private final CountingOutputStream countingOut;
    private long currBytes;
    private String currName;
    private long currSize;
    final String encoding;
    private boolean finished;
    private boolean haveUnclosedEntry;
    private int longFileMode;
    private final FixedLengthBlockOutputStream out;
    private final byte[] recordBuf;
    private final int recordsPerBlock;
    private int recordsWritten;
    private final ZipEncoding zipEncoding;

    public TarArchiveOutputStream(OutputStream outputStream) {
        this(outputStream, BLOCK_SIZE_UNSPECIFIED);
    }

    private void addPaxHeaderForBigNumber(Map<String, String> map, String str, long j6, long j7) {
        if (j6 < 0 || j6 > j7) {
            map.put(str, String.valueOf(j6));
        }
    }

    private void addPaxHeadersForBigNumbers(Map<String, String> map, TarArchiveEntry tarArchiveEntry) {
        addPaxHeaderForBigNumber(map, "size", tarArchiveEntry.getSize(), TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(map, "gid", tarArchiveEntry.getLongGroupId(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(map, "mtime", tarArchiveEntry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(map, "uid", tarArchiveEntry.getLongUserId(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(map, "SCHILY.devmajor", tarArchiveEntry.getDevMajor(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(map, "SCHILY.devminor", tarArchiveEntry.getDevMinor(), TarConstants.MAXID);
        failForBigNumber("mode", tarArchiveEntry.getMode(), TarConstants.MAXID);
    }

    private byte[] encodeExtendedPaxHeadersContents(Map<String, String> map) {
        StringWriter stringWriter = new StringWriter();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            int length = value.length() + key.length() + 5;
            String str = length + " " + key + "=" + value + "\n";
            int length2 = str.getBytes(StandardCharsets.UTF_8).length;
            while (length != length2) {
                str = length2 + " " + key + "=" + value + "\n";
                int i5 = length2;
                length2 = str.getBytes(StandardCharsets.UTF_8).length;
                length = i5;
            }
            stringWriter.write(str);
        }
        return stringWriter.toString().getBytes(StandardCharsets.UTF_8);
    }

    private void failForBigNumber(String str, long j6, long j7) {
        failForBigNumber(str, j6, j7, "");
    }

    private void failForBigNumberWithPosixMessage(String str, long j6, long j7) {
        failForBigNumber(str, j6, j7, " Use STAR or POSIX extensions to overcome this limit");
    }

    private void failForBigNumbers(TarArchiveEntry tarArchiveEntry) {
        failForBigNumber("entry size", tarArchiveEntry.getSize(), TarConstants.MAXSIZE);
        failForBigNumberWithPosixMessage("group id", tarArchiveEntry.getLongGroupId(), TarConstants.MAXID);
        failForBigNumber("last modification time", tarArchiveEntry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        failForBigNumber("user id", tarArchiveEntry.getLongUserId(), TarConstants.MAXID);
        failForBigNumber("mode", tarArchiveEntry.getMode(), TarConstants.MAXID);
        failForBigNumber("major device number", tarArchiveEntry.getDevMajor(), TarConstants.MAXID);
        failForBigNumber("minor device number", tarArchiveEntry.getDevMinor(), TarConstants.MAXID);
    }

    private boolean handleLongName(TarArchiveEntry tarArchiveEntry, String str, Map<String, String> map, String str2, byte b, String str3) throws IOException {
        ByteBuffer byteBufferEncode = this.zipEncoding.encode(str);
        int iLimit = byteBufferEncode.limit() - byteBufferEncode.position();
        if (iLimit >= 100) {
            int i5 = this.longFileMode;
            if (i5 == 3) {
                map.put(str2, str);
                return true;
            }
            if (i5 == 2) {
                TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(TarConstants.GNU_LONGLINK, b);
                tarArchiveEntry2.setSize(((long) iLimit) + 1);
                transferModTime(tarArchiveEntry, tarArchiveEntry2);
                putArchiveEntry(tarArchiveEntry2);
                write(byteBufferEncode.array(), byteBufferEncode.arrayOffset(), iLimit);
                write(0);
                closeArchiveEntry();
            } else if (i5 != 1) {
                throw new IllegalArgumentException(androidx.exifinterface.media.a.A(str3, " '", str, "' is too long ( > 100 bytes)"));
            }
        }
        return false;
    }

    private void padAsNeeded() throws IOException {
        int i5 = this.recordsWritten % this.recordsPerBlock;
        if (i5 != 0) {
            while (i5 < this.recordsPerBlock) {
                writeEOFRecord();
                i5++;
            }
        }
    }

    private boolean shouldBeReplaced(char c) {
        return c == 0 || c == '/' || c == '\\';
    }

    private String stripTo7Bits(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = (char) (str.charAt(i5) & Ascii.MAX);
            if (shouldBeReplaced(cCharAt)) {
                sb.append("_");
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private void transferModTime(TarArchiveEntry tarArchiveEntry, TarArchiveEntry tarArchiveEntry2) {
        Date modTime = tarArchiveEntry.getModTime();
        long time = modTime.getTime() / 1000;
        if (time < 0 || time > TarConstants.MAXSIZE) {
            modTime = new Date(0L);
        }
        tarArchiveEntry2.setModTime(modTime);
    }

    private void writeEOFRecord() throws IOException {
        Arrays.fill(this.recordBuf, (byte) 0);
        writeRecord(this.recordBuf);
    }

    private void writeRecord(byte[] bArr) throws IOException {
        if (bArr.length != 512) {
            throw new IOException(AbstractC0157z.l("' which is not the record size of '512'", bArr.length, new StringBuilder("Record to write has length '")));
        }
        this.out.write(bArr);
        this.recordsWritten++;
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
        if (!this.haveUnclosedEntry) {
            throw new IOException("No current entry to close");
        }
        this.out.flushBlock();
        long j6 = this.currBytes;
        long j7 = this.currSize;
        if (j6 < j7) {
            StringBuilder sb = new StringBuilder("Entry '");
            sb.append(this.currName);
            sb.append("' closed at '");
            sb.append(this.currBytes);
            sb.append("' before the '");
            throw new IOException(AbstractC0157z.r(sb, this.currSize, "' bytes specified in the header were written"));
        }
        int i5 = (int) ((j7 / 512) + ((long) this.recordsWritten));
        this.recordsWritten = i5;
        if (0 != j7 % 512) {
            this.recordsWritten = i5 + 1;
        }
        this.haveUnclosedEntry = false;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File file, String str) throws IOException {
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        return new TarArchiveEntry(file, str);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            throw new IOException("This archive has already been finished");
        }
        if (this.haveUnclosedEntry) {
            throw new IOException("This archive contains unclosed entries.");
        }
        writeEOFRecord();
        writeEOFRecord();
        padAsNeeded();
        this.out.flush();
        this.finished = true;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public long getBytesWritten() {
        return this.countingOut.getBytesWritten();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    @Deprecated
    public int getCount() {
        return (int) getBytesWritten();
    }

    @Deprecated
    public int getRecordSize() {
        return 512;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    /* JADX WARN: Code duplicated, block: B:23:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:49:0x00db  */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        TarArchiveOutputStream tarArchiveOutputStream;
        boolean z6;
        int i5;
        if (this.finished) {
            throw new IOException("Stream has already been finished");
        }
        TarArchiveEntry tarArchiveEntry = (TarArchiveEntry) archiveEntry;
        if (tarArchiveEntry.isGlobalPaxHeader()) {
            byte[] bArrEncodeExtendedPaxHeadersContents = encodeExtendedPaxHeadersContents(tarArchiveEntry.getExtraPaxHeaders());
            tarArchiveEntry.setSize(bArrEncodeExtendedPaxHeadersContents.length);
            tarArchiveEntry.writeEntryHeader(this.recordBuf, this.zipEncoding, this.bigNumberMode == 1);
            writeRecord(this.recordBuf);
            this.currSize = tarArchiveEntry.getSize();
            this.currBytes = 0L;
            this.haveUnclosedEntry = true;
            write(bArrEncodeExtendedPaxHeadersContents);
            closeArchiveEntry();
            return;
        }
        HashMap map = new HashMap();
        String name = tarArchiveEntry.getName();
        boolean zHandleLongName = handleLongName(tarArchiveEntry, name, map, "path", TarConstants.LF_GNUTYPE_LONGNAME, "file name");
        String linkName = tarArchiveEntry.getLinkName();
        if (linkName != null && !linkName.isEmpty()) {
            tarArchiveOutputStream = this;
            if (tarArchiveOutputStream.handleLongName(tarArchiveEntry, linkName, map, "linkpath", TarConstants.LF_GNUTYPE_LONGLINK, "link name")) {
                z6 = true;
            }
            i5 = tarArchiveOutputStream.bigNumberMode;
            if (i5 == 2) {
                addPaxHeadersForBigNumbers(map, tarArchiveEntry);
            } else if (i5 != 1) {
                failForBigNumbers(tarArchiveEntry);
            }
            if (tarArchiveOutputStream.addPaxHeadersForNonAsciiNames && !zHandleLongName && !ASCII.canEncode(name)) {
                map.put("path", name);
            }
            if (tarArchiveOutputStream.addPaxHeadersForNonAsciiNames && !z6 && ((tarArchiveEntry.isLink() || tarArchiveEntry.isSymbolicLink()) && !ASCII.canEncode(linkName))) {
                map.put("linkpath", linkName);
            }
            map.putAll(tarArchiveEntry.getExtraPaxHeaders());
            if (!map.isEmpty()) {
                writePaxHeaders(tarArchiveEntry, name, map);
            }
            tarArchiveEntry.writeEntryHeader(tarArchiveOutputStream.recordBuf, tarArchiveOutputStream.zipEncoding, tarArchiveOutputStream.bigNumberMode == 1);
            writeRecord(tarArchiveOutputStream.recordBuf);
            tarArchiveOutputStream.currBytes = 0L;
            if (tarArchiveEntry.isDirectory()) {
                tarArchiveOutputStream.currSize = 0L;
            } else {
                tarArchiveOutputStream.currSize = tarArchiveEntry.getSize();
            }
            tarArchiveOutputStream.currName = name;
            tarArchiveOutputStream.haveUnclosedEntry = true;
        }
        tarArchiveOutputStream = this;
        z6 = false;
        i5 = tarArchiveOutputStream.bigNumberMode;
        if (i5 == 2) {
            addPaxHeadersForBigNumbers(map, tarArchiveEntry);
        } else if (i5 != 1) {
            failForBigNumbers(tarArchiveEntry);
        }
        if (tarArchiveOutputStream.addPaxHeadersForNonAsciiNames) {
            map.put("path", name);
        }
        if (tarArchiveOutputStream.addPaxHeadersForNonAsciiNames) {
            map.put("linkpath", linkName);
        }
        map.putAll(tarArchiveEntry.getExtraPaxHeaders());
        if (!map.isEmpty()) {
            writePaxHeaders(tarArchiveEntry, name, map);
        }
        tarArchiveEntry.writeEntryHeader(tarArchiveOutputStream.recordBuf, tarArchiveOutputStream.zipEncoding, tarArchiveOutputStream.bigNumberMode == 1);
        writeRecord(tarArchiveOutputStream.recordBuf);
        tarArchiveOutputStream.currBytes = 0L;
        if (tarArchiveEntry.isDirectory()) {
            tarArchiveOutputStream.currSize = 0L;
        } else {
            tarArchiveOutputStream.currSize = tarArchiveEntry.getSize();
        }
        tarArchiveOutputStream.currName = name;
        tarArchiveOutputStream.haveUnclosedEntry = true;
    }

    public void setAddPaxHeadersForNonAsciiNames(boolean z6) {
        this.addPaxHeadersForNonAsciiNames = z6;
    }

    public void setBigNumberMode(int i5) {
        this.bigNumberMode = i5;
    }

    public void setLongFileMode(int i5) {
        this.longFileMode = i5;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        if (!this.haveUnclosedEntry) {
            throw new IllegalStateException("No current tar entry");
        }
        long j6 = i6;
        if (this.currBytes + j6 <= this.currSize) {
            this.out.write(bArr, i5, i6);
            this.currBytes += j6;
        } else {
            StringBuilder sbT = AbstractC0157z.t(i6, "Request to write '", "' bytes exceeds size in header of '");
            sbT.append(this.currSize);
            sbT.append("' bytes for entry '");
            throw new IOException(AbstractC0157z.s(sbT, this.currName, "'"));
        }
    }

    public void writePaxHeaders(TarArchiveEntry tarArchiveEntry, String str, Map<String, String> map) throws IOException {
        String strSubstring = "./PaxHeaders.X/" + stripTo7Bits(str);
        if (strSubstring.length() >= 100) {
            strSubstring = strSubstring.substring(0, 99);
        }
        TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(strSubstring, TarConstants.LF_PAX_EXTENDED_HEADER_LC);
        transferModTime(tarArchiveEntry, tarArchiveEntry2);
        byte[] bArrEncodeExtendedPaxHeadersContents = encodeExtendedPaxHeadersContents(map);
        tarArchiveEntry2.setSize(bArrEncodeExtendedPaxHeadersContents.length);
        putArchiveEntry(tarArchiveEntry2);
        write(bArrEncodeExtendedPaxHeadersContents);
        closeArchiveEntry();
    }

    public TarArchiveOutputStream(OutputStream outputStream, String str) {
        this(outputStream, BLOCK_SIZE_UNSPECIFIED, str);
    }

    private void failForBigNumber(String str, long j6, long j7, String str2) {
        if (j6 < 0 || j6 > j7) {
            throw new IllegalArgumentException(str + " '" + j6 + "' is too big ( > " + j7 + " )." + str2);
        }
    }

    public TarArchiveOutputStream(OutputStream outputStream, int i5) {
        this(outputStream, i5, (String) null);
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream outputStream, int i5, int i6) {
        this(outputStream, i5, i6, null);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        if (!this.finished) {
            return new TarArchiveEntry(path, str, linkOptionArr);
        }
        throw new IOException("Stream has already been finished");
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream outputStream, int i5, int i6, String str) {
        this(outputStream, i5, str);
        if (i6 != 512) {
            throw new IllegalArgumentException(AbstractC0157z.k(i6, "Tar record size must always be 512 bytes. Attempt to set size of "));
        }
    }

    public TarArchiveOutputStream(OutputStream outputStream, int i5, String str) {
        this.longFileMode = 0;
        this.bigNumberMode = 0;
        int i6 = BLOCK_SIZE_UNSPECIFIED == i5 ? 512 : i5;
        if (i6 > 0 && i6 % 512 == 0) {
            CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
            this.countingOut = countingOutputStream;
            this.out = new FixedLengthBlockOutputStream(countingOutputStream, 512);
            this.encoding = str;
            this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
            this.recordBuf = new byte[512];
            this.recordsPerBlock = i6 / 512;
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Block size must be a multiple of 512 bytes. Attempt to use set size of "));
    }
}
