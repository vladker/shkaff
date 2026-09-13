package org.apache.commons.compress.archivers.zip;

import androidx.core.location.LocationRequestCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZipArchiveInputStream extends ArchiveInputStream implements InputStreamStatistics {
    private static final int CFH_LEN = 46;
    private static final int LFH_LEN = 30;
    private static final long TWO_EXP_32 = 4294967296L;
    private static final String USE_ZIPFILE_INSTEAD_OF_STREAM_DISCLAIMER = " while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile";
    private boolean allowStoredEntriesWithDataDescriptor;
    private final ByteBuffer buf;
    private boolean closed;
    private CurrentEntry current;
    final String encoding;
    private int entriesRead;
    private boolean hitCentralDirectory;
    private final InputStream in;
    private final Inflater inf;
    private ByteArrayInputStream lastStoredEntry;
    private final byte[] lfhBuf;
    private final byte[] shortBuf;
    private final byte[] skipBuf;
    private final boolean skipSplitSig;
    private final byte[] twoDwordBuf;
    private long uncompressedCount;
    private final boolean useUnicodeExtraFields;
    private final byte[] wordBuf;
    private final ZipEncoding zipEncoding;
    private static final byte[] LFH = ZipLong.LFH_SIG.getBytes();
    private static final byte[] CFH = ZipLong.CFH_SIG.getBytes();
    private static final byte[] DD = ZipLong.DD_SIG.getBytes();
    private static final byte[] APK_SIGNING_BLOCK_MAGIC = {65, 80, TarConstants.LF_GNUTYPE_LONGLINK, 32, TarConstants.LF_GNUTYPE_SPARSE, 105, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 32, 66, 108, 111, 99, 107, 32, TarConstants.LF_BLK, TarConstants.LF_SYMLINK};
    private static final BigInteger LONG_MAX = BigInteger.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.zip.ZipArchiveInputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod;

        static {
            int[] iArr = new int[ZipMethod.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod = iArr;
            try {
                iArr[ZipMethod.UNSHRINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.IMPLODING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.BZIP2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[ZipMethod.ENHANCED_DEFLATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ZipArchiveInputStream(InputStream inputStream) {
        this(inputStream, "UTF8");
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0066  */
    private boolean bufferContainsSignature(ByteArrayOutputStream byteArrayOutputStream, int i5, int i6, int i7) throws IOException {
        int i8;
        boolean z6 = false;
        int i9 = 0;
        while (!z6) {
            int i10 = i5 + i6;
            if (i9 >= i10 - 4) {
                break;
            }
            byte b = this.buf.array()[i9];
            byte[] bArr = LFH;
            if (b == bArr[0] && this.buf.array()[i9 + 1] == bArr[1]) {
                if (i9 >= i7 && this.buf.array()[i9 + 2] == bArr[2] && this.buf.array()[i9 + 3] == bArr[3]) {
                    i8 = i9 - i7;
                    z6 = true;
                } else {
                    int i11 = i9 + 2;
                    byte b6 = this.buf.array()[i11];
                    byte[] bArr2 = CFH;
                    if (b6 == bArr2[2] && this.buf.array()[i9 + 3] == bArr2[3]) {
                        i8 = i9 - i7;
                    } else {
                        byte b7 = this.buf.array()[i11];
                        byte[] bArr3 = DD;
                        if (b7 == bArr3[2] && this.buf.array()[i9 + 3] == bArr3[3]) {
                            i8 = i9;
                        } else {
                            i8 = i9;
                        }
                    }
                    z6 = true;
                }
                if (z6) {
                    pushback(this.buf.array(), i8, i10 - i8);
                    byteArrayOutputStream.write(this.buf.array(), 0, i8);
                    readDataDescriptor();
                }
            }
            i9++;
        }
        return z6;
    }

    private int cacheBytesRead(ByteArrayOutputStream byteArrayOutputStream, int i5, int i6, int i7) {
        int i8 = i5 + i6;
        int i9 = (i8 - i7) - 3;
        if (i9 <= 0) {
            return i8;
        }
        byteArrayOutputStream.write(this.buf.array(), 0, i9);
        int i10 = i7 + 3;
        System.arraycopy(this.buf.array(), i9, this.buf.array(), 0, i10);
        return i10;
    }

    private static boolean checksig(byte[] bArr, byte[] bArr2) {
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    private void closeEntry() throws IOException {
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        if (this.current == null) {
            return;
        }
        if (currentEntryHasOutstandingBytes()) {
            drainCurrentEntryData();
        } else {
            skip(LocationRequestCompat.PASSIVE_INTERVAL);
            int bytesInflated = (int) (this.current.bytesReadFromStream - (this.current.entry.getMethod() == 8 ? getBytesInflated() : this.current.bytesRead));
            if (bytesInflated > 0) {
                pushback(this.buf.array(), this.buf.limit() - bytesInflated, bytesInflated);
                this.current.bytesReadFromStream -= (long) bytesInflated;
            }
            if (currentEntryHasOutstandingBytes()) {
                drainCurrentEntryData();
            }
        }
        if (this.lastStoredEntry == null && this.current.hasDataDescriptor) {
            readDataDescriptor();
        }
        this.inf.reset();
        this.buf.clear().flip();
        this.current = null;
        this.lastStoredEntry = null;
    }

    private boolean currentEntryHasOutstandingBytes() {
        return this.current.bytesReadFromStream <= this.current.entry.getCompressedSize() && !this.current.hasDataDescriptor;
    }

    private void drainCurrentEntryData() throws EOFException {
        long compressedSize = this.current.entry.getCompressedSize() - this.current.bytesReadFromStream;
        while (compressedSize > 0) {
            long j6 = this.in.read(this.buf.array(), 0, (int) Math.min(this.buf.capacity(), compressedSize));
            if (j6 < 0) {
                throw new EOFException("Truncated ZIP entry: " + ArchiveUtils.sanitize(this.current.entry.getName()));
            }
            count(j6);
            compressedSize -= j6;
        }
    }

    private int fill() throws IOException {
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        int i5 = this.in.read(this.buf.array());
        if (i5 > 0) {
            this.buf.limit(i5);
            count(this.buf.limit());
            this.inf.setInput(this.buf.array(), 0, this.buf.limit());
        }
        return i5;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013  */
    /* JADX WARN: Code duplicated, block: B:14:0x0021  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:28:0x003d A[EDGE_INSN: B:28:0x003d->B:22:0x003d BREAK  A[LOOP:0: B:3:0x0003->B:32:?, LOOP_LABEL: LOOP:0: B:3:0x0003->B:32:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x003d A[EDGE_INSN: B:29:0x003d->B:22:0x003d BREAK  A[LOOP:0: B:3:0x0003->B:32:?, LOOP_LABEL: LOOP:0: B:3:0x0003->B:32:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x003d A[EDGE_INSN: B:30:0x003d->B:22:0x003d BREAK  A[LOOP:0: B:3:0x0003->B:32:?, LOOP_LABEL: LOOP:0: B:3:0x0003->B:32:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0026 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x001e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x002f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x000c A[PHI: r3
  0x000c: PHI (r3v3 int) = (r3v2 int), (r3v8 int) binds: [B:4:0x0004, B:6:0x000a] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean findEocdRecord() throws IOException {
        byte[] bArr;
        int oneByte = -1;
        loop0: while (true) {
            boolean zIsFirstByteOfEocdSig = false;
            while (true) {
                if (!zIsFirstByteOfEocdSig) {
                    oneByte = readOneByte();
                    if (oneByte <= -1) {
                        break loop0;
                    }
                    if (!isFirstByteOfEocdSig(oneByte)) {
                        break;
                    }
                    oneByte = readOneByte();
                    bArr = ZipArchiveOutputStream.EOCD_SIG;
                    if (oneByte != bArr[1]) {
                        oneByte = readOneByte();
                        if (oneByte != bArr[2]) {
                            oneByte = readOneByte();
                            if (oneByte == -1) {
                                break loop0;
                                break loop0;
                            }
                            if (oneByte == bArr[3]) {
                                return true;
                            }
                            zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                        } else {
                            if (oneByte == -1) {
                                break loop0;
                                break loop0;
                            }
                            zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                        }
                    } else {
                        if (oneByte == -1) {
                            break loop0;
                            break loop0;
                        }
                        zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                    }
                } else {
                    if (!isFirstByteOfEocdSig(oneByte)) {
                        break;
                    }
                    oneByte = readOneByte();
                    bArr = ZipArchiveOutputStream.EOCD_SIG;
                    if (oneByte != bArr[1]) {
                        oneByte = readOneByte();
                        if (oneByte != bArr[2]) {
                            oneByte = readOneByte();
                            if (oneByte == -1) {
                                break loop0;
                            }
                            if (oneByte == bArr[3]) {
                                return true;
                            }
                            zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                        } else {
                            if (oneByte == -1) {
                                break loop0;
                            }
                            zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                        }
                    } else {
                        if (oneByte == -1) {
                            break loop0;
                        }
                        zIsFirstByteOfEocdSig = isFirstByteOfEocdSig(oneByte);
                    }
                }
            }
        }
        return false;
    }

    private long getBytesInflated() {
        long bytesRead = this.inf.getBytesRead();
        if (this.current.bytesReadFromStream >= TWO_EXP_32) {
            while (true) {
                long j6 = bytesRead + TWO_EXP_32;
                if (j6 > this.current.bytesReadFromStream) {
                    break;
                }
                bytesRead = j6;
            }
        }
        return bytesRead;
    }

    private boolean isApkSigningBlock(byte[] bArr) throws IOException {
        BigInteger value = ZipEightByteInteger.getValue(bArr);
        long length = 8 - bArr.length;
        byte[] bArr2 = APK_SIGNING_BLOCK_MAGIC;
        BigInteger bigIntegerAdd = value.add(BigInteger.valueOf(length - ((long) bArr2.length)));
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2];
        try {
            if (bigIntegerAdd.signum() < 0) {
                int length3 = bArr.length + bigIntegerAdd.intValue();
                if (length3 < 8) {
                    return false;
                }
                int iAbs = Math.abs(bigIntegerAdd.intValue());
                System.arraycopy(bArr, length3, bArr3, 0, Math.min(iAbs, length2));
                if (iAbs < length2) {
                    readFully(bArr3, iAbs);
                }
            } else {
                while (true) {
                    BigInteger bigInteger = LONG_MAX;
                    if (bigIntegerAdd.compareTo(bigInteger) <= 0) {
                        break;
                    }
                    realSkip(LocationRequestCompat.PASSIVE_INTERVAL);
                    bigIntegerAdd = bigIntegerAdd.add(bigInteger.negate());
                }
                realSkip(bigIntegerAdd.longValue());
                readFully(bArr3);
            }
            return Arrays.equals(bArr3, APK_SIGNING_BLOCK_MAGIC);
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean isFirstByteOfEocdSig(int i5) {
        return i5 == ZipArchiveOutputStream.EOCD_SIG[0];
    }

    public static boolean matches(byte[] bArr, int i5) {
        byte[] bArr2 = ZipArchiveOutputStream.LFH_SIG;
        if (i5 < bArr2.length) {
            return false;
        }
        return checksig(bArr, bArr2) || checksig(bArr, ZipArchiveOutputStream.EOCD_SIG) || checksig(bArr, ZipArchiveOutputStream.DD_SIG) || checksig(bArr, ZipLong.SINGLE_SEGMENT_SPLIT_MARKER.getBytes());
    }

    private void processZip64Extra(ZipLong zipLong, ZipLong zipLong2) throws ZipException {
        ZipExtraField extraField = this.current.entry.getExtraField(Zip64ExtendedInformationExtraField.HEADER_ID);
        if (extraField != null && !(extraField instanceof Zip64ExtendedInformationExtraField)) {
            throw new ZipException("archive contains unparseable zip64 extra field");
        }
        Zip64ExtendedInformationExtraField zip64ExtendedInformationExtraField = (Zip64ExtendedInformationExtraField) extraField;
        this.current.usesZip64 = zip64ExtendedInformationExtraField != null;
        if (this.current.hasDataDescriptor) {
            return;
        }
        if (zip64ExtendedInformationExtraField != null) {
            ZipLong zipLong3 = ZipLong.ZIP64_MAGIC;
            if (zipLong3.equals(zipLong2) || zipLong3.equals(zipLong)) {
                if (zip64ExtendedInformationExtraField.getCompressedSize() == null || zip64ExtendedInformationExtraField.getSize() == null) {
                    throw new ZipException("archive contains corrupted zip64 extra field");
                }
                long longValue = zip64ExtendedInformationExtraField.getCompressedSize().getLongValue();
                if (longValue < 0) {
                    throw new ZipException("broken archive, entry with negative compressed size");
                }
                this.current.entry.setCompressedSize(longValue);
                long longValue2 = zip64ExtendedInformationExtraField.getSize().getLongValue();
                if (longValue2 < 0) {
                    throw new ZipException("broken archive, entry with negative size");
                }
                this.current.entry.setSize(longValue2);
                return;
            }
        }
        if (zipLong2 == null || zipLong == null) {
            return;
        }
        if (zipLong2.getValue() < 0) {
            throw new ZipException("broken archive, entry with negative compressed size");
        }
        this.current.entry.setCompressedSize(zipLong2.getValue());
        if (zipLong.getValue() < 0) {
            throw new ZipException("broken archive, entry with negative size");
        }
        this.current.entry.setSize(zipLong.getValue());
    }

    private void pushback(byte[] bArr, int i5, int i6) throws IOException {
        ((PushbackInputStream) this.in).unread(bArr, i5, i6);
        pushedBackBytes(i6);
    }

    private void readDataDescriptor() throws IOException {
        readFully(this.wordBuf);
        ZipLong zipLong = new ZipLong(this.wordBuf);
        if (ZipLong.DD_SIG.equals(zipLong)) {
            readFully(this.wordBuf);
            zipLong = new ZipLong(this.wordBuf);
        }
        this.current.entry.setCrc(zipLong.getValue());
        readFully(this.twoDwordBuf);
        ZipLong zipLong2 = new ZipLong(this.twoDwordBuf, 8);
        if (!zipLong2.equals(ZipLong.CFH_SIG) && !zipLong2.equals(ZipLong.LFH_SIG)) {
            long longValue = ZipEightByteInteger.getLongValue(this.twoDwordBuf);
            if (longValue < 0) {
                throw new ZipException("broken archive, entry with negative compressed size");
            }
            this.current.entry.setCompressedSize(longValue);
            long longValue2 = ZipEightByteInteger.getLongValue(this.twoDwordBuf, 8);
            if (longValue2 < 0) {
                throw new ZipException("broken archive, entry with negative size");
            }
            this.current.entry.setSize(longValue2);
            return;
        }
        pushback(this.twoDwordBuf, 8, 8);
        long value = ZipLong.getValue(this.twoDwordBuf);
        if (value < 0) {
            throw new ZipException("broken archive, entry with negative compressed size");
        }
        this.current.entry.setCompressedSize(value);
        long value2 = ZipLong.getValue(this.twoDwordBuf, 4);
        if (value2 < 0) {
            throw new ZipException("broken archive, entry with negative size");
        }
        this.current.entry.setSize(value2);
    }

    private int readDeflated(byte[] bArr, int i5, int i6) throws IOException {
        int fromInflater = readFromInflater(bArr, i5, i6);
        if (fromInflater <= 0) {
            if (this.inf.finished()) {
                return -1;
            }
            if (this.inf.needsDictionary()) {
                throw new ZipException("This archive needs a preset dictionary which is not supported by Commons Compress.");
            }
            if (fromInflater == -1) {
                throw new IOException("Truncated ZIP file");
            }
        }
        return fromInflater;
    }

    private void readFirstLocalFileHeader() throws IOException {
        readFully(this.lfhBuf);
        ZipLong zipLong = new ZipLong(this.lfhBuf);
        if (!this.skipSplitSig && zipLong.equals(ZipLong.DD_SIG)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.SPLITTING);
        }
        if (zipLong.equals(ZipLong.SINGLE_SEGMENT_SPLIT_MARKER) || zipLong.equals(ZipLong.DD_SIG)) {
            byte[] bArr = new byte[4];
            readFully(bArr);
            byte[] bArr2 = this.lfhBuf;
            System.arraycopy(bArr2, 4, bArr2, 0, 26);
            System.arraycopy(bArr, 0, this.lfhBuf, 26, 4);
        }
    }

    private int readFromInflater(byte[] bArr, int i5, int i6) throws IOException {
        int iInflate = 0;
        do {
            if (this.inf.needsInput()) {
                int iFill = fill();
                if (iFill <= 0) {
                    if (iFill == -1) {
                        return -1;
                    }
                    return iInflate;
                }
                this.current.bytesReadFromStream += (long) this.buf.limit();
            }
            try {
                iInflate = this.inf.inflate(bArr, i5, i6);
                if (iInflate != 0) {
                    break;
                }
            } catch (DataFormatException e) {
                throw ((IOException) new ZipException(e.getMessage()).initCause(e));
            }
        } while (this.inf.needsInput());
        return iInflate;
    }

    private void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0);
    }

    private int readOneByte() throws IOException {
        int i5 = this.in.read();
        if (i5 != -1) {
            count(1);
        }
        return i5;
    }

    private byte[] readRange(int i5) throws EOFException {
        byte[] range = IOUtils.readRange(this.in, i5);
        count(range.length);
        if (range.length >= i5) {
            return range;
        }
        throw new EOFException();
    }

    private int readStored(byte[] bArr, int i5, int i6) throws IOException {
        if (this.current.hasDataDescriptor) {
            if (this.lastStoredEntry == null) {
                readStoredEntry();
            }
            return this.lastStoredEntry.read(bArr, i5, i6);
        }
        long size = this.current.entry.getSize();
        if (this.current.bytesRead >= size) {
            return -1;
        }
        if (this.buf.position() >= this.buf.limit()) {
            this.buf.position(0);
            int i7 = this.in.read(this.buf.array());
            if (i7 == -1) {
                this.buf.limit(0);
                throw new IOException("Truncated ZIP file");
            }
            this.buf.limit(i7);
            count(i7);
            this.current.bytesReadFromStream += (long) i7;
        }
        int iMin = Math.min(this.buf.remaining(), i6);
        if (size - this.current.bytesRead < iMin) {
            iMin = (int) (size - this.current.bytesRead);
        }
        this.buf.get(bArr, i5, iMin);
        this.current.bytesRead += (long) iMin;
        return iMin;
    }

    private void readStoredEntry() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = this.current.usesZip64 ? 20 : 12;
        boolean zBufferContainsSignature = false;
        int iCacheBytesRead = 0;
        while (!zBufferContainsSignature) {
            int i6 = this.in.read(this.buf.array(), iCacheBytesRead, 512 - iCacheBytesRead);
            if (i6 <= 0) {
                throw new IOException("Truncated ZIP file");
            }
            int i7 = i6 + iCacheBytesRead;
            if (i7 < 4) {
                iCacheBytesRead = i7;
            } else {
                zBufferContainsSignature = bufferContainsSignature(byteArrayOutputStream, iCacheBytesRead, i6, i5);
                if (!zBufferContainsSignature) {
                    iCacheBytesRead = cacheBytesRead(byteArrayOutputStream, iCacheBytesRead, i6, i5);
                }
            }
        }
        if (this.current.entry.getCompressedSize() != this.current.entry.getSize()) {
            throw new ZipException("compressed and uncompressed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (byteArray.length != this.current.entry.getSize()) {
            throw new ZipException("actual and claimed size don't match while reading a stored entry using data descriptor. Either the archive is broken or it can not be read using ZipArchiveInputStream and you must use ZipFile. A common cause for this is a ZIP archive containing a ZIP archive. See http://commons.apache.org/proper/commons-compress/zip.html#ZipArchiveInputStream_vs_ZipFile");
        }
        this.lastStoredEntry = new ByteArrayInputStream(byteArray);
    }

    private void realSkip(long j6) throws IOException {
        long j7 = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException();
        }
        while (j7 < j6) {
            long length = j6 - j7;
            InputStream inputStream = this.in;
            byte[] bArr = this.skipBuf;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i5 = inputStream.read(bArr, 0, (int) length);
            if (i5 == -1) {
                return;
            }
            count(i5);
            j7 += (long) i5;
        }
    }

    private void skipRemainderOfArchive() throws IOException {
        int i5 = this.entriesRead;
        if (i5 > 0) {
            realSkip((((long) i5) * 46) - 30);
            if (findEocdRecord()) {
                realSkip(16L);
                readFully(this.shortBuf);
                int value = ZipShort.getValue(this.shortBuf);
                if (value >= 0) {
                    realSkip(value);
                    return;
                }
            }
        }
        throw new IOException("Truncated ZIP file");
    }

    private boolean supportsCompressedSizeFor(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getCompressedSize() != -1 || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return true;
        }
        return zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor() && this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0;
    }

    private boolean supportsDataDescriptorFor(ZipArchiveEntry zipArchiveEntry) {
        if (zipArchiveEntry.getGeneralPurposeBit().usesDataDescriptor()) {
            return (this.allowStoredEntriesWithDataDescriptor && zipArchiveEntry.getMethod() == 0) || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode();
        }
        return true;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        if (archiveEntry instanceof ZipArchiveEntry) {
            ZipArchiveEntry zipArchiveEntry = (ZipArchiveEntry) archiveEntry;
            if (ZipUtil.canHandleEntryData(zipArchiveEntry) && supportsDataDescriptorFor(zipArchiveEntry) && supportsCompressedSizeFor(zipArchiveEntry)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            this.in.close();
        } finally {
            this.inf.end();
        }
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        if (this.current.entry.getMethod() == 0) {
            return this.current.bytesRead;
        }
        if (this.current.entry.getMethod() == 8) {
            return getBytesInflated();
        }
        if (this.current.entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) {
            return ((UnshrinkingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.IMPLODING.getCode()) {
            return ((ExplodingInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) {
            return ((Deflate64CompressorInputStream) this.current.in).getCompressedCount();
        }
        if (this.current.entry.getMethod() == ZipMethod.BZIP2.getCode()) {
            return ((BZip2CompressorInputStream) this.current.in).getCompressedCount();
        }
        return -1L;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() {
        return getNextZipEntry();
    }

    public ZipArchiveEntry getNextZipEntry() throws IOException {
        boolean z6;
        ZipLong zipLong;
        ZipLong zipLong2;
        this.uncompressedCount = 0L;
        AnonymousClass1 anonymousClass1 = null;
        if (!this.closed && !this.hitCentralDirectory) {
            if (this.current != null) {
                closeEntry();
                z6 = false;
            } else {
                z6 = true;
            }
            long bytesRead = getBytesRead();
            try {
                if (z6) {
                    readFirstLocalFileHeader();
                } else {
                    readFully(this.lfhBuf);
                }
                ZipLong zipLong3 = new ZipLong(this.lfhBuf);
                if (!zipLong3.equals(ZipLong.LFH_SIG)) {
                    if (!zipLong3.equals(ZipLong.CFH_SIG) && !zipLong3.equals(ZipLong.AED_SIG) && !isApkSigningBlock(this.lfhBuf)) {
                        throw new ZipException(String.format("Unexpected record signature: 0X%X", Long.valueOf(zipLong3.getValue())));
                    }
                    this.hitCentralDirectory = true;
                    skipRemainderOfArchive();
                    return null;
                }
                this.current = new CurrentEntry(anonymousClass1);
                this.current.entry.setPlatform((ZipShort.getValue(this.lfhBuf, 4) >> 8) & 15);
                GeneralPurposeBit generalPurposeBit = GeneralPurposeBit.parse(this.lfhBuf, 6);
                boolean zUsesUTF8ForNames = generalPurposeBit.usesUTF8ForNames();
                ZipEncoding zipEncoding = zUsesUTF8ForNames ? ZipEncodingHelper.UTF8_ZIP_ENCODING : this.zipEncoding;
                this.current.hasDataDescriptor = generalPurposeBit.usesDataDescriptor();
                this.current.entry.setGeneralPurposeBit(generalPurposeBit);
                this.current.entry.setMethod(ZipShort.getValue(this.lfhBuf, 8));
                this.current.entry.setTime(ZipUtil.dosToJavaTime(ZipLong.getValue(this.lfhBuf, 10)));
                if (this.current.hasDataDescriptor) {
                    zipLong = null;
                    zipLong2 = null;
                } else {
                    this.current.entry.setCrc(ZipLong.getValue(this.lfhBuf, 14));
                    zipLong = new ZipLong(this.lfhBuf, 18);
                    zipLong2 = new ZipLong(this.lfhBuf, 22);
                }
                int value = ZipShort.getValue(this.lfhBuf, 26);
                int value2 = ZipShort.getValue(this.lfhBuf, 28);
                byte[] range = readRange(value);
                this.current.entry.setName(zipEncoding.decode(range), range);
                if (zUsesUTF8ForNames) {
                    this.current.entry.setNameSource(ZipArchiveEntry.NameSource.NAME_WITH_EFS_FLAG);
                }
                try {
                    this.current.entry.setExtra(readRange(value2));
                    if (!zUsesUTF8ForNames && this.useUnicodeExtraFields) {
                        ZipUtil.setNameAndCommentFromExtraFields(this.current.entry, range, null);
                    }
                    processZip64Extra(zipLong2, zipLong);
                    this.current.entry.setLocalHeaderOffset(bytesRead);
                    this.current.entry.setDataOffset(getBytesRead());
                    this.current.entry.setStreamContiguous(true);
                    ZipMethod methodByCode = ZipMethod.getMethodByCode(this.current.entry.getMethod());
                    if (this.current.entry.getCompressedSize() != -1) {
                        if (ZipUtil.canHandleEntryData(this.current.entry) && methodByCode != ZipMethod.STORED && methodByCode != ZipMethod.DEFLATED) {
                            BoundedInputStream boundedInputStream = new BoundedInputStream(this.in, this.current.entry.getCompressedSize());
                            int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$zip$ZipMethod[methodByCode.ordinal()];
                            if (i5 == 1) {
                                this.current.in = new UnshrinkingInputStream(boundedInputStream);
                            } else if (i5 == 2) {
                                try {
                                    CurrentEntry currentEntry = this.current;
                                    currentEntry.in = new ExplodingInputStream(currentEntry.entry.getGeneralPurposeBit().getSlidingDictionarySize(), this.current.entry.getGeneralPurposeBit().getNumberOfShannonFanoTrees(), boundedInputStream);
                                } catch (IllegalArgumentException e) {
                                    throw new IOException("bad IMPLODE data", e);
                                }
                            } else if (i5 == 3) {
                                this.current.in = new BZip2CompressorInputStream(boundedInputStream);
                            } else if (i5 == 4) {
                                this.current.in = new Deflate64CompressorInputStream(boundedInputStream);
                            }
                        }
                    } else if (methodByCode == ZipMethod.ENHANCED_DEFLATED) {
                        this.current.in = new Deflate64CompressorInputStream(this.in);
                    }
                    this.entriesRead++;
                    return this.current.entry;
                } catch (RuntimeException e6) {
                    ZipException zipException = new ZipException("Invalid extra data in entry " + this.current.entry.getName());
                    zipException.initCause(e6);
                    throw zipException;
                }
            } catch (EOFException unused) {
            }
        }
        return null;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        int deflated;
        if (i6 == 0) {
            return 0;
        }
        if (this.closed) {
            throw new IOException("The stream is closed");
        }
        CurrentEntry currentEntry = this.current;
        if (currentEntry == null) {
            return -1;
        }
        if (i5 > bArr.length || i6 < 0 || i5 < 0 || bArr.length - i5 < i6) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ZipUtil.checkRequestedFeatures(currentEntry.entry);
        if (!supportsDataDescriptorFor(this.current.entry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.DATA_DESCRIPTOR, this.current.entry);
        }
        if (!supportsCompressedSizeFor(this.current.entry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.UNKNOWN_COMPRESSED_SIZE, this.current.entry);
        }
        if (this.current.entry.getMethod() == 0) {
            deflated = readStored(bArr, i5, i6);
        } else if (this.current.entry.getMethod() == 8) {
            deflated = readDeflated(bArr, i5, i6);
        } else {
            if (this.current.entry.getMethod() != ZipMethod.UNSHRINKING.getCode() && this.current.entry.getMethod() != ZipMethod.IMPLODING.getCode() && this.current.entry.getMethod() != ZipMethod.ENHANCED_DEFLATED.getCode() && this.current.entry.getMethod() != ZipMethod.BZIP2.getCode()) {
                throw new UnsupportedZipFeatureException(ZipMethod.getMethodByCode(this.current.entry.getMethod()), this.current.entry);
            }
            deflated = this.current.in.read(bArr, i5, i6);
        }
        if (deflated >= 0) {
            this.current.crc.update(bArr, i5, deflated);
            this.uncompressedCount += (long) deflated;
        }
        return deflated;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        long j7 = 0;
        if (j6 < 0) {
            throw new IllegalArgumentException();
        }
        while (j7 < j6) {
            long length = j6 - j7;
            byte[] bArr = this.skipBuf;
            if (bArr.length <= length) {
                length = bArr.length;
            }
            int i5 = read(bArr, 0, (int) length);
            if (i5 == -1) {
                break;
            }
            j7 += (long) i5;
        }
        return j7;
    }

    public ZipArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, str, true);
    }

    private void readFully(byte[] bArr, int i5) throws IOException {
        int length = bArr.length - i5;
        int fully = IOUtils.readFully(this.in, bArr, i5, length);
        count(fully);
        if (fully < length) {
            throw new EOFException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CurrentEntry {
        private long bytesRead;
        private long bytesReadFromStream;
        private final CRC32 crc;
        private final ZipArchiveEntry entry;
        private boolean hasDataDescriptor;
        private InputStream in;
        private boolean usesZip64;

        private CurrentEntry() {
            this.entry = new ZipArchiveEntry();
            this.crc = new CRC32();
        }

        public static /* synthetic */ long access$708(CurrentEntry currentEntry) {
            long j6 = currentEntry.bytesReadFromStream;
            currentEntry.bytesReadFromStream = 1 + j6;
            return j6;
        }

        public /* synthetic */ CurrentEntry(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z6) {
        this(inputStream, str, z6, false);
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z6, boolean z7) {
        this(inputStream, str, z6, z7, false);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BoundedInputStream extends InputStream {
        private final InputStream in;
        private final long max;
        private long pos;

        public BoundedInputStream(InputStream inputStream, long j6) {
            this.max = j6;
            this.in = inputStream;
        }

        @Override // java.io.InputStream
        public int available() {
            long j6 = this.max;
            if (j6 < 0 || this.pos < j6) {
                return this.in.available();
            }
            return 0;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            long j6 = this.max;
            if (j6 >= 0 && this.pos >= j6) {
                return -1;
            }
            int i5 = this.in.read();
            this.pos++;
            ZipArchiveInputStream.this.count(1);
            CurrentEntry.access$708(ZipArchiveInputStream.this.current);
            return i5;
        }

        @Override // java.io.InputStream
        public long skip(long j6) throws IOException {
            long j7 = this.max;
            if (j7 >= 0) {
                j6 = Math.min(j6, j7 - this.pos);
            }
            long jSkip = IOUtils.skip(this.in, j6);
            this.pos += jSkip;
            return jSkip;
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
            long j6 = this.max;
            if (j6 >= 0 && this.pos >= j6) {
                return -1;
            }
            int i7 = this.in.read(bArr, i5, (int) (j6 >= 0 ? Math.min(i6, j6 - this.pos) : i6));
            if (i7 == -1) {
                return -1;
            }
            long j7 = i7;
            this.pos += j7;
            ZipArchiveInputStream.this.count(i7);
            ZipArchiveInputStream.this.current.bytesReadFromStream += j7;
            return i7;
        }
    }

    public ZipArchiveInputStream(InputStream inputStream, String str, boolean z6, boolean z7, boolean z8) {
        this.inf = new Inflater(true);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
        this.buf = byteBufferAllocate;
        this.lfhBuf = new byte[30];
        this.skipBuf = new byte[1024];
        this.shortBuf = new byte[2];
        this.wordBuf = new byte[4];
        this.twoDwordBuf = new byte[16];
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.useUnicodeExtraFields = z6;
        this.in = new PushbackInputStream(inputStream, byteBufferAllocate.capacity());
        this.allowStoredEntriesWithDataDescriptor = z7;
        this.skipSplitSig = z8;
        byteBufferAllocate.limit(0);
    }
}
