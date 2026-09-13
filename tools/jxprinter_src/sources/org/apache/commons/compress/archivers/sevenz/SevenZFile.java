package org.apache.commons.compress.archivers.sevenz;

import A3.AbstractC0157z;
import androidx.core.location.LocationRequestCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import io.flutter.embedding.android.KeyboardMap;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.CRC32;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SevenZFile implements Closeable {
    private static final String DEFAULT_FILE_NAME = "unknown archive";
    static final int SIGNATURE_HEADER_SIZE = 32;
    private final Archive archive;
    private SeekableByteChannel channel;
    private long compressedBytesReadFromCurrentEntry;
    private int currentEntryIndex;
    private int currentFolderIndex;
    private InputStream currentFolderInputStream;
    private final ArrayList<InputStream> deferredBlockStreams;
    private final String fileName;
    private final SevenZFileOptions options;
    private byte[] password;
    private long uncompressedBytesReadFromCurrentEntry;
    static final byte[] sevenZSignature = {TarConstants.LF_CONTIG, 122, -68, -81, 39, Ascii.FS};
    private static final CharsetEncoder PASSWORD_ENCODER = StandardCharsets.UTF_16LE.newEncoder();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ArchiveStatistics {
        private BitSet folderHasCrc;
        private long numberOfCoders;
        private int numberOfEntries;
        private int numberOfEntriesWithStream;
        private int numberOfFolders;
        private long numberOfInStreams;
        private long numberOfOutStreams;
        private int numberOfPackedStreams;
        private long numberOfUnpackSubStreams;

        private ArchiveStatistics() {
        }

        private long bindPairSize() {
            return 16L;
        }

        private long coderSize() {
            return 22L;
        }

        private long entrySize() {
            return 100L;
        }

        private long folderSize() {
            return 30L;
        }

        private long streamMapSize() {
            return (this.numberOfEntries * 4) + (this.numberOfPackedStreams * 8) + (this.numberOfFolders * 8);
        }

        public void assertValidity(int i5) throws IOException {
            int i6 = this.numberOfEntriesWithStream;
            if (i6 > 0 && this.numberOfFolders == 0) {
                throw new IOException("archive with entries but no folders");
            }
            if (i6 > this.numberOfUnpackSubStreams) {
                throw new IOException("archive doesn't contain enough substreams for entries");
            }
            long jEstimateSize = estimateSize() / 1024;
            if (i5 < jEstimateSize) {
                throw new MemoryLimitException(jEstimateSize, i5);
            }
        }

        public long estimateSize() {
            int i5 = this.numberOfPackedStreams;
            long jBindPairSize = ((this.numberOfOutStreams - ((long) this.numberOfFolders)) * bindPairSize()) + (this.numberOfCoders * coderSize()) + (((long) this.numberOfFolders) * folderSize()) + (((long) i5) * 16) + ((long) (i5 / 8));
            long j6 = this.numberOfInStreams;
            long j7 = this.numberOfOutStreams;
            return ((((long) this.numberOfEntries) * entrySize()) + (j7 * 8) + (((j6 - j7) + ((long) this.numberOfFolders)) * 8) + jBindPairSize + streamMapSize()) * 2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Archive with ");
            sb.append(this.numberOfEntries);
            sb.append(" entries in ");
            sb.append(this.numberOfFolders);
            sb.append(" folders. Estimated size ");
            return AbstractC0157z.r(sb, estimateSize() / 1024, " kB.");
        }
    }

    public SevenZFile(File file, char[] cArr) {
        this(file, cArr, SevenZFileOptions.DEFAULT);
    }

    private static int assertFitsIntoNonNegativeInt(String str, long j6) throws IOException {
        if (j6 <= 2147483647L && j6 >= 0) {
            return (int) j6;
        }
        throw new IOException("Cannot handle " + str + " " + j6);
    }

    private InputStream buildDecoderStack(Folder folder, long j6, int i5, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        this.channel.position(j6);
        FilterInputStream filterInputStream = new FilterInputStream(new BufferedInputStream(new BoundedSeekableByteChannelInputStream(this.channel, this.archive.packSizes[i5]))) { // from class: org.apache.commons.compress.archivers.sevenz.SevenZFile.1
            private void count(int i6) {
                SevenZFile.this.compressedBytesReadFromCurrentEntry += (long) i6;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                int i6 = ((FilterInputStream) this).in.read();
                if (i6 >= 0) {
                    count(1);
                }
                return i6;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr) {
                return read(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i6, int i7) throws IOException {
                if (i7 == 0) {
                    return 0;
                }
                int i8 = ((FilterInputStream) this).in.read(bArr, i6, i7);
                if (i8 >= 0) {
                    count(i8);
                }
                return i8;
            }
        };
        LinkedList linkedList = new LinkedList();
        InputStream inputStreamAddDecoder = filterInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            SevenZMethod sevenZMethodById = SevenZMethod.byId(coder.decompressionMethodId);
            inputStreamAddDecoder = Coders.addDecoder(this.fileName, inputStreamAddDecoder, folder.getUnpackSizeForCoder(coder), coder, this.password, this.options.getMaxMemoryLimitInKb());
            linkedList.addFirst(new SevenZMethodConfiguration(sevenZMethodById, Coders.findByMethod(sevenZMethodById).getOptionsFromCoder(coder, inputStreamAddDecoder)));
        }
        sevenZArchiveEntry.setContentMethods(linkedList);
        return folder.hasCrc ? new CRC32VerifyingInputStream(inputStreamAddDecoder, folder.getUnpackSize(), folder.crc) : inputStreamAddDecoder;
    }

    private void buildDecodingStream(int i5, boolean z6) throws IOException {
        boolean z7;
        Archive archive = this.archive;
        StreamMap streamMap = archive.streamMap;
        if (streamMap == null) {
            throw new IOException("Archive doesn't contain stream information to read entries");
        }
        int i6 = streamMap.fileFolderIndex[i5];
        if (i6 < 0) {
            this.deferredBlockStreams.clear();
            return;
        }
        SevenZArchiveEntry[] sevenZArchiveEntryArr = archive.files;
        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[i5];
        if (this.currentFolderIndex == i6) {
            if (i5 > 0) {
                sevenZArchiveEntry.setContentMethods(sevenZArchiveEntryArr[i5 - 1].getContentMethods());
            }
            if (z6 && sevenZArchiveEntry.getContentMethods() == null) {
                Archive archive2 = this.archive;
                sevenZArchiveEntry.setContentMethods(archive2.files[archive2.streamMap.folderFirstFileIndex[i6]].getContentMethods());
            }
            z7 = true;
        } else {
            this.currentFolderIndex = i6;
            reopenFolderInputStream(i6, sevenZArchiveEntry);
            z7 = false;
        }
        boolean zSkipEntriesWhenNeeded = z6 ? skipEntriesWhenNeeded(i5, z7, i6) : false;
        if (z6 && this.currentEntryIndex == i5 && !zSkipEntriesWhenNeeded) {
            return;
        }
        InputStream boundedInputStream = new BoundedInputStream(this.currentFolderInputStream, sevenZArchiveEntry.getSize());
        if (sevenZArchiveEntry.getHasCrc()) {
            boundedInputStream = new CRC32VerifyingInputStream(boundedInputStream, sevenZArchiveEntry.getSize(), sevenZArchiveEntry.getCrcValue());
        }
        this.deferredBlockStreams.add(boundedInputStream);
    }

    private void calculateStreamMap(Archive archive) throws IOException {
        Folder[] folderArr;
        StreamMap streamMap = new StreamMap();
        Folder[] folderArr2 = archive.folders;
        int length = folderArr2 != null ? folderArr2.length : 0;
        streamMap.folderFirstPackStreamIndex = new int[length];
        int length2 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            streamMap.folderFirstPackStreamIndex[i5] = length2;
            length2 += archive.folders[i5].packedStreams.length;
        }
        int length3 = archive.packSizes.length;
        streamMap.packStreamOffsets = new long[length3];
        long j6 = 0;
        for (int i6 = 0; i6 < length3; i6++) {
            streamMap.packStreamOffsets[i6] = j6;
            j6 += archive.packSizes[i6];
        }
        streamMap.folderFirstFileIndex = new int[length];
        streamMap.fileFolderIndex = new int[archive.files.length];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            SevenZArchiveEntry[] sevenZArchiveEntryArr = archive.files;
            if (i7 >= sevenZArchiveEntryArr.length) {
                archive.streamMap = streamMap;
                return;
            }
            if (sevenZArchiveEntryArr[i7].hasStream() || i8 != 0) {
                if (i8 == 0) {
                    while (true) {
                        folderArr = archive.folders;
                        if (i9 >= folderArr.length) {
                            break;
                        }
                        streamMap.folderFirstFileIndex[i9] = i7;
                        if (folderArr[i9].numUnpackSubStreams > 0) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i9 >= folderArr.length) {
                        throw new IOException("Too few folders in archive");
                    }
                }
                streamMap.fileFolderIndex[i7] = i9;
                if (archive.files[i7].hasStream() && (i8 = i8 + 1) >= archive.folders[i9].numUnpackSubStreams) {
                    i9++;
                    i8 = 0;
                }
            } else {
                streamMap.fileFolderIndex[i7] = -1;
            }
            i7++;
        }
    }

    private void checkEntryIsInitialized(Map<Integer, SevenZArchiveEntry> map, int i5) {
        if (map.get(Integer.valueOf(i5)) == null) {
            map.put(Integer.valueOf(i5), new SevenZArchiveEntry());
        }
    }

    private static void get(ByteBuffer byteBuffer, byte[] bArr) throws EOFException {
        if (byteBuffer.remaining() < bArr.length) {
            throw new EOFException();
        }
        byteBuffer.get(bArr);
    }

    private static char getChar(ByteBuffer byteBuffer) throws EOFException {
        if (byteBuffer.remaining() >= 2) {
            return byteBuffer.getChar();
        }
        throw new EOFException();
    }

    private InputStream getCurrentStream() throws IOException {
        if (this.archive.files[this.currentEntryIndex].getSize() == 0) {
            return new ByteArrayInputStream(ByteUtils.EMPTY_BYTE_ARRAY);
        }
        if (this.deferredBlockStreams.isEmpty()) {
            throw new IllegalStateException("No current 7z entry (call getNextEntry() first).");
        }
        while (this.deferredBlockStreams.size() > 1) {
            InputStream inputStreamRemove = this.deferredBlockStreams.remove(0);
            try {
                IOUtils.skip(inputStreamRemove, LocationRequestCompat.PASSIVE_INTERVAL);
                if (inputStreamRemove != null) {
                    inputStreamRemove.close();
                }
                this.compressedBytesReadFromCurrentEntry = 0L;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStreamRemove != null) {
                        try {
                            inputStreamRemove.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        return this.deferredBlockStreams.get(0);
    }

    private static int getInt(ByteBuffer byteBuffer) throws EOFException {
        if (byteBuffer.remaining() >= 4) {
            return byteBuffer.getInt();
        }
        throw new EOFException();
    }

    private static long getLong(ByteBuffer byteBuffer) throws EOFException {
        if (byteBuffer.remaining() >= 8) {
            return byteBuffer.getLong();
        }
        throw new EOFException();
    }

    private static int getUnsignedByte(ByteBuffer byteBuffer) throws EOFException {
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & UnsignedBytes.MAX_VALUE;
        }
        throw new EOFException();
    }

    private boolean hasCurrentEntryBeenRead() {
        if (this.deferredBlockStreams.isEmpty()) {
            return false;
        }
        InputStream inputStream = (InputStream) androidx.collection.a.e(this.deferredBlockStreams, 1);
        boolean z6 = (inputStream instanceof CRC32VerifyingInputStream) && ((CRC32VerifyingInputStream) inputStream).getBytesRemaining() != this.archive.files[this.currentEntryIndex].getSize();
        if (inputStream instanceof BoundedInputStream) {
            return ((BoundedInputStream) inputStream).getBytesRemaining() != this.archive.files[this.currentEntryIndex].getSize();
        }
        return z6;
    }

    private Archive initializeArchive(StartHeader startHeader, byte[] bArr, boolean z6) throws IOException {
        assertFitsIntoNonNegativeInt("nextHeaderSize", startHeader.nextHeaderSize);
        int i5 = (int) startHeader.nextHeaderSize;
        this.channel.position(startHeader.nextHeaderOffset + 32);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i5).order(ByteOrder.LITTLE_ENDIAN);
        readFully(byteBufferOrder);
        if (z6) {
            CRC32 crc32 = new CRC32();
            crc32.update(byteBufferOrder.array());
            if (startHeader.nextHeaderCrc != crc32.getValue()) {
                throw new IOException("NextHeader CRC mismatch");
            }
        }
        Archive archive = new Archive();
        int unsignedByte = getUnsignedByte(byteBufferOrder);
        if (unsignedByte == 23) {
            byteBufferOrder = readEncodedHeader(byteBufferOrder, archive, bArr);
            archive = new Archive();
            unsignedByte = getUnsignedByte(byteBufferOrder);
        }
        if (unsignedByte != 1) {
            throw new IOException("Broken or unsupported archive: no Header");
        }
        readHeader(byteBufferOrder, archive);
        archive.subStreamsInfo = null;
        return archive;
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < sevenZSignature.length) {
            return false;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr2 = sevenZSignature;
            if (i6 >= bArr2.length) {
                return true;
            }
            if (bArr[i6] != bArr2[i6]) {
                return false;
            }
            i6++;
        }
    }

    private BitSet readAllOrBits(ByteBuffer byteBuffer, int i5) {
        if (getUnsignedByte(byteBuffer) == 0) {
            return readBits(byteBuffer, i5);
        }
        BitSet bitSet = new BitSet(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            bitSet.set(i6, true);
        }
        return bitSet;
    }

    private void readArchiveProperties(ByteBuffer byteBuffer) throws EOFException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            get(byteBuffer, new byte[(int) readUint64(byteBuffer)]);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
    }

    private BitSet readBits(ByteBuffer byteBuffer, int i5) throws EOFException {
        BitSet bitSet = new BitSet(i5);
        int i6 = 0;
        int unsignedByte = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i6 == 0) {
                unsignedByte = getUnsignedByte(byteBuffer);
                i6 = 128;
            }
            bitSet.set(i7, (unsignedByte & i6) != 0);
            i6 >>>= 1;
        }
        return bitSet;
    }

    private ByteBuffer readEncodedHeader(ByteBuffer byteBuffer, Archive archive, byte[] bArr) throws IOException {
        int iPosition = byteBuffer.position();
        ArchiveStatistics archiveStatistics = new ArchiveStatistics();
        sanityCheckStreamsInfo(byteBuffer, archiveStatistics);
        archiveStatistics.assertValidity(this.options.getMaxMemoryLimitInKb());
        byteBuffer.position(iPosition);
        readStreamsInfo(byteBuffer, archive);
        Folder[] folderArr = archive.folders;
        if (folderArr == null || folderArr.length == 0) {
            throw new IOException("no folders, can't read encoded header");
        }
        long[] jArr = archive.packSizes;
        if (jArr == null || jArr.length == 0) {
            throw new IOException("no packed streams, can't read encoded header");
        }
        Folder folder = folderArr[0];
        this.channel.position(archive.packPos + 32);
        BoundedSeekableByteChannelInputStream boundedSeekableByteChannelInputStream = new BoundedSeekableByteChannelInputStream(this.channel, archive.packSizes[0]);
        InputStream cRC32VerifyingInputStream = boundedSeekableByteChannelInputStream;
        for (Coder coder : folder.getOrderedCoders()) {
            if (coder.numInStreams != 1 || coder.numOutStreams != 1) {
                throw new IOException("Multi input/output stream coders are not yet supported");
            }
            cRC32VerifyingInputStream = Coders.addDecoder(this.fileName, cRC32VerifyingInputStream, folder.getUnpackSizeForCoder(coder), coder, bArr, this.options.getMaxMemoryLimitInKb());
        }
        if (folder.hasCrc) {
            cRC32VerifyingInputStream = new CRC32VerifyingInputStream(cRC32VerifyingInputStream, folder.getUnpackSize(), folder.crc);
        }
        int iAssertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("unpackSize", folder.getUnpackSize());
        byte[] range = IOUtils.readRange(cRC32VerifyingInputStream, iAssertFitsIntoNonNegativeInt);
        if (range.length < iAssertFitsIntoNonNegativeInt) {
            throw new IOException("premature end of stream");
        }
        cRC32VerifyingInputStream.close();
        return ByteBuffer.wrap(range).order(ByteOrder.LITTLE_ENDIAN);
    }

    private void readFilesInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int uint64 = (int) readUint64(byteBuffer);
        HashMap map = new HashMap();
        BitSet bits = null;
        BitSet bits2 = null;
        BitSet bits3 = null;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            int i5 = 0;
            if (unsignedByte == 0) {
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < uint64; i8++) {
                    SevenZArchiveEntry sevenZArchiveEntry = (SevenZArchiveEntry) map.get(Integer.valueOf(i8));
                    if (sevenZArchiveEntry != null) {
                        sevenZArchiveEntry.setHasStream(bits == null || !bits.get(i8));
                        if (!sevenZArchiveEntry.hasStream()) {
                            sevenZArchiveEntry.setDirectory(bits2 == null || !bits2.get(i6));
                            sevenZArchiveEntry.setAntiItem(bits3 != null && bits3.get(i6));
                            sevenZArchiveEntry.setHasCrc(false);
                            sevenZArchiveEntry.setSize(0L);
                            i6++;
                        } else {
                            if (archive.subStreamsInfo == null) {
                                throw new IOException("Archive contains file with streams but no subStreamsInfo");
                            }
                            sevenZArchiveEntry.setDirectory(false);
                            sevenZArchiveEntry.setAntiItem(false);
                            sevenZArchiveEntry.setHasCrc(archive.subStreamsInfo.hasCrc.get(i7));
                            sevenZArchiveEntry.setCrcValue(archive.subStreamsInfo.crcs[i7]);
                            sevenZArchiveEntry.setSize(archive.subStreamsInfo.unpackSizes[i7]);
                            if (sevenZArchiveEntry.getSize() < 0) {
                                throw new IOException("broken archive, entry with negative size");
                            }
                            i7++;
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (SevenZArchiveEntry sevenZArchiveEntry2 : map.values()) {
                    if (sevenZArchiveEntry2 != null) {
                        arrayList.add(sevenZArchiveEntry2);
                    }
                }
                archive.files = (SevenZArchiveEntry[]) arrayList.toArray(SevenZArchiveEntry.EMPTY_SEVEN_Z_ARCHIVE_ENTRY_ARRAY);
                calculateStreamMap(archive);
                return;
            }
            long uint65 = readUint64(byteBuffer);
            if (unsignedByte != 25) {
                switch (unsignedByte) {
                    case 14:
                        bits = readBits(byteBuffer, uint64);
                        break;
                    case 15:
                        bits2 = readBits(byteBuffer, bits.cardinality());
                        break;
                    case 16:
                        bits3 = readBits(byteBuffer, bits.cardinality());
                        break;
                    case 17:
                        getUnsignedByte(byteBuffer);
                        int i9 = (int) (uint65 - 1);
                        byte[] bArr = new byte[i9];
                        get(byteBuffer, bArr);
                        int i10 = 0;
                        int i11 = 0;
                        while (i5 < i9) {
                            if (bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                                checkEntryIsInitialized(map, i11);
                                ((SevenZArchiveEntry) map.get(Integer.valueOf(i11))).setName(new String(bArr, i10, i5 - i10, StandardCharsets.UTF_16LE));
                                i11++;
                                i10 = i5 + 2;
                            }
                            i5 += 2;
                        }
                        if (i10 != i9 || i11 != uint64) {
                            throw new IOException("Error parsing file names");
                        }
                        break;
                        break;
                    case 18:
                        BitSet allOrBits = readAllOrBits(byteBuffer, uint64);
                        getUnsignedByte(byteBuffer);
                        while (i5 < uint64) {
                            checkEntryIsInitialized(map, i5);
                            SevenZArchiveEntry sevenZArchiveEntry3 = (SevenZArchiveEntry) map.get(Integer.valueOf(i5));
                            sevenZArchiveEntry3.setHasCreationDate(allOrBits.get(i5));
                            if (sevenZArchiveEntry3.getHasCreationDate()) {
                                sevenZArchiveEntry3.setCreationDate(getLong(byteBuffer));
                            }
                            i5++;
                        }
                        break;
                    case 19:
                        BitSet allOrBits2 = readAllOrBits(byteBuffer, uint64);
                        getUnsignedByte(byteBuffer);
                        while (i5 < uint64) {
                            checkEntryIsInitialized(map, i5);
                            SevenZArchiveEntry sevenZArchiveEntry4 = (SevenZArchiveEntry) map.get(Integer.valueOf(i5));
                            sevenZArchiveEntry4.setHasAccessDate(allOrBits2.get(i5));
                            if (sevenZArchiveEntry4.getHasAccessDate()) {
                                sevenZArchiveEntry4.setAccessDate(getLong(byteBuffer));
                            }
                            i5++;
                        }
                        break;
                    case 20:
                        BitSet allOrBits3 = readAllOrBits(byteBuffer, uint64);
                        getUnsignedByte(byteBuffer);
                        while (i5 < uint64) {
                            checkEntryIsInitialized(map, i5);
                            SevenZArchiveEntry sevenZArchiveEntry5 = (SevenZArchiveEntry) map.get(Integer.valueOf(i5));
                            sevenZArchiveEntry5.setHasLastModifiedDate(allOrBits3.get(i5));
                            if (sevenZArchiveEntry5.getHasLastModifiedDate()) {
                                sevenZArchiveEntry5.setLastModifiedDate(getLong(byteBuffer));
                            }
                            i5++;
                        }
                        break;
                    case 21:
                        BitSet allOrBits4 = readAllOrBits(byteBuffer, uint64);
                        getUnsignedByte(byteBuffer);
                        while (i5 < uint64) {
                            checkEntryIsInitialized(map, i5);
                            SevenZArchiveEntry sevenZArchiveEntry6 = (SevenZArchiveEntry) map.get(Integer.valueOf(i5));
                            sevenZArchiveEntry6.setHasWindowsAttributes(allOrBits4.get(i5));
                            if (sevenZArchiveEntry6.getHasWindowsAttributes()) {
                                sevenZArchiveEntry6.setWindowsAttributes(getInt(byteBuffer));
                            }
                            i5++;
                        }
                        break;
                    default:
                        skipBytesFully(byteBuffer, uint65);
                        break;
                }
            } else {
                skipBytesFully(byteBuffer, uint65);
            }
        }
    }

    private Folder readFolder(ByteBuffer byteBuffer) throws IOException {
        Folder folder = new Folder();
        int uint64 = (int) readUint64(byteBuffer);
        Coder[] coderArr = new Coder[uint64];
        long j6 = 0;
        long j7 = 0;
        for (int i5 = 0; i5 < uint64; i5++) {
            coderArr[i5] = new Coder();
            int unsignedByte = getUnsignedByte(byteBuffer);
            int i6 = unsignedByte & 15;
            boolean z6 = (unsignedByte & 16) == 0;
            boolean z7 = (unsignedByte & 32) != 0;
            boolean z8 = (unsignedByte & 128) != 0;
            byte[] bArr = new byte[i6];
            coderArr[i5].decompressionMethodId = bArr;
            get(byteBuffer, bArr);
            if (z6) {
                Coder coder = coderArr[i5];
                coder.numInStreams = 1L;
                coder.numOutStreams = 1L;
            } else {
                coderArr[i5].numInStreams = readUint64(byteBuffer);
                coderArr[i5].numOutStreams = readUint64(byteBuffer);
            }
            Coder coder2 = coderArr[i5];
            j6 += coder2.numInStreams;
            j7 += coder2.numOutStreams;
            if (z7) {
                byte[] bArr2 = new byte[(int) readUint64(byteBuffer)];
                coderArr[i5].properties = bArr2;
                get(byteBuffer, bArr2);
            }
            if (z8) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
        }
        folder.coders = coderArr;
        folder.totalInputStreams = j6;
        folder.totalOutputStreams = j7;
        long j8 = j7 - 1;
        int i7 = (int) j8;
        BindPair[] bindPairArr = new BindPair[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            BindPair bindPair = new BindPair();
            bindPairArr[i8] = bindPair;
            bindPair.inIndex = readUint64(byteBuffer);
            bindPairArr[i8].outIndex = readUint64(byteBuffer);
        }
        folder.bindPairs = bindPairArr;
        long j9 = j6 - j8;
        int i9 = (int) j9;
        long[] jArr = new long[i9];
        if (j9 == 1) {
            int i10 = 0;
            while (i10 < ((int) j6) && folder.findBindPairForInStream(i10) >= 0) {
                i10++;
            }
            jArr[0] = i10;
        } else {
            for (int i11 = 0; i11 < i9; i11++) {
                jArr[i11] = readUint64(byteBuffer);
            }
        }
        folder.packedStreams = jArr;
        return folder;
    }

    private void readFully(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.rewind();
        IOUtils.readFully(this.channel, byteBuffer);
        byteBuffer.flip();
    }

    private void readHeader(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int iPosition = byteBuffer.position();
        sanityCheckAndCollectStatistics(byteBuffer).assertValidity(this.options.getMaxMemoryLimitInKb());
        byteBuffer.position(iPosition);
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            readArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (unsignedByte == 4) {
            readStreamsInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 5) {
            readFilesInfo(byteBuffer, archive);
            getUnsignedByte(byteBuffer);
        }
    }

    private Archive readHeaders(byte[] bArr) throws IOException {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(12).order(ByteOrder.LITTLE_ENDIAN);
        readFully(byteBufferOrder);
        byte[] bArr2 = new byte[6];
        byteBufferOrder.get(bArr2);
        if (!Arrays.equals(bArr2, sevenZSignature)) {
            throw new IOException("Bad 7z signature");
        }
        byte b = byteBufferOrder.get();
        byte b6 = byteBufferOrder.get();
        if (b != 0) {
            throw new IOException(String.format("Unsupported 7z version (%d,%d)", Byte.valueOf(b), Byte.valueOf(b6)));
        }
        long j6 = ((long) byteBufferOrder.getInt()) & KeyboardMap.kValueMask;
        if (j6 == 0) {
            long jPosition = this.channel.position();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
            readFully(byteBufferAllocate);
            this.channel.position(jPosition);
            while (byteBufferAllocate.hasRemaining()) {
                if (byteBufferAllocate.get() != 0) {
                }
            }
            if (this.options.getTryToRecoverBrokenArchives()) {
                return tryToLocateEndHeader(bArr);
            }
            throw new IOException("archive seems to be invalid.\nYou may want to retry and enable the tryToRecoverBrokenArchives if the archive could be a multi volume archive that has been closed prematurely.");
        }
        return initializeArchive(readStartHeader(j6), bArr, true);
    }

    private void readPackInfo(ByteBuffer byteBuffer, Archive archive) throws EOFException {
        archive.packPos = readUint64(byteBuffer);
        int uint64 = (int) readUint64(byteBuffer);
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 9) {
            archive.packSizes = new long[uint64];
            int i5 = 0;
            while (true) {
                long[] jArr = archive.packSizes;
                if (i5 >= jArr.length) {
                    break;
                }
                jArr[i5] = readUint64(byteBuffer);
                i5++;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 10) {
            archive.packCrcsDefined = readAllOrBits(byteBuffer, uint64);
            archive.packCrcs = new long[uint64];
            for (int i6 = 0; i6 < uint64; i6++) {
                if (archive.packCrcsDefined.get(i6)) {
                    archive.packCrcs[i6] = ((long) getInt(byteBuffer)) & KeyboardMap.kValueMask;
                }
            }
            getUnsignedByte(byteBuffer);
        }
    }

    private StartHeader readStartHeader(long j6) throws IOException {
        StartHeader startHeader = new StartHeader();
        DataInputStream dataInputStream = new DataInputStream(new CRC32VerifyingInputStream(new BoundedSeekableByteChannelInputStream(this.channel, 20L), 20L, j6));
        try {
            long jReverseBytes = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderOffset = jReverseBytes;
            if (jReverseBytes < 0 || jReverseBytes + 32 > this.channel.size()) {
                throw new IOException("nextHeaderOffset is out of bounds");
            }
            long jReverseBytes2 = Long.reverseBytes(dataInputStream.readLong());
            startHeader.nextHeaderSize = jReverseBytes2;
            long j7 = startHeader.nextHeaderOffset;
            long j8 = jReverseBytes2 + j7;
            if (j8 < j7 || j8 + 32 > this.channel.size()) {
                throw new IOException("nextHeaderSize is out of bounds");
            }
            startHeader.nextHeaderCrc = ((long) Integer.reverseBytes(dataInputStream.readInt())) & KeyboardMap.kValueMask;
            dataInputStream.close();
            return startHeader;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    dataInputStream.close();
                    throw th2;
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                    throw th2;
                }
            }
        }
    }

    private void readStreamsInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            readPackInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            readUnpackInfo(byteBuffer, archive);
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            archive.folders = Folder.EMPTY_FOLDER_ARRAY;
        }
        if (unsignedByte == 8) {
            readSubStreamsInfo(byteBuffer, archive);
            getUnsignedByte(byteBuffer);
        }
    }

    private void readSubStreamsInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        for (Folder folder : archive.folders) {
            folder.numUnpackSubStreams = 1;
        }
        long length = archive.folders.length;
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 13) {
            long j6 = 0;
            for (Folder folder2 : archive.folders) {
                long uint64 = readUint64(byteBuffer);
                folder2.numUnpackSubStreams = (int) uint64;
                j6 += uint64;
            }
            unsignedByte = getUnsignedByte(byteBuffer);
            length = j6;
        }
        int i5 = (int) length;
        SubStreamsInfo subStreamsInfo = new SubStreamsInfo();
        subStreamsInfo.unpackSizes = new long[i5];
        subStreamsInfo.hasCrc = new BitSet(i5);
        subStreamsInfo.crcs = new long[i5];
        int i6 = 0;
        for (Folder folder3 : archive.folders) {
            if (folder3.numUnpackSubStreams != 0) {
                long j7 = 0;
                if (unsignedByte == 9) {
                    int i7 = 0;
                    while (i7 < folder3.numUnpackSubStreams - 1) {
                        long uint65 = readUint64(byteBuffer);
                        subStreamsInfo.unpackSizes[i6] = uint65;
                        j7 += uint65;
                        i7++;
                        i6++;
                    }
                }
                if (j7 > folder3.getUnpackSize()) {
                    throw new IOException("sum of unpack sizes of folder exceeds total unpack size");
                }
                subStreamsInfo.unpackSizes[i6] = folder3.getUnpackSize() - j7;
                i6++;
            }
        }
        if (unsignedByte == 9) {
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        int i8 = 0;
        for (Folder folder4 : archive.folders) {
            int i9 = folder4.numUnpackSubStreams;
            if (i9 != 1 || !folder4.hasCrc) {
                i8 += i9;
            }
        }
        if (unsignedByte == 10) {
            BitSet allOrBits = readAllOrBits(byteBuffer, i8);
            long[] jArr = new long[i8];
            for (int i10 = 0; i10 < i8; i10++) {
                if (allOrBits.get(i10)) {
                    jArr[i10] = ((long) getInt(byteBuffer)) & KeyboardMap.kValueMask;
                }
            }
            int i11 = 0;
            int i12 = 0;
            for (Folder folder5 : archive.folders) {
                if (folder5.numUnpackSubStreams == 1 && folder5.hasCrc) {
                    subStreamsInfo.hasCrc.set(i11, true);
                    subStreamsInfo.crcs[i11] = folder5.crc;
                    i11++;
                } else {
                    for (int i13 = 0; i13 < folder5.numUnpackSubStreams; i13++) {
                        subStreamsInfo.hasCrc.set(i11, allOrBits.get(i12));
                        subStreamsInfo.crcs[i11] = jArr[i12];
                        i11++;
                        i12++;
                    }
                }
            }
            getUnsignedByte(byteBuffer);
        }
        archive.subStreamsInfo = subStreamsInfo;
    }

    private static long readUint64(ByteBuffer byteBuffer) {
        long unsignedByte = getUnsignedByte(byteBuffer);
        int i5 = 128;
        long unsignedByte2 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            if ((((long) i5) & unsignedByte) == 0) {
                return ((unsignedByte & ((long) (i5 - 1))) << (i6 * 8)) | unsignedByte2;
            }
            unsignedByte2 |= ((long) getUnsignedByte(byteBuffer)) << (i6 * 8);
            i5 >>>= 1;
        }
        return unsignedByte2;
    }

    private void readUnpackInfo(ByteBuffer byteBuffer, Archive archive) throws IOException {
        getUnsignedByte(byteBuffer);
        int uint64 = (int) readUint64(byteBuffer);
        Folder[] folderArr = new Folder[uint64];
        archive.folders = folderArr;
        getUnsignedByte(byteBuffer);
        for (int i5 = 0; i5 < uint64; i5++) {
            folderArr[i5] = readFolder(byteBuffer);
        }
        getUnsignedByte(byteBuffer);
        for (int i6 = 0; i6 < uint64; i6++) {
            Folder folder = folderArr[i6];
            assertFitsIntoNonNegativeInt("totalOutputStreams", folder.totalOutputStreams);
            folder.unpackSizes = new long[(int) folder.totalOutputStreams];
            for (int i7 = 0; i7 < folder.totalOutputStreams; i7++) {
                folder.unpackSizes[i7] = readUint64(byteBuffer);
            }
        }
        if (getUnsignedByte(byteBuffer) == 10) {
            BitSet allOrBits = readAllOrBits(byteBuffer, uint64);
            for (int i8 = 0; i8 < uint64; i8++) {
                if (allOrBits.get(i8)) {
                    Folder folder2 = folderArr[i8];
                    folder2.hasCrc = true;
                    folder2.crc = ((long) getInt(byteBuffer)) & KeyboardMap.kValueMask;
                } else {
                    folderArr[i8].hasCrc = false;
                }
            }
            getUnsignedByte(byteBuffer);
        }
    }

    private void reopenFolderInputStream(int i5, SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        this.deferredBlockStreams.clear();
        InputStream inputStream = this.currentFolderInputStream;
        if (inputStream != null) {
            inputStream.close();
            this.currentFolderInputStream = null;
        }
        Archive archive = this.archive;
        Folder folder = archive.folders[i5];
        StreamMap streamMap = archive.streamMap;
        int i6 = streamMap.folderFirstPackStreamIndex[i5];
        this.currentFolderInputStream = buildDecoderStack(folder, archive.packPos + 32 + streamMap.packStreamOffsets[i6], i6, sevenZArchiveEntry);
    }

    private ArchiveStatistics sanityCheckAndCollectStatistics(ByteBuffer byteBuffer) throws IOException {
        ArchiveStatistics archiveStatistics = new ArchiveStatistics();
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 2) {
            sanityCheckArchiveProperties(byteBuffer);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 3) {
            throw new IOException("Additional streams unsupported");
        }
        if (unsignedByte == 4) {
            sanityCheckStreamsInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 5) {
            sanityCheckFilesInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 0) {
            return archiveStatistics;
        }
        throw new IOException(AbstractC0157z.k(unsignedByte, "Badly terminated header, found "));
    }

    private void sanityCheckArchiveProperties(ByteBuffer byteBuffer) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        while (unsignedByte != 0) {
            long jAssertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("propertySize", readUint64(byteBuffer));
            if (skipBytesFully(byteBuffer, jAssertFitsIntoNonNegativeInt) < jAssertFitsIntoNonNegativeInt) {
                throw new IOException("invalid property size");
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
    }

    private void sanityCheckFilesInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        archiveStatistics.numberOfEntries = assertFitsIntoNonNegativeInt("numFiles", readUint64(byteBuffer));
        int iCardinality = -1;
        while (true) {
            int unsignedByte = getUnsignedByte(byteBuffer);
            if (unsignedByte == 0) {
                int i5 = archiveStatistics.numberOfEntries;
                if (iCardinality <= 0) {
                    iCardinality = 0;
                }
                archiveStatistics.numberOfEntriesWithStream = i5 - iCardinality;
                return;
            }
            long uint64 = readUint64(byteBuffer);
            switch (unsignedByte) {
                case 14:
                    iCardinality = readBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    break;
                case 15:
                    if (iCardinality == -1) {
                        throw new IOException("Header format error: kEmptyStream must appear before kEmptyFile");
                    }
                    readBits(byteBuffer, iCardinality);
                    break;
                    break;
                case 16:
                    if (iCardinality == -1) {
                        throw new IOException("Header format error: kEmptyStream must appear before kAnti");
                    }
                    readBits(byteBuffer, iCardinality);
                    break;
                    break;
                case 17:
                    if (getUnsignedByte(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    int iAssertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("file names length", uint64 - 1);
                    if ((iAssertFitsIntoNonNegativeInt & 1) != 0) {
                        throw new IOException("File names length invalid");
                    }
                    int i6 = 0;
                    for (int i7 = 0; i7 < iAssertFitsIntoNonNegativeInt; i7 += 2) {
                        if (getChar(byteBuffer) == 0) {
                            i6++;
                        }
                    }
                    if (i6 != archiveStatistics.numberOfEntries) {
                        throw new IOException(AbstractC0157z.l(")", archiveStatistics.numberOfEntries, AbstractC0157z.t(i6, "Invalid number of file names (", " instead of ")));
                    }
                    break;
                    break;
                case 18:
                    int iCardinality2 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j6 = iCardinality2 * 8;
                    if (skipBytesFully(byteBuffer, j6) < j6) {
                        throw new IOException("invalid creation dates size");
                    }
                    break;
                    break;
                case 19:
                    int iCardinality3 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j7 = iCardinality3 * 8;
                    if (skipBytesFully(byteBuffer, j7) < j7) {
                        throw new IOException("invalid access dates size");
                    }
                    break;
                    break;
                case 20:
                    int iCardinality4 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j8 = iCardinality4 * 8;
                    if (skipBytesFully(byteBuffer, j8) < j8) {
                        throw new IOException("invalid modification dates size");
                    }
                    break;
                    break;
                case 21:
                    int iCardinality5 = readAllOrBits(byteBuffer, archiveStatistics.numberOfEntries).cardinality();
                    if (getUnsignedByte(byteBuffer) != 0) {
                        throw new IOException("Not implemented");
                    }
                    long j9 = iCardinality5 * 4;
                    if (skipBytesFully(byteBuffer, j9) < j9) {
                        throw new IOException("invalid windows attributes size");
                    }
                    break;
                    break;
                case 22:
                case 23:
                default:
                    if (skipBytesFully(byteBuffer, uint64) < uint64) {
                        throw new IOException(AbstractC0157z.k(unsignedByte, "Incomplete property of type "));
                    }
                    break;
                    break;
                case 24:
                    throw new IOException("kStartPos is unsupported, please report");
                case 25:
                    if (skipBytesFully(byteBuffer, uint64) < uint64) {
                        throw new IOException("Incomplete kDummy property");
                    }
                    break;
                    break;
            }
        }
    }

    private int sanityCheckFolder(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int iAssertFitsIntoNonNegativeInt = assertFitsIntoNonNegativeInt("numCoders", readUint64(byteBuffer));
        if (iAssertFitsIntoNonNegativeInt == 0) {
            throw new IOException("Folder without coders");
        }
        archiveStatistics.numberOfCoders += (long) iAssertFitsIntoNonNegativeInt;
        long jAssertFitsIntoNonNegativeInt = 0;
        long j6 = 0;
        int i5 = 0;
        while (true) {
            long jAssertFitsIntoNonNegativeInt2 = 1;
            if (i5 >= iAssertFitsIntoNonNegativeInt) {
                assertFitsIntoNonNegativeInt("totalInStreams", jAssertFitsIntoNonNegativeInt);
                assertFitsIntoNonNegativeInt("totalOutStreams", j6);
                archiveStatistics.numberOfOutStreams += j6;
                archiveStatistics.numberOfInStreams += jAssertFitsIntoNonNegativeInt;
                if (j6 == 0) {
                    throw new IOException("Total output streams can't be 0");
                }
                int iAssertFitsIntoNonNegativeInt2 = assertFitsIntoNonNegativeInt("numBindPairs", j6 - 1);
                long j7 = iAssertFitsIntoNonNegativeInt2;
                if (jAssertFitsIntoNonNegativeInt < j7) {
                    throw new IOException("Total input streams can't be less than the number of bind pairs");
                }
                BitSet bitSet = new BitSet((int) jAssertFitsIntoNonNegativeInt);
                for (int i6 = 0; i6 < iAssertFitsIntoNonNegativeInt2; i6++) {
                    int iAssertFitsIntoNonNegativeInt3 = assertFitsIntoNonNegativeInt("inIndex", readUint64(byteBuffer));
                    if (jAssertFitsIntoNonNegativeInt <= iAssertFitsIntoNonNegativeInt3) {
                        throw new IOException("inIndex is bigger than number of inStreams");
                    }
                    bitSet.set(iAssertFitsIntoNonNegativeInt3);
                    if (j6 <= assertFitsIntoNonNegativeInt("outIndex", readUint64(byteBuffer))) {
                        throw new IOException("outIndex is bigger than number of outStreams");
                    }
                }
                int iAssertFitsIntoNonNegativeInt4 = assertFitsIntoNonNegativeInt("numPackedStreams", jAssertFitsIntoNonNegativeInt - j7);
                if (iAssertFitsIntoNonNegativeInt4 != 1) {
                    for (int i7 = 0; i7 < iAssertFitsIntoNonNegativeInt4; i7++) {
                        if (assertFitsIntoNonNegativeInt("packedStreamIndex", readUint64(byteBuffer)) >= jAssertFitsIntoNonNegativeInt) {
                            throw new IOException("packedStreamIndex is bigger than number of totalInStreams");
                        }
                    }
                } else if (bitSet.nextClearBit(0) == -1) {
                    throw new IOException("Couldn't find stream's bind pair index");
                }
                return (int) j6;
            }
            int unsignedByte = getUnsignedByte(byteBuffer);
            get(byteBuffer, new byte[unsignedByte & 15]);
            boolean z6 = (unsignedByte & 16) == 0;
            boolean z7 = (unsignedByte & 32) != 0;
            if ((unsignedByte & 128) != 0) {
                throw new IOException("Alternative methods are unsupported, please report. The reference implementation doesn't support them either.");
            }
            if (z6) {
                jAssertFitsIntoNonNegativeInt++;
            } else {
                jAssertFitsIntoNonNegativeInt += (long) assertFitsIntoNonNegativeInt("numInStreams", readUint64(byteBuffer));
                jAssertFitsIntoNonNegativeInt2 = assertFitsIntoNonNegativeInt("numOutStreams", readUint64(byteBuffer));
            }
            j6 += jAssertFitsIntoNonNegativeInt2;
            if (z7) {
                long jAssertFitsIntoNonNegativeInt3 = assertFitsIntoNonNegativeInt("propertiesSize", readUint64(byteBuffer));
                if (skipBytesFully(byteBuffer, jAssertFitsIntoNonNegativeInt3) < jAssertFitsIntoNonNegativeInt3) {
                    throw new IOException("invalid propertiesSize in folder");
                }
            }
            i5++;
        }
    }

    private void sanityCheckPackInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        long uint64 = readUint64(byteBuffer);
        long j6 = 0;
        if (uint64 >= 0) {
            long j7 = 32 + uint64;
            if (j7 <= this.channel.size() && j7 >= 0) {
                archiveStatistics.numberOfPackedStreams = assertFitsIntoNonNegativeInt("numPackStreams", readUint64(byteBuffer));
                int unsignedByte = getUnsignedByte(byteBuffer);
                if (unsignedByte == 9) {
                    int i5 = 0;
                    long j8 = 0;
                    while (i5 < archiveStatistics.numberOfPackedStreams) {
                        long uint65 = readUint64(byteBuffer);
                        j8 += uint65;
                        long j9 = j7 + j8;
                        if (uint65 < j6 || j9 > this.channel.size() || j9 < uint64) {
                            throw new IOException(androidx.exifinterface.media.a.k("packSize (", uint65, ") is out of range"));
                        }
                        i5++;
                        j6 = 0;
                    }
                    unsignedByte = getUnsignedByte(byteBuffer);
                }
                if (unsignedByte == 10) {
                    long jCardinality = readAllOrBits(byteBuffer, archiveStatistics.numberOfPackedStreams).cardinality() * 4;
                    if (skipBytesFully(byteBuffer, jCardinality) < jCardinality) {
                        throw new IOException("invalid number of CRCs in PackInfo");
                    }
                    unsignedByte = getUnsignedByte(byteBuffer);
                }
                if (unsignedByte != 0) {
                    throw new IOException(androidx.collection.a.i(unsignedByte, "Badly terminated PackInfo (", ")"));
                }
                return;
            }
        }
        throw new IOException(androidx.exifinterface.media.a.k("packPos (", uint64, ") is out of range"));
    }

    private void sanityCheckStreamsInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte == 6) {
            sanityCheckPackInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 7) {
            sanityCheckUnpackInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte == 8) {
            sanityCheckSubStreamsInfo(byteBuffer, archiveStatistics);
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated StreamsInfo");
        }
    }

    private void sanityCheckSubStreamsInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int iCardinality;
        int unsignedByte = getUnsignedByte(byteBuffer);
        LinkedList linkedList = new LinkedList();
        int i5 = 0;
        if (unsignedByte == 13) {
            for (int i6 = 0; i6 < archiveStatistics.numberOfFolders; i6++) {
                linkedList.add(Integer.valueOf(assertFitsIntoNonNegativeInt("numStreams", readUint64(byteBuffer))));
            }
            archiveStatistics.numberOfUnpackSubStreams = ((Long) linkedList.stream().collect(Collectors.summingLong(new a(0)))).longValue();
            unsignedByte = getUnsignedByte(byteBuffer);
        } else {
            archiveStatistics.numberOfUnpackSubStreams = archiveStatistics.numberOfFolders;
        }
        assertFitsIntoNonNegativeInt("totalUnpackStreams", archiveStatistics.numberOfUnpackSubStreams);
        if (unsignedByte == 9) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (iIntValue != 0) {
                    for (int i7 = 0; i7 < iIntValue - 1; i7++) {
                        if (readUint64(byteBuffer) < 0) {
                            throw new IOException("negative unpackSize");
                        }
                    }
                }
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (linkedList.isEmpty()) {
            iCardinality = archiveStatistics.folderHasCrc == null ? archiveStatistics.numberOfFolders : archiveStatistics.numberOfFolders - archiveStatistics.folderHasCrc.cardinality();
        } else {
            Iterator it2 = linkedList.iterator();
            int i8 = 0;
            while (it2.hasNext()) {
                int iIntValue2 = ((Integer) it2.next()).intValue();
                if (iIntValue2 == 1 && archiveStatistics.folderHasCrc != null) {
                    int i9 = i8 + 1;
                    if (archiveStatistics.folderHasCrc.get(i8)) {
                        i8 = i9;
                    } else {
                        i8 = i9;
                    }
                }
                i5 += iIntValue2;
            }
            iCardinality = i5;
        }
        if (unsignedByte == 10) {
            assertFitsIntoNonNegativeInt("numDigests", iCardinality);
            long jCardinality = readAllOrBits(byteBuffer, iCardinality).cardinality() * 4;
            if (skipBytesFully(byteBuffer, jCardinality) < jCardinality) {
                throw new IOException("invalid number of missing CRCs in SubStreamInfo");
            }
            unsignedByte = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte != 0) {
            throw new IOException("Badly terminated SubStreamsInfo");
        }
    }

    private void sanityCheckUnpackInfo(ByteBuffer byteBuffer, ArchiveStatistics archiveStatistics) throws IOException {
        int unsignedByte = getUnsignedByte(byteBuffer);
        if (unsignedByte != 11) {
            throw new IOException(AbstractC0157z.k(unsignedByte, "Expected kFolder, got "));
        }
        archiveStatistics.numberOfFolders = assertFitsIntoNonNegativeInt("numFolders", readUint64(byteBuffer));
        if (getUnsignedByte(byteBuffer) != 0) {
            throw new IOException("External unsupported");
        }
        LinkedList linkedList = new LinkedList();
        for (int i5 = 0; i5 < archiveStatistics.numberOfFolders; i5++) {
            linkedList.add(Integer.valueOf(sanityCheckFolder(byteBuffer, archiveStatistics)));
        }
        if (archiveStatistics.numberOfInStreams - (archiveStatistics.numberOfOutStreams - ((long) archiveStatistics.numberOfFolders)) < archiveStatistics.numberOfPackedStreams) {
            throw new IOException("archive doesn't contain enough packed streams");
        }
        int unsignedByte2 = getUnsignedByte(byteBuffer);
        if (unsignedByte2 != 12) {
            throw new IOException(AbstractC0157z.k(unsignedByte2, "Expected kCodersUnpackSize, got "));
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            for (int i6 = 0; i6 < iIntValue; i6++) {
                if (readUint64(byteBuffer) < 0) {
                    throw new IllegalArgumentException("negative unpackSize");
                }
            }
        }
        int unsignedByte3 = getUnsignedByte(byteBuffer);
        if (unsignedByte3 == 10) {
            archiveStatistics.folderHasCrc = readAllOrBits(byteBuffer, archiveStatistics.numberOfFolders);
            long jCardinality = archiveStatistics.folderHasCrc.cardinality() * 4;
            if (skipBytesFully(byteBuffer, jCardinality) < jCardinality) {
                throw new IOException("invalid number of CRCs in UnpackInfo");
            }
            unsignedByte3 = getUnsignedByte(byteBuffer);
        }
        if (unsignedByte3 != 0) {
            throw new IOException("Badly terminated UnpackInfo");
        }
    }

    private static long skipBytesFully(ByteBuffer byteBuffer, long j6) {
        if (j6 < 1) {
            return 0L;
        }
        int iPosition = byteBuffer.position();
        long jRemaining = byteBuffer.remaining();
        if (jRemaining < j6) {
            j6 = jRemaining;
        }
        byteBuffer.position(iPosition + ((int) j6));
        return j6;
    }

    private boolean skipEntriesWhenNeeded(int i5, boolean z6, int i6) throws IOException {
        SevenZArchiveEntry sevenZArchiveEntry = this.archive.files[i5];
        if (this.currentEntryIndex == i5 && !hasCurrentEntryBeenRead()) {
            return false;
        }
        int i7 = this.archive.streamMap.folderFirstFileIndex[this.currentFolderIndex];
        if (z6) {
            int i8 = this.currentEntryIndex;
            if (i8 < i5) {
                i7 = i8 + 1;
            } else {
                reopenFolderInputStream(i6, sevenZArchiveEntry);
            }
        }
        while (i7 < i5) {
            SevenZArchiveEntry sevenZArchiveEntry2 = this.archive.files[i7];
            InputStream boundedInputStream = new BoundedInputStream(this.currentFolderInputStream, sevenZArchiveEntry2.getSize());
            if (sevenZArchiveEntry2.getHasCrc()) {
                boundedInputStream = new CRC32VerifyingInputStream(boundedInputStream, sevenZArchiveEntry2.getSize(), sevenZArchiveEntry2.getCrcValue());
            }
            this.deferredBlockStreams.add(boundedInputStream);
            sevenZArchiveEntry2.setContentMethods(sevenZArchiveEntry.getContentMethods());
            i7++;
        }
        return true;
    }

    private Archive tryToLocateEndHeader(byte[] bArr) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
        long jPosition = this.channel.position() + 20;
        long jPosition2 = this.channel.position() + 1048576 > this.channel.size() ? this.channel.position() : this.channel.size() - 1048576;
        long size = this.channel.size() - 1;
        while (size > jPosition2) {
            size--;
            this.channel.position(size);
            byteBufferAllocate.rewind();
            if (this.channel.read(byteBufferAllocate) < 1) {
                throw new EOFException();
            }
            byte b = byteBufferAllocate.array()[0];
            if (b == 23 || b == 1) {
                try {
                    StartHeader startHeader = new StartHeader();
                    startHeader.nextHeaderOffset = size - jPosition;
                    startHeader.nextHeaderSize = this.channel.size() - size;
                    Archive archiveInitializeArchive = initializeArchive(startHeader, bArr, false);
                    if (archiveInitializeArchive.packSizes.length > 0 && archiveInitializeArchive.files.length > 0) {
                        return archiveInitializeArchive;
                    }
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        throw new IOException("Start header corrupt and unable to guess end header");
    }

    private static byte[] utf16Decode(char[] cArr) throws CharacterCodingException {
        if (cArr == null) {
            return null;
        }
        ByteBuffer byteBufferEncode = PASSWORD_ENCODER.encode(CharBuffer.wrap(cArr));
        if (byteBufferEncode.hasArray()) {
            return byteBufferEncode.array();
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SeekableByteChannel seekableByteChannel = this.channel;
        if (seekableByteChannel != null) {
            try {
                seekableByteChannel.close();
            } finally {
                this.channel = null;
                byte[] bArr = this.password;
                if (bArr != null) {
                    Arrays.fill(bArr, (byte) 0);
                }
                this.password = null;
            }
        }
    }

    public String getDefaultName() {
        if (DEFAULT_FILE_NAME.equals(this.fileName) || this.fileName == null) {
            return null;
        }
        String name = new File(this.fileName).getName();
        int iLastIndexOf = name.lastIndexOf(Consts.DOT);
        return iLastIndexOf > 0 ? name.substring(0, iLastIndexOf) : name.concat("~");
    }

    public Iterable<SevenZArchiveEntry> getEntries() {
        return new ArrayList(Arrays.asList(this.archive.files));
    }

    public InputStream getInputStream(SevenZArchiveEntry sevenZArchiveEntry) throws IOException {
        int i5 = 0;
        while (true) {
            SevenZArchiveEntry[] sevenZArchiveEntryArr = this.archive.files;
            if (i5 >= sevenZArchiveEntryArr.length) {
                i5 = -1;
                break;
            }
            if (sevenZArchiveEntry == sevenZArchiveEntryArr[i5]) {
                break;
            }
            i5++;
        }
        if (i5 >= 0) {
            buildDecodingStream(i5, true);
            this.currentEntryIndex = i5;
            this.currentFolderIndex = this.archive.streamMap.fileFolderIndex[i5];
            return getCurrentStream();
        }
        throw new IllegalArgumentException("Can not find " + sevenZArchiveEntry.getName() + " in " + this.fileName);
    }

    public SevenZArchiveEntry getNextEntry() throws IOException {
        int i5 = this.currentEntryIndex;
        SevenZArchiveEntry[] sevenZArchiveEntryArr = this.archive.files;
        if (i5 >= sevenZArchiveEntryArr.length - 1) {
            return null;
        }
        int i6 = i5 + 1;
        this.currentEntryIndex = i6;
        SevenZArchiveEntry sevenZArchiveEntry = sevenZArchiveEntryArr[i6];
        if (sevenZArchiveEntry.getName() == null && this.options.getUseDefaultNameForUnnamedEntries()) {
            sevenZArchiveEntry.setName(getDefaultName());
        }
        buildDecodingStream(this.currentEntryIndex, false);
        this.compressedBytesReadFromCurrentEntry = 0L;
        this.uncompressedBytesReadFromCurrentEntry = 0L;
        return sevenZArchiveEntry;
    }

    public InputStreamStatistics getStatisticsForCurrentEntry() {
        return new InputStreamStatistics() { // from class: org.apache.commons.compress.archivers.sevenz.SevenZFile.2
            @Override // org.apache.commons.compress.utils.InputStreamStatistics
            public long getCompressedCount() {
                return SevenZFile.this.compressedBytesReadFromCurrentEntry;
            }

            @Override // org.apache.commons.compress.utils.InputStreamStatistics
            public long getUncompressedCount() {
                return SevenZFile.this.uncompressedBytesReadFromCurrentEntry;
            }
        };
    }

    public int read() throws IOException {
        int i5 = getCurrentStream().read();
        if (i5 >= 0) {
            this.uncompressedBytesReadFromCurrentEntry++;
        }
        return i5;
    }

    public String toString() {
        return this.archive.toString();
    }

    public SevenZFile(File file, char[] cArr, SevenZFileOptions sevenZFileOptions) {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), utf16Decode(cArr), true, sevenZFileOptions);
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        int i7 = getCurrentStream().read(bArr, i5, i6);
        if (i7 > 0) {
            this.uncompressedBytesReadFromCurrentEntry += (long) i7;
        }
        return i7;
    }

    @Deprecated
    public SevenZFile(File file, byte[] bArr) {
        this(Files.newByteChannel(file.toPath(), EnumSet.of(StandardOpenOption.READ), new FileAttribute[0]), file.getAbsolutePath(), bArr, true, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel) {
        this(seekableByteChannel, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, SevenZFileOptions sevenZFileOptions) {
        this(seekableByteChannel, DEFAULT_FILE_NAME, null, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr) {
        this(seekableByteChannel, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, char[] cArr, SevenZFileOptions sevenZFileOptions) {
        this(seekableByteChannel, DEFAULT_FILE_NAME, cArr, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr) {
        this(seekableByteChannel, str, cArr, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, char[] cArr, SevenZFileOptions sevenZFileOptions) {
        this(seekableByteChannel, str, utf16Decode(cArr), false, sevenZFileOptions);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str) {
        this(seekableByteChannel, str, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, SevenZFileOptions sevenZFileOptions) {
        this(seekableByteChannel, str, null, false, sevenZFileOptions);
    }

    @Deprecated
    public SevenZFile(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        this(seekableByteChannel, DEFAULT_FILE_NAME, bArr);
    }

    @Deprecated
    public SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr) {
        this(seekableByteChannel, str, bArr, false, SevenZFileOptions.DEFAULT);
    }

    private SevenZFile(SeekableByteChannel seekableByteChannel, String str, byte[] bArr, boolean z6, SevenZFileOptions sevenZFileOptions) throws IOException {
        this.currentEntryIndex = -1;
        this.currentFolderIndex = -1;
        this.deferredBlockStreams = new ArrayList<>();
        this.channel = seekableByteChannel;
        this.fileName = str;
        this.options = sevenZFileOptions;
        try {
            this.archive = readHeaders(bArr);
            if (bArr != null) {
                this.password = Arrays.copyOf(bArr, bArr.length);
            } else {
                this.password = null;
            }
        } catch (Throwable th) {
            if (z6) {
                this.channel.close();
            }
            throw th;
        }
    }

    public SevenZFile(File file) {
        this(file, SevenZFileOptions.DEFAULT);
    }

    public SevenZFile(File file, SevenZFileOptions sevenZFileOptions) {
        this(file, (char[]) null, sevenZFileOptions);
    }
}
