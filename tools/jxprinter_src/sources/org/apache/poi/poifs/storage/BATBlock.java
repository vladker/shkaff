package org.apache.poi.poifs.storage;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class BATBlock implements BlockWritable {
    private boolean _has_free_sectors;
    private int[] _values;
    private POIFSBigBlockSize bigBlockSize;
    private int ourBlockIndex;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BATBlockAndIndex {
        private final BATBlock block;
        private final int index;

        public BATBlock getBlock() {
            return this.block;
        }

        public int getIndex() {
            return this.index;
        }

        private BATBlockAndIndex(int i5, BATBlock bATBlock) {
            this.index = i5;
            this.block = bATBlock;
        }
    }

    private BATBlock(POIFSBigBlockSize pOIFSBigBlockSize) {
        this.bigBlockSize = pOIFSBigBlockSize;
        int[] iArr = new int[pOIFSBigBlockSize.getBATEntriesPerBlock()];
        this._values = iArr;
        this._has_free_sectors = true;
        Arrays.fill(iArr, -1);
    }

    public static long calculateMaximumSize(POIFSBigBlockSize pOIFSBigBlockSize, int i5) {
        return ((((long) i5) * ((long) pOIFSBigBlockSize.getBATEntriesPerBlock())) + 1) * ((long) pOIFSBigBlockSize.getBigBlockSize());
    }

    public static BATBlock createBATBlock(POIFSBigBlockSize pOIFSBigBlockSize, ByteBuffer byteBuffer) {
        BATBlock bATBlock = new BATBlock(pOIFSBigBlockSize);
        byte[] bArr = new byte[4];
        for (int i5 = 0; i5 < bATBlock._values.length; i5++) {
            byteBuffer.get(bArr);
            bATBlock._values[i5] = LittleEndian.getInt(bArr);
        }
        bATBlock.recomputeFree();
        return bATBlock;
    }

    public static BATBlock createEmptyBATBlock(POIFSBigBlockSize pOIFSBigBlockSize, boolean z6) {
        BATBlock bATBlock = new BATBlock(pOIFSBigBlockSize);
        if (z6) {
            bATBlock._values[pOIFSBigBlockSize.getXBATEntriesPerBlock()] = -2;
        }
        return bATBlock;
    }

    public static BATBlockAndIndex getBATBlockAndIndex(int i5, HeaderBlock headerBlock, List<BATBlock> list) {
        int bATEntriesPerBlock = headerBlock.getBigBlockSize().getBATEntriesPerBlock();
        return new BATBlockAndIndex(i5 % bATEntriesPerBlock, list.get(i5 / bATEntriesPerBlock));
    }

    public static BATBlockAndIndex getSBATBlockAndIndex(int i5, HeaderBlock headerBlock, List<BATBlock> list) {
        return getBATBlockAndIndex(i5, headerBlock, list);
    }

    private void recomputeFree() {
        boolean z6 = false;
        for (int i5 : this._values) {
            if (i5 == -1) {
                z6 = true;
                break;
            }
        }
        this._has_free_sectors = z6;
    }

    private byte[] serialize() {
        byte[] bArr = new byte[this.bigBlockSize.getBigBlockSize()];
        int i5 = 0;
        for (int i6 : this._values) {
            LittleEndian.putInt(bArr, i5, i6);
            i5 += 4;
        }
        return bArr;
    }

    public int getOccupiedSize() {
        int[] iArr = this._values;
        int length = iArr.length;
        for (int length2 = iArr.length - 1; length2 >= 0 && this._values[length2] == -1; length2--) {
            length--;
        }
        return length;
    }

    public int getOurBlockIndex() {
        return this.ourBlockIndex;
    }

    public int getUsedSectors(boolean z6) {
        int length = this._values.length;
        if (z6) {
            length--;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (this._values[i6] != -1) {
                i5++;
            }
        }
        return i5;
    }

    public int getValueAt(int i5) {
        int[] iArr = this._values;
        if (i5 < iArr.length) {
            return iArr[i5];
        }
        throw new ArrayIndexOutOfBoundsException(AbstractC0157z.l(" entries", this._values.length, AbstractC0157z.t(i5, "Unable to fetch offset ", " as the BAT only contains ")));
    }

    public boolean hasFreeSectors() {
        return this._has_free_sectors;
    }

    public void setOurBlockIndex(int i5) {
        this.ourBlockIndex = i5;
    }

    public void setValueAt(int i5, int i6) {
        int[] iArr = this._values;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        if (i6 == -1) {
            this._has_free_sectors = true;
        } else if (i7 == -1) {
            recomputeFree();
        }
    }

    @Override // org.apache.poi.poifs.storage.BlockWritable
    public void writeBlocks(OutputStream outputStream) throws IOException {
        outputStream.write(serialize());
    }

    public void writeData(ByteBuffer byteBuffer) {
        byteBuffer.put(serialize());
    }

    public static long calculateMaximumSize(HeaderBlock headerBlock) {
        return calculateMaximumSize(headerBlock.getBigBlockSize(), headerBlock.getBATCount());
    }
}
