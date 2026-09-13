package org.apache.poi.poifs.filesystem;

import java.nio.ByteBuffer;
import org.apache.poi.poifs.storage.BATBlock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BlockStore {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ChainLoopDetector {
        private final boolean[] used_blocks;

        public ChainLoopDetector(long j6) {
            if (j6 < 0) {
                throw new IllegalArgumentException(androidx.collection.a.j(j6, "Cannot create a ChainLoopDetector with negative size, but had: "));
            }
            long blockStoreBlockSize = BlockStore.this.getBlockStoreBlockSize();
            int i5 = (int) (j6 / blockStoreBlockSize);
            this.used_blocks = new boolean[j6 % blockStoreBlockSize != 0 ? i5 + 1 : i5];
        }

        public void claim(int i5) {
            boolean[] zArr = this.used_blocks;
            if (i5 >= zArr.length) {
                return;
            }
            if (zArr[i5]) {
                throw new IllegalStateException(androidx.collection.a.i(i5, "Potential loop detected - Block ", " was already claimed but was just requested again"));
            }
            zArr[i5] = true;
        }
    }

    public abstract ByteBuffer createBlockIfNeeded(int i5);

    public abstract BATBlock.BATBlockAndIndex getBATBlockAndIndex(int i5);

    public abstract ByteBuffer getBlockAt(int i5);

    public abstract int getBlockStoreBlockSize();

    public abstract ChainLoopDetector getChainLoopDetector();

    public abstract int getFreeBlock();

    public abstract int getNextBlock(int i5);

    public abstract void releaseBuffer(ByteBuffer byteBuffer);

    public abstract void setNextBlock(int i5, int i6);
}
