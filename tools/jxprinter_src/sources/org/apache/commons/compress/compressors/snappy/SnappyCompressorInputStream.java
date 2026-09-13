package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SnappyCompressorInputStream extends AbstractLZ77CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private boolean endReached;
    private final int size;
    private State state;
    private int uncompressedBytesRemaining;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State = iArr;
            try {
                iArr[State.NO_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[State.IN_LITERAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[State.IN_BACK_REFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum State {
        NO_BLOCK,
        IN_LITERAL,
        IN_BACK_REFERENCE
    }

    public SnappyCompressorInputStream(InputStream inputStream) {
        this(inputStream, 32768);
    }

    private void fill() throws IOException {
        if (this.uncompressedBytesRemaining == 0) {
            this.endReached = true;
            return;
        }
        int oneByte = readOneByte();
        if (oneByte == -1) {
            throw new IOException("Premature end of stream reading block start");
        }
        int i5 = oneByte & 3;
        if (i5 == 0) {
            int literalLength = readLiteralLength(oneByte);
            if (literalLength < 0) {
                throw new IOException("Illegal block with a negative literal size found");
            }
            this.uncompressedBytesRemaining -= literalLength;
            startLiteral(literalLength);
            this.state = State.IN_LITERAL;
            return;
        }
        if (i5 == 1) {
            int i6 = ((oneByte >> 2) & 7) + 4;
            if (i6 < 0) {
                throw new IOException("Illegal block with a negative match length found");
            }
            this.uncompressedBytesRemaining -= i6;
            int i7 = (oneByte & 224) << 3;
            int oneByte2 = readOneByte();
            if (oneByte2 == -1) {
                throw new IOException("Premature end of stream reading back-reference length");
            }
            try {
                startBackReference(i7 | oneByte2, i6);
                this.state = State.IN_BACK_REFERENCE;
                return;
            } catch (IllegalArgumentException e) {
                throw new IOException("Illegal block with bad offset found", e);
            }
        }
        if (i5 == 2) {
            int i8 = (oneByte >> 2) + 1;
            if (i8 < 0) {
                throw new IOException("Illegal block with a negative match length found");
            }
            this.uncompressedBytesRemaining -= i8;
            try {
                startBackReference((int) ByteUtils.fromLittleEndian(this.supplier, 2), i8);
                this.state = State.IN_BACK_REFERENCE;
                return;
            } catch (IllegalArgumentException e6) {
                throw new IOException("Illegal block with bad offset found", e6);
            }
        }
        if (i5 != 3) {
            return;
        }
        int i9 = (oneByte >> 2) + 1;
        if (i9 < 0) {
            throw new IOException("Illegal block with a negative match length found");
        }
        this.uncompressedBytesRemaining -= i9;
        try {
            startBackReference(((int) ByteUtils.fromLittleEndian(this.supplier, 4)) & Integer.MAX_VALUE, i9);
            this.state = State.IN_BACK_REFERENCE;
        } catch (IllegalArgumentException e7) {
            throw new IOException("Illegal block with bad offset found", e7);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int readLiteralLength(int i5) throws IOException {
        long jFromLittleEndian;
        int oneByte = i5 >> 2;
        switch (oneByte) {
            case 60:
                oneByte = readOneByte();
                if (oneByte == -1) {
                    throw new IOException("Premature end of stream reading literal length");
                }
                return oneByte + 1;
            case 61:
                jFromLittleEndian = ByteUtils.fromLittleEndian(this.supplier, 2);
                break;
            case 62:
                jFromLittleEndian = ByteUtils.fromLittleEndian(this.supplier, 3);
                break;
            case 63:
                jFromLittleEndian = ByteUtils.fromLittleEndian(this.supplier, 4);
                break;
            default:
                return oneByte + 1;
        }
        oneByte = (int) jFromLittleEndian;
        return oneByte + 1;
    }

    private long readSize() throws IOException {
        int i5 = 0;
        long j6 = 0;
        while (true) {
            int oneByte = readOneByte();
            if (oneByte == -1) {
                throw new IOException("Premature end of stream reading size");
            }
            int i6 = i5 + 1;
            j6 |= (long) ((oneByte & 127) << (i5 * 7));
            if ((oneByte & 128) == 0) {
                return j6;
            }
            i5 = i6;
        }
    }

    @Override // org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream
    public int getSize() {
        return this.size;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (this.endReached) {
            return -1;
        }
        int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[this.state.ordinal()];
        if (i7 == 1) {
            fill();
            return read(bArr, i5, i6);
        }
        if (i7 == 2) {
            int literal = readLiteral(bArr, i5, i6);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            return literal > 0 ? literal : read(bArr, i5, i6);
        }
        if (i7 != 3) {
            throw new IOException("Unknown stream state " + this.state);
        }
        int backReference = readBackReference(bArr, i5, i6);
        if (!hasMoreDataInBlock()) {
            this.state = State.NO_BLOCK;
        }
        return backReference > 0 ? backReference : read(bArr, i5, i6);
    }

    public SnappyCompressorInputStream(InputStream inputStream, int i5) {
        super(inputStream, i5);
        this.state = State.NO_BLOCK;
        int size = (int) readSize();
        this.size = size;
        this.uncompressedBytesRemaining = size;
    }
}
