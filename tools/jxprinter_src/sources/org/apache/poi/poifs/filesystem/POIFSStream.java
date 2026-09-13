package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class POIFSStream implements Iterable<ByteBuffer> {
    private final BlockStore blockStore;
    private OutputStream outStream;
    private int startBlock;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StreamBlockByteBufferIterator implements Iterator<ByteBuffer> {
        private final BlockStore.ChainLoopDetector loopDetector;
        private int nextBlock;

        public StreamBlockByteBufferIterator(int i5) {
            this.nextBlock = i5;
            try {
                this.loopDetector = POIFSStream.this.blockStore.getChainLoopDetector();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextBlock != -2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public ByteBuffer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't read past the end of the stream");
            }
            try {
                this.loopDetector.claim(this.nextBlock);
                ByteBuffer blockAt = POIFSStream.this.blockStore.getBlockAt(this.nextBlock);
                this.nextBlock = POIFSStream.this.blockStore.getNextBlock(this.nextBlock);
                return blockAt;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StreamBlockOffsetIterator implements Iterator<Integer> {
        private final BlockStore.ChainLoopDetector loopDetector;
        private int nextBlock;

        public StreamBlockOffsetIterator(int i5) {
            this.nextBlock = i5;
            try {
                this.loopDetector = POIFSStream.this.blockStore.getChainLoopDetector();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextBlock != -2;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Can't read past the end of the stream");
            }
            this.loopDetector.claim(this.nextBlock);
            int i5 = this.nextBlock;
            this.nextBlock = POIFSStream.this.blockStore.getNextBlock(this.nextBlock);
            return Integer.valueOf(i5);
        }
    }

    public POIFSStream(BlockStore blockStore, int i5) {
        this.blockStore = blockStore;
        this.startBlock = i5;
    }

    public void free() {
        free(this.blockStore.getChainLoopDetector());
    }

    public Iterator<ByteBuffer> getBlockIterator() {
        int i5 = this.startBlock;
        if (i5 != -2) {
            return new StreamBlockByteBufferIterator(i5);
        }
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    public Iterator<Integer> getBlockOffsetIterator() {
        int i5 = this.startBlock;
        if (i5 != -2) {
            return new StreamBlockOffsetIterator(i5);
        }
        throw new IllegalStateException("Can't read from a new stream before it has been written to");
    }

    public OutputStream getOutputStream() {
        if (this.outStream == null) {
            this.outStream = new StreamBlockByteBuffer();
        }
        return this.outStream;
    }

    public int getStartBlock() {
        return this.startBlock;
    }

    @Override // java.lang.Iterable
    public Iterator<ByteBuffer> iterator() {
        return getBlockIterator();
    }

    public void updateContents(byte[] bArr) throws IOException {
        OutputStream outputStream = getOutputStream();
        outputStream.write(bArr);
        outputStream.close();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StreamBlockByteBuffer extends OutputStream {
        ByteBuffer buffer;
        BlockStore.ChainLoopDetector loopDetector;
        int nextBlock;
        byte[] oneByte = new byte[1];
        int prevBlock = -2;

        public StreamBlockByteBuffer() {
            this.loopDetector = POIFSStream.this.blockStore.getChainLoopDetector();
            this.nextBlock = POIFSStream.this.startBlock;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            new POIFSStream(POIFSStream.this.blockStore, this.nextBlock).free(this.loopDetector);
            if (this.prevBlock != -2) {
                POIFSStream.this.blockStore.setNextBlock(this.prevBlock, -2);
            }
        }

        public void createBlockIfNeeded() {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer == null || !byteBuffer.hasRemaining()) {
                int freeBlock = this.nextBlock;
                if (freeBlock == -2) {
                    freeBlock = POIFSStream.this.blockStore.getFreeBlock();
                    this.loopDetector.claim(freeBlock);
                    this.nextBlock = -2;
                    if (this.prevBlock != -2) {
                        POIFSStream.this.blockStore.setNextBlock(this.prevBlock, freeBlock);
                    }
                    POIFSStream.this.blockStore.setNextBlock(freeBlock, -2);
                    if (POIFSStream.this.startBlock == -2) {
                        POIFSStream.this.startBlock = freeBlock;
                    }
                } else {
                    this.loopDetector.claim(freeBlock);
                    this.nextBlock = POIFSStream.this.blockStore.getNextBlock(freeBlock);
                }
                if (this.buffer != null) {
                    POIFSStream.this.blockStore.releaseBuffer(this.buffer);
                }
                this.buffer = POIFSStream.this.blockStore.createBlockIfNeeded(freeBlock);
                this.prevBlock = freeBlock;
            }
        }

        @Override // java.io.OutputStream
        public void write(int i5) throws IOException {
            byte[] bArr = this.oneByte;
            bArr[0] = (byte) (i5 & 255);
            write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            int i7;
            if (i5 < 0 || i5 > bArr.length || i6 < 0 || (i7 = i5 + i6) > bArr.length || i7 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i6 == 0) {
                return;
            }
            do {
                createBlockIfNeeded();
                int iMin = Math.min(this.buffer.remaining(), i6);
                this.buffer.put(bArr, i5, iMin);
                i5 += iMin;
                i6 -= iMin;
            } while (i6 > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void free(BlockStore.ChainLoopDetector chainLoopDetector) {
        int i5 = this.startBlock;
        while (i5 != -2) {
            chainLoopDetector.claim(i5);
            int nextBlock = this.blockStore.getNextBlock(i5);
            this.blockStore.setNextBlock(i5, -1);
            i5 = nextBlock;
        }
        this.startBlock = -2;
    }

    public POIFSStream(BlockStore blockStore) {
        this.blockStore = blockStore;
        this.startBlock = -2;
    }
}
