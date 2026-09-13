package org.apache.poi.poifs.crypt.agile;

import androidx.webkit.ProxyConfig;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KeyEncryptor {
    static final String CERT_NS = "http://schemas.microsoft.com/office/2006/keyEncryptor/certificate";
    static final String PASS_NS = "http://schemas.microsoft.com/office/2006/keyEncryptor/password";
    private CertificateKeyEncryptor certificateKeyEncryptor;
    private PasswordKeyEncryptor passwordKeyEncryptor;

    public KeyEncryptor() {
    }

    public CertificateKeyEncryptor getCertificateKeyEncryptor() {
        return this.certificateKeyEncryptor;
    }

    public PasswordKeyEncryptor getPasswordKeyEncryptor() {
        return this.passwordKeyEncryptor;
    }

    public void setCertificateKeyEncryptor(CertificateKeyEncryptor certificateKeyEncryptor) {
        this.certificateKeyEncryptor = certificateKeyEncryptor;
    }

    public void setPasswordKeyEncryptor(PasswordKeyEncryptor passwordKeyEncryptor) {
        this.passwordKeyEncryptor = passwordKeyEncryptor;
    }

    public void write(Element element) {
        PasswordKeyEncryptor passwordKeyEncryptor = this.passwordKeyEncryptor;
        if (passwordKeyEncryptor != null) {
            passwordKeyEncryptor.write(element);
            return;
        }
        CertificateKeyEncryptor certificateKeyEncryptor = this.certificateKeyEncryptor;
        if (certificateKeyEncryptor != null) {
            certificateKeyEncryptor.write(element);
        }
    }

    public KeyEncryptor(Element element) {
        if (element == null) {
            throw new EncryptedDocumentException("Unable to parse encryption descriptor");
        }
        NodeList elementsByTagNameNS = element.getElementsByTagNameNS(ProxyConfig.MATCH_ALL_SCHEMES, "encryptedKey");
        for (int i5 = 0; i5 < elementsByTagNameNS.getLength(); i5++) {
            Element element2 = (Element) elementsByTagNameNS.item(i5);
            String namespaceURI = element2.getNamespaceURI();
            if (PASS_NS.equals(namespaceURI)) {
                this.passwordKeyEncryptor = new PasswordKeyEncryptor(element2);
            } else if (CERT_NS.equals(namespaceURI)) {
                this.certificateKeyEncryptor = new CertificateKeyEncryptor(element2);
            }
        }
    }
}
