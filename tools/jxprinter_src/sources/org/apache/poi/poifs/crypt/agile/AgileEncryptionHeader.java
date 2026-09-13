package org.apache.poi.poifs.crypt.agile;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.EncryptionHeader;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AgileEncryptionHeader extends EncryptionHeader {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public AgileEncryptionHeader(String str) {
        this(AgileEncryptionInfoBuilder.parseDescriptor(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getGenericProperties$0() {
        return super.getGenericProperties();
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final int i5 = 0;
        Supplier supplier = new Supplier(this) { // from class: org.apache.poi.poifs.crypt.agile.a
            public final /* synthetic */ AgileEncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getEncryptedHmacKey();
                    default:
                        return this.b.getEncryptedHmacValue();
                }
            }
        };
        final int i6 = 1;
        Supplier supplier2 = new Supplier(this) { // from class: org.apache.poi.poifs.crypt.agile.a
            public final /* synthetic */ AgileEncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getEncryptedHmacKey();
                    default:
                        return this.b.getEncryptedHmacValue();
                }
            }
        };
        final int i7 = 2;
        return GenericRecordUtil.getGenericProperties("base", supplier, "encryptedHmacKey", supplier2, "encryptedHmacValue", new Supplier(this) { // from class: org.apache.poi.poifs.crypt.agile.a
            public final /* synthetic */ AgileEncryptionHeader b;

            {
                this.b = this;
            }

            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return this.b.lambda$getGenericProperties$0();
                    case 1:
                        return this.b.getEncryptedHmacKey();
                    default:
                        return this.b.getEncryptedHmacValue();
                }
            }
        });
    }

    public void setEncryptedHmacKey(byte[] bArr) {
        this.encryptedHmacKey = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setEncryptedHmacValue(byte[] bArr) {
        this.encryptedHmacValue = bArr == null ? null : (byte[]) bArr.clone();
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader
    public void setKeySalt(byte[] bArr) {
        if (bArr == null || bArr.length != getBlockSize()) {
            throw new EncryptedDocumentException("invalid verifier salt");
        }
        super.setKeySalt(bArr);
    }

    public AgileEncryptionHeader(AgileEncryptionHeader agileEncryptionHeader) {
        super(agileEncryptionHeader);
        byte[] bArr = agileEncryptionHeader.encryptedHmacKey;
        this.encryptedHmacKey = bArr == null ? null : (byte[]) bArr.clone();
        byte[] bArr2 = agileEncryptionHeader.encryptedHmacValue;
        this.encryptedHmacValue = bArr2 != null ? (byte[]) bArr2.clone() : null;
    }

    @Override // org.apache.poi.poifs.crypt.EncryptionHeader, org.apache.poi.common.Duplicatable
    public AgileEncryptionHeader copy() {
        return new AgileEncryptionHeader(this);
    }

    public AgileEncryptionHeader(EncryptionDocument encryptionDocument) {
        try {
            KeyData keyData = encryptionDocument.getKeyData();
            if (keyData != null) {
                int iIntValue = keyData.getKeyBits().intValue();
                CipherAlgorithm cipherAlgorithm = keyData.getCipherAlgorithm();
                setCipherAlgorithm(cipherAlgorithm);
                setCipherProvider(cipherAlgorithm.provider);
                setKeySize(iIntValue);
                setFlags(0);
                setSizeExtra(0);
                setCspName(null);
                setBlockSize(keyData.getBlockSize().intValue());
                setChainingMode(keyData.getCipherChaining());
                if (getChainingMode() != ChainingMode.cbc && getChainingMode() != ChainingMode.cfb) {
                    throw new EncryptedDocumentException("Unsupported chaining mode - " + keyData.getCipherChaining());
                }
                int iIntValue2 = keyData.getHashSize().intValue();
                setHashAlgorithm(keyData.getHashAlgorithm());
                if (getHashAlgorithm().hashSize == iIntValue2) {
                    int iIntValue3 = keyData.getSaltSize().intValue();
                    setKeySalt(keyData.getSaltValue());
                    if (getKeySalt().length == iIntValue3) {
                        DataIntegrity dataIntegrity = encryptionDocument.getDataIntegrity();
                        setEncryptedHmacKey(dataIntegrity.getEncryptedHmacKey());
                        setEncryptedHmacValue(dataIntegrity.getEncryptedHmacValue());
                        return;
                    }
                    throw new EncryptedDocumentException("Invalid salt length");
                }
                throw new EncryptedDocumentException("Unsupported hash algorithm: " + keyData.getHashAlgorithm() + " @ " + iIntValue2 + " bytes");
            }
            throw new NullPointerException("keyData not set");
        } catch (Exception unused) {
            throw new EncryptedDocumentException("Unable to parse keyData");
        }
    }

    public AgileEncryptionHeader(CipherAlgorithm cipherAlgorithm, HashAlgorithm hashAlgorithm, int i5, int i6, ChainingMode chainingMode) {
        setCipherAlgorithm(cipherAlgorithm);
        setHashAlgorithm(hashAlgorithm);
        setKeySize(i5);
        setBlockSize(i6);
        setChainingMode(chainingMode);
    }
}
