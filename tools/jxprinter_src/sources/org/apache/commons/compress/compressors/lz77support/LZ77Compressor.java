package org.apache.commons.compress.compressors.lz77support;

import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LZ77Compressor {
    private static final int HASH_MASK = 32767;
    private static final int HASH_SIZE = 32768;
    private static final int H_SHIFT = 5;
    private static final int NO_MATCH = -1;
    static final int NUMBER_OF_BYTES_IN_HASH = 3;
    private static final Block THE_EOD = new EOD();
    private int blockStart;
    private final Callback callback;
    private int currentPosition;
    private final int[] head;
    private boolean initialized;
    private int insertHash;
    private int lookahead;
    private int matchStart = -1;
    private int missedInserts;
    private final Parameters params;
    private final int[] prev;
    private final int wMask;
    private final byte[] window;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class BackReference extends Block {
        private final int length;
        private final int offset;

        public BackReference(int i5, int i6) {
            this.offset = i5;
            this.length = i6;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.BACK_REFERENCE;
        }

        public String toString() {
            return "BackReference with offset " + this.offset + " and length " + this.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Block {

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public enum BlockType {
            LITERAL,
            BACK_REFERENCE,
            EOD
        }

        public abstract BlockType getType();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Callback {
        void accept(Block block);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class EOD extends Block {
        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.EOD;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class LiteralBlock extends Block {
        private final byte[] data;
        private final int length;
        private final int offset;

        public LiteralBlock(byte[] bArr, int i5, int i6) {
            this.data = bArr;
            this.offset = i5;
            this.length = i6;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getLength() {
            return this.length;
        }

        public int getOffset() {
            return this.offset;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.LITERAL;
        }

        public String toString() {
            return "LiteralBlock starting at " + this.offset + " with length " + this.length;
        }
    }

    public LZ77Compressor(Parameters parameters, Callback callback) {
        Objects.requireNonNull(parameters, "params");
        Objects.requireNonNull(callback, "callback");
        this.params = parameters;
        this.callback = callback;
        int windowSize = parameters.getWindowSize();
        this.window = new byte[windowSize * 2];
        this.wMask = windowSize - 1;
        int[] iArr = new int[32768];
        this.head = iArr;
        Arrays.fill(iArr, -1);
        this.prev = new int[windowSize];
    }

    private void catchUpMissedInserts() {
        while (true) {
            int i5 = this.missedInserts;
            if (i5 <= 0) {
                return;
            }
            int i6 = this.currentPosition;
            this.missedInserts = i5 - 1;
            insertString(i6 - i5);
        }
    }

    private void doCompress(byte[] bArr, int i5, int i6) {
        if (i6 > (this.window.length - this.currentPosition) - this.lookahead) {
            slide();
        }
        System.arraycopy(bArr, i5, this.window, this.currentPosition + this.lookahead, i6);
        int i7 = this.lookahead + i6;
        this.lookahead = i7;
        if (!this.initialized && i7 >= this.params.getMinBackReferenceLength()) {
            initialize();
        }
        if (this.initialized) {
            compress();
        }
    }

    private void flushBackReference(int i5) {
        this.callback.accept(new BackReference(this.currentPosition - this.matchStart, i5));
    }

    private void flushLiteralBlock() {
        Callback callback = this.callback;
        byte[] bArr = this.window;
        int i5 = this.blockStart;
        callback.accept(new LiteralBlock(bArr, i5, this.currentPosition - i5));
    }

    private void initialize() {
        for (int i5 = 0; i5 < 2; i5++) {
            this.insertHash = nextHash(this.insertHash, this.window[i5]);
        }
        this.initialized = true;
    }

    private int insertString(int i5) {
        int iNextHash = nextHash(this.insertHash, this.window[i5 + 2]);
        this.insertHash = iNextHash;
        int[] iArr = this.head;
        int i6 = iArr[iNextHash];
        this.prev[this.wMask & i5] = i6;
        iArr[iNextHash] = i5;
        return i6;
    }

    private void insertStringsInMatch(int i5) {
        int iMin = Math.min(i5 - 1, this.lookahead - 3);
        for (int i6 = 1; i6 <= iMin; i6++) {
            insertString(this.currentPosition + i6);
        }
        this.missedInserts = (i5 - iMin) - 1;
    }

    private int longestMatch(int i5) {
        int minBackReferenceLength = this.params.getMinBackReferenceLength() - 1;
        int iMin = Math.min(this.params.getMaxBackReferenceLength(), this.lookahead);
        int iMax = Math.max(0, this.currentPosition - this.params.getMaxOffset());
        int iMin2 = Math.min(iMin, this.params.getNiceBackReferenceLength());
        int maxCandidates = this.params.getMaxCandidates();
        for (int i6 = 0; i6 < maxCandidates && i5 >= iMax; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < iMin; i8++) {
                byte[] bArr = this.window;
                if (bArr[i5 + i8] != bArr[this.currentPosition + i8]) {
                    break;
                }
                i7++;
            }
            if (i7 > minBackReferenceLength) {
                this.matchStart = i5;
                if (i7 >= iMin2) {
                    return i7;
                }
                minBackReferenceLength = i7;
            }
            i5 = this.prev[i5 & this.wMask];
        }
        return minBackReferenceLength;
    }

    private int longestMatchForNextPosition(int i5) {
        int i6 = this.matchStart;
        int i7 = this.insertHash;
        this.lookahead--;
        int i8 = this.currentPosition + 1;
        this.currentPosition = i8;
        int iInsertString = insertString(i8);
        int i9 = this.prev[this.currentPosition & this.wMask];
        int iLongestMatch = longestMatch(iInsertString);
        if (iLongestMatch > i5) {
            return iLongestMatch;
        }
        this.matchStart = i6;
        this.head[this.insertHash] = i9;
        this.insertHash = i7;
        this.currentPosition--;
        this.lookahead++;
        return i5;
    }

    private int nextHash(int i5, byte b) {
        return ((i5 << 5) ^ (b & UnsignedBytes.MAX_VALUE)) & HASH_MASK;
    }

    private void slide() {
        int windowSize = this.params.getWindowSize();
        int i5 = this.blockStart;
        if (i5 != this.currentPosition && i5 < windowSize) {
            flushLiteralBlock();
            this.blockStart = this.currentPosition;
        }
        byte[] bArr = this.window;
        System.arraycopy(bArr, windowSize, bArr, 0, windowSize);
        this.currentPosition -= windowSize;
        this.matchStart -= windowSize;
        this.blockStart -= windowSize;
        int i6 = 0;
        while (true) {
            int i7 = -1;
            if (i6 >= 32768) {
                break;
            }
            int[] iArr = this.head;
            int i8 = iArr[i6];
            if (i8 >= windowSize) {
                i7 = i8 - windowSize;
            }
            iArr[i6] = i7;
            i6++;
        }
        for (int i9 = 0; i9 < windowSize; i9++) {
            int[] iArr2 = this.prev;
            int i10 = iArr2[i9];
            iArr2[i9] = i10 >= windowSize ? i10 - windowSize : -1;
        }
    }

    public void compress(byte[] bArr) {
        compress(bArr, 0, bArr.length);
    }

    public void finish() {
        int i5 = this.blockStart;
        int i6 = this.currentPosition;
        if (i5 != i6 || this.lookahead > 0) {
            this.currentPosition = i6 + this.lookahead;
            flushLiteralBlock();
        }
        this.callback.accept(THE_EOD);
    }

    public void prefill(byte[] bArr) {
        if (this.currentPosition != 0 || this.lookahead != 0) {
            throw new IllegalStateException("The compressor has already started to accept data, can't prefill anymore");
        }
        int iMin = Math.min(this.params.getWindowSize(), bArr.length);
        System.arraycopy(bArr, bArr.length - iMin, this.window, 0, iMin);
        if (iMin >= 3) {
            initialize();
            int i5 = iMin - 2;
            for (int i6 = 0; i6 < i5; i6++) {
                insertString(i6);
            }
            this.missedInserts = 2;
        } else {
            this.missedInserts = iMin;
        }
        this.currentPosition = iMin;
        this.blockStart = iMin;
    }

    public void compress(byte[] bArr, int i5, int i6) {
        int windowSize = this.params.getWindowSize();
        while (i6 > windowSize) {
            doCompress(bArr, i5, windowSize);
            i5 += windowSize;
            i6 -= windowSize;
        }
        if (i6 > 0) {
            doCompress(bArr, i5, i6);
        }
    }

    private void compress() {
        int iLongestMatch;
        int minBackReferenceLength = this.params.getMinBackReferenceLength();
        boolean lazyMatching = this.params.getLazyMatching();
        int lazyMatchingThreshold = this.params.getLazyMatchingThreshold();
        while (this.lookahead >= minBackReferenceLength) {
            catchUpMissedInserts();
            int iInsertString = insertString(this.currentPosition);
            if (iInsertString == -1 || iInsertString - this.currentPosition > this.params.getMaxOffset()) {
                iLongestMatch = 0;
            } else {
                iLongestMatch = longestMatch(iInsertString);
                if (lazyMatching && iLongestMatch <= lazyMatchingThreshold && this.lookahead > minBackReferenceLength) {
                    iLongestMatch = longestMatchForNextPosition(iLongestMatch);
                }
            }
            if (iLongestMatch >= minBackReferenceLength) {
                if (this.blockStart != this.currentPosition) {
                    flushLiteralBlock();
                    this.blockStart = -1;
                }
                flushBackReference(iLongestMatch);
                insertStringsInMatch(iLongestMatch);
                this.lookahead -= iLongestMatch;
                int i5 = this.currentPosition + iLongestMatch;
                this.currentPosition = i5;
                this.blockStart = i5;
            } else {
                this.lookahead--;
                int i6 = this.currentPosition + 1;
                this.currentPosition = i6;
                if (i6 - this.blockStart >= this.params.getMaxLiteralLength()) {
                    flushLiteralBlock();
                    this.blockStart = this.currentPosition;
                }
            }
        }
    }
}
