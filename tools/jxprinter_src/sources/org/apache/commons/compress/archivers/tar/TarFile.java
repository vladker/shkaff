package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.BoundedArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.BoundedSeekableByteChannelInputStream;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class TarFile implements Closeable {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final SeekableByteChannel archive;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    private final LinkedList<TarArchiveEntry> entries;
    private Map<String, String> globalPaxHeaders;
    private final List<TarArchiveStructSparse> globalSparseHeaders;
    private boolean hasHitEOF;
    private final boolean lenient;
    private final ByteBuffer recordBuffer;
    private final int recordSize;
    private final byte[] smallBuf;
    private final Map<String, List<InputStream>> sparseInputStreams;
    private final ZipEncoding zipEncoding;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class BoundedTarEntryInputStream extends BoundedArchiveInputStream {
        private final SeekableByteChannel channel;
        private int currentSparseInputStreamIndex;
        private final TarArchiveEntry entry;
        private long entryOffset;

        public BoundedTarEntryInputStream(TarArchiveEntry tarArchiveEntry, SeekableByteChannel seekableByteChannel) throws IOException {
            super(tarArchiveEntry.getDataOffset(), tarArchiveEntry.getRealSize());
            if (seekableByteChannel.size() - tarArchiveEntry.getSize() < tarArchiveEntry.getDataOffset()) {
                throw new IOException("entry size exceeds archive size");
            }
            this.entry = tarArchiveEntry;
            this.channel = seekableByteChannel;
        }

        private int readArchive(long j6, ByteBuffer byteBuffer) throws IOException {
            this.channel.position(j6);
            return this.channel.read(byteBuffer);
        }

        private int readSparse(long j6, ByteBuffer byteBuffer, int i5) throws IOException {
            List list = (List) TarFile.this.sparseInputStreams.get(this.entry.getName());
            if (list == null || list.isEmpty()) {
                return readArchive(this.entry.getDataOffset() + j6, byteBuffer);
            }
            if (this.currentSparseInputStreamIndex >= list.size()) {
                return -1;
            }
            byte[] bArr = new byte[i5];
            int i6 = ((InputStream) list.get(this.currentSparseInputStreamIndex)).read(bArr);
            if (i6 != -1) {
                byteBuffer.put(bArr, 0, i6);
            }
            if (this.currentSparseInputStreamIndex == list.size() - 1) {
                return i6;
            }
            if (i6 == -1) {
                this.currentSparseInputStreamIndex++;
                return readSparse(j6, byteBuffer, i5);
            }
            if (i6 >= i5) {
                return i6;
            }
            this.currentSparseInputStreamIndex++;
            int sparse = readSparse(j6 + ((long) i6), byteBuffer, i5 - i6);
            return sparse == -1 ? i6 : i6 + sparse;
        }

        @Override // org.apache.commons.compress.utils.BoundedArchiveInputStream
        public int read(long j6, ByteBuffer byteBuffer) throws IOException {
            if (this.entryOffset >= this.entry.getRealSize()) {
                return -1;
            }
            int sparse = this.entry.isSparse() ? readSparse(this.entryOffset, byteBuffer, byteBuffer.limit()) : readArchive(j6, byteBuffer);
            if (sparse != -1) {
                this.entryOffset += (long) sparse;
                byteBuffer.flip();
                return sparse;
            }
            if (byteBuffer.array().length > 0) {
                throw new IOException("Truncated TAR archive");
            }
            TarFile.this.setAtEOF(true);
            return sparse;
        }
    }

    public TarFile(byte[] bArr) {
        this(new SeekableInMemoryByteChannel(bArr));
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> map, List<TarArchiveStructSparse> list) throws IOException {
        this.currEntry.updateEntryFromPaxHeaders(map);
        this.currEntry.setSparseHeaders(list);
    }

    private void buildSparseInputStreams() throws IOException {
        ArrayList arrayList = new ArrayList();
        List<TarArchiveStructSparse> orderedSparseHeaders = this.currEntry.getOrderedSparseHeaders();
        TarArchiveSparseZeroInputStream tarArchiveSparseZeroInputStream = new TarArchiveSparseZeroInputStream();
        long offset = 0;
        long j6 = 0;
        for (TarArchiveStructSparse tarArchiveStructSparse : orderedSparseHeaders) {
            long offset2 = tarArchiveStructSparse.getOffset() - offset;
            if (offset2 < 0) {
                throw new IOException("Corrupted struct sparse detected");
            }
            if (offset2 > 0) {
                arrayList.add(new BoundedInputStream(tarArchiveSparseZeroInputStream, offset2));
                j6 += offset2;
            }
            if (tarArchiveStructSparse.getNumbytes() > 0) {
                long offset3 = (tarArchiveStructSparse.getOffset() + this.currEntry.getDataOffset()) - j6;
                if (tarArchiveStructSparse.getNumbytes() + offset3 < offset3) {
                    throw new IOException("Unreadable TAR archive, sparse block offset or length too big");
                }
                arrayList.add(new BoundedSeekableByteChannelInputStream(offset3, tarArchiveStructSparse.getNumbytes(), this.archive));
            }
            offset = tarArchiveStructSparse.getOffset() + tarArchiveStructSparse.getNumbytes();
        }
        this.sparseInputStreams.put(this.currEntry.getName(), arrayList);
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long jPosition = this.archive.position();
        int i5 = this.blockSize;
        long j6 = jPosition % ((long) i5);
        if (j6 > 0) {
            repositionForwardBy(((long) i5) - j6);
        }
    }

    private byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = getInputStream(this.currEntry);
        while (true) {
            try {
                int i5 = inputStream.read(this.smallBuf);
                if (i5 < 0) {
                    break;
                }
                byteArrayOutputStream.write(this.smallBuf, 0, i5);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        inputStream.close();
        getNextTarEntry();
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

    private TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF()) {
            return null;
        }
        TarArchiveEntry tarArchiveEntry = this.currEntry;
        if (tarArchiveEntry != null) {
            repositionForwardTo(this.currEntry.getSize() + tarArchiveEntry.getDataOffset());
            throwExceptionIfPositionIsNotInArchive();
            skipRecordPadding();
        }
        ByteBuffer record = getRecord();
        if (record == null) {
            this.currEntry = null;
            return null;
        }
        try {
            TarArchiveEntry tarArchiveEntry2 = new TarArchiveEntry(record.array(), this.zipEncoding, this.lenient, this.archive.position());
            this.currEntry = tarArchiveEntry2;
            if (tarArchiveEntry2.isGNULongLinkEntry()) {
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
                return this.currEntry;
            } catch (NumberFormatException e) {
                throw new IOException("Error detected parsing the pax header", e);
            }
        } catch (IllegalArgumentException e6) {
            throw new IOException("Error detected parsing the header", e6);
        }
    }

    private ByteBuffer getRecord() throws IOException {
        ByteBuffer record = readRecord();
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

    private boolean isEOFRecord(ByteBuffer byteBuffer) {
        return byteBuffer == null || ArchiveUtils.isArrayZero(byteBuffer.array(), this.recordSize);
    }

    private void paxHeaders() throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStream inputStream = getInputStream(this.currEntry);
        try {
            Map<String, String> paxHeaders = TarUtils.parsePaxHeaders(inputStream, arrayList, this.globalPaxHeaders, this.currEntry.getSize());
            if (inputStream != null) {
                inputStream.close();
            }
            if (paxHeaders.containsKey("GNU.sparse.map")) {
                arrayList = new ArrayList(TarUtils.parseFromPAX01SparseHeaders(paxHeaders.get("GNU.sparse.map")));
            }
            getNextTarEntry();
            if (this.currEntry == null) {
                throw new IOException("premature end of tar archive. Didn't find any entry after PAX header.");
            }
            applyPaxHeadersToCurrentEntry(paxHeaders, arrayList);
            if (this.currEntry.isPaxGNU1XSparse()) {
                InputStream inputStream2 = getInputStream(this.currEntry);
                try {
                    List<TarArchiveStructSparse> pAX1XSparseHeaders = TarUtils.parsePAX1XSparseHeaders(inputStream2, this.recordSize);
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    this.currEntry.setSparseHeaders(pAX1XSparseHeaders);
                    TarArchiveEntry tarArchiveEntry = this.currEntry;
                    tarArchiveEntry.setDataOffset(tarArchiveEntry.getDataOffset() + ((long) this.recordSize));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            }
            buildSparseInputStreams();
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    private void readGlobalPaxHeaders() throws IOException {
        InputStream inputStream = getInputStream(this.currEntry);
        try {
            this.globalPaxHeaders = TarUtils.parsePaxHeaders(inputStream, this.globalSparseHeaders, this.globalPaxHeaders, this.currEntry.getSize());
            if (inputStream != null) {
                inputStream.close();
            }
            getNextTarEntry();
            if (this.currEntry == null) {
                throw new IOException("Error detected parsing the pax header");
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void readOldGNUSparse() throws IOException {
        TarArchiveSparseEntry tarArchiveSparseEntry;
        if (this.currEntry.isExtended()) {
            do {
                ByteBuffer record = getRecord();
                if (record == null) {
                    throw new IOException("premature end of tar archive. Didn't find extended_header after header with extended flag.");
                }
                tarArchiveSparseEntry = new TarArchiveSparseEntry(record.array());
                this.currEntry.getSparseHeaders().addAll(tarArchiveSparseEntry.getSparseHeaders());
                TarArchiveEntry tarArchiveEntry = this.currEntry;
                tarArchiveEntry.setDataOffset(tarArchiveEntry.getDataOffset() + ((long) this.recordSize));
            } while (tarArchiveSparseEntry.isExtended());
        }
        buildSparseInputStreams();
    }

    private ByteBuffer readRecord() {
        this.recordBuffer.rewind();
        if (this.archive.read(this.recordBuffer) != this.recordSize) {
            return null;
        }
        return this.recordBuffer;
    }

    private void repositionForwardBy(long j6) throws IOException {
        repositionForwardTo(this.archive.position() + j6);
    }

    private void repositionForwardTo(long j6) throws IOException {
        if (j6 < this.archive.position()) {
            throw new IOException("trying to move backwards inside of the archive");
        }
        this.archive.position(j6);
    }

    private void skipRecordPadding() throws IOException {
        if (isDirectory() || this.currEntry.getSize() <= 0 || this.currEntry.getSize() % ((long) this.recordSize) == 0) {
            return;
        }
        long size = this.currEntry.getSize();
        int i5 = this.recordSize;
        repositionForwardBy((((size / ((long) i5)) + 1) * ((long) i5)) - this.currEntry.getSize());
        throwExceptionIfPositionIsNotInArchive();
    }

    private void throwExceptionIfPositionIsNotInArchive() throws IOException {
        if (this.archive.size() < this.archive.position()) {
            throw new IOException("Truncated TAR archive");
        }
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        try {
            if (isEOFRecord(readRecord())) {
                return;
            }
            SeekableByteChannel seekableByteChannel = this.archive;
            seekableByteChannel.position(seekableByteChannel.position() - ((long) this.recordSize));
        } catch (Throwable th) {
            SeekableByteChannel seekableByteChannel2 = this.archive;
            seekableByteChannel2.position(seekableByteChannel2.position() - ((long) this.recordSize));
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.archive.close();
    }

    public List<TarArchiveEntry> getEntries() {
        return new ArrayList(this.entries);
    }

    public InputStream getInputStream(TarArchiveEntry tarArchiveEntry) {
        try {
            return new BoundedTarEntryInputStream(tarArchiveEntry, this.archive);
        } catch (RuntimeException e) {
            throw new IOException("Corrupted TAR archive. Can't read entry", e);
        }
    }

    public final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    public final void setAtEOF(boolean z6) {
        this.hasHitEOF = z6;
    }

    public TarFile(byte[] bArr, String str) {
        this(new SeekableInMemoryByteChannel(bArr), TarConstants.DEFAULT_BLKSIZE, 512, str, false);
    }

    public TarFile(byte[] bArr, boolean z6) {
        this(new SeekableInMemoryByteChannel(bArr), TarConstants.DEFAULT_BLKSIZE, 512, null, z6);
    }

    public TarFile(File file) {
        this(file.toPath());
    }

    public TarFile(File file, String str) {
        this(file.toPath(), str);
    }

    public TarFile(File file, boolean z6) {
        this(file.toPath(), z6);
    }

    public TarFile(Path path) {
        this(Files.newByteChannel(path, new OpenOption[0]), TarConstants.DEFAULT_BLKSIZE, 512, null, false);
    }

    public TarFile(Path path, String str) {
        this(Files.newByteChannel(path, new OpenOption[0]), TarConstants.DEFAULT_BLKSIZE, 512, str, false);
    }

    public TarFile(Path path, boolean z6) {
        this(Files.newByteChannel(path, new OpenOption[0]), TarConstants.DEFAULT_BLKSIZE, 512, null, z6);
    }

    public TarFile(SeekableByteChannel seekableByteChannel) {
        this(seekableByteChannel, TarConstants.DEFAULT_BLKSIZE, 512, null, false);
    }

    public TarFile(SeekableByteChannel seekableByteChannel, int i5, int i6, String str, boolean z6) throws IOException {
        this.smallBuf = new byte[256];
        this.entries = new LinkedList<>();
        this.globalSparseHeaders = new ArrayList();
        this.globalPaxHeaders = new HashMap();
        this.sparseInputStreams = new HashMap();
        this.archive = seekableByteChannel;
        this.hasHitEOF = false;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.recordSize = i6;
        this.recordBuffer = ByteBuffer.allocate(i6);
        this.blockSize = i5;
        this.lenient = z6;
        while (true) {
            TarArchiveEntry nextTarEntry = getNextTarEntry();
            if (nextTarEntry == null) {
                return;
            } else {
                this.entries.add(nextTarEntry);
            }
        }
    }
}
