package org.apache.poi.poifs.crypt;

import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class ChunkedCipherInputStream extends LittleEndianInputStream {
    private final byte[] chunk;
    private final int chunkBits;
    private boolean chunkIsValid;
    private final int chunkSize;
    private final Cipher cipher;
    private int lastIndex;
    private final byte[] plain;
    private long pos;
    private final long size;

    public ChunkedCipherInputStream(InputStream inputStream, long j6, int i5) {
        this(inputStream, j6, i5, 0);
    }

    private void nextChunk() throws IOException {
        int i5;
        if (this.chunkSize != -1) {
            int i6 = (int) (this.pos >> this.chunkBits);
            initCipherForBlock(this.cipher, i6);
            int i7 = this.lastIndex;
            if (i7 != i6) {
                long j6 = (((long) i6) - ((long) i7)) << this.chunkBits;
                if (super.skip(j6) < j6) {
                    throw new EOFException("buffer underrun");
                }
            }
            this.lastIndex = i6 + 1;
        }
        int iMin = (int) Math.min(this.size, this.chunk.length);
        int iMax = 0;
        do {
            i5 = super.read(this.plain, iMax, iMin - iMax);
            iMax += Math.max(0, i5);
            if (i5 == -1) {
                break;
            }
        } while (iMax < iMin);
        if (i5 == -1) {
            long j7 = this.pos + ((long) iMax);
            long j8 = this.size;
            if (j7 < j8 && j8 < 2147483647L) {
                throw new EOFException("buffer underrun");
            }
        }
        System.arraycopy(this.plain, 0, this.chunk, 0, iMax);
        invokeCipher(iMax, iMax == this.chunkSize);
    }

    private int remainingBytes() {
        return (int) (this.size - this.pos);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream, org.apache.poi.util.LittleEndianInput
    public int available() {
        return remainingBytes();
    }

    public byte[] getChunk() {
        return this.chunk;
    }

    public int getChunkMask() {
        return this.chunk.length - 1;
    }

    public byte[] getPlain() {
        return this.plain;
    }

    public long getPos() {
        return this.pos;
    }

    public final Cipher initCipherForBlock(int i5) throws GeneralSecurityException {
        if (this.chunkSize != -1) {
            throw new GeneralSecurityException("the cipher block can only be set for streaming encryption, e.g. CryptoAPI...");
        }
        this.chunkIsValid = false;
        return initCipherForBlock(this.cipher, i5);
    }

    public abstract Cipher initCipherForBlock(Cipher cipher, int i5);

    public int invokeCipher(int i5, boolean z6) {
        if (z6) {
            Cipher cipher = this.cipher;
            byte[] bArr = this.chunk;
            return cipher.doFinal(bArr, 0, i5, bArr);
        }
        Cipher cipher2 = this.cipher;
        byte[] bArr2 = this.chunk;
        return cipher2.update(bArr2, 0, i5, bArr2);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        byte[] bArr = {0};
        if (read(bArr) == 1) {
            return bArr[0] & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, org.apache.poi.util.LittleEndianInput
    public void readPlain(byte[] bArr, int i5, int i6) {
        if (i6 <= 0) {
            return;
        }
        int iMax = 0;
        do {
            try {
                int i7 = read(bArr, i5, i6, true);
                iMax += Math.max(0, i7);
                if (i7 <= -1) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (iMax < i6);
        if (iMax >= i6) {
        } else {
            throw new EOFException("buffer underrun");
        }
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) {
        long j7 = this.pos;
        long jMin = Math.min(remainingBytes(), j6);
        if (((j7 ^ (this.pos + jMin)) & ((long) (~getChunkMask()))) != 0) {
            this.chunkIsValid = false;
        }
        this.pos += jMin;
        return jMin;
    }

    public ChunkedCipherInputStream(InputStream inputStream, long j6, int i5, int i6) {
        super(inputStream);
        this.size = j6;
        this.pos = i6;
        this.chunkSize = i5;
        long j7 = i5 == -1 ? 4096 : i5;
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(j7, CryptoFunctions.MAX_RECORD_LENGTH);
        this.chunk = bArrSafelyAllocate;
        this.plain = IOUtils.safelyAllocate(j7, CryptoFunctions.MAX_RECORD_LENGTH);
        int iBitCount = Integer.bitCount(bArrSafelyAllocate.length - 1);
        this.chunkBits = iBitCount;
        int i7 = (int) (this.pos >> iBitCount);
        this.lastIndex = i7;
        this.cipher = initCipherForBlock(null, i7);
    }

    @Override // org.apache.poi.util.LittleEndianInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        return read(bArr, i5, i6, false);
    }

    private int read(byte[] bArr, int i5, int i6, boolean z6) throws IOException {
        if (remainingBytes() <= 0) {
            return -1;
        }
        int chunkMask = getChunkMask();
        int i7 = 0;
        while (i6 > 0) {
            if (!this.chunkIsValid) {
                try {
                    nextChunk();
                    this.chunkIsValid = true;
                } catch (GeneralSecurityException e) {
                    throw new EncryptedDocumentException(e.getMessage(), e);
                }
            }
            long j6 = chunkMask;
            int length = (int) (((long) this.chunk.length) - (this.pos & j6));
            int iRemainingBytes = remainingBytes();
            if (iRemainingBytes == 0) {
                break;
            }
            int iMin = Math.min(iRemainingBytes, Math.min(length, i6));
            System.arraycopy(z6 ? this.plain : this.chunk, (int) (this.pos & j6), bArr, i5, iMin);
            i5 += iMin;
            i6 -= iMin;
            long j7 = this.pos + ((long) iMin);
            this.pos = j7;
            if ((j7 & j6) == 0) {
                this.chunkIsValid = false;
            }
            i7 += iMin;
        }
        return i7;
    }

    public void setNextRecordSize(int i5) {
    }
}
