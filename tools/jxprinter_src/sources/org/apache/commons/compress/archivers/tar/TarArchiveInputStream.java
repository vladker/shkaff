package org.apache.commons.compress.archivers.tar;

import androidx.core.location.LocationRequestCompat;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    private int currentSparseInputStreamIndex;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private final List<TarArchiveStructSparse> globalSparseHeaders;
    private boolean hasHitEOF;
    private final InputStream inputStream;
    private final boolean lenient;
    private final byte[] recordBuffer;
    private final int recordSize;
    private final byte[] smallBuf;
    private List<InputStream> sparseInputStreams;
    private final ZipEncoding zipEncoding;

    public TarArchiveInputStream(InputStream inputStream) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512);
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map, List<TarArchiveStructSparse> list) throws IOException {
        this.currEntry.updateEntryFromPaxHeaders(map);
        this.currEntry.setSparseHeaders(list);
    }

    private void buildSparseInputStreams() throws IOException {
        this.currentSparseInputStreamIndex = -1;
        this.sparseInputStreams = new ArrayList();
        List<TarArchiveStructSparse> orderedSparseHeaders = this.currEntry.getOrderedSparseHeaders();
        TarArchiveSparseZeroInputStream tarArchiveSparseZeroInputStream = new TarArchiveSparseZeroInputStream();
        long offset = 0;
        for (TarArchiveStructSparse tarArchiveStructSparse : orderedSparseHeaders) {
            long offset2 = tarArchiveStructSparse.getOffset() - offset;
            if (offset2 < 0) {
                throw new IOException("Corrupted struct sparse detected");
            }
            if (offset2 > 0) {
                this.sparseInputStreams.add(new BoundedInputStream(tarArchiveSparseZeroInputStream, tarArchiveStructSparse.getOffset() - offset));
            }
            if (tarArchiveStructSparse.getNumbytes() > 0) {
                this.sparseInputStreams.add(new BoundedInputStream(this.inputStream, tarArchiveStructSparse.getNumbytes()));
            }
            offset = tarArchiveStructSparse.getOffset() + tarArchiveStructSparse.getNumbytes();
        }
        if (this.sparseInputStreams.isEmpty()) {
            return;
        }
        this.currentSparseInputStreamIndex = 0;
    }

    private void consumeRemainderOfLastBlock() {
        long bytesRead = getBytesRead();
        int i5 = this.blockSize;
        long j6 = bytesRead % ((long) i5);
        if (j6 > 0) {
            count(IOUtils.skip(this.inputStream, ((long) i5) - j6));
        }
    }

    private long getActuallySkipped(long j6, long j7, long j8) throws IOException {
        if (this.inputStream instanceof FileInputStream) {
            j7 = Math.min(j7, j6);
        }
        if (j7 == j8) {
            return j7;
        }
        throw new IOException("Truncated TAR archive");
    }

    private byte[] getRecord() throws IOException {
        byte[] record = readRecord();
        setAtEOF(isEOFRecord(record));
        if (!isAtEOF() || record == null) {
            return record;
        }
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    }

    private boolean isDirectory() {
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        return tarArchiveEntry != null && tarArchiveEntry.isDirectory();
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < 265) {
            return false;
        }
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, bArr, 263, 2)) {
            return true;
        }
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, bArr, 257, 6) && (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, bArr, 263, 2) || ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, bArr, 263, 2))) {
            return true;
        }
        return ArchiveUtils.matchAsciiBuffer("ustar\u0000", bArr, 257, 6) && ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, bArr, 263, 2);
    }

    private void paxHeaders() throws IOException {
        ArrayList arrayList = new ArrayList();
        Map<String, String> paxHeaders = TarUtils.parsePaxHeaders(this, arrayList, this.globalPaxHeaders, this.entrySize);
        if (paxHeaders.containsKey("GNU.sparse.map")) {
            arrayList = new ArrayList(TarUtils.parseFromPAX01SparseHeaders(paxHeaders.get("GNU.sparse.map")));
        }
        getNextEntry();
        if (this.currEntry == null) {
            throw new IOException("premature end of tar archive. Didn't find any entry after PAX header.");
        }
        applyPaxHeadersToCurrentEntry(paxHeaders, arrayList);
        if (this.currEntry.isPaxGNU1XSparse()) {
            this.currEntry.setSparseHeaders(TarUtils.parsePAX1XSparseHeaders(this.inputStream, this.recordSize));
        }
        buildSparseInputStreams();
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = TarUtils.parsePaxHeaders(this, this.globalSparseHeaders, this.globalPaxHeaders, this.entrySize);
        getNextEntry();
        if (this.currEntry == null) {
            throw new IOException("Error detected parsing the pax header");
        }
    }

    private void readOldGNUSparse() throws IOException {
        TarArchiveSparseEntry tarArchiveSparseEntry;
        if (this.currEntry.isExtended()) {
            do {
                byte[] record = getRecord();
                if (record == null) {
                    throw new IOException("premature end of tar archive. Didn't find extended_header after header with extended flag.");
                }
                tarArchiveSparseEntry = new TarArchiveSparseEntry(record);
                this.currEntry.getSparseHeaders().addAll(tarArchiveSparseEntry.getSparseHeaders());
            } while (tarArchiveSparseEntry.isExtended());
        }
        buildSparseInputStreams();
    }

    private int readSparse(byte[] bArr, int i5, int i6) throws IOException {
        List<InputStream> list = this.sparseInputStreams;
        if (list == null || list.isEmpty()) {
            return this.inputStream.read(bArr, i5, i6);
        }
        if (this.currentSparseInputStreamIndex >= this.sparseInputStreams.size()) {
            return -1;
        }
        int i7 = this.sparseInputStreams.get(this.currentSparseInputStreamIndex).read(bArr, i5, i6);
        if (this.currentSparseInputStreamIndex == this.sparseInputStreams.size() - 1) {
            return i7;
        }
        if (i7 == -1) {
            this.currentSparseInputStreamIndex++;
            return readSparse(bArr, i5, i6);
        }
        if (i7 >= i6) {
            return i7;
        }
        this.currentSparseInputStreamIndex++;
        int sparse = readSparse(bArr, i5 + i7, i6 - i7);
        return sparse == -1 ? i7 : i7 + sparse;
    }

    private void skipRecordPadding() {
        if (!isDirectory()) {
            long j6 = this.entrySize;
            if (j6 > 0 && j6 % ((long) this.recordSize) != 0) {
                long jAvailable = this.inputStream.available();
                long j7 = this.entrySize;
                int i5 = this.recordSize;
                long j8 = (((j7 / ((long) i5)) + 1) * ((long) i5)) - j7;
                count(getActuallySkipped(jAvailable, IOUtils.skip(this.inputStream, j8), j8));
            }
        }
    }

    private long skipSparse(long j6) {
        List<InputStream> list = this.sparseInputStreams;
        if (list == null || list.isEmpty()) {
            return this.inputStream.skip(j6);
        }
        long jSkip = 0;
        while (jSkip < j6 && this.currentSparseInputStreamIndex < this.sparseInputStreams.size()) {
            jSkip += this.sparseInputStreams.get(this.currentSparseInputStreamIndex).skip(j6 - jSkip);
            if (jSkip < j6) {
                this.currentSparseInputStreamIndex++;
            }
        }
        return jSkip;
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean zMarkSupported = this.inputStream.markSupported();
        if (zMarkSupported) {
            this.inputStream.mark(this.recordSize);
        }
        try {
            if (isEOFRecord(readRecord()) || !zMarkSupported) {
                return;
            }
            pushedBackBytes(this.recordSize);
            this.inputStream.reset();
        } catch (Throwable th) {
            if (zMarkSupported) {
                pushedBackBytes(this.recordSize);
                this.inputStream.reset();
            }
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        if (isDirectory()) {
            return 0;
        }
        if (this.currEntry.getRealSize() - this.entryOffset > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (this.currEntry.getRealSize() - this.entryOffset);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return archiveEntry instanceof TarArchiveEntry;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        List<InputStream> list = this.sparseInputStreams;
        if (list != null) {
            Iterator<InputStream> it = list.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
        this.inputStream.close();
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    public byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i5 = read(this.smallBuf);
            if (i5 < 0) {
                break;
            }
            byteArrayOutputStream.write(this.smallBuf, 0, i5);
        }
        getNextEntry();
        if (this.currEntry == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() {
        return getNextTarEntry();
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        if (this.currEntry != null) {
            IOUtils.skip(this, LocationRequestCompat.PASSIVE_INTERVAL);
            skipRecordPadding();
        }
        byte[] record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(record, this.zipEncoding, this.lenient);
            this.currEntry = tarArchiveEntry;
            this.entryOffset = 0L;
            this.entrySize = tarArchiveEntry.getSize();
            if (this.currEntry.isGNULongLinkEntry()) {
                byte[] longNameData = getLongNameData();
                if (longNameData == null) {
                    return null;
                }
                this.currEntry.setLinkName(this.zipEncoding.decode(longNameData));
            }
            if (this.currEntry.isGNULongNameEntry()) {
                byte[] longNameData2 = getLongNameData();
                if (longNameData2 == null) {
                    return null;
                }
                String strDecode = this.zipEncoding.decode(longNameData2);
                this.currEntry.setName(strDecode);
                if (this.currEntry.isDirectory() && !strDecode.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
                    this.currEntry.setName(strDecode.concat(PackagingURIHelper.FORWARD_SLASH_STRING));
                }
            }
            if (this.currEntry.isGlobalPaxHeader()) {
                readGlobalPaxHeaders();
            }
            try {
                if (this.currEntry.isPaxHeader()) {
                    paxHeaders();
                } else if (!this.globalPaxHeaders.isEmpty()) {
                    applyPaxHeadersToCurrentEntry(this.globalPaxHeaders, this.globalSparseHeaders);
                }
                if (this.currEntry.isOldGNUSparse()) {
                    readOldGNUSparse();
                }
                this.entrySize = this.currEntry.getSize();
                return this.currEntry;
            } catch (NumberFormatException e) {
                throw new IOException("Error detected parsing the pax header", e);
            }
        } catch (IllegalArgumentException e6) {
            throw new IOException("Error detected parsing the header", e6);
        }
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    public boolean isEOFRecord(byte[] bArr) {
        return bArr == null || ArchiveUtils.isArrayZero(bArr, this.recordSize);
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i5) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        if (isAtEOF() || isDirectory()) {
            return -1;
        }
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        if (tarArchiveEntry == null) {
            throw new IllegalStateException("No current tar entry");
        }
        if (this.entryOffset >= tarArchiveEntry.getRealSize()) {
            return -1;
        }
        int iMin = Math.min(i6, available());
        int sparse = this.currEntry.isSparse() ? readSparse(bArr, i5, iMin) : this.inputStream.read(bArr, i5, iMin);
        if (sparse != -1) {
            count(sparse);
            this.entryOffset += (long) sparse;
            return sparse;
        }
        if (iMin > 0) {
            throw new IOException("Truncated TAR archive");
        }
        setAtEOF(true);
        return sparse;
    }

    public byte[] readRecord() {
        int fully = IOUtils.readFully(this.inputStream, this.recordBuffer);
        count(fully);
        if (fully != this.recordSize) {
            return null;
        }
        return this.recordBuffer;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    public final void setAtEOF(boolean z6) {
        this.hasHitEOF = z6;
    }

    public final void setCurrentEntry(TarArchiveEntry tarArchiveEntry) {
        this.currEntry = tarArchiveEntry;
    }

    @Override // java.io.InputStream
    public long skip(long j6) throws IOException {
        TarArchiveInputStream tarArchiveInputStream;
        long jSkipSparse;
        if (j6 <= 0 || isDirectory()) {
            return 0L;
        }
        long jAvailable = this.inputStream.available();
        long jMin = Math.min(j6, this.currEntry.getRealSize() - this.entryOffset);
        if (this.currEntry.isSparse()) {
            tarArchiveInputStream = this;
            jSkipSparse = skipSparse(jMin);
        } else {
            jSkipSparse = getActuallySkipped(jAvailable, IOUtils.skip(this.inputStream, jMin), jMin);
            tarArchiveInputStream = this;
        }
        count(jSkipSparse);
        tarArchiveInputStream.entryOffset += jSkipSparse;
        return jSkipSparse;
    }

    public TarArchiveInputStream(InputStream inputStream, boolean z6) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, null, z6);
    }

    public TarArchiveInputStream(InputStream inputStream, String str) {
        this(inputStream, TarConstants.DEFAULT_BLKSIZE, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i5) {
        this(inputStream, i5, 512);
    }

    public TarArchiveInputStream(InputStream inputStream, int i5, String str) {
        this(inputStream, i5, 512, str);
    }

    public TarArchiveInputStream(InputStream inputStream, int i5, int i6) {
        this(inputStream, i5, i6, null);
    }

    public TarArchiveInputStream(InputStream inputStream, int i5, int i6, String str) {
        this(inputStream, i5, i6, str, false);
    }

    public TarArchiveInputStream(InputStream inputStream, int i5, int i6, String str, boolean z6) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.globalSparseHeaders = new ArrayList();
        this.inputStream = inputStream;
        this.hasHitEOF = false;
        this.encoding = str;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i6;
        this.recordBuffer = new byte[i6];
        this.blockSize = i5;
        this.lenient = z6;
    }
}
