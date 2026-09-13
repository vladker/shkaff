package org.apache.poi.poifs.filesystem;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.poi.poifs.property.RootProperty;
import org.apache.poi.poifs.storage.BATBlock;
import org.apache.poi.poifs.storage.HeaderBlock;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSMiniStore extends BlockStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final POIFSFileSystem _filesystem;
    private final HeaderBlock _header;
    private POIFSStream _mini_stream;
    private final RootProperty _root;
    private final List<BATBlock> _sbat_blocks;

    public POIFSMiniStore(POIFSFileSystem pOIFSFileSystem, RootProperty rootProperty, List<BATBlock> list, HeaderBlock headerBlock) {
        if (rootProperty == null) {
            throw new RecordFormatException("Invalid argument to POIFSMiniStore: root is null");
        }
        this._filesystem = pOIFSFileSystem;
        this._sbat_blocks = list;
        this._header = headerBlock;
        this._root = rootProperty;
        this._mini_stream = new POIFSStream(pOIFSFileSystem, rootProperty.getStartBlock());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer createBlockIfNeeded(int i5) {
        boolean z6 = this._mini_stream.getStartBlock() == -2;
        if (!z6) {
            try {
                return getBlockAt(i5);
            } catch (NoSuchElementException unused) {
            }
        }
        int freeBlock = this._filesystem.getFreeBlock();
        this._filesystem.createBlockIfNeeded(freeBlock);
        if (z6) {
            this._filesystem._get_property_table().getRoot().setStartBlock(freeBlock);
            this._mini_stream = new POIFSStream(this._filesystem, freeBlock);
        } else {
            BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
            int startBlock = this._mini_stream.getStartBlock();
            while (true) {
                chainLoopDetector.claim(startBlock);
                int nextBlock = this._filesystem.getNextBlock(startBlock);
                if (nextBlock == -2) {
                    break;
                }
                startBlock = nextBlock;
            }
            this._filesystem.setNextBlock(startBlock, freeBlock);
        }
        this._filesystem.setNextBlock(freeBlock, -2);
        return createBlockIfNeeded(i5);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i5) {
        return BATBlock.getSBATBlockAndIndex(i5, this._header, this._sbat_blocks);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public ByteBuffer getBlockAt(int i5) {
        int i6 = i5 * 64;
        int bigBlockSize = i6 / this._filesystem.getBigBlockSize();
        int bigBlockSize2 = i6 % this._filesystem.getBigBlockSize();
        Iterator<Integer> blockOffsetIterator = this._mini_stream.getBlockOffsetIterator();
        for (int i7 = 0; i7 < bigBlockSize; i7++) {
            blockOffsetIterator.next();
        }
        ByteBuffer blockAt = this._filesystem.getBlockAt(blockOffsetIterator.next().intValue());
        blockAt.position(blockAt.position() + bigBlockSize2);
        ByteBuffer byteBufferSlice = blockAt.slice();
        byteBufferSlice.limit(64);
        return byteBufferSlice;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getBlockStoreBlockSize() {
        return 64;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public BlockStore.ChainLoopDetector getChainLoopDetector() {
        return new BlockStore.ChainLoopDetector(this._root.getSize());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getFreeBlock() {
        int bATEntriesPerBlock = this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock();
        int i5 = 0;
        for (BATBlock bATBlock : this._sbat_blocks) {
            if (bATBlock.hasFreeSectors()) {
                for (int i6 = 0; i6 < bATEntriesPerBlock; i6++) {
                    if (bATBlock.getValueAt(i6) == -1) {
                        return i5 + i6;
                    }
                }
            }
            i5 += bATEntriesPerBlock;
        }
        BATBlock bATBlockCreateEmptyBATBlock = BATBlock.createEmptyBATBlock(this._filesystem.getBigBlockSizeDetails(), false);
        int freeBlock = this._filesystem.getFreeBlock();
        bATBlockCreateEmptyBATBlock.setOurBlockIndex(freeBlock);
        if (this._header.getSBATCount() == 0) {
            this._header.setSBATStart(freeBlock);
            this._header.setSBATBlockCount(1);
        } else {
            BlockStore.ChainLoopDetector chainLoopDetector = this._filesystem.getChainLoopDetector();
            int sBATStart = this._header.getSBATStart();
            while (true) {
                chainLoopDetector.claim(sBATStart);
                int nextBlock = this._filesystem.getNextBlock(sBATStart);
                if (nextBlock == -2) {
                    break;
                }
                sBATStart = nextBlock;
            }
            this._filesystem.setNextBlock(sBATStart, freeBlock);
            HeaderBlock headerBlock = this._header;
            headerBlock.setSBATBlockCount(headerBlock.getSBATCount() + 1);
        }
        this._filesystem.setNextBlock(freeBlock, -2);
        this._sbat_blocks.add(bATBlockCreateEmptyBATBlock);
        return i5;
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public int getNextBlock(int i5) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i5);
        return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void releaseBuffer(ByteBuffer byteBuffer) {
        this._filesystem.releaseBuffer(byteBuffer);
    }

    @Override // org.apache.poi.poifs.filesystem.BlockStore
    public void setNextBlock(int i5, int i6) {
        BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(i5);
        bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), i6);
    }

    public void syncWithDataSource() {
        int bATEntriesPerBlock = 0;
        for (BATBlock bATBlock : this._sbat_blocks) {
            bATBlock.writeData(this._filesystem.getBlockAt(bATBlock.getOurBlockIndex()));
            bATEntriesPerBlock = (!bATBlock.hasFreeSectors() ? this._filesystem.getBigBlockSizeDetails().getBATEntriesPerBlock() : bATBlock.getOccupiedSize()) + bATEntriesPerBlock;
        }
        this._filesystem._get_property_table().getRoot().setSize(bATEntriesPerBlock);
    }
}
