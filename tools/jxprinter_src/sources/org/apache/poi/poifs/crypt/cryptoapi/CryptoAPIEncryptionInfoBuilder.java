package org.apache.poi.poifs.crypt.cryptoapi;

import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CryptoAPIEncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) {
        littleEndianInput.readInt();
        CryptoAPIEncryptionHeader cryptoAPIEncryptionHeader = new CryptoAPIEncryptionHeader(littleEndianInput);
        encryptionInfo.setHeader(cryptoAPIEncryptionHeader);
        encryptionInfo.setVerifier(new CryptoAPIEncryptionVerifier(littleEndianInput, cryptoAPIEncryptionHeader));
        Decryptor cryptoAPIDecryptor = new CryptoAPIDecryptor();
        cryptoAPIDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(cryptoAPIDecryptor);
        Encryptor cryptoAPIEncryptor = new CryptoAPIEncryptor();
        cryptoAPIEncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(cryptoAPIEncryptor);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        if (cipherAlgorithm == null) {
            cipherAlgorithm = CipherAlgorithm.rc4;
        }
        CipherAlgorithm cipherAlgorithm2 = cipherAlgorithm;
        if (hashAlgorithm == null) {
            hashAlgorithm = HashAlgorithm.sha1;
        }
        HashAlgorithm hashAlgorithm2 = hashAlgorithm;
        if (i5 == -1) {
            i5 = 40;
        }
        int i7 = i5;
        encryptionInfo.setHeader(new CryptoAPIEncryptionHeader(cipherAlgorithm2, hashAlgorithm2, i7, i6, chainingMode));
        encryptionInfo.setVerifier(new CryptoAPIEncryptionVerifier(cipherAlgorithm2, hashAlgorithm2, i7, i6, chainingMode));
        CryptoAPIDecryptor cryptoAPIDecryptor = new CryptoAPIDecryptor();
        cryptoAPIDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(cryptoAPIDecryptor);
        CryptoAPIEncryptor cryptoAPIEncryptor = new CryptoAPIEncryptor();
        cryptoAPIEncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(cryptoAPIEncryptor);
    }
}
