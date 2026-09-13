package org.apache.poi.poifs.crypt.xor;

import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XOREncryptionInfoBuilder implements EncryptionInfoBuilder {
    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) {
        encryptionInfo.setHeader(new XOREncryptionHeader());
        encryptionInfo.setVerifier(new XOREncryptionVerifier(littleEndianInput));
        XORDecryptor xORDecryptor = new XORDecryptor();
        xORDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(xORDecryptor);
        XOREncryptor xOREncryptor = new XOREncryptor();
        xOREncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(xOREncryptor);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        encryptionInfo.setHeader(new XOREncryptionHeader());
        encryptionInfo.setVerifier(new XOREncryptionVerifier());
        XORDecryptor xORDecryptor = new XORDecryptor();
        xORDecryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(xORDecryptor);
        XOREncryptor xOREncryptor = new XOREncryptor();
        xOREncryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(xOREncryptor);
    }
}
