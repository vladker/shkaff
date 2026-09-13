package org.apache.commons.compress.compressors.snappy;

import Y2.a;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int FOUR_BYTE_COPY_TAG = 3;
    private static final int FOUR_SIZE_BYTE_MARKER = 252;
    private static final int MAX_LITERAL_SIZE_WITHOUT_SIZE_BYTES = 60;
    private static final int MAX_LITERAL_SIZE_WITH_ONE_SIZE_BYTE = 256;
    private static final int MAX_LITERAL_SIZE_WITH_THREE_SIZE_BYTES = 16777216;
    private static final int MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES = 65536;
    private static final int MAX_MATCH_LENGTH = 64;
    private static final int MAX_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 11;
    private static final int MAX_OFFSET_WITH_ONE_OFFSET_BYTE = 1024;
    private static final int MAX_OFFSET_WITH_TWO_OFFSET_BYTES = 32768;
    private static final int MIN_MATCH_LENGTH = 4;
    private static final int MIN_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 4;
    private static final int ONE_BYTE_COPY_TAG = 1;
    private static final int ONE_SIZE_BYTE_MARKER = 240;
    private static final int THREE_SIZE_BYTE_MARKER = 248;
    private static final int TWO_BYTE_COPY_TAG = 2;
    private static final int TWO_SIZE_BYTE_MARKER = 244;
    private final LZ77Compressor compressor;
    private final ByteUtils.ByteConsumer consumer;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream$1, reason: invalid class name */
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

    public SnappyCompressorOutputStream(OutputStream outputStream, long j6) {
        this(outputStream, j6, 32768);
    }

    public static Parameters.Builder createParameterBuilder(int i5) {
        return Parameters.builder(i5).withMinBackReferenceLength(4).withMaxBackReferenceLength(64).withMaxOffset(i5).withMaxLiteralLength(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(LZ77Compressor.Block block) throws IOException {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[block.getType().ordinal()];
        if (i5 == 1) {
            writeLiteralBlock((LZ77Compressor.LiteralBlock) block);
        } else {
            if (i5 != 2) {
                return;
            }
            writeBackReference((LZ77Compressor.BackReference) block);
        }
    }

    private void writeBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        int length = backReference.getLength();
        int offset = backReference.getOffset();
        if (length >= 4 && length <= 11 && offset <= 1024) {
            writeBackReferenceWithOneOffsetByte(length, offset);
        } else if (offset < 32768) {
            writeBackReferenceWithTwoOffsetBytes(length, offset);
        } else {
            writeBackReferenceWithFourOffsetBytes(length, offset);
        }
    }

    private void writeBackReferenceWithFourOffsetBytes(int i5, int i6) throws IOException {
        writeBackReferenceWithLittleEndianOffset(3, 4, i5, i6);
    }

    private void writeBackReferenceWithLittleEndianOffset(int i5, int i6, int i7, int i8) throws IOException {
        this.os.write(i5 | ((i7 - 1) << 2));
        writeLittleEndian(i6, i8);
    }

    private void writeBackReferenceWithOneOffsetByte(int i5, int i6) throws IOException {
        this.os.write(((i5 - 4) << 2) | 1 | ((i6 & 1792) >> 3));
        this.os.write(i6 & 255);
    }

    private void writeBackReferenceWithTwoOffsetBytes(int i5, int i6) throws IOException {
        writeBackReferenceWithLittleEndianOffset(2, 2, i5, i6);
    }

    private void writeLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        int length = literalBlock.getLength();
        if (length <= 60) {
            writeLiteralBlockNoSizeBytes(literalBlock, length);
            return;
        }
        if (length <= 256) {
            writeLiteralBlockOneSizeByte(literalBlock, length);
            return;
        }
        if (length <= 65536) {
            writeLiteralBlockTwoSizeBytes(literalBlock, length);
        } else if (length <= 16777216) {
            writeLiteralBlockThreeSizeBytes(literalBlock, length);
        } else {
            writeLiteralBlockFourSizeBytes(literalBlock, length);
        }
    }

    private void writeLiteralBlockFourSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i5) throws IOException {
        writeLiteralBlockWithSize(252, 4, i5, literalBlock);
    }

    private void writeLiteralBlockNoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i5) throws IOException {
        writeLiteralBlockWithSize((i5 - 1) << 2, 0, i5, literalBlock);
    }

    private void writeLiteralBlockOneSizeByte(LZ77Compressor.LiteralBlock literalBlock, int i5) throws IOException {
        writeLiteralBlockWithSize(240, 1, i5, literalBlock);
    }

    private void writeLiteralBlockThreeSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i5) throws IOException {
        writeLiteralBlockWithSize(248, 3, i5, literalBlock);
    }

    private void writeLiteralBlockTwoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i5) throws IOException {
        writeLiteralBlockWithSize(244, 2, i5, literalBlock);
    }

    private void writeLiteralBlockWithSize(int i5, int i6, int i7, LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        this.os.write(i5);
        writeLittleEndian(i6, i7 - 1);
        this.os.write(literalBlock.getData(), literalBlock.getOffset(), i7);
    }

    private void writeLittleEndian(int i5, int i6) {
        ByteUtils.toLittleEndian(this.consumer, i6, i5);
    }

    private void writeUncompressedSize(long j6) throws IOException {
        boolean z6;
        do {
            int i5 = (int) (127 & j6);
            z6 = j6 > ((long) i5);
            if (z6) {
                i5 |= 128;
            }
            this.os.write(i5);
            j6 >>= 7;
        } while (z6);
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

    @Override // java.io.OutputStream
    public void write(int i5) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i5 & 255);
        write(bArr);
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j6, int i5) {
        this(outputStream, j6, createParameterBuilder(i5).build());
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j6, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.os = outputStream;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        this.compressor = new LZ77Compressor(parameters, new a(this, 26));
        writeUncompressedSize(j6);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        this.compressor.compress(bArr, i5, i6);
    }
}
