package org.apache.poi.poifs.crypt.dsig;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.ooxml.util.XPathHelper;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SignaturePart {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SignaturePart.class);
    private static final String XMLSEC_VALIDATE_MANIFEST = "org.jcp.xml.dsig.validateManifests";
    private static final String XMLSEC_VALIDATE_SECURE = "org.apache.jcp.xml.dsig.secureValidation";
    private List<X509Certificate> certChain;
    private final SignatureInfo signatureInfo;
    private final PackagePart signaturePart;
    private X509Certificate signer;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class XPathNSContext implements NamespaceContext {
        final Map<String, String> nsMap;

        private XPathNSContext() {
            HashMap map = new HashMap();
            this.nsMap = map;
            SignaturePart.this.signatureInfo.getSignatureConfig().getNamespacePrefixes().forEach(new c(this, 1));
            map.put("dsss", SignatureFacet.MS_DIGSIG_NS);
            map.put("ds", SignatureFacet.XML_DIGSIG_NS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(String str, String str2) {
            this.nsMap.put(str2, str);
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            return this.nsMap.get(str);
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            return null;
        }
    }

    public SignaturePart(PackagePart packagePart, SignatureInfo signatureInfo) {
        this.signaturePart = packagePart;
        this.signatureInfo = signatureInfo;
    }

    private void extractConfig(Document document, XMLSignature xMLSignature) {
        final SignatureConfig signatureConfig = this.signatureInfo.getSignatureConfig();
        if (signatureConfig.isUpdateConfigOnValidate()) {
            signatureConfig.setSigningCertificateChain(this.certChain);
            signatureConfig.setSignatureMethodFromUri(xMLSignature.getSignedInfo().getSignatureMethod().getAlgorithm());
            XPath xPathNewXPath = XPathHelper.getFactory().newXPath();
            xPathNewXPath.setNamespaceContext(new XPathNSContext());
            HashMap map = new HashMap();
            final int i5 = 0;
            map.put("//mdssi:SignatureTime/mdssi:Value", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i5) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            final int i6 = 1;
            map.put("//xd:ClaimedRole", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i6) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            final int i7 = 2;
            map.put("//dsss:SignatureComments", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i7) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            final int i8 = 3;
            map.put("//xd:QualifyingProperties//xd:SignedSignatureProperties//ds:DigestMethod/@Algorithm", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i8) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            final int i9 = 4;
            map.put("//ds:CanonicalizationMethod", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i9) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            final int i10 = 5;
            map.put("//xd:CommitmentTypeId/xd:Description", new Consumer() { // from class: org.apache.poi.poifs.crypt.dsig.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    switch (i10) {
                        case 0:
                            signatureConfig.setExecutionTime((String) obj);
                            break;
                        case 1:
                            signatureConfig.setXadesRole((String) obj);
                            break;
                        case 2:
                            signatureConfig.setSignatureDescription((String) obj);
                            break;
                        case 3:
                            signatureConfig.setXadesDigestAlgo((String) obj);
                            break;
                        case 4:
                            signatureConfig.setCanonicalizationMethod((String) obj);
                            break;
                        default:
                            signatureConfig.setCommitmentType((String) obj);
                            break;
                    }
                }
            });
            for (Map.Entry entry : map.entrySet()) {
                ((Consumer) entry.getValue()).accept((String) xPathNewXPath.compile((String) entry.getKey()).evaluate(document, XPathConstants.STRING));
            }
        }
    }

    public List<X509Certificate> getCertChain() {
        return this.certChain;
    }

    public PackagePart getPackagePart() {
        return this.signaturePart;
    }

    public u5.b getSignatureDocument() throws IOException {
        InputStream inputStream = this.signaturePart.getInputStream();
        try {
            if (u5.b.f8745h0.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS) != 0) {
                throw new ClassCastException();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public X509Certificate getSigner() {
        return this.signer;
    }

    public boolean validate() {
        KeyInfoKeySelector keyInfoKeySelector = new KeyInfoKeySelector();
        XPath xPathNewXPath = XPathHelper.getFactory().newXPath();
        xPathNewXPath.setNamespaceContext(new XPathNSContext());
        try {
            InputStream inputStream = this.signaturePart.getInputStream();
            try {
                Document document = DocumentHelper.readDocument(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                NodeList nodeList = (NodeList) xPathNewXPath.compile("//*[@Id]").evaluate(document, XPathConstants.NODESET);
                int length = nodeList.getLength();
                for (int i5 = 0; i5 < length; i5++) {
                    ((Element) nodeList.item(i5)).setIdAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, true);
                }
                DOMValidateContext dOMValidateContext = new DOMValidateContext(keyInfoKeySelector, document);
                dOMValidateContext.setProperty(XMLSEC_VALIDATE_MANIFEST, Boolean.TRUE);
                dOMValidateContext.setProperty(XMLSEC_VALIDATE_SECURE, Boolean.valueOf(this.signatureInfo.getSignatureConfig().isSecureValidation()));
                dOMValidateContext.setURIDereferencer(this.signatureInfo.getUriDereferencer());
                XMLSignature xMLSignatureUnmarshalXMLSignature = this.signatureInfo.getSignatureFactory().unmarshalXMLSignature(dOMValidateContext);
                boolean zValidate = xMLSignatureUnmarshalXMLSignature.validate(dOMValidateContext);
                if (zValidate) {
                    this.signer = keyInfoKeySelector.getSigner();
                    this.certChain = keyInfoKeySelector.getCertChain();
                    extractConfig(document, xMLSignatureUnmarshalXMLSignature);
                }
                return zValidate;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (MarshalException e) {
            LOG.atError().withThrowable(e).log("error in unmarshalling the signature");
            throw new EncryptedDocumentException("error in unmarshalling the signature", e);
        } catch (SAXException e6) {
            LOG.atError().withThrowable(e6).log("error in parsing document");
            throw new EncryptedDocumentException("error in parsing document", e6);
        } catch (XMLSignatureException e7) {
            LOG.atError().withThrowable(e7).log("error in validating the signature");
            throw new EncryptedDocumentException("error in validating the signature", e7);
        } catch (IOException e8) {
            LOG.atError().withThrowable(e8).log("error in reading document");
            throw new EncryptedDocumentException("error in reading document", e8);
        } catch (XPathExpressionException e9) {
            LOG.atError().withThrowable(e9).log("error in searching document with xpath expression");
            throw new EncryptedDocumentException("error in searching document with xpath expression", e9);
        }
    }
}
