package org.apache.commons.compress.archivers.dump;

import I4.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DumpArchiveInputStream extends ArchiveInputStream {
    private DumpArchiveEntry active;
    private byte[] blockBuffer;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private long filepos;
    private boolean hasHitEOF;
    private boolean isClosed;
    private final Map<Integer, Dirent> names;
    private final Map<Integer, DumpArchiveEntry> pending;
    private final Queue<DumpArchiveEntry> queue;
    protected TapeInputStream raw;
    private final byte[] readBuf;
    private int readIdx;
    private int recordOffset;
    private final DumpArchiveSummary summary;
    private final ZipEncoding zipEncoding;

    public DumpArchiveInputStream(InputStream inputStream) {
        this(inputStream, null);
    }

    private String getPath(DumpArchiveEntry dumpArchiveEntry) {
        Stack stack = new Stack();
        int ino = dumpArchiveEntry.getIno();
        while (true) {
            if (!this.names.containsKey(Integer.valueOf(ino))) {
                stack.clear();
                break;
            }
            Dirent dirent = this.names.get(Integer.valueOf(ino));
            stack.push(dirent.getName());
            if (dirent.getIno() == dirent.getParentIno()) {
                break;
            }
            ino = dirent.getParentIno();
        }
        if (stack.isEmpty()) {
            this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
            return null;
        }
        StringBuilder sb = new StringBuilder((String) stack.pop());
        while (!stack.isEmpty()) {
            sb.append('/');
            sb.append((String) stack.pop());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(DumpArchiveEntry dumpArchiveEntry, DumpArchiveEntry dumpArchiveEntry2) {
        if (dumpArchiveEntry.getOriginalName() == null || dumpArchiveEntry2.getOriginalName() == null) {
            return Integer.MAX_VALUE;
        }
        return dumpArchiveEntry.getOriginalName().compareTo(dumpArchiveEntry2.getOriginalName());
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < 32) {
            return false;
        }
        if (i5 >= 1024) {
            return DumpArchiveUtil.verify(bArr);
        }
        return 60012 == DumpArchiveUtil.convert32(bArr, 24);
    }

    private void readBITS() throws InvalidFormatException, EOFException {
        byte[] record = this.raw.readRecord();
        if (!DumpArchiveUtil.verify(record)) {
            throw new InvalidFormatException();
        }
        DumpArchiveEntry dumpArchiveEntry = DumpArchiveEntry.parse(record);
        this.active = dumpArchiveEntry;
        if (DumpArchiveConstants.SEGMENT_TYPE.BITS != dumpArchiveEntry.getHeaderType()) {
            throw new InvalidFormatException();
        }
        if (this.raw.skip(((long) this.active.getHeaderCount()) * 1024) == -1) {
            throw new EOFException();
        }
        this.readIdx = this.active.getHeaderCount();
    }

    private void readCLRI() throws InvalidFormatException, EOFException {
        byte[] record = this.raw.readRecord();
        if (!DumpArchiveUtil.verify(record)) {
            throw new InvalidFormatException();
        }
        DumpArchiveEntry dumpArchiveEntry = DumpArchiveEntry.parse(record);
        this.active = dumpArchiveEntry;
        if (DumpArchiveConstants.SEGMENT_TYPE.CLRI != dumpArchiveEntry.getHeaderType()) {
            throw new InvalidFormatException();
        }
        if (this.raw.skip(((long) this.active.getHeaderCount()) * 1024) == -1) {
            throw new EOFException();
        }
        this.readIdx = this.active.getHeaderCount();
    }

    private void readDirectoryEntry(DumpArchiveEntry dumpArchiveEntry) throws InvalidFormatException, EOFException {
        long entrySize = dumpArchiveEntry.getEntrySize();
        boolean z6 = true;
        while (true) {
            if (!z6 && DumpArchiveConstants.SEGMENT_TYPE.ADDR != dumpArchiveEntry.getHeaderType()) {
                return;
            }
            if (!z6) {
                this.raw.readRecord();
            }
            if (!this.names.containsKey(Integer.valueOf(dumpArchiveEntry.getIno())) && DumpArchiveConstants.SEGMENT_TYPE.INODE == dumpArchiveEntry.getHeaderType()) {
                this.pending.put(Integer.valueOf(dumpArchiveEntry.getIno()), dumpArchiveEntry);
            }
            int headerCount = dumpArchiveEntry.getHeaderCount() * 1024;
            byte[] bArr = this.blockBuffer;
            if (bArr.length < headerCount) {
                byte[] range = IOUtils.readRange(this.raw, headerCount);
                this.blockBuffer = range;
                if (range.length != headerCount) {
                    throw new EOFException();
                }
            } else if (this.raw.read(bArr, 0, headerCount) != headerCount) {
                throw new EOFException();
            }
            int i5 = 0;
            while (i5 < headerCount - 8 && i5 < entrySize - 8) {
                int iConvert32 = DumpArchiveUtil.convert32(this.blockBuffer, i5);
                int iConvert16 = DumpArchiveUtil.convert16(this.blockBuffer, i5 + 4);
                byte[] bArr2 = this.blockBuffer;
                byte b = bArr2[i5 + 6];
                String strDecode = DumpArchiveUtil.decode(this.zipEncoding, bArr2, i5 + 8, bArr2[i5 + 7]);
                if (!Consts.DOT.equals(strDecode) && !"..".equals(strDecode)) {
                    this.names.put(Integer.valueOf(iConvert32), new Dirent(iConvert32, dumpArchiveEntry.getIno(), b, strDecode));
                    for (Map.Entry<Integer, DumpArchiveEntry> entry : this.pending.entrySet()) {
                        String path = getPath(entry.getValue());
                        if (path != null) {
                            entry.getValue().setName(path);
                            entry.getValue().setSimpleName(this.names.get(entry.getKey()).getName());
                            this.queue.add(entry.getValue());
                        }
                    }
                    Iterator<DumpArchiveEntry> it = this.queue.iterator();
                    while (it.hasNext()) {
                        this.pending.remove(Integer.valueOf(it.next().getIno()));
                    }
                }
                i5 += iConvert16;
            }
            byte[] bArrPeek = this.raw.peek();
            if (!DumpArchiveUtil.verify(bArrPeek)) {
                throw new InvalidFormatException();
            }
            dumpArchiveEntry = DumpArchiveEntry.parse(bArrPeek);
            entrySize -= 1024;
            z6 = false;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.raw.close();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public long getBytesRead() {
        return this.raw.getBytesRead();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    @Deprecated
    public int getCount() {
        return (int) getBytesRead();
    }

    public DumpArchiveEntry getNextDumpEntry() {
        return getNextEntry();
    }

    public DumpArchiveSummary getSummary() {
        return this.summary;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws InvalidFormatException, EOFException {
        if (i6 == 0) {
            return 0;
        }
        if (this.hasHitEOF || this.isClosed) {
            return -1;
        }
        long j6 = this.entryOffset;
        long j7 = this.entrySize;
        if (j6 >= j7) {
            return -1;
        }
        if (this.active == null) {
            throw new IllegalStateException("No current dump entry");
        }
        if (((long) i6) + j6 > j7) {
            i6 = (int) (j7 - j6);
        }
        int i7 = 0;
        while (i6 > 0) {
            byte[] bArr2 = this.readBuf;
            int length = bArr2.length;
            int i8 = this.recordOffset;
            int length2 = i6 > length - i8 ? bArr2.length - i8 : i6;
            if (i8 + length2 <= bArr2.length) {
                System.arraycopy(bArr2, i8, bArr, i5, length2);
                i7 += length2;
                this.recordOffset += length2;
                i6 -= length2;
                i5 += length2;
            }
            if (i6 > 0) {
                if (this.readIdx >= 512) {
                    byte[] record = this.raw.readRecord();
                    if (!DumpArchiveUtil.verify(record)) {
                        throw new InvalidFormatException();
                    }
                    this.active = DumpArchiveEntry.parse(record);
                    this.readIdx = 0;
                }
                DumpArchiveEntry dumpArchiveEntry = this.active;
                int i9 = this.readIdx;
                this.readIdx = i9 + 1;
                if (dumpArchiveEntry.isSparseRecord(i9)) {
                    Arrays.fill(this.readBuf, (byte) 0);
                } else {
                    TapeInputStream tapeInputStream = this.raw;
                    byte[] bArr3 = this.readBuf;
                    if (tapeInputStream.read(bArr3, 0, bArr3.length) != this.readBuf.length) {
                        throw new EOFException();
                    }
                }
                this.recordOffset = 0;
            }
        }
        this.entryOffset += (long) i7;
        return i7;
    }

    public DumpArchiveInputStream(InputStream inputStream, String str) throws ArchiveException {
        this.readBuf = new byte[1024];
        HashMap map = new HashMap();
        this.names = map;
        this.pending = new HashMap();
        this.raw = new TapeInputStream(inputStream);
        this.hasHitEOF = false;
        this.encoding = str;
        ZipEncoding zipEncoding = ZipEncodingHelper.getZipEncoding(str);
        this.zipEncoding = zipEncoding;
        try {
            byte[] record = this.raw.readRecord();
            if (!DumpArchiveUtil.verify(record)) {
                throw new UnrecognizedFormatException();
            }
            DumpArchiveSummary dumpArchiveSummary = new DumpArchiveSummary(record, zipEncoding);
            this.summary = dumpArchiveSummary;
            this.raw.resetBlockSize(dumpArchiveSummary.getNTRec(), dumpArchiveSummary.isCompressed());
            this.blockBuffer = new byte[4096];
            readCLRI();
            readBITS();
            map.put(2, new Dirent(2, 2, 4, Consts.DOT));
            this.queue = new PriorityQueue(10, new a(16));
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage(), e);
        }
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public DumpArchiveEntry getNextEntry() throws InvalidFormatException, EOFException {
        if (!this.queue.isEmpty()) {
            return this.queue.remove();
        }
        DumpArchiveEntry dumpArchiveEntry = null;
        String str = null;
        while (dumpArchiveEntry == null) {
            if (this.hasHitEOF) {
                return null;
            }
            while (this.readIdx < this.active.getHeaderCount()) {
                DumpArchiveEntry dumpArchiveEntry2 = this.active;
                int i5 = this.readIdx;
                this.readIdx = i5 + 1;
                if (!dumpArchiveEntry2.isSparseRecord(i5) && this.raw.skip(1024L) == -1) {
                    throw new EOFException();
                }
            }
            this.readIdx = 0;
            this.filepos = this.raw.getBytesRead();
            byte[] record = this.raw.readRecord();
            if (!DumpArchiveUtil.verify(record)) {
                throw new InvalidFormatException();
            }
            this.active = DumpArchiveEntry.parse(record);
            while (DumpArchiveConstants.SEGMENT_TYPE.ADDR == this.active.getHeaderType()) {
                if (this.raw.skip(((long) (this.active.getHeaderCount() - this.active.getHeaderHoles())) * 1024) == -1) {
                    throw new EOFException();
                }
                this.filepos = this.raw.getBytesRead();
                byte[] record2 = this.raw.readRecord();
                if (!DumpArchiveUtil.verify(record2)) {
                    throw new InvalidFormatException();
                }
                this.active = DumpArchiveEntry.parse(record2);
            }
            if (DumpArchiveConstants.SEGMENT_TYPE.END == this.active.getHeaderType()) {
                this.hasHitEOF = true;
                return null;
            }
            DumpArchiveEntry dumpArchiveEntry3 = this.active;
            if (dumpArchiveEntry3.isDirectory()) {
                readDirectoryEntry(this.active);
                this.entryOffset = 0L;
                this.entrySize = 0L;
                this.readIdx = this.active.getHeaderCount();
            } else {
                this.entryOffset = 0L;
                this.entrySize = this.active.getEntrySize();
                this.readIdx = 0;
            }
            this.recordOffset = this.readBuf.length;
            String path = getPath(dumpArchiveEntry3);
            if (path == null) {
                dumpArchiveEntry3 = null;
            }
            DumpArchiveEntry dumpArchiveEntry4 = dumpArchiveEntry3;
            str = path;
            dumpArchiveEntry = dumpArchiveEntry4;
        }
        dumpArchiveEntry.setName(str);
        dumpArchiveEntry.setSimpleName(this.names.get(Integer.valueOf(dumpArchiveEntry.getIno())).getName());
        dumpArchiveEntry.setOffset(this.filepos);
        return dumpArchiveEntry;
    }
}
