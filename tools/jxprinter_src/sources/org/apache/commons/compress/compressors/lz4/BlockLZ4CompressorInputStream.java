package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BlockLZ4CompressorInputStream extends AbstractLZ77CompressorInputStream {
    static final int BACK_REFERENCE_SIZE_MASK = 15;
    static final int LITERAL_SIZE_MASK = 240;
    static final int SIZE_BITS = 4;
    static final int WINDOW_SIZE = 65536;
    private int nextBackReferenceSize;
    private State state;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State = iArr;
            try {
                iArr[State.EOF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.NO_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.IN_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.LOOKING_FOR_BACK_REFERENCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[State.IN_BACK_REFERENCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum State {
        NO_BLOCK,
        IN_LITERAL,
        LOOKING_FOR_BACK_REFERENCE,
        IN_BACK_REFERENCE,
        EOF
    }

    public BlockLZ4CompressorInputStream(InputStream inputStream) {
        super(inputStream, 65536);
        this.state = State.NO_BLOCK;
    }

    private boolean initializeBackReference() throws IOException {
        try {
            int iFromLittleEndian = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
            int i5 = this.nextBackReferenceSize;
            long sizeBytes = i5;
            if (i5 == 15) {
                sizeBytes += readSizeBytes();
            }
            if (sizeBytes < 0) {
                throw new IOException("Illegal block with a negative match length found");
            }
            try {
                startBackReference(iFromLittleEndian, sizeBytes + 4);
                this.state = State.IN_BACK_REFERENCE;
                return true;
            } catch (IllegalArgumentException e) {
                throw new IOException("Illegal block with bad offset found", e);
            }
        } catch (IOException e6) {
            if (this.nextBackReferenceSize == 0) {
                return false;
            }
            throw e6;
        }
    }

    private long readSizeBytes() throws IOException {
        int oneByte;
        long j6 = 0;
        do {
            oneByte = readOneByte();
            if (oneByte == -1) {
                throw new IOException("Premature end of stream while parsing length");
            }
            j6 += (long) oneByte;
        } while (oneByte == 255);
        return j6;
    }

    private void readSizes() throws IOException {
        int oneByte = readOneByte();
        if (oneByte == -1) {
            throw new IOException("Premature end of stream while looking for next block");
        }
        this.nextBackReferenceSize = oneByte & 15;
        long sizeBytes = (oneByte & 240) >> 4;
        if (sizeBytes == 15) {
            sizeBytes += readSizeBytes();
        }
        if (sizeBytes < 0) {
            throw new IOException("Illegal block with a negative literal size found");
        }
        startLiteral(sizeBytes);
        this.state = State.IN_LITERAL;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i6 == 0) {
            return 0;
        }
        int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[this.state.ordinal()];
        if (i7 == 1) {
            return -1;
        }
        if (i7 == 2) {
            readSizes();
        } else if (i7 != 3) {
            if (i7 != 4) {
                if (i7 != 5) {
                    throw new IOException("Unknown stream state " + this.state);
                }
            } else if (!initializeBackReference()) {
                this.state = State.EOF;
                return -1;
            }
            int backReference = readBackReference(bArr, i5, i6);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            return backReference > 0 ? backReference : read(bArr, i5, i6);
        }
        int literal = readLiteral(bArr, i5, i6);
        if (!hasMoreDataInBlock()) {
            this.state = State.LOOKING_FOR_BACK_REFERENCE;
        }
        return literal > 0 ? literal : read(bArr, i5, i6);
    }
}
