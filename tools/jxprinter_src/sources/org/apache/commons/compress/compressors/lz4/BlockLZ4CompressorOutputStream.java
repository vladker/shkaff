package org.apache.commons.compress.compressors.lz4;

import A3.AbstractC0157z;
import Y2.a;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BlockLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final int MIN_BACK_REFERENCE_LENGTH = 4;
    private static final int MIN_OFFSET_OF_LAST_BACK_REFERENCE = 12;
    private final LZ77Compressor compressor;
    private final Deque<byte[]> expandedBlocks;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;
    private final Deque<Pair> pairs;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType;

        static {
            int[] iArr = new int[LZ77Compressor.Block.BlockType.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = iArr;
            try {
                iArr[LZ77Compressor.Block.BlockType.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.BACK_REFERENCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.EOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Pair {
        private int brLength;
        private int brOffset;
        private final Deque<byte[]> literals = new LinkedList();
        private boolean written;

        /* JADX INFO: Access modifiers changed from: private */
        public int backReferenceLength() {
            return this.brLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasBeenWritten() {
            return this.written;
        }

        private static int lengths(int i5, int i6) {
            int i7 = 15;
            if (i5 >= 15) {
                i5 = 15;
            }
            if (i6 < 4) {
                i7 = 0;
            } else if (i6 < 19) {
                i7 = i6 - 4;
            }
            return (i5 << 4) | i7;
        }

        private int literalLength() {
            Iterator<byte[]> it = this.literals.iterator();
            int length = 0;
            while (it.hasNext()) {
                length += it.next().length;
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void prependLiteral(byte[] bArr) {
            this.literals.addFirst(bArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void prependTo(Pair pair) {
            Iterator<byte[]> itDescendingIterator = this.literals.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                pair.prependLiteral(itDescendingIterator.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Pair splitWithNewBackReferenceLengthOf(int i5) {
            Pair pair = new Pair();
            pair.literals.addAll(this.literals);
            pair.brOffset = this.brOffset;
            pair.brLength = i5;
            return pair;
        }

        private static void writeLength(int i5, OutputStream outputStream) throws IOException {
            while (i5 >= 255) {
                outputStream.write(255);
                i5 -= 255;
            }
            outputStream.write(i5);
        }

        public byte[] addLiteral(LZ77Compressor.LiteralBlock literalBlock) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(literalBlock.getData(), literalBlock.getOffset(), literalBlock.getLength() + literalBlock.getOffset());
            this.literals.add(bArrCopyOfRange);
            return bArrCopyOfRange;
        }

        public boolean canBeWritten(int i5) {
            return hasBackReference() && i5 >= 16;
        }

        public boolean hasBackReference() {
            return this.brOffset > 0;
        }

        public int length() {
            return literalLength() + this.brLength;
        }

        public void setBackReference(LZ77Compressor.BackReference backReference) {
            if (hasBackReference()) {
                throw new IllegalStateException();
            }
            this.brOffset = backReference.getOffset();
            this.brLength = backReference.getLength();
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            int iLiteralLength = literalLength();
            outputStream.write(lengths(iLiteralLength, this.brLength));
            if (iLiteralLength >= 15) {
                writeLength(iLiteralLength - 15, outputStream);
            }
            Iterator<byte[]> it = this.literals.iterator();
            while (it.hasNext()) {
                outputStream.write(it.next());
            }
            if (hasBackReference()) {
                ByteUtils.toLittleEndian(outputStream, this.brOffset, 2);
                int i5 = this.brLength;
                if (i5 - 4 >= 15) {
                    writeLength(i5 - 19, outputStream);
                }
            }
            this.written = true;
        }
    }

    public BlockLZ4CompressorOutputStream(OutputStream outputStream) {
        this(outputStream, createParameterBuilder().build());
    }

    private void addBackReference(LZ77Compressor.BackReference backReference) {
        writeBlocksAndReturnUnfinishedPair(backReference.getLength()).setBackReference(backReference);
        recordBackReference(backReference);
        clearUnusedBlocksAndPairs();
    }

    private void addLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) {
        recordLiteral(writeBlocksAndReturnUnfinishedPair(literalBlock.getLength()).addLiteral(literalBlock));
        clearUnusedBlocksAndPairs();
    }

    private void clearUnusedBlocks() {
        Iterator<byte[]> it = this.expandedBlocks.iterator();
        int i5 = 0;
        int length = 0;
        while (it.hasNext()) {
            i5++;
            length += it.next().length;
            if (length >= 65536) {
                break;
            }
        }
        int size = this.expandedBlocks.size();
        while (i5 < size) {
            this.expandedBlocks.removeLast();
            i5++;
        }
    }

    private void clearUnusedBlocksAndPairs() {
        clearUnusedBlocks();
        clearUnusedPairs();
    }

    private void clearUnusedPairs() {
        Iterator<Pair> itDescendingIterator = this.pairs.descendingIterator();
        int i5 = 0;
        int length = 0;
        while (itDescendingIterator.hasNext()) {
            i5++;
            length += itDescendingIterator.next().length();
            if (length >= 65536) {
                break;
            }
        }
        int size = this.pairs.size();
        while (i5 < size && this.pairs.peekFirst().hasBeenWritten()) {
            this.pairs.removeFirst();
            i5++;
        }
    }

    public static Parameters.Builder createParameterBuilder() {
        return Parameters.builder(65536).withMinBackReferenceLength(4).withMaxBackReferenceLength(65535).withMaxOffset(65535).withMaxLiteralLength(65535);
    }

    private byte[] expand(int i5, int i6) {
        byte[] bArr = new byte[i6];
        if (i5 != 1) {
            expandFromList(bArr, i5, i6);
            return bArr;
        }
        byte[] bArrPeekFirst = this.expandedBlocks.peekFirst();
        byte b = bArrPeekFirst[bArrPeekFirst.length - 1];
        if (b != 0) {
            Arrays.fill(bArr, b);
        }
        return bArr;
    }

    private void expandFromList(byte[] bArr, int i5, int i6) {
        int length;
        int iMin;
        byte[] next;
        int i7 = i5;
        int i8 = 0;
        while (i6 > 0) {
            if (i7 > 0) {
                Iterator<byte[]> it = this.expandedBlocks.iterator();
                int length2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.length + length2 >= i7) {
                        break;
                    } else {
                        length2 += next.length;
                    }
                }
                if (next == null) {
                    throw new IllegalStateException(AbstractC0157z.k(i5, "Failed to find a block containing offset "));
                }
                length = (length2 + next.length) - i7;
                iMin = Math.min(i6, next.length - length);
            } else {
                length = -i7;
                iMin = Math.min(i6, i8 + i7);
                next = bArr;
            }
            System.arraycopy(next, length, bArr, i8, iMin);
            i7 -= iMin;
            i6 -= iMin;
            i8 += iMin;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(LZ77Compressor.Block block) throws IOException {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[block.getType().ordinal()];
        if (i5 == 1) {
            addLiteralBlock((LZ77Compressor.LiteralBlock) block);
        } else if (i5 == 2) {
            addBackReference((LZ77Compressor.BackReference) block);
        } else {
            if (i5 != 3) {
                return;
            }
            writeFinalLiteralBlock();
        }
    }

    private void recordBackReference(LZ77Compressor.BackReference backReference) {
        this.expandedBlocks.addFirst(expand(backReference.getOffset(), backReference.getLength()));
    }

    private void recordLiteral(byte[] bArr) {
        this.expandedBlocks.addFirst(bArr);
    }

    private void rewriteLastPairs() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator<Pair> itDescendingIterator = this.pairs.descendingIterator();
        int i5 = 0;
        while (itDescendingIterator.hasNext()) {
            Pair next = itDescendingIterator.next();
            if (next.hasBeenWritten()) {
                break;
            }
            int length = next.length();
            linkedList2.addFirst(Integer.valueOf(length));
            linkedList.addFirst(next);
            i5 += length;
            if (i5 >= 12) {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.pairs.remove((Pair) it.next());
        }
        int size = linkedList.size();
        int iIntValue = 0;
        for (int i6 = 1; i6 < size; i6++) {
            iIntValue += ((Integer) linkedList2.get(i6)).intValue();
        }
        Pair pair = new Pair();
        if (iIntValue > 0) {
            pair.prependLiteral(expand(iIntValue, iIntValue));
        }
        Pair pair2 = (Pair) linkedList.get(0);
        int i7 = 12 - iIntValue;
        int iBackReferenceLength = pair2.hasBackReference() ? pair2.backReferenceLength() : 0;
        if (!pair2.hasBackReference() || iBackReferenceLength < 16 - iIntValue) {
            if (pair2.hasBackReference()) {
                pair.prependLiteral(expand(iIntValue + iBackReferenceLength, iBackReferenceLength));
            }
            pair2.prependTo(pair);
        } else {
            pair.prependLiteral(expand(iIntValue + i7, i7));
            this.pairs.add(pair2.splitWithNewBackReferenceLengthOf(iBackReferenceLength - i7));
        }
        this.pairs.add(pair);
    }

    private Pair writeBlocksAndReturnUnfinishedPair(int i5) throws IOException {
        writeWritablePairs(i5);
        Pair pairPeekLast = this.pairs.peekLast();
        if (pairPeekLast != null && !pairPeekLast.hasBackReference()) {
            return pairPeekLast;
        }
        Pair pair = new Pair();
        this.pairs.addLast(pair);
        return pair;
    }

    private void writeFinalLiteralBlock() throws IOException {
        rewriteLastPairs();
        for (Pair pair : this.pairs) {
            if (!pair.hasBeenWritten()) {
                pair.writeTo(this.os);
            }
        }
        this.pairs.clear();
    }

    private void writeWritablePairs(int i5) throws IOException {
        Iterator<Pair> itDescendingIterator = this.pairs.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            Pair next = itDescendingIterator.next();
            if (next.hasBeenWritten()) {
                break;
            } else {
                i5 += next.length();
            }
        }
        for (Pair pair : this.pairs) {
            if (!pair.hasBeenWritten()) {
                i5 -= pair.length();
                if (!pair.canBeWritten(i5)) {
                    return;
                } else {
                    pair.writeTo(this.os);
                }
            }
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.os.close();
        }
    }

    public void finish() {
        if (this.finished) {
            return;
        }
        this.compressor.finish();
        this.finished = true;
    }

    public void prefill(byte[] bArr, int i5, int i6) {
        if (i6 > 0) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i6 + i5);
            this.compressor.prefill(bArrCopyOfRange);
            recordLiteral(bArrCopyOfRange);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr);
    }

    public BlockLZ4CompressorOutputStream(OutputStream outputStream, Parameters parameters) {
        this.oneByte = new byte[1];
        this.pairs = new LinkedList();
        this.expandedBlocks = new LinkedList();
        this.os = outputStream;
        this.compressor = new LZ77Compressor(parameters, new a(this, 22));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.compressor.compress(bArr, i5, i6);
    }
}
