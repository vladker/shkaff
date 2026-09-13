package org.apache.poi.poifs.crypt.agile;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KeyData {
    private Integer blockSize;
    private CipherAlgorithm cipherAlgorithm;
    private ChainingMode cipherChaining;
    private HashAlgorithm hashAlgorithm;
    private Integer hashSize;
    private Integer keyBits;
    private Integer saltSize;
    private byte[] saltValue;

    public KeyData() {
    }

    public Integer getBlockSize() {
        return this.blockSize;
    }

    public CipherAlgorithm getCipherAlgorithm() {
        return this.cipherAlgorithm;
    }

    public ChainingMode getCipherChaining() {
        return this.cipherChaining;
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public Integer getHashSize() {
        return this.hashSize;
    }

    public Integer getKeyBits() {
        return this.keyBits;
    }

    public Integer getSaltSize() {
        return this.saltSize;
    }

    public byte[] getSaltValue() {
        return this.saltValue;
    }

    public void setBlockSize(Integer num) {
        this.blockSize = num;
    }

    public void setCipherAlgorithm(CipherAlgorithm cipherAlgorithm) {
        this.cipherAlgorithm = cipherAlgorithm;
    }

    public void setCipherChaining(ChainingMode chainingMode) {
        this.cipherChaining = chainingMode;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public void setHashSize(Integer num) {
        this.hashSize = num;
    }

    public void setKeyBits(Integer num) {
        this.keyBits = num;
    }

    public void setSaltSize(Integer num) {
        this.saltSize = num;
    }

    public void setSaltValue(byte[] bArr) {
        this.saltValue = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void write(Element element) {
        Element element2 = (Element) element.appendChild(element.getOwnerDocument().createElementNS("http://schemas.microsoft.com/office/2006/encryption", "keyData"));
        EncryptionDocument.setIntAttr(element2, "saltSize", this.saltSize);
        EncryptionDocument.setIntAttr(element2, "blockSize", this.blockSize);
        EncryptionDocument.setIntAttr(element2, "keyBits", this.keyBits);
        EncryptionDocument.setIntAttr(element2, "hashSize", this.hashSize);
        CipherAlgorithm cipherAlgorithm = this.cipherAlgorithm;
        EncryptionDocument.setAttr(element2, "cipherAlgorithm", cipherAlgorithm == null ? null : cipherAlgorithm.xmlId);
        ChainingMode chainingMode = this.cipherChaining;
        EncryptionDocument.setAttr(element2, "cipherChaining", chainingMode == null ? null : chainingMode.xmlId);
        HashAlgorithm hashAlgorithm = this.hashAlgorithm;
        EncryptionDocument.setAttr(element2, "hashAlgorithm", hashAlgorithm != null ? hashAlgorithm.ecmaString : null);
        EncryptionDocument.setBinAttr(element2, "saltValue", this.saltValue);
    }

    public KeyData(Element element) {
        Element tag = EncryptionDocument.getTag(element, "http://schemas.microsoft.com/office/2006/encryption", "keyData");
        if (tag == null) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        this.saltSize = EncryptionDocument.getIntAttr(tag, "saltSize");
        this.blockSize = EncryptionDocument.getIntAttr(tag, "blockSize");
        this.keyBits = EncryptionDocument.getIntAttr(tag, "keyBits");
        this.hashSize = EncryptionDocument.getIntAttr(tag, "hashSize");
        this.cipherAlgorithm = CipherAlgorithm.fromXmlId(tag.getAttribute("cipherAlgorithm"), this.keyBits.intValue());
        this.cipherChaining = ChainingMode.fromXmlId(tag.getAttribute("cipherChaining"));
        HashAlgorithm hashAlgorithmFromEcmaId = HashAlgorithm.fromEcmaId(tag.getAttribute("hashAlgorithm"));
        this.hashAlgorithm = hashAlgorithmFromEcmaId;
        if (this.cipherAlgorithm == null || this.cipherChaining == null || hashAlgorithmFromEcmaId == null) {
            throw new EncryptedDocumentException("Cipher algorithm, chaining mode or hash algorithm was null");
        }
        this.saltValue = EncryptionDocument.getBinAttr(tag, "saltValue");
    }
}
