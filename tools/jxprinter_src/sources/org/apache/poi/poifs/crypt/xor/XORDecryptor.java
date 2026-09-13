package org.apache.poi.poifs.crypt.xor;

import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XORDecryptor extends Decryptor {
    private int chunkSize;
    private long length;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class XORCipherInputStream extends ChunkedCipherInputStream {
        private final int initialOffset;
        private int recordEnd;
        private int recordStart;

        public XORCipherInputStream(InputStream inputStream, int i5) {
            super(inputStream, 2147483647L, XORDecryptor.this.chunkSize);
            this.initialOffset = i5;
        }

        private byte rotateLeft(byte b, int i5) {
            int i6 = b & 255;
            return (byte) ((i6 >>> (8 - i5)) | (i6 << i5));
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5) {
            return XORDecryptor.this.initCipherForBlock(cipher, i5);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public int invokeCipher(int i5, boolean z6) {
            int pos = (int) getPos();
            byte[] encoded = XORDecryptor.this.getEncryptionInfo().getDecryptor().getSecretKey().getEncoded();
            byte[] chunk = getChunk();
            byte[] plain = getPlain();
            int chunkMask = getChunkMask() & pos;
            int i6 = (pos - this.recordStart) + this.initialOffset + this.recordEnd;
            for (int i7 = 0; pos + i7 < this.recordEnd && i7 < i5; i7++) {
                int i8 = chunkMask + i7;
                chunk[i8] = (byte) (rotateLeft(plain[i8], 3) ^ encoded[(i6 + i7) & 15]);
            }
            return i5;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public void setNextRecordSize(int i5) {
            int pos = (int) getPos();
            byte[] chunk = getChunk();
            int chunkMask = getChunkMask();
            this.recordStart = pos;
            this.recordEnd = pos + i5;
            invokeCipher(Math.min(i5, chunk.length - (pos & chunkMask)), true);
        }
    }

    public XORDecryptor() {
        this.length = -1L;
        this.chunkSize = 512;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j6 = this.length;
        if (j6 != -1) {
            return j6;
        }
        throw new IllegalStateException("Decryptor.getDataStream() was not called");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public Cipher initCipherForBlock(Cipher cipher, int i5) {
        return null;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int i5) {
        this.chunkSize = i5;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        XOREncryptionVerifier xOREncryptionVerifier = (XOREncryptionVerifier) getEncryptionInfo().getVerifier();
        int uShort = LittleEndian.getUShort(xOREncryptionVerifier.getEncryptedKey());
        int uShort2 = LittleEndian.getUShort(xOREncryptionVerifier.getEncryptedVerifier());
        int iCreateXorKey1 = CryptoFunctions.createXorKey1(str);
        int iCreateXorVerifier1 = CryptoFunctions.createXorVerifier1(str);
        if (uShort != iCreateXorKey1 || uShort2 != iCreateXorVerifier1) {
            return false;
        }
        setSecretKey(new SecretKeySpec(CryptoFunctions.createXorArray1(str), "XOR"));
        return true;
    }

    public static Cipher initCipherForBlock(Cipher cipher, int i5, EncryptionInfo encryptionInfo, SecretKey secretKey, int i6) {
        return null;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public XORDecryptor copy() {
        return new XORDecryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) {
        throw new EncryptedDocumentException("not supported");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream inputStream, int i5, int i6) {
        return new XORCipherInputStream(inputStream, i6);
    }

    public XORDecryptor(XORDecryptor xORDecryptor) {
        super(xORDecryptor);
        this.length = -1L;
        this.chunkSize = 512;
        this.length = xORDecryptor.length;
        this.chunkSize = xORDecryptor.chunkSize;
    }
}
