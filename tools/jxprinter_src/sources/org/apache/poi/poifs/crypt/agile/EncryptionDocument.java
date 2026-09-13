package org.apache.poi.poifs.crypt.agile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EncryptionDocument {
    static final String ENC_NS = "http://schemas.microsoft.com/office/2006/encryption";
    private DataIntegrity dataIntegrity;
    private KeyData keyData;
    private final List<KeyEncryptor> keyEncryptors = new ArrayList();

    public static byte[] getBinAttr(Element element, String str) {
        String attribute = element.getAttribute(str);
        if (attribute.isEmpty()) {
            return null;
        }
        return Base64.getDecoder().decode(attribute);
    }

    public static Integer getIntAttr(Element element, String str) {
        String attribute = element.getAttribute(str);
        if (attribute.isEmpty()) {
            return null;
        }
        return Integer.valueOf(attribute);
    }

    public static Element getTag(Element element, String str, String str2) {
        if (element == null) {
            return null;
        }
        NodeList elementsByTagNameNS = element.getElementsByTagNameNS(str, str2);
        if (elementsByTagNameNS.getLength() > 0) {
            return (Element) elementsByTagNameNS.item(0);
        }
        return null;
    }

    public static void setAttr(Element element, String str, String str2) {
        if (str2 != null) {
            element.setAttribute(str, str2);
        }
    }

    public static void setBinAttr(Element element, String str, byte[] bArr) {
        if (bArr != null) {
            setAttr(element, str, Base64.getEncoder().encodeToString(bArr));
        }
    }

    public static void setIntAttr(Element element, String str, Integer num) {
        setAttr(element, str, num == null ? null : num.toString());
    }

    public DataIntegrity getDataIntegrity() {
        return this.dataIntegrity;
    }

    public KeyData getKeyData() {
        return this.keyData;
    }

    public List<KeyEncryptor> getKeyEncryptors() {
        return this.keyEncryptors;
    }

    public void parse(Document document) {
        Element documentElement = document.getDocumentElement();
        if (!ENC_NS.equals(documentElement.getNamespaceURI()) || !"encryption".equals(documentElement.getLocalName())) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        this.keyData = new KeyData(documentElement);
        this.dataIntegrity = new DataIntegrity(documentElement);
        Element tag = getTag(documentElement, ENC_NS, "keyEncryptors");
        if (tag == null) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        NodeList elementsByTagNameNS = tag.getElementsByTagNameNS(ENC_NS, "keyEncryptor");
        for (int i5 = 0; i5 < elementsByTagNameNS.getLength(); i5++) {
            this.keyEncryptors.add(new KeyEncryptor((Element) elementsByTagNameNS.item(i5)));
        }
    }

    public void setDataIntegrity(DataIntegrity dataIntegrity) {
        this.dataIntegrity = dataIntegrity;
    }

    public void setKeyData(KeyData keyData) {
        this.keyData = keyData;
    }

    public void write(Document document) {
        document.setXmlStandalone(true);
        Element element = (Element) document.appendChild(document.createElementNS(ENC_NS, "encryption"));
        KeyData keyData = this.keyData;
        if (keyData != null) {
            keyData.write(element);
        }
        DataIntegrity dataIntegrity = this.dataIntegrity;
        if (dataIntegrity != null) {
            dataIntegrity.write(element);
        }
        Element element2 = (Element) element.appendChild(document.createElementNS(ENC_NS, "keyEncryptors"));
        boolean z6 = false;
        boolean z7 = false;
        for (KeyEncryptor keyEncryptor : this.keyEncryptors) {
            keyEncryptor.write(element2);
            z6 |= keyEncryptor.getPasswordKeyEncryptor() != null;
            z7 |= keyEncryptor.getCertificateKeyEncryptor() != null;
        }
        if (z6) {
            element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:p", "http://schemas.microsoft.com/office/2006/keyEncryptor/password");
        }
        if (z7) {
            element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:c", "http://schemas.microsoft.com/office/2006/keyEncryptor/certificate");
        }
    }
}
