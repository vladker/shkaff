package org.apache.poi.poifs.crypt.standard;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardEncryptionInfoBuilder implements EncryptionInfoBuilder {
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) {
        littleEndianInput.readInt();
        StandardEncryptionHeader standardEncryptionHeader = new StandardEncryptionHeader(littleEndianInput);
        encryptionInfo.setHeader(standardEncryptionHeader);
        encryptionInfo.setVerifier(new StandardEncryptionVerifier(littleEndianInput, standardEncryptionHeader));
        if (encryptionInfo.getVersionMinor() == 2) {
            if (encryptionInfo.getVersionMajor() == 3 || encryptionInfo.getVersionMajor() == 4) {
                Decryptor standardDecryptor = new StandardDecryptor();
                standardDecryptor.setEncryptionInfo(encryptionInfo);
                encryptionInfo.setDecryptor(standardDecryptor);
            }
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.aes128;
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        if (cipherAlgorithm2 != CipherAlgorithm.aes128 && cipherAlgorithm2 != CipherAlgorithm.aes192 && cipherAlgorithm2 != CipherAlgorithm.aes256) {
            throw new EncryptedDocumentException("Standard encryption only supports AES128/192/256.");
        }
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        if (hashAlgorithm2 == HashAlgorithm.sha1) {
            if (chainingMode == null) {
                chainingMode = ChainingMode.ecb;
            }
            ChainingMode chainingMode2 = chainingMode;
            if (chainingMode2 == ChainingMode.ecb) {
                if (i5 == -1) {
                    i5 = cipherAlgorithm2.defaultKeySize;
                }
                int i7 = i5;
                if (i6 == -1) {
                    i6 = cipherAlgorithm2.blockSize;
                }
                int i8 = i6;
                boolean z6 = false;
                for (int i9 : cipherAlgorithm2.allowedKeySize) {
                    z6 |= i9 == i7;
                }
                if (z6) {
                    encryptionInfo.setHeader(new StandardEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i7, i8, chainingMode2));
                    encryptionInfo.setVerifier(new StandardEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i7, i8, chainingMode2));
                    StandardDecryptor standardDecryptor = new StandardDecryptor();
                    standardDecryptor.setEncryptionInfo(encryptionInfo);
                    encryptionInfo.setDecryptor(standardDecryptor);
                    StandardEncryptor standardEncryptor = new StandardEncryptor();
                    standardEncryptor.setEncryptionInfo(encryptionInfo);
                    encryptionInfo.setEncryptor(standardEncryptor);
                    return;
                }
                throw new EncryptedDocumentException("KeySize " + i7 + " not allowed for Cipher " + cipherAlgorithm2);
            }
            throw new EncryptedDocumentException("Standard encryption only supports ECB chaining.");
        }
        throw new EncryptedDocumentException("Standard encryption only supports SHA-1.");
    }
}
