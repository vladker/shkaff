package org.apache.poi.poifs.filesystem;

import A3.AbstractC0157z;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EmptyFileException;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.poifs.common.POIFSConstants;
import org.apache.poi.poifs.dev.POIFSViewable;
import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
import org.apache.poi.poifs.nio.DataSource;
import org.apache.poi.poifs.nio.FileBackedDataSource;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.PropertyTable;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSFileSystem extends BlockStore implements POIFSViewable, Closeable {
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000;
    private static final Logger LOG = LogManager.getLogger((Class<?>) POIFSFileSystem.class);
    private static final int MAX_ALLOCATION_SIZE = 250000000;
    private static final int MAX_BLOCK_COUNT = 65535;
    private static int MAX_RECORD_LENGTH = 100000;
    private final List<BATBlock> _bat_blocks;
    protected DataSource _data;
    private HeaderBlock _header;
    private POIFSMiniStore _mini_store;
    private PropertyTable _property_table;
    private DirectoryNode _root;
    private final List<BATBlock> _xbat_blocks;
    private POIFSBigBlockSize bigBlockSize;

    private POIFSFileSystem(boolean z6) {
        POIFSBigBlockSize pOIFSBigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
        this.bigBlockSize = pOIFSBigBlockSize;
        this._header = new HeaderBlock(pOIFSBigBlockSize);
        PropertyTable propertyTable = new PropertyTable(this._header);
        this._property_table = propertyTable;
        this._mini_store = new POIFSMiniStore(this, propertyTable.getRoot(), new ArrayList(), this._header);
        this._xbat_blocks = new ArrayList();
        this._bat_blocks = new ArrayList();
        this._root = null;
        if (z6) {
            createNewDataSource();
        }
    }

    private void closeInputStream(InputStream inputStream, boolean z6) {
        try {
            inputStream.close();
        } catch (IOException e) {
            if (z6) {
                throw new RuntimeException(e);
            }
            LOG.atError().withThrowable(e).log("can't close input stream");
        }
    }

    public static POIFSFileSystem create(File file) {
        POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                pOIFSFileSystem.writeFilesystem(fileOutputStream);
                fileOutputStream.close();
                pOIFSFileSystem.close();
                return new POIFSFileSystem(file, false);
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
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    pOIFSFileSystem.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    private BATBlock createBAT(int i5, boolean z6) {
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, !z6);
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(i5);
        this._data.write(ByteBuffer.allocate(this.bigBlockSize.getBigBlockSize()), Math.multiplyExact(((long) i5) + 1, this.bigBlockSize.getBigBlockSize()));
        return bATBlockCreateEmptyBATBlock;
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length != 2) {
            System.err.println("two arguments required: input filename and output filename");
            System.exit(1);
        }
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1]);
            try {
                POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(fileInputStream);
                try {
                    pOIFSFileSystem.writeFilesystem(fileOutputStream);
                    pOIFSFileSystem.close();
                    fileOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            pOIFSFileSystem.close();
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
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            try {
                throw th7;
            } catch (Throwable th8) {
                try {
                    fileInputStream.close();
                } catch (Throwable th9) {
                    th7.addSuppressed(th9);
                }
                throw th8;
            }
        }
    }

    private void readBAT(int i5, BlockStore.ChainLoopDetector chainLoopDetector) {
        chainLoopDetector.claim(i5);
        BATBlock bATBlockCreateBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(i5));
        bATBlockCreateBATBlock.setOurBlockIndex(i5);
        this._bat_blocks.add(bATBlockCreateBATBlock);
    }

    private void readCoreContents() {
        this.bigBlockSize = this._header.getBigBlockSize();
        BlockStore.ChainLoopDetector chainLoopDetector = getChainLoopDetector();
        for (int i5 : this._header.getBATArray()) {
            readBAT(i5, chainLoopDetector);
        }
        int bATCount = this._header.getBATCount() - this._header.getBATArray().length;
        int xBATIndex = this._header.getXBATIndex();
        for (int i6 = 0; i6 < this._header.getXBATCount(); i6++) {
            chainLoopDetector.claim(xBATIndex);
            BATBlock bATBlockCreateBATBlock = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(xBATIndex));
            bATBlockCreateBATBlock.setOurBlockIndex(xBATIndex);
            xBATIndex = bATBlockCreateBATBlock.getValueAt(this.bigBlockSize.getXBATEntriesPerBlock());
            this._xbat_blocks.add(bATBlockCreateBATBlock);
            int iMin = Math.min(bATCount, this.bigBlockSize.getXBATEntriesPerBlock());
            for (int i7 = 0; i7 < iMin; i7++) {
                int valueAt = bATBlockCreateBATBlock.getValueAt(i7);
                if (valueAt == -1 || valueAt == -2) {
                    break;
                }
                readBAT(valueAt, chainLoopDetector);
            }
            bATCount -= iMin;
        }
        this._property_table = new PropertyTable(this._header, this);
        ArrayList arrayList = new ArrayList();
        this._mini_store = new POIFSMiniStore(this, this._property_table.getRoot(), arrayList, this._header);
        int sBATStart = this._header.getSBATStart();
        for (int i8 = 0; i8 < this._header.getSBATCount() && sBATStart != -2; i8++) {
            chainLoopDetector.claim(sBATStart);
            BATBlock bATBlockCreateBATBlock2 = BATBlock.createBATBlock(this.bigBlockSize, getBlockAt(sBATStart));
            bATBlockCreateBATBlock2.setOurBlockIndex(sBATStart);
            arrayList.add(bATBlockCreateBATBlock2);
            sBATStart = getNextBlock(sBATStart);
        }
    }

    private static void sanityCheckBlockCount(int i5) throws IOException {
        if (i5 <= 0) {
            throw new IOException(androidx.collection.a.i(i5, "Illegal block count; minimum count is 1, got ", " instead"));
        }
        if (i5 > 65535) {
            throw new IOException(androidx.collection.a.i(i5, "Block count ", " is too high. POI maximum is 65535."));
        }
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    private void syncWithDataSource() {
        this._mini_store.syncWithDataSource();
        POIFSStream pOIFSStream = new POIFSStream(this, this._header.getPropertyStart());
        this._property_table.preWrite();
        this._property_table.write(pOIFSStream);
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream(this._header.getBigBlockSize().getBigBlockSize());
        this._header.writeData(unsynchronizedByteArrayOutputStream);
        getBlockAt(-1).put(unsynchronizedByteArrayOutputStream.toByteArray());
        for (BATBlock bATBlock : this._bat_blocks) {
            bATBlock.writeData(getBlockAt(bATBlock.getOurBlockIndex()));
        }
        for (BATBlock bATBlock2 : this._xbat_blocks) {
            bATBlock2.writeData(getBlockAt(bATBlock2.getOurBlockIndex()));
        }
    }

    public PropertyTable _get_property_table() {
        return this._property_table;
    }

    public void addDirectory(DirectoryProperty directoryProperty) {
        this._property_table.addProperty(directoryProperty);
    }

    public void addDocument(POIFSDocument pOIFSDocument) {
        this._property_table.addProperty(pOIFSDocument.getDocumentProperty());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this._data.close();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer createBlockIfNeeded(int i5) {
        try {
            return getBlockAt(i5);
        } catch (IndexOutOfBoundsException unused) {
            long bigBlockSize = (((long) i5) + 1) * ((long) this.bigBlockSize.getBigBlockSize());
            this._data.write(ByteBuffer.allocate(getBigBlockSize()), bigBlockSize);
            return getBlockAt(i5);
        }
    }

    public DirectoryEntry createDirectory(String str) {
        return getRoot().createDirectory(str);
    }

    public DocumentEntry createDocument(InputStream inputStream, String str) {
        return getRoot().createDocument(str, inputStream);
    }

    public DocumentInputStream createDocumentInputStream(String str) {
        return getRoot().createDocumentInputStream(str);
    }

    public void createNewDataSource() {
        this._data = new ByteArrayBackedDataSource(IOUtils.safelyAllocate(Math.multiplyExact(this.bigBlockSize.getBigBlockSize(), 3L), MAX_RECORD_LENGTH));
    }

    public DocumentEntry createOrUpdateDocument(InputStream inputStream, String str) {
        return getRoot().createOrUpdateDocument(str, inputStream);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i5) {
        return BATBlock.getBATBlockAndIndex(i5, this._header, this._bat_blocks);
    }

    public int getBigBlockSize() {
        return this.bigBlockSize.getBigBlockSize();
    }

    public POIFSBigBlockSize getBigBlockSizeDetails() {
        return this.bigBlockSize;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer getBlockAt(int i5) {
        try {
            return this._data.read(this.bigBlockSize.getBigBlockSize(), (((long) i5) + 1) * ((long) this.bigBlockSize.getBigBlockSize()));
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(androidx.collection.a.i(i5, "Block ", " not found"));
            indexOutOfBoundsException.initCause(e);
            throw indexOutOfBoundsException;
        }
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getBlockStoreBlockSize() {
        return getBigBlockSize();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BlockStore.ChainLoopDetector getChainLoopDetector() {
        return new BlockStore.ChainLoopDetector(this._data.size());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getFreeBlock() {
        BATBlock next;
        int bATEntriesPerBlock = this.bigBlockSize.getBATEntriesPerBlock();
        int i5 = 0;
        for (BATBlock bATBlock : this._bat_blocks) {
            if (bATBlock.hasFreeSectors()) {
                for (int i6 = 0; i6 < bATEntriesPerBlock; i6++) {
                    if (bATBlock.getValueAt(i6) == -1) {
                        return i5 + i6;
                    }
                }
            }
            i5 += bATEntriesPerBlock;
        }
        BATBlock bATBlockCreateBAT = createBAT(i5, true);
        bATBlockCreateBAT.setValueAt(0, -3);
        this._bat_blocks.add(bATBlockCreateBAT);
        if (this._header.getBATCount() >= 109) {
            Iterator<BATBlock> it = this._xbat_blocks.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!next.hasFreeSectors());
            if (next == null) {
                int i7 = i5 + 1;
                BATBlock bATBlockCreateBAT2 = createBAT(i7, false);
                bATBlockCreateBAT2.setValueAt(0, i5);
                bATBlockCreateBAT.setValueAt(1, -4);
                if (this._xbat_blocks.isEmpty()) {
                    this._header.setXBATStart(i7);
                } else {
                    ((BATBlock) AbstractC0157z.f(1, this._xbat_blocks)).setValueAt(this.bigBlockSize.getXBATEntriesPerBlock(), i7);
                }
                this._xbat_blocks.add(bATBlockCreateBAT2);
                this._header.setXBATCount(this._xbat_blocks.size());
                i5 = i7;
            } else {
                for (int i8 = 0; i8 < this.bigBlockSize.getXBATEntriesPerBlock(); i8++) {
                    if (next.getValueAt(i8) == -1) {
                        next.setValueAt(i8, i5);
                        break;
                    }
                }
            }
        } else {
            int bATCount = this._header.getBATCount();
            int[] iArr = new int[bATCount + 1];
            System.arraycopy(this._header.getBATArray(), 0, iArr, 0, bATCount);
            iArr[bATCount] = i5;
            this._header.setBATArray(iArr);
        }
        this._header.setBATCount(this._bat_blocks.size());
        return i5 + 1;
    }

    @Internal
    public HeaderBlock getHeaderBlock() {
        return this._header;
    }

    public POIFSMiniStore getMiniStore() {
        return this._mini_store;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getNextBlock(int i5) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i5);
        return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
    }

    @Internal
    public PropertyTable getPropertyTable() {
        return this._property_table;
    }

    public DirectoryNode getRoot() {
        if (this._root == null) {
            this._root = new DirectoryNode(this._property_table.getRoot(), this, null);
        }
        return this._root;
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public String getShortDescription() {
        return "POIFS FileSystem";
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Object[] getViewableArray() {
        return preferArray() ? getRoot().getViewableArray() : new Object[0];
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public Iterator<Object> getViewableIterator() {
        return !preferArray() ? getRoot().getViewableIterator() : Collections.emptyIterator();
    }

    public boolean isInPlaceWriteable() {
        DataSource dataSource = this._data;
        return (dataSource instanceof FileBackedDataSource) && ((FileBackedDataSource) dataSource).isWriteable();
    }

    @Override // org.apache.poi.poifs.dev.POIFSViewable
    public boolean preferArray() {
        return getRoot().preferArray();
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void releaseBuffer(ByteBuffer byteBuffer) {
        DataSource dataSource = this._data;
        if (dataSource instanceof FileBackedDataSource) {
            ((FileBackedDataSource) dataSource).releaseBuffer(byteBuffer);
        }
    }

    public void remove(EntryNode entryNode) {
        if (entryNode instanceof DocumentEntry) {
            new POIFSDocument((DocumentProperty) entryNode.getProperty(), this).free();
        }
        this._property_table.removeProperty(entryNode.getProperty());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void setNextBlock(int i5, int i6) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i5);
        bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), i6);
    }

    public long size() {
        return this._data.size();
    }

    public void writeFilesystem() {
        DataSource dataSource = this._data;
        if (!(dataSource instanceof FileBackedDataSource)) {
            throw new IllegalArgumentException("POIFS opened from an inputstream, so writeFilesystem() may not be called. Use writeFilesystem(OutputStream) instead");
        }
        if (!((FileBackedDataSource) dataSource).isWriteable()) {
            throw new IllegalArgumentException("POIFS opened in read only mode, so writeFilesystem() may not be called. Open the FileSystem in read-write mode first");
        }
        syncWithDataSource();
    }

    public DocumentEntry createDocument(String str, int i5, POIFSWriterListener pOIFSWriterListener) {
        return getRoot().createDocument(str, i5, pOIFSWriterListener);
    }

    public void writeFilesystem(OutputStream outputStream) {
        syncWithDataSource();
        this._data.copyTo(outputStream);
    }

    public POIFSFileSystem() {
        this(true);
        this._header.setBATCount(1);
        this._header.setBATArray(new int[]{1});
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, false);
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(1);
        this._bat_blocks.add(bATBlockCreateEmptyBATBlock);
        setNextBlock(0, -2);
        setNextBlock(1, -3);
        this._property_table.setStartBlock(0);
    }

    public POIFSFileSystem(File file) {
        this(file, true);
    }

    public POIFSFileSystem(File file, boolean z6) {
        this(null, file, z6, true, true);
    }

    public POIFSFileSystem(FileChannel fileChannel) {
        this(fileChannel, true);
    }

    public POIFSFileSystem(FileChannel fileChannel, boolean z6) {
        this(fileChannel, null, z6, false, true);
    }

    public POIFSFileSystem(FileChannel fileChannel, boolean z6, boolean z7) {
        this(fileChannel, null, z6, z7, z7);
    }

    private POIFSFileSystem(FileChannel fileChannel, File file, boolean z6, boolean z7, boolean z8) throws Throwable {
        this(false);
        try {
            if (file == null) {
                this._data = new FileBackedDataSource(fileChannel, z6, z8);
            } else if (file.length() != 0) {
                FileBackedDataSource fileBackedDataSource = new FileBackedDataSource(file, z6);
                fileChannel = fileBackedDataSource.getChannel();
                this._data = fileBackedDataSource;
            } else {
                throw new EmptyFileException(file);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
            IOUtils.readFully(fileChannel, byteBufferAllocate);
            this._header = new HeaderBlock(byteBufferAllocate);
            readCoreContents();
        } catch (IOException e) {
            e = e;
            if (z7 && fileChannel != null) {
                fileChannel.close();
            }
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            if (z7) {
                fileChannel.close();
            }
            throw e;
        }
    }

    public POIFSFileSystem(InputStream inputStream) {
        this(false);
        try {
            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStream);
            try {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(512);
                IOUtils.readFully(readableByteChannelNewChannel, byteBufferAllocate);
                HeaderBlock headerBlock = new HeaderBlock(byteBufferAllocate);
                this._header = headerBlock;
                sanityCheckBlockCount(headerBlock.getBATCount());
                long jCalculateMaximumSize = BATBlock.calculateMaximumSize(this._header);
                if (jCalculateMaximumSize <= 2147483647L) {
                    IOUtils.safelyAllocateCheck(jCalculateMaximumSize, MAX_ALLOCATION_SIZE);
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) jCalculateMaximumSize);
                    byteBufferAllocate.position(0);
                    byteBufferAllocate2.put(byteBufferAllocate);
                    byteBufferAllocate2.position(byteBufferAllocate.capacity());
                    IOUtils.readFully(readableByteChannelNewChannel, byteBufferAllocate2);
                    this._data = new ByteArrayBackedDataSource(byteBufferAllocate2.array(), byteBufferAllocate2.position());
                    if (readableByteChannelNewChannel != null) {
                        readableByteChannelNewChannel.close();
                    }
                    closeInputStream(inputStream, true);
                    readCoreContents();
                    return;
                }
                throw new IllegalArgumentException("Unable read a >2gb file via an InputStream");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (readableByteChannelNewChannel != null) {
                        try {
                            readableByteChannelNewChannel.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            closeInputStream(inputStream, false);
            throw th4;
        }
    }
}
