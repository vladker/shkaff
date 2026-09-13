package org.apache.commons.compress.compressors.deflate64;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.poi.hssf.record.ArrayRecord;
import org.apache.poi.hssf.record.DSFRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.record.chart.SeriesIndexRecord;
import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class HuffmanDecoder implements Closeable {
    private static final int[] FIXED_DISTANCE;
    private static final int[] FIXED_LITERALS;
    private boolean finalBlock;
    private final InputStream in;
    private final DecodingMemory memory;
    private BitInputStream reader;
    private DecoderState state;
    private static final short[] RUN_LENGTH_TABLE = {96, 128, 160, EscherAggregate.ST_ACTIONBUTTONINFORMATION, ExtendedFormatRecord.sid, ExtendedPivotTableViewFieldsRecord.sid, 288, 320, DSFRecord.sid, 417, 481, ArrayRecord.sid, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, SeriesIndexRecord.sid, 5221, 6245, 7269, EscherAggregate.ST_FLOWCHARTPREDEFINEDPROCESS};
    private static final int[] DISTANCE_TABLE = {16, 32, 48, 64, 81, 113, 146, 210, 275, 403, Videoio.CAP_PROP_XI_SENSOR_CLOCK_FREQ_HZ, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};
    private static final int[] CODE_LENGTHS_ORDER = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class BinaryTreeNode {
        private final int bits;
        BinaryTreeNode leftNode;
        int literal;
        BinaryTreeNode rightNode;

        public void leaf(int i5) {
            this.literal = i5;
            this.leftNode = null;
            this.rightNode = null;
        }

        public BinaryTreeNode left() {
            if (this.leftNode == null && this.literal == -1) {
                this.leftNode = new BinaryTreeNode(this.bits + 1);
            }
            return this.leftNode;
        }

        public BinaryTreeNode right() {
            if (this.rightNode == null && this.literal == -1) {
                this.rightNode = new BinaryTreeNode(this.bits + 1);
            }
            return this.rightNode;
        }

        private BinaryTreeNode(int i5) {
            this.literal = -1;
            this.bits = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class DecoderState {
        private DecoderState() {
        }

        public abstract int available();

        public abstract boolean hasData();

        public abstract int read(byte[] bArr, int i5, int i6);

        public abstract HuffmanState state();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DecodingMemory {
        private final int mask;
        private final byte[] memory;
        private int wHead;
        private boolean wrappedAround;

        private int incCounter(int i5) {
            int i6 = (i5 + 1) & this.mask;
            if (!this.wrappedAround && i6 < i5) {
                this.wrappedAround = true;
            }
            return i6;
        }

        public byte add(byte b) {
            byte[] bArr = this.memory;
            int i5 = this.wHead;
            bArr[i5] = b;
            this.wHead = incCounter(i5);
            return b;
        }

        public void recordToBuffer(int i5, int i6, byte[] bArr) {
            if (i5 > this.memory.length) {
                throw new IllegalStateException(AbstractC0157z.k(i5, "Illegal distance parameter: "));
            }
            int i7 = this.wHead;
            int iIncCounter = (i7 - i5) & this.mask;
            if (!this.wrappedAround && iIncCounter >= i7) {
                throw new IllegalStateException(AbstractC0157z.k(i5, "Attempt to read beyond memory: dist="));
            }
            int i8 = 0;
            while (i8 < i6) {
                bArr[i8] = add(this.memory[iIncCounter]);
                i8++;
                iIncCounter = incCounter(iIncCounter);
            }
        }

        private DecodingMemory() {
            this(16);
        }

        private DecodingMemory(int i5) {
            byte[] bArr = new byte[1 << i5];
            this.memory = bArr;
            this.mask = bArr.length - 1;
        }

        public void add(byte[] bArr, int i5, int i6) {
            for (int i7 = i5; i7 < i5 + i6; i7++) {
                add(bArr[i7]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class HuffmanCodes extends DecoderState {
        private final BinaryTreeNode distanceTree;
        private boolean endOfBlock;
        private final BinaryTreeNode lengthTree;
        private byte[] runBuffer;
        private int runBufferLength;
        private int runBufferPos;
        private final HuffmanState state;

        public HuffmanCodes(HuffmanState huffmanState, int[] iArr, int[] iArr2) {
            super();
            this.runBuffer = ByteUtils.EMPTY_BYTE_ARRAY;
            this.state = huffmanState;
            this.lengthTree = HuffmanDecoder.buildTree(iArr);
            this.distanceTree = HuffmanDecoder.buildTree(iArr2);
        }

        private int copyFromRunBuffer(byte[] bArr, int i5, int i6) {
            int i7 = this.runBufferLength - this.runBufferPos;
            if (i7 <= 0) {
                return 0;
            }
            int iMin = Math.min(i6, i7);
            System.arraycopy(this.runBuffer, this.runBufferPos, bArr, i5, iMin);
            this.runBufferPos += iMin;
            return iMin;
        }

        private int decodeNext(byte[] bArr, int i5, int i6) {
            if (this.endOfBlock) {
                return -1;
            }
            int iCopyFromRunBuffer = copyFromRunBuffer(bArr, i5, i6);
            while (iCopyFromRunBuffer < i6) {
                int iNextSymbol = HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.lengthTree);
                if (iNextSymbol >= 256) {
                    if (iNextSymbol <= 256) {
                        this.endOfBlock = true;
                        break;
                    }
                    short s6 = HuffmanDecoder.RUN_LENGTH_TABLE[iNextSymbol - 257];
                    int bits = (int) (((long) (s6 >>> 5)) + HuffmanDecoder.this.readBits(s6 & 31));
                    int i7 = HuffmanDecoder.DISTANCE_TABLE[HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.distanceTree)];
                    int bits2 = (int) (((long) (i7 >>> 4)) + HuffmanDecoder.this.readBits(i7 & 15));
                    if (this.runBuffer.length < bits) {
                        this.runBuffer = new byte[bits];
                    }
                    this.runBufferLength = bits;
                    this.runBufferPos = 0;
                    HuffmanDecoder.this.memory.recordToBuffer(bits2, bits, this.runBuffer);
                    iCopyFromRunBuffer += copyFromRunBuffer(bArr, i5 + iCopyFromRunBuffer, i6 - iCopyFromRunBuffer);
                } else {
                    bArr[iCopyFromRunBuffer + i5] = HuffmanDecoder.this.memory.add((byte) iNextSymbol);
                    iCopyFromRunBuffer++;
                }
            }
            return iCopyFromRunBuffer;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int available() {
            return this.runBufferLength - this.runBufferPos;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public boolean hasData() {
            return !this.endOfBlock;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int read(byte[] bArr, int i5, int i6) {
            if (i6 == 0) {
                return 0;
            }
            return decodeNext(bArr, i5, i6);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public HuffmanState state() {
            return this.endOfBlock ? HuffmanState.INITIAL : this.state;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class InitialState extends DecoderState {
        private InitialState() {
            super();
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int available() {
            return 0;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public boolean hasData() {
            return false;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int read(byte[] bArr, int i5, int i6) {
            if (i6 == 0) {
                return 0;
            }
            throw new IllegalStateException("Cannot read in this state");
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public HuffmanState state() {
            return HuffmanState.INITIAL;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class UncompressedState extends DecoderState {
        private final long blockLength;
        private long read;

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int available() {
            return (int) Math.min(this.blockLength - this.read, HuffmanDecoder.this.reader.bitsAvailable() / 8);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public boolean hasData() {
            return this.read < this.blockLength;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public int read(byte[] bArr, int i5, int i6) throws IOException {
            int i7;
            int i8 = 0;
            if (i6 == 0) {
                return 0;
            }
            int iMin = (int) Math.min(this.blockLength - this.read, i6);
            while (i8 < iMin) {
                if (HuffmanDecoder.this.reader.bitsCached() > 0) {
                    bArr[i5 + i8] = HuffmanDecoder.this.memory.add((byte) HuffmanDecoder.this.readBits(8));
                    i7 = 1;
                } else {
                    int i9 = i5 + i8;
                    i7 = HuffmanDecoder.this.in.read(bArr, i9, iMin - i8);
                    if (i7 == -1) {
                        throw new EOFException("Truncated Deflate64 Stream");
                    }
                    HuffmanDecoder.this.memory.add(bArr, i9, i7);
                }
                this.read += (long) i7;
                i8 += i7;
            }
            return iMin;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        public HuffmanState state() {
            return this.read < this.blockLength ? HuffmanState.STORED : HuffmanState.INITIAL;
        }

        private UncompressedState(long j6) {
            super();
            this.blockLength = j6;
        }
    }

    static {
        int[] iArr = new int[288];
        FIXED_LITERALS = iArr;
        Arrays.fill(iArr, 0, 144, 8);
        Arrays.fill(iArr, 144, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        FIXED_DISTANCE = iArr2;
        Arrays.fill(iArr2, 5);
    }

    public HuffmanDecoder(InputStream inputStream) {
        this.memory = new DecodingMemory();
        this.reader = new BitInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.in = inputStream;
        this.state = new InitialState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BinaryTreeNode buildTree(int[] iArr) {
        int[] codes = getCodes(iArr);
        int i5 = 0;
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(i5);
        while (i5 < iArr.length) {
            int i6 = iArr[i5];
            if (i6 != 0) {
                int i7 = i6 - 1;
                int i8 = codes[i7];
                BinaryTreeNode binaryTreeNodeLeft = binaryTreeNode;
                for (int i9 = i7; i9 >= 0; i9--) {
                    binaryTreeNodeLeft = ((1 << i9) & i8) == 0 ? binaryTreeNodeLeft.left() : binaryTreeNodeLeft.right();
                    if (binaryTreeNodeLeft == null) {
                        throw new IllegalStateException("node doesn't exist in Huffman tree");
                    }
                }
                binaryTreeNodeLeft.leaf(i5);
                codes[i7] = codes[i7] + 1;
            }
            i5++;
        }
        return binaryTreeNode;
    }

    private static int[] getCodes(int[] iArr) {
        int[] iArr2 = new int[65];
        int iMax = 0;
        for (int i5 : iArr) {
            if (i5 < 0 || i5 > 64) {
                throw new IllegalArgumentException(a.i(i5, "Invalid code ", " in literal table"));
            }
            iMax = Math.max(iMax, i5);
            iArr2[i5] = iArr2[i5] + 1;
        }
        int i6 = iMax + 1;
        int[] iArrCopyOf = Arrays.copyOf(iArr2, i6);
        int[] iArr3 = new int[i6];
        int i7 = 0;
        for (int i8 = 0; i8 <= iMax; i8++) {
            i7 = (i7 + iArrCopyOf[i8]) << 1;
            iArr3[i8] = i7;
        }
        return iArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int nextSymbol(BitInputStream bitInputStream, BinaryTreeNode binaryTreeNode) {
        while (binaryTreeNode != null && binaryTreeNode.literal == -1) {
            binaryTreeNode = readBits(bitInputStream, 1) == 0 ? binaryTreeNode.leftNode : binaryTreeNode.rightNode;
        }
        if (binaryTreeNode != null) {
            return binaryTreeNode.literal;
        }
        return -1;
    }

    private static void populateDynamicTables(BitInputStream bitInputStream, int[] iArr, int[] iArr2) throws IOException {
        long bits;
        int bits2 = (int) (readBits(bitInputStream, 4) + 4);
        int[] iArr3 = new int[19];
        for (int i5 = 0; i5 < bits2; i5++) {
            iArr3[CODE_LENGTHS_ORDER[i5]] = (int) readBits(bitInputStream, 3);
        }
        BinaryTreeNode binaryTreeNodeBuildTree = buildTree(iArr3);
        int length = iArr.length + iArr2.length;
        int[] iArr4 = new int[length];
        int i6 = -1;
        int i7 = 0;
        int bits3 = 0;
        while (i7 < length) {
            if (bits3 > 0) {
                iArr4[i7] = i6;
                bits3--;
                i7++;
            } else {
                int iNextSymbol = nextSymbol(bitInputStream, binaryTreeNodeBuildTree);
                if (iNextSymbol < 16) {
                    iArr4[i7] = iNextSymbol;
                    i7++;
                    i6 = iNextSymbol;
                } else {
                    long j6 = 3;
                    switch (iNextSymbol) {
                        case 16:
                            bits3 = (int) (readBits(bitInputStream, 2) + 3);
                            continue;
                        case 17:
                            bits = readBits(bitInputStream, 3);
                            break;
                        case 18:
                            bits = readBits(bitInputStream, 7);
                            j6 = 11;
                            break;
                        default:
                            continue;
                    }
                    bits3 = (int) (bits + j6);
                    i6 = 0;
                }
            }
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr.length);
        System.arraycopy(iArr4, iArr.length, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long readBits(int i5) {
        return readBits(this.reader, i5);
    }

    private int[][] readDynamicTables() throws IOException {
        int[][] iArr = {new int[(int) (readBits(5) + 257)], new int[(int) (readBits(5) + 1)]};
        populateDynamicTables(this.reader, iArr[0], iArr[1]);
        return iArr;
    }

    private void switchToUncompressedState() {
        this.reader.alignWithByteBoundary();
        long bits = readBits(16);
        if ((65535 & (bits ^ 65535)) != readBits(16)) {
            throw new IllegalStateException("Illegal LEN / NLEN values");
        }
        this.state = new UncompressedState(bits);
    }

    public int available() {
        return this.state.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.state = new InitialState();
        this.reader = null;
    }

    public int decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }

    public long getBytesRead() {
        return this.reader.getBytesRead();
    }

    private static long readBits(BitInputStream bitInputStream, int i5) throws IOException {
        long bits = bitInputStream.readBits(i5);
        if (bits != -1) {
            return bits;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }

    public int decode(byte[] bArr, int i5, int i6) throws IOException {
        while (true) {
            if (this.finalBlock && !this.state.hasData()) {
                return -1;
            }
            if (this.state.state() == HuffmanState.INITIAL) {
                this.finalBlock = readBits(1) == 1;
                int bits = (int) readBits(2);
                if (bits == 0) {
                    switchToUncompressedState();
                } else if (bits == 1) {
                    this.state = new HuffmanCodes(HuffmanState.FIXED_CODES, FIXED_LITERALS, FIXED_DISTANCE);
                } else {
                    if (bits != 2) {
                        throw new IllegalStateException(AbstractC0157z.k(bits, "Unsupported compression: "));
                    }
                    int[][] dynamicTables = readDynamicTables();
                    this.state = new HuffmanCodes(HuffmanState.DYNAMIC_CODES, dynamicTables[0], dynamicTables[1]);
                }
            } else {
                int i7 = this.state.read(bArr, i5, i6);
                if (i7 != 0) {
                    return i7;
                }
            }
        }
    }
}
