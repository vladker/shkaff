package org.apache.poi.poifs.crypt.dsig.facets;

import Q4.d;
import Q4.h;
import Q4.i;
import Q4.l;
import Q4.m;
import Q4.q;
import Q4.r;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.security.auth.x500.X500Principal;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.poifs.crypt.dsig.SignatureConfig;
import org.apache.poi.poifs.crypt.dsig.SignatureInfo;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XAdESSignatureFacet implements SignatureFacet {
    private static final Logger LOG = LogManager.getLogger((Class<?>) XAdESSignatureFacet.class);
    private static final String XADES_TYPE = "http://uri.etsi.org/01903#SignedProperties";
    private final Map<String, String> dataObjectFormatMimeTypes = new HashMap();

    private static Element importNode(Document document, XmlObject xmlObject) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            QName name = xmlCursorNewCursor.getName();
            Element elementCreateElementNS = document.createElementNS(name.getNamespaceURI(), name.getLocalPart());
            while (xmlCursorNewCursor.hasNextToken()) {
                switch (xmlCursorNewCursor.toNextToken().intValue()) {
                    case 3:
                        QName name2 = xmlCursorNewCursor.getName();
                        elementCreateElementNS = (Element) elementCreateElementNS.appendChild(document.createElementNS(name2.getNamespaceURI(), name2.getLocalPart()));
                        break;
                    case 4:
                        Element element = (Element) elementCreateElementNS.getParentNode();
                        if (element != null) {
                            elementCreateElementNS = element;
                        }
                        break;
                    case 5:
                        elementCreateElementNS.appendChild(document.createTextNode(xmlCursorNewCursor.getTextValue()));
                        break;
                    case 6:
                        QName name3 = xmlCursorNewCursor.getName();
                        elementCreateElementNS.setAttributeNS(name3.getNamespaceURI(), name3.getLocalPart(), xmlCursorNewCursor.getTextValue());
                        if (PackageRelationship.ID_ATTRIBUTE_NAME.equals(name3.getLocalPart())) {
                            elementCreateElementNS.setIdAttribute(PackageRelationship.ID_ATTRIBUTE_NAME, true);
                        }
                        break;
                    case 7:
                        QName name4 = xmlCursorNewCursor.getName();
                        elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_STRING + name4.getPrefix(), name4.getNamespaceURI());
                        break;
                    case 8:
                        elementCreateElementNS.appendChild(document.createComment(xmlCursorNewCursor.getTextValue()));
                        break;
                }
            }
            xmlCursorNewCursor.close();
            return elementCreateElementNS;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void insertXChild(XmlObject xmlObject, XmlObject xmlObject2) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            xmlCursorNewCursor.toEndToken();
            XmlCursor xmlCursorNewCursor2 = xmlObject2.newCursor();
            try {
                xmlCursorNewCursor2.toNextToken();
                xmlCursorNewCursor2.moveXml(xmlCursorNewCursor);
                xmlCursorNewCursor2.close();
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor2 != null) {
                        try {
                            xmlCursorNewCursor2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    private static /* synthetic */ void lambda$addMimeTypes$0(List list, String str, String str2) {
        h.f576O.newInstance().getClass();
        throw new ClassCastException();
    }

    public static void setCertID(d dVar, SignatureConfig signatureConfig, boolean z6, X509Certificate x509Certificate) {
        dVar.g();
        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
        if (z6) {
            issuerX500Principal.getName().replace(",", ", ");
        } else {
            issuerX500Principal.toString();
        }
        throw null;
    }

    public static void setDigestAlgAndValue(i iVar, byte[] bArr, HashAlgorithm hashAlgorithm) {
        iVar.s();
        SignatureConfig.getDigestMethodUri(hashAlgorithm);
        throw null;
    }

    public void addCertificate(SignatureInfo signatureInfo, r rVar) {
        List<X509Certificate> signingCertificateChain = signatureInfo.getSignatureConfig().getSigningCertificateChain();
        if (signingCertificateChain == null || signingCertificateChain.isEmpty()) {
            throw new RuntimeException("no signing certificate chain available");
        }
        rVar.n();
        throw null;
    }

    public void addCommitmentType(SignatureInfo signatureInfo, q qVar) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        String signatureDescription = signatureConfig.getSignatureDescription();
        String commitmentType = signatureConfig.getCommitmentType();
        if (signatureDescription == null && commitmentType == null) {
            return;
        }
        if (qVar.b()) {
            qVar.f();
        } else {
            qVar.i();
        }
        throw null;
    }

    public void addMimeType(String str, String str2) {
        this.dataObjectFormatMimeTypes.put(str, str2);
    }

    public void addMimeTypes(SignatureInfo signatureInfo, q qVar) {
        if (this.dataObjectFormatMimeTypes.isEmpty()) {
            return;
        }
        qVar.i();
        throw null;
    }

    public void addPolicy(SignatureInfo signatureInfo, r rVar) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        if (signatureConfig.getSignaturePolicyService() != null) {
            rVar.j();
            throw null;
        }
        if (signatureConfig.isXadesSignaturePolicyImplied()) {
            rVar.j();
            throw null;
        }
    }

    public void addSigningTime(SignatureInfo signatureInfo, r rVar) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Z"), Locale.ROOT);
        calendar.setTime(signatureConfig.getExecutionTime());
        calendar.clear(14);
        rVar.m();
    }

    public XMLObject addXadesObject(SignatureInfo signatureInfo, Document document, m mVar) {
        return signatureInfo.getSignatureFactory().newXMLObject(Collections.singletonList(new DOMStructure(importNode(document, mVar))), (String) null, (String) null, (String) null);
    }

    public Reference addXadesReference(SignatureInfo signatureInfo) {
        SignatureConfig signatureConfig = signatureInfo.getSignatureConfig();
        return SignatureFacetHelper.newReference(signatureInfo, "#" + signatureConfig.getXadesSignatureId(), Collections.singletonList(SignatureFacetHelper.newTransform(signatureInfo, "http://www.w3.org/TR/2001/REC-xml-c14n-20010315")), XADES_TYPE);
    }

    public void addXadesRole(SignatureInfo signatureInfo, r rVar) {
        String xadesRole = signatureInfo.getSignatureConfig().getXadesRole();
        if (xadesRole == null || xadesRole.isEmpty()) {
            return;
        }
        rVar.c();
        rVar.k();
        throw null;
    }

    public q createSignedProperties(SignatureInfo signatureInfo, m mVar) {
        mVar.h();
        signatureInfo.getSignatureConfig().getXadesSignatureId();
        throw null;
    }

    @Override // org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet
    public void preSign(SignatureInfo signatureInfo, Document document, List<Reference> list, List<XMLObject> list2) {
        LOG.atDebug().log("preSign");
        signatureInfo.getSignatureConfig();
        l.f578U.newInstance().getClass();
        throw new ClassCastException();
    }
}
