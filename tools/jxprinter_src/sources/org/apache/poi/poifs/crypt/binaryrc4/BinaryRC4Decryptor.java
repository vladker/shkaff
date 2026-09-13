package org.apache.poi.poifs.crypt.binaryrc4;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BinaryRC4Decryptor extends Decryptor {
    private int chunkSize;
    private long length;

    public BinaryRC4Decryptor() {
        this.length = -1L;
        this.chunkSize = 512;
    }

    public static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier) {
        if (str.length() > 255) {
            str = str.substring(0, 255);
        }
        MessageDigest messageDigest = CryptoFunctions.getMessageDigest(encryptionVerifier.getHashAlgorithm());
        byte[] bArrDigest = messageDigest.digest(StringUtil.getToUnicodeLE(str));
        byte[] salt = encryptionVerifier.getSalt();
        messageDigest.reset();
        for (int i5 = 0; i5 < 16; i5++) {
            messageDigest.update(bArrDigest, 0, 5);
            messageDigest.update(salt);
        }
        return new SecretKeySpec(Arrays.copyOf(messageDigest.digest(), 5), encryptionVerifier.getCipherAlgorithm().jceId);
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
        return initCipherForBlock(cipher, i5, getEncryptionInfo(), getSecretKey(), 2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public void setChunkSize(int i5) {
        this.chunkSize = i5;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        SecretKey secretKeyGenerateSecretKey = generateSecretKey(str, verifier);
        try {
            Cipher cipherInitCipherForBlock = initCipherForBlock(null, 0, getEncryptionInfo(), secretKeyGenerateSecretKey, 2);
            byte[] encryptedVerifier = verifier.getEncryptedVerifier();
            byte[] bArr = new byte[encryptedVerifier.length];
            cipherInitCipherForBlock.update(encryptedVerifier, 0, encryptedVerifier.length, bArr);
            setVerifier(bArr);
            if (!Arrays.equals(CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArr), cipherInitCipherForBlock.doFinal(verifier.getEncryptedVerifierHash()))) {
                return false;
            }
            setSecretKey(secretKeyGenerateSecretKey);
            return true;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BinaryRC4CipherInputStream extends ChunkedCipherInputStream {
        public BinaryRC4CipherInputStream(DocumentInputStream documentInputStream, long j6) {
            super(documentInputStream, j6, BinaryRC4Decryptor.this.chunkSize);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5) {
            return BinaryRC4Decryptor.this.initCipherForBlock(cipher, i5);
        }

        public BinaryRC4CipherInputStream(InputStream inputStream, int i5, int i6) {
            super(inputStream, i5, BinaryRC4Decryptor.this.chunkSize, i6);
        }
    }

    public static Cipher initCipherForBlock(Cipher cipher, int i5, EncryptionInfo encryptionInfo, SecretKey secretKey, int i6) {
        HashAlgorithm hashAlgorithm = encryptionInfo.getVerifier().getHashAlgorithm();
        byte[] bArr = new byte[4];
        LittleEndian.putUInt(bArr, 0, i5);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.generateKey(secretKey.getEncoded(), hashAlgorithm, bArr, 16), secretKey.getAlgorithm());
        if (cipher == null) {
            return CryptoFunctions.getCipher(secretKeySpec, encryptionInfo.getHeader().getCipherAlgorithm(), null, null, i6);
        }
        cipher.init(i6, secretKeySpec);
        return cipher;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public BinaryRC4Decryptor copy() {
        return new BinaryRC4Decryptor(this);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public ChunkedCipherInputStream getDataStream(DirectoryNode directoryNode) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this.length = documentInputStreamCreateDocumentInputStream.readLong();
        return new BinaryRC4CipherInputStream(documentInputStreamCreateDocumentInputStream, this.length);
    }

    public BinaryRC4Decryptor(BinaryRC4Decryptor binaryRC4Decryptor) {
        super(binaryRC4Decryptor);
        this.length = -1L;
        this.chunkSize = 512;
        this.length = binaryRC4Decryptor.length;
        this.chunkSize = binaryRC4Decryptor.chunkSize;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(InputStream inputStream, int i5, int i6) {
        return new BinaryRC4CipherInputStream(inputStream, i5, i6);
    }
}
