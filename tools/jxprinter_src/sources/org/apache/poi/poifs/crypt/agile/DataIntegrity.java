package org.apache.poi.poifs.crypt.agile;

import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DataIntegrity {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public DataIntegrity() {
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }

    public void setEncryptedHmacKey(byte[] bArr) {
        this.encryptedHmacKey = bArr;
    }

    public void setEncryptedHmacValue(byte[] bArr) {
        this.encryptedHmacValue = bArr;
    }

    public void write(Element element) {
        Element element2 = (Element) element.appendChild(element.getOwnerDocument().createElementNS("http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity"));
        EncryptionDocument.setBinAttr(element2, "encryptedHmacKey", this.encryptedHmacKey);
        EncryptionDocument.setBinAttr(element2, "encryptedHmacValue", this.encryptedHmacValue);
    }

    public DataIntegrity(Element element) {
        Element tag = EncryptionDocument.getTag(element, "http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity");
        if (tag == null) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        this.encryptedHmacKey = EncryptionDocument.getBinAttr(tag, "encryptedHmacKey");
        this.encryptedHmacValue = EncryptionDocument.getBinAttr(tag, "encryptedHmacValue");
    }
}
