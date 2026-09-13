package org.apache.poi.poifs.crypt.standard;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardDecryptor extends Decryptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long _length;

    public StandardDecryptor() {
        this._length = -1L;
    }

    public static byte[] fillAndXor(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[64];
        Arrays.fill(bArr2, b);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr2[i5] = (byte) (bArr2[i5] ^ bArr[i5]);
        }
        return CryptoFunctions.getMessageDigest(HashAlgorithm.sha1).digest(bArr2);
    }

    public static SecretKey generateSecretKey(String str, EncryptionVerifier encryptionVerifier, int i5) {
        HashAlgorithm hashAlgorithm = encryptionVerifier.getHashAlgorithm();
        byte[] bArrHashPassword = CryptoFunctions.hashPassword(str, hashAlgorithm, encryptionVerifier.getSalt(), encryptionVerifier.getSpinCount());
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, 0);
        byte[] bArrGenerateKey = CryptoFunctions.generateKey(bArrHashPassword, hashAlgorithm, bArr, hashAlgorithm.hashSize);
        byte[] bArrFillAndXor = fillAndXor(bArrGenerateKey, TarConstants.LF_FIFO);
        byte[] bArrFillAndXor2 = fillAndXor(bArrGenerateKey, (byte) 92);
        byte[] bArr2 = new byte[bArrFillAndXor.length + bArrFillAndXor2.length];
        System.arraycopy(bArrFillAndXor, 0, bArr2, 0, bArrFillAndXor.length);
        System.arraycopy(bArrFillAndXor2, 0, bArr2, bArrFillAndXor.length, bArrFillAndXor2.length);
        return new SecretKeySpec(Arrays.copyOf(bArr2, i5), encryptionVerifier.getCipherAlgorithm().jceId);
    }

    private Cipher getCipher(SecretKey secretKey) {
        EncryptionHeader header = getEncryptionInfo().getHeader();
        return CryptoFunctions.getCipher(secretKey, header.getCipherAlgorithm(), header.getChainingMode(), null, 2);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public InputStream getDataStream(DirectoryNode directoryNode) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(Decryptor.DEFAULT_POIFS_ENTRY);
        this._length = documentInputStreamCreateDocumentInputStream.readLong();
        if (getSecretKey() == null) {
            verifyPassword(null);
        }
        long j6 = getEncryptionInfo().getHeader().getCipherAlgorithm().blockSize;
        return new BoundedInputStream(new CipherInputStream(new BoundedInputStream(documentInputStreamCreateDocumentInputStream, ((this._length / j6) + 1) * j6), getCipher(getSecretKey())), this._length);
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public long getLength() {
        long j6 = this._length;
        if (j6 != -1) {
            return j6;
        }
        throw new IllegalStateException("Decryptor.getDataStream() was not called");
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public boolean verifyPassword(String str) {
        EncryptionVerifier verifier = getEncryptionInfo().getVerifier();
        SecretKey secretKeyGenerateSecretKey = generateSecretKey(str, verifier, getKeySizeInBytes());
        Cipher cipher = getCipher(secretKeyGenerateSecretKey);
        try {
            byte[] bArrDoFinal = cipher.doFinal(verifier.getEncryptedVerifier());
            setVerifier(bArrDoFinal);
            byte[] bArrDigest = CryptoFunctions.getMessageDigest(verifier.getHashAlgorithm()).digest(bArrDoFinal);
            if (!Arrays.equals(bArrDigest, Arrays.copyOf(cipher.doFinal(verifier.getEncryptedVerifierHash()), bArrDigest.length))) {
                return false;
            }
            setSecretKey(secretKeyGenerateSecretKey);
            return true;
        } catch (GeneralSecurityException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    @Override // org.apache.poi.poifs.crypt.Decryptor
    public StandardDecryptor copy() {
        return new StandardDecryptor(this);
    }

    public StandardDecryptor(StandardDecryptor standardDecryptor) {
        super(standardDecryptor);
        this._length = -1L;
        this._length = standardDecryptor._length;
    }
}
