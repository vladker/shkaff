package org.apache.poi.poifs.crypt.agile;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.ChunkedCipherInputStream;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgileDecryptor extends Decryptor {
    private long _length;
    static final byte[] kVerifierInputBlock = longToBytes(-96877461722390919L);
    static final byte[] kHashedVerifierBlock = longToBytes(-2906493647876705202L);
    static final byte[] kCryptoKeyBlock = longToBytes(1472127217842311382L);
    static final byte[] kIntegrityKeyBlock = longToBytes(6895764199477731830L);
    static final byte[] kIntegrityValueBlock = longToBytes(-6888397455483960269L);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AgileCipherInputStream extends ChunkedCipherInputStream {
        public AgileCipherInputStream(DocumentInputStream documentInputStream, long j6) {
            super(documentInputStream, j6, 4096);
        }

        @Override // org.apache.poi.poifs.crypt.ChunkedCipherInputStream
        public Cipher initCipherForBlock(Cipher cipher, int i5) {
            return AgileDecryptor.initCipherForBlock(cipher, i5, false, AgileDecryptor.this.getEncryptionInfo(), AgileDecryptor.this.getSecretKey(), 2);
        }
    }

    public AgileDecryptor() {
        this._length = -1L;
    }

    public static int getNextBlockSize(int i5, int i6) {
        return ((int) Math.ceil(((double) i5) / ((double) i6))) * i6;
    }

    public static byte[] hashInput(AgileEncryptionVerifier agileEncryptionVerifier, byte[] bArr, byte[] bArr2, byte[] bArr3, int i5) {
        CipherAlgorithm cipherAlgorithm = agileEncryptionVerifier.getCipherAlgorithm();
        ChainingMode chainingMode = agileEncryptionVerifier.getChainingMode();
        int keySize = agileEncryptionVerifier.getKeySize() / 8;
        int blockSize = agileEncryptionVerifier.getBlockSize();
        HashAlgorithm hashAlgorithm = agileEncryptionVerifier.getHashAlgorithm();
        Cipher cipher = CryptoFunctions.getCipher(new SecretKeySpec(CryptoFunctions.generateKey(bArr, hashAlgorithm, bArr2, keySize), cipherAlgorithm.jceId), cipherAlgorithm, chainingMode, CryptoFunctions.generateIv(hashAlgorithm, agileEncryptionVerifier.getSalt(), null, blockSize), i5);
        if (bArr3 == null) {
            throw new EncryptedDocumentException("Cannot has input without inputKey");
        }
        try {
            return cipher.doFinal(CryptoFunctions.getBlock0(bArr3, getNextBlockSize(bArr3.length, blockSize)));
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public static Cipher initCipherForBlock(Cipher cipher, int i5, boolean z6, EncryptionInfo encryptionInfo, SecretKey secretKey, int i6) throws InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKey secretKey2;
        int i7;
        EncryptionHeader header = encryptionInfo.getHeader();
        String str = z6 ? "PKCS5Padding" : "NoPadding";
        if (cipher == null || !cipher.getAlgorithm().endsWith(str)) {
            secretKey2 = secretKey;
            i7 = i6;
            cipher = CryptoFunctions.getCipher(secretKey2, header.getCipherAlgorithm(), header.getChainingMode(), header.getKeySalt(), i7, str);
        } else {
            secretKey2 = secretKey;
            i7 = i6;
        }
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, i5);
        byte[] bArrGenerateIv = CryptoFunctions.generateIv(header.getHashAlgorithm(), header.getKeySalt(), bArr, header.getBlockSize());
        cipher.init(i7, secretKey2, header.getCipherAlgorithm() == CipherAlgorithm.rc2 ? new RC2ParameterSpec(secretKey2.getEncoded().length * 8, bArrGenerateIv) : new IvParameterSpec(bArrGenerateIv));
        return cipher;
    }

    private static byte[] longToBytes(long j6) {
        return ByteBuffer.allocate(8).putLong(j6).array();
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this._length = documentInputStreamCreateDocumentInputStream.readLong();
        return new AgileCipherInputStream(documentInputStreamCreateDocumentInputStream, this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j6 = this._length;
        if (j6 != -1) {
            return j6;
        }
        throw new IllegalStateException("EcmaDecryptor.getDataStream() was not called");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        AgileEncryptionVerifier agileEncryptionVerifier = (AgileEncryptionVerifier) getEncryptionInfo().getVerifier();
        AgileEncryptionHeader agileEncryptionHeader = (AgileEncryptionHeader) getEncryptionInfo().getHeader();
        int blockSize = agileEncryptionHeader.getBlockSize();
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, agileEncryptionVerifier.getHashAlgorithm(), agileEncryptionVerifier.getSalt(), agileEncryptionVerifier.getSpinCount());
        byte[] bArrHashInput = hashInput(agileEncryptionVerifier, bArrHashPassword, kVerifierInputBlock, agileEncryptionVerifier.getEncryptedVerifier(), 2);
        setVerifier(bArrHashInput);
        byte[] bArrDigest = CryptoFunctions.getMessageDigest(agileEncryptionVerifier.getHashAlgorithm()).digest(bArrHashInput);
        byte[] block0 = CryptoFunctions.getBlock0(hashInput(agileEncryptionVerifier, bArrHashPassword, kHashedVerifierBlock, agileEncryptionVerifier.getEncryptedVerifierHash(), 2), agileEncryptionVerifier.getHashAlgorithm().hashSize);
        SecretKeySpec secretKeySpec = new SecretKeySpec(CryptoFunctions.getBlock0(hashInput(agileEncryptionVerifier, bArrHashPassword, kCryptoKeyBlock, agileEncryptionVerifier.getEncryptedKey(), 2), agileEncryptionHeader.getKeySize() / 8), agileEncryptionHeader.getCipherAlgorithm().jceId);
        byte[] bArrGenerateIv = CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), kIntegrityKeyBlock, blockSize);
        CipherAlgorithm cipherAlgorithm = agileEncryptionHeader.getCipherAlgorithm();
        byte[] block1 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionHeader.getChainingMode(), bArrGenerateIv, 2).doFinal(agileEncryptionHeader.getEncryptedHmacKey()), agileEncryptionHeader.getHashAlgorithm().hashSize);
        byte[] block2 = CryptoFunctions.getBlock0(CryptoFunctions.getCipher(secretKeySpec, cipherAlgorithm, agileEncryptionVerifier.getChainingMode(), CryptoFunctions.generateIv(agileEncryptionHeader.getHashAlgorithm(), agileEncryptionHeader.getKeySalt(), kIntegrityValueBlock, blockSize), 2).doFinal(agileEncryptionHeader.getEncryptedHmacValue()), agileEncryptionHeader.getHashAlgorithm().hashSize);
        if (!Arrays.equals(block0, bArrDigest)) {
            return false;
        }
        setSecretKey(secretKeySpec);
        setIntegrityHmacKey(block1);
        setIntegrityHmacValue(block2);
        return true;
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public AgileDecryptor copy() {
        return new AgileDecryptor(this);
    }

    public AgileDecryptor(AgileDecryptor agileDecryptor) {
        super(agileDecryptor);
        this._length = -1L;
        this._length = agileDecryptor._length;
    }
}
