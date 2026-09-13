package org.apache.poi.poifs.crypt.agile;

import A3.AbstractC0157z;
import java.util.Iterator;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionVerifier;
import org.apache.poi.poifs.crypt.HashAlgorithm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgileEncryptionVerifier extends EncryptionVerifier {
    private int blockSize;
    private int keyBits;

    public AgileEncryptionVerifier(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getKeySize() {
        return this.keyBits;
    }

    public void setBlockSize(int i5) {
        this.blockSize = i5;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public final void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        super.setCipherAlgorithm(cipherAlgorithm);
        if (cipherAlgorithm.allowedKeySize.length == 1) {
            setKeySize(cipherAlgorithm.defaultKeySize);
        }
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedKey(byte[] bArr) {
        super.setEncryptedKey(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifier(byte[] bArr) {
        super.setEncryptedVerifier(bArr);
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setEncryptedVerifierHash(byte[] bArr) {
        super.setEncryptedVerifierHash(bArr);
    }

    public void setKeySize(int i5) {
        this.keyBits = i5;
        for (int i6 : getCipherAlgorithm().allowedKeySize) {
            if (i6 == i5) {
                return;
            }
        }
        StringBuilder sbT = AbstractC0157z.t(i5, "KeySize ", " not allowed for cipher ");
        sbT.append(getCipherAlgorithm());
        throw new EncryptedDocumentException(sbT.toString());
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier
    public void setSalt(byte[] bArr) {
        if (bArr == null || bArr.length != getCipherAlgorithm().blockSize) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setSalt(bArr);
    }

    public AgileEncryptionVerifier(EncryptionDocument encryptionDocument) {
        this.keyBits = -1;
        this.blockSize = -1;
        Iterator<KeyEncryptor> it = encryptionDocument.getKeyEncryptors().iterator();
        PasswordKeyEncryptor passwordKeyEncryptor = null;
        while (it.hasNext() && (passwordKeyEncryptor = it.next().getPasswordKeyEncryptor()) == null) {
        }
        if (passwordKeyEncryptor == null) {
            throw new IllegalArgumentException("encryptedKey not set");
        }
        setCipherAlgorithm(passwordKeyEncryptor.getCipherAlgorithm());
        setKeySize(passwordKeyEncryptor.getKeyBits().intValue());
        setBlockSize(passwordKeyEncryptor.getBlockSize().intValue());
        int iIntValue = passwordKeyEncryptor.getHashSize().intValue();
        setHashAlgorithm(passwordKeyEncryptor.getHashAlgorithm());
        if (getHashAlgorithm().hashSize != iIntValue) {
            throw new EncryptedDocumentException("Unsupported hash algorithm: " + passwordKeyEncryptor.getHashAlgorithm() + " @ " + iIntValue + " bytes");
        }
        Integer spinCount = passwordKeyEncryptor.getSpinCount();
        if (spinCount != null) {
            setSpinCount(spinCount.intValue());
        }
        setEncryptedVerifier(passwordKeyEncryptor.getEncryptedVerifierHashInput());
        setSalt(passwordKeyEncryptor.getSaltValue());
        setEncryptedKey(passwordKeyEncryptor.getEncryptedKeyValue());
        setEncryptedVerifierHash(passwordKeyEncryptor.getEncryptedVerifierHashValue());
        Integer saltSize = passwordKeyEncryptor.getSaltSize();
        if (saltSize == null || saltSize.intValue() != getSalt().length) {
            throw new EncryptedDocumentException("Invalid salt size");
        }
        setChainingMode(passwordKeyEncryptor.getCipherChaining());
        if (passwordKeyEncryptor.getCipherChaining() == ChainingMode.cbc || passwordKeyEncryptor.getCipherChaining() == ChainingMode.cfb) {
            return;
        }
        throw new EncryptedDocumentException("Unsupported chaining mode - " + passwordKeyEncryptor.getCipherChaining());
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionVerifier, org.apache.poi.common.Duplicatable
    public AgileEncryptionVerifier copy() {
        return new AgileEncryptionVerifier(this);
    }

    public AgileEncryptionVerifier(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        this.keyBits = -1;
        this.blockSize = -1;
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setChainingMode(chainingMode);
        setKeySize(i5);
        setBlockSize(i6);
        setSpinCount(BZip2Constants.BASEBLOCKSIZE);
    }

    public AgileEncryptionVerifier(AgileEncryptionVerifier agileEncryptionVerifier) {
        super(agileEncryptionVerifier);
        this.keyBits = -1;
        this.blockSize = -1;
        this.keyBits = agileEncryptionVerifier.keyBits;
        this.blockSize = agileEncryptionVerifier.blockSize;
    }
}
