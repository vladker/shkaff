package org.apache.poi.poifs.crypt.agile;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.ChainingMode;
import org.apache.poi.poifs.crypt.CipherAlgorithm;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PasswordKeyEncryptor {
    private Integer blockSize;
    private CipherAlgorithm cipherAlgorithm;
    private ChainingMode cipherChaining;
    private byte[] encryptedKeyValue;
    private byte[] encryptedVerifierHashInput;
    private byte[] encryptedVerifierHashValue;
    private HashAlgorithm hashAlgorithm;
    private Integer hashSize;
    private Integer keyBits;
    private Integer saltSize;
    private byte[] saltValue;
    private Integer spinCount;

    public PasswordKeyEncryptor() {
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

    public byte[] getEncryptedKeyValue() {
        return this.encryptedKeyValue;
    }

    public byte[] getEncryptedVerifierHashInput() {
        return this.encryptedVerifierHashInput;
    }

    public byte[] getEncryptedVerifierHashValue() {
        return this.encryptedVerifierHashValue;
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

    public Integer getSpinCount() {
        return this.spinCount;
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

    public void setEncryptedKeyValue(byte[] bArr) {
        this.encryptedKeyValue = bArr;
    }

    public void setEncryptedVerifierHashInput(byte[] bArr) {
        this.encryptedVerifierHashInput = bArr;
    }

    public void setEncryptedVerifierHashValue(byte[] bArr) {
        this.encryptedVerifierHashValue = bArr;
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
        this.saltValue = bArr;
    }

    public void setSpinCount(Integer num) {
        this.spinCount = num;
    }

    public void write(Element element) {
        Document ownerDocument = element.getOwnerDocument();
        Element element2 = (Element) element.appendChild(ownerDocument.createElementNS("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptor"));
        element2.setAttribute("uri", "http://schemas.microsoft.com/office/2006/keyEncryptor/password");
        Element element3 = (Element) element2.appendChild(ownerDocument.createElementNS("http://schemas.microsoft.com/office/2006/keyEncryptor/password", "p:encryptedKey"));
        EncryptionDocument.setIntAttr(element3, "saltSize", this.saltSize);
        EncryptionDocument.setIntAttr(element3, "blockSize", this.blockSize);
        EncryptionDocument.setIntAttr(element3, "keyBits", this.keyBits);
        EncryptionDocument.setIntAttr(element3, "hashSize", this.hashSize);
        CipherAlgorithm cipherAlgorithm = this.cipherAlgorithm;
        EncryptionDocument.setAttr(element3, "cipherAlgorithm", cipherAlgorithm == null ? null : cipherAlgorithm.xmlId);
        ChainingMode chainingMode = this.cipherChaining;
        EncryptionDocument.setAttr(element3, "cipherChaining", chainingMode == null ? null : chainingMode.xmlId);
        HashAlgorithm hashAlgorithm = this.hashAlgorithm;
        EncryptionDocument.setAttr(element3, "hashAlgorithm", hashAlgorithm != null ? hashAlgorithm.ecmaString : null);
        EncryptionDocument.setBinAttr(element3, "saltValue", this.saltValue);
        EncryptionDocument.setIntAttr(element3, "spinCount", this.spinCount);
        EncryptionDocument.setBinAttr(element3, "encryptedVerifierHashInput", this.encryptedVerifierHashInput);
        EncryptionDocument.setBinAttr(element3, "encryptedVerifierHashValue", this.encryptedVerifierHashValue);
        EncryptionDocument.setBinAttr(element3, "encryptedKeyValue", this.encryptedKeyValue);
    }

    public PasswordKeyEncryptor(Element element) {
        if (element == null) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        this.saltSize = EncryptionDocument.getIntAttr(element, "saltSize");
        this.blockSize = EncryptionDocument.getIntAttr(element, "blockSize");
        this.keyBits = EncryptionDocument.getIntAttr(element, "keyBits");
        this.hashSize = EncryptionDocument.getIntAttr(element, "hashSize");
        this.cipherAlgorithm = CipherAlgorithm.fromXmlId(element.getAttribute("cipherAlgorithm"), this.keyBits.intValue());
        this.cipherChaining = ChainingMode.fromXmlId(element.getAttribute("cipherChaining"));
        this.hashAlgorithm = HashAlgorithm.fromEcmaId(element.getAttribute("hashAlgorithm"));
        this.saltValue = EncryptionDocument.getBinAttr(element, "saltValue");
        this.spinCount = EncryptionDocument.getIntAttr(element, "spinCount");
        this.encryptedVerifierHashInput = EncryptionDocument.getBinAttr(element, "encryptedVerifierHashInput");
        this.encryptedVerifierHashValue = EncryptionDocument.getBinAttr(element, "encryptedVerifierHashValue");
        this.encryptedKeyValue = EncryptionDocument.getBinAttr(element, "encryptedKeyValue");
    }
}
