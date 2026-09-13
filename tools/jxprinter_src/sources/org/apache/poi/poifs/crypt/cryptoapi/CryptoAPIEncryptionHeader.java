package org.apache.poi.poifs.crypt.cryptoapi;

import A3.AbstractC0157z;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.CipherProvider;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CryptoAPIEncryptionHeader extends StandardEncryptionHeader {
    public CryptoAPIEncryptionHeader(LittleEndianInput littleEndianInput) {
        super(littleEndianInput);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public void setKeySize(int i5) {
        for (int i6 : getCipherAlgorithm().allowedKeySize) {
            if (i6 == i5) {
                super.setKeySize(i5);
                if (i5 > 40) {
                    setCspName("Microsoft Enhanced Cryptographic Provider v1.0");
                    return;
                } else {
                    setCspName(CipherProvider.rc4.cipherProviderName);
                    return;
                }
            }
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "invalid keysize ", " for cipher algorithm ");
        sbT.append(getCipherAlgorithm());
        throw new EncryptedDocumentException(sbT.toString());
    }

    public CryptoAPIEncryptionHeader(CryptoAPIEncryptionHeader cryptoAPIEncryptionHeader) {
        super(cryptoAPIEncryptionHeader);
    }

    public CryptoAPIEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        super(cipherAlgorithm, hashAlgorithm, i5, i6, chainingMode);
    }

    @Override // org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader, org.apache.poi.poifs.crypt.EncryptionHeader, org.apache.poi.common.Duplicatable
    public CryptoAPIEncryptionHeader copy() {
        return new CryptoAPIEncryptionHeader(this);
    }
}
