package org.apache.poi.poifs.crypt.xor;

import V2.f;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XOREncryptor extends Encryptor {
    public XOREncryptor() {
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        int iCreateXorKey1 = CryptoFunctions.createXorKey1(str);
        int iCreateXorVerifier1 = CryptoFunctions.createXorVerifier1(str);
        byte[] bArrCreateXorArray1 = CryptoFunctions.createXorArray1(str);
        byte[] bArr = new byte[2];
        XOREncryptionVerifier xOREncryptionVerifier = (XOREncryptionVerifier) getEncryptionInfo().getVerifier();
        LittleEndian.putUShort(bArr, 0, iCreateXorKey1);
        xOREncryptionVerifier.setEncryptedKey(bArr);
        LittleEndian.putUShort(bArr, 0, iCreateXorVerifier1);
        xOREncryptionVerifier.setEncryptedVerifier(bArr);
        setSecretKey(new SecretKeySpec(bArrCreateXorArray1, "XOR"));
    }

    public int getKeySizeInBytes() {
        return -1;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class XORCipherOutputStream extends ChunkedCipherOutputStream {
        private int recordEnd;
        private int recordStart;

        public XORCipherOutputStream(OutputStream outputStream, int i5) {
            super(outputStream, -1);
        }

        private byte rotateLeft(byte b, int i5) {
            int i6 = b & 255;
            return (byte) ((i6 >>> (8 - i5)) | (i6 << i5));
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) {
            throw new EncryptedDocumentException("createEncryptionInfoEntry not supported");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            setNextRecordSize(0, true);
            super.flush();
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5, boolean z6) {
            return XORDecryptor.initCipherForBlock(cipher, i5, XOREncryptor.this.getEncryptionInfo(), XOREncryptor.this.getSecretKey(), 1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public int invokeCipher(int i5, boolean z6) {
            if (i5 == 0) {
                return 0;
            }
            int iMax = Math.max(i5 - (this.recordEnd - this.recordStart), 0);
            f plainByteFlags = getPlainByteFlags();
            byte[] encoded = XOREncryptor.this.getEncryptionInfo().getEncryptor().getSecretKey().getEncoded();
            byte[] chunk = getChunk();
            plainByteFlags.k();
            byte[] bArr = plainByteFlags.d.b == 0 ? null : (byte[]) chunk.clone();
            int i6 = (iMax - this.recordStart) + this.recordEnd;
            int i7 = iMax;
            while (i7 < i5) {
                chunk[i7] = rotateLeft((byte) (encoded[i6 & 15] ^ chunk[i7]), 5);
                i7++;
                i6++;
            }
            if (bArr != null) {
                for (int iH = plainByteFlags.h(iMax); iH >= 0 && iH < i5; iH = plainByteFlags.h(iH + 1)) {
                    chunk[iH] = bArr[iH];
                }
            }
            return i5;
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void setNextRecordSize(int i5, boolean z6) {
            if (this.recordEnd > 0 && !z6) {
                invokeCipher((int) getPos(), true);
            }
            int totalPos = ((int) getTotalPos()) + 4;
            this.recordStart = totalPos;
            this.recordEnd = totalPos + i5;
        }

        public XORCipherOutputStream(DirectoryNode directoryNode) {
            super(directoryNode, -1);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void calculateChecksum(File file, int i5) {
        }
    }

    public XOREncryptor(XOREncryptor xOREncryptor) {
        super(xOREncryptor);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public XOREncryptor copy() {
        return new XOREncryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) {
        return new XORCipherOutputStream(directoryNode);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public XORCipherOutputStream getDataStream(OutputStream outputStream, int i5) {
        return new XORCipherOutputStream(outputStream, i5);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        confirmPassword(str);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void setChunkSize(int i5) {
    }
}
