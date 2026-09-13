package org.apache.poi.poifs.crypt.cryptoapi;

import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CryptoAPIEncryptionVerifier extends StandardEncryptionVerifier {
    public CryptoAPIEncryptionVerifier(LittleEndianInput littleEndianInput, CryptoAPIEncryptionHeader cryptoAPIEncryptionHeader) {
        super(littleEndianInput, cryptoAPIEncryptionHeader);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifierHash(byte[] bArr) {
        super.setEncryptedVerifierHash(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setSalt(byte[] bArr) {
        super.setSalt(bArr);
    }

    public CryptoAPIEncryptionVerifier(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        super(cipherAlgorithm, hashAlgorithm, i5, i6, chainingMode);
    }

    public CryptoAPIEncryptionVerifier(CryptoAPIEncryptionVerifier cryptoAPIEncryptionVerifier) {
        super(cryptoAPIEncryptionVerifier);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier, org.apache.poi.poifs.crypt.EncryptionVerifier, org.apache.poi.common.Duplicatable
    public CryptoAPIEncryptionVerifier copy() {
        return new CryptoAPIEncryptionVerifier(this);
    }
}
