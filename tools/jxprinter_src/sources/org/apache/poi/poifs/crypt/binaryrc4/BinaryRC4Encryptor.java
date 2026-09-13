package org.apache.poi.poifs.crypt.binaryrc4;

import M1.b;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherOutputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.DataSpaceMapUtils;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.RandomSingleton;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BinaryRC4Encryptor extends Encryptor {
    private int chunkSize;

    public BinaryRC4Encryptor() {
        this.chunkSize = 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createEncryptionInfoEntry$0(EncryptionInfo encryptionInfo, BinaryRC4EncryptionHeader binaryRC4EncryptionHeader, BinaryRC4EncryptionVerifier binaryRC4EncryptionVerifier, LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMajor());
        littleEndianByteArrayOutputStream.writeShort(encryptionInfo.getVersionMinor());
        binaryRC4EncryptionHeader.write(littleEndianByteArrayOutputStream);
        binaryRC4EncryptionVerifier.write(littleEndianByteArrayOutputStream);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str) {
        SecureRandom randomSingleton = RandomSingleton.getInstance();
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        randomSingleton.nextBytes(bArr);
        randomSingleton.nextBytes(bArr2);
        confirmPassword(str, null, null, bArr2, bArr, null);
    }

    public void createEncryptionInfoEntry(DirectoryNode directoryNode) {
        DataSpaceMapUtils.addDefaultDataSpace(directoryNode);
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        DataSpaceMapUtils.createEncryptionEntry(directoryNode, EncryptionInfo.ENCRYPTION_INFO_ENTRY, new b(encryptionInfo, 4, (BinaryRC4EncryptionHeader) encryptionInfo.getHeader(), (BinaryRC4EncryptionVerifier) encryptionInfo.getVerifier()));
    }

    public int getKeySizeInBytes() {
        return getEncryptionInfo().getHeader().getKeySize() / 8;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void setChunkSize(int i5) {
        this.chunkSize = i5;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BinaryRC4CipherOutputStream extends ChunkedCipherOutputStream {
        public BinaryRC4CipherOutputStream(OutputStream outputStream) {
            super(outputStream, BinaryRC4Encryptor.this.chunkSize);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void createEncryptionInfoEntry(DirectoryNode directoryNode, File file) {
            BinaryRC4Encryptor.this.createEncryptionInfoEntry(directoryNode);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            writeChunk(false);
            super.flush();
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5, boolean z6) {
            return BinaryRC4Decryptor.initCipherForBlock(cipher, i5, BinaryRC4Encryptor.this.getEncryptionInfo(), BinaryRC4Encryptor.this.getSecretKey(), 1);
        }

        public BinaryRC4CipherOutputStream(DirectoryNode directoryNode) {
            super(directoryNode, BinaryRC4Encryptor.this.chunkSize);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherOutputStream
        public void calculateChecksum(File file, int i5) {
        }
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public BinaryRC4Encryptor copy() {
        return new BinaryRC4Encryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public OutputStream getDataStream(DirectoryNode directoryNode) {
        return new BinaryRC4CipherOutputStream(directoryNode);
    }

    public BinaryRC4Encryptor(BinaryRC4Encryptor binaryRC4Encryptor) {
        super(binaryRC4Encryptor);
        this.chunkSize = 512;
        this.chunkSize = binaryRC4Encryptor.chunkSize;
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public BinaryRC4CipherOutputStream getDataStream(OutputStream outputStream, int i5) {
        return new BinaryRC4CipherOutputStream(outputStream);
    }

    @Override // org.apache.poi.poifs.crypt.Encryptor
    public void confirmPassword(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        BinaryRC4EncryptionVerifier binaryRC4EncryptionVerifier = (BinaryRC4EncryptionVerifier) getEncryptionInfo().getVerifier();
        binaryRC4EncryptionVerifier.setSalt(bArr4);
        SecretKey secretKeyGenerateSecretKey = BinaryRC4Decryptor.generateSecretKey(str, binaryRC4EncryptionVerifier);
        setSecretKey(secretKeyGenerateSecretKey);
        try {
            Cipher cipherInitCipherForBlock = BinaryRC4Decryptor.initCipherForBlock(null, 0, getEncryptionInfo(), secretKeyGenerateSecretKey, 1);
            byte[] bArr6 = new byte[16];
            cipherInitCipherForBlock.update(bArr3, 0, 16, bArr6);
            binaryRC4EncryptionVerifier.setEncryptedVerifier(bArr6);
            binaryRC4EncryptionVerifier.setEncryptedVerifierHash(cipherInitCipherForBlock.doFinal(CryptoFunctions.getMessageDigest(binaryRC4EncryptionVerifier.getHashAlgorithm()).digest(bArr3)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException("Password confirmation failed", e);
        }
    }
}
