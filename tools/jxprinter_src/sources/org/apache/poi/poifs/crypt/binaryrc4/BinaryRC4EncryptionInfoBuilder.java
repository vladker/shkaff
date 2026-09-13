package org.apache.poi.poifs.crypt.binaryrc4;

import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionInfoBuilder;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class BinaryRC4EncryptionInfoBuilder implements EncryptionInfoBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, LittleEndianInput littleEndianInput) {
        encryptionInfo.getVersionMajor();
        encryptionInfo.getVersionMinor();
        encryptionInfo.setHeader(new BinaryRC4EncryptionHeader());
        encryptionInfo.setVerifier(new BinaryRC4EncryptionVerifier(littleEndianInput));
        BinaryRC4Decryptor binaryRC4Decryptor = new BinaryRC4Decryptor();
        binaryRC4Decryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(binaryRC4Decryptor);
        BinaryRC4Encryptor binaryRC4Encryptor = new BinaryRC4Encryptor();
        binaryRC4Encryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(binaryRC4Encryptor);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionInfoBuilder
    public void initialize(EncryptionInfo encryptionInfo, CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        encryptionInfo.setHeader(new BinaryRC4EncryptionHeader());
        encryptionInfo.setVerifier(new BinaryRC4EncryptionVerifier());
        BinaryRC4Decryptor binaryRC4Decryptor = new BinaryRC4Decryptor();
        binaryRC4Decryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setDecryptor(binaryRC4Decryptor);
        BinaryRC4Encryptor binaryRC4Encryptor = new BinaryRC4Encryptor();
        binaryRC4Encryptor.setEncryptionInfo(encryptionInfo);
        encryptionInfo.setEncryptor(binaryRC4Encryptor);
    }
}
