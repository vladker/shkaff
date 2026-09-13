package org.apache.commons.compress.archivers.arj;

import androidx.core.location.LocationRequestCompat;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ArjArchiveInputStream extends ArchiveInputStream {
    private static final int ARJ_MAGIC_1 = 96;
    private static final int ARJ_MAGIC_2 = 234;
    private final String charsetName;
    private InputStream currentInputStream;
    private LocalFileHeader currentLocalFileHeader;
    private final DataInputStream in;
    private final MainHeader mainHeader;

    public ArjArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.in = new DataInputStream(inputStream);
        this.charsetName = str;
        try {
            MainHeader mainHeader = readMainHeader();
            this.mainHeader = mainHeader;
            int i5 = mainHeader.arjFlags;
            if ((i5 & 1) != 0) {
                throw new ArchiveException("Encrypted ARJ files are unsupported");
            }
            if ((i5 & 4) != 0) {
                throw new ArchiveException("Multi-volume ARJ files are unsupported");
            }
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage(), e);
        }
    }

    public static boolean matches(byte[] bArr, int i5) {
        return i5 >= 2 && (bArr[0] & UnsignedBytes.MAX_VALUE) == 96 && (bArr[1] & UnsignedBytes.MAX_VALUE) == 234;
    }

    private int read16(DataInputStream dataInputStream) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        count(2);
        return Integer.reverseBytes(unsignedShort) >>> 16;
    }

    private int read32(DataInputStream dataInputStream) throws IOException {
        int i5 = dataInputStream.readInt();
        count(4);
        return Integer.reverseBytes(i5);
    }

    private int read8(DataInputStream dataInputStream) throws IOException {
        int unsignedByte = dataInputStream.readUnsignedByte();
        count(1);
        return unsignedByte;
    }

    private void readExtraData(int i5, DataInputStream dataInputStream, LocalFileHeader localFileHeader) {
        if (i5 >= 33) {
            localFileHeader.extendedFilePosition = read32(dataInputStream);
            if (i5 >= 45) {
                localFileHeader.dateTimeAccessed = read32(dataInputStream);
                localFileHeader.dateTimeCreated = read32(dataInputStream);
                localFileHeader.originalSizeEvenForVolumes = read32(dataInputStream);
                pushedBackBytes(12L);
            }
            pushedBackBytes(4L);
        }
    }

    private byte[] readHeader() throws IOException {
        boolean z6 = false;
        byte[] range = null;
        do {
            int i5 = read8(this.in);
            while (true) {
                int i6 = read8(this.in);
                if (i5 == 96 || i6 == 234) {
                    break;
                }
                i5 = i6;
            }
            int i7 = read16(this.in);
            if (i7 == 0) {
                return null;
            }
            if (i7 <= 2600) {
                range = readRange(this.in, i7);
                long j6 = ((long) read32(this.in)) & KeyboardMap.kValueMask;
                CRC32 crc32 = new CRC32();
                crc32.update(range);
                if (j6 == crc32.getValue()) {
                    z6 = true;
                }
            }
        } while (!z6);
        return range;
    }

    private LocalFileHeader readLocalFileHeader() throws IOException {
        byte[] header = readHeader();
        if (header == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(header));
        try {
            int unsignedByte = dataInputStream.readUnsignedByte();
            byte[] range = readRange(dataInputStream, unsignedByte - 1);
            pushedBackBytes(range.length);
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(range));
            try {
                LocalFileHeader localFileHeader = new LocalFileHeader();
                localFileHeader.archiverVersionNumber = dataInputStream2.readUnsignedByte();
                localFileHeader.minVersionToExtract = dataInputStream2.readUnsignedByte();
                localFileHeader.hostOS = dataInputStream2.readUnsignedByte();
                localFileHeader.arjFlags = dataInputStream2.readUnsignedByte();
                localFileHeader.method = dataInputStream2.readUnsignedByte();
                localFileHeader.fileType = dataInputStream2.readUnsignedByte();
                localFileHeader.reserved = dataInputStream2.readUnsignedByte();
                localFileHeader.dateTimeModified = read32(dataInputStream2);
                localFileHeader.compressedSize = ((long) read32(dataInputStream2)) & KeyboardMap.kValueMask;
                localFileHeader.originalSize = ((long) read32(dataInputStream2)) & KeyboardMap.kValueMask;
                localFileHeader.originalCrc32 = ((long) read32(dataInputStream2)) & KeyboardMap.kValueMask;
                localFileHeader.fileSpecPosition = read16(dataInputStream2);
                localFileHeader.fileAccessMode = read16(dataInputStream2);
                pushedBackBytes(20L);
                localFileHeader.firstChapter = dataInputStream2.readUnsignedByte();
                localFileHeader.lastChapter = dataInputStream2.readUnsignedByte();
                readExtraData(unsignedByte, dataInputStream2, localFileHeader);
                localFileHeader.name = readString(dataInputStream);
                localFileHeader.comment = readString(dataInputStream);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int i5 = read16(this.in);
                    if (i5 <= 0) {
                        localFileHeader.extendedHeaders = (byte[][]) arrayList.toArray(new byte[0][]);
                        dataInputStream2.close();
                        dataInputStream.close();
                        return localFileHeader;
                    }
                    byte[] range2 = readRange(this.in, i5);
                    long j6 = ((long) read32(this.in)) & KeyboardMap.kValueMask;
                    CRC32 crc32 = new CRC32();
                    crc32.update(range2);
                    if (j6 != crc32.getValue()) {
                        throw new IOException("Extended header CRC32 verification failure");
                    }
                    arrayList.add(range2);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        dataInputStream2.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    dataInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    private MainHeader readMainHeader() throws IOException {
        byte[] header = readHeader();
        if (header == null) {
            throw new IOException("Archive ends without any headers");
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(header));
        int unsignedByte = dataInputStream.readUnsignedByte();
        byte[] range = readRange(dataInputStream, unsignedByte - 1);
        pushedBackBytes(range.length);
        DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream(range));
        MainHeader mainHeader = new MainHeader();
        mainHeader.archiverVersionNumber = dataInputStream2.readUnsignedByte();
        mainHeader.minVersionToExtract = dataInputStream2.readUnsignedByte();
        mainHeader.hostOS = dataInputStream2.readUnsignedByte();
        mainHeader.arjFlags = dataInputStream2.readUnsignedByte();
        mainHeader.securityVersion = dataInputStream2.readUnsignedByte();
        mainHeader.fileType = dataInputStream2.readUnsignedByte();
        mainHeader.reserved = dataInputStream2.readUnsignedByte();
        mainHeader.dateTimeCreated = read32(dataInputStream2);
        mainHeader.dateTimeModified = read32(dataInputStream2);
        mainHeader.archiveSize = ((long) read32(dataInputStream2)) & KeyboardMap.kValueMask;
        mainHeader.securityEnvelopeFilePosition = read32(dataInputStream2);
        mainHeader.fileSpecPosition = read16(dataInputStream2);
        mainHeader.securityEnvelopeLength = read16(dataInputStream2);
        pushedBackBytes(20L);
        mainHeader.encryptionVersion = dataInputStream2.readUnsignedByte();
        mainHeader.lastChapter = dataInputStream2.readUnsignedByte();
        if (unsignedByte >= 33) {
            mainHeader.arjProtectionFactor = dataInputStream2.readUnsignedByte();
            mainHeader.arjFlags2 = dataInputStream2.readUnsignedByte();
            dataInputStream2.readUnsignedByte();
            dataInputStream2.readUnsignedByte();
        }
        mainHeader.name = readString(dataInputStream);
        mainHeader.comment = readString(dataInputStream);
        int i5 = read16(this.in);
        if (i5 > 0) {
            mainHeader.extendedHeaderBytes = readRange(this.in, i5);
            long j6 = ((long) read32(this.in)) & KeyboardMap.kValueMask;
            CRC32 crc32 = new CRC32();
            crc32.update(mainHeader.extendedHeaderBytes);
            if (j6 != crc32.getValue()) {
                throw new IOException("Extended header CRC32 verification failure");
            }
        }
        return mainHeader;
    }

    private byte[] readRange(InputStream inputStream, int i5) throws EOFException {
        byte[] range = IOUtils.readRange(inputStream, i5);
        count(range.length);
        if (range.length >= i5) {
            return range;
        }
        throw new EOFException();
    }

    private String readString(DataInputStream dataInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int unsignedByte = dataInputStream.readUnsignedByte();
                if (unsignedByte == 0) {
                    break;
                }
                byteArrayOutputStream.write(unsignedByte);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String str = this.charsetName;
        if (str != null) {
            String string = byteArrayOutputStream.toString(str);
            byteArrayOutputStream.close();
            return string;
        }
        String string2 = byteArrayOutputStream.toString();
        byteArrayOutputStream.close();
        return string2;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return (archiveEntry instanceof ArjArchiveEntry) && ((ArjArchiveEntry) archiveEntry).getMethod() == 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public String getArchiveComment() {
        return this.mainHeader.comment;
    }

    public String getArchiveName() {
        return this.mainHeader.name;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        LocalFileHeader localFileHeader = this.currentLocalFileHeader;
        if (localFileHeader == null) {
            throw new IllegalStateException("No current arj entry");
        }
        if (localFileHeader.method == 0) {
            return this.currentInputStream.read(bArr, i5, i6);
        }
        throw new IOException("Unsupported compression method " + this.currentLocalFileHeader.method);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArjArchiveEntry getNextEntry() throws IOException {
        InputStream inputStream = this.currentInputStream;
        if (inputStream != null) {
            IOUtils.skip(inputStream, LocationRequestCompat.PASSIVE_INTERVAL);
            this.currentInputStream.close();
            this.currentLocalFileHeader = null;
            this.currentInputStream = null;
        }
        LocalFileHeader localFileHeader = readLocalFileHeader();
        this.currentLocalFileHeader = localFileHeader;
        if (localFileHeader == null) {
            this.currentInputStream = null;
            return null;
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream(this.in, localFileHeader.compressedSize);
        this.currentInputStream = boundedInputStream;
        LocalFileHeader localFileHeader2 = this.currentLocalFileHeader;
        if (localFileHeader2.method == 0) {
            this.currentInputStream = new CRC32VerifyingInputStream(boundedInputStream, localFileHeader2.originalSize, localFileHeader2.originalCrc32);
        }
        return new ArjArchiveEntry(this.currentLocalFileHeader);
    }

    public ArjArchiveInputStream(InputStream inputStream) {
        this(inputStream, "CP437");
    }
}
