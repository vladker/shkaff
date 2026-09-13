package org.apache.poi.poifs.crypt.dsig.facets;

import java.security.Key;
import java.security.KeyException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import org.apache.jcp.xml.dsig.internal.dom.DOMKeyInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KeyInfoSignatureFacet implements SignatureFacet {
    private static final Logger LOG = LogManager.getLogger((Class<?>) KeyInfoSignatureFacet.class);

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void postSign(SignatureInfo signatureInfo, Document document) {
        LOG.atDebug().log("postSign");
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "Object");
        Node nodeItem = elementsByTagNameNS.getLength() == 0 ? null : elementsByTagNameNS.item(0);
        KeyInfoFactory keyInfoFactory = signatureInfo.getKeyInfoFactory();
        ArrayList arrayList = new ArrayList();
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        X509Certificate x509Certificate = signatureConfig.getSigningCertificateChain().get(0);
        ArrayList arrayList2 = new ArrayList();
        if (signatureConfig.isIncludeKeyValue()) {
            try {
                arrayList2.add(keyInfoFactory.newKeyValue(x509Certificate.getPublicKey()));
            } catch (KeyException e) {
                throw new RuntimeException("key exception: " + e.getMessage(), e);
            }
        }
        if (signatureConfig.isIncludeIssuerSerial()) {
            arrayList.add(keyInfoFactory.newX509IssuerSerial(x509Certificate.getIssuerX500Principal().toString(), x509Certificate.getSerialNumber()));
        }
        if (signatureConfig.isIncludeEntireCertificateChain()) {
            arrayList.addAll(signatureConfig.getSigningCertificateChain());
        } else {
            arrayList.add(x509Certificate);
        }
        if (!arrayList.isEmpty()) {
            arrayList2.add(keyInfoFactory.newX509Data(arrayList));
        }
        DOMKeyInfo dOMKeyInfoNewKeyInfo = keyInfoFactory.newKeyInfo(arrayList2);
        Key key = new Key() { // from class: org.apache.poi.poifs.crypt.dsig.facets.KeyInfoSignatureFacet.1
            private static final long serialVersionUID = 1;

            @Override // java.security.Key
            public String getAlgorithm() {
                return null;
            }

            @Override // java.security.Key
            public byte[] getEncoded() {
                return null;
            }

            @Override // java.security.Key
            public String getFormat() {
                return null;
            }
        };
        Element documentElement = document.getDocumentElement();
        final DOMSignContext dOMSignContext = nodeItem == null ? new DOMSignContext(key, documentElement) : new DOMSignContext(key, documentElement, nodeItem);
        signatureConfig.getNamespacePrefixes().forEach(new BiConsumer() { // from class: org.apache.poi.poifs.crypt.dsig.facets.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                dOMSignContext.putNamespacePrefix((String) obj, (String) obj2);
            }
        });
        dOMKeyInfoNewKeyInfo.marshal(new DOMStructure(documentElement), dOMSignContext);
        if (nodeItem != null) {
            NodeList elementsByTagNameNS2 = document.getElementsByTagNameNS(SignatureFacet.XML_DIGSIG_NS, "KeyInfo");
            if (elementsByTagNameNS2.getLength() != 1) {
                throw new RuntimeException("KeyInfo wasn't set");
            }
            nodeItem.getParentNode().insertBefore(elementsByTagNameNS2.item(0), nodeItem);
        }
    }
}
